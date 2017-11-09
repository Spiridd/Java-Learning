/**
 * Program finds all 4-digit vampire numbers.
 *
 * Vampire number is a composite natural number v of size n such that
 * 1. It can be factored into two integers x and y
 * 2. x and y have n/2 digits each
 * 3. if x ends with 0, y mustn't end with non-zero digit
 * 4. v contains all digits from x and y
 *
 * @author dimon
 */
public class VampireNumbers {
    /**
     * Main method
     * @param args array of input arguments
     */
    public static void main(String[] args) {
        for(int i=1000; i<10000; ++i) {
            int[] fangs = getFangs(i);
            if (fangs != null) {
                System.out.println(i + " = " + fangs[0] + " * " +fangs[1]);
            }
        }
    }

    /**
     * Get digits from a number
     * @param value input number
     * @return array of value digits
     * @throws ArithmeticException value must be > 0
     */
    public static int[] getDigits(int value) throws ArithmeticException {
        if (value <= 0) {
            throw new ArithmeticException("value should be > 0");
        }
        int size = (int) (Math.log10(value) + 1);
        int[] digits = new int[size];
        for(int i=0; i<size; ++i) {
            digits[i] = value % 10;
            value /= 10;
        }
        return digits;
    }

    /**
     * Gets two digit number
     * @param digits array of 4 digits
     * @param pos1 position of more valuable digit
     * @param pos2 position of the other digit
     * @return number with two digits
     */
    public static int getTwoDigitNumber(int[] digits, int pos1, int pos2) {
        return digits[pos1]*10 + digits[pos2];
    }

    /**
     * changes number ab to ba
     * @param value number with two digits
     * @return value read from end to begin
     */
    public static int swapTwoDigits(int value) {
        int d1 = value % 10;
        int d2 = value / 10;
        return d1 * 10 + d2;
    }

    /**
     * Finds fangs of vampire number.
     * @param vampire
     * @return one pair of fangs or null if they don't exist
     */
    public static int[] getFangs(int vampire) {
        int[] digits = getDigits(vampire);

        int fang1, fang2;
        for(int i=0; i<3; ++i) {
            fang1 = getTwoDigitNumber(digits, 3, i);
            // i + pos1 + pos2 = 3
            int pos1 = (2 == i ? 1 : 2);
            int pos2 = 3-pos1-i;
            fang2 = getTwoDigitNumber(digits, pos1, pos2);

            for(int j=0; j<2 && fang1*fang2 != vampire; ++j) {
                fang1 = swapTwoDigits(fang1);
                if (fang1*fang2 != vampire) fang2 = swapTwoDigits(fang2);
            }
            if (fang1*fang2 == vampire) return new int[]{fang1, fang2};
        }

        return null;
    }
}
