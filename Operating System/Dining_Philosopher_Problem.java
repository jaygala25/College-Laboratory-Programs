import java.util.*;
class sema 
{
  static int s[]=new int[5];
  static void wait(int a)
  {
    if(s[a]==0)
    {
      s[a]=1;
    }
    else
    {
      while(s[a]!=0)
      {
        continue;
      }
      s[a]=1;
    }
  }
  static void signal(int a)
  {
    s[a]=0;
  }
}
class Main 
{
  public static void main(String[] args) 
  {
    philo p0=new philo(0);
    philo p1=new philo(1);
    philo p2=new philo(2);
    philo p3=new philo(3);
    philo1 p4=new philo1(4);
    Thread t0=new Thread(p0);
    Thread t1=new Thread(p1);
    Thread t2=new Thread(p2);
    Thread t3=new Thread(p3);
    Thread t4=new Thread(p4);
    t0.start();
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
class philo extends sema implements Runnable 
{
  int no;
  philo(int a)
  {
    no=a;
  }
  public void run()
  {
	while(true)
	{
      System.out.println("Philo "+no+" is thinking");
      try
      {
        Thread.sleep(2000);
      }
      catch(Exception e)
      {

      }
      sema.wait(no);
      sema.wait(no+1);
      System.out.println("Philo "+no+" is eating with spoons "+no+" & "+(no+1));
      sema.signal(no);
      sema.signal(no+1);
	}
  }
}
class philo1 extends sema implements Runnable 
{
  int no;
  philo1(int a)
  {
    no=a;
  }
  public void run()
  {
	while(true)
	{
      System.out.println("Philo "+no+" is thinking");
      try
      {
        Thread.sleep(2000);
      }
      catch(Exception e)
      {
        
      }
      sema.wait(0);
      sema.wait(4);
      System.out.println("Philo "+no+" is eating with spoons 0 & 4");
      sema.signal(4);
      sema.signal(0);
	}
  }
}