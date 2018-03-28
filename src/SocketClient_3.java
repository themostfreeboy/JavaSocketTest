import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class SocketClient_3
{
	String temp1,temp2,temp3;
	Socket s;
	public void connect()
	{
			try 
			{
				s = new Socket(InetAddress.getLocalHost(),9633);
				OutputStream fos=s.getOutputStream();
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				FileInputStream fis=new FileInputStream("D:\\send.jpg");
				BufferedInputStream bis=new BufferedInputStream(fis);
				byte[] buf = new byte[1024];
				int len = 0;
				while( (len = bis.read(buf)) != -1 )
				{
					bos.write(buf,0,len);
				}
				bis.close();
				bos.close();
				s.close();
			} 
			catch (UnknownHostException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		new SocketClient_3().connect();
	}
}
