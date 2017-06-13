package ensyuu7;
import java.util.Scanner;

/*
 * 三つのint型引数firstNumber,secondNumber,thirdNumberの最小値を求めるメソッドminを作成せよ。
 */
public class En7_2 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "三つの整数の最小値を求めます、";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "\n三つの整数を入力してください。";
	//一つ目の整数の入力文のための定数
	private static final String INPUT_FIRST_NUMBER_MESSAGE = "一つ目の整数：";
	//二つ目の整数の入力文のための定数
	private static final String INPUT_SECOND_NUMBER_MESSAGE = "二つ目の整数：";
	//三つ目の整数の入力文のための定数
	private static final String INPUT_THIRD_NUMBER_MESSAGE = "三つ目の整数：";
	//結果を表示する文のための定数
	private static final String OUTPUT_RESULT_STRING = "最小値は%dです。";


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラムa
		Scanner inputNumberStream = new Scanner(System.in);

		int firstNumber = 0;		//一つ目の値のための変数
		int secondNumber = 0;		//二つ目の値のための変数
		int thirdNumber = 0;		//三つ目の値のための変数

		//プログラムの説明のための出力
		System.out.println(PROGRAM_MESSAGE);

		//三つの整数の入力をしてもらうための文の出力
		System.out.println(INPUT_NUMBER_MESSAGE);

		//一つ目の整数の入力のための文の出力
		System.out.print(INPUT_FIRST_NUMBER_MESSAGE);
		//入力された値を比較するための一つ目の変数に代入する
		firstNumber = inputNumberStream.nextInt();

		//二つ目の整数の入力のための文の出力
		System.out.print(INPUT_SECOND_NUMBER_MESSAGE);
		//入力された値を比較するための二つ目の変数に代入する
		secondNumber = inputNumberStream.nextInt();

		//三つ目の整数の入力のための文の出力
		System.out.print(INPUT_THIRD_NUMBER_MESSAGE);
		//入力された値を比較するための三つ目の変数に代入する
		thirdNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//メソッドminで求めた最小値を表示するための結果文の出力
		System.out.printf(OUTPUT_RESULT_STRING, min(firstNumber, secondNumber, thirdNumber));
	}

	//三つの値の最小値を求めるためのメソッド
	static int min(int firstNumber, int secondNumber, int thirdNumber){
		//最小値を求めるために、一つ目の値を最小値用の変数に代入する
		int minimumNumber = firstNumber;
		//二つ目の値とminimumNumberの値を比較して最小値を入れ替えるための条件式
		if(secondNumber < minimumNumber){
			//最小値を二つ目の値に入れ替えるための代入
			minimumNumber = secondNumber;
		}
		//三つ目の値とminimumNumberの値を比較して最小値を入れ替えるための条件式
		if(thirdNumber < minimumNumber){
			//最小値を三つ目の値に入れ替えるための代入
			minimumNumber = thirdNumber;
		}
		//最小値が入っている変数をメインメソッドに返すためのreturn文
		return minimumNumber;
	}

}
