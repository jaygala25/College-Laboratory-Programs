import java.util.*;
class SRTN 
{
  static ArrayList<Integer> tp;
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter Arrival and Burst time of 1st process: ");
    tp=new ArrayList();
    ArrayList<process> a=new ArrayList();
    ArrayList<Integer> gantt=new ArrayList();
    float t1=sc.nextFloat(),t2=sc.nextFloat(),wait_sum=0,tat_sum=0,tt1,tt2,tat_t,wait_t;
    a.add(new process(1,t1,t2-1,0,t2-t1,t2));
    System.out.println("Process 1 is executing");
    ArrayList<Integer> abd=proc(a);
    System.out.println("Ready Queue: "+abd);
    System.out.println();
    gantt.add(1);
    int i=1;
    float cur=t1+1;
    char c;
    while(true)
    {
      System.out.print("Want to add more processes? ");
      c=sc.next().charAt(0);
      if(c=='y')
      {
        System.out.print("Enter Arrival and Burst time of Process "+(++i)+": ");
        tt1=sc.nextFloat();
        tt2=sc.nextFloat();
        a.add(new process(i,tt1,tt2,0,0,tt2));
        Collections.sort(a);
      }
      process pro=a.get(0);
      if(pro.exe==0)
      {
        if(a.size()==1)
        {
          tat_t=cur-pro.arr;
          wait_t=tat_t-pro.ex;
          wait_sum+=wait_t;
          tat_sum+=tat_t;
          System.out.println("TAT and waiting time of process "+(pro.pid)+": "+tat_t+" "+wait_t);
          break;
        }
        System.out.println("Process "+a.get(1).pid+" is executing");
        gantt.add(a.get(1).pid);
        tat_t=cur-pro.arr;
        wait_t=tat_t-pro.ex;
        wait_sum+=wait_t;
        tat_sum+=tat_t;
        System.out.println("TAT and waiting time of process "+(pro.pid)+": "+tat_t+" "+wait_t);
        a.remove(0);
      }
      else
      {
        System.out.println("Process "+a.get(0).pid+" is executing");
        gantt.add(a.get(0).pid);
      }
      abd=proc(a);
      System.out.println("Ready Queue = "+abd);
      System.out.println();
      cur++;
      a.get(0).exe--;
    }
    System.out.println();
    System.out.println("Average Waiting time is = "+wait_sum/i);
    System.out.println("Average TAT time is = "+tat_sum/i);
    System.out.println("Gantt chart: "+gantt);
  }
  public static ArrayList proc(ArrayList<process> x)
  {
    tp.clear();
    for(int i=1;i<x.size();i++)
    {
      tp.add(x.get(i).pid);
    }
    return tp;
  }
}
class process implements Comparable<process>
{
  int pid;
  float arr,exe,wait,tat,ex;
  process(int a,float b,float c,float d,float e,float f)
  {
    pid=a;
    arr=b;
    exe=c;
    wait=d;
    tat=e;
    ex=f;
  }
  public int compareTo(process p)
  {
    return (int)this.exe - (int)p.exe;
  }
}