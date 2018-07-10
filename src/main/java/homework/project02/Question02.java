package homework.project02;

import java.util.Scanner;

/**
 * Question02
 *
 * @author guxiang
 * @date 2017/11/29
 */
public class Question02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        String firstline = scanner.nextLine();
        System.out.print("Enter the second complex number: ");
        String secondline = scanner.nextLine();

        String[] arg1 = firstline.split(" ");
        String[] arg2 = secondline.split(" ");
        float a = Float.parseFloat(arg1[0]);
        float b = Float.parseFloat(arg1[1]);

        float c = Float.parseFloat(arg2[0]);
        float d = Float.parseFloat(arg2[1]);

        Complex firstc = new Complex(a,b);

        Complex secondc = new Complex(c,d);

        System.out.println(firstc+" + "+ secondc +"="+ firstc.add(secondc).toResultString());
        System.out.println(firstc+" - "+ secondc +"="+ firstc.subtract(secondc).toResultString());
        System.out.println(firstc+" * "+ secondc +"="+ firstc.multiply(secondc).toResultString());
        System.out.println(firstc+" / "+ secondc +"="+ firstc.divide(secondc).toResultString());
        System.out.println("|"+firstc+"| = "+firstc.abs());
    }
}
