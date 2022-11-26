/**
 * @Author: Jiongting Chen
 * @Purpose: To simulate the calculations of fractions
 * @Version: 1.0
 */

public class Fraction {
    private int nmrt;
    private int dnmt;


    /**
     *Default fraction: 1/1
     */
    public Fraction() {
        nmrt = 1;
        dnmt = 1;

    }

    /**
     * @param d - assign to denominator
     * @param n - assign to numerator
     */
    public Fraction(int n, int d) {
        nmrt = n;
        if (d != 0) dnmt = d;
        else {
            dnmt = 1;
            System.out.println("Error: 0 as the denominator? Are you kidding me...");
        }
        dnNegative();
    }


    /**
     * @param f - assign a string to the fraction
     */
    public Fraction(String f) {
        nmrt = Integer.parseInt(f.substring(0, f.indexOf("/")));
        if (Integer.parseInt(f.substring(f.indexOf("/")+1)) != 0) dnmt = Integer.parseInt(f.substring(f.indexOf("/")+1));
        else {
            dnmt = 1;
            System.out.println("Error: 0 as the denominator? Are you kidding me...");
        }

    }

    /**
     * @param f - assign to another fraction
     */
    public Fraction (Fraction f) {
        nmrt = f.nmrt;
        dnmt = f.dnmt;
        dnNegative();
    }

    /**
     * Pre-condition: numerator < 0 and denominator < 0
     * Post-condition: numerator and denominator change into absolute value
     * change the fraction back to positive if numerator and denominator are both negative
     */
    public void dnNegative() {
        if (nmrt < 0 && dnmt < 0) {
            setNum(Math.abs(nmrt));
            setDenom(Math.abs(dnmt));
        }
    }

    /**
     * @return the fraction as a string
     */
    //Accessor Methods
    public String toString() {
        return nmrt + "/" + dnmt;
    }

    /**
     * @return Numerator
     */
    public int getNum() {
        return nmrt;
    }

    /**
     * @return Denominator
     */
    public int getDenom() {
        return dnmt;
    }

    /**
     * @return the fraction which its numerator and denominator are both doubles
     */
    public double toDouble() {
        return ((double) nmrt/ (double) dnmt);
    }

    //Mutator Methods

    /**
     * reduce the fraction to its simplest form by dividing the numerator and denominator by their greatest common factor
     */
    public void reduce() {
        int factor = GCF(nmrt, dnmt);
        nmrt /= factor;
        dnmt /= factor;
    }

    /**
     * @param n - value to change to
     */
    public void setNum(int n) {
        nmrt = n;
    }

    /**
     * @param d - value to change to
     */
    public void setDenom(int d) {
        if (d != 0) dnmt = d;
        else {
            dnmt = 1;
            System.out.println("Error: 0 as the denominator? Are you kidding me...");
        }

    }

    private int GCF(int a, int b) {


            if (Math.abs(a) == Math.abs(b) && (a > 0 || b > 0)) return a;
            else if (a < 0 || b < 0) return -a;
            if (Math.abs(a) > Math.abs(b)) return GCF(Math.abs(a) - Math.abs(b), Math.abs(b));
            return GCF(Math.abs(b) - Math.abs(a), Math.abs(a));
    }

    public static Fraction reciprocal(Fraction f) {
        return new Fraction(f.dnmt,f.nmrt);
    }

    public static Fraction add(Fraction a, Fraction b) {
        return new Fraction(a.nmrt*b.dnmt + b.nmrt*a.dnmt, a.dnmt*b.dnmt);

    }

    public static Fraction subtract(Fraction a, Fraction b) {
        return new Fraction(a.nmrt*b.dnmt - b.nmrt*a.dnmt, a.dnmt*b.dnmt);
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction output = new Fraction((a.nmrt * b.nmrt), (a.dnmt * b.dnmt));
        output.reduce();
        return output;

    }

    public Fraction multiply(Fraction a) {
        Fraction output = new Fraction((nmrt * a.nmrt), (dnmt * a.dnmt));
        output.reduce();
        return output;

    }

    public static Fraction divide(Fraction a, Fraction b) {
        return multiply(a, reciprocal(b));
    }

    public Fraction divide(Fraction a) {
        return multiply(new Fraction(nmrt, dnmt), reciprocal(a));
    }

    public static Fraction randomFraction() {
        return new Fraction((int)(Math.random()*9+1), (int)(Math.random()*9+1));
    }

}
