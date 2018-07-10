package homework.project02;

/**
 * Complex
 *
 * @author guxiang
 * @date 2017/11/29
 */
public class Complex implements Cloneable{
    private float a = 0;
    private float b =0;

    public Complex(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public Complex(float a) {
        this.a = a;
    }

    public Complex() {
    }

    public float getRealPart() {
        return a;
    }


    public float getImaginaryPart() {
        return b;
    }



    public Complex add(Complex complex2){

        float m = a + complex2.getRealPart();
        float n = b + complex2.getImaginaryPart();
        return new Complex(m,n);
    }

    public Complex subtract (Complex complex2){
        float m = a - complex2.getRealPart();
        float n = b - complex2.getImaginaryPart();
        return new Complex(m,n);
    }

    public Complex multiply (Complex complex2){

        float c = complex2.getRealPart();
        float d = complex2.getImaginaryPart();
        float m = a*c -b*d;

        float n =b*c + a*d;
        return new Complex(m,n);
    }

    public Complex divide (Complex complex2){

        float c = complex2.getRealPart();
        float d = complex2.getImaginaryPart();

        float m = (a*c + b*d)/(c*c + d*d);
        float n = (b*c - a*d)/(c*c + d*d);
        return new Complex(m,n);
    }

    public double abs (){

        double m  =a*a + b*b;

        double sqrt = Math.sqrt(m);

        return sqrt;
    }

    @Override
    public String toString() {
        return "("+a+" + "+b+"i)";
    }

    public String toResultString(){
        return a +" + "+b+"i";
    }
}
