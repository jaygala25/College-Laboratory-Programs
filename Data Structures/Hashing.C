#include<stdio.h>
void lp(int htl[],int a[],int n)
{
	int i,j,h;
	for(i=0;i<10;i++)
	{
		htl[i]=-1;
	}
	for(i=0;i<n;i++)
	{
		for(j=0;j<10;j++)
		{
			h=(a[i]%10+j)%10;
			if(htl[h]==-1)
			{
				htl[h]=a[i];
				break;
			}
		}
	}
}
void qp(int htq[],int a[],int n)
{
	int i,j,c1,c2,h;
	for(i=0;i<10;i++)
	{
		htq[i]=-1;
	}
	printf("Enter values of c1 and c2 = ");
	scanf("%d %d",&c1,&c2);
	for(i=0;i<n;i++)
	{
		for(j=0;j<10;j++)
		{
			h=((a[i]%10)+(c1*j)+(c2*j*j))%10;
			if(htq[h]==-1)
			{
				htq[h]=a[i];
				break;
			}
		}
	}
}
void search(int ht[])
{
  int x,i;
  printf("Enter Key to Search = ");
  scanf("%d",&x);
  int h=x%10;
  if(ht[h]==x)
  {
    printf("Key found at index %d",h);
  }
  else
  if(ht[h]==-1)
  {
    printf("Key not found");
  }
  else
  {
    int f=0;
    for(i=h+1;i<10;i++)
    {
      if(ht[i]==x)
      {
        printf("Key found at index %d",i);
        f=1;
        break;
      }
      else
      if(ht[i]==-1)
      {
        printf("Key not found");
        f=1;
        break;
      }
    }
    if(f==0)
    {
      printf("Key not found");
    }
  }
}
void display(int ht[])
{
	int i;
	printf("Elements of hashtable are = ");
	for(i=0;i<10;i++)
	{
		printf("%d ",ht[i]);
	}
}
int main()
{
	int htl[10],htq[10],a[10]={0},n,i,b;
	printf("Enter no. of keys = ");
	scanf("%d",&n);
	printf("Enter keys = ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("1.Linear Probing Insertion\n2.Quadratic Probing Insertion\n3.Search in linear probing\n4.Search in quadratic probing\n5.Exit");
	while(1)
	{
		printf("\nEnter Operation = ");
		scanf("%d",&b);
		switch(b)
		{
			case 1:
			lp(htl,a,n);
			display(htl);
			break;
			case 2:
			qp(htq,a,n);
			display(htq);
			break;
			case 3:
			search(htl);
			break;
			case 4:
			search(htq);
			break;
			case 5:
			exit(0);
			default:
			printf("Invalid Operation");
		}
	}
	return 0;
}