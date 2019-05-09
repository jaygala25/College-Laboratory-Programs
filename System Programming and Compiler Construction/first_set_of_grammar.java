/*
Consider the grammar: S -> Aa|Bb|Cc
Then the input will be in following format:
S Aa Bb Cc
*/
import java.util.*;
class first_set_of_grammar
{
	public static ArrayList first(String left,ArrayList<String> right,LinkedHashMap<String,ArrayList<String>> prod)
	{
		int i,j,count;
		ArrayList<String> f=new ArrayList<String>();
		for(i=0;i<right.size();i++)
		{
			String one=right.get(i);
			count=0;
			for(j=0;j<one.length();j++)
			{
				if(Character.isUpperCase(one.charAt(j)))
				{
					String idk=String.valueOf(one.charAt(j));
					HashSet<String> find=new HashSet<String>(first(idk,prod.get(idk),prod));
					if(find.contains("#"))
					{
						find.remove("#");
						count++;
						f.addAll(find);
					}
					else
					{
						f.addAll(find);
						break;
					}
				}
				else
				{
					f.add(String.valueOf(one.charAt(j)));
					break;
				}
				if(count==one.length())
				{
					f.add("#");
				}
			}
		}
		f=new ArrayList<String>(new HashSet<String>(f));
		return f;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of non terminals = ");
		int n=Integer.parseInt(sc.nextLine()),i,j;
		System.out.println("Enter grammar:");
		LinkedHashMap<String,ArrayList<String>> prod=new LinkedHashMap<String,ArrayList<String>>();
		LinkedHashMap<String,ArrayList<String>> fust=new LinkedHashMap<String,ArrayList<String>>();
		String tem=new String();
		for(i=0;i<n;i++)
		{
			tem=sc.nextLine();
			ArrayList<String> t=new ArrayList<String>();
			String arr[]=tem.split(" ");
			for(j=1;j<arr.length;j++)
			{
				t.add(arr[j]);
			}
			prod.put(arr[0],t);
		}
		for(String k:prod.keySet())
		{
			ArrayList<String> temp=new ArrayList<String>(first(k,prod.get(k),prod));
			fust.put(k,temp);
		}
		System.out.println("First Set:");
		for(String k:fust.keySet())
		{
			System.out.println(k+": "+fust.get(k));
		}
	}
}