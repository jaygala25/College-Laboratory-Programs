#include<stdio.h>
#include<conio.h>
void binary(int a,int b,int c[],int d)
{
	int i;
	for(i=a;i>=b;i--)
	{
		c[i]=d%2;
		d=d/2;
	}
}
void print(int a,int b[])
{
	int i;
	for(i=0;i<a;i++)
	{
		printf("%d",b[i]);
	}
}
void store(int a,int b,int c[],int d[])
{
	int i,f;
	for(i=a,f=0;i<b;i++,f++)
	{
		c[i]=d[f];
	}
}
void main()
{
	double n,h,q1,l,j;
	int m[20]={0},m1,z=0,i,a[60]={0},b,s[32]={0},x[52]={0},k=0,c,f,y=0,d[64]={0};
	clrscr();
	printf("Enter Floating Point No. = ");
	scanf("%lf",&n);
	if(n>=0)
	{
		s[0]=0;
		d[0]=0;
	}
	else
	{
		s[0]=1;
		d[0]=1;
		n=(-1)*n;
	}
	m1=n;
	q1=(double)m1;
	h=n-q1;
	for(i=0;i<64;i++)
	{
		l=j=h*2;
		b=(int)l;
		a[i]=b;
		l=(double)b;
		h=j-l;
	}
	if(n>=1)
	{
		while(m1!=0)
		{
			m1=m1/2;
			z++;
		}
		binary(z-1,0,m,n);
		for(i=0;i<z;i++)
		{
			if(m[i]==1)
			{
				i++;
				while(i<z)
				{
					x[k++]=m[i++];
				}
				break;
			}
		}
		for(i=k,f=0;i<52;i++,f++)
		{
			x[i]=a[f];
		}
		c=k;
	}
	else
	if(n<1 && n>=0)
	{
		for(i=0;i<64;i++)
		{
			if(a[i]==1)
			{
				i++;
				while(i<64)
				{
					x[k++]=a[i++];
				}
				break;
			}
			else
			{
				y++;
			}
		}
		c=(-1)*(y+1);
	}
	store(9,32,s,x);
	store(12,64,d,x);
	binary(8,1,s,127+c);
	binary(11,1,d,1023+c);
	printf("\n");
	printf("Single Precision IEEE Representation: \n");
	print(32,s);
	printf("\n\n");
	printf("Double Precision IEEE Representation: \n");
	print(64,d);
	getch();
}