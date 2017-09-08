package ensyuu9;


class En9_3_BankAccount {
	private String accountName;											//口座名義のためのフィールド変数
	private String accountNumber;										//口座番号のためのフィールド変数
	private long accountBalance;										//預金残高のためのフィールド変数
	private En9_2_Day accountOpenedDate;								//口座開設日のためのフィールド変数


	//銀行口座クラスのためのコンストラクター
	En9_3_BankAccount(String accountName, String accountNumber, long accountBalance, En9_2_Day accountOpenedDate) {
		this.accountName = accountName;									//口座名義のフィールドに仮引数の値を代入するための代入式
		this.accountNumber = accountNumber;								//口座番号のフィールドに仮引数の値を代入するための代入式
		this.accountBalance = accountBalance;							//預金残高のフィールドに仮引数の値を代入するための代入式
		this.accountOpenedDate = new En9_2_Day(accountOpenedDate);		//口座開設日のフィールドに仮引数の値を代入するための代入式
	}

	//口座名義を取得するためのゲッターメソッド
	public String getAccountName() {
		//呼び出し元に取得した口座名義の値を返却するreturn文
		return accountName;
	}

	//口座番号を取得するためのゲッターメソッド
	public String getAccountNumber() {
		//呼び出し元に取得した口座番号の値を返却するreturn文
		return accountNumber;
	}

	//預金残高を取得するためのゲッターメソッド
	public long getAccountBalance() {
		//呼び出し元に取得した預金残高の値を返却するreturn文
		return accountBalance;
	}

	//口座開設日を取得するためのゲッターメソッド
	public En9_2_Day getAccountOpenedDate(){
		//呼び出し元に口座開設日の値への参照を返却するreturn文
		return new En9_2_Day(accountOpenedDate);
	}

	//預金時の計算をするためのメソッド
	void deposit(long amountOfDeposit){
		//口座の預金残高に預金する金額を加算し代入する演算式
		accountBalance += amountOfDeposit;
	}

	//預金から引き出し時の計算をするためのメソッド
	void withdraw(long amountOfWithdraw){
		//口座の残高から引き出す金額を減算し代入する演算式
		accountBalance -= amountOfWithdraw;
	}

	//口座情報を文字列表現として返却するためのメソッド
	public String toString(){
		//呼び出し元に値を文字列表現として返却するためのreturn文
		return String.format("%s君の口座\n　■口座名義：%s\n　■口座番号：%s\n　■預金残高：%d円\n",
									getAccountName(), getAccountName(), getAccountNumber(), getAccountBalance());
	}



}
