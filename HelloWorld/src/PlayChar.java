import java.util.Arrays;

/**
 * Created by dimon on 01.08.17.
 */
public class PlayChar {
    public static void main(String[] args) {
        byte[] s = new byte[]{'a', 'b', 'c', 'd', 'x'};
        System.out.println(Arrays.toString(s));
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(s);
        System.out.println(asciiCharSequence.toString());
        System.out.println(asciiCharSequence.charAt(2));
        System.out.println(asciiCharSequence.length());
        System.out.println(asciiCharSequence.subSequence(1, 3));
    }
}
