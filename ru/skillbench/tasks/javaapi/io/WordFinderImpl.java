package ru.skillbench.tasks.javaapi.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.Stream;

public class WordFinderImpl implements WordFinder {
    private String text = null;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) throws IllegalArgumentException {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        this.text = text;
    }

    @Override
    public void setInputStream(InputStream is) throws IOException {
        if (is == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder buffer = new StringBuilder();
        int i;
        while ((i = is.read()) != -1) {
            buffer.append((char) i);
        }
        text = buffer.toString();
    }

    @Override
    public void setFilePath(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException();
        }
        FileReader fileReader = new FileReader(filePath);
        StringBuilder buffer = new StringBuilder();
        int i;
        while ((i = fileReader.read()) != -1) {
            buffer.append((char) i);
        }
        text = buffer.toString();
    }

    @Override
    public void setResource(String resourceName) throws IOException {

    }

    @Override
    public Stream<String> findWordsStartWith(String begin) {
        return null;
    }

    @Override
    public void writeWords(OutputStream os) throws IOException {

    }
}
