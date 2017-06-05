package ensyuu7;
import java.util.Scanner;

/*
 * 1から入力された値までの全整数の和を求めて返却するメソッドを作成せよ。
 */
public class En7_4 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "１から入力された値までの全整数の和を求めます。";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "\nどの値まで加算しますか？：";
	//結果を出力する文のための定数
	private static final String OUTPUT_SUM_RESULT_STRING = "全整数の和は%dです。";

	public static void main(String[] args) {
		//キーボードから読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int sumLimitNumber = 0;		//１から加算していく上限の値のまでの変数

		//プログラムの説明文の表示のための出力
		System.out.println(PROGRAM_MESSAGE);

		//値の入力を促す文の表示のための出力
		System.out.print(INPUT_NUMBER_MESSAGE);
		//入力された値を和を求めるために変数に代入する
		sumLimitNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//メソッドsumUpで求めた全整数の和を表示するための出力
		System.out.printf(OUTPUT_SUM_RESULT_STRING, sumUp(sumLimitNumber));
	}

	//1から入力された値までの整数の和を求めるためのメソッド
	static int sumUp(int sumLimitNumber){
		int sumLoop;		//加算する繰り返し制御のための変数
		int sumResult = 0;		//全整数の和のための変数

		//全整数の和を求めるためのループ文
		for(sumLoop = 0; sumLoop <= sumLimitNumber; sumLoop++){
			//全整数の和を求めるために、変数に1ずつインクリメントしたsumLoopの値を加算する
			sumResult += sumLoop;
		}

		//加算した結果をメインメソッドに返すためのreturn文
		return sumResult;

	}

}
