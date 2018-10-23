import ru.skillbench.tasks.text.regex.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String str = "email@dot.com  dsmkvs@dvmskl.ru";
        PatternsImpl pat = new PatternsImpl();
        List<String> list = new ArrayList<>(pat.findAll(str, pat.getEmailPattern()));
        for (String obj : list) {
            System.out.println(obj);
        }
        System.out.println(pat.countMatches(str, pat.getEmailPattern().toString()));
    }
}


