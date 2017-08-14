package ensyuu7;
import java.util.Scanner;

/*
 * int型の1次元配列とint型の2次元配列（行によって列数が異なる可能性がある）の全要素の値を表示する、
 * 多重定義されたメソッド群を作成せよ。
 * void printArray(int[] overloadArray)
 * void printArray(int[][] overloadArray)
 * なお、1次元配列の表示では、各要素のあいだには1文字分のスペースを空けること。
 * また、2次元配列の表示では、各列の数値の先頭が揃うように、最低限のスペースを空けること。
 */
public class En7_33 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "1次元配列と2次元配列の全要素の値を表示します。";
	//1次元配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "\n1次元配列の要素数を入力してください：";
	//2次元配列の行数の入力を促す文のための定数
	private static final String INPUT_ARRAY_MATRIX_ROW_NUMBER = "\n2次元配列の行数を入力してください：";
	//2次元配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_MATRIX_LINE_NUMBER = "各行の要素数を入力してください。";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "要素の値を入力してください。";
	//配列の行のインデックスのための定数
	private static final String INPUT_ARRAY_INDEX_STRING = "overloadArray[%d] = ";
	//要素の値を入力する際に表示する2次元配列のインデックスのための定数
	private static final String INPUT_ARRAY_MATRIX_INDEX_STRING = "overloadArrayMatrix[%d][%d] = ";
	//1次元配列の要素の結果を表示する結果文のための定数
	private static final String ARRAY_RESULT_MESSAGE = "1次元配列の要素：";
	//2次元配列の要素の結果を表示する結果文のための定数
	private static final String ARRAY_MATRIX_RESULT_MESSAGE = "2次元配列の要素：";


	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//1次元配列を作成するためのメソッドの呼び出し
		int[] makeArrayResult = makeArray();

		//配列の要素に値を入力するためのメソッドの呼び出し
		int[] overloadArray = inputElements(makeArrayResult, INPUT_ARRAY_INDEX_STRING);

		//2次元配列を作成するためのメソッドの呼び出し
		int[][] makeArrayMatrixResult = makeArrayMatrix();

		//2次元配列の要素に値を入力するためのメソッドの呼び出し
		int[][] overloadArrayMatrix = inputElements(makeArrayMatrixResult, INPUT_ARRAY_MATRIX_INDEX_STRING);

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//入力処理と結果出力を区切って表示するための空白行の出力
		System.out.println();

		//1次元配列の要素を表示する結果文のための出力
		System.out.println(ARRAY_RESULT_MESSAGE);
		//作成した1次元配列の要素を表示するための出力メソッドの呼び出し
		printArray(overloadArray);

		//次の出力と区切って表示するための改行の出力
		System.out.println("\n");

		//2次元配列の要素を表示する結果文のための出力
		System.out.println(ARRAY_MATRIX_RESULT_MESSAGE);
		//作成した2次元配列の要素を表示するための出力メソッドの呼び出し
		printArray(overloadArrayMatrix);
	}

	//1次元配列を作成するためのメソッド
	private static int[] makeArray(){
		int arrayNumber = 0;						//作成する配列の要素数のための変数

		//配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値を配列の作成で使用するために、変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//入力された値の要素数の配列を宣言する
		int[] makeArrayResult = new int[arrayNumber];

		//メインメソッドに作成したメソッドを返却するためのreturn文
		return makeArrayResult;
	}

	//2次元配列を作成するためのメソッド
	private static int[][] makeArrayMatrix(){
		int arrayRowNumber = 0;					//作成する2次元配列の行数のための変数
		int arrayLineNumber = 0;					//作成する2次元配列の列数のための変数

		//配列の行数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_MATRIX_ROW_NUMBER);
		//入力された値の行数の配列を作成するために、変数に代入する
		arrayRowNumber = inputNumberStream.nextInt();

		//入力された行数の配列の宣言
		int[][] arrayMatrix = new int[arrayRowNumber][];

		//各行の要素数の入力を促す文を表示するための出力
		System.out.println(INPUT_ARRAY_MATRIX_LINE_NUMBER);

		//各行の要素数を入力するための繰り返し処理
		for(int inputLineNumberLoop = 0; inputLineNumberLoop < arrayRowNumber; inputLineNumberLoop++){
			//要素数を入力する行のインデックスを表示するための出力
			System.out.printf(INPUT_ARRAY_INDEX_STRING, inputLineNumberLoop);
			//入力された値の要素数の配列を宣言するために、変数に代入する
			arrayLineNumber = inputNumberStream.nextInt();
			//入力された値の要素数をもつ行の配列を宣言するための処理
			arrayMatrix[inputLineNumberLoop] = new int[arrayLineNumber];
		}
		//作成した2次元配列をメインメソッドに返却するためのreturn文
		return arrayMatrix;

	}

	//1次元配列の要素に値を入力するためのメソッド
	private static int[] inputElements(int[] inputArray, String indexString){
		//要素の値を入力する繰り返し処理の制御のための、配列の長さの値の変数
		int arrayLength = inputArray.length;

		//要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//要素の値を入力するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayLength; inputElementsLoop++){
			//値を入力する配列のインデックスを表示するための出力
			System.out.printf(indexString, inputElementsLoop);
			//入力された値を配列の要素に格納するための処理
			inputArray[inputElementsLoop] = inputNumberStream.nextInt();
		}
		//値を格納した配列をメインメソッドに返却するためのreturn文
		return inputArray;
	}

	//2次元配列の要素に値を入力するためのメソッド
	private static int[][] inputElements(int[][] inputArrayMatrix, String indexString){
		//2次元配列に要素を入力する行の繰り返し制御のための配列の行の長さの変数
		int arrayRowLength = inputArrayMatrix.length;

		//要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//要素を入力する行のための繰り返し処理
		for(int inputRowLoop = 0; inputRowLoop < arrayRowLength; inputRowLoop++){
			//配列の要素を入力する列の繰り返し制御のための配列の列の長さの変数
			int arrayLineLength = inputArrayMatrix[inputRowLoop].length;
			//要素を入力する列のための繰り返し処理
			for(int inputLineLoop = 0; inputLineLoop < arrayLineLength; inputLineLoop++){
				//値を入力する配列のインデックスを表示するための出力
				System.out.printf(indexString, inputRowLoop, inputLineLoop);
				//入力された値を配列の要素に格納するための処理
				inputArrayMatrix[inputRowLoop][inputLineLoop] = inputNumberStream.nextInt();
			}
			//入力する行の配列を区切って表示するための改行の出力
			System.out.println();
		}
		//値を格納した配列をメインメソッドに返却するためのreturn文
		return inputArrayMatrix;
	}

	//1次元配列の要素の値を表示するための出力メソッド
	private static void printArray(int[] printArrays){
		int arrayLength = printArrays.length;			//配列の要素を表示する繰り返し制御のための配列の長さの変数

		//配列の要素を表示するための出力の繰り返し処理
		for(int printArrayLoop = 0; printArrayLoop < arrayLength; printArrayLoop++){
			//配列の要素を表示するための出力
			System.out.print(printArrays[printArrayLoop] + " ");
		}
	}

	//2次元配列の要素の値を表示するための出力メソッド
	private static void printArray(int[][] printArrays){
		//2次元配列の行の出力の繰り返し制御のための、配列の行の長さのための変数
		int arrayRowLength = printArrays.length;

		//出力時数値の先頭をそろえるための、各列の最大値取得のためのメソッドの呼び出し
		int[] lineMaxValue = getLineMaxValue(printArrays);
		//[%-4d]%n 左詰め最小フィールド幅指定

		//配列の行の要素の出力のための繰り返し処理
		for(int printRowLoop = 0; printRowLoop < arrayRowLength; printRowLoop++){
			//2次元配列の列の出力の繰り返し制御のための、配列の列の長さのための変数
			int arrayLineLength = printArrays[printRowLoop].length;
			//配列の列の要素の出力のための繰り返し処理
			for(int printLineLoop = 0; printLineLoop < arrayLineLength; printLineLoop++){
				int printValueNumber = lineMaxValue[printLineLoop];
				//配列の要素を表示するための出力
				System.out.print(printArrays[printRowLoop][printLineLoop]);
				//最大桁数-出力桁数の空白
				//先頭の要素出力を揃えるために出力する空白の算出のための、要素の桁数の取得
				String valueCount = String.valueOf(printArrays[printRowLoop][printLineLoop]);
				//出力する空白数のための計算
				int valueForSpace =printValueNumber - valueCount.length();
				//列の最大桁数に足りない桁数分空白を出力するための繰り返し処理
				do{
					//空白を表示するための出力
					System.out.print(" ");
					//空白数を1デクリメント
					valueForSpace--;
				//空白数が0になるまで処理を繰り返すための条件式
				}while(valueForSpace >= 0);
			}
			//次の行の要素の出力を改行するための改行の出力
			System.out.print("\n");
		}
	}

	//2次元配列の各列の要素の最大値を取得するためのメソッド
	private static int[] getLineMaxValue(int[][] arrayLineMax){
		int arrayRowLength = arrayLineMax.length;		//配列の行の長さの値のための変数
		int maxLineLength = 0;						//行の最大要素数のための変数

		//行の最大要素数取得のための繰り返し処理
		for(int rowLoop = 0; rowLoop < arrayRowLength; rowLoop++){
			//行の要素数のための変数
			int arrayLineLength = arrayLineMax[rowLoop].length;
			//最大要素数を入れ替えるための条件式
			if(maxLineLength < arrayLineLength){
				//最大要素数を入れ替えるための代入式
				maxLineLength = arrayLineLength;
			}
		}

		//各列の最大桁数を保持するための配列の宣言
		int[] lineMaxValueArray = new int[maxLineLength];

		//各列の最大桁数取得のための繰り返し処理
		for(int maxValueRowLoop = 0; maxValueRowLoop < arrayRowLength; maxValueRowLoop++){
			//最大桁数取得のための列の長さの値のための変数
			int arrayLineLength = arrayLineMax[maxValueRowLoop].length;
			//最大桁数取得のための列の繰り返し処理
			for(int maxValueLineLoop = 0; maxValueLineLoop < arrayLineLength; maxValueLineLoop++){
				//要素の桁数を数えるための代入式
				String valueCount =String.valueOf(arrayLineMax[maxValueRowLoop][maxValueLineLoop]);
				//要素の桁数のための代入式
				int valueResult =valueCount.length();

				//最大桁数を配列に保持するための条件式
				if(lineMaxValueArray[maxValueLineLoop] == 0 || lineMaxValueArray[maxValueLineLoop] < valueResult){
					//最大桁数の値を保持するための配列に格納する
					lineMaxValueArray[maxValueLineLoop] = valueResult;
				}
			}
		}
		//最大桁数を保持した配列をメインメソッドに返却するためのreturn文
		return lineMaxValueArray;
	}

}
