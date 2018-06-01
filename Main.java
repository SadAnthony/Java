import one.packet.trainning.DraftClass;

public class Main {

    public static void main(String[] args) {

        DraftClass name = new DraftClass();
        name.setNumber(123);
        name.setStr("Xuy");

        System.out.println(name.getNumber() + name.getStr());

        name.function();
    }

}