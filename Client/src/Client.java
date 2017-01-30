import java.io.*;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		try{
			Socket s=new Socket("localhost",6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server");
			dout.flush();
			dout.close();
			s.close();
			Socket so = new Socket("localhost",6666);
			DataInputStream rec = new DataInputStream(so.getInputStream());
			String str1=rec.readUTF();
			System.out.println(str1);
			so.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
