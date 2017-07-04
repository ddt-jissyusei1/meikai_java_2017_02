package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayExchangeOneと配列arrayExchangeTwoの全要素の値を交換するメソッドarrayExchangeを作成せよ。
 * 二つの配列の要素数が等しくない場合は、小さいほうの要素数分の要素を交換すること。
 */
public class En7_21 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "二つの配列の全要素を交換します。\n要素数が等しくない場合は、"
														+ "小さいほうの要素数分の要素を交換します。";
	//一つ目の配列の要素数の入力を促す文のための定数
	private static final String INPUT_FIRST_ARRAY_NUMBER_MESSAGE = "一つ目の配列の要素数を入力してください：";
	//二つ目の配列の要素数の入力を促す文のための定数
	private static final String INPUT_SECOND_ARRAY_NUMBER_MESSAGE = "\n二つ目の配列の要素数を入力してください：";
	//ふたつの配列の各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "\n二つの配列の各要素の値を入力してください。";
	//要素入力時に表示する一つ目の配列のインデックス定形文のための定数
	private static final String FIRST_ARRAY_INDEX_STRING = "arrayExchangeOne[%d] =";
	//要素入力時に表示する二つ目の配列のインデックス定形文のための定数
	private static final String SECOND_ARRAY_INDEX_STRING = "arrayExchangeSecond[%d] =";
	//全要素を交換した結果文のための定数
	private static final String OUTPUT_EXCHANGE_RESULT_MESSAGE = "\n二つの配列の全要素を交換しました。";
	//交換後の一つ目の配列の要素を表示する定形文のための定数
	private static final String RESULT_FIRST_ARRAY_INDEX_STRING = "\narrayExchangeOne[%d] = %d";
	//交換後の二つ目の配列の要素を表示する定形文のための定数
	private static final String RESULT_SECOND_ARRAY_INDEX_STRING = "\narrayExchangeTwo[%d] = %d";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int firstArrayNumber = 0;						//一つ目の配列の要素数のための変数
		int secondArrayNumber = 0;					//二つ目の配列の要素数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//一つ目の配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_FIRST_ARRAY_NUMBER_MESSAGE);
		//入力された値を、配列の宣言で使用するために変数に代入する
		firstArrayNumber = inputNumberStream.nextInt();

		//要素を交換するため一つ目の配列を宣言する
		int[] arrayExchangeOne = new int[firstArrayNumber];

		//二つ目の配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_SECOND_ARRAY_NUMBER_MESSAGE);
		//入力された値を、配列の宣言で使用するために変数に代入する
		secondArrayNumber = inputNumberStream.nextInt();

		//要素を交換するための二つ目の配列を宣言する
		int[] arrayExchangeTwo = new int[secondArrayNumber];


		//二つの配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//一つ目の配列の要素に値を入力するための繰り返し処理
		for(int firstInputLoop = 0; firstInputLoop < firstArrayNumber; firstInputLoop++){
			//一つ目の配列の要素を入力するインデックスを表示するための出力
			System.out.printf(FIRST_ARRAY_INDEX_STRING, firstInputLoop);
			//入力された値を要素に代入するための処理
			arrayExchangeOne[firstInputLoop] = inputNumberStream.nextInt();
		}

		//二つの配列の要素入力の表示を区切るための改行の出力
		System.out.println();

		//二つ目の配列の要素に値を入力するための繰り返し処理
		for(int secondInputLoop = 0; secondInputLoop < secondArrayNumber; secondInputLoop++){
			//二つ目の配列の要素を入力するインデックスを表示するための出力
			System.out.printf(SECOND_ARRAY_INDEX_STRING, secondInputLoop);
			//入力された値を要素に代入するための処理
			arrayExchangeTwo[secondInputLoop] = inputNumberStream.nextInt();
		}

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//二つの配列の要素を交換するためのメソッドの呼び出し
		arrayExchange(arrayExchangeOne, arrayExchangeTwo);

	}

	//二つの配列の全要素を交換するためのメソッド
	private static void arrayExchange(int[] arrayExchangeOne, int[] arrayExchangeTwo){
		int exchangeSubVariable = 0;					//要素の交換のための予備変数
		int arrayOneLength = arrayExchangeOne.length;		//繰り返し処理で使用するための、配列の長さの変数
		int arrayTwoLength = arrayExchangeTwo.length;	//二つ目の配列の長さを比較するための、二つ目の配列の長さの変数
		int arrayLength = 0;						//小さいほうの配列の長さのための変数

		//二つの配列の長さが等しくない場合の条件分岐
		if(arrayOneLength != arrayTwoLength){
			//配列の要素数が少ないほうの配列の長さを変数に代入する
			arrayLength = arrayOneLength < arrayTwoLength ? arrayOneLength : arrayTwoLength;
		//同じ要素数の場合の条件分岐
		}else{
			//繰り返し処理で使用するため、かたほうの配列の長さを変数に代入する
			arrayLength = arrayOneLength;
		}

		//二つの配列の全要素を交換するための繰り返し処理
		for(int exchangeLoop = 0; exchangeLoop < arrayLength; exchangeLoop++){
			//要素の交換のため、一つ目の配列の要素を入れ替え用の変数に代入する
			exchangeSubVariable = arrayExchangeOne[exchangeLoop];
			//一つ目の配列の要素に、二つ目の配列の要素を移すための代入
			arrayExchangeOne[exchangeLoop] = arrayExchangeTwo[exchangeLoop];
			//二つ目の配列の要素に、一つ目の配列の要素を移すための代入
			arrayExchangeTwo[exchangeLoop] = exchangeSubVariable;
		}

		//交換が終了したことを伝えるための文の表示
		System.out.println(OUTPUT_EXCHANGE_RESULT_MESSAGE);

		//一つ目の配列の、要素の交換結果を表示するための繰り返し処理
		for(int exchangeResultLoop = 0; exchangeResultLoop < arrayOneLength; exchangeResultLoop++){
			//一つ目の配列の要素を表示するための出力
			System.out.printf(RESULT_FIRST_ARRAY_INDEX_STRING, exchangeResultLoop, arrayExchangeOne[exchangeResultLoop]);
		}

		//二つの配列の表示を区切るための改行の出力
		System.out.println();

		//二つ目の配列の、要素の交換結果を表示するための繰り返し処理
		for(int exchangeResultLoop = 0; exchangeResultLoop < arrayTwoLength; exchangeResultLoop++){
			//一つ目の配列の要素を表示するための出力
			System.out.printf(RESULT_SECOND_ARRAY_INDEX_STRING, exchangeResultLoop, arrayExchangeTwo[exchangeResultLoop]);
		}
	}

}
