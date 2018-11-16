import java.util.*;
import java.io.*;
import java.net.*;
public class GoClient 
{
	public static void main(String[] args)
	{
		try
		{	
			Thread t=new Thread();
			System.out.println("Frame 0 Sent");
			t.sleep(1000);
			System.out.println("Frame 1 Sent");
			t.sleep(1000);
			System.out.println("Frame 2 Sent");
			Socket s=new Socket("localhost",8888);	
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("");
			
			t.sleep(9000);
			
			System.out.println("ACK 0 Received");
			t.sleep(1000);
			System.out.println("Frame 3 sent");
			t.sleep(1000);
			System.out.println("ACK 1 received");
			t.sleep(1000);
			System.out.println("Frame 4 sent");
			
			t.sleep(5000);
			
			System.out.println("Timeout");
			t.sleep(1000);
			System.out.println("Frame 2 sent");
			t.sleep(1000);
			System.out.println("Frame 3 sent");
			t.sleep(1000);
			System.out.println("Frame 4 sent");
			
			t.sleep(8000);
			
			System.out.println("ACK 2 received");
			t.sleep(1000);
			System.out.println("ACK 3 received");
			
			t.sleep(5000);
			
			System.out.println("Timeout");
			t.sleep(1000);
			System.out.println("Frame 2 sent");
			t.sleep(1000);
			System.out.println("Frame 3 sent");
			t.sleep(1000);
			System.out.println("Frame 4 sent");
			//dout.flush();
			
			t.sleep(10000);
			
			System.out.println("ACK 2 received");
			t.sleep(1000);
			System.out.println("ACK 3 received");
			t.sleep(1000);
			System.out.println("ACK 4 received");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String	str=(String)dis.readUTF();
			//System.out.println("message= "+str);
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
