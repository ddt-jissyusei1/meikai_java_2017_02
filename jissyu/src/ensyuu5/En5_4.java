package ensyuu5;
import java.util.Scanner;

/*
 * 三つの整数値を読み込んで、その合計と平均を表示するプログラムを作成せよ。
 * 平均は実数として表示すること。
 */
public class En5_4 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "読み込んだ三つの整数値の合計と平均を表示します。";
	//一つ目の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_ONE_MESSAGE = "一つ目の値を入力してください：";
	//二つ目の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_TWO_MESSAGE = "二つ目の値を入力してください：";
	//三つ目の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_THREE_MESSAGE = "三つ目の値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int firstNumber = 0;			//一つ目の値を代入するための変数を用意し、0で初期化する
		int secondNumber = 0;			//二つ目の値を代入するための変数を用意し、0で初期化する
		int thirdNumber = 0;			//三つ目の値を代入するための変数を用意し、0で初期化する

		//一つ目の数値を入力してもらうための文を出力する
		System.out.print(INPUT_NUMBER_ONE_MESSAGE);
		//入力された値をfirstNumberに代入する
		firstNumber = inputStream.nextInt();

		//二つ目の数値を入力してもらうための文を出力する
		System.out.print(INPUT_NUMBER_TWO_MESSAGE);
		//入力された値をsecondNumberに代入する
		secondNumber = inputStream.nextInt();

		//三つ目の数値を入力してもらうための文を出力する
		System.out.print(INPUT_NUMBER_THREE_MESSAGE);
		//入力された値をthirdNumberに代入する
		thirdNumber = inputStream.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//三つの値の合計を計算し、変数sumNumberに代入する
		int sumNumber = (firstNumber + secondNumber + thirdNumber);

		//三つの値の平均を計算し、実数で表示するためにdouble型の変数averageに代入する
		double averageNumber = sumNumber/3.0;

		//三つの値の合計と平均を出力する
		System.out.println("\n三つの値の合計は、" + sumNumber + "\n平均は、" + averageNumber + "です。"  );

	}

}
