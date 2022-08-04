import aima.core.agent.impl.DynamicAction;

public class TOHActions extends DynamicAction{

    public static final String MOVE_1_2 = "1->2";
    public static final String MOVE_1_3 = "1->3";
    public static final String MOVE_2_1 = "2->1";
    public static final String MOVE_2_3 = "2->3";
    public static final String MOVE_3_1 = "3->1";
    public static final String MOVE_3_2 = "3->2";

    public TOHActions(String type) {
        super(type);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
