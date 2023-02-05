public class Command_State {

    public Command_State(state state_type) {
        this.state_type = state_type;
    }

    private enum state {
        QUIT,
        NEXT
    }

    private state state_type;


}
