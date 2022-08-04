import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import aima.core.util.JavaRandomizer;

public class TOHState implements Cloneable {
    public static final int MIN_DISKS = 3;
    public static final int MAX_DISKS = 7;

    private int numDisks = 3;
    private List<Stack<Integer>> base = new ArrayList<Stack<Integer>>(3);

    public TOHState(int numDisks) {
        this.numDisks = numDisks;
        initializeBase();
    }

    public TOHState() {
        initializeBase();
    }

    public TOHState(boolean random) {
        if (random)
            initializeBaseRandomly();
    }

    public TOHState(int numDisks, boolean random) {
        this.numDisks = numDisks;
        if (random)
            initializeBaseRandomly();
    }

    

    public int getNumDisks() {
        return numDisks;
    }

    @Override
	public TOHState clone() {
		TOHState copy = null;
		try {
			copy = (TOHState) super.clone();
            copy.base = new ArrayList<Stack<Integer>>(3);
            Stack<Integer> pino1 = new Stack<>();
            Stack<Integer> pino2 = new Stack<>();
            Stack<Integer> pino3 = new Stack<>();

            copy.base.add(pino1);
            copy.base.add(pino2);
            copy.base.add(pino3);
            copy.base.set(0, (Stack<Integer>) base.get(0).clone());
            copy.base.set(1, (Stack<Integer>) base.get(1).clone());
            copy.base.set(2, (Stack<Integer>) base.get(2).clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(); // should never happen...
		}
		return copy;
	}

    public List<Stack<Integer>> getBase() {
        return base;
    }

    public void setBase(List<Stack<Integer>> base) {
        this.base = base;
    }

    private void initializeBase() {
        Stack<Integer> pino1 = new Stack<>();
        Stack<Integer> pino2 = new Stack<>();
        Stack<Integer> pino3 = new Stack<>();

        base.add(pino1);
        base.add(pino2);
        base.add(pino3);

        for (int i = numDisks; i > 0; i--) {
            base.get(0).push(i);
        }
    }

    private void initializeBaseRandomly() {
        Stack<Integer> stack;
        JavaRandomizer randomizer = new JavaRandomizer();
        int random;
        for (int i = numDisks; i > 0; i--) {
            random = (int) randomizer.nextDouble() % 3;
            stack = base.get(random);
            while (stack.peek() != null && stack.peek() < i) {
                random = (int) randomizer.nextDouble() % 3;
                stack = base.get(random);
            }
            stack.push(i);
        }
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			builder.append(base.get(i).toString());
		}
		return builder.toString();
	}

    @Override
	public int hashCode() {
		return toString().hashCode();
	}
    

    @Override
    public boolean equals(Object e) {
        return (e.hashCode() == this.hashCode());
    }
}
