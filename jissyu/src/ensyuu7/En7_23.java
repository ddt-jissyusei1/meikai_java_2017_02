package ensyuu7;
import java.util.Scanner;

/*
 * 配列arraySearchIndexの要素の中で、値がsearchNumberである全要素のインデックスを
 * 先頭から順に格納した配列を返却するメソッドarraySearchIndexを作成せよ。
 */
public class En7_23 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の要素の中で、探す値がある全要素の"
														+ "インデックスを順に格納した配列を返却します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力時に表示するインデックスの定形文のための定数
	private static final String ARRAY_INDEX_STRING = "arraySearchIndex[%d] =";
	//探索する値の入力を促す文のための定数
	private static final String INPUT_SEARCH_KEY_NUMBER_MESSAGE = "探索する値を入力してください：";
	//探索成功時に表示する文のための定数
	private static final String SEARCH_RESULT_SUCCESS_MESSAGE = "同じ値の要素のインデックスを配列に格納しました。";
	//探索失敗時に表示する文のための定数
	private static final String SEARCH_RESULT_FAILED_MESSAGE = "探索する値が配列にありませんでした。";
	//結果表示するインデックスの定形文のための定数
	private static final String INDEX_SEARCH_RESULT_STRING = "arraySearchResult[%d] = %d\n";


	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;							//探索する配列の要素数のための変数
		int searchKeyNumber = 0;						//探索する値のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//0以下の値が入力されている間、入力を促す処理を繰り返すための繰り返し処理
		do{
			//探索する配列の要素数の入力を促す文を表示するための出力
			System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
			//探索する配列を宣言するために、入力された値を変数に代入する
			arrayNumber = inputNumberStream.nextInt();
		//入力された値が0以下の間繰り返す条件文
		}while(arrayNumber <= 0);

		//入力された要素数で探索するための配列を宣言する
		int[] arraySearchIndex = new int[arrayNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//各要素に値を入力するための繰り返し処理
		for(int inputElementsNumberLoop = 0; inputElementsNumberLoop < arrayNumber; inputElementsNumberLoop++){
			//値を入力するインデックスを表示するための出力
			System.out.printf(ARRAY_INDEX_STRING, inputElementsNumberLoop);
			//入力された値を要素に格納する
			arraySearchIndex[inputElementsNumberLoop] = inputNumberStream.nextInt();
		}

		//表示文の区切りのための改行出力
		System.out.println();

		//作成した配列を表示するための繰り返し処理
		for(int printArrayLoop = 0; printArrayLoop < arrayNumber; printArrayLoop++){
			//配列のインデックスを表示するための定形文の出力
			System.out.printf(ARRAY_INDEX_STRING, printArrayLoop);
			//配列の要素の値を表示する
			System.out.println(arraySearchIndex[printArrayLoop]);
		}

		//探索する値の入力を促す文を表示するための出力
		System.out.print(INPUT_SEARCH_KEY_NUMBER_MESSAGE);
		//入力された値を探索で使用するために、変数に代入する
		searchKeyNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//探索する値と同じ値が格納されたインデックスを返却するためのメソッドの呼び出し
		int[] arraySearchResult = arraySearchIndex(arraySearchIndex, searchKeyNumber);

		//探索結果で処理を分岐させるためのメソッドの呼び出し
		searchResult(arraySearchResult);

	}

	//探索する値と同じ値が格納された要素のインデックスを返却するためのメソッド
	private static int[] arraySearchIndex(int[] arraySearchIndex, int keyNumber){
		//繰り返し処理で使用するため、配列の長さの値を変数に代入する
		int arrayLength = arraySearchIndex.length;
		//探索する値が格納されたインデックスを格納するするための配列の宣言
		int[] arrayIndexCount = new int[arrayLength];

		int indexCounter = 0;							//探索するキー値が格納されたインデックスをカウントするための変数

		//配列内のキー値を探索するための繰り返し処理
		for(int searchKeyLoop = 0; searchKeyLoop < arrayLength; searchKeyLoop++){
			//キー値と同じ値が要素にあった場合に実行するための分岐処理
			if(arraySearchIndex[searchKeyLoop] == keyNumber){
				//インデックスをメインメソッドに返すために、配列に格納する
				arrayIndexCount[indexCounter] = searchKeyLoop;
				//発見したインデックス数の配列を作成するために、カウンター変数を1インクリメントする
				indexCounter++;
			}
		}

		//発見したインデックス数の要素数の配列をメインメソッドに返却するための配列の宣言
		int[] arraySearchResult = new int[indexCounter];

		//インデックスをメインメソッドに返却するために、返却用配列の要素にインデックスを格納するための繰り返し処理
		for(int arrayCloneLoop = 0; arrayCloneLoop < indexCounter; arrayCloneLoop++){
			//インデックスを返却用の配列の要素にコピーする
			arraySearchResult[arrayCloneLoop] = arrayIndexCount[arrayCloneLoop];
		}

		//探索結果をメインメソッドに返却するためのreturn文
		return arraySearchResult;
	}

	//探索結果の処理を分岐させるためのメソッド
	private static void searchResult(int[] arraySearchResult){
		//探索の結果で処理を分岐させるために、返却された配列の長さの値を変数に代入する
		int arrayResultLength = arraySearchResult.length;

		int outputLoop = 0;							//出力の拡張for文のためのカウンター変数

		//返却された配列の長さが0でない場合に実行するための条件分岐
		if(arrayResultLength != 0){
			//探索結果文を表示するための出力
			System.out.println(SEARCH_RESULT_SUCCESS_MESSAGE);

			//返却されたインデックスの結果を表示するための繰り返し処理
			for(int outputElements : arraySearchResult){
				//結果表示のためのインデックスの定形文の出力
				System.out.printf(INDEX_SEARCH_RESULT_STRING, outputLoop, outputElements);
				//次のインデックスの表示のためにカウンター変数を1インクリメントする
				outputLoop++;
			}
		//返却された配列の長さが0の場合に実行するための条件分岐
		}else{
			//探索失敗の結果文を表示するための出力
			System.out.println(SEARCH_RESULT_FAILED_MESSAGE);
		}

	}
}
