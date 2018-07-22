import ru.skillbench.tasks.javaapi.collections.TreeNodeImpl;

public class Main {

    public static void main(String[] args) {
        TreeNodeImpl t1 = new TreeNodeImpl();
        t1.setData("Root");

        TreeNodeImpl t2 = new TreeNodeImpl();
        t2.setData("First_Child");
        t1.addChild(t2);

        TreeNodeImpl t3 = new TreeNodeImpl();
        t3.setData("Second_Child");
        t2.addChild(t3);

        System.out.println(t3.getTreePath());
        System.out.println(t2.getRoot().getData().toString());
    }
}