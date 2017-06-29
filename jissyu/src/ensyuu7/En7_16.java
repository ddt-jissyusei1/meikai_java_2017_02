package ensyuu7;
import java.util.Scanner;

/*
 * 配列minArrayの要素の最小値を求めるメソッドminOfを作成せよ。
 */
public class En7_16 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の要素の最小値を求めます。";
	//要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力の定型文のための定数
	private static final String ELEMENTS_NUMBER_STRING = "minArray[%d] =";
	//最小値の結果文のための定数
	private static final String OUTPUT_MINIMUM_RESULT_MESSAGE = "配列minArrayの最小値は%dです。";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int minArrayNumber = 0;						//配列の要素数のための変数

		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された要素数の配列を宣言するための変数への代入
		minArrayNumber = inputNumberStream.nextInt();

		//最小値を求めるための、入力された要素数の配列を宣言する
		int[] minArray = new int[minArrayNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//各要素に値を入力するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < minArrayNumber; inputElementsLoop++){
			//入力する配列要素を表示するための出力
			System.out.printf(ELEMENTS_NUMBER_STRING, inputElementsLoop);
			//最小値を求めるため、入力された値を要素に代入する
			minArray[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//配列の要素の最小値を求めるためのメソッド呼び出し
		minOf(minArray);

	}

	//配列の要素の最小値を求めるためのメソッド
	private static void minOf(int[] minArray){
		int minArrayLength = minArray.length;			//繰り返し処理で使用する配列の長さのための変数
		int minimumElementsResult = minArray[0];		//要素の最小値のための変数。要素を比較するため、配列[0]の値で初期化する

		//配列の要素の最小値を求めるための繰り返し処理
		for(int minSearchLoop = 0; minSearchLoop < minArrayLength; minSearchLoop++){
			//配列の最小値を求めるための演算子
			//参照している要素の値が、minimumElementsResultの値より小さい→trueなら要素の値を返し、falseなら変数の値を返す
			minimumElementsResult = (minArray[minSearchLoop] < minimumElementsResult)
																	? minArray[minSearchLoop] : minimumElementsResult;
		}

		//最小値を求めた結果を表示するための出力
		System.out.printf(OUTPUT_MINIMUM_RESULT_MESSAGE, minimumElementsResult);

	}

}
