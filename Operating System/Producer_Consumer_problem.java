import java.util.*;
class sema
{
  public static int flag=0;
  public static ArrayList<Integer> buf=new ArrayList();
  public static void waitt()
  {
    while(flag!=0)
    {
      continue;
    }
    flag=1;
  }
  public static void signal()
  {
    flag=0;
  }
}
class Pros_Cons 
{
  public static void main(String[] args) 
  {
    producer p1=new producer(1);
    producer p2=new producer(2);
    Thread t1=new Thread(p1);
    Thread t2=new Thread(p2);
    consumer c1=new consumer(1);
    consumer c2=new consumer(2);
    Thread t3=new Thread(c1);
    Thread t4=new Thread(c2);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
class producer extends sema implements Runnable
{
  int no;
  producer(int j)
  {
    no=j;
  }
  public void run()
  {
    Random r=new Random();
    int i;
    while(true)
    {
      sema.waitt();
      if(buf.size()==15)
      {
        System.out.println("Producer waiting for consumer to consume");
      }
      else
      {
        i=r.nextInt(10);
        buf.add(i);
        System.out.println("Producer "+no+" Produced: "+i);
      }
      sema.signal();
      try
      {
        Thread.sleep(800);
      }
      catch(Exception e)
      {

      }
    }
  }
}
class consumer extends sema implements Runnable
{
  int no;
  consumer(int j)
  {
    no=j;
  }
  public void run()
  {
    while(true)
    {
      sema.waitt();
      if(buf.size()==0)
      {
        System.out.println("Consumer waiting for producer to produce");
      }
      else
      {
        System.out.println("Consumer "+no+" consumed: "+buf.get(0));
        buf.remove(0);
      }
      sema.signal();
      try
      {
        Thread.sleep(2000);
      }
      catch(Exception e)
      {
        
      }
    }
  }
}