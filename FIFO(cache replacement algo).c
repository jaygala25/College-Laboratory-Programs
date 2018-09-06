#include<stdio.h>
int main()
{
	int n,fifo[3]={-1,-1,-1},a[100]={0},i,j,c[3]={6,5,4},max,k,f;
	printf("Enter no. of numbers = ");
	scanf("%d",&n);
	printf("Enter nos. = ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<n;i++)
	{
		f=0;
		for(k=0;k<3;k++)
		{
			if(a[i]==fifo[k])
			{
				f=1;
				break;
			}
		}
		if(f==0)
		{
        		max=c[0];
                for(j=1;j<3;j++)
                {
                    if(max<c[j])
                    {
                        max=c[j];
                    }
                }
                for(j=0;j<3;j++)
                {
                    if(max==c[j])
                    {
                        break;
                    }
                }
                fifo[j]=a[i];
                c[j]=0;
		}
		for(j=0;j<3;j++)
		{
			c[j]++;
			printf("%d ",fifo[j]);
		}
		printf("\n");
	}
}
