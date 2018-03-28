import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer_1 implements Runnable
{
	DataInputStream is;
	DataOutputStream os;
	String temp;
	public void CreatServer()
	{
		try 
		{
			ServerSocket ss=new ServerSocket(8123);
			Socket s=ss.accept();
			//InputStream is=s.getInputStream();
			//OutputStream os=s.getOutputStream();
			//is.read();
			is=new DataInputStream(s.getInputStream());
			os=new DataOutputStream(s.getOutputStream());
			//String temp=is.readUTF();
			//System.out.print(temp);
			new Thread(this).start();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String temps;
			while((temps=br.readLine())!=null)
			{
				os.writeUTF(temps);
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		try 
		{
			temp = is.readUTF();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(temp);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new SocketServer_1().CreatServer();
	}
}
