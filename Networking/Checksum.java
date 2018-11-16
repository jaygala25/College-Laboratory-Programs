import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.println("Transmitter Side:");
   System.out.print("Enter 64 Bit Data = ");
   String s=new String();
   s=sc.next();
   String temp=s;
   int sum=0,i;
   for(i=0;i<s.length();i+=4)
   {
     sum=sum+Integer.parseInt(s.substring(i,i+4),16);
   }
   s=Integer.toHexString(sum);
   System.out.println("After Adding = "+s);
   String x=s.substring(0,1);
   String y=s.substring(1,s.length());
   sum=Integer.parseInt(x,16)+Integer.parseInt(y,16);
   s=Integer.toHexString(sum);
   System.out.println("After adding carry = "+s);
   sum=65535-sum;
   s=Integer.toHexString(sum);
   System.out.println("Checksum (1's complement) is = "+s);
   System.out.println("Data sent is = "+temp+s);


   System.out.println();
   System.out.println("Receiver Side: ");
   System.out.print("Enter Received data = ");
   s=sc.next();
   sum=0;
   for(i=0;i<s.length();i+=4)
   {
     sum=sum+Integer.parseInt(s.substring(i,i+4),16);
   }
   s=Integer.toHexString(sum);
   System.out.println("After Adding = "+s);
   x=s.substring(0,1);
   y=s.substring(1,s.length());
   sum=Integer.parseInt(x,16)+Integer.parseInt(y,16);
   s=Integer.toHexString(sum);
   System.out.println("After adding carry = "+s);
   sum=65535-sum;
   s=Integer.toHexString(sum);
   System.out.println("1's complement is = "+s);
   if(sum==0)
   {
     System.out.println("Data received has no error");
   }
   else
   {
     System.out.println("Data received has error");
   }

  
 }
}