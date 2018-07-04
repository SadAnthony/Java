import ru.skillbench.tasks.basics.control.ControlFlowStatements2Impl;

public class Main {

    public static void main(String[] args) {
        ControlFlowStatements2Impl object1 = new ControlFlowStatements2Impl();
        System.out.println(object1.getFunctionValue(1));
        System.out.println(object1.decodeMark(5));
        System.out.println(object1.initArray()[4][3]);
        System.out.println(object1.getMaxValue(object1.initArray()));
        System.out.println(object1.calculateSportsman(10).toString());
    }
}