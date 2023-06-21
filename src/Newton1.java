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
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        Random1L rnd = new Random1L();
        double r = rnd.nextDouble();
        r = (r + x / r) / 2;

        double check = (r * r - x);
        while (check / x > (.0001 * .0001)) {
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
        String y = "y";
        while (y.equals("y")) {

            out.print("Enter a starting number: ");
            double n = in.nextDouble();
            out.println(sqrt(n));
            out.print("Would you like to start another series(\"y\"): ");
            y = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
