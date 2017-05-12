package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * 要素型がint型である配列を作り、全要素を1～10の乱数で埋め尽くす（1以上10以下の値を代入する）プログラムを作成せよ。
 * 要素数はキーボードから読み込むこと。
 */
public class En6_9 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "int型要素の配列の全要素を1～10の乱数で埋めます。";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER = "要素数を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数を入力してもらうための文を出力する
		System.out.print(INPUT_ARRAY_NUMBER);
		//入力された値の配列を作成するための変数に代入する
		int arrayNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		int[] arrayRandomNumbers = new int[arrayNumber];		//入力された値の要素数の配列を宣言する
		int arrayLength = arrayRandomNumbers.length;			//ループ処理で使用するため、配列の長さを変数に代入する

		//配列に乱数を代入するためのループ処理
		for(int inputRandomNumberLoop = 0; inputRandomNumberLoop < arrayLength; inputRandomNumberLoop++){
			//1～10の乱数を生成して要素に代入するためのコード
			arrayRandomNumbers[inputRandomNumberLoop] = randomNumber.nextInt(10)+1;
			//要素の値を表示するための文
			System.out.println("arrayRandomNumbers[" + inputRandomNumberLoop + "] = " + arrayRandomNumbers[inputRandomNumberLoop]);
		}

	}
}
