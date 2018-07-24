import ru.skillbench.tasks.javaapi.collections.StringFilterImpl;
import ru.skillbench.tasks.text.WordCounterImpl;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        /*StringFilterImpl sf = new StringFilterImpl();
        sf.add("Hello");
        sf.add("World");
        sf.add("Wonder");
        sf.add("sell your soul");
        for (Iterator<String> i = sf.getStringsStartingWith("Wo"); i.hasNext();) {
            System.out.println(i.next());
        }*/
        WordCounterImpl wc = new WordCounterImpl();
        wc.setText("  A Combined Work is a work produced by combining or linking an\n" +
                "Application with the Library.\n" + "The particular version 150 БЕТОНЁПТА of the Library\n" +
                "with which the Combined Work was made is also called the Linked\n" +
                "END");
        System.out.println(wc.getWordCounts());
        System.out.println(wc.sortHashMapByValues(wc.getWordCounts()));
        System.out.println(wc.getWordCountsSorted());
    }
}