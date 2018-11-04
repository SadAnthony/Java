package ru.skillbench.tasks.javax.xml;

import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class SimpleXMLImpl implements SimpleXML {
    @Override
    public String createXML(String tagName, String textNode) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = Objects.requireNonNull(builder).newDocument();
        Element root = document.createElement(tagName);
        document.appendChild(root);
        Text text = document.createTextNode(textNode);
        root.appendChild(text);
        Transformer t = null;
        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        if (t != null) {
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        }
        try {
            if (t != null) {
                t.transform(new DOMSource(document),
                        new StreamResult(new FileOutputStream("temp.xml")));
            }
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
        StringWriter writer = new StringWriter();
        try {
            if (t != null) {
                t.transform(new DOMSource(document), new StreamResult(writer));
            }
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return writer.getBuffer().toString();
    }

    @Override
    public String parseRootElement(InputStream xmlStream) throws SAXException {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName,
                                     String qName, Attributes attributes) throws SAXException {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(new FileWriter("outFile.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (printWriter != null) {
                    printWriter.write(qName);
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            if (parser != null) {
                parser.parse(xmlStream, handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = "";
        try
        {
            content = new String (Files.readAllBytes(Paths.get("outFile.txt")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
