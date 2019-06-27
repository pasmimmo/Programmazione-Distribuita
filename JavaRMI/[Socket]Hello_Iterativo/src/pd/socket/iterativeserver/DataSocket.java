package pd.socket.iterativeserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DataSocket {

	private Socket socket;
	private ObjectInputStream ingress = null;
	private ObjectOutputStream egress = null;

	public DataSocket(int dataConnectPort) throws UnknownHostException, IOException {
		openChannels(socket = new Socket("localhost", dataConnectPort));
	}

	public DataSocket(String ip, int dataConnectPort) throws UnknownHostException, IOException {
		openChannels(socket = new Socket(ip, dataConnectPort));
	}

	private void openChannels(Socket socket) throws IOException {
		ingress = new ObjectInputStream(socket.getInputStream());
		egress = new ObjectOutputStream(socket.getOutputStream());
	}

	public void close() throws IOException {
		ingress.close();
		egress.close();
		socket.close();
	}

	public Object readObject() throws ClassNotFoundException, IOException {
		return ingress.readObject();
	}

	public void writeObject(Object obj) throws IOException {
		egress.writeObject(obj);
		egress.flush();
	}

}
