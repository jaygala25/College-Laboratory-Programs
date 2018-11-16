import java.util.*;
class LOOK 
{
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> a=new ArrayList<Integer>();
    ArrayList<Integer> seq=new ArrayList<Integer>();
    System.out.print("Enter total number of tracks = ");
    int n=sc.nextInt();
    System.out.print("Enter initial head position = ");
    int j=sc.nextInt(),i,inp;
    while(j<0 || j>=n)
    {
      System.out.print("Enter valid head position = ");
      j=sc.nextInt();
    }
    int sum=0;
    System.out.print("Enter no. of jobs = ");
    int m=sc.nextInt();
    while(m<0 || m>n)
    {
      System.out.print("Enter valid no. of jobs = ");
      m=sc.nextInt();
    }
    for(i=0;i<m;i++)
    {
      System.out.print("Enter valid track number = ");
      inp=sc.nextInt();
      if(inp>=0 && inp<n)
      {
        a.add(inp);
      }
      else
      {
        System.out.println("Invalid Input");
        i--;
      }
    }
    Collections.sort(a);
    System.out.println();
    int val=0,index=0;
    for(i=0;i<a.size();i++)
    {
      if(a.get(i)>=j)
      {
        val=a.get(i);
        index=i;
        break;        
      }
    }
    for(i=index;i<a.size();)
    {
      System.out.println("Head Position: "+a.get(i));
      seq.add(a.get(i));
      sum+=Math.abs(j-a.get(i));
      j=a.get(i);
      a.remove(i);
    }
    for(i=a.size()-1;a.size()>0;i--)
    {
      System.out.println("Head Position: "+a.get(i));
      seq.add(a.get(i));
      sum+=Math.abs(j-a.get(i));
      j=a.get(i);
      a.remove(i);
    }
    System.out.println("Sequence is: "+seq);
    double avg=(double)sum/seq.size();
    System.out.println("Total seek length = "+sum);
    System.out.println("Average seek length = "+avg);
  }
}