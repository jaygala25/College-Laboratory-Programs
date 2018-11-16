import java.util.*;
import java.io.*;
import java.net.*;

public class StopClient {
public static void main(String[] args) {
try{	
Socket s=new Socket("localhost",8888);

DataOutputStream dout=new DataOutputStream(s.getOutputStream());
dout.writeUTF("Frame 0");
System.out.println("Frame 0 sent");
 Thread t=new Thread();
 t.sleep(4000);
dout.flush();

DataInputStream dis=new DataInputStream(s.getInputStream());


String	str=(String)dis.readUTF();
System.out.println("message= "+str+" recived");


t.sleep(1000);
System.out.println("Frame 1 sent");


t.sleep(5000);
System.out.println("Time out");
System.out.println("Frame 1 sent");
dout.writeUTF("Frame 1");
dout.flush();
t.sleep(7000);
System.out.println("Time-out");
System.out.println("Frame 1 sent");

//s.close();
dout.close();
s.close();
t.sleep(5000);
System.out.println("ACK 1 received");
}catch(Exception e){System.out.println(e);}
}
}
