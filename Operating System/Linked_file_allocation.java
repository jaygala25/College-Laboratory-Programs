import java.util.*;
class table
{
  String name;
  int start,end;
  table(String abb,int b,int c)
  {
    name=abb;
    start=b;
    end=c;
  }
}
class Main
{
  static int a[],n,block_size,i,j;
  static ArrayList<table> al;
  static LinkedList<Integer> l;

  static void insert(String x,int y)
  {
    String na=x;
    int size=y,temp,t;
    int no_of_blocks=(int)Math.ceil((double)size/block_size);
    if(l.size()>=no_of_blocks)
    {
      t=l.getFirst();
      temp=t;
      l.removeFirst();
      for(i=1;i<no_of_blocks;i++)
      {
        a[t]=l.getFirst();
        t=l.getFirst();
        l.removeFirst();
      }
      a[t]=-1;
      al.add(new table(na,temp,t));
      display();
    }
    else
    {
      System.out.println("Disk don't have space to insert file");
      System.out.println();
    }
  }

  static void display()
  {
    System.out.println();
    System.out.println("Name\t"+"start\t"+"End");
    for(i=0;i<al.size();i++)
    {
      System.out.println(al.get(i).name+"\t"+al.get(i).start+"\t"+al.get(i).end);
    }
    System.out.println();
  }

  static void delete(String ab)
  {
    String na=ab;
    int i,f=0,star=0,en;
    for(i=0;i<al.size();i++)
    {
      if(al.get(i).name.equals(na))
      {
        star=al.get(i).start;
        en=al.get(i).end;
        al.remove(i);
        f=1;
        break;
      }
    }
    if(f==1)
    {
      while(star!=-1)
      {
        l.add(star);
        star=a[star];
      }
      System.out.println("File deleted successfully");
      display();
    }
    else
    {
      System.out.println("File not found");
      System.out.println();
    }
  }

  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    
    System.out.print("Enter total number of blocks in the disk = ");
    n=sc.nextInt();
    a=new int[n];

    al=new ArrayList<table>();
    l=new LinkedList<Integer>();
    for(i=0;i<n;i++)
    {
      l.add(i);
    }

    System.out.print("Enter size of each block = ");
    block_size=sc.nextInt();
    System.out.println();
    
    System.out.print("Enter file name and size = ");
    String nam=sc.next();
    int file_size=sc.nextInt();
    
    insert(nam,file_size);

    System.out.println();
    System.out.println("1. Insert\n2. Delete\n3. Exit\n");
    
    while(true)
    {
      System.out.print("Enter option = ");
      int option=sc.nextInt();
      switch(option)
      {
        case 1:
          System.out.print("Enter file name and size = ");
          nam=sc.next();
          file_size=sc.nextInt();
          insert(nam,file_size);
          break;
        
        case 2:
          System.out.print("Enter file name = ");
          nam=sc.next();
          delete(nam);
          break;

        case 3:
          System.exit(0);
      }
    }

  }
}