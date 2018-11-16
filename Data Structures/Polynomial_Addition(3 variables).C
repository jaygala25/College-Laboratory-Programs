#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct nd
{
	int c,x,y,z;
	struct nd *next;
}node;
node *create(node *s)
{
	int n,i=1;
	node *temp,*ptr;
	printf("Enter no. of terms = ");
	scanf("%d",&n);
	s=(node*)malloc(sizeof(node));
	printf("Enter term: ");
	scanf("%d %d %d %d",&s->c,&s->x,&s->y,&s->z);
	s->next=NULL;
	temp=s;
	while(i<n)
	{
		ptr=(node*)malloc(sizeof(node));
		printf("Enter term: ");
		scanf("%d %d %d %d",&ptr->c,&ptr->x,&ptr->y,&ptr->z);
		ptr->next=NULL;
		temp->next=ptr;
		temp=ptr;
		i++;
	}
	printf("\n");
	return s;
}
node *cal(node *a,node *b)
{
	node *t1=NULL,*t3=b,*t2,*t4;
	t1->next=a;
	while(t3!=NULL)
	{
		t1=NULL;
		t2=t1->next;
		while(t2!=NULL)
		{
			if(t2->x==t3->x&&t2->y==t3->y&&t2->z==t3->z)
			{
				t3->c=t3->c+t2->c;
				if(t2==a)
				{
					a=a->next;
				}
				t2=t2->next;
				t1->next=t2;
				break;
			}
			else
			{
				t1=t1->next;
				t2=t2->next;
			}
		}
		t4=t3;
		t3=t3->next;
	}
	t4->next=a;
	return b;
}
void disp(node *c)
{
	node *t=c;
	printf("Final Polynomial is = \n");
	while(t!=NULL)
	{
		printf("%d %d %d %d\n",t->c,t->x,t->y,t->z);
		t=t->next;
	}
}
void main()
{
	node *s1=NULL,*s2=NULL;
	clrscr();
	printf("Enter values in the manner: coeff Indexofx Indexofy Indexofz\n\n");
	disp(cal(create(s1),create(s2)));
	getch();
}