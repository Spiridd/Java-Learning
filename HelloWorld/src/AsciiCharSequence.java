/**
 * Created by dimon on 01.08.17.
 */
import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private final byte[] value;

    public AsciiCharSequence(byte[] sequence) {
        this.value = Arrays.copyOf(sequence, sequence.length);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.value, i, i1));
    }

    @Override
    public char charAt(int i) {
        return (char)(this.value[i]);
    }

    @Override
    public int length() {
        return this.value.length;
    }

    @Override
    public String toString() {
        char[] castedValue = new char[this.length()];
        for(int i=0; i<this.length(); ++i) {
            castedValue[i] = this.charAt(i);
        }
        return new String(castedValue);
    }
}
