import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class SocketClient_1 implements Runnable
{
	DataInputStream is;
	DataOutputStream os;
	public void connect()
	{
		try 
		{
			Socket s=new Socket(InetAddress.getLocalHost(),8123);
			//InputStream is=s.getInputStream();
			//OutputStream os=s.getOutputStream();
			is=new DataInputStream(s.getInputStream());
			os=new DataOutputStream(s.getOutputStream());
			//os.writeUTF("Hello!");
			new Thread(this).start();
			while(true)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String temps;
				while((temps=br.readLine())!=null)
				{
					os.writeUTF(temps);
				}
			}
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
	public void run()
	{
		try
		{
			os.writeUTF("Hello!");
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
		new SocketClient_1().connect();
	}
}
