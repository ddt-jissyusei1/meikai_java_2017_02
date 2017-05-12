package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * 配列の要素の並びをシャッフルする（ランダムな順となるようにかき混ぜる）プログラムを作成せよ。
 */
public class En6_12 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の要素の並びをシャッフルします。";
	//要素数の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "要素数を入力してください：";
	//結果を出力する前置き文のための定数
	private static final String OUTPUT_SHUFFLE_MESSAGE = "\n要素の並びをシャッフルしました。";
	//結果出力文を整形するための定数
	private static final String OUTPUT_RESULT_FORMAT = "arrayShuffles[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数を入力してもらうための文を出力する
		System.out.print(INPUT_ELEMENTS_NUMBER_MESSAGE);
		//入力された要素数の配列を作成するため、変数に代入する
		int arrayNumber = inputNumberStream.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputNumberStream.close();

		int[] arrayShuffles = new int[arrayNumber];			//要素の並びをシャッフルするための配列を宣言する
		int arrayLength = arrayShuffles.length;				//繰り返し処理で使用するため、配列の長さを変数に代入する

		//配列の要素に生成した乱数を代入するための繰り返し処理
		for(int inputRandomNumberLoop = 0; inputRandomNumberLoop < arrayLength; inputRandomNumberLoop++){
			//要素に乱数を代入する
			arrayShuffles[inputRandomNumberLoop] = randomNumber.nextInt(99);
			//代入された値がわかるよう出力する
			System.out.printf(OUTPUT_RESULT_FORMAT, inputRandomNumberLoop, arrayShuffles[inputRandomNumberLoop]);
		}

		//ここから要素の並びをシャッフルするためのコード

		//配列の長さだけ要素を入れ変えるための繰り返し処理
		for(int elementShuffleLoop = 0; elementShuffleLoop < arrayLength; elementShuffleLoop++){
			//参照する要素を乱数で指定するため、要素数で生成する乱数の範囲を指定して代入する
			int randomElementNumber = randomNumber.nextInt(arrayNumber);
			//入れ替えるために、要素を仮の変数に代入する
			int subShuffleNumber = arrayShuffles[randomElementNumber];
			//入れ替える要素を入れ替え先に代入する
			arrayShuffles[randomElementNumber] = arrayShuffles[elementShuffleLoop];
			//仮変数の値を入れ替え元に代入する
			arrayShuffles[elementShuffleLoop] = subShuffleNumber;
		}

		//要素の並びをシャッフルするプログラムを実行したと伝えるための文を出力する
		System.out.println(OUTPUT_SHUFFLE_MESSAGE);

		//要素の並びのシャッフル結果を出力するための繰り返し処理
		for(int inputRandomNumberLoop = 0; inputRandomNumberLoop < arrayLength; inputRandomNumberLoop++){
			//代入された値がわかるよう出力する
			System.out.printf(OUTPUT_RESULT_FORMAT, inputRandomNumberLoop, arrayShuffles[inputRandomNumberLoop]);
		}




	}

}
