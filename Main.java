import ru.skillbench.tasks.javax.xml.SimpleXML;
import ru.skillbench.tasks.text.regex.*;
import ru.skillbench.tasks.javaapi.io.*;

import ru.skillbench.tasks.javax.xml.SimpleXMLImpl;

public class Main {

    public static void main(String[] args) {
        SimpleXML sxml = new SimpleXMLImpl();
        System.out.println(sxml.createXML("someKindOfTag1", "<[\n" +
                "\n" +
                "New line\n" +
                "\n" +
                "]>"));
    }
}


