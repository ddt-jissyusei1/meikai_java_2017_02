package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayRemoveNumbersから要素arrayRemoveNumber[index]を先頭とするremoveNumber個の要素を削除した配列を返却する
 * メソッドarrayRemoveOfNumberを作成せよ。
 * 削除はarrayRemoveNumbers[index]より後ろの全要素をremoveNumber個前方にずらすことによって行うこと。
 */
public class En7_25 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の指定した要素を先頭に指定した数だけ要素を削除します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//配列の要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素入力時のインデックスの定形文のための定数
	private static final String ARRAY_INDEX_STRING = "arrayRemoveNumbers[%d] =";
	//削除する先頭インデックスの入力を促す文のための定数
	private static final String INPUT_REMOVE_START_INDEX_MESSAGE = "削除を開始するインデックスを入力してください：";
	//削除するインデックスの数の入力を促す文のための定数
	private static final String INPUT_REMOVE_INDEX_NUMBER_MESSAGE = "削除するインデックスの数を入力してください：";
	//削除実行時に表示する文のための定数
	private static final String REMOVE_SUCCESS_MESSAGE = "\n配列からインデックスを削除しました。";
	//削除結果を表示するインデックスの定形文のための定数
	private static final String RESULT_ARRAY_INDEX_STRING = "arrayRemoveResult[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;								//入力された配列の要素数のための変数
		int removeStartIndexNumber = 0;					//入力された削除するインデックスのための変数
		int removeIndexNumber = 0;						//入力された削除するインデックス数のための変数

		//プログラムの説明をするための説明文の表示
		System.out.println(PROGRAM_MESSAGE);

		//削除する配列の作成のために、配列の要素数の入力を促す文を表示する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値の要素数の配列を作成するために、値を変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//インデックスを削除するための配列を宣言する
		int[] arrayRemoveNumbers = new int[arrayNumber];

		//作成した配列の要素に値を入力するための文を表示する
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//削除する配列の各要素に値を格納するための繰り返し処理
		for(int inputNumberLoop = 0; inputNumberLoop < arrayNumber; inputNumberLoop++){
			//どの要素の入力か表示するためのインデックスの出力
			System.out.printf(ARRAY_INDEX_STRING, inputNumberLoop);
			//入力された値を配列の要素に格納するための代入
			arrayRemoveNumbers[inputNumberLoop] = inputNumberStream.nextInt();
		}

		//削除を開始する先頭のインデックスの入力を促すための文を表示する
		System.out.print(INPUT_REMOVE_START_INDEX_MESSAGE);
		//インデックスを削除するメソッドで使用するため、入力された値を変数に代入する
		removeStartIndexNumber = inputNumberStream.nextInt();

		//連続したインデックスを削除するため、削除する個数の入力を促す文を表示する
		System.out.print(INPUT_REMOVE_INDEX_NUMBER_MESSAGE);
		//インデックスを削除するメソッドで使用するため、入力された値を変数に代入する
		removeIndexNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//配列から指定インデックスを指定個数削除するためのメソッドの呼び出し、
		//メソッドから返却された結果を表示するための配列に代入する
		int[] arrayRemoveResult = arrayRemoveOfNumber(arrayRemoveNumbers, removeStartIndexNumber, removeIndexNumber);

		//削除結果の配列を表示する繰り返し処理で使用するための、配列の長さの変数
		int resultArrayLength = arrayRemoveResult.length;

		//削除を実行したことを表示するための文の出力
		System.out.println(REMOVE_SUCCESS_MESSAGE);

		//削除結果を表示するための繰り返し処理
		for(int outputResultLoop = 0; outputResultLoop <resultArrayLength; outputResultLoop++){
			//インデックスを表示するための定形文の出力
			System.out.printf(RESULT_ARRAY_INDEX_STRING, outputResultLoop, arrayRemoveResult[outputResultLoop]);
		}

	}


	//配列から、指定インデックスから指定数インデックスを削除するためのメソッド
	private static int[] arrayRemoveOfNumber(int[] arrayRemoveNumbers, int removeStartIndexNumber, int removeIndexNumber){
		//インデックスを削除する繰り返し処理で使用するための配列の長さの変数
		int arrayLength = arrayRemoveNumbers.length;
		//削除結果をメインメソッドに返却するための配列の宣言
		//要素数は元の配列の長さから削除するインデックス数を引いた数を指定
		int[] arrayRemoveResult = new int[arrayLength - removeIndexNumber];

		//配列から指定インデックスを先頭に指定個数削除するための繰り返し処理
		for(int removeIndexLoop = 0; removeIndexLoop < arrayLength - removeIndexNumber; removeIndexLoop++){
			//先頭削除インデックスより前の要素の有無で処理を分けるための条件分岐
			if(removeIndexLoop < removeStartIndexNumber){
				//結果用配列に、削除インデックスより前の要素を格納する
				arrayRemoveResult[removeIndexLoop] = arrayRemoveNumbers[removeIndexLoop];
			//先頭削除インデックスより後ろの全要素の処理のための分岐
			}else{
				//後ろの全要素を、削除個数文に前方にずらし結果用配列に格納するための処理
				arrayRemoveResult[removeIndexLoop] = arrayRemoveNumbers[removeIndexLoop + removeIndexNumber];
			}
		}
		return arrayRemoveResult;
	}

}
