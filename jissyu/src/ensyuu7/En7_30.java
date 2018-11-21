package ensyuu7;
import java.util.Scanner;

/*
 * 2つのint型整数minNumberOne, minNumberTwoの最小値、3つのint型整数minNumberOne, minNumberTwo, minNumberThreeの最小値、
 * 配列minArrayの要素の最小値を求める、以下に示す多重定義されたメソッド群を作成せよ。
 * int min(int minNumberOne, minNumberTwo)
 * int min(int minNumberOne, minNumberTwo, minNumberThree)
 * int min(int[] minArray)
 */
public class En7_30 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "2つのint型整数minNumberOneとminNumberTwoの最小値、"
														+ "\n3つのint型整数minNumberOne、minNumberTwo、minNumberThreeの最小値、"
														+ "\n配列minArrayの要素の最小値をそれぞれ求めます。";
	//int型整数の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "\n最小値を求める各変数の値を入力してください。";
	//最小値を求める一つ目の変数名のための定数
	private static final String VARIABLE_NAME_STRING = "minNumberOne";
	//最小値を求める二つ目の変数名のための定数
	private static final String SECOND_VARIABLE_NAME_STRING = "minNumberTwo";
	//最小値を求める三つ目の変数名のための定数
	private static final String THIRD_VARIABLE_NAME_STRING = "minNumberThree";
	//最小値を求める配列の配列名のための変数
	private static final String MIN_ARRAY_NAME_STRING = "minArray[%d] =";
	//配列の要素を確認時に表示するインデックスのための定数
	private static final String ARRAY_INDEX_STRING = "minArray[%d] = %d\n";
	//変数の値入力時にする表示する変数名のための定数
	private static final String INPUT_VARIABLE_NUMBER_STRING = "%sの値：";
	//最小値を求める配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "\n最小値を求める配列の要素数を入力してください：";
	//配列の要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//二値の最小値の結果表示文のための定数
	private static final String OUTPUT_TWO_MIN_RESULT_STRING = "%dと%dの最小値は%dです。\n";
	//三値の最小値の結果表示文のための定数
	private static final String OUTPUT_THREE_MIN_RESULT_STRING = "%dと%dと%dの最小値は%dです。\n";
	//配列の要素の最小値の結果表示文のための定数
	private static final String OUTPUT_ARRAY_MIN_RESULT_STRING = "配列minArrayの要素の最小値は%dです。";

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//最小値を求める各変数の値の入力を促す文を表示するための出力
		System.out.println(INPUT_NUMBER_MESSAGE);

		//最小値を求める一つ目の変数に値を入力するためのメソッドの呼び出し
		int minNumberOne = insertVariableNumber(VARIABLE_NAME_STRING);

		//最小値を求める二つ目の変数に値を入力するためのメソッドの呼び出し
		int minNumberTwo = insertVariableNumber(SECOND_VARIABLE_NAME_STRING);

		//最小値を求める三つ目の変数に値を入力するためのメソッドの呼び出し
		int minNumberThree = insertVariableNumber(THIRD_VARIABLE_NAME_STRING);

		//最小値を求める配列を作成するためのメソッドの呼び出し
		int[] arrayMin = makeArray(MIN_ARRAY_NAME_STRING);

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//作成した配列を表示確認するためのメソッドの呼び出し
		printArray(arrayMin, ARRAY_INDEX_STRING);

		//結果表示を分けて出力するための改行の出力
		System.out.println();

		//二値の最小値を求めるためのメソッドを呼び出し,結果を表示するための出力
		System.out.printf(OUTPUT_TWO_MIN_RESULT_STRING,
								VARIABLE_NAME_STRING, SECOND_VARIABLE_NAME_STRING, min(minNumberOne, minNumberTwo));

		//三値の最小値を求めるためのメソッドを呼び出し、結果を表示するための出力
		System.out.printf(OUTPUT_THREE_MIN_RESULT_STRING,
								VARIABLE_NAME_STRING, SECOND_VARIABLE_NAME_STRING, THIRD_VARIABLE_NAME_STRING,
																		 min(minNumberOne, minNumberTwo, minNumberThree));
		//配列の最小値を求めるためのメソッドの呼び出し
		int[] minArrayResult =  min(arrayMin);

		//配列の最小値を求めた結果を表示するための出力
		System.out.printf(OUTPUT_ARRAY_MIN_RESULT_STRING, minArrayResult[0]);
	}

	//変数に入力された値を代入するためのメソッド
	private static int insertVariableNumber(String variableName){
		//値を入力する変数名を表示するための出力
		System.out.printf(INPUT_VARIABLE_NUMBER_STRING, variableName);
		//入力された値をメインメソッドに返却するための変数に格納する
		int variableNumber = inputNumberStream.nextInt();

		//メインメソッドに値を返却するためのreturn文
		return variableNumber;
	}

	//最小値を求める配列を作成するためのメソッド
	private static int[] makeArray(String arrayName){
		//最小値を求める配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値の要素数の配列を作成するために、変数に代入する
		int arrayNumber = inputNumberStream.nextInt();
		//メインメソッドに返却するための配列を、引数の値で宣言する
		int[] makeArrayResult = new int[arrayNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//配列の要素に値を格納するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//値を入力する配列のインデックスを表示するための出力
			System.out.printf(arrayName, inputElementsLoop);
			//入力された値を要素に格納するための代入
			makeArrayResult[inputElementsLoop] = inputNumberStream.nextInt();
		}
		//メインメソッドに作成した配列を返却するためのreturn文
		return makeArrayResult;
	}

	//配列の要素を表示するための出力メソッド
	private static void printArray(int[] printArray, String arrayIndex){
		//配列の要素を表示する繰り返し処理の制御で使用するための配列の長さの値の変数
		int arrayLength = printArray.length;

		//配列の要素を表示するための繰り返し処理
		for(int printArrayLoop = 0; printArrayLoop < arrayLength; printArrayLoop++){
			//配列の要素を表示するための出力
			System.out.printf(arrayIndex, printArrayLoop, printArray[printArrayLoop]);
		}
	}

	//二つのint型整数の最小値を求めるためのメソッド
	private static int min(int minNumberOne, int minNumberTwo){
		//二値を比較して、最小値をメインメソッドに返却するための演算子
		return minNumberOne < minNumberTwo ? minNumberOne : minNumberTwo;
	}

	//三つのint型整数の最小値を求めるためのメソッド
	private static int min(int minNumberOne, int minNumberTwo, int minNumberThree){
		//最小値を求める際の入れ替えのための変数への代入
		int minResult = minNumberOne;
		//最小値を求めるための二つ目の値を比較した条件式
		if(minNumberTwo < minResult){
			//最小値を入れ替えるための代入
			minResult = minNumberTwo;
		}
		//最小値を求めるための三つ目の値を比較した条件式
		if(minNumberThree < minResult){
			//最小値を入れ替えるための代入
			minResult = minNumberThree;
		}
		//メインメソッドに三つの値の中の最小値を返却するためのreturn文
		return minResult;
	}

	//配列の要素の最小値を求めるためのメソッド
	private static int[] min(int[] minArray){
		//最小値を求める繰り返し処理の制御のための、配列の長さの値の変数
		int arrayLength = minArray.length;
		//メインメソッドに返却する最小値のための変数
		int[] minArrayResult = new int[1];

		//最小値入れ替えのため、最初の要素を結果用の配列の要素に代入する
		minArrayResult[0] = minArray[0];

		//配列の要素の最小値を求めるための繰り返し処理
		for(int minElementsLoop = 0; minElementsLoop < arrayLength; minElementsLoop++){
			//最小値を求めるための条件式
			if(minArrayResult[0] > minArray[minElementsLoop]){
				//メインメソッドに返却する要素の最小値の値の入れ替え
				minArrayResult[0] = minArray[minElementsLoop];
			}
		}
		//メインメソッドに要素の最小値を返却するためのreturn文
		return minArrayResult;
	}

}
