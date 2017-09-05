package ensyuu9;

public class En9_2_Day {
	private int year = 1;						//初期化子で初期化した年のための変数
	private int month = 1;						//初期化子で初期化した月のための変数
	private int date = 1;						//初期化子で初期化した日のための変数

	//仮引数がない日付クラスのためのコンストラクタ
	public En9_2_Day(){
	}

	//仮引数に年のみ受け取る日付クラスのためのコンストラクタ
	public En9_2_Day(int year){
		this.year = year;						//年のフィールドに仮引数yearの値を代入するための代入式
	}

	//仮引数に年と月のみ受け取る日付クラスのためのコンストラクタ
	public En9_2_Day(int year, int month){
		this(year);								//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.month = month;						//月のフィールドに仮引数monthの値を代入するための代入式
	}

	//仮引数に年・月・日のみ受け取る日付クラスのためのコンストラクタ
	public En9_2_Day(int year, int month, int date) {
		this(year, month);						//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.date = date;						//日のフィールドに仮引数dateの値を代入するための代入式
	}

	//仮引数に日付のみ受け取る日付クラスのためのコンストラクタ
	public En9_2_Day(En9_2_Day day){
		this(day.year, day.month, day.date);	//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
	}

	//年取得のためのメソッド
	public int getYear(){
		//呼び出し元に年の値を返却するためのreturn文
		return year;
	}

	//月取得のためのメソッド
	public int getMonth(){
		//呼び出し元に月の値を返却するためのreturn文
		return month;
	}

	//日取得のためのメソッド
	public int getDate(){
		//呼び出し元に日の値を返却するためのreturn文
		return date;
	}


	//年の値を設定するためのメソッド
	public void setYear(int year){
		//仮引数の値をフィールドの値に設定するための代入式
		this.year = year;
	}

	//月の値を設定するためのメソッド
	public void setMonth(int month){
		//仮引数の値をフィールドに設定するための代入式
		this.month = month;
	}

	//日の値を設定するためのメソッド
	public void setDate(int date){
		//仮引数の値をフィールドに設定するための代入式
		this.date = date;
	}

	//曜日を求めるためのメソッド
	public int dayOfWeek(){
		int yearForWeek = year;				//曜日を求めるための年の変数にフィールドの年の値を代入する
		int monthForWeek = month;				//曜日を求めるための月の変数にフィールドの月の値を代入する

		//月の値が1または2であった場合に実行する処理のための条件式
		if(monthForWeek == 1 || monthForWeek == 2){
			//年の値を1デクリメントする
			yearForWeek--;
			//月の値に12加算し、代入する
			monthForWeek += 12;
		}

		//呼び出し元に求めた曜日の結果を返却するためのreturn文
		return (yearForWeek + yearForWeek / 100 + yearForWeek / 400 + ( 13 * monthForWeek + 8) / 5 + date) % 7;
	}

	//仮引数の値がフィールドの日付と等しいか確認するためのメソッド
	public boolean equalTo(En9_2_Day day){
		//呼び出し元に同一日付の真偽を返却するためのreturn文
		return year == day.year && month == day.month && date == day.date;
	}

	//フィールドの日付を文字列の表示として出力するためのメソッド
	public String toString(){
		//曜日のための配列の生成
		String[] weekdayString = {"日","月","火","水","木","金","土"};
		//呼び出し元に日付の文字列表示を返却するためのreturn文
		return String.format("%04d年%02d月%02d日（%s）",year, month, date, weekdayString[dayOfWeek()]);
	}



}
