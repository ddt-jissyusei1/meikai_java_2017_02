package ensyuu6;
import java.util.Scanner;

/*
 * 配列copyArrayOneの全要素を配列copyArrayTwoに対して逆順にコピーするプログラムを作成せよ。なお、二つの配列の要素数は同一であると仮定してよい。
 */
public class En6_13 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "配列copyArrayOneの全要素を配列copyArrayTwoに逆順にコピーします。";
	//要素数の入力を促すための文の定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "要素数を入力してください：";
	//要素の値の入力を促すための文の定数
	private static final String INPUT_ELEMENT_NUMBER_MESSAGE = "要素の値を入力してください。";
	//プログラムを実行したという文のための定数
	private static final String OUTPUT_RESULT_MESSAGE = "\n要素を逆順にコピーします。";
	//配列copyArrayTwoの要素を出力する文を整形するための定数
	private static final String OUTPUT_COPY_ARRAY_TWO_FORMAT = "copyArrayTwo[%d] = %d\n";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数の入力を促す文を出力する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力されたの要素数の配列を作成するために変数に代入する
		int arrayNumber = inputNumberStream.nextInt();

		int[] copyArrayOne = new int[arrayNumber];		//コピー元として使用するための配列を宣言する
		int[] copyArrayTwo = new int[arrayNumber];		//コピー先として使用するための配列を宣言する
		int arrayLength = copyArrayOne.length;				//繰り返し処理で使用するため、配列の長さを変数に代入する

		//要素の値の入力促す文を出力する
		System.out.println(INPUT_ELEMENT_NUMBER_MESSAGE);

		//入力された値を要素に代入するための繰り返し処理
		for(int inputElementNumberLoop = 0; inputElementNumberLoop < arrayLength; inputElementNumberLoop++){
			//どの要素に入力するか判別するための文を出力する
			System.out.print("copyArrayOne[" + inputElementNumberLoop + "] = ");
			//入力された値を要素に読み込む
			copyArrayOne[inputElementNumberLoop] = inputNumberStream.nextInt();
		}

		//値の入力が終わったので開いていたリソースを開放する
		inputNumberStream.close();

		//ここから配列copyArrayTwoに逆順にコピーするコード

		//プログラムを実行するという周知文を出力する
		System.out.println(OUTPUT_RESULT_MESSAGE);

		//copyArrayOneを降順で参照していくために、要素数から1引いた値を変数に代入する
		int copyArrayOneElement = arrayNumber-1;

		//copyArrayOneの要素をcopyArrayTwoに逆順にコピーするための繰り返し処理
		for(int copyElementLoop = 0; copyElementLoop < arrayLength; copyElementLoop++){
			//要素を逆順にコピーするため、copyArrayTwo配列の最後から昇順にコピーする
			copyArrayTwo[copyElementLoop] = copyArrayOne[copyArrayOneElement];
			//コピーした要素を出力する
			System.out.printf(OUTPUT_COPY_ARRAY_TWO_FORMAT,copyElementLoop,copyArrayTwo[copyElementLoop]);
			//ひとつ前の要素を参照するために、inputElementNumberLoopを1デクリメントする
			copyArrayOneElement--;
		}

	}

}
