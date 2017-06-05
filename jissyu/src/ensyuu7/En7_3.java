package ensyuu7;
import java.util.Scanner;

/*
 * 三つのint型引数、firstNumber、secondNumber、thirdNumberの中央値を求めるメソッドmedを作成せよ。
 */
public class En7_3 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "三つの整数の中央値を求めます。";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "\n三つの整数を入力してください。";
	//一つ目の整数の入力文のための定数
	private static final String INPUT_FIRST_NUMBER_MESSAGE = "一つ目の整数：";
	//二つ目の整数の入力文のための定数
	private static final String INPUT_SECOND_NUMBER_MESSAGE = "二つ目の整数：";
	//三つ目の整数の入力文のための定数
	private static final String INPUT_THIRD_NUMBER_MESSAGE = "三つ目の整数：";
	//結果を表示する文のための定数
	private static final String OUTPUT_RESULT_STRING = "中央値は%dです。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int firstNumber = 0;			//中央値を求める一つ目の値のための変数
		int secondNumber = 0;			//中央値を求める二つ目の値のための変数
		int thirdNumber = 0;			//中央値を求める三つ目の値のための変数

		//プログラムの説明文の表示のための出力
		System.out.println(PROGRAM_MESSAGE);

		//値の入力を促す文の表示のための出力
		System.out.println(INPUT_NUMBER_MESSAGE);

		//一つ目の整数の入力のための文の出力
		System.out.print(INPUT_FIRST_NUMBER_MESSAGE);
		//中央値を求めるための一つ目の変数に入力された値を代入する
		firstNumber = inputNumberStream.nextInt();

		//二つ目の整数の入力のための文の出力
		System.out.print(INPUT_SECOND_NUMBER_MESSAGE);
		//中央値を求めるための二つ目の変数に入力された値を代入する
		secondNumber = inputNumberStream.nextInt();

		//三つ目の整数の入力のための文の出力
		System.out.print(INPUT_THIRD_NUMBER_MESSAGE);
		//中央値を求めるための三つ目の変数に入力された値を代入する
		thirdNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//メソッドmidで求めた中央値を表示するための出力
		System.out.printf(OUTPUT_RESULT_STRING, mid(firstNumber, secondNumber, thirdNumber));
	}

	//中央値を求めるためのメソッド
	static int mid(int firstNumber, int secondNumber, int thirdNumber){
		int switchNumber;			//三つの値を入れ替えるための予備の変数

		//中央値を求めるための最初の入れ替えの条件式
		if(secondNumber < firstNumber){
			//入れ替え時、firstNumberの値が消えないようにするための予備の変数への代入
			switchNumber = firstNumber;
			//空になったfirstNumberにsecondNumberの値を代入するためのコード
			firstNumber = secondNumber;
			//空になったsecondNumberに予備変数に代入したfirstNumberの値を代入するためのコード
			secondNumber = switchNumber;
		}

		//中央値を求めるための二番目の入れ替えの条件式
		if(thirdNumber < firstNumber){
			//入れ替え時、firstNumberの値が消えないようにするための予備の変数への代入
			switchNumber = firstNumber;
			//空になったfirstNumberにthirdNumberの値を代入するためのコード
			firstNumber = thirdNumber;
			//空になったthirdNumberに、予備変数に代入したfirstNumberの値を代入するためのコード
			thirdNumber = switchNumber;
		}

		//中央値を求めるための最後の入れ替えの条件式
		if(thirdNumber < secondNumber){
			//入れ替え時、secondNumberの値が消えないようにするための予備の変数への代入
			switchNumber = secondNumber;
			//空になったsecondNumberにthirdNumberの値を代入するためのコード
			secondNumber = thirdNumber;
			//空になったthirdNumberに、予備変数に代入したsecondNumberの値を代入するためのコード
			thirdNumber = switchNumber;
		}

		//求めた中央値をメインメソッドに返すためのreturn文
		return secondNumber;
	}

}
