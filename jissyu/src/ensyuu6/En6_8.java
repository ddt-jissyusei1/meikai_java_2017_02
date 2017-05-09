package ensyuu6;
import java.util.Scanner;

/*
 * double型の配列の全要素の合計と平均を求めるプログラムを作成せよ。
 * 要素数と全要素の値はキーボードから読み込むこと。
 */
public class En6_8 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "double型配列の全要素の合計と平均を求めます。";
	//要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_DOUBLE_ARRAY_NUMBERS_MESSAGE = "\n要素の値を少数点で入力してください。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//配列の要素の入力を促すための文
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値の配列を宣言するための変数に代入する
		int arrayNumbers = inputStream.nextInt();

		double[] doubleArrays = new double[arrayNumbers];		//合計と平均を求めるための、入力された要素数の配列を宣言する
		int arrayLength = doubleArrays.length;						//ループで使用するための、配列の長さで初期化した変数
		double sumNumber = 0;										//要素の合計値を代入すための変数

		//要素の値を入力してもらうための文を出力する
		System.out.println(INPUT_DOUBLE_ARRAY_NUMBERS_MESSAGE);
		//配列に値を代入するためのループ
		for(int inputLoop = 0; inputLoop < arrayLength; inputLoop++){
			//代入する要素を把握するための文を出力する
			System.out.print("doubleArrays[" + inputLoop + "] = ");
			//要素に値を代入するためのコード
			doubleArrays[inputLoop] = inputStream.nextDouble();
			//合計値を計算するために、sumNumberに入力された値を加算して代入する
			sumNumber += doubleArrays[inputLoop];
		}
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		double arraysAverageNumber = sumNumber/arrayNumbers;		//全要素の平均を代入するための変数

		//配列の全要素の合計と平均を出力するための文
		System.out.println("\ndouble型配列の全要素の合計は" + sumNumber + "\n平均は" + arraysAverageNumber + "です。");
	}

}
