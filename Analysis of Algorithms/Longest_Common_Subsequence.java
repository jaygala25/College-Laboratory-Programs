import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter 1st String = ");
   String s1=new String();
   s1=sc.nextLine();
   int i,j;
   System.out.print("Enter 2nd String = ");
   String s2=new String();
   s2=sc.nextLine();
   char c[]=s1.toCharArray();
   char d[]=s2.toCharArray();
   int m[][]=new int[c.length+1][d.length+1];
   for(i=0;i<=d.length;i++)
   {
     m[0][i]=0;
   }
   for(i=0;i<=c.length;i++)
   {
     m[i][0]=0;
   }
   System.out.println("Matrix formed is :");
   for(i=1;i<=c.length;i++)
   {
     for(j=1;j<=d.length;j++)
     {
       if(c[i-1]==d[j-1])
       {
         m[i][j]=m[i-1][j-1]+1;
       }
       else
       {
         m[i][j]=Math.max(m[i-1][j],m[i][j-1]);
       }
       System.out.print(m[i][j]+" ");
     }
     System.out.println();
   }
   i=c.length;
   j=d.length;
   StringBuffer s=new StringBuffer();
   while(i>0 && j>0)
   {
     if(m[i][j]>m[i-1][j-1] && m[i-1][j]==m[i][j-1])
     {
       s.append(c[i-1]);
       i--;
       j--;
     }
     else
     if(m[i-1][j]>m[i][j-1])
     {
       i--;
     }
     else
     {
       j--;
     }
   }
   s=s.reverse();
   if(s.length()>0)
   {
     System.out.println("LCS is = "+s);
     System.out.print("Length of LCS is = "+s.length());
   }
   else
   {
     System.out.print("No LCS exists");
   }
 }
}
