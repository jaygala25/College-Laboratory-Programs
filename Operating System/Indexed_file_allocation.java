import java.util.*;
class table
{
  String name;
  int index;
  table(String abb,int b)
  {
    name=abb;
    index=b;
  }
}
class indexed
{
  static int a[],n,block_size,i,j;
  static ArrayList<table> al;
  static LinkedList<Integer> l;
  static HashMap<Integer,ArrayList<Integer>> h;

  static void insert(String x,int y)
  {
    String na=x;
    int size=y,t;
    int no_of_blocks=(int)Math.ceil((double)size/block_size);
    ArrayList<Integer> array=new ArrayList<Integer>();
    if(l.size()>=no_of_blocks+1)
    {
      t=l.get(0);
      a[t]=1;
      l.removeFirst();
      for(i=1;i<=no_of_blocks;i++)
      {
        array.add(l.get(0));
        a[l.get(0)]=1;
        l.removeFirst();
      }
      h.put(t,array);
      al.add(new table(na,t));
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
    System.out.println("Name\t"+"Index Block");
    for(i=0;i<al.size();i++)
    {
      System.out.println(al.get(i).name+"\t"+al.get(i).index);
    }
    System.out.println();
    for(Integer var: h.keySet())
    {
      System.out.println("Index block at "+var+": "+h.get(var));
    }
    System.out.println();
  }

  static void delete(String ab)
  {
    String na=ab;
    int f=0,i,ind=0;
    for(i=0;i<al.size();i++)
    {
      if(al.get(i).name.equals(na))
      {
        ind=al.get(i).index;
        f=1;
        al.remove(i);
        break;
      }
    }
    if(f==1)
    {
      l.add(ind);
      ArrayList<Integer> all=h.get(ind);
      for(i=0;i<all.size();i++)
      {
        l.add(all.get(i));
      }
      h.remove(ind);
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
    h=new HashMap<Integer,ArrayList<Integer>>();
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