public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(Complex c) {
        this.real = c.real;
        this.imaginary = c.imaginary;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    void addWithComplex(Complex c) {
        this.real += c.real;
        this.imaginary += c.imaginary;
    }

    void showNumber() {
        System.out.println("Imaginary part is: " + getImaginary() +
                        '\n' + "Real part is: " + getReal());
    }
}
