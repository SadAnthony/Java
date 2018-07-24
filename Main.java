import ru.skillbench.tasks.javaapi.collections.StringFilterImpl;
import ru.skillbench.tasks.text.WordCounterImpl;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        StringFilterImpl sf = new StringFilterImpl();
        sf.add("Hello");
        sf.add("World");
        sf.add("Wonder");
        sf.add("+9.45");
        sf.add("-1.y2");
        sf.add("-1.56");
        sf.add("-10.00");
        sf.add(null);
        for (Iterator<String> i = sf.getStringsByNumberFormat("-1.##"); i.hasNext();) {
            System.out.println(i.next());
        }
        for (Iterator<String> i = sf.getStringsByPattern("-1.*"); i.hasNext();) {
            System.out.println(i.next());
        }
        /*WordCounterImpl wc = new WordCounterImpl();
        wc.setText("  A Combined Work is a work produced by combining or linking an\n" +
                "Application with the Library.\n" + "The particular version 150 БЕТОНЁПТА of the Library\n" +
                "with which the Combined Work was made is also called the Linked\n" +
                "END");
        System.out.println(wc.getWordCounts());
        System.out.println(wc.sortHashMapByValues(wc.getWordCounts()));
        System.out.println(wc.getWordCountsSorted());*/
    }
}