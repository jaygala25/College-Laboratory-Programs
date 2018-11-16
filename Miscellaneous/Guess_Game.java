/*This Program guesses the number in user's mind in least number of tries with the help of yes/no type questions, more specifically, it guesses the number in less than (or equal to) log(n) tries where the number ranges from 1 to n.

Basic logic of this program is Binary Search.*/

import java.util.*;
class Main 
{
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the upper limit of your desired range = ");
    int n=sc.nextInt();
    System.out.println("Select any random number between 1 to "+n);
    System.out.println("Type y for yes and n for no");
    int l=1,h=n,mid;
    String s=new String();
    int f=0;
    while(l<=h)
    {
      mid=(l+h)/2;
      System.out.print("Is your number "+mid+"?");
      s=sc.next();
      if(s.equals("y"))
      {
        f=1;
        break;
      }
      else
      {
        System.out.print("Is your number smaller than "+mid+"?");
        s=sc.next();
        if(s.equals("y"))
        {
          h=mid-1;
        }
        else
        {
          l=mid+1;
        }
      }
    }
    if(f==1)
    {
      System.out.println("Woohoo ! I found your number.");
    }
    else
    {
      System.out.println("Unable to find your number, you must have wrongly answered the questions.");
    }
  }
}
