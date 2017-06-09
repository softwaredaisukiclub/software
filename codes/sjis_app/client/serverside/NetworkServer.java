package client.serverside;
import java.util.*;
import java.io.*;
import java.net.*;
public class NetworkServer {
	//����M���ꂽ�f�[�^��ۑ�����f�B���N�g����ݒ肷��N���X�ϐ�
	public static final int PORT = 8000;
	protected String myaddress;
	protected String[] myaddresses;
	//�R���X�g���N�^�B�����̃A�h���X�Ƒ��M���鑊��̃A�h���X��z��ł��B�i�܂��ύX���邩���j
	public NetworkServer(String address, String[] addresses) {
		myaddress = address;
		myaddresses = addresses;
	}



	//�����̃t�@�C���������Ɏ�������ƈ��zip�t�@�C���ɂȂ�
	private File zip(File[] files) throws Exception {
		String zipFilename ="data.zip";
		String zipPath = PathList.zipDataPath+zipFilename;
		return ZipClient.compressZip(PathList.rowDataPath, files, zipPath);
	}


	//�𓀎��ɕ����̃t�@�C���ɂȂ邱�Ƃ�����̂Ń��X�g�ŕԂ��悤�ɂ���
	private ArrayList<File> unzip(File file) throws Exception {
		String filename = file.getName();
		return ZipClient.decompressZip(PathList.zipDataPath+filename, PathList.unzipDataPath);
	}

	public void sendString(String data, String host,int num) {
		//�t�@�C�����𑗐M���郁�\�b�h
		Socket socket = new Socket();
		try{
			// �\�P�b�g�̏���
			if(data.equals("test")){
				socket.connect(new InetSocketAddress(host, PORT+num), 100);
			} else {
				socket = new Socket(host, PORT+num);
			}
			// ���M�o�b�t�@�ݒ�
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

			out.println(data);	// String���M
			socket.close();
			if(data.equals("test")){
				AddressList.addServerList(host);
			}
		} catch(Exception e) {
			if(!data.equals("test")){
				e.printStackTrace();
			}
		}
	}

	public String getString(int num) {
		//�t�@�C��������M���郁�\�b�h
		// �\�P�b�g�̏���
		Socket socket = null;
		String str= null;
		try {
			ServerSocket s = new ServerSocket(PORT+num);
			socket = s.accept();	// �R�l�N�V�����ݒ�v����҂�
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// �f�[�^��M�p�o�b�t�@�̐ݒ�
				 str = in.readLine();	// �t�@�C������M
				 socket.close();
				 s.close();
				 return str;
				}catch(Exception e){
					e.printStackTrace();
					return str;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return str;
		}

		public void sendData(File[] sendFiles,String host,int num) {
			byte[] buffer = new byte[512];      // �t�@�C�����M���̃o�b�t�@
			try{
				File file = zip(sendFiles); // ���M����t�@�C���̃I�u�W�F�N�g
			// �\�P�b�g�̏���
				Socket socket = new Socket(host, PORT+num);
			// �X�g���[���̏���
				InputStream  inputStream  = new FileInputStream(file);
				OutputStream outputStream = socket.getOutputStream();

				int fileLength;
				while ((fileLength = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, fileLength);
				}
				// �I������
				socket.close();
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				file.delete();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		public ArrayList<File> getData(int num) {
		String filepath = PathList.zipDataPath+UUID.randomUUID()+".zip";       // ��M�����t�@�C���̕ۑ���
		byte[] buffer = new byte[512]; // �t�@�C����M���̃o�b�t�@
		ArrayList<File> data = null;
		try{
			// �\�P�b�g�̏���
			ServerSocket serverSocket = new ServerSocket(PORT+num);
			Socket       socket       = serverSocket.accept();
			// �X�g���[���̏���
			InputStream  inputStream  = socket.getInputStream();
			OutputStream outputStream = new FileOutputStream(filepath);
			// �t�@�C�����X�g���[���Ŏ�M
			int fileLength;
			while ((fileLength = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, fileLength);
			}
			// �I������
			socket.close();
			serverSocket.close();
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			File getData = new File(filepath);
			data = unzip(getData);
			getData.delete();
			return data;
		}catch(Exception e){
			e.printStackTrace();
			return data;
		}
	}
}