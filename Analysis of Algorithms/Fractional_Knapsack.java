import java.util.*;
class Pair implements Comparable<Pair>
{
  double first,second;
  Pair(double x,double y)
  {
    first=x;
    second=y;
  }
  public int compareTo(Pair p)
  {
    if(this.first-p.first>0)
    {
      return 1;
    }
    else
    if(this.first==p.first)
    {
      return 0;
    }
    else
    {
      return -1;
    }
  }
  /*public String toString()
  {
    return "f "+first+" s "+second;
  }*/
}
public class Main 
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int n,i;
    double s=0,w;
    System.out.print("Enter no. of weights = ");
    n=sc.nextInt();
    System.out.print("Enter weights = ");
    double a[]=new double[n];
    double p[]=new double[n];
    for(i=0;i<n;i++)
    {
      a[i]=sc.nextDouble();
    }
    System.out.print("Enter profits = ");
    for(i=0;i<n;i++)
    {
      p[i]=sc.nextDouble();
    }
    System.out.print("Enter Max weight = ");
    w=sc.nextDouble();
    Vector<Pair> v=new Vector<Pair>();
    for(i=0;i<n;i++)
    {
      v.addElement(new Pair(p[i]/a[i],a[i]));
    }
    Collections.sort(v);
    //System.out.println(v);
    System.out.println("Weight\tProfit");
    for(i=n-1;i>=0;i--)
    {
      Pair p1=v.elementAt(i);
      if(p1.second<=w)
      {
        s=s+p1.first*p1.second;
        w=w-p1.second;
        System.out.println(p1.second+"\t"+(p1.second*p1.first));
      }
      else
      {
        s=s+p1.first*w;
        System.out.println(p1.second+"\t"+(p1.first*w));
        break;
      }
    }
    System.out.print("Max profit is = "+s);
  }
}