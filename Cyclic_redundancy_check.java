import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter Generator Polynomial = ");
   String s=new String();
   s=sc.next();
   System.out.println("No. of bits to be appended = "+(s.length()-1));
 
 
   System.out.println("Transmitter Side:");
   System.out.print("Enter Generator Polynomial = ");
   int divi[]=new int[7];
   int gen[]=new int[4];
   int temp[]=new int[4];
   int i,j;
   for(i=0;i<=3;i++)
   {
     gen[i]=sc.nextInt();
   }
   System.out.print("Enter Dividend = ");
   for(i=0;i<=3;i++)
   {
     divi[i]=sc.nextInt();
     temp[i]=divi[i];
   }
   System.out.println("After padding 0s = "+Arrays.toString(divi));
   for(i=0;i<=3;i++)
   {
     if(divi[i]==1)
     {
       for(j=0;j<=3;j++)
       {
         divi[i+j]=divi[i+j]^gen[j];
       }
     }
     else
     {
       for(j=0;j<=3;j++)
       {
         divi[i+j]=divi[i+j]^0;
       }
     }
   }
   divi[0]=temp[0];
   divi[1]=temp[1];
   divi[2]=temp[2];
   divi[3]=temp[3];
   System.out.println("Remainder is = "+divi[4]+""+divi[5]+""+divi[6]);
   System.out.println("Data sent is = "+Arrays.toString(divi));
   System.out.println();
  
  
   System.out.println("Receiver Side:");
   System.out.print("Enter Received data = ");
   for(i=0;i<=6;i++)
   {
     divi[i]=sc.nextInt();
   }
   for(i=0;i<=3;i++)
   {
     if(divi[i]==1)
     {
       for(j=0;j<=3;j++)
       {
         divi[i+j]=divi[i+j]^gen[j];
       }
     }
     else
     {
       for(j=0;j<=3;j++)
       {
         divi[i+j]=divi[i+j]^0;
       }
     }
   }
   System.out.println("Remainder is = "+divi[4]+""+divi[5]+""+divi[6]);
   if(divi[4]==0 && divi[5]==0 && divi[6]==0)
   {
     System.out.println("Data received has no error");
   }
   else
   {
     System.out.println("Data received has error");
   }
 }
}