package ru.skillbench.tasks.javaapi.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class StringFilterImpl implements StringFilter{
    private HashSet<String> set = new HashSet<>();

    @Override
    public void add(String s) {
        if (s == null) {
            set.add(null);
            return;
        }
        String str = s.toLowerCase();
        set.add(str);
    }

    @Override
    public boolean remove(String s) {
        if (s == null) {
            return set.remove(null);
        }
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
        String s = chars.toLowerCase();
        for (String str : set) {
            if (str != null && str.length() >= s.length() && str.contains(chars)) {
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
            if (str != null && str.length() >= s.length() &&
                    str.substring(0, s.length()).equals(s)) {
                suppSet.add(str);
            }
        }
        return suppSet.iterator();
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        if (format == null || format.equals("")) {
            return set.iterator();
        }
        String s = format.toLowerCase();
        HashSet<String> suppSet = new HashSet<>();
        for (String str : set) {
            if (str == null || str.length() != s.length()) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (str.charAt(i) != s.charAt(i) &&
                        (s.charAt(i) != '#' || !Character.isDigit(str.charAt(i))) ) {
                    break;
                }
                if (i == str.length() - 1) {
                    suppSet.add(str);
                }
            }
        }
        return suppSet.iterator();
    }

    @Override       //TODO it is a bidlo-method - fix it
    public Iterator<String> getStringsByPattern(String pattern) {
        if (pattern == null || pattern.equals("")) {
            return set.iterator();
        }
        String s = pattern.toLowerCase();
        HashSet<String> suppSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char c;
        boolean flag = true;

        for (String str : set) {
            if (str == null) {
                continue;
            }
            for (int i = 0; i < pattern.length(); i++) {
                c = pattern.charAt(i);
                if (c != '*') {
                    sb.append(c);
                } else if (!str.contains(sb)) {
                    flag = false;
                } else {
                    sb.delete(0, sb.length());
                }
            }
            sb.delete(0, sb.length());
            if (flag) {
                suppSet.add(str);
            }
            flag = true;
        }
        return suppSet.iterator();
    }
}
