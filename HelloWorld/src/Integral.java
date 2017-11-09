/**
 * Created by dimon on 01.08.17.
 */
import java.util.function.DoubleUnaryOperator;

public class Integral {
    public static void main(String[] args) {
        System.out.println(integrate(x -> x, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double dx = 1e-6;
        double sum = 0.0;
        final int steps = (int) ((b-a)/dx);
        for(int i=0; i<steps; ++i) {
            sum += f.applyAsDouble(a + i * dx);
        }
        return sum*dx;
    }
}
