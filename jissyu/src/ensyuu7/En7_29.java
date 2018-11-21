package ensyuu7;
import java.util.Scanner;

/*
 * 2次元配列arrayCloneと同じ配列（要素数が同じで、すべての要素の値が同じ配列）を生成して返却するメソッドarrayClone2を作成せよ。
 */
public class En7_29 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "最初に作成した2次元配列と要素数・要素数の値がすべて同じ配列を生成します。";
	//配列の行数の入力を促す文のための定数
	private static final String INPUT_ROW_NUMBER_MESSAGE = "\n配列の行数を入力してください：";
	//配列の各行の列数の入力を促す文のための定数
	private static final String INPUT_LINE_NUMBER_MESSAGE = "\n各行の要素数を入力してください：";
	//要素数入力時に表示する配列の行のインデックスのための定数
	private static final String ARRAY_ROW_INDEX_STRING = "arrayClone[%d] =";
	//配列の各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "\n各要素の値を入力してください。";
	//各要素の値入力時に表示する配列のインデックスのための定数
	private static final String ARRAY_INDEX_STRING = "arrayClone[%d][%d] =";
	//生成した配列の表示確認時に表示するインデックスのための定数
	private static final String OUTPUT_ARRAY_INDEX_STRING = "\narrayClone[%d][%d] = %d";
	//2次元配列の複製を実行したと表示する文のための定数
	private static final String OUTPUT_ARRAY_CLONE_SUCCESS_MESSAGE = "\n最初に作成した2次元配列と同じ配列を生成しました。";
	//生成結果の配列の表示確認時に表示するインデックスのための定数
	private static final String ARRAY_CLONE_RESULT_INDEX_STRING = "cloneResultArray[%d][%d] = [%d]\n";

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//コピー元の配列を生成するため、2次元配列を生成するメソッドの呼び出し
		int[][] makeArrayResult = makeArrayMatrix(ARRAY_ROW_INDEX_STRING);

		//生成した配列の要素に値を入力するためのメソッドの呼び出し
		int[][] arrayClone = inputArrayElements(makeArrayResult, ARRAY_INDEX_STRING);

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//生成した配列を表示確認するための、配列を表示出力するメソッドの呼び出し
		printArrayMatrix(arrayClone, OUTPUT_ARRAY_INDEX_STRING);

		//配列の作成と結果出力の表示を区切るための改行の出力
		System.out.println();

		//生成した配列と要素数・要素の値がすべて同じ配列を生成するためのメソッドの呼び出し
		int[][] cloneResultArray = arrayClone2(arrayClone);

		//最初に生成した2次元配列の複製を実行したと表示する文のための出力
		System.out.println(OUTPUT_ARRAY_CLONE_SUCCESS_MESSAGE);

		//複製結果を表示確認するために、配列を出力するメソッドの呼び出し
		printArrayMatrix(cloneResultArray, ARRAY_CLONE_RESULT_INDEX_STRING);
	}

	//配列を作成するためのメソッド
	private static int[][] makeArrayMatrix(String rowIndexString){
		int arrayRowNumber = 0;								//2次元配列を生成するための行数のための変数
		int arrayLineNumber =0;								//2次元配列を生成するための列数のための変数

		//入力された値が0以下である間入力を促す文を表示する処理を繰り返すためのdo文
		do{
			//コピー元の配列を生成するため、行数の入力を促す文を表示するための出力
			System.out.print(INPUT_ROW_NUMBER_MESSAGE);
			//入力された値の行数の配列を生成するために、入力された値を変数に代入する
			arrayRowNumber = inputNumberStream.nextInt();
		//入力された値が0以下である間処理を繰り返すための条件式
		}while(arrayRowNumber <= 0);

		//列数を入力するために、配列を宣言する
		int[][] makeArrayResult = new int[arrayRowNumber][];

		//配列の各行の列数の入力を促す文を表示するための出力
		System.out.println(INPUT_LINE_NUMBER_MESSAGE);

		//配列の各行の要素数を入力するためのループ処理
		for(int inputLineNumberLoop = 0; inputLineNumberLoop < arrayRowNumber; inputLineNumberLoop++){
			//1以上の値が入力されるまで、列の入力を促す処理を繰り返すためのdo文
			do{
				//列数を入力する行のインデックスを表示するための出力
				System.out.printf(rowIndexString, inputLineNumberLoop);
				//入力された値の列数の配列を生成するために、入力された値を変数に代入する
				arrayLineNumber = inputNumberStream.nextInt();
			//入力された値が0以下の間のみ上記処理を繰り返すための条件文
			}while(arrayLineNumber <= 0);
			//入力された値の列数の配列を宣言する
			makeArrayResult[inputLineNumberLoop] = new int[arrayLineNumber];
		}
		//メインメソッドに生成した配列を返却するためのreturn文
		return makeArrayResult;
	}

	//配列の要素に値を入力するためのメソッド
	private static int[][] inputArrayElements(int[][] arrayClone, String indexString){
		//配列の要素に値を入力する行の繰り返し処理の制御のための、行の長さの値のための変数
		int arrayRowLength = arrayClone.length;;

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//配列の要素に値を入力するための、配列の行の繰り返し処理
		for(int inputElementsRowLoop = 0; inputElementsRowLoop < arrayRowLength; inputElementsRowLoop++){
			//配列の要素に値を入力する列の繰り返し処理の制御のための、列の長さの値のための変数
			int arrayLineLength = arrayClone[inputElementsRowLoop].length;
			//配列の要素に値を入力するための、配列の列の繰り返し処理
			for(int inputElementsLineLoop = 0; inputElementsLineLoop < arrayLineLength; inputElementsLineLoop++){
				//値を入力する要素のインデックスを表示するための出力
				System.out.printf(indexString, inputElementsRowLoop, inputElementsLineLoop);
				//入力された値を配列の要素に格納するための代入
				arrayClone[inputElementsRowLoop][inputElementsLineLoop] = inputNumberStream.nextInt();
			}
		}
		//メインメソッドに要素の値が入力された配列を返却するためのreturn文
		return arrayClone;
	}

	//配列の要素を表示する出力ためのメソッド
	private static void printArrayMatrix(int[][] printArray, String printIndexString){
		//配列を表示する行の繰り返し処理の制御のための、行の長さの値のための変数
		int printArrayRowLength = printArray.length;

		//配列を表示するための行の繰り返し処理
		for(int printArrayRowLoop = 0; printArrayRowLoop < printArrayRowLength; printArrayRowLoop++){
			//配列を表示する列の繰り返し処理の制御のための、列の長さの値のための変数
			int printArrayLineLength = printArray[printArrayRowLoop].length;
			//配列を表示するための列の繰り返し処理
			for(int printArrayLineLoop = 0; printArrayLineLoop < printArrayLineLength; printArrayLineLoop++){
				//配列を表示確認するための、配列の要素の出力
				System.out.printf(printIndexString, printArrayRowLoop, printArrayLineLoop,
													printArray[printArrayRowLoop][printArrayLineLoop]);
			}
		}
	}

	//要素数・要素の値がすべて同じ配列を生成するためのメソッド
	private static int[][] arrayClone2(int[][] cloneBaseArray){
		//配列を複製するための、複製元の配列の行の長さの値のための変数
		int cloneArrayRowLength = cloneBaseArray.length;

		//複製元の配列の列を複製するための複製する配列の宣言
		int[][] arrayClone = new int[cloneArrayRowLength][];

		//配列の要素を複製するための、配列の行の繰り返し処理
		for(int cloneArrayRowLoop = 0; cloneArrayRowLoop < cloneArrayRowLength; cloneArrayRowLoop++){
			//配列を複製するための、複製元の配列の列の長さの値のための変数
			int cloneArrayLineLength = cloneBaseArray[cloneArrayRowLoop].length;
			//配列の列数を複製するための、複製する配列の列数の宣言
			arrayClone[cloneArrayRowLoop] = new int[cloneArrayLineLength];
			//配列の要素を複製するための、配列の列の繰り返し処理
			for(int cloneArrayLineLoop = 0; cloneArrayLineLoop < cloneArrayLineLength; cloneArrayLineLoop++){
				//複製元の要素の値を複製先の配列の要素に格納する
				arrayClone[cloneArrayRowLoop][cloneArrayLineLoop] = cloneBaseArray[cloneArrayRowLoop][cloneArrayLineLoop];
			}
		}
		//メインメソッドに複製結果の２次元配列を返却するためのreturn文
		return arrayClone;
	}

}
