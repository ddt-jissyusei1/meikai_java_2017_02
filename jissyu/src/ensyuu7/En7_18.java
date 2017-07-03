package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayRemoveから要素arrayRemove[removeIndexNumber]を削除するメソッドarrayRemoveMethodを作成せよ。
 * 削除はarrayRemove[removeIndexNumber]より後ろの全要素を一つ前方にずらすことによって行うこと。
 * なお、移動されずにあまってしまう末尾要素arrayRemove[arrayRemove.length - 1]の値は変更しなくてよい。
 */
public class En7_18 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列から指定されたインデックスを削除します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//配列の要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の入力の定形文のための定数
	private static final String ELEMENTS_NUMBER_STRING = "arrayRemove[%d] = ";
	//削除するインデックスの入力を促す文のための定数
	private static final String INPUT_REMOVE_INDEX_MESSAGE = "\n削除するインデックスの番号を入力してください:";
	//削除結果文のための定数
	private static final String OUTPUT_REMOVE_RESULT_MESSAGE = "arrayRemove[%d]を削除しました。\n";
	//削除後の配列の要素を表示する定型文のための定数
	private static final String OUTPUT_REMOVE_RESULT_STRING = "\narrayRemove[%d] = %d";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;								//配列の要素数のための変数
		int removeIndexNumber = 0;

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//削除対象の配列を作成するため、配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値で配列を宣言するため、変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//インデックスを削除するための配列の宣言
		int[] arrayRemove = new int[arrayNumber];

		//各要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//各要素に値を代入するための繰り返し処理
		for(int inputNumberLoop = 0; inputNumberLoop < arrayNumber; inputNumberLoop++){
			//入力するインデックス番号を表示するための出力
			System.out.printf(ELEMENTS_NUMBER_STRING, inputNumberLoop);
			//入力された値を配列の要素にするための代入
			arrayRemove[inputNumberLoop] = inputNumberStream.nextInt();
		}

		//削除するインデックス番号の入力を促す文を表示するための出力
		System.out.print(INPUT_REMOVE_INDEX_MESSAGE);
		//入力された値を、削除するメソッドで使用するため変数に代入する
		removeIndexNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//インデックスを削除するためのメソッドの呼び出し
		arrayRemoveMethod(arrayRemove, removeIndexNumber);
	}

	//インデックスを削除するためのメソッド
	private static void arrayRemoveMethod(int[] arrayRemove, int removeIndexNumber){
		int arrayLength = arrayRemove.length;				//繰り返し処理で使用するため、配列の長さの値を変数に代入する

		//指定されたインデックスを削除するための繰り返し処理
		for(int removeIndexLoop = removeIndexNumber; removeIndexLoop < arrayLength - 1; removeIndexLoop++){
			//削除するインデックスに、後ろの要素を前方にひとつずらすための代入処理
			arrayRemove[removeIndexLoop] = arrayRemove[removeIndexLoop + 1];
		}

		//削除結果文を表示するための出力
		System.out.printf(OUTPUT_REMOVE_RESULT_MESSAGE, removeIndexNumber);

		//削除後の配列の要素を確認するための繰り返し処理
		for(int printArrayLoop = 0; printArrayLoop < arrayLength; printArrayLoop++){
			//配列の要素を表示するための出力
			System.out.printf(OUTPUT_REMOVE_RESULT_STRING, printArrayLoop, arrayRemove[printArrayLoop]);
		}
	}

}
