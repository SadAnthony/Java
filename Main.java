import ru.skillbench.tasks.basics.math.ComplexNumberImpl;

public class Main {

    public static void main(String[] args) {
        ComplexNumberImpl z1 = new ComplexNumberImpl(-1.3, 8.4);
        ComplexNumberImpl z2 = new ComplexNumberImpl(2.3);
        ComplexNumberImpl z3 = new ComplexNumberImpl(8.0, -5.6);
        ComplexNumberImpl z4 = new ComplexNumberImpl(-5.9, -10.1);
        ComplexNumberImpl z5 = new ComplexNumberImpl(0, -10.5);
        ComplexNumberImpl z6 = new ComplexNumberImpl();
        ComplexNumberImpl z7 = new ComplexNumberImpl();
        System.out.println("------------------\nOperations");
        System.out.println(z3.add(z1).toString());
        System.out.println(z4.multiply(z5).toString());
        System.out.println(z3.multiply(z3).toString());
        System.out.println("------------------\nFucking set method");
        z1.set("10-9.3i");
        System.out.println("10-9.3i:  " + z1);
        z7.set("-4+2.5i");
        System.out.println("-4+2.5i:  " + z7);
        z7.set("5.0");
        System.out.println("5.0:  " + z7);
    }
}