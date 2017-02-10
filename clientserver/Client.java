package clientserver;
import java.io.*;
import java.net.*;	
public class Client {
	public static void main(String[] args) throws UnknownHostException , IOException {
		String name = args[0];
		Socket socket = new Socket("localhost",4444);
		BufferedReader messageFromServer = new java.io.BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader dataFromCommandPrompt = new java.io.BufferedReader(new InputStreamReader(System.in));
		printWriter.println(name);
		while(true){
			try {
				String readerInput = dataFromCommandPrompt.readLine();
				printWriter.println(name+": "+readerInput);
				System.out.println(messageFromServer.readLine());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
