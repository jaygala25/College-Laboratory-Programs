import java.util.*;
class Pair implements Comparable<Pair>
{
  int pro,dead;
  char label;
  Pair(char x,int y,int z)
  {
    label=x;
    pro=y;
    dead=z;
  }
  public int compareTo(Pair p)
  {
    if(this.pro-p.pro>0)
    {
      return 1;
    }
    else
    if(this.pro==p.pro)
    {
      return 0;
    }
    else
    {
      return -1;
    }
  }
}
class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter no. of jobs = ");
    int n=sc.nextInt();
    Vector<Pair> v=new Vector<Pair>();
    int max=0,a,b,i,j;
    char c;
    for(i=0;i<n;i++)
    {
      System.out.print("Enter job_id profit deadline of "+(i+1)+" job = ");
      c=sc.next().charAt(0);
      a=sc.nextInt();
      b=sc.nextInt();
      v.addElement(new Pair(c,a,b));
      if(max<b)
      {
        max=b;
      }
    }
    Collections.sort(v);
    char ch[]=new char[max+1];
    for(i=n-1;i>=0;i--)
    {
      Pair p1=v.elementAt(i);
      for(j=v.elementAt(i).dead;j>=1;j--)
      {
        if(ch[j]==0)
        {
          ch[j]=p1.label;
          break;
        }
      }
    }
    System.out.print("Following is maximum profit sequence of jobs: ");
    for(i=1;i<=max;i++)
    {
      if(ch[i]!=0)
      {
        System.out.print(ch[i]+" ");
      }
    }
  }
}