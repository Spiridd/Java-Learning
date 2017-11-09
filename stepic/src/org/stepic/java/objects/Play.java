package org.stepic.java.objects;

/**
 * Created by dimon on 03.08.17.
 */
public class Play {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(TextAnalyzer analyzer : analyzers) {
            Label result = analyzer.processText(text);
            if (result != Label.OK) return result;
        }
        return Label.OK;
    }
}
