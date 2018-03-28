import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer_3
{
	String temp1,temp2;
	ServerSocket ss;
	Socket s;
	public void CreatServer()
	{
		try 
		{
			ss = new ServerSocket(9633);
			s=ss.accept();
			InputStream fis=s.getInputStream();
			BufferedInputStream bis=new BufferedInputStream(fis);
			FileOutputStream fos=new FileOutputStream("D:\\receive.jpg");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			byte[] buf = new byte[1024];
			int len = 0;
			while( (len = bis.read(buf)) != -1 )
			{
				bos.write(buf,0,len);
			}
			bos.close();
			s.close();
			ss.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new SocketServer_3().CreatServer();
	}
}
