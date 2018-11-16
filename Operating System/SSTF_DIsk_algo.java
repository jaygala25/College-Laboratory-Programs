import java.util.*;
class SSTF 
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
    int index=0,temp,k=j;
    int min=Math.abs(j-a.get(0));
    for(i=0;i<a.size();i++)
    {
        temp=Math.abs(k-a.get(i));
        if(min>=temp)
        {
          if(k-a.get(i)>=0)
          {
            j=k-temp;
          }
          else
          { 
            j=temp+k;
          }
          //System.out.println(j);
          min=temp;
          index=i;
        }
    }
    System.out.println("Head Position: "+j);
    seq.add(j);
    int sum=min;
    a.remove(index);
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
      k=j;
      index=0;
      min=Math.abs(j-a.get(0));
      for(i=0;i<a.size();i++)
      {
          temp=Math.abs(k-a.get(i));
          if(min>=temp)
          {
            if(k-a.get(i)>=0)
            {
              j=k-temp;
            }
            else
            { 
              j=temp+k;
            }
            min=temp;
            index=i;
          }
      }
      System.out.println("Head Position: "+j);
      seq.add(j);
      sum+=min;
      //System.out.println(min);
      a.remove(index);
      System.out.println("Queue = "+a);
      System.out.println();
    }
    System.out.println("Sequence is: "+seq);
    double avg=(double)sum/seq.size();
    System.out.println("Total seek length = "+sum);
    System.out.println("Average seek length = "+avg);
  }
}