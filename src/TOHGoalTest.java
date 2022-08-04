import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import aima.core.search.framework.problem.GoalTest;

public class TOHGoalTest implements GoalTest<TOHState>{

    private List<Stack<Integer>> pinos = new ArrayList<>(3);
    private int numDisks;

    public TOHGoalTest(int numDisks) {
        Stack<Integer> pino1 = new Stack<>();
        Stack<Integer> pino2 = new Stack<>();
        Stack<Integer> pino3 = new Stack<>();

        pinos.add(pino1);
        pinos.add(pino2);
        pinos.add(pino3);

        this.numDisks = numDisks;
        for (int i = numDisks; i > 0; i--) {
            pinos.get(2).push(i);
        }
    }

    public TOHGoalTest(int numDisks, List<Stack<Integer>> pinos) {
        this.pinos = pinos;
        this.numDisks = numDisks;
    }

    public boolean test(TOHState state) {
        try {
            if (state.getNumDisks() != numDisks){
                throw new Exception("Número de discos do goal test diferente do definido na classe de estados.");
            }

            return (state.getBase().equals(pinos));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return false;
    }

    public List<Stack<Integer>> getObjective() {
        return pinos;
    }
}
