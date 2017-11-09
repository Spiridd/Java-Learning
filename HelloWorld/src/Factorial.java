import java.math.BigInteger;

/**
 * Created by dimon on 05.07.17.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(10));
    }

    public static BigInteger fact(int n) {
        return n > 0 ? fact(n-1).multiply(BigInteger.valueOf(n)) : BigInteger.valueOf(1);
    }
}
