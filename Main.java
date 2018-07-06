import ru.skillbench.tasks.basics.math.ArrayVectorImpl;

public class Main {

    public static void main(String[] args) {
        ArrayVectorImpl vector = new ArrayVectorImpl();
        double[] arr = {1, 8.3, -4.7, 6, 0, 5, 2, 7.5};
        vector.set(arr);
        System.out.println("Second element: " + vector.get(1));
        vector.set(1, 2.3);
        System.out.println("Size of vector: " + vector.getSize());
        System.out.println("Max elements: " + vector.getMax());
        System.out.println("Min elements: " + vector.getMin());
        vector.inString();
        System.out.println("--------------------");
        ArrayVectorImpl vector2 = new ArrayVectorImpl();
        vector2.set(5.2, 6.0, 9.5);
        vector2.sum(vector);
        vector2.inString();
        System.out.println("Scalar multiplication: " + vector.scalarMult(vector));
        System.out.println("Norm: " + vector.getNorm());
    }
}