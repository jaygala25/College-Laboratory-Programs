import java.util.*;
class Main 
{
  static HashSet<Integer> h=new HashSet();
  static LinkedList<Integer> l=new LinkedList();
  static void dfs(int node,int adj[][],int n)
  {
    int i;
    System.out.print(node+" ");
    h.add(node);
    for(i=0;i<n;i++)
    {
      if(adj[node][i]==1 && !h.contains(i))
      {
        dfs(i,adj,n);
      }
    }
  }
  static void bfs(int node,int adj[][],int n)
  {
    int i;
    while(true)
    {
      System.out.print(node+" ");
      h.add(node);
      if(h.size()==n) break;
      for(i=0;i<n;i++)
      {
        if(adj[node][i]==1 && !h.contains(i) && !l.contains(i))
        {
          l.add(i);
        }
      }
      node=l.getFirst();
      l.removeFirst();
    }
  }
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter no. of nodes = ");
    int n=sc.nextInt(),i,j;
    System.out.println("Enter Adjacency Matrix:");
    int adj[][]=new int[n][n];
    for(i=0;i<n;i++)
    {
      for(j=0;j<n;j++)
      {
        adj[i][j]=sc.nextInt();
      }
    }
    System.out.print("Enter starting node = ");
    int start=sc.nextInt();
    System.out.print("1.DFS\n2.BFS\n");
    System.out.print("Enter option = ");
    int opt=sc.nextInt();
    if(opt==1)
    {
      dfs(start,adj,n);
    }
    else
    {
      bfs(start,adj,n);
    }
  }
}