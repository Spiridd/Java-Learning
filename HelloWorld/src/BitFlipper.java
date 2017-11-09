/**
 * Created by dimon on 04.07.17.
 */
import java.math.*;

public class BitFlipper {
    public static void main(String[] args) {
        int value = 10;
        for(int bitIndex = 10; bitIndex > 0; --bitIndex) {
            int addValue = (int) Math.pow(2, (double) bitIndex - 1);
            System.out.print((value & addValue) > 0 ? '1' : '0');
        }
    }
}
