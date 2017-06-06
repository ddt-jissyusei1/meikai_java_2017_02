package ensyuu7;
import java.util.Scanner;

/*
 * 「正の整数値：」と表示してキーボードから正の整数値を読み込んで、
 * その値を返却するメソッドreadPlusIntを作成せよ。
 * 0や負の値が入力されたら再入力させること。
 * int readPlusInt();
 */
public class En7_9 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "正の整数値を読み込んでその値を返却します。";
	//正の整数値の入力を促す文のための定数
	private static final String INPUT_PLUS_NUMBER_MESSAGE = "正の整数値：";
	//返却した値を表示する文のための定数
	private static final String OUTPUT_RETURN_PLUS_NUMBER = "値は%dです。";

	public static void main(String[] args) {
		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//入力された値を返却させるためのメソッドを呼び出し、返却された値を表示のための変数に代入する
		int plusResult = readPlusInt();

		//返却された値を表示するための出力
		System.out.printf(OUTPUT_RETURN_PLUS_NUMBER, plusResult);
	}

	//整数値の値を返却するためのメソッド
	static int readPlusInt(){
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputPlusNumberStream = new Scanner(System.in);

		int plusNumber = 0;		//入力された値をメインメソッドに返却するための変数

		//入力された値が0以下の間入力を促す文の出力を続けるための繰り返し処理
		do{
			//正の整数値の入力を促す文を表示するための出力
			System.out.print(INPUT_PLUS_NUMBER_MESSAGE);
			//入力された値をメインメソッドに返却するために変数に代入する
			plusNumber = inputPlusNumberStream.nextInt();
		//plusNumberの値が0以下の間処理を繰り返す条件式
		}while(plusNumber <= 0);

		//値の入力が終わったので開いていたリソースを開放する
		inputPlusNumberStream.close();

		//メインメソッドに値を返却するためのreturn文
		return plusNumber;

	}

}
