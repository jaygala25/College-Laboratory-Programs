import java.io.*;
import java.util.*;
import java.net.*;
public class GoServer
{
	public static void main(String[] args)
	{
		try
		{
			Thread t=new Thread();  
			ServerSocket ss=new ServerSocket(8888);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String	str=(String)dis.readUTF();
			t.sleep(2000);
			System.out.println("Frame 0 received");
			t.sleep(1000);
			System.out.println("ACK 0 sent");
			t.sleep(1000);
			System.out.println("Frame 1 received");
			t.sleep(1000);
			System.out.println("ACK 1 sent");
			t.sleep(1000);
			System.out.println("Frame 2 received");
			t.sleep(1000);
			System.out.println("ACK 2 sent");	
			
			t.sleep(15000);
			
			System.out.println("Frame 2 received");
			t.sleep(1000);
			System.out.println("ACK 2 sent");
			t.sleep(1000);
			System.out.println("Frame 3 received");
			t.sleep(1000);
			System.out.println("ACK 3 sent");
			
			t.sleep(14000);
			
			System.out.println("Frame 2 received");
			t.sleep(1000);
			System.out.println("ACK 2 sent");
			t.sleep(1000);
			System.out.println("Frame 3 received");
			t.sleep(1000);
			System.out.println("ACK 3 sent");
			t.sleep(1000);
			System.out.println("Frame 4 received");
			t.sleep(1000);
			System.out.println("ACK 4 sent");
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Client");
			dout.flush();
			dout.close();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
