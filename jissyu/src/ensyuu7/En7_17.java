package ensyuu7;
import java.util.Scanner;

/*
 * メソッドlinearSearchは、探索するキーと同じ値の要素が複数個存在する場合、最も先頭に位置する要素を見つけるものである。
 * 最も末尾側に位置する要素を見つけるメソッドlinearSearchRを作成せよ。
 */
public class En7_17 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された値を探索値として、配列の最も末尾側にある要素を見つけます。";
	//探索用の配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素の値入力の定型文のための定数
	private static final String ELEMENTS_NUMBER_STRING = "linearSearchArray[%d] =";
	//探索値の入力を促す文のための定数
	private static final String INPUT_KEY_NUMBER_MESSAGE = "\n探索する値を入力してください:";
	//探索成功の結果文のための定数
	private static final String OUTPUT_SEARCH_SUCCESS_MESSAGE = "その値はlinearSearchArray[%d]にあります。";
	//探索失敗の結果文のための定数
	private static final String OUTPUT_SEARCH_FAIL_MESSAGE = "その値はこの配列にはありません。";
	//探索失敗時の返却値のための定数
	private static final int FAIL_RETURN_NUMBER = -1;

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;								//配列の要素数のための変数
		int keyNumber = 0;									//探索値のための変数
		int searchResultNumber = 0;						//探索結果のための変数

		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//探索用の配列を作成するため、値を変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//探索のための配列を、入力された要素数で宣言する
		int[] linearSearchArray = new int[arrayNumber];

		//配列の要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//各要素に値を代入するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//入力する配列の要素を表示するための出力
			System.out.printf(ELEMENTS_NUMBER_STRING, inputElementsLoop);
			//入力された値を要素を代入する
			linearSearchArray[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//探索値の入力を促す文を表示するための出力
		System.out.print(INPUT_KEY_NUMBER_MESSAGE);
		//入力された値をキー値をするため、変数に代入する
		keyNumber = inputNumberStream.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputNumberStream.close();

		//線形探索で、配列の最も末尾側にある探索値を見つけるメソッドの呼び出し
		searchResultNumber = linearSearchR(linearSearchArray, keyNumber);

		//探索失敗の場合に実行するための条件分岐
		if(searchResultNumber == FAIL_RETURN_NUMBER){
			//探索失敗の結果文を表示するための出力
			System.out.println(OUTPUT_SEARCH_FAIL_MESSAGE);
		//探索成功の場合に実行するための条件分岐
		}else{
			//探索成功の結果文を表示するための出力
			System.out.printf(OUTPUT_SEARCH_SUCCESS_MESSAGE, searchResultNumber);
		}
	}

	//線形探索で、配列の最も末尾側の探索値を見つけるメソッド
	private static int linearSearchR(int[] linearSearchArray, int keyNumber){
		int searchResult = FAIL_RETURN_NUMBER;			//探索結果のための変数

		//繰り返し制御で使用するため、配列の長さの値を変数に代入する
		int arrayLength = linearSearchArray.length;

		//末尾側の探索値を探すための繰り返し処理
		for(int reverseSearchLoop = arrayLength-1; reverseSearchLoop >= 0; reverseSearchLoop--){
			//探索値を見つけた場合のみ実行するための条件式
			if(linearSearchArray[reverseSearchLoop] == keyNumber){
				//配列のインデックスをメインメソッドに返却するため、変数に代入する
				searchResult = reverseSearchLoop;
			}
		}
		//結果をメインメソッドに返すためのreturn文
		return searchResult;
	}

}
