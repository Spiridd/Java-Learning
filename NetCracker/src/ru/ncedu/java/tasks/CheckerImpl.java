package ru.ncedu.java.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dimon on 02.10.17.
 */
public class CheckerImpl implements Checker {
    @Override
    public Pattern getPLSQLNamesPattern() {
        return Pattern.compile("[a-zA-Z][\\w$]{0,29}");
    }

    @Override
    public Pattern getHrefURLPattern() {
        return Pattern.compile("<\\s*[aA]\\s*[hH][rR][eE][fF]\\s*=\\s*(?:(?:\"[\\w\\s]*\")|(?:\\w*))\\s*/?\\s*>");
    }

    @Override
    public Pattern getEMailPattern() {
        return Pattern.compile("[a-zA-Z0-9](?:|[\\w.\\-]{0,20}[a-zA-Z0-9])" +
                "@([a-zA-Z0-9][\\w\\-&&[^_]]*[a-zA-Z0-9]\\.)+(?:ru|com|net|org)");
    }

    @Override
    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if (inputString == null && pattern == null) return true;
        else if (inputString == null || pattern == null)    throw new IllegalArgumentException();
        return pattern.matcher(inputString).matches();
    }

    @Override
    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
        if (inputString == null || pattern == null)    throw new IllegalArgumentException();
        Matcher matcher = pattern.matcher(inputString);
        List<String> allMatches = new ArrayList<>();
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }
        return allMatches;
    }
}
