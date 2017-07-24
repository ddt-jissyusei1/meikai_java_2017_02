package ensyuu7;
import java.util.Scanner;

/*
 * 行列arrayMatrixFirstとarrayMatrixSecondの和を格納した2次元配列を返すメソッドを作成せよ。
 * （行数および列数が同一の配列をarrayMatrixFirstとarrayMatrixSecondに受け取ることを前提としてよい。
 */
public class En7_28 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "二つの二次元配列の和を格納した二次元配列を返します。";
	//配列の行数の入力を促す文のための定数
	private static final String INPUT_ARRAY_ROW_NUMBER_MESSAGE = "\n%dつ目の配列の行数を入力してください：";
	//配列の各行の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_LINE_NUMBER_MESSAGE = "各行の要素数を入力してください。";
	//一つ目の配列の行を表示するインデックスの定形文のための定数
	private static final String FIRST_ARRAY_ROW_INDEX_STRING = "arrayMatrixFirst[%d] =";
	//二つ目の配列の行を表示するインデックスのの定形文のための定数
	private static final String SECOND_ARRAY_ROW_INDEX_STRING = "arrayMatrixSecond[%d] =";
	//配列の各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "配列の各要素の値を入力してください。";
	//一つ目の配列の要素入力時に表示するインデックスの定形文ための定数
	private static final String FIRST_ARRAY_INDEX_STRING = "arrayMatrixFirst[%d][%d] =";
	//二つ目の配列の要素入力時に表示するインデックスの定形文のための定数
	private static final String SECOND_ARRAY_INDEX_STRING = "arrayMatrix Second[%d][%d] =";
	//一つ目の配列の要素表示時に出力するインデックスの定形文のための定数
	private static final String PRINT_FIRST_ARRAY_INDEX_STRING = "arrayMatrixFirst[%d][%d] = %d\n";
	//二つ目の配列の要素表示時に出力するインデックスの定形文のための定数
	private static final String PRINT_SECOND_ARRAY_INDEX_STRING = "arrayMatrix Second[%d][%d] = %d\n";
	//加算を実行したと表示する文のための定数
	private static final String SUM_SUCCESS_MESSAGE = "\n二つの配列の和を格納した二次元配列は：";
	//二つの配列の和を格納した配列の要素を表示するインデックスの定形文のための定数
	private static final String SUM_RESULT_ARRAY_INDEX_STRING = "sumResultArrayMatrix[%d][%d] = %d\n";
	//二つの配列の行数、列数が等しくない場合に表示する文のための定数
	private static final String ARRAY_ROW_LINE_NOT_EQUALS_MESSAGE = "二つの配列の行数または列数が等しくありません。";

	public static void main(String[] args) {
		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//一つ目の二次元配列を作成するためのメソッドの呼び出し
		int[][] arrayMatrixFirst = makeArrayMatrix(FIRST_ARRAY_INDEX_STRING, FIRST_ARRAY_ROW_INDEX_STRING, 1);
		//一つ目の配列を表示確認するため、配列を表示出力するメソッドの呼び出し
		printArray(arrayMatrixFirst, PRINT_FIRST_ARRAY_INDEX_STRING);

		//二つ目の二次元配列を作成するためのメソッドの呼び出し
		int[][] arrayMatrixSecond = makeArrayMatrix(SECOND_ARRAY_INDEX_STRING, SECOND_ARRAY_ROW_INDEX_STRING, 2);
		//二つ目の配列を表示確認するため、配列を表示出力するメソッドの呼び出し
		printArray(arrayMatrixSecond, PRINT_SECOND_ARRAY_INDEX_STRING);

		//二つの配列の行数を比較するための、一つ目の配列の行数のための変数
		int firstArrayRowLength = arrayMatrixFirst.length;
		//二つの配列の行数を比較するための、二つ目の配列の行数のための変数
		int secondArrayRowLength = arrayMatrixSecond.length;

		//二つの配列の列数を比較するための、一つ目の配列の列数のための変数
		int firstArrayLineLength = arrayMatrixFirst[0].length;
		//二つの配列の列数を比較するための、二つ目の配列の列数のための変数
		int secondArrayLineLength = arrayMatrixSecond[0].length;

		//二つの配列の行数と列数が同じであれば、加算処理を実行するための条件分岐
		if(firstArrayRowLength == secondArrayRowLength && firstArrayLineLength == secondArrayLineLength){
			//二つの配列を加算するためのメソッドの呼び出し
			int[][] addResultArray = addMatrix(arrayMatrixFirst, arrayMatrixSecond);
			//加算結果の文を表示するための出力
			System.out.println(SUM_SUCCESS_MESSAGE);
			//返却された和の結果の配列を表示するために、配列を表示出力するメソッドの呼び出し
			printArray(addResultArray, SUM_RESULT_ARRAY_INDEX_STRING);

		//二つの配列の行数、列数が等しくない場合に実行する処理のための条件分岐
		}else {
			//二つの配列の行数・列数が等しくないと表示するための出力
			System.out.println(ARRAY_ROW_LINE_NOT_EQUALS_MESSAGE);
		}

	}

	//二次元配列を作成するためのメソッド
	private static int[][] makeArrayMatrix(String indexString, String rowIndexString, int numberArray){
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayRowNumber = 0;				//配列の行数のための変数
		int arrayLineNumber = 0;				//配列の列数のための変数

		//配列の行数の入力を促すための文の出力
		System.out.printf(INPUT_ARRAY_ROW_NUMBER_MESSAGE, numberArray);
		//配列の宣言で使用するために、入力された行の値を変数に代入する
		arrayRowNumber = inputNumberStream.nextInt();

		//各行の要素数の入力を促す文を表示するための出力
		System.out.println(INPUT_ARRAY_LINE_NUMBER_MESSAGE);

		//配列の各行の列数を入力するための繰り返し処理
		for(int inputLineLoop = 0; inputLineLoop < arrayRowNumber; inputLineLoop++){
			//列数を入力する行を表示するためのインデックスの出力
			System.out.printf(rowIndexString, inputLineLoop);
			//配列の宣言で使用するために、入力された列の値を変数に代入する
			arrayLineNumber = inputNumberStream.nextInt();
		}
		//加算するための配列の宣言
		int[][] arrayMatrix = new int[arrayRowNumber][arrayLineNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//二次元配列の要素に値を入力するための繰り返し処理
		for(int inputElementsRowLoop = 0; inputElementsRowLoop < arrayRowNumber; inputElementsRowLoop++){
			//要素を入力する列のための繰り返し処理
			for(int inputElementsLineLoop = 0; inputElementsLineLoop < arrayLineNumber; inputElementsLineLoop++){
				//値を入力する要素のインデックスを表示するための出力
				System.out.printf(indexString, inputElementsRowLoop, inputElementsLineLoop);
				//入力された値を配列の要素に格納する
				arrayMatrix[inputElementsRowLoop][inputElementsLineLoop] = inputNumberStream.nextInt();
			}
		}

		//二つ目の配列の宣言が終わったら実行する処理のための条件文
		if(numberArray == 2){
			//値の入力が終了したので、開いていたリソースを開放する
			inputNumberStream.close();
		}

		//メインメソッドに宣言した配列を返すためのreturn文
		return arrayMatrix;
	}

	//配列の要素を表示するためのメソッド
	private static void printArray(int[][] arrayPrint, String indexString){
		//配列を表示する行の繰り返し制御のための、配列の行の長さのための変数
		int arrayRowLength = arrayPrint.length;
		//配列を表示する列の繰り返し制御のための、配列の列の長さのための変数
		int arrayLineLength = arrayPrint[0].length;

		//配列の要素を表示するための行の繰り返し処理
		for(int printArrayRowLoop = 0; printArrayRowLoop < arrayRowLength; printArrayRowLoop++){
			//配列の要素を表示するための列の繰り返し処理
			for(int printArrayLineLoop = 0; printArrayLineLoop < arrayLineLength; printArrayLineLoop++){
				//配列の要素を表示するための出力
				System.out.printf(indexString, printArrayRowLoop, printArrayLineLoop, arrayPrint[printArrayRowLoop][printArrayLineLoop]);}
		}

	}

	//二つの配列の要素を加算し、格納した2次元配列を返却するためのメソッド
	private static int[][] addMatrix(int[][] sumArrayFirst, int[][] sumArraySecond){
		//配列を加算する行の繰り返し処理の制御のための配列の行の長さのための変数
		int sumArrayRowLength = sumArrayFirst.length;
		//配列を加算する列の繰り返し処理の制御のための配列の列の長さのための変数
		int sumArrayLineLength = sumArrayFirst[0].length;

		//二つの配列の和を格納するための配列の宣言
		int[][] sumArrayResult = new int[sumArrayRowLength][sumArrayLineLength];

		//二つの配列を加算するための行の繰り返し処理
		for(int sumArrayRowLoop = 0; sumArrayRowLoop < sumArrayRowLength; sumArrayRowLoop++){
			//二つの配列を加算するための列の繰り返し処理
			for(int sumArrayLineLoop = 0; sumArrayLineLoop < sumArrayLineLength; sumArrayLineLoop++){
				//配列の要素を加算し、結果用配列に格納するための代入
				sumArrayResult[sumArrayRowLoop][sumArrayLineLoop] = sumArrayFirst[sumArrayRowLoop][sumArrayLineLoop]
																		+ sumArraySecond[sumArrayRowLoop][sumArrayLineLoop];
			}
		}
		//メインメソッドに加算結果の配列を返却するためのreturn文
		return sumArrayResult;
	}

}
