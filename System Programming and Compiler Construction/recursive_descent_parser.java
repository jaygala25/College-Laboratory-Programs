/*
Grammar:
S->bA/cA
A->bA/cA/aa
*/
import java.util.*;
class recursive_descent_parser
{
	static int pos,ans;
	static String s;
	public static int S(String s,int pos)
	{
		if(s.charAt(pos)=='b')
		{
			pos++;
			return A(s,pos);
		}
		else
		if(s.charAt(pos)=='c')
		{
			pos++;
			return A(s,pos);
		}
		return 0;
	}

	public static int A(String s,int pos)
	{
		if(s.charAt(pos)=='b')
		{
			pos++;
			return A(s,pos);
		}
		else
		if(s.charAt(pos)=='c')
		{
			pos++;
			return A(s,pos);	
		}
		else
		if(s.charAt(pos)=='a')
		{
			try
			{
				if(s.charAt(pos+1)=='a' && pos+2==s.length())
				{
					return 1;
				}
			}
			catch(Exception e)
			{
				return 0;
			}	 
		}
		return 0;
	}

	public static void main(String args[])
	{
		System.out.print("Enter String = ");
		Scanner sc=new Scanner(System.in);
		pos=0;
		s=new String();
		s=sc.next();
		if(s.length()<3)
		{
			System.out.println("Invalid");
		}
		else
		{
			ans=S(s,pos);
			if(ans==1)
			{
				System.out.println("Valid");
			}
			else
			{
				System.out.println("Invalid");
			}
		}
	}
}