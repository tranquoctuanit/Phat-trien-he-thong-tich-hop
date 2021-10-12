package vidu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public final static int serverPort = 3000;
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(serverPort);
			System.out.println("Server da duoc tao");
			while(true) {
				try {
					Socket s = ss.accept();
					OutputStream os = s.getOutputStream();
					InputStream is = s.getInputStream();
					int ch = 0;
					while(true) {
						ch = is.read();
						if(ch ==-1) break;
						System.out.println((char)ch);
						os.write(ch);
					}
					s.close();
					
				} catch (IOException ie1) {
					// TODO: handle exception
					System.out.println("Connect Error"  + ie1);
					
				}
			}
		} catch (IOException ie) {
			// TODO: handle exception
			System.out.println("Server creation Error : " +ie);
		}
	}

}