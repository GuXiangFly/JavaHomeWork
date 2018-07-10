package cn.guxiangfly.shiyan.project04;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/*
初始化变量
*/
public class Client extends Frame {
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bConnected = false;

	TextField tfTxt = new TextField();

	TextArea taContent = new TextArea();

	Thread tRecv = new Thread(new RecvThread());

	public static void main(String[] args) {
		new Client().launchFrame();
	}
	/*
    设置聊天窗口，包括当程序启动时窗口的位置，大小等
    */
	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				disconnect();
				System.exit(0);
			}

		});
		tfTxt.addActionListener(new TFListener());
		setVisible(true);
		connect();

		tRecv.start();
	}
	/*
此段程序是服务器和客户端链接的程序，创建套接字，“铺设”数据流管道，用来传达服务器和客户端的信息
*/
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8787);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("connected!");
			bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
此段程序是当断开链接时，关闭dos,dis,s等还在运行的服务程序，因为系统不会自动关闭这些运行的程序，需要自己编写代码关闭这些程序，否则这些程序会一直运行下去
*/
	public void disconnect() {
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		try {
			bConnected = false;
			tRecv.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	/*
在客户端和服务器端分别进行读写数据
*/
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			//taContent.setText(str);
			tfTxt.setText("");

			try {
//System.out.println(s);
				dos.writeUTF(str);
				dos.flush();
				//dos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}
	/*
重写run方法，做关闭程序后的一些处理
*/
	private class RecvThread implements Runnable {

		@Override
		public void run() {
			try {
				while(bConnected) {
					String str = dis.readUTF();
					//System.out.println(str);
					taContent.setText(taContent.getText() + str + '\n');
				}
			} catch (SocketException e) {
				System.out.println("退出了，bye!");
			} catch (EOFException e) {
				System.out.println("推出了，bye - bye!");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
