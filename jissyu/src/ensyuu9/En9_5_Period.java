package ensyuu9;

public class En9_5_Period {
	private En9_2_Day startingDayPeriod;								//開始日のための変数
	private En9_2_Day endDayPeriod;										//終了日のための変数

	//期間を表すクラスのためのコンストラクター
	public En9_5_Period(En9_2_Day fromPeriod, En9_2_Day toPeriod) {
		this.startingDayPeriod = fromPeriod;							//開始日のフィールドに仮引数の値を代入するための変数
		this.endDayPeriod = toPeriod;									//終了日のフィールドに仮引数の値を代入するための変数
	}

	//開始日取得のためゲットメソッド
	public En9_2_Day getStartingPeriod() {
		//呼び出し元に取得した値を返却する
		return startingDayPeriod;
	}

	//開始日を設定するためのセットメソッド
	public void setStartingPeriod(En9_2_Day fromPeriod) {
		//フィールドに仮引数の値を設定する
		this.startingDayPeriod = fromPeriod;
	}

	//終了日取得のためのゲットメソッド
	public En9_2_Day getEndPeriod() {
		//呼び出し元に取得した値を返却する
		return endDayPeriod;
	}

	//終了日を設定するためのセットメソッド
	public void setEndPeriod(En9_2_Day toPeriod) {
		//フィールドに仮引数の値を設定する
		this.endDayPeriod = toPeriod;
	}

	public void showPeriod(){
		//設定された開始日を表示確認する
		System.out.println("開始日：" + getStartingPeriod());
		//設定された終了日を表示確認する
		System.out.println("終了日：" + getEndPeriod());
	}




}
