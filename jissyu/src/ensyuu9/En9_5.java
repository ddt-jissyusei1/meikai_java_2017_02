package ensyuu9;
import java.util.Scanner;

/*
 * 開始日と終了日から構成される《期間》を表すクラスPeriodを作成せよ。フィールドは以下のようになる。
 * class Period {
 * 		private Day from;
 * 		private Day to;
 * }
 * コンストラクタやメソッドを自由に定義すること
 */
public class En9_5 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_EXPLANATION_STRING = "<<期間>>を表示するプログラムです。";
	//開始日と終了日の入力を促す文のための定数
	private static final String INPUT_PERIOD_DATE_MESSAGE = "\n開始日と終了日を西暦で入力してください。";
	//開始日の項目のための定数
	private static final String STARTING_PERIOD_COLUMN_STRING = "☆開始日☆";
	//終了日の項目のための定数
	private static final String END_PERIOD_COLUMN_STRING = "★終了日★";
	//年の項目のための定数
	private static final String YEAR_COLUMN_STRING = "年：";
	//月の項目のための定数
	private static final String MONTH_COLUMN_STRING = "月：";
	//日の項目のための定数
	private static final String DAY_COLUMN_STRING = "日:";
	//年月日変更の質問のための定数
	private static final String CHANGE_DATE_QUESTION_STRING = "\n日付を変更しますか？　はい＞＞1 いいえ＞＞0　\n：";
	//変更する日付の質問のための定数
	private static final String CHANGE_PERIOD_QUESTION_STRING ="どちらの日付を変更しますか？　開始日＞＞1　終了日＞＞0　\n：";
	//プログラム終了の通知文のための定数
	private static final String END_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputPeriodDate = new Scanner(System.in);

	static En9_5_Period testPeriod;					//期間インスタンスのための変数
	static En9_2_Day inputStartPeriodDates;			//開始日付インスタンスのための変数
	static En9_2_Day inputEndPeriodDates;			//終了日付インスタンスのための変数

	public static void main(String[] args) {
		int repeatJudgeResult = 0;					//日付変更の繰り返し判定のための変数

		//プログラムの説明文を表示する
		System.out.println(PROGRAM_EXPLANATION_STRING);

		//インスタンス生成のためのメソッドの呼び出し
		periodInstance();

		//ユーザーが希望するだけ日付変更を繰り返せるようにするための繰り返し処理
		do{
			//年月日の変更の有無を入力してもらうための文を表示する
			System.out.print(CHANGE_DATE_QUESTION_STRING);

			//日付変更の繰り返し処理を判定するためのメソッドの呼び出し
			repeatJudgeResult = repeatChangeDateJudge();

			if(repeatJudgeResult == 1){
				//日付変更の処理メソッドを呼び出す
				changePeriodDate();
			}

		//繰り返し判定の値が「１」である間処理を繰り返すための条件式
		}while(repeatJudgeResult == 1);

		//値の入力が終了したので、開いていたリソースを開放する
		inputPeriodDate.close();

		//プログラムの終了をユーザーに通知するための文を出力する
		System.out.println(END_PROGRAM_MESSAGE);

	}

	//期間インスタンス生成のためのメソッド
	public static void periodInstance(){

		//開始日と終了日の入力を促す文を表示する
		System.out.println(INPUT_PERIOD_DATE_MESSAGE);

		//開始日と終了日のインスタンスへの参照を渡した期間インスタンスの生成
		testPeriod = new En9_5_Period(inputStartPeriods(), inputEndPeriods());

		//生成した期間を表示確認するためのメソッドの呼び出し
		testPeriod.showPeriod();

	}

	//期間のインスタンスを生成するための開始日付入力メソッド
	public static En9_2_Day inputStartPeriods(){
		//開始日の入力を促す項目を表示する
		System.out.println(STARTING_PERIOD_COLUMN_STRING);

		//呼び出し元に返却するため入力された値のインスタンスへの参照で変数を初期化
		inputStartPeriodDates = new En9_2_Day(inputYear(), inputMonth(), inputDay());

		//呼び出し元に開始日付のインスタンスの参照を返却する
		return inputStartPeriodDates;

	}

	//期間のインスタンスを生成するための終了日付の入力メソッド
	public static En9_2_Day inputEndPeriods(){
		//終了日の入力を促す項目を表示する
		System.out.println(END_PERIOD_COLUMN_STRING);

		//呼び出し元に返却するため入力された値のインスタンスへの参照で変数を初期化
		inputEndPeriodDates = new En9_2_Day(inputYear(), inputMonth(), inputDay());

		//呼び出し元に終了日付のインスタンスの参照を返却する
		return inputEndPeriodDates;
	}

	//年の入力のためのメソッド
	public static int inputYear(){
		int periodYear = 0;							//年のための変数
		//年の入力のための年の項目を表示する
		System.out.print(YEAR_COLUMN_STRING);
		//呼び出し元に返却するための変数に入力された値を代入する
		periodYear = inputPeriodDate.nextInt();

		//呼び出し元に入力された値を返却する
		return periodYear;
	}

	//月の入力のためのメソッド
	public static int inputMonth(){
		int periodMonth = 0;							//月のための変数

		//月の入力を促す項目を表示する
		System.out.print(MONTH_COLUMN_STRING);
		//呼び出し元に返却するための変数に入力された値を代入する
		periodMonth = inputPeriodDate.nextInt();

		//呼び出し元に入力された値を返却する
		return periodMonth;
	}

	//日にちの入力のためのメソッド
	public static int inputDay(){
		int periodDay = 0;								//日のための変数

		//日の入力を促す項目を表示する
		System.out.print(DAY_COLUMN_STRING);
		//呼び出し元に返却するための変数に入力された値を代入する
		periodDay = inputPeriodDate.nextInt();

		//呼び出し元に入力された値を返却する
		return periodDay;
	}

	//日付変更の繰り返し判定をするためのメソッド
	public static int repeatChangeDateJudge(){
		int continueDateChange = 0;					//日付変更の有無の値のための変数

		//変更の有無判定後の処理を決定するために入力された値を変数に代入する
		continueDateChange = inputPeriodDate.nextInt();

		//入力された値を呼び出し元に返却する
		return continueDateChange;
	}

	//年月日変更のためのメソッド
	public static void changePeriodDate(){
		int selectChangePeriod = 0;					//変更する日付の選択のための変数

			//変更する日付を選択してもらうための文を出力する
			System.out.print(CHANGE_PERIOD_QUESTION_STRING);
			//変更する日付の処理を分けるため、入力された値を変数に代入する
			selectChangePeriod = inputPeriodDate.nextInt();

			//開始日付の変更選択時に実行するための処理
			if(selectChangePeriod == 1){
				//開始日を変更するためのメソッドの呼び出し
				changeStartPeriod();
			}

			//終了日付の変更選択時に実行するための処理
			if(selectChangePeriod == 0){
				//終了日付を変更するためのメソッドの呼び出し
				changeEndPeriod();
			}

			//日付を変更したことを通知するための文の表示
			System.out.println("日付を変更しました。");
			//変更した日付を表示確認するためのメソッドの呼び出し
			testPeriod.showPeriod();
	}

	//開始日付を変更するためのメソッド
	public static void changeStartPeriod(){
		//年を変更するためのメソッドを呼び出し、返却された値を開始年にセットする
		inputStartPeriodDates.setYear(inputYear());
		//月を変更するためのメソッドを呼び出し、返却された値を開始月にセットする
		inputStartPeriodDates.setMonth(inputMonth());
		//日を変更するためのメソッドを呼び出し、返却された値を開始日にセットする
		inputStartPeriodDates.setDate(inputDay());
	}

	//終了日付を変更するためのメソッド
	public static void changeEndPeriod(){
		//年を変更するためのメソッドを呼び出し、返却された値を終了年にセットする
		inputEndPeriodDates.setYear(inputYear());
		//月を変更するためのメソッドを呼び出し、返却された値を終了月にセットする
		inputEndPeriodDates.setMonth(inputMonth());
		//日を変更するためのメソッドを呼び出し、返却された値を開始日にセットする
		inputEndPeriodDates.setDate(inputDay());
	}


}
