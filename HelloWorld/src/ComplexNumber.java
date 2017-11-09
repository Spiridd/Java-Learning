/**
 * Created by dimon on 01.08.17.
 */
public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) object;
            if (this.re == other.re && this.im == other.im) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int)(this.re*this.re + this.im*this.im);
    }
}
