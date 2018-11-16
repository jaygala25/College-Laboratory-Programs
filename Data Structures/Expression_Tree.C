#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<ctype.h>
typedef struct nd
{
	char data;
	struct nd *l,*r;
}node;
void postfix(node *t)
{
	if(t!=NULL)
	{
		postfix(t->l);
		postfix(t->r);
		printf("%c",t->data);
	}
}
void infix(node *t)
{
	if(t!=NULL)
	{
		infix(t->l);
		printf("%c",t->data);
		infix(t->r);
	}
}
void prefix(node *t)
{
	if(t!=NULL)
	{
		printf("%c",t->data);
		prefix(t->l);
		prefix(t->r);
	}
}
void main()
{
	char s[20];
	node *stk[20],*temp,*rt,*ptr;
	int top=-1,i;
	clrscr();
	printf("Enter Postfix Expression = ");
	scanf("%s",&s);
	rt=(node*)malloc(sizeof(node));
	rt->data=s[0];
	rt->l=NULL;
	rt->r=NULL;
	stk[++top]=rt;
	for(i=1;s[i]!='\0';i++)
	{
		if(isalpha(s[i]))
		{
			ptr=(node*)malloc(sizeof(node));
			ptr->data=s[i];
			ptr->l=NULL;
			ptr->r=NULL;
			stk[++top]=ptr;
		}
		else
		{
			temp=(node*)malloc(sizeof(node));
			temp->data=s[i];
			temp->r=stk[top--];
			temp->l=stk[top--];
			stk[++top]=temp;
		}
	}
	printf("Postfix = ");
	postfix(temp);
	printf("\nInfix   = ");
	infix(temp);
	printf("\nPrefix  = ");
	prefix(temp);
	getch();
}