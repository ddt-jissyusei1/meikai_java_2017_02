package ensyuu7;
import java.util.Scanner;

/*
 *配列sumArrayの全要素の合計を求めるメソッドsumOfを作成せよ。
 */
public class En7_15 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列の全要素の合計を求めます。";
	//要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "\n要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "各要素の値を入力してください。\n";
	//要素の値の入力の定形文のための定数
	private static final String ELEMENTS_NUMBER_STRING ="sumArray[%d] =";
	//結果表示文のための定数
	private static final String OUTPUT_SUMARRAY_RESULT = "配列sumArrayの全要素の合計は%dです。";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int sumArrayNumber = 0;				//配列の要素数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//要素数の入力を促す文を表示するための出力
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値を配列の要素数で使用するために、変数に代入する
		sumArrayNumber = inputNumberStream.nextInt();

		//全要素の合計のための配列を、入力された値の要素数で宣言する
		int[] sumArray = new int[sumArrayNumber];

		//要素の値の入力を促す文を表示するための出力
		System.out.print(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//配列の各要素に入力された値を格納するための繰り返し処理
		for(int inputElementsLoop = 0; inputElementsLoop < sumArrayNumber; inputElementsLoop++){
			//入力する配列の要素を表示するための出力
			System.out.printf(ELEMENTS_NUMBER_STRING, inputElementsLoop);
			//入力された値を配列の要素にするための代入
			sumArray[inputElementsLoop] = inputNumberStream.nextInt();
		}

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//配列の全要素を合計するためのメソッドの呼び出し
		sumOf(sumArray);

	}

	//配列の全要素の合計を求めるためのメソッド
	private static void sumOf(int[] sumArray){
		int arrayLength = sumArray.length;		//繰り返し処理にしようするために、配列の長さの値を変数に代入する
		int sumArrayResult = 0;				//全要素の合計のための変数

		//全要素を合計するための繰り返し処理
		for(int sumArrayLoop = 0; sumArrayLoop < arrayLength; sumArrayLoop++){
			//配列の要素を合計用変数に加算するための計算式
			sumArrayResult += sumArray[sumArrayLoop];
		}

		//全要素の合計結果を表示するための出力
		System.out.printf(OUTPUT_SUMARRAY_RESULT, sumArrayResult);

	}

}
