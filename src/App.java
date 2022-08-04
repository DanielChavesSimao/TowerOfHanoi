import java.util.List;
import java.util.Optional;

import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;

public class App {
    public static void main(String[] args) throws Exception {
        TOHState initialState = new TOHState(7);
        System.out.println(initialState);
        Problem<TOHState, TOHActions> problem = new GeneralProblem<>(initialState, TOHFunctions::getActions,
            TOHFunctions::getResult, TOHFunctions::testGoal);
        SearchForActions<TOHState, TOHActions> search = new BreadthFirstSearch<>();
        // SearchForActions<TOHState, TOHActions> search = new DepthFirstSearch<>();
        Optional<List<TOHActions>> actions = search.findActions(problem);
        
        if (actions.isPresent()) {
            System.out.println(actions.get());
        } else {
            System.out.println("Zero ações encontradas.");
        }
    }
}
