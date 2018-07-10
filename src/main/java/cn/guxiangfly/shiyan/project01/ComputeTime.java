package cn.guxiangfly.shiyan.project01;

import java.util.Scanner;

public class ComputeTime {
  
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {


        Scanner reader=new Scanner(System.in);
        int a=reader.nextInt();
        int  b=reader.nextInt(); int c=reader.nextInt();

        Common bike = new Common() {
            @Override
            public double getSpeed(double A, double B, double C) {
                return A+B+C+1;
            }
        };

        System.out.println(bike.getSpeed(a, b, c));

    }  
  
}  