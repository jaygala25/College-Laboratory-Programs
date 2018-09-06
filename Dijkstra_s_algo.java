import java.util.*;
class Main
{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   int i,j;
   //Graph input starts
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
   //Graph input ends
   //Algorithm starts
   System.out.println();
   System.out.print("Enter Source: ");
   int source=sc.nextInt();
   System.out.println();
   System.out.println("Matrix formed");
   int ans[]=new int[n+1];
   int label[]=new int[n+1];
   System.out.print(source+" | ");
   for(i=1;i<=n;i++)
   {
     ans[i]=adj[source][i];
     label[i]=source;
     System.out.print(ans[i]+" ");
   }
   System.out.println();
   HashSet<Integer> h=new HashSet<Integer>();
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
         min=ans[j];
         index=j;
       }
     }
     h.add(index);
     for(j=1;j<=n;j++)
     {
       if(!h.contains(j))
       {
         if(min+adj[index][j]<ans[j])
         {
           ans[j]=min+adj[index][j];
           label[j]=index;
         }
       }
     }
     System.out.print(index+" | ");
     for(j=1;j<=n;j++)
     {
       System.out.print(ans[j]+" ");
     }
     System.out.println();
   }
   //algorithm ends
   System.out.println();
   Vector<Integer> v=new Vector<Integer>();
   System.out.println("To\tWeight\tShortest Path");
   for(i=1;i<=n;i++)
   {
     if(i==source)
     {
       continue;
     }
     System.out.print(i+"\t"+ans[i]+"\t");
     j=i;
     v.add(j);
     while(j!=source)
     {
       v.add(label[j]);
       j=label[j];
     }
     Collections.reverse(v);
     System.out.print(v);
     System.out.println();
     v.clear();
   }
 }
}