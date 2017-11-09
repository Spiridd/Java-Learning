package org.stepic.java.objects;

/**
 * Created by dimon on 03.08.17.
 */
class SpamAnalyzer extends KeywordAnalyzer {
    final private String[] keywords;
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

    @Override
    public String[] getKeywords() {
        return keywords;
    }
}
