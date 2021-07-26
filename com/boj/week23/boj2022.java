package com.boj.week23;
import java.text.DecimalFormat;
import java.util.*;

public class boj2022 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double x=sc.nextDouble();
        double y=sc.nextDouble();
        double c=sc.nextDouble();
        double right=Math.min(x,y);
        double left=0;
        double middle=0;
        while(right-left>0.000001){
            middle=(right+left)/2;
            //middle==res
            double h1=Math.sqrt(x*x-middle*middle);
            double h2=Math.sqrt(y*y-middle*middle);
            double a=(c*middle)/h2;
            double b=(c*middle)/h1;
            if(a+b<middle){
                left=middle;
            }else if(a+b>middle){
                right=middle;
            }
            else{
                break;
            }
        }
        String str=String.format("%.3f",middle);
        System.out.println(str);
    }
}
