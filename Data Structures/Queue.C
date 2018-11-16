#include<stdio.h>
#include<conio.h>
int f=0,r=-1,i,j,q[5],a,b,c,d,e;
void out()
{
	printf("Q = ");
	for(j=f;j<=r;j++)
		printf("%d\t",q[j]);
}
void ri()
{
	b=r;
	if(b<4)
	{
		r++;
		printf("Insert Element = ");
		scanf("%d",&q[r]);
		out();
	}
	else
	if(b==4 && f>0)
	{
		printf("Can't insert from rear end");
	}
	else
	{
		printf("Queue size exceded");
	}
}
void fd()
{
	e=f;
	if(e<=r)
	{
		f++;
		out();
	}
	else
	{
		f=0;
		r=-1;
		printf("Queue is empty");
	}
}
void rd()
{
	d=r;
	if(f<=d)
	{
		r--;
		out();
	}
	else
	{
		f=0;
		r=-1;
		printf("Queue is empty");
	}
}
void fi()
{
	c=f;
	if(c==0 && r==4)
	{
		printf("Queue size exceded");
	}
	else
	if(c==0 && r>=0 && r<4)
	{
		printf("Can't insert from front side");
	}
	else
	if(c==0 && r==-1)
	{
		r++;
		printf("Insert Element = ");
		scanf("%d",&q[f]);
		out();
	}
	else
	{
		f--;
		printf("Insert Element = ");
		scanf("%d",&q[f]);
		out();
	}
}
void main()
{
	clrscr();
	printf("1:Rear Insertion\n2:Front Deletion\n3:Rear Deletion\n4:Front Insertion\n5:Exit");
	while(1)
	{
		printf("\n");
		printf("Enter Operation = ");
		scanf("%d",&a);
		switch(a)
		{
			case 1:   //rear insertion
			ri();
			break;
			case 2:   //front deletion
			fd();
			break;
			case 3:   //rear deletion
			rd();
			break;
			case 4:   //front insertion
			fi();
			break;
			case 5:
			exit();
			break;
			default:
			printf("Invalid Operation");
		}
	}
}