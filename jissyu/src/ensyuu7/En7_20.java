package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayInsertの要素arrayinsert[arrayIndex]にinsertNumberを挿入するメソッドarrayInsを作成せよ。
 * 挿入に伴ってarrayInsert[arrayIndex]～arrayInsert[arrayInsert.length - 2]を一つ後方にずらさなければならない。
 */
public class En7_20 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の任意の要素に、入力された値を挿入します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//配列の各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//各要素の値の入力時に表示する定形文のための定数
	private static final String INDEX_NUMBER_STRING = "arrayInsert[%d] = ";
	//値を挿入する要素の指定の入力を促す文のための定数
	private static final String SELECT_INDEX_MESSAGE ="\n値を挿入する要素の番号を入力してください：";
	//挿入する値の入力を促す文のための定数
	private static final String INPUT_INSERT_NUMBER_MESSAGE = "\n挿入する値を入力してください：";
	//挿入結果を表示する文のための定数
	private static final String OUTPUT_INSERT_RESULT_MESSAGE = "arrayInsert[%d]に%dを挿入しました。\n";
	//挿入後の結果表示のための要素の定型文の定数
	private static final String OUTPUT_RESULT_STRING = "\narrayInsert[%d] = %d";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;						//配列の要素数のための変数
		int selectIndexNumber = 0;				//挿入する要素の指定のための変数
		int insertElementsNumber = 0;				//挿入する値のための変数

		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//挿入する配列の要素数の入力のための文の出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値を配列の要素数の宣言に使用するために変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//挿入する配列を作成するための宣言
		int[] arrayInsert = new int[arrayNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//配列の要素に値を入力するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//入力する要素のインデックスを表示するための出力
			System.out.printf(INDEX_NUMBER_STRING, inputElementsLoop);
			//入力された値を要素に代入する
			arrayInsert[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//挿入する要素の番号の入力を促す文を表示するための出力
		System.out.print(SELECT_INDEX_MESSAGE);
		//要素に挿入するメソッドで使用するために、入力された値を変数に代入する
		selectIndexNumber = inputNumberStream.nextInt();

		//挿入する値の入力を促す文を表示するための出力
		System.out.print(INPUT_INSERT_NUMBER_MESSAGE);
		//要素に挿入するメソッドで使用するために、入力された値を変数に代入する
		insertElementsNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//配列arrayInsertの指定された要素に値を挿入するためのメソッドの呼び出し
		arrayIns(arrayInsert, selectIndexNumber, insertElementsNumber);

	}

	//配列の指定された要素に値を挿入するためのメソッド
	private static void arrayIns(int[] arrayInsert, int selectIndexNumber, int insertElementsNumber){
		int arrayLength = arrayInsert.length;		//挿入する繰り返し処理で使用するため、配列の長さの値を変数に代入する

		//挿入する箇所から後ろの要素を後方に一つずつずらすための繰り返し処理
		for(int insertLoop = arrayLength; insertLoop > selectIndexNumber; insertLoop--){
			//arrayInsert[insertLoop - 2]の要素を一つ後方の要素に代入する
			arrayInsert[insertLoop - 1] = arrayInsert[insertLoop - 2];
		}

		//要素の入れ替えで挿入する箇所の要素が空になったので、挿入する値を代入する
		arrayInsert[selectIndexNumber] = insertElementsNumber;

		//挿入結果を表示するための文の出力
		System.out.printf(OUTPUT_INSERT_RESULT_MESSAGE, selectIndexNumber, insertElementsNumber);
		//挿入後の配列の要素を表示するための繰り返し処理
		for(int outputResultLoop = 0; outputResultLoop < arrayLength; outputResultLoop++){
			//配列の要素を表示するための出力
			System.out.printf(OUTPUT_RESULT_STRING, outputResultLoop, arrayInsert[outputResultLoop]);
		}
	}

}
