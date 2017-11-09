package org.stepic.java.objects;

/**
 * Created by dimon on 03.08.17.
 */
abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        String[] keywords = this.getKeywords();
        Label label = this.getLabel();
        boolean contains = false;
        for(String keyword : keywords)
            if (text.contains(keyword)) contains = true;
        return contains ? label : Label.OK;
    }
}
