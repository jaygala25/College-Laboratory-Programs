import java.util.*;
class Bankers 
{
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter number of processes = ");
    int m=sc.nextInt(),i,j;
    System.out.print("Enter number of different types of resources available = ");
    int n=sc.nextInt(),temp=0;
    ArrayList<Integer> seq=new ArrayList<Integer>();
    HashSet<Integer> h=new HashSet<Integer>();
    int alloc[][]=new int[m][n];
    int max[][]=new int[m][n];
    int need[][]=new int[m][n];
    int res[]=new int[n];
    int sum[]=new int[n];
    int avail[]=new int[n];
    System.out.println("Enter Corresponding number of resources allocated: ");
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        alloc[i][j]=sc.nextInt();
        sum[j]+=alloc[i][j];
      }
    }
    System.out.println("Enter maximum number of resouces required: ");
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        max[i][j]=sc.nextInt();
        need[i][j]=max[i][j]-alloc[i][j];
      }
    }
    System.out.print("Enter Resource Vector: ");
    for(i=0;i<n;i++)
    {
      res[i]=sc.nextInt();
    }
    System.out.println();
    System.out.print("Available Vector: ");
    for(i=0;i<n;i++)
    {
      avail[i]=res[i]-sum[i];
      System.out.print(avail[i]+" ");
    }
    System.out.println();
    System.out.println();
    System.out.println("Need Matrix is: ");
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        System.out.print(need[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();

    i=0;
    int count=0,f=0;
    while(seq.size()<m)
    {
      while(h.contains(i))
      {
        i++;
      }
      if(i>=m)
      {
        i=0;
        if(seq.size()==0 || seq.size()==temp)
        {
          System.out.println("Unsafe State");
          f=1;
          break;
        }
        temp=seq.size();
      }
      count=0;
      for(j=0;j<n;j++)
      {
        if(need[i][j]<=avail[j])
        {
          count++;
        }
      }
      if(count==n)
      {
        seq.add(i);
        h.add(i);
        for(j=0;j<n;j++)
        {
          avail[j]+=alloc[i][j];
        }
        System.out.println("Need <= Availability");
        System.out.println("Execute Process "+i);
        System.out.print("New Availability: ");
        for(j=0;j<n;j++)
        {
          System.out.print(avail[j]+" ");
        }
        System.out.println();
      }
      else
      {
        System.out.println("Need > Availability");
        System.out.println("Do not execute process "+i);
      }
      System.out.println();
      i++;
    }
    if(f==0)
    {
      System.out.println("Safe State");
      System.out.print("Safe Sequence is: "+seq);
    }
  }
}