package ensyuu5;
import java.util.Scanner;

/*
 * 三つの整数値を読み込んで、その合計と平均を表示するプログラムを作成せよ。
 * 平均はキャスト演算子を利用して求め、実数として表示すること。
 */
public class En5_5 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "三つの整数値の合計と平均を求めます。";
	//一つ目の値の入力を促す文のための定数
	private static final String INPUT_FIRST_NUMBER_MESSAGE = "一つ目の値を入力してください：";
	//二つ目の値の入力を促す文のための定数
	private static final String INPUT_SECOND_NUMBER_MESSAGE = "二つ目の値を入力してください：";
	//三つ目の値の入力を促す文のための定数
	private static final String INPUT_THIRD_NUMBER_MESSAGE = "三つ目の値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int sumNumber = 0;			//三つの値を加算、代入するための変数を用意し、0で初期化する

		//一つ目の値の入力を促す文を出力する
		System.out.print(INPUT_FIRST_NUMBER_MESSAGE);
		//入力された値をsumNuberに代入する
		sumNumber = inputStream.nextInt();

		//二つ目の値の入力を促す文を出力する
		System.out.print(INPUT_SECOND_NUMBER_MESSAGE);
		//入力された二つ目の値をsumNumberの値に加算して代入する
		sumNumber += inputStream.nextInt();

		//三つ目の値の入力を促す文を出力する
		System.out.print(INPUT_THIRD_NUMBER_MESSAGE);
		//入力された三つ目の値をsumNumberに加算して代入する
		sumNumber += inputStream.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//三つの値の合計と平均を出力する
		//平均は実数として表示するため、double型にキャストする
		System.out.println("\n三つの整数値の合計は" + sumNumber + "\n平均は" + (double)sumNumber/3 + "です。" );

	}

}
