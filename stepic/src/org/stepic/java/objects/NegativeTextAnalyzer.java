package org.stepic.java.objects;

/**
 * Created by dimon on 03.08.17.
 */
class NegativeTextAnalyzer extends KeywordAnalyzer {

    public NegativeTextAnalyzer() {}

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return new String[] {":(", "=(", ":|"};
    }
}
