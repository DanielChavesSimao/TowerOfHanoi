import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class TOHFunctions {
    public static List<TOHActions> getActions(TOHState state) {
        List<TOHActions> actions = new ArrayList<>();

        Stack<Integer> pino1 = state.getBase().get(0);
        Stack<Integer> pino2 = state.getBase().get(1);
        Stack<Integer> pino3 = state.getBase().get(2);

        if (!pino1.empty()) {
            if (!pino2.empty()) {
                if (pino1.peek() < pino2.peek()) {
                    actions.add(new TOHActions(TOHActions.MOVE_1_2));
                } else {
                    actions.add(new TOHActions(TOHActions.MOVE_2_1));
                }        
            } else {
                actions.add(new TOHActions(TOHActions.MOVE_1_2));
            }

            if (!pino3.empty()) {
                if (pino1.peek() < pino3.peek()) {
                    actions.add(new TOHActions(TOHActions.MOVE_1_3));
                } else {
                    actions.add(new TOHActions(TOHActions.MOVE_3_1));
                }
            } else {
                actions.add(new TOHActions(TOHActions.MOVE_1_3));
            }
        } else {
            if (!pino2.empty()) {
                actions.add(new TOHActions(TOHActions.MOVE_2_1));
            }
            if (!pino3.empty()) {
                actions.add(new TOHActions(TOHActions.MOVE_3_1));
            }
        }

        if (!pino2.empty()) {
            if (!pino3.empty()) {
                if (pino2.peek() < pino3.peek()) {
                    actions.add(new TOHActions(TOHActions.MOVE_2_3));
                } else {
                    actions.add(new TOHActions(TOHActions.MOVE_3_2));
                }
            } else {
                actions.add(new TOHActions(TOHActions.MOVE_2_3));
            }
        } else {
            if (!pino1.empty()) {
                actions.add(new TOHActions(TOHActions.MOVE_1_2));
            }
            if (!pino3.empty()) {
                actions.add(new TOHActions(TOHActions.MOVE_3_2));
            }
        }
        
        return actions;
    }

    public static TOHState getResult(TOHState state, TOHActions action) {
        TOHState child = state.clone();

        if (Objects.equals(action.getName(), TOHActions.MOVE_1_2)) {
            child.getBase().get(1).push(child.getBase().get(0).pop());
        }
        if (Objects.equals(action.getName(), TOHActions.MOVE_2_1)) {
            child.getBase().get(0).push(child.getBase().get(1).pop());
        }
        if (Objects.equals(action.getName(), TOHActions.MOVE_1_3)) {
            child.getBase().get(2).push(child.getBase().get(0).pop());
        }
        if (Objects.equals(action.getName(), TOHActions.MOVE_3_1)) {
            child.getBase().get(0).push(child.getBase().get(2).pop());
        }
        if (Objects.equals(action.getName(), TOHActions.MOVE_2_3)) {
            child.getBase().get(2).push(child.getBase().get(1).pop());
        }
        if (Objects.equals(action.getName(), TOHActions.MOVE_3_2)) {
            child.getBase().get(1).push(child.getBase().get(2).pop());
        }

        return child;
    }

    public static boolean testGoal(TOHState state) {
        return new TOHGoalTest(state.getNumDisks()).test(state);
    }

}
