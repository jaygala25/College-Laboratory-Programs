import java.util.*;
class pair implements Comparable<pair>
{
 int val,mini;
 pair(int x,int y)
 {
   val=x;
   mini=y;
 }
 public int compareTo(pair p)
 {
   return this.val-p.val;
 }
}
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter no. of matrices = ");
   int n=sc.nextInt();
   System.out.print("Enter orders of matrices = ");
   int order[]=new int[n+2];
   int i,j,count,k,temp;
   for(i=1;i<=n+1;i++)
   {
     order[i]=sc.nextInt();
   }
   int m[][]=new int[n+1][n+1];
   int s[][]=new int[n+1][n+1];
   for(i=1;i<=n;i++)
   {
     m[i][i]=0;
   }
   Vector<pair> v=new Vector<pair>();
   count=1;
   i=1;
   while(count<n)
   {
     j=i+count;
     while(j<=n)
     {
       for(k=i;k<j;k++)
       {
         temp=m[i][k]+m[k+1][j]+order[i]*order[k+1]*order[j+1];
         v.add(new pair(temp,k));
       }
       pair p=Collections.min(v);
       m[i][j]=p.val;
       s[i][j]=p.mini;
       v.clear();
       i++;
       j++;
     }
     i=1;
     count++;
   }
   System.out.println();
   System.out.println("Matrix formed:");
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=n;j++)
     {
       System.out.print(m[i][j]+" ");
     }
     System.out.println();
   }
   System.out.println();
   System.out.println("Minimum multiplication cost is = "+m[1][n]);
 }
}