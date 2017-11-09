package org.stepic.java.objects;

/**
 * Created by dimon on 03.08.17.
 */
class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > this.maxLength ? Label.TOO_LONG : Label.OK;
    }
}
