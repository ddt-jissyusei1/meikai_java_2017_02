package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * 連続する要素が同じ値をもつことのないように演習6－9のプログラムを改良したプログラムを作成せよ。
 * 例えば[1, 3, 5, 5, 3, 2}とならないように。
 */
public class En6_10 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "連続する要素が同じ値を持つことがない配列を表示します。";
	//要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "要素数を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数を入力してもらうための文を出力する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値の要素数の配列を作成するため、変数に代入する
		int arrayNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		int[] arrayRandomNumbers = new int[arrayNumber];		//入力された値の要素数の配列を宣言する
		int arrayLength = arrayRandomNumbers.length;			//ループで使用するための配列の長さの変数

		//配列に乱数を代入するためのループ処理
		for(int inputRandomNumberLoop = 0; inputRandomNumberLoop < arrayLength; inputRandomNumberLoop++){
			//1～10の生成した乱数を要素に代入するためのコード
			arrayRandomNumbers[inputRandomNumberLoop] = randomNumber.nextInt(10)+1;

			//連続した要素に同じ値が入らないようにするためのループ文
			do{
				//同じ要素だった場合、再度乱数生成して代入する
				arrayRandomNumbers[inputRandomNumberLoop] = randomNumber.nextInt(10)+1;
			//配列の要素数が0以上かつ連続した要素が同じだった場合繰り返すための条件文
			}while(inputRandomNumberLoop > 0 && arrayRandomNumbers[inputRandomNumberLoop]
																	== arrayRandomNumbers[inputRandomNumberLoop-1]);

			//代入された要素の値を表示するためのコード
			System.out.println("arrayRandomNumbers[" + inputRandomNumberLoop + "] = "
																	+ arrayRandomNumbers[inputRandomNumberLoop]);
		}

	}

}
