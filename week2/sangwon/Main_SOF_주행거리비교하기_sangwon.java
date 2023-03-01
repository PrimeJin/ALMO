import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        if(A > B)  System.out.println("A"); 
        else if(A < B)  System.out.println("B"); 
        else  System.out.println("same");


    }
}