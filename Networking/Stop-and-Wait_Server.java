import java.io.*;
import java.util.*;
import java.net.*;

public class StopServer {
public static void main(String[] args){
try{
ServerSocket ss=new ServerSocket(8888);
Socket s=ss.accept();

DataInputStream dis=new DataInputStream(s.getInputStream());
Thread t1=new Thread();
t1.sleep(2000);

String	str=(String)dis.readUTF();
System.out.println("message= "+str+" received");


//TimerTask tasknew = new TimerTask();
   Thread t=new Thread();
      
   // scheduling the task at interval
   t.sleep(1000);

DataOutputStream dout=new DataOutputStream(s.getOutputStream());
System.out.println("ACK 0 sent");
dout.writeUTF("ACK 0");
dout.flush();

t.sleep(4000);
//System.out.println("Frame 1 not received");

t.sleep(5000);
str=(String)dis.readUTF();
System.out.println("message= "+str+" received");

t.sleep(1000);
System.out.println("ACK 1 sent");
dout.writeUTF("ACK 1");
dout.flush();

dout.close();

ss.close();

t.sleep(7000);
System.out.println("Frame 1 received");
t.sleep(1000);
System.out.println("ACK 1 Sent");
}catch(Exception e){System.out.println(e);}
}
}
