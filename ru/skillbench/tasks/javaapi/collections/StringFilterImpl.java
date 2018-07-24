package ru.skillbench.tasks.javaapi.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class StringFilterImpl implements StringFilter{
    private HashSet<String> set = new HashSet<>();

    @Override
    public void add(String s) {
        String str = s.toLowerCase();
        set.add(str);
    }

    @Override
    public boolean remove(String s) {
        return set.remove(s.toLowerCase());
    }

    @Override
    public void removeAll() {
        set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        if (chars == null || chars.equals("")) {
            return set.iterator();
        }
        HashSet<String> suppSet = new HashSet<>();
        for (String str : set) {
            if (str.contains(chars)) {
                suppSet.add(str);
            }
        }
        return suppSet.iterator();
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        if (begin == null || begin.equals("")) {
            return set.iterator();
        }
        String s = begin.toLowerCase();
        HashSet<String> suppSet = new HashSet<>();
        for (String str : set) {
            if (str.substring(0, s.length()).equals(s)) {
                suppSet.add(str);
            }
        }
        return suppSet.iterator();
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return null;
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        return null;
    }
}
