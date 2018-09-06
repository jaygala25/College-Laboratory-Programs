/*Program that prints a vertical histogram of frequency of each alphabet in a text file

The program's logic is basically storing count of occurrence of each alphabet in an array of size 26, finding maximum count (max of array) and lastly printing in a proper manner.*/

#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE *f=fopen("file_name.txt","r");
    char c;
    int a[26],b,e,i;
    for(i=0;i<26;i++)
    {
         a[i]=0;
    }
    while((c=getc(f))!=EOF)
    {
        if(c>=65 && c<=90)
        {
            a[c-65]++;
        }
        else
        if(c>=97 && c<=122)
        {
            a[c-97]++;
        }
    }
    b=a[0];
    for(i=1;i<26;i++)
    {
          if(b<a[i])
          {
                b=a[i];
          }
    }
    for(i=b;i>=1;i--)
    {
        printf("%10d ",i);
        for(e=0;e<26;e++)
        {
            if(i<=a[e])
            {
                  printf("# ");
            }
            else
            {
                printf("  ");
            }
        }
        printf("\n");
        printf("\n");
    }
    printf("           ");
    c='a';
    for(i=1;i<=26;i++)
    {
        printf("%c ",c);
        c++;
    }
    printf("\n");
    return 0;
}
