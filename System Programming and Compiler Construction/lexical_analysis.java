import java.util.*;
import java.io.*;
class Pair 
{
	int first,second;
	Pair(int x,int y)
	{
		first=x;
		second=y;
	}
}
class lexical_analysis
{
	public static void main(String args[]) throws IOException 
	{
		long start=System.nanoTime();
		int i;

		//pre calculation starts
		LinkedHashMap<String,Integer> va=new LinkedHashMap<String,Integer>();
		LinkedHashMap<String,Integer> constant=new LinkedHashMap<String,Integer>();
		LinkedHashMap<String,Pair> error=new LinkedHashMap<String,Pair>();

		HashMap<String,Integer> key=new HashMap<String,Integer>();
		String[] keywords={"break","case","char","continue","default","do","double","else","float","for","goto","if","int","long","return","short","signed","static","struct","switch","typedef","union","unsigned","void","while"};
		for(i=0;i<keywords.length;i++)
		{
			key.put(keywords[i],i);
		}

		char operators[]={'+','-','=','!','*','(',')','/','%'};
		HashMap<Character,Integer> op=new HashMap<Character,Integer>();
		for(i=0;i<operators.length;i++)
		{
			op.put(operators[i],i);
		}

		char special[]={'{','}',';',':','[',']'};
		HashMap<Character,Integer> sp=new HashMap<Character,Integer>();
		for(i=0;i<special.length;i++)
		{
			sp.put(special[i],i);
		}		

		String function[]={"main","printf","scanf","getch"};
		HashMap<String,Integer> func=new HashMap<String,Integer>();
		for(i=0;i<function.length;i++)
		{
			func.put(function[i],i);
		}
		//pre calculation ends

		//reading file
		FileReader fr=null;
		try
		{
			fr=new FileReader("test.C");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}

		BufferedReader bufferedReader = new BufferedReader(fr);
        String line;

        //main logic
        int er=0,vari=0,l=0,con=0;
        while((line = bufferedReader.readLine())!=null)
        {
        	l++;
        	line=line.trim();
        	ArrayList<String> al=new ArrayList<String>();
        	StringTokenizer st = new StringTokenizer(line," []{}()+-*/%=!;:",true);
        	while(st.hasMoreTokens()) 
        	{
        		String t=st.nextToken();
        		if(t.trim().length() > 0)
        		{
    				al.add(t);
    			}
			}

			String temp;
			for(i=0;i<al.size();i++)
			{
				temp=al.get(i);
				if(key.containsKey(temp))
				{
					System.out.println("<key"+key.get(temp)+">");
				}
				else
				if(op.containsKey(temp.charAt(0)))
				{
					System.out.println("<op"+op.get(temp.charAt(0))+">");
				}
				else
				if(sp.containsKey(temp.charAt(0)))
				{
					System.out.println("<sp"+sp.get(temp.charAt(0))+">");
				}
				else
				if(func.containsKey(temp))
				{
					System.out.println("<func"+func.get(temp)+">");
				}
				else
				if(va.containsKey(temp))
				{
					System.out.println("<var"+va.get(temp)+">");
				}
				else
				if(constant.containsKey(temp))
				{
					System.out.println("<cons"+constant.get(temp)+">");
				}
				else
				if(error.containsKey(temp))
				{
					System.out.println("<error"+error.get(temp)+">");
				}
				else
				{
					try
					{
						Float.parseFloat(temp);
						constant.put(temp,con);
						System.out.println("<con"+con+">");
						con++;
					}
					catch(Exception e)
					{
						int f=0;
						if(!(Character.isLetter(temp.charAt(0)) || temp.charAt(0)=='_'))
						{
							error.put(temp,new Pair(er,l));
							System.out.println("<error"+er+">");
							er++;
							f=1;
						}
						else
						{
							for(int j=1;j<temp.length();j++)
							{
								if(!(Character.isLetter(temp.charAt(j)) || temp.charAt(i)=='_' || Character.isDigit(temp.charAt(j))))
								{	
									error.put(temp,new Pair(er,l));
									System.out.println("<error"+er+">");
									er++;
									f=1;
									break;
								}		
							}
						}
						if(f==0)
						{
							va.put(temp,vari);
							System.out.println("<var"+vari+">");
							vari++;
						}
					}
				}
			}
        }

        System.out.println();
        System.out.println("Constant Table");
        System.out.println("Constant\tID");
        for(String str: constant.keySet())
        {
        	System.out.println(str+"\t"+constant.get(str));
        }

		System.out.println();
        System.out.println("Variable Table");
        System.out.println("Variable\tID");
        for(String str: va.keySet())
        {
        	System.out.println(str+"\t"+va.get(str));
        }

        System.out.println();
        System.out.println("Error Table");
        System.out.println("Error\tID\tLine");
        for(String str: error.keySet())
        {
        	Pair p=error.get(str);
        	System.out.println(str+"\t"+p.first+"\t"+p.second);
        }
        System.out.println();

		fr.close();

		long stop=System.nanoTime();
		System.out.println("Execution Time: "+(stop-start)+" nano seconds");
	}
}