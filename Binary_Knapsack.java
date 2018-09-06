import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter no. of weights = ");
   int n=sc.nextInt(),i,j;
   int p[]=new int[n+1];
   System.out.print("Enter profits = ");
   for(i=1;i<=n;i++)
   {
     p[i]=sc.nextInt();
   }
   int w[]=new int[n+1];
   System.out.print("Enter corresponding weights = ");
   for(i=1;i<=n;i++)
   {
     w[i]=sc.nextInt();
   }
   System.out.print("Enter Maximum weight = ");
   int W=sc.nextInt();
   int v[][]=new int[n+1][W+1];
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=W;j++)
     {
       if(w[i]<=j)
       {
         v[i][j]=Math.max(v[i-1][j],p[i]+v[i-1][j-w[i]]);
       }
       else
       {
         v[i][j]=v[i-1][j];
       }
     }
   }
   System.out.println("Matrix formed is :");
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=W;j++)
     {
       System.out.print(v[i][j]+" ");
     }
     System.out.println();
   }
   System.out.println("Maximum profit = "+v[n][W]);
   i=n;
   j=W;
   Vector<Integer> thing=new Vector<Integer>();
   while(v[i][j]!=0)
   {
     if(v[i][j]>v[i-1][j])
     {
       thing.add(i);
       j-=w[i];
       i--;
     }
     else
     {
       i--;
     }
   }
   System.out.println("Weights included = "+thing);
 }
}