package ensyuu7;
import java.util.Scanner;

/*
 * List7-20のプログラムは、三つの配列x, y, zの行数および列数が同一であることを前提としている。
 * 三つの配列の要素数が等しければ加算を行ってtrueを返し、等しくなければ加算を行わずにfalseを返すメソッドに書きかえよ。
 */
public class En7_27 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "三つの配列の要素数が等しければ加算を行いtrueを返し、"
														+ "\n等しくなれければ加算は行わずfalseを返します。";
	//配列の行数の入力を促す文のための定数
	private static final String INPUT_ARRAY_ROW_NUMBER_MESSAGE = "\n%dつ目の配列の行数を入力してください：";
	//配列の各行の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_LINE_NUMBER_MESSAGE = "各行の要素数を入力してください:";
	//配列の各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください：";
	//一つ目の配列のインデックスを表示する定形文のための定数
	private static final String FIRST_ARRAY_INDEX_STRING = "sumArrayMatrixFirst[%d][%d] =";
	//二つ目の配列のインデックスを表示する定形文のための定数
	private static final String SECOND_ARRAY_INDEX_STRING = "sumArrayMatrixSecond[%d][%d] =";
	//三つ目の配列のインデックスを表示する定形文のための定数
	private static final String THIRD_ARRAY_INDEX_STRING = "sumArrayMatrixThird[%d][%d] =";
	//一つ目の配列の列数入力時に表示するインデックスのための定数
	private static final String FIRST_ARRAY_LINE_INDEX_STRING = "sumArrayMatrixFirst[%d] =";
	//二つ目の配列の列数入力時に表示するインデックスのための定数
	private static final String SECOND_ARRAY_LINE_INDEX_STRING = "sumArrayMatrixSecond[%d] =";
	//三つ目の配列の列数入力時に表示するインデックスのための定数
	private static final String THIRD_ARRAY_LINE_INDEX_STRING = "sumArrayMatrixThird[%d] =";
	//加算結果の配列を表示するインデックスのための定数
	private static final String SUM_RESULT_ARRAY_INDEX_STRING = "sumArrayMatrixResult[%d][%d] = ";
	//三つの配列の要素数が等しい場合に表示する文のための定数
	private static final String ARRAY_ELEMENTS_EQUALS_MESSAGE = "\n三つの配列の要素数は等しいです。";
	//三つの配列の要素数が等しくない場合に表示する文のための定数
	private static final String ARRAY_ELEMENTS_NOT_EQUALS_MESSAGE = "\n三つの配列の要素数は等しくありません。";
	//作成する配列の数のためのマジックナンバー
	private static final int ARRAY_MAGIC_NUMBER = 3;

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		//プログラムの説明をするための説明文の出力
		System.out.println(PROGRAM_MESSAGE);

		//加算する一つ目の多次元配列を作成するためのメソッドの呼び出し
		int[][] sumArrayMatrixFirst = makeArrayMatrix(FIRST_ARRAY_INDEX_STRING, FIRST_ARRAY_LINE_INDEX_STRING, 1);

		//加算する二つ目の多次元配列を作成するためのメソッドの呼び出し
		int[][] sumArrayMatrixSecond = makeArrayMatrix(SECOND_ARRAY_INDEX_STRING, SECOND_ARRAY_LINE_INDEX_STRING, 2);

		//加算する三つ目の多次元配列を作成するためのメソッドの呼び出し
		int[][] sumArrayMatrixThird = makeArrayMatrix(THIRD_ARRAY_INDEX_STRING, THIRD_ARRAY_LINE_INDEX_STRING, 3);

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//一つ目の配列の要素を表示するための出力メソッドの呼び出し
		printArrayMatrix(sumArrayMatrixFirst, FIRST_ARRAY_INDEX_STRING);

		//二つ目の配列の要素を表示するための出力メソッドの呼び出し
		printArrayMatrix(sumArrayMatrixSecond, SECOND_ARRAY_INDEX_STRING);

		//三つ目の配列の要素数を表示するための出力メソッドの呼び出し
		printArrayMatrix(sumArrayMatrixThird, THIRD_ARRAY_INDEX_STRING);

		//三つの配列の要素数を比較し、等しければ加算を行いtrueを返し、等しくなければfalseを返すメソッドの呼び出し
		boolean arrayElementsNumberJudge = judgeElementsNumber(sumArrayMatrixFirst, sumArrayMatrixSecond, sumArrayMatrixThird);

		//trueが返却された場合に行う処理ための条件分岐
		if(arrayElementsNumberJudge){
			//三つの配列の要素数が等しいという文を表示するための出力
			System.out.println(ARRAY_ELEMENTS_EQUALS_MESSAGE);
			//要素数が等しい場合に加算を行うためのメソッドの呼び出し
			int[][] sumArrayMatrixResult = addMatrix(sumArrayMatrixFirst, sumArrayMatrixSecond, sumArrayMatrixThird);

			//加算結果を表示するためのメソッドの呼び出し
			printArrayMatrix(sumArrayMatrixResult, SUM_RESULT_ARRAY_INDEX_STRING);

		//falseが返却された場合に行う処理のための条件分岐
		}else{
			//三つの配列の要素数が等しくないという文を表示するための出力
			System.out.println(ARRAY_ELEMENTS_NOT_EQUALS_MESSAGE);

		}

	}

	//加算する3つの多次元配列を作成するためのメソッド
	private static int[][] makeArrayMatrix(String indexString, String LineIndex, int arrayNumber){
		int arrayRowNumber = 0;								//入力された配列の行数のための変数
		int arrayLineNumber = 0;								//入力された配列の列数のための変数
		int arrayLength = 0;									//要素の値入力時の繰り返し処理で使用する、配列の長さのための変数

		//行数の入力を促すための文の出力
		System.out.printf(INPUT_ARRAY_ROW_NUMBER_MESSAGE, arrayNumber);
		//入力された値の行数の配列を宣言するために、変数に格納する
		arrayRowNumber = inputNumberStream.nextInt();

		//入力された値の行数の配列を宣言する
		int[][] resultArray = new int[arrayRowNumber][];

		//各行の列数の入力を促すための文の出力
		System.out.println(INPUT_ARRAY_LINE_NUMBER_MESSAGE);
		//配列の各行の列数の入力をするための繰り返し処理
		for(int arrayLineLoop = 0; arrayLineLoop < arrayRowNumber; arrayLineLoop++){
			//入力する配列の行のインデックスを表示するための出力
			System.out.printf(LineIndex, arrayLineLoop);
			//各行の列数で使用するために、入力された値を変数に格納する
			arrayLineNumber = inputNumberStream.nextInt();

			//配列の各行の列数を宣言する
			resultArray[arrayLineLoop] = new int[arrayLineNumber];
		}

		//加算する一つ目と二つ目の配列の要素の値の入力のための条件処理
		if(arrayNumber < ARRAY_MAGIC_NUMBER){
			//各要素の値の入力を促すための文の出力
			System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

			//配列の各要素に値を入力する、行数のための繰り返し処理
			for(int inputRowLoop = 0; inputRowLoop < arrayRowNumber; inputRowLoop++){
				//列数の繰り返し制御で使用するため、配列の長さを変数に格納する
				arrayLength = resultArray[inputRowLoop].length;
				//配列の各要素に値を入力する、列数のための繰り返し処理
				for(int inputLineLoop = 0; inputLineLoop < arrayLength; inputLineLoop++){
					//値を入力する要素のインデックスを表示するための出力
					System.out.printf(indexString, inputRowLoop, inputLineLoop);
					//入力された値を配列の要素に格納する
					resultArray[inputRowLoop][inputLineLoop] = inputNumberStream.nextInt();
				}
			}
		}

		//出力の表示を見やすく区切るための空白行の出力
		System.out.println();

		//メインメソッドに配列を返却するためのreturn文
		return resultArray;
	}

	//配列の要素を表示するための出力のメソッド
	private static void printArrayMatrix(int[][] arrayMatrix, String arrayIndex){
		int rowLength = arrayMatrix.length;					//行数を表示する繰り返し処理の制御のための配列の行の長さの変数

		//配列の要素を表示するための繰り返し処理
		for(int printRowLoop = 0; printRowLoop < rowLength; printRowLoop++){
			int lineLength = arrayMatrix[printRowLoop].length;			//列数を表示する繰り返し処理の制御のための配列の列数の長さの変数
			//列数を表示するための繰り返し処理
			for(int printLineLoop = 0; printLineLoop < lineLength; printLineLoop++){
				//配列のインデックスを表示するための出力
				System.out.printf(arrayIndex, printRowLoop, printLineLoop);
				//配列の要素の値を表示するための出力
				System.out.println(arrayMatrix[printRowLoop][printLineLoop]);
			}
		}
		//次に出力する配列がある場合、先に出力した配列と区切って表示するための空白行の出力
		System.out.println();
	}

	//三つの配列の要素数が等しければ加算を行いtrueを返し、等しくなければfalseを返すためのメソッド
	private static boolean judgeElementsNumber(int[][] firstArrayMatrix, int[][] secondArrayMatrix, int[][] thirdArrayMatrix){
		boolean judge = true;									//真偽を返却するための変数
		int arrayRowLength = firstArrayMatrix.length;			//配列の行数を比較するための、一つ目の配列の行数の変数
		int secondArrayRowLength = secondArrayMatrix.length;	//行数比較のための二つ目の配列の行数の値の変数
		int thirdArrayRowLength = thirdArrayMatrix.length;	//行数比較のための三つ目の配列の行数の値の変数
		int arrayLineLength = firstArrayMatrix[0].length;		//配列の列数を比較するための、一つ目の配列の列数の変数

		//三つの配列の要素数が等しいか比較確認するための繰り返し処理
		for(int compareRowLoop = 0; compareRowLoop < arrayRowLength; compareRowLoop++){
			//三つの配列の行数の長さが等しくなければ実行する処理の条件分岐
			if(arrayRowLength != secondArrayRowLength || arrayRowLength != thirdArrayRowLength){
				//メインメソッドに等しくない結果を返却するために変数にfalseを代入する
				judge = false;
				//等しくない時点でこれ以降の処理を行わないよう繰り返し処理から抜けるためのbreak文
				break;
			}
			//三つの配列の列数比較のための繰り返し処理
			for(int compareLineLoop = 0; compareLineLoop < arrayLineLength; compareLineLoop++){
				//列数比較のための、二つ目の配列の列数の値のための変数
				int secondArrayLineLength = secondArrayMatrix[compareRowLoop].length;
				//列数比較のための、三つ目の配列の列数の値のための変数
				int thirdArrayLineLength = thirdArrayMatrix[compareRowLoop].length;
				//三つの配列の列数の長さが等しくなければ実行する処理のための条件分岐
				if(arrayLineLength != secondArrayLineLength || arrayLineLength != thirdArrayLineLength){
					//メインメソッドに等しくない結果を返却するために変数にfalseを代入する
					judge = false;
					//等しくない時点でこれ以降の処理を行わないよう繰り返し処理から抜けるためのbreak文
					break;
				}
			}
		}
		//メインメソッドに真偽値を返却するためのreturn文
		return judge;
	}

	//三つの配列の要素が等しい場合に、加算を行うためのメソッド
	private static int[][] addMatrix(int[][] firstArrayMatrix, int[][] secondArrayMatrix, int[][] thirdArrayMatrix){
		int sumRowLength = firstArrayMatrix.length;			//加算を行う繰り返し処理の制御のための、配列の行の長さのための変数
		int sumLineLength = firstArrayMatrix[0].length;		//加算を行う繰り返し処理の制御のための、配列の列の長さのための変数

		//配列の要素の値を加算するための繰り返し処理
		for(int sumRowLoop = 0; sumRowLoop < sumRowLength; sumRowLoop++){
			//一つ目と二つ目の配列の要素の値を加算し、三つ目の配列の要素に格納するための繰り返し処理
			for(int sumLineLoop = 0; sumLineLoop < sumLineLength; sumLineLoop++){
				//一つ目の配列と二つ目の配列の要素の値を加算し、三つ目の配列に格納するための加算処理
				thirdArrayMatrix[sumRowLoop][sumLineLoop] = firstArrayMatrix[sumRowLoop][sumLineLoop] +
						                                           secondArrayMatrix[sumRowLoop][sumLineLoop];
			}
		}

		//メインメソッドに加算結果の配列を返すためのreturn文
		return thirdArrayMatrix;
	}



}
