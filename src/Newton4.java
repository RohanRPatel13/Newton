import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error given by
     * the user.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double percent) {
        Random1L rnd = new Random1L();
        double r = rnd.nextDouble();
        r = (r + x / r) / 2;

        double check = (r * r - x);
        while (check / x > (percent * percent)) {
            r = (r + x / r) / 2;

            if ((r * r - x) < 0) {
                check = -1 * (r * r - x);
            } else {
                check = r * r - x;
            }
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        double n = 0.0;
        while (n >= 0.0) {
            out.print("Enter a starting number: ");
            n = in.nextDouble();
            out.print("Enter relative error: ");
            double err = in.nextDouble();
            out.println(sqrt(n, err));
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
