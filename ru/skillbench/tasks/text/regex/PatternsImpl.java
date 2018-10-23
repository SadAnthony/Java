package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsImpl implements Patterns {
    @Override
    public Pattern getSQLIdentifierPattern() {
        return Pattern.compile("[a-zA-Z][0-9a-zA-Z_]{0,30}");
    }

    @Override
    public Pattern getEmailPattern() {
        return Pattern.compile("([a-zA-Z0-9][0-9a-zA-Z_.\\-]{0,20}[a-zA-Z0-9])@" +
                "([a-zA-Z0-9\\-]+\\.)+" + "((ru)|(com)|(net)|(org))");
    }

    @Override
    public Pattern getHrefTagPattern() {
        return Pattern.compile("<\\s*[aA]\\s+([hH][rR][eE][fF])\\s*=\\s*" +
                "(([\\\\0-9a-zA-Z_.\\-@#\"]*)|(\"[\\\\0-9a-zA-Z_.\\-\"\\s@#]*\"))\\s*\\\\?>");
    }

    @Override
    public List<String> findAll(String input, Pattern pattern) {
        List<String> matches = new ArrayList<>();
        Matcher m = pattern.matcher(input);
        while(m.find()) {
            matches.add(m.group());
        }
        return matches;
    }

    @Override
    public int countMatches(String input, String regex) {
        List<String> matches = new ArrayList<>();
        Pattern pat = Pattern.compile(regex);
        Matcher m = pat.matcher(input);
        while(m.find()) {
            matches.add(m.group());
        }
        return matches.size();
    }
}
