class Client extends NetworkServer {
	public Client(String addres, String[] addressies) {
		// address: 自分のアドレス
		// addressies: サーバーのアドレスの配列
		super(address,addressies);
	}

	public File[] find(String filename) {
		//この部分にマルチスレッドで受け取りのサーバを展開(getData(filename))
		for( String address : myaddress) {
			sendString('find', address);
			sendString(filename, address);
		}
		//return 受け取った複数のファイル 
	}

	public boolean delete(String filename) {
		//この部分にマルチスレッドで受け取りのサーバを展開(getData(filename))
		for( String address : myaddress) {
			sendString('delete', address);
			sendString(filename, address);
		}
		//return 削除が成功したかどうか
	}

	public boolean store(File file) {
		//この部分にマルチスレッドで受け取りのサーバーを展開(getData(file.getName()))
		for( String address : myaddress) {
		sendString('store', address);
		sendString(file.getName(), address);
		sendData(file, address);
	}
		//return 保存が成功したかどうか
	}
}