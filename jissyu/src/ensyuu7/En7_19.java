package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayRemoveNから要素arrayRemoveN[removeIndexNumber]を先頭とする、
 * removeNumber個の要素を削除するメソッドarrayRemoveNを作成せよ。
 * 削除はarrayRemoveN[removeIndexNumber]より後ろの全要素をremoveNumber個前方にずらすことによって行うこと。
 * なお、移動されずにあまってしまう要素の値が変更しなくてよい。
 */
public class En7_19 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "指定されたインデックスを先頭に、指定された数だけ要素を削除します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//各要素数の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力の定型文のための定数
	private static final String INDEX_NUMBER_STRING = "arrayRemoveN[%d] =";
	//削除する先頭のインデックス番号の入力を促す文のための定数
	private static final String INPUT_REMOVE_TOP_INDEX_NUMBER = "\n削除するインデックスの番号を入力してください：";
	//削除するインデックスの個数の入力を促す文のための定数
	private static final String INPUT_REMOVE_NUMBER = "削除するインデックスの個数を入力してください：";
	//削除結果を表示する文のための定数
	private static final String OUTPUT_REMOVE_RESULT_MESSAGE = "arrayRemoveN[%d]から%d個要素を削除しました。\n";
	//削除後の配列の要素を確認する定型文のための定数
	private static final String RESULT_INDEX_NUMBER_STRING = "\narrayRemove[%d] = %d";

	public static void main(String[] args) {
		//キーボードから入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;								//配列の要素数のための変数
		int removeIndexNumber = 0;						//削除するインデックス番号のための変数
		int removeNumber = 0;								//削除する個数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//インデックスを削除する配列を作成するため、値を変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//インデックスを削除するための配列の宣言
		int[] arrayRemoveN = new int[arrayNumber];

		//配列の各要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);
		//各要素に値を入力するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//入力する要素のインデックス番号を表示するための出力
			System.out.printf(INDEX_NUMBER_STRING, inputElementsLoop);
			//入力された値を配列の要素に代入する
			arrayRemoveN[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//削除するインデックス番号の入力を促す文を表示するための出力
		System.out.print(INPUT_REMOVE_TOP_INDEX_NUMBER);
		//削除するメソッドで使用するため、入力された値を削除インデックス番号用の変数に代入する
		removeIndexNumber = inputNumberStream.nextInt();

		//削除するインデックスの個数の入力を促す文を表示するための出力
		System.out.print(INPUT_REMOVE_NUMBER);
		//削除するメソッドで使用するため、入力された値を削除個数用の変数に代入する
		removeNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//配列から要素を削除するためのメソッドの呼び出し
		arrayRemoveN(arrayRemoveN, removeIndexNumber, removeNumber);

	}

	//配列の要素を、指定インデックスから指定個数削除するためのメソッド
	private static void arrayRemoveN(int[] arrayRemoveN, int removeIndexNumber, int removeNumber){
		//インデックスを削除する繰り返し処理で使用するため、配列の長さの値を変数に代入する
		int arrayLength = arrayRemoveN.length;

		//インデックスを削除するための繰り返し処理
		for(int indexRemoveLoop = removeIndexNumber; indexRemoveLoop < arrayLength - removeNumber; indexRemoveLoop++){
			//削除するインデックスに、後ろの要素をremoveNumber個前方にずらすための代入処理
			arrayRemoveN[indexRemoveLoop] = arrayRemoveN[indexRemoveLoop + removeNumber];
		}

		//削除結果文を表示するための出力
		System.out.printf(OUTPUT_REMOVE_RESULT_MESSAGE, removeIndexNumber, removeNumber);

		//削除後の配列の要素の確認のための繰り返し処理
		for(int printArrayLoop = 0; printArrayLoop < arrayLength; printArrayLoop++){
			//配列の要素を表示するための出力
			System.out.printf(RESULT_INDEX_NUMBER_STRING, printArrayLoop, arrayRemoveN[printArrayLoop]);
		}


	}

}
