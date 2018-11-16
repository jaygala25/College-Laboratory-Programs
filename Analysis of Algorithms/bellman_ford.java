import java.util.*;
class Main
{
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter no. of vertices = ");
    int n=sc.nextInt();
    int adj[][]=new int[n+1][n+1];
    int ver[]=new int[n+1];
    int ans[][]=new int[n][n+1];
    int x,y,i,j,k;
    for(i=1;i<=n;i++)
    {
      Arrays.fill(adj[i],999);
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
    for(i=1;i<n;i++)
    {
      Arrays.fill(ans[i],999);
    }
    System.out.print("Enter source = ");
    int z=sc.nextInt();
    for(j=1;j<n;j++)
    {
      if(adj[z][j]!=999)
      {
        ans[1][j]=adj[z][j];
      }
      ans[j][z]=0;
    }
    Vector<Integer> v=new Vector<Integer>();
    for(i=2;i<n;i++)
    {
      for(j=1;j<=n;j++)
      {
        if(j==z)
        {
          continue;
        }
        v.addElement(ans[i-1][j]);
        for(k=1;k<=n;k++)
        {
          int w=ans[i-1][k]+adj[k][j];
          v.addElement(w);
        }
        ans[i][j]=Collections.min(v);
        v.clear();
      }
    }
    for(i=1;i<=n;i++)
    {
      System.out.print(i+"\t");
    }
    System.out.println();
    for(i=1;i<=n;i++)
    {
      System.out.print("-----\t");
    }
    System.out.println();
    for(i=1;i<n;i++)
    {
      for(j=1;j<=n;j++)
      {
        System.out.print(ans[i][j]+"\t");
      }
      System.out.println();
    }
  }
}