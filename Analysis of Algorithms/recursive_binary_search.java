import java.util.*;
class recursive_binary 
{
  public static int binary(int l,int u,int a[],int b)
  {
    if(l<=u)
    {
      int mid=(l+u)/2;
      if(a[mid]==b)
      {
        return mid;
      }
      else
      if(a[mid]>b)
      {
        return binary(l,mid-1,a,b);
      }
      else
      {
        return binary(mid+1,u,a,b);
      }
    }
    else
    {
      return -1;
    }
  }
  public static void main(String[] args) 
  {
    Scanner s=new Scanner(System.in);
    System.out.print("Enter size = ");
    int n=s.nextInt();
    System.out.print("Enter array elements = ");
    int a[]=new int[n];
    for(int i=0;i<n;i++)
    {
      a[i]=s.nextInt();
    }
    System.out.print("Enter element to be searched = ");
    int b=s.nextInt();
    Arrays.sort(a);
    int x=binary(0,n-1,a,b);
    if(x==-1)
    {
      System.out.println("Element not found");
    }
    else
    {
      System.out.println("Element found at index "+x);
    }
  }
}