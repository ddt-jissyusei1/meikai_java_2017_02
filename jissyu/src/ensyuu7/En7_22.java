package ensyuu7;
import java.util.Scanner;

/*
 * 配列arrayCloneと同じ配列（要素数が同じで、すべての要素の値が同じ配列）を生成して返却するメソッドgenerateArrayCloneを作成せよ。
 */
public class En7_22 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列arrayCloneと要素数・要素の値がすべて同じ配列を作成します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "配列の要素数を入力してください：";
	//配列の要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//要素入力時に表示するインデックスの定形文のための定数
	private static final String ARRAY_INDEX_STRING = "arrayClone[%d] =";
	//作成結果を表示するための文の定数
	private static final String OUTPUT_CLONE_RESULT_MESSAGE = "\n配列arrayCloneとすべてが同じ配列を作成しました。";
	//作成した配列の結果を表示するインデックスの定形文のための定数
	private static final String RESULT_ARRAY_INDEX_STRING = "arrayCloneResult[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int arrayNumber = 0;							//配列の要素数のための変数

		//プログラムの説明を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//複製する配列の要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値で配列を宣言するために、変数に代入する
		arrayNumber = inputNumberStream.nextInt();

		//複製するための配列を宣言する
		int[] arrayClone = new int[arrayNumber];

		//配列の各要素の値の入力を促す文を表示するための出力
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);
		//各要素に値を代入するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < arrayNumber; inputElementsLoop++){
			//値を入力するインデックスを表示するための出力
			System.out.printf(ARRAY_INDEX_STRING, inputElementsLoop);
			//入力された値を要素に代入する
			arrayClone[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//要素数・要素の値がすべて同じ配列を作成するためのメソッドの呼び出し
		int[] arrayCloneResult = generateArrayClone(arrayClone);

		//作成結果を表示する文のための出力
		System.out.println(OUTPUT_CLONE_RESULT_MESSAGE);

		int resultLength = arrayCloneResult.length;		//作成結果を出力する繰り返し処理のための変数

		//作成した配列を確認のために表示する出力の繰り返し処理
		for(int outputResultLoop = 0; outputResultLoop < resultLength; outputResultLoop++){
			//作成した配列の要素を表示するための出力
			System.out.printf(RESULT_ARRAY_INDEX_STRING, outputResultLoop, arrayCloneResult[outputResultLoop]);
		}

	}

	//要素数・要素の値がすべて同じ配列を作成するためのメソッド
	private static int[] generateArrayClone(int[] arrayClone){
		//元の配列と同じ要素数の配列を宣言するため、元の配列の長さを変数に代入する
		int arrayLength = arrayClone.length;

		//複製するための配列の宣言
		int[] cloneResult = new int[arrayLength];

		//元の配列の要素の値を複製するための繰り返し処理
		for(int cloneElementsLoop = 0; cloneElementsLoop < arrayLength; cloneElementsLoop++){
			//作成する配列の要素に、元の配列の要素の値を代入する
			cloneResult[cloneElementsLoop] = arrayClone[cloneElementsLoop];
		}

		//作成した配列をメインメソッドに返却するためのreturn文
		return cloneResult;
	}

}
