package ensyuu9;
import java.util.Scanner;

/*
 * 日付クラス第３版（p.322）を利用するプログラムを作成せよ。すべてのコンストラクタの働きを確認できるようにすること。
 */
public class En9_2 {
	//プログラムの説明文のための定数
	private static final String OUTPUT_PROGRAM_MESSAGE = "日付クラスのすべてのコンストラクタの働きを確認するためのプログラムです。";
	//年の入力を促す文のための定数
	private static final String INPUT_YEAR_MESSAGE = "\n年を入力してください。\n☆年：";
	//月の入力を促す文のための定数
	private static final String INPUT_MONTH_MESSAGE = "\n月を入力してください。\n★月：";
	//日にちの入力を促す文のための定数
	private static final String INPUT_DAY_MESSAGE = "\n日を入力してください。\n☆日：";
	//年の設定通知文のための定数
	private static final String YEAR_SET_MESSAGE_STRING = "年を設定しました：%s\n";
	//月の設定通知文のための定数
	private static final String MONTH_SET_MESSAGE_STRING = "月を設定しました：%s\n";
	//日にちの設定通知文のための定数
	private static final String DAY_SET_MESSAGE_STRING = "日を設定しました：%s\n";
	//日付変更するかの問いのための定数
	private static final String CHANGE_DATE_QUESTION_MESSAGE = "\n日付を変更しますか？\n[はい]→0\n[いいえ]→1\n★:";
	//変更する日付の選択肢のための定数
	private static final String CHANGE_DATE_SELECT_STRING = "変更箇所の番号を入力してください。\n[年]→0\n[月]→1\n[日]→2\n☆:";
	//プログラムを終了する通知文のための定数
	private static final String FINISH_PROGRAM_MESSAGE ="プログラムを終了します。お疲れ様でした。";


	//キーボードからの入力ストリームを読み込むための
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		int inputYear = 0;									//入力された年の値のための変数
		int inputMonth = 0;								//入力された月の値のための変数
		int inputDay = 0;									//入力された日の値のための変数
		int changeDateSelectNumber = 0;					//日付変更の選択肢番号のための変数


		//プログラムの説明を表示するための説明文の出力
		System.out.println(OUTPUT_PROGRAM_MESSAGE);


		//引数を渡さない日付インスタンスの生成
		En9_2_Day firstDate = new En9_2_Day();

		//引数なしのコンストラクタの働きを確認するためのインスタンスの出力
		System.out.println("始まりの日付：" + firstDate);


		//ユーザーに年の入力をしてもらうための文を表示する
		System.out.print(INPUT_YEAR_MESSAGE);
		//入力された値を日付クラスに渡すためのに変数に代入する
		inputYear = inputNumberStream.nextInt();

		//年を引数にした日付インスタンスの生成
		En9_2_Day yearSetDate = new En9_2_Day(inputYear);

		//年が仮引数のコンストラクタの働きを確認するためのインスタンスの出力
		System.out.printf(YEAR_SET_MESSAGE_STRING, yearSetDate);


		//ユーザーに月の入力をしてもらうための文を表示する
		System.out.print(INPUT_MONTH_MESSAGE);
		//入力された値を日付クラスに渡すための変数に代入する
		inputMonth = inputNumberStream.nextInt();

		//年と月を引数にした日付インスタンスの生成
		En9_2_Day yearMonthSet = new En9_2_Day(inputYear, inputMonth);

		//年月が仮引数のコンストラクタの働きを確認するためのインスタンスの出力
		System.out.printf(MONTH_SET_MESSAGE_STRING, yearMonthSet);


		//ユーザーに日の入力をしてもらうための文を表示する
		System.out.print(INPUT_DAY_MESSAGE);
		//入力された値を日付クラスに渡すための変数に代入する
		inputDay = inputNumberStream.nextInt();

		//年月日を引数にした日付インスタンスの生成
		En9_2_Day yearMonthDaySet = new En9_2_Day(inputYear, inputMonth, inputDay);

