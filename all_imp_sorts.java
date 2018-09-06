import java.util.*; 
class Main 
{
  static int temp[],n;
  static void display(int a[],int n)
  {
    for(int i=0;i<n;i++)
    {
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }
  static void bubble(int a[],int n)
  {
    int i,j,flag,temp;
    for(i=0;i<n;i++)
    {
      flag=0;
      for(j=0;j<n-i-1;j++)
      {
        if(a[j+1]<a[j])
        {
          flag=1;
          temp=a[j+1];
          a[j+1]=a[j];
          a[j]=temp;
        }
      }
      display(a,n);
      if(flag==0)
      {
        break;
      }
    }
  }
  static void insert(int a[],int n)
  {
    int i,j,temp;
    for(i=1;i<n;i++)
    {
      temp=a[i];
      j=i-1;
      while(j>=0 && a[j]>temp)
      {
        a[j+1]=a[j];
        j--;
      }
      a[j+1]=temp;
      display(a,n);
    }
  }
  static void select(int a[],int n)
  {
    int i,j,temp,min,index;
    for(i=0;i<n;i++)
    {
      min=a[i];
      index=i;
      for(j=i+1;j<n;j++)
      {
        if(min>a[j])
        {
          min=a[j];
          index=j;
        }
      }
      temp=a[i];
      a[i]=a[index];
      a[index]=temp;
      display(a,n);
    }
  }
  static int partition(int a[],int l,int h) 
  {
    int pivot=a[l],i=l,j=h,temp; //first element as pivot 
    while(i<j)
    {
      while(a[i]<=pivot && i<h)
      {
        i++;
      }
      while(a[j]>pivot && j>l)
      {
        j--;
      }
      if(i<j)
      {
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
      }
    }
    temp=a[l];
    a[l]=a[j];
    a[j]=temp;
    return j;
  }
  static void quick(int a[],int l,int h)
  {
    if(l<h)
    {
      int p=partition(a,l,h);
      display(a,n);
      quick(a,l,p-1);
      quick(a,p+1,h);
    }
  }
  static void merge(int a[],int l,int mid,int h)
  {
    int i=l,j=mid+1,k=l;
    while(i<=mid && j<=h)
    {
      if(a[i]<=a[j])
      {
        temp[k++]=a[i++];
      }
      else
      {
        temp[k++]=a[j++];
      }
    }
    while(i<=mid)
    {
      temp[k++]=a[i++];
    }
    while(j<=h)
    {
      temp[k++]=a[j++];
    }
    for(i=l;i<k;i++)
    {
      a[i]=temp[i];
    }
  }
  static void mergesort(int a[],int l,int h)
  {
    if(l<h)
    {
      int mid=(l+h)/2;
      mergesort(a,l,mid);
      mergesort(a,mid+1,h);
      merge(a,l,mid,h);
      display(a,n);
    }
  }
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("1. Bubble\n2. Insertion\n3. Selection\n4. Quick\n5. Merge");
    System.out.print("Enter total no. of numbers = ");
    n=sc.nextInt();
    int i;
    int a[]=new int[n];
    temp=new int[n];
    System.out.print("Enter numbers = ");
    for(i=0;i<n;i++)
    {
      a[i]=sc.nextInt();
    }
    System.out.print("Select sorting algo = ");
    int opt=sc.nextInt();
    System.out.println("Intermediate Steps:");
    switch(opt)
    {
      case 1:bubble(a,n);break;
      case 2:insert(a,n);break;
      case 3:select(a,n);break;
      case 4:quick(a,0,n-1);break;
      case 5:mergesort(a,0,n-1);break;
    }
  }
}