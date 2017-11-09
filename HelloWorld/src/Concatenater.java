/**
 * Created by dimon on 04.07.17.
 */
public class Concatenater {
    public static void main(String[] args) {
        String text = "Madam, I'm Adam!";
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder textReversed = new StringBuilder(text);
        textReversed.reverse();
        System.out.println(text);
        System.out.println(textReversed);
        System.out.println(text.equalsIgnoreCase(textReversed.toString()));
    }
}
