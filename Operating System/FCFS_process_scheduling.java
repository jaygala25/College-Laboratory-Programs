import java.util.*;
class FCFS 
{
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter Arrival and Burst time of Process 1: ");
    ArrayList<process> a=new ArrayList();
    ArrayList<Integer> gantt=new ArrayList();
    float t1=sc.nextFloat(),t2=sc.nextFloat();
    float tt1,tt2,wait_sum=0,tat_sum=0,wait_t,tat_t;
    float exe_sum=t2,fix=t1;
    System.out.println("Process 1 is executing");
    System.out.println("Ready Queue: "+a);
    System.out.println();
    gantt.add(1);
    int i=1,num=1,z=0;
    float cur=t1+1,w=0;
    char c;
    while(true)
    {
      System.out.print("Want to add more Processes? ");
      c=sc.next().charAt(0);
      if(c=='y')
      {
        System.out.print("Enter Arrival and Burst time of Process "+(++i)+": ");
        tt1=sc.nextFloat();
        tt2=sc.nextFloat();
        exe_sum+=tt2;
        if(exe_sum-tt1-tt2+fix>=0)
        {
          a.add(new process(i,tt1,tt2,exe_sum-tt1-tt2+fix,0));
        }
        else
        {
          a.add(new process(i,tt1,tt2,0,0));
        }
      }
      if(cur>=t1+t2+w)
      {
        if(a.size()==0)
        {
          tat_t=cur-t1;
          wait_t=tat_t-t2;
          wait_sum+=wait_t;
          tat_sum+=tat_t;
          System.out.println("TAT and Waiting Time of process "+num+": "+tat_t+" "+wait_t);
          break;
        }
        System.out.println("Process "+a.get(0).pid+" is executing");
        num=a.get(0).pid;
        gantt.add(a.get(0).pid);
        tat_t=cur-t1;
        wait_t=tat_t-t2;
        wait_sum+=wait_t;
        tat_sum+=tat_t;
        System.out.println("TAT and Waiting Time of process "+(a.get(0).pid-1)+": "+tat_t+" "+wait_t);
        t1=a.get(0).arr;
        t2=a.get(0).exe;
        w=a.get(0).wait;
        a.remove(0);
      }
      else
      {
        if(a.size()==0)
        {
          z=num;
        }
        else
        {
          z=a.get(0).pid-1;
        }
        System.out.println("Process "+z+" is executing");
        gantt.add(z);
      }
      System.out.println("Ready Queue = "+a);
      System.out.println();
      cur++;
    }
    System.out.println();
    System.out.println("Average Waiting time is = "+wait_sum/i);
    System.out.println("Average TAT time is = "+tat_sum/i);
    System.out.println("Gantt chart: "+gantt);
  }
}
class process 
{
  int pid;
  float arr,exe,wait,tat;
  process(int a,float b,float c,float d,float e)
  {
    pid=a;
    arr=b;
    exe=c;
    wait=d;
    tat=e;
  }
  public String toString()
  {
    return String.valueOf(pid);
  }
}