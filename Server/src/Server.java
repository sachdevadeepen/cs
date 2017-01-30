import java.io.*;
import java.net.*;	
public class Server {
	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			System.out.println("Message: "+str);
			
			Socket so = ss.accept();
			DataOutputStream dos = new DataOutputStream(so.getOutputStream());
			dos.writeUTF("Message Received");
			dos.flush();
			dos.close();
			so.close();
			
			ss.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
