import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   //Graph input starts
   System.out.print("Enter no. of vertices = ");
   int n=sc.nextInt();
   int adj[][]=new int[n+1][n+1];
   int ver[]=new int[n+1];
   int x,y,i,j,k,INF=99999;
   for(i=1;i<=n;i++)
   {
     Arrays.fill(adj[i],INF);
     adj[i][i]=0;
   }
   for(i=1;i<=n;i++)
   {
     System.out.print("Enter no. of neighbors of "+i+": ");
     ver[i]=sc.nextInt();
   }
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=ver[i];j++)
     {
       System.out.print("Enter neighbor and weight of vertex "+i+": ");
       x=sc.nextInt();
       y=sc.nextInt();
       adj[i][x]=y;
     }
   }
   //Graph input ends
   //Actual Algorihm starts
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=n;j++)
     {
       for(k=1;k<=n;k++)
       {
         adj[j][k]=Math.min(adj[j][i]+adj[i][k],adj[j][k]);
       }
     }
   }
   //Algorithm ends
   System.out.println("All  Pair SHortest Path is:");
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=n;j++)
     {
       if(adj[i][j]==INF)
       {
         System.out.print("INF ");
       }
       else
       {
         System.out.print(adj[i][j]+" ");
       }
     }
     System.out.println();
   }
 }
}