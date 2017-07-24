package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayRemoveから要素arrayRemove[removeIndexNumber]を削除した配列を返却するメソッドarrayRemoveOfを作成せよ。
 * 削除はarrayRemove[index]より後ろの全要素を一つ前方にずらすことによって行うこと。
 */
public class En7_24 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列から指定インデックスを削除した配列を返却します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//配列の要素の値の入力を促す文のため定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力時に表示するインデックスの定形文のための定数
	private static final String ARRAY_INDEX_STRING = "arrayRemove[%d] =";
	//配列の要素を表示する際に出力するインデックスの定形文のための定数
	private static final String OUTPUT_ARRAY_INDEX_STRING = "\narrayRemove[%d] = %d";
	//削除するインデックスの入力を促す文のための定数
	private static final String INPUT_REMOVE_INDEX_MESSAGE = "\n削除するインデックスを入力してください：";
	//削除実行時の文のための定数
	private static final String REMOVE_SUCCESS_MESSAGE = "指定されたインデックスを削除しました。";
	//表示する削除結果のインデックスの定形文のための定数
	private static final String OUTPUT_INDEX_RESULT_STRING = "arrayRemoveResult[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;									//削除する配列の要素数のための変数
		int removeIndexNumber = 0;							//削除するインデックス番号のための変数

		//プログラムの説明をするための文を表示する出力
		System.out.println(PROGRAM_MESSAGE);

		//入力された値が0以下の間処理を繰り返すためのdo文
		do{
			//削除する配列の要素数の入力を促す文を表示するための出力
			System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
			//入力された値の要素数の配列を作成するために、変数に代入する
			arrayNumber = inputNumberStream.nextInt();

		//入力された値が0以下の間入力を促す文の表示を繰り返すための条件文
		}while(arrayNumber <= 0);

		//インデックスを削除するための配列を宣言する
		int[] arrayRemove = new int[arrayNumber];

		//要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//配列の各要素に値を入力するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//入力するインデックスを表示するための出力
			System.out.printf(ARRAY_INDEX_STRING, inputElementsLoop);
			//配列の要素に値を代入する
			arrayRemove[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//表示する文を区切るための空白行の出力
		System.out.println();

		//作成した配列を表示するためのメソッドの呼び出し
		printArray(arrayRemove, OUTPUT_ARRAY_INDEX_STRING);

		//削除するインデックスの入力を促す文を表示するための出力
		System.out.print(INPUT_REMOVE_INDEX_MESSAGE);
		//入力された値のインデックスを削除で使用するため、変数に代入する
		removeIndexNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//指定されたインデックスを削除するためのメソッドの呼び出し
		int[] removeIndexResult = arrayRemoveOf(arrayRemove, removeIndexNumber);

		//削除を実行したことを表示するための文の出力
		System.out.println(REMOVE_SUCCESS_MESSAGE);

		//削除結果を表示するために、配列を表示出力するためのメソッドの呼び出し
		printArray(removeIndexResult, OUTPUT_INDEX_RESULT_STRING);

	}

	//配列から指定されたインデックスを削除するためのメソッド
	private static int[] arrayRemoveOf(int[] arrayRemove, int removeIndexNumber){
		//インデックスの削除処理で使用するための、配列の長さの値を変数に代入
		int arrayLength = arrayRemove.length;
		//メインメソッドに返却するための配列の宣言
		int[] arrayRemoveResult = new int[arrayLength - 1];

		//削除したインデックスから後ろの全要素を一つ前方にずらすための繰り返し処理
		for(int removeIndexLoop = 0; removeIndexLoop < arrayLength - 1; removeIndexLoop++){
			//削除するインデックスより前に要素がある場合に実行するための条件分岐
			if(removeIndexLoop < removeIndexNumber){
				//前の要素の値を結果用配列に格納する
				arrayRemoveResult[removeIndexLoop] = arrayRemove[removeIndexLoop];
			//削除するインデックスより後ろの要素のための分岐処理
			}else{
				//後ろの要素を一つ前方にずらすための処理
				arrayRemoveResult[removeIndexLoop] = arrayRemove[removeIndexLoop + 1];
			}
		}

		//メインメソッドに削除結果の配列を返却するためのreturn文
		return arrayRemoveResult;
	}

	//配列を表示するための出力のメソッド
	private static void printArray(int[] arrayPrint, String arrayIndex){
		//配列を表示する繰り返し処理で使用するための、配列の長さのための変数
		int arrayLength = arrayPrint.length;

		//配列を表示するための繰り返し処理
		for(int outputArrayLoop = 0; outputArrayLoop < arrayLength; outputArrayLoop++){
			//結果を表示のためのインデックスの定形文の出力
			System.out.printf(arrayIndex, outputArrayLoop, arrayPrint[outputArrayLoop]);
		}

	}

}
