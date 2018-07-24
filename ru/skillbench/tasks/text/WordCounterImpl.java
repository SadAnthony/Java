package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter{
    private String text = "";

    @Override
    public void setText(String text) {
        if (text != null) {
            this.text = text;
        }
    }

    @Override
    public String getText() {
        if (this.text.equals("")) {
            return null;
        } else {
            return this.text;
        }
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if (this.text.equals("")) {
            throw new IllegalStateException();
        }
        String t = text.toLowerCase();
        char c;
        StringBuilder word = new StringBuilder();
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (c == '<') {
                do {
                    i++;
                    c = t.charAt(i);
                } while (c != '>');
            } else if (Character.isLetter(c) || Character.isDigit(c)
                    || Character.isAlphabetic(c)) {
                word.append(c);
            }
            if (c == '\n' || c == '\t' || c == ' ' || i == t.length()-1) {
                if (word.length() != 0) {
                    String key = word.toString();
                    if (map.containsKey(key)) {
                        Long count = map.get(key);
                        count++;
                        map.remove(key);
                        map.put(key, count);
                    } else {
                        map.put(key, 1L);
                    }
                    word.delete(0, word.length());
                }
            }
        }
        return map;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        if (this.text.equals("")) {
            throw new IllegalStateException();
        }
        return new ArrayList<>(this.sortHashMapByValues(this.getWordCounts()).entrySet());
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>>
    sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        return null;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {

    }

    public LinkedHashMap<String, Long> sortHashMapByValues(
            Map<String, Long> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Long> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.reverse(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Long> sortedMap =
                new LinkedHashMap<>();

        for (Long val : mapValues) {
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Long comp1 = passedMap.get(key);

                if (comp1.equals(val)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
