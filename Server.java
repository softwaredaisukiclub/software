class Server extends NetworkServer {
	public Server(String address, String addressies) {
		// address: 自分のアドレス
		// addressies: 自分とクライアント以外のアドレス
		super(address, addressies);
		public DataBase dataBase  = new DataBase();
	}

	public void serverStart() {
		//サーバを起動するメソッド
		//port 8000
	}

	

}