		//年月日が仮引数のコンストラクタの働きを確認するためのインスタンスの出力
		System.out.printf(DAY_SET_MESSAGE_STRING, yearMonthDaySet);


		//好きなだけユーザーが日付を変更できるようにするための日付変更の繰り返し処理
		do{
			//日付を変更するかの選択をユーザーに選択してもらうための質問文の表示
			System.out.print(CHANGE_DATE_QUESTION_MESSAGE );
			//入力された値で処理を分岐させるために変数に代入する
			changeDateSelectNumber = inputNumberStream.nextInt();
			//日付変更選択の値が1の場合、プログラムを終了させるために繰り返し処理を抜ける条件式
			if(changeDateSelectNumber == 1){
				//日付変更の繰り返しを抜けるためのbreak文
				break;
			}

			//日付変更の処理のためのメソッドの呼び出し
			changeDate(yearMonthDaySet);

		//日付変更の選択の値が0である間、変更処理の流れを繰り返す
		}while(changeDateSelectNumber == 0);

		//値の入力が終了したの、開いていたリソースを開放する
		inputNumberStream.close();

		//プログラムの終了をユーザーに知らせるための文を表示する
		System.out.println(FINISH_PROGRAM_MESSAGE);

	}

	//日付を変更するためのメソッド
	private static void changeDate(En9_2_Day yearMonthDaySet){
		int selectedChangeDateNumber = 0;				//変更する日付の選択肢番号のための変数

		//変更する日付の選択をしてもらうための質問文の出力
		System.out.print(CHANGE_DATE_SELECT_STRING);
		//入力された値で処理を分岐させるために変数に代入する
		selectedChangeDateNumber = inputNumberStream.nextInt();

		//選択された番号に対応する処理を実行するための分岐処理
		switch(selectedChangeDateNumber){

			//番号0の選択で年を変更するためのメソッドの呼び出し
			case 0 : changeYear(yearMonthDaySet);
			break;

			//番号1の選択で月を変更するためのメソッドの呼び出し
			case 1 : changeMonth(yearMonthDaySet);
			break;

			//番号2の選択で日を変更するためのメソッドの呼び出し
			case 2 : changeDay(yearMonthDaySet);
			break;

		}
	}

	//年を変更するためのメソッド
	private static void changeYear(En9_2_Day yearMonthDaySet){
		int changeYear = 0;								//変更する年のための変数

		//年の入力をしてもらうための文の出力
		System.out.print(INPUT_YEAR_MESSAGE);
		//インスタンスの年を変更するために入力された値を変数に代入する
		changeYear = inputNumberStream.nextInt();
		//インスタンスの年の値を変更するためセッターの呼び出し
		 yearMonthDaySet.setYear(changeYear);

		 //変更結果を通知するための表示
		 System.out.printf("年を変更しました：%s\n",yearMonthDaySet);
	}

	//月を変更するためのメソッド
	private static void changeMonth(En9_2_Day yearMonthDaySet){
		int changeMonth = 0;								//変更する月のための変数

		//月の入力をしてもらうための文の出力
		System.out.print(INPUT_MONTH_MESSAGE);
		//インスタンスの月を変更するために入力された値を変数に代入する
		changeMonth = inputNumberStream.nextInt();
		//月の値を変更するためのセッターの呼び出し
		yearMonthDaySet.setMonth(changeMonth);

		//変更結果を通知するための表示
		System.out.printf("月を変更しました：%s\n", yearMonthDaySet);
	}

	//日を変更するためのメソッド
	private static void changeDay(En9_2_Day yearMonthDaySet){
		int changeDay = 0;									//変更する日のための変数

		//日の入力をしてもらうための文の出力
		System.out.print(INPUT_DAY_MESSAGE);
		//インスタンスの日の値を変更するために入力された値を変数に代入する
		changeDay = inputNumberStream.nextInt();
		//日の値を変更するためのセッターの呼び出し
		yearMonthDaySet.setDate(changeDay);

		//変更結果を通知するための表示
		System.out.printf("日を変更しました：%s\n", yearMonthDaySet);

	}

}
