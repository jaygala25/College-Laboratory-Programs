import java.util.*;
class sema
{
  public static int w=0,rcount=0;
  public static StringBuilder str=new StringBuilder();
  public static void writer_waitt()
  {
    while(rcount!=0 || w!=0)
    {
      continue;
    }
    w=1;
  }
  public static void reader_waitt()
  {
    while(w!=0)
    {
      continue;
    }
    rcount++;
  }
  public static void writer_signal()
  {
    w=0;
  }
  public static void reader_signal()
  {
    rcount--;
  }
}
class read_write 
{
  public static void main(String[] args) 
  {
    writer w1=new writer(1);
    writer w2=new writer(2);
    reader r1=new reader(1);
    reader r2=new reader(2);
    Thread t1=new Thread(w1);
    Thread t2=new Thread(w2);
    Thread t3=new Thread(r1);
    Thread t4=new Thread(r2);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
class writer extends sema implements Runnable
{
  int no;
  writer(int j)
  {
    no=j;
  }
  public void run()
  {
    Random r=new Random();
    int i;
    while(true)
    {
      sema.writer_waitt();
      i=r.nextInt(10);
      str.append(i);
      System.out.println("Writer "+no+" wrote: "+str);
      sema.writer_signal();
      try
      {
        Thread.sleep(1000);
      }
      catch(Exception e)
      {

      }
    }
  }
}
class reader extends sema implements Runnable
{
  int no;
  reader(int j)
  {
    no=j;
  }
  public void run()
  {
    while(true)
    {
      sema.reader_waitt();
      System.out.println("Reader "+no+" read: "+str);
      sema.reader_signal();
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