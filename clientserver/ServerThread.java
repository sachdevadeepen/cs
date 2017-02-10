package clientserver;
import java.io.*;
import java.net.*;	
public class ServerThread extends Thread{
		Socket socket;
		ServerThread(Socket socket){
			this.socket = socket;
			}
	public void run(){
			try{
				String message = null;
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("user '"+bufferedReader.readLine()+"' is now connected to the Server...");
				while((message = bufferedReader.readLine())!=null){
						System.out.println("incoming client message: "+message);
						printWriter.println("Server ecoing client msg: "+message);
				}
				socket.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
