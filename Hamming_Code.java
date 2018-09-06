import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.println("Transmitter Side:");
   System.out.print("Enter no. of Data bits = ");
   int k=sc.nextInt();
   int r=0,i,j;
   while(Math.pow(2,r)<=k+r)
   {
     r++;
   }
   System.out.println("Total no. of parity bits = "+r);
   int ham[]=new int[k+r+1];
   System.out.print("Enter "+k+" bits of data = ");
   for(i=ham.length-1;i>=1;i--)
   {
     if((i & (i-1))!=0)
     {
       ham[i]=sc.nextInt();
     }
   }
   int e=0;
   for(i=1;i<=k+r;i*=2)
   {
     e=0;
     for(j=1;j<=k+r;j++)
     {
       if(j!=i && (j & i)==i)
       {
         e=e^ham[j];
       }
     }
     ham[i]=e;
   }
   System.out.print("Hamming Code sent is = ");
   for(i=ham.length-1;i>=1;i--)
   {
     System.out.print(ham[i]+" ");
   }
   System.out.println();
   System.out.println();
   System.out.println("Receiver Side:");
   System.out.print("Enter Received Hamming code = ");
   int rec[]=new int[k+r+1];
   for(i=rec.length-1;i>=1;i--)
   {
     rec[i]=sc.nextInt();
   }
   int temp[]=new int[k+r+1];
   for(i=temp.length-1;i>=1;i--)
   {
     if((i & (i-1))!=0)
     {
       temp[i]=rec[i];
     }
   }
   e=0;
   for(i=1;i<=k+r;i*=2)
   {
     e=0;
     for(j=1;j<=k+r;j++)
     {
       if(j!=i && (j & i)==i)
       {
         e=e^temp[j];
       }
     }
     temp[i]=e;
   }
   int f=0;
   StringBuffer str=new StringBuffer();
   for(i=1;i<=k+r;i*=2)
   {
     if(rec[i]!=temp[i])
     {
       str.append("1");
       f=1;
     }
     else
     {
       str.append("0");
     }
   }
   str=str.reverse();
   if(f==1)
   {
     System.out.println("Error detected");
     int pos=Integer.parseInt(String.valueOf(str),2);
     System.out.println("Error detected at position = "+pos);
     rec[pos]=rec[pos]^1;
     System.out.print("Corrected code is = ");
     for(i=rec.length-1;i>=1;i--)
     {
       System.out.print(rec[i]+" ");
     }
   }
   else
   {
     System.out.print("No error detected");
   }
 }
}