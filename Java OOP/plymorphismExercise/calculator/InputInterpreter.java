package plymorphismExercise.calculator;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if(operation.equals("/")){
            return new DivisionOperation();
        } else if(operation.equals("ms")){
            return new MsOperation(engine.getMemory());
        } else if(operation.equals("mr")){
            return new MrOperation(engine.getMemory());
        }

        return null;
    }
}
