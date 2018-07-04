import ru.skillbench.tasks.basics.control.ControlFlowStatements3Impl;

public class Main {

    public static void main(String[] args) {
        ControlFlowStatements3Impl object1 = new ControlFlowStatements3Impl();
        System.out.println(object1.getFunctionValue(1));
        System.out.println(object1.decodeSeason(5));
        System.out.println(object1.initArray()[4][3]);
        System.out.println(object1.getMaxProductIndex(object1.initArray()));
        System.out.println(object1.calculateLineSegment(10, 3));
    }
}