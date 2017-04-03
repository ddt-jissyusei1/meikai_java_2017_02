package ensyuu4;
import java.util.Scanner;

/*
 * 身長と標準体重の対応表を表示するプログラムを作成せよ
 * 表示する身長の範囲（開始値/終了値/増分）は、整数値として読み込むこと
 * ※標準体重は（身長－１００）×０．０９によって求められる
 */
public class En4_15 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "身長と標準体重の対応表を表示します。";
	//開始値を入力してもらうための文の定数
	private static final String STARTING_HEIGHT_MESSAGE = "身長何cmから開始しますか？：";
	//終了値を入力してもらうための文の定数
	private static final String ENDING_HEIGHT_MESSAGE = "身長何cmまで表示しますか？：";
	//増分を入力してもらうための文の定数
	private static final String INCREMENT_HEIGHT_MESSAGE = "何cmごとに表示しますか？：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int startHeight = 0;					//開始する身長の値を代入するための変数startHeightを用意し、0で初期化する
		int endHeight = 0;					//終了する身長の値を代入するための変数endHeightを用意し、0で初期化する
		int incrementHeight = 0;				//増分する間隔の値を代入するための変数incrementHeightを用意し、0で初期化する

		//開始する身長の入力をしてもらう
		//整数値以外が入力される場合を考慮して、do文で繰り返し入力文を出力するようにする
		do{
			//開始する身長の入力を促す文を出力する
			System.out.print(STARTING_HEIGHT_MESSAGE);
			//入力された値を変数startHeightに代入する
			startHeight = inputStream.nextInt();
		//startHeightの値が0以下の間、入力文の出力を繰り返す
		}while(startHeight <= 0);

		//次に終了する身長の入力をしてもらう
		//同じように整数値以外が入力される場合を考慮して、do文で繰り返し入力文を出力するようにする
		do{
			//終了する身長の入力を促す文を出力する
			System.out.print(ENDING_HEIGHT_MESSAGE);
			//入力された値を変数endHeightに代入する
			endHeight = inputStream.nextInt();
		//endHeightの値が0以下の間、入力文の出力を繰り返す
		}while(endHeight <= 0);

		//最後に、増分する値を入力してもらう
		//これも整数値以外が入力される場合を考慮して、do文で繰り返し入力文を出力するようにする
		do{
			//増分する値を入力してもらう
			System.out.print(INCREMENT_HEIGHT_MESSAGE);
			//入力された値を変数incrementHeightに代入する
			incrementHeight = inputStream.nextInt();
		//incrementHeightの値が0イカの間、入力文の出力を繰り返す
		}while(incrementHeight <= 0);
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		double standardWeight = 0;			//身長から計算した標準体重の値を代入するための変数standardWeightを用意し、0で初期化する

		//身長と体重の項目名を出力する
		System.out.println("身長　体重");

		//ここから入力された値をもとに、身長と標準体重の対応表を出力していく
		//繰り返し処理のためにcounter変数を初期化部で用意し0で初期化
		//startHeightがendHeight以下の間処理を繰り返し、繰り返し毎にcounterを1インクリメントする
		for(int counter = 0; startHeight <= endHeight; counter++){
			//身長から標準体重の計算をして、standardWeightに代入する
			standardWeight = (startHeight - 100) * 0.9;
			//身長と計算結果の標準体重を出力する
			System.out.println(startHeight + "   " + standardWeight);
			//startHeightに増分の値であるincrementheightをプラスする
			startHeight += incrementHeight;
		}

	}

}
