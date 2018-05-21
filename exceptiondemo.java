import java.util.Scanner;
import java.io.*;
import java.lang.*;
class exceptiondemo{
public static void main(String[] agrs) {
Scanner sc=new Scanner(System.in);
int a,b;
System.out.println("enter a and b");
a=sc.nextInt();
b=sc.nextInt();
try {
System.out.println(a/b);
}
catch(Exception exc) {
System.out.println("exception handeled");
exc.printStackTrace();
}
finally {
System.out.println("code after exception`");
}
}
}
