import java.util.*;
class table
{
  String name;
  int start,length;
  table(String abb,int b,int c)
  {
    name=abb;
    start=b;
    length=c;
  }
}
class Sequential
{
  static int a[],n,block_size,i,j;
  static ArrayList<table> al;

  static void insert(String x,int y)
  {
    String na=x;
    int size=y,f=0,count=0;
    int no_of_blocks=(int)Math.ceil((double)size/block_size);
    for(i=0;i<n;i++)
    {
      if(a[i]==0)
      {
        count=0;
        for(j=i;j<n;j++)
        {
          if(a[j]==0)
          {
            count++;
          }
          else
          {
            break;
          }
        }
        //System.out.println(count);
        if(count>=no_of_blocks)
        {
          for(j=i;j<i+no_of_blocks;j++)
          {
            a[j]=1;
          }
          f=1;
          al.add(new table(na,i,no_of_blocks));
          display();
        }
        if(f==1)
        {
          break;
        }
      }
    }
    if(f==0)
    {
      System.out.println("Disk don't have space to insert the file");
      System.out.println();
    }
  }

  static void display()
  {
    System.out.println();
    System.out.println("Name\t"+"start\t"+"Length");
    for(i=0;i<al.size();i++)
    {
      System.out.println(al.get(i).name+"\t"+al.get(i).start+"\t"+al.get(i).length);
    }
    System.out.println();
  }

  static void delete(String ab)
  {
    String na=ab;
    int i,star=0,len=0,f=0;
    for(i=0;i<al.size();i++)
    {
      if(al.get(i).name.equals(na))
      {
        star=al.get(i).start;
        len=al.get(i).length;
        al.remove(i);
        f=1;
        break;
      }
    }
    if(f==1)
    {
      for(i=star;i<len+star;i++)
      {
        a[i]=0;
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