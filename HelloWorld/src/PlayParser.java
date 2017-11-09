import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dimon on 06.07.17.
 */
public class PlayParser {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Vector<String> roles = new Vector<String>();
        input.skip("roles:\n");
        while( input.hasNextLine() ) {
            roles.add(input.nextLine());
        }
        System.out.println(roles);
/*
        Vector<String> textLines = new Vector<String>();
        input.skip("textLines:\n");
        while( input.hasNextLine() ) {
            textLines.add(input.nextLine());
        }
        System.out.println(roles);
*/
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        return "";
    }
}
