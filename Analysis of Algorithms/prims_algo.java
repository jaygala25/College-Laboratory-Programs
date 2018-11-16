import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   int i,j;
   System.out.print("Enter no. of vertices = ");
   int n=sc.nextInt();
   int adj[][]=new int[n+1][n+1];
   System.out.println("Enter Adjacency Matrix:");
   for(i=1;i<=n;i++)
   {
     for(j=1;j<=n;j++)
     {
       adj[i][j]=sc.nextInt();
     }
   }
   int source=1;
   int ans[]=new int[n+1];
   int label[]=new int[n+1];
   for(i=1;i<=n;i++)
   {
     ans[i]=adj[source][i];
     label[i]=source;
   }
   HashSet<Integer> h=new HashSet<Integer>();
   HashSet<String> mst=new HashSet<String>();
   h.add(source);
   int min,index;
   for(i=2;i<=n;i++)
   {
     min=Integer.MAX_VALUE;
     index=Integer.MAX_VALUE;
     for(j=1;j<=n;j++)
     {
       if(min>ans[j] && !h.contains(j))
       {
         mst.add(j+"-"+label[j]);
         min=ans[j];
         index=j;
       }
     }
     h.add(index);
     for(j=1;j<=n;j++)
     {
       if(!h.contains(j))
       {
         if(adj[index][j]<ans[j])
         {
           ans[j]=adj[index][j];
           label[j]=index;
         }
       }
     }
   }
   int s=0;
   for(i=1;i<=n;i++)
   {
     s=s+ans[i];
   }
   System.out.println("Minimum cost is = "+s);
   System.out.println("Edges included = "+mst);
   System.out.print("Corresponding weights included = ");
   for(i=2;i<=n;i++)
   {
     System.out.print(ans[i]+" ");
   }
 }
}