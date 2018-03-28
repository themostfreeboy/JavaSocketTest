import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.util.Scanner;
public class SocketClient_2 implements Runnable
{
	DataInputStream is;
	DataOutputStream os;
	String temp1,temp2,temp3;
	Socket s;
	public void connect()
	{
			try 
			{
				//temp3="";
				//Scanner input=new Scanner(System.in);
				//temp3=input.nextLine();
				s = new Socket(InetAddress.getLocalHost(),9633);
				//InetAddress.getLocalHost().getHostAddress()//获取本机IP地址
				//s = new Socket(temp3,9633);
				is=new DataInputStream(s.getInputStream());
				os=new DataOutputStream(s.getOutputStream());
				new Thread(this).start();
				temp1="";
				while(!temp1.equals("exit"))
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					while((temp1=br.readLine())!=null)
					{
						os.writeUTF(temp1);
					}
				}
				//input.close();
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
	public void run()
	{
		temp2="";
		while(!temp2.equals("exit"))
		{
			try 
			{
				temp2 = is.readUTF();
				System.out.println(temp2);
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
		new SocketClient_2().connect();
	}
}
