package ensyuu7;
import java.util.Scanner;

/*
 *配列arrayInsertの要素arrayInsert[index]にinsertNumberを挿入した配列を返却するメソッドarrayInsertOfを作成せよ。
 *挿入に伴ってarrayInsert[index]以降の全要素をひとつ後方にずらすこと。
 */
public class En7_26 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の指定したインデックスに値を挿入します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力時に表示するインデックスの定型文のための定数
	private static final String ARRAY_INDEX_STRING = "arrayInsert[%d] =";
	//値を挿入するインデックス番号の入力を促す文のための定数
	private static final String INPUT_INSERT_INDEX_MESSAGE = "値を挿入するインデックス番号を入力してください：";
	//挿入する値の入力を促す文のための定数
	private static final String INPUT_INSERT_NUMBER_MESSAGE = "挿入する値を入力してください：";
	//挿入の処理を実行した文のための定数
	private static final String INSERT_SUCCESS_MESSAGE = "arrayInsert[%d]に値を挿入しました。\n";
	//挿入結果の比較のために表示する挿入前のインデックスの定型文のための定数
	private static final String BEFORE_INSERT_INDEX_STRING = "arrayBeforeInsert[%d] = %d\n";
	//挿入結果を表示するためのインデックスの定型文のための定数
	private static final String INSERT_RESULT_INDEX_STRING = "arrayInsertResult[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;						//値を挿入する配列の作成に使用する要素数のための変数
		int insertIndexNumber = 0;				//値を挿入するインデックスのための変数
		int insertNumber = 0;						//挿入する値のための変数

		//プログラムの説明をするための文の出力
		System.out.println(PROGRAM_MESSAGE);

		//値を挿入する配列を作成するための、要素数の入力を促す文を出力する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値を配列の宣言で使用するため、変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//値を挿入するための配列の宣言
		int[] arrayInsert = new int[arrayNumber];

		//各要素の値の入力を促す文を出力する
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//作成した配列の各要素に値を入力するための繰り返し処理
		for(int inputElementsNumberLoop = 0; inputElementsNumberLoop < arrayNumber; inputElementsNumberLoop++){
			//値を入力するインデックスを表示するための出力
			System.out.printf(ARRAY_INDEX_STRING, inputElementsNumberLoop);
			//入力された値を配列の要素に格納するための代入
			arrayInsert[inputElementsNumberLoop] = inputNumberStream.nextInt();
		}

		//値を挿入するためのインデックス番号の入力を促す文を出力する
		System.out.print(INPUT_INSERT_INDEX_MESSAGE);
		//値を挿入するメソッドで使用するため、入力された値を変数に代入する
		insertIndexNumber = inputNumberStream.nextInt();

		//挿入する値の入力を促す文を表示するための出力
		System.out.print(INPUT_INSERT_NUMBER_MESSAGE);
		//インデックスに値を挿入するため、入力された値を変数に代入する
		insertNumber = inputNumberStream.nextInt();

		//値の入力が終了したので開いていたリソースを開放する。
		inputNumberStream.close();

		//配列の指定されたインデックスに値を挿入するためのメソッドの呼び出し
		//返却された挿入結果の配列を、結果表示のための配列に代入する
		int[] insertResultArray = arrayInsertOf(arrayInsert, insertIndexNumber, insertNumber);

		//処理を実行したと表示するための文の出力
		System.out.printf(INSERT_SUCCESS_MESSAGE, insertIndexNumber);

		//結果比較のための、挿入前の配列の要素を表示するためのメソッドの呼び出し
		arrayOutPutElements(arrayInsert, BEFORE_INSERT_INDEX_STRING);

		//次の配列を区切って表示するための改行の出力
		System.out.println();

		//結果比較のための、挿入後の配列の要素を表示するためのメソッドの呼び出し
		arrayOutPutElements(insertResultArray, INSERT_RESULT_INDEX_STRING);

	}

	//配列の指定されたインデックスに値を挿入するためのメソッド
	private static int[] arrayInsertOf(int[] arrayInsert, int insertIndexNumber, int insertNumber){
		//配列に値を挿入する繰り返し処理で使用するため、配列の長さの値を変数に代入する
		int arrayLength = arrayInsert.length;
		//メインメソッドに挿入結果を返却するための配列の宣言
		//値を挿入するので、要素数は元の配列の要素を1インクリメント
		int[] insertResultArray = new int[arrayLength + 1];

		//挿入箇所以降の全要素を後ろに一つずらすための繰り返し処理
		for(int insertIndexLoop = 0; insertIndexLoop < arrayLength; insertIndexLoop++){

			//挿入するインデックスより前の要素の処理のための条件分岐
			 if(insertIndexLoop < insertIndexNumber){
				//結果用配列に、挿入インデックス前の要素を格納する
				insertResultArray[insertIndexLoop] = arrayInsert[insertIndexLoop];

			//挿入箇所以降の全要素の処理のための条件分岐
			}else{
				//挿入箇所以降の全要素を後ろに一つずらしたインデックスに格納する
				insertResultArray[insertIndexLoop + 1] = arrayInsert[insertIndexLoop];
			}
		}

		//指定されたインデックスに値を挿入する
		insertResultArray[insertIndexNumber] = insertNumber;

		//メインメソッドに挿入結果の配列を返却するためのreturn文
		return insertResultArray;
	}

	//配列の要素を表示するためのメソッド
	private static void arrayOutPutElements (int[] arrayPrint, String indexString){
		//要素を表示するための繰り返し処理で使用するため、配列の長さの値を変数に代入する
		int arrayLength = arrayPrint.length;

		//配列の要素を表示するための繰り返し処理
		for(int outPutArrayLoop = 0; outPutArrayLoop < arrayLength; outPutArrayLoop++){
			//配列の要素を表示するための出力
			System.out.printf(indexString, outPutArrayLoop, arrayPrint[outPutArrayLoop]);
		}

	}

}
