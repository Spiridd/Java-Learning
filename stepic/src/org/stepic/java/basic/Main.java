package org.stepic.java.basic;

/**
 * Created by dimon on 03.08.17.
 */
public class Main {
    public String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] roleTexts = new StringBuilder[roles.length];
        for(int i=0; i<roles.length; ++i)
            roleTexts[i] = new StringBuilder("");
        for(int lineNumber=0; lineNumber < textLines.length; ++lineNumber) {
            String line = textLines[lineNumber];
            for(int roleNumber=0; roleNumber < roles.length; ++roleNumber) {
                String role = roles[roleNumber];
                if (line.startsWith(role.concat(":"))) {
                    roleTexts[roleNumber].append(Integer.toString(lineNumber + 1))
                            .append(") ").append(line.subSequence(role.length() + 2, line.length()));
                }
            }
        }
        StringBuilder grouppedText = new StringBuilder();
        for(int roleNumber=0; roleNumber < roles.length; ++roleNumber) {
            grouppedText.append(roles[roleNumber]).append(":\n").append(roleTexts[roleNumber]).append("\n");
        }
        return grouppedText.toString();
    }
}
