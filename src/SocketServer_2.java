import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer_2 implements Runnable
{
	DataInputStream is;
	DataOutputStream os;
	String temp1,temp2;
	ServerSocket ss;
	Socket s;
	public void CreatServer()
	{
		try 
		{
			ss = new ServerSocket(9633);
			s=ss.accept();
			is=new DataInputStream(s.getInputStream());
			os=new DataOutputStream(s.getOutputStream());
			new Thread(this).start();
			temp1="";
			while(!temp1.equals("exit"))
			{
				temp1 = is.readUTF();
				System.out.println(temp1);
			}
			s.close();
			ss.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		temp2="";
		while(!temp2.equals("exit"))
		{
			try 
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				while((temp2=br.readLine())!=null)
				{
					os.writeUTF(temp2);
				}
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try 
		{
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
		new SocketServer_2().CreatServer();
	}
}
