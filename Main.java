import ru.skillbench.tasks.basics.math.ComplexNumberImpl;

public class Main {

    public static void main(String[] args) {
        ComplexNumberImpl z1 = new ComplexNumberImpl(-1.3, 8.4);
        ComplexNumberImpl z2 = new ComplexNumberImpl(2.3);
        ComplexNumberImpl z3 = new ComplexNumberImpl(8.0, -5.6);
        System.out.println("------------------\nFucking set method");
        z1.set("10-9.3i");
        System.out.println("10-9.3i:  " + z1);
        z2.set("-4+2.5i");
        System.out.println("-4+2.5i:  " + z2);
        z3.set("5.0");
        System.out.println("5.0:  " + z3);
        z3.set("5.0i");
        System.out.println("5.0i:  " + z3);
        z3.set("-5.0i");
        System.out.println("-5.0i:  " + z3);
        z3.set("-5.0");
        System.out.println("-5.0:  " + z3);
    }
}