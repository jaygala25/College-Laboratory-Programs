#include<stdio.h>
#include<stdlib.h>
void insert(int a[],int pt)
{
  int j,temp;
  for(j=pt;j!=1;j=j/2)
  {
    if(a[j]>a[j/2])
    {
      temp=a[j];
      a[j]=a[j/2];
      a[j/2]=temp;
    }
  }
}
int del(int a[],int pt)
{
  int i,temp,k;
  k=a[1]=a[pt];
  a[pt]=0;
  pt--;
  for(i=1;i<=pt;)
  {
    if(k<a[2*i] || k<a[2*i+1])
    {
      if(a[2*i]>a[(2*i)+1])
      {
        temp=a[i];
        a[i]=a[2*i];
        a[2*i]=temp;
        i=2*i;
      }
      else
      {
        temp=a[i];
        a[i]=a[(2*i)+1];
        a[(2*i)+1]=temp;
        i=(2*i)+1;
      }
    }
    else break;
  }
  return pt;
}
void display(int a[],int pt)
{
  int k;
  for(k=1;k<=pt;k++)
  {
    printf("%d ",a[k]);
  }
}
int main()
{
  int a[21]={0},i,n,pt=0,b,f;
  printf("Enter no. of values = ");
  scanf("%d",&n);
  printf("Enter values = ");
  for(i=1;i<=n;i++)
  {
    scanf("%d",&a[++pt]);
    insert(a,pt);
  }
  display(a,pt);
  printf("\n1. Insert\n2. Delete\n3. Exit");
  while(1)
  {
    printf("\nEnter Operation = ");
    scanf("%d",&b);
    switch(b)
    {
      case 1:
      printf("Enter value = ");
      scanf("%d",&a[++pt]);
      insert(a,pt);
      display(a,pt);
      break;
      case 2:
      f=del(a,pt);
      pt=f;
      display(a,pt);
      break;
      case 3:
      exit(0);
      default:
      printf("Invalid Operation");
    }
  }
  return 0;
}
