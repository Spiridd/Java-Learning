package ru.ncedu.java.tasks;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dimon on 05.10.17.
 */
public class WordProcessorImpl implements WordProcessor {
    private String text = null;

    @Override
    public void setSource(String src) {
        if (src == null)    throw new IllegalArgumentException();
        this.text = src;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setSourceFile(String srcFile) throws IOException {
        if (srcFile == null)    throw new IllegalArgumentException();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        this.text = stringBuilder.toString();
    }

    @Override
    public void setSource(FileInputStream fis) throws IOException {
        if (fis == null)    throw new IllegalArgumentException();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        this.text = stringBuilder.toString();
    }

    @Override
    public Set<String> wordsStartWith(String begin) {
        this.text = this.text.toLowerCase();
        Set<String> allWords = new HashSet<>(Arrays.asList(this.text.split("\\s+")));

        if (begin == null || begin.equals(""))  return allWords;

        begin = begin.toLowerCase();
        Set<String> goodWords = new HashSet<>();
        for(String word : allWords) {
            if (word.startsWith(begin)) {
                goodWords.add(word);
            }
        }

        return allWords;
    }
}
