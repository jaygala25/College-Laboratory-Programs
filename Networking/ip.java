import java.util.*;
class ip 
{
  static int validate(String s)
  {
    int dot=0,i;
    try
    {
      String a[]=s.split("\\.");
      int w=Integer.parseInt(a[0]);
      int x=Integer.parseInt(a[1]);
      int y=Integer.parseInt(a[2]);
      int z=Integer.parseInt(a[3]);
      if(a.length!=4)
      {
        return 0;
      }
      for(i=0;i<s.length();i++)
      {
        if(s.charAt(i)=='.')
        {
          dot++;
        }
      }
      if(dot!=3)
      {
        return 0;
      }
      if(w<0 || w>255 || x<0 || x>255 || y<0 || y>255 || z<0 || z>255)
      {
        return 0;
      }
    }
    catch(Exception e)
    {
      return 0;
    }
    return 1;
  }
  static void first_last(String a[],int sec[],int comp[])
  {
    int temp,i,z;
    System.out.print("First address is = ");
    for(i=0;i<4;i++)
    {
      temp=Integer.parseInt(a[i]);
      z=temp & sec[i];
      System.out.print(z);
      if(i<3)
      {
        System.out.print(".");
      }
    }
    System.out.println();
    System.out.print("Last address is = ");
    for(i=0;i<4;i++)
    {
      temp=Integer.parseInt(a[i]);
      z=temp | comp[i];
      System.out.print(z);
      if(i<3)
      {
        System.out.print(".");
      }
    }
  }
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter ip address = ");
    String s=new String();
    s=sc.next();
    int val=validate(s);
    if(val==0)
    {
      System.out.print("Invalid Input !");
    }
    else
    {
    String a[]=s.split("\\.");
    int ik=Integer.parseInt(a[0]);
    if(ik >= 0 && ik <= 126)
    {
      System.out.println("ip address belongs to class A");
      System.out.println("Default mask is 255.0.0.0");
      int sec[]={255,0,0,0};
      int comp[]={0,255,255,255};
      first_last(a,sec,comp);    
    }
    else
    if(ik >= 128 && ik <= 191)
    {
      System.out.println("ip address belongs to class B");
      System.out.println("Default mask is 255.255.0.0");
      int sec[]={255,255,0,0};
      int comp[]={0,0,255,255};
      first_last(a,sec,comp);
    }
    else 
    if(ik >= 192 && ik <= 223)
    {
      System.out.println("ip address belongs to class C");
      System.out.println("Default mask is 255.255.255.0");
      int sec[]={255,255,255,0};
      int comp[]={0,0,0,255};
      first_last(a,sec,comp);
    }
    else 
    if(ik >= 224 && ik <= 239)
    {
      System.out.print("ip address belongs to class D");
    }
    else 
    if(ik >= 240 && ik <= 255)
    {
      System.out.print("ip address belongs to class E");
    }
    }
  }
}