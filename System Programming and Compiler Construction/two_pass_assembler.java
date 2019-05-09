import java.util.*;
import java.io.*;
class base
{
	int r,c;
	base(int x,int y)
	{
		r=x;
		c=y;
	}
}
class symbol
{
	String ar;
	int value,length;
	symbol(int b,int c,String d)
	{
		value=b;
		length=c;
		ar=d;
	}
}
class literal
{
	String lit,ar;
	int value,length;
	literal(String a,int b,int c,String d)
	{
		lit=a;
		value=b;
		length=c;
		ar=d;
	}	
}
class MOT
{
	String opcode,type;
	int length;
	MOT(String b,int c,String d)
	{
		opcode=b;
		length=c;
		type=d;
	}
}
class two_pass_assembler
{
	public static void main(String args[]) throws IOException
	{
		long start=System.nanoTime();

		int i;

		LinkedHashMap<String,MOT> mot=new LinkedHashMap<>();
		LinkedHashMap<String,String> pot=new LinkedHashMap<>();
		LinkedHashMap<String,symbol> s=new LinkedHashMap<>();
		ArrayList<literal> l=new ArrayList<>();

		mot.put("A",new MOT("5A",4,"RX"));
		mot.put("LA",new MOT("01",4,"RX"));
		mot.put("SR",new MOT("02",2,"RR"));
		mot.put("C",new MOT("59",4,"RX"));
		mot.put("BR",new MOT("0A",8,"RR"));
		mot.put("L",new MOT("58",4,"RX"));
		mot.put("LR",new MOT("08",2,"RR"));
		mot.put("AR",new MOT("04",2,"RR"));
		mot.put("BNE",new MOT("04",4,"RX"));
		mot.put("ST",new MOT("50",4,"RX"));

		String str1[]={"START","DS","DC","EQU","END","USING","LTORG","DROP"};
		String str2[]={"START()","DS()","DC()","EQU()","END()","USING()","LTORG()","DROP()"};
		for(i=0;i<str1.length;i++)
		{
			pot.put(str1[i],str2[i]);
		}

		FileReader fr=null;
		FileWriter fw=new FileWriter("pass_1_output.txt");
		try
		{
			fr=new FileReader("test.asm");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}

		BufferedReader bufferedReader = new BufferedReader(fr);
    	String line;
    	ArrayList<Integer> store=new ArrayList();
    	LinkedHashSet<String> h;
    	ArrayList<String> al;

    	int lc=0,stop=0;
    	while((line = bufferedReader.readLine())!=null)
    	{
    		line=line.trim();
        	h=new LinkedHashSet<String>();
        	al=new ArrayList<String>();
        	StringTokenizer st = new StringTokenizer(line," ,*",true);
        	while(st.hasMoreTokens()) 
        	{	
        		String t=st.nextToken();
        		if(t.trim().length() > 0 && !t.equals(","))
        		{
    				al.add(t);
    				h.add(t);
    			}
			}

			if(!h.contains("EQU"))
			{
				fw.write(lc+" "+line+"\n");
			}

			if(h.contains("START"))
			{
				lc=Integer.parseInt(al.get(al.size()-1));
				if(al.size()==3)
				{
					s.put(al.get(0),new symbol(lc,1,"R"));
				}
			}
			else
			if(h.contains("EQU"))
			{
				if(al.get(al.size()-1).equals("*"))
				{
					s.put(al.get(0),new symbol(lc,1,"R"));
				}
				else
				{
					s.put(al.get(0),new symbol(Integer.parseInt(al.get(2)),1,"A"));
				}
			}
			else
			if(h.contains("LTORG"))
			{
				for(i=stop;i<l.size();i++)
				{
					l.get(i).value=lc;
					lc+=4;
				}
				stop=i;
				store.add(lc-4);
			}
			else
			if(h.contains("END"))
			{
				for(i=stop;i<l.size();i++)
				{
					l.get(i).value=lc;
					lc+=4;
				}
				store.add(lc-4);
			}
			else
			if(h.contains("DS"))
			{
				StringBuilder temp=new StringBuilder(String.valueOf(al.get(2)));
				temp.deleteCharAt(temp.length()-1);
				int val=Integer.parseInt(String.valueOf(temp));
				s.put(al.get(0),new symbol(lc,4,"R"));
				lc+=(val*4);
			}
			else
			if(h.contains("DC"))
			{
				StringTokenizer ts = new StringTokenizer(line,", 'F",true);
				ArrayList<String> pemt=new ArrayList();
        		while(ts.hasMoreTokens()) 
        		{	
        			String t=ts.nextToken();
        			if(t.trim().length() > 0 && !t.equals(",") && !t.equals("'") && !t.equals("F") && !Character.isLetter(t.charAt(0)))
        			{
        				pemt.add(t);
    				}
				}
				int val=pemt.size();
				s.put(al.get(0),new symbol(lc,4,"R"));
				lc+=(val*4);
			}
			else
			if(mot.containsKey(al.get(0)) || mot.containsKey(al.get(1)))
			{
				if(mot.containsKey(al.get(0)))
				{
					lc+=mot.get(al.get(0)).length;
				}
				else
				{
					s.put(al.get(0),new symbol(lc,4,"R"));
					lc+=mot.get(al.get(1)).length;
				}
				if(al.get(al.size()-1).charAt(0)=='=')
				{
					l.add(new literal(al.get(al.size()-1),0,4,"R"));
				}
			}
    	}

    	System.out.println();
    	System.out.println("Symbol Table:");
    	System.out.println();
    	System.out.println("Symbol\tValue\tLength\tA/R");
    	for(String j:s.keySet())
    	{
    		symbol t=s.get(j);
    		System.out.println(j+"\t"+t.value+"\t"+t.length+"\t"+t.ar);
    	}

    	System.out.println();
		System.out.println("Literal Table:");
		System.out.println();
    	System.out.println("Literal\tValue\tLength\tA/R");
    	for(i=0;i<l.size();i++)
    	{
    		literal t=l.get(i);
    		System.out.println(t.lit+"\t"+t.value+"\t"+t.length+"\t"+t.ar);
    	}  

    	System.out.println();

    	fr.close();
    	fw.close();

		long sto=System.nanoTime();
		System.out.println("Execution Time of pass 1: "+(sto-start)+" nano seconds");  
		long pass1=sto-start;

		//pass 2
		start=System.nanoTime();
		fr=null;
		fw=new FileWriter("pass_2_output.txt");
		try
		{
			fr=new FileReader("pass_1_output.txt");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}

		bufferedReader = new BufferedReader(fr);
    	int reg=0,cont=0,right=0,left=0,ans=0,an=0,j=0,k=0;
    	ArrayList<base> ba=new ArrayList();
    	literal tempp=new literal("jay",1,1,"jay");

    	while((line = bufferedReader.readLine())!=null)
    	{
    		line=line.trim();
        	h=new LinkedHashSet<String>();
        	al=new ArrayList<String>();
        	StringTokenizer st = new StringTokenizer(line," ,",true);
        	while(st.hasMoreTokens()) 
        	{	
        		String t=st.nextToken();
        		if(t.trim().length() > 0 && !t.equals(","))
        		{
    				al.add(t);
    				h.add(t);
    			}
			}

			if(h.contains("START"))
			{
				continue;
			}
			else
			if(h.contains("LTORG") || h.contains("END"))
			{
				for(i=Integer.parseInt(al.get(0));i<=store.get(j);i+=4)
				{
					String trav=l.get(k).lit;
					StringTokenizer wei=new StringTokenizer(trav,"=F()'",true);
					while(wei.hasMoreTokens())
					{
						String tr=wei.nextToken();
						try
						{
							right=Integer.parseInt(tr);
							fw.write(i+" "+right+"\n");
						}
						catch(Exception e)
						{
							if(s.containsKey(tr))
							{
								symbol ja=s.get(tr);
								fw.write(i+" "+ja.value+"\n");
							}
						}
					}
					k++;
				}
				j++;
			}
			else
			if(h.contains("USING"))
			{
				if(al.get(2).equals("*"))
				{
					cont=Integer.parseInt(al.get(0));
				}
				else
				{
					try
					{
						cont=Integer.parseInt(al.get(2));
					}
					catch(Exception e)
					{
						symbol te=s.get(al.get(2));
						cont=te.value;
					}
				}

				try
				{
					reg=Integer.parseInt(al.get(3));
				}
				catch(Exception e)
				{
					symbol te=s.get(al.get(3));
					reg=te.value;
				}

				ba.add(new base(reg,cont));
			}
			else
			if(h.contains("DS"))
			{
				String o=al.get(3).substring(0,al.get(3).length()-1);
				ans=Integer.parseInt(o)*4+Integer.parseInt(al.get(0));
				fw.write(al.get(0)+" ----- "+(Integer.parseInt(o)*4)+" entries\n");
				fw.write(".\n");
				fw.write(".\n");
				fw.write((ans-1)+"\n");
			}
			else
			if(h.contains("DC"))
			{
				lc=Integer.parseInt(al.get(0));
				StringTokenizer jay=new StringTokenizer(line," =',F",true);
				i=0;
				while(jay.hasMoreTokens())
				{
					String y=jay.nextToken();
					if(i==0)
					{
						i++;
						continue;
					}
					try
					{
						fw.write(lc+" "+Integer.parseInt(y)+"\n");
						lc+=4;
					}
					catch(Exception e)
					{

					}
				}
			}
			else
			if(h.contains("BR"))
			{
				fw.write(al.get(0)+" BCR 15,14\n");
			}
			else
			if(h.contains("BNE"))
			{
				if(al.size()==4)
				{
					ans=2;
				}
				else
				{
					ans=1;
				}
				symbol te=s.get(al.get(ans+1));
				right=te.value;
				right-=ba.get(ba.size()-1).c;
				if(right<0)
				{
					ba.remove(ba.size()-1);
					right=te.value-ba.get(ba.size()-1).c;
				}
				fw.write(al.get(0)+" BC 7,"+right+"(0,"+ba.get(ba.size()-1).r+")\n");
			}
			else
			{
				if(al.size()==5)
				{
					ans=2;
				}
				else
				{
					ans=1;
				}

				MOT tem=mot.get(al.get(ans));

				if(tem.type.equals("RR"))
				{
					try
					{
						left=Integer.parseInt(al.get(ans+1));
					}
					catch(Exception e)
					{
						symbol te=s.get(al.get(ans+1));
						left=te.value;
					}

					try
					{
						right=Integer.parseInt(al.get(ans+2));
					}
					catch(Exception e)
					{
						symbol te=s.get(al.get(ans+2));
						right=te.value;
					}

					fw.write(al.get(0)+" "+al.get(ans)+" "+left+","+right+"\n");
				}
				else
				{
					try
					{
						left=Integer.parseInt(al.get(ans+1));
					}
					catch(Exception e)
					{
						symbol te=s.get(al.get(ans+1));
						left=te.value;
					}

					LinkedHashSet<String> brac=new LinkedHashSet();
					ArrayList<String> b=new ArrayList();
					StringTokenizer pe=new StringTokenizer(al.get(ans+2),"()",true);
					while(pe.hasMoreTokens())
					{
						String p=pe.nextToken();
						brac.add(p);
						if(!p.equals("(") && !p.equals(")"))
						{
							b.add(p);
						}
					}

					if(al.get(ans+2).charAt(0)=='=')
					{
						for(i=0;i<l.size();i++)
						{
							tempp=l.get(i);
							if(tempp.lit.equals(al.get(ans+2)))
							{
								right=tempp.value;
								break;
							}
						}
						right-=ba.get(ba.size()-1).c;
						if(right<0)
						{
							ba.remove(ba.size()-1);
							right=tempp.value-ba.get(ba.size()-1).c;
						}
						fw.write(al.get(0)+" "+al.get(ans)+" "+left+","+right+"(0,"+ba.get(ba.size()-1).r+")\n");
					}
					else
					if(brac.contains("("))
					{
						symbol te=s.get(b.get(0));
						right=te.value;
						right-=ba.get(ba.size()-1).c;
						if(right<0)
						{
							ba.remove(ba.size()-1);
							right=te.value-ba.get(ba.size()-1).c;
						}
						try
						{
							an=Integer.parseInt(b.get(1));
						}
						catch(Exception e)
						{
							te=s.get(b.get(1));
							an=te.value;
						}
						fw.write(al.get(0)+" "+al.get(ans)+" "+left+","+right+"("+an+","+ba.get(ba.size()-1).r+")\n");
					}
					else
					{
						symbol te=s.get(al.get(ans+2));
						right=te.value;
						right-=ba.get(ba.size()-1).c;
						if(right<0)
						{
							ba.remove(ba.size()-1);
							right=te.value-ba.get(ba.size()-1).c;
						}
						fw.write(al.get(0)+" "+al.get(ans)+" "+left+","+right+"(0,"+ba.get(ba.size()-1).r+")\n");
					}
				}
			}
    	}
    	fr.close();
    	fw.close();
    	sto=System.nanoTime();
    	System.out.println("Execution Time of pass 2: "+(sto-start)+" nano seconds");
    	System.out.println("Total Time: "+(pass1+sto-start)+" nano seconds");
    }
}