import java.util.*;
class FIFO 
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
    int sum=j;
    for(i=0;i<5;i++)
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
    System.out.println("Head Position: "+a.get(0));
    seq.add(a.get(0));
    sum=Math.abs(j-a.get(0));
    j=a.get(0);
    a.remove(0);
    System.out.println("Queue = "+a);
    System.out.println();
    while(a.size()!=0)
    {
      System.out.print("Do you want to add job = ");
      char c=sc.next().charAt(0);
      if(c=='y')
      {
        System.out.print("Enter track number = ");
        inp=sc.nextInt();
        while(inp<0 || inp>=n)
        {
          System.out.print("Enter valid track number = ");
          inp=sc.nextInt();
        }
        a.add(inp);
      }
      System.out.println("Head Position: "+a.get(0));
      seq.add(a.get(0));
      sum+=Math.abs(j-a.get(0));
      j=a.get(0);
      a.remove(0);
      System.out.println("Queue = "+a);
      System.out.println();
    }
    System.out.println("Sequence is: "+seq);
    double avg=sum/seq.size();
    System.out.println("Total seek length = "+sum);
    System.out.println("Average seek length = "+avg);
  }
}