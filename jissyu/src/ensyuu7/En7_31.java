package ensyuu7;
import java.util.Scanner;


/*
 * int型整数absoluteNumberの絶対値、long型整数のabsoluteNumberの絶対値、
 * float型実数absoluteNumberの絶対値、double型実数absoluteNumberの絶対値を求める、
 * 以下に示す多重定義されたメソッド群を作成せよ。
 * int absolute(int absoluteNumber)
 * long absolute(long absoluteNumber)
 * float absolute(float absoluteNumber)
 * double absolute(double absoluteNumber)
 */
public class En7_31 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "int型、long型、float型、double型の絶対値を求めます。";
	//絶対値を求める値の入力を促す文のための定数
	private static final String INPUT_ABSOLUTE_NUMBER_MESSAGE = "求める絶対値のための値を入力してください：";
	//int型整数の絶対値の結果を表示する文のための定数
	private static final String OUTPUT_INT_ABSOLUTE_RESULT_STRING = "int型整数の絶対値は%dです。\n";
	//long型整数の絶対値の結果を表示する文のための定数
	private static final String OUTPUT_LONG_ABSOLUTE_RESULT_STRING = "long型整数の絶対値は%dです。\n";
	//float型実数の絶対値の結果を表示する文のための定数
	private static final String OUTPUT_FLOAT_ABSOLUTE_RESULT_STRING = "float型実数の絶対値は%fです。\n";
	//double型実数の絶対値の結果を表示する文のための定数
	private static final String OUTPUT_DOUBLE_ABSOLUTE_RESULT_STRING = "double型実数の絶対値は%fです。\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		int absoluteNumber = 0;						//絶対とを求める値のための変数

		//各型の絶対値を求めるための値の入力を促す文を表示するための出力
		System.out.print(INPUT_ABSOLUTE_NUMBER_MESSAGE);
		//各型の絶対値を求めるメソッドで使用するため、入力された値を変数に格納する
		absoluteNumber = inputNumberStream.nextInt();

		//値の入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//int型の絶対値を求めるためのメソッドの呼び出し
		int absoluteInt = absolute(absoluteNumber);

		//long型の絶対値を求めるためのメソッドの呼び出し
		long absoluteLong = absolute((long)absoluteNumber);

		//float型の絶対値を求めるためのメソッドの呼び出し
		float absoluteFloat = absolute((float)absoluteNumber);

		//double型の実数値を求めるためのメソッドの呼び出し
		double absoluteDouble = absolute((double)absoluteNumber);

		//結果出力を区切って表示するための改行の出力
		System.out.println();

		//int型整数の絶対値の結果を表示するための出力
		System.out.printf(OUTPUT_INT_ABSOLUTE_RESULT_STRING, absoluteInt);

		//long型整数の絶対値の結果を表示するための出力
		System.out.printf(OUTPUT_LONG_ABSOLUTE_RESULT_STRING, absoluteLong);

		//float型実数の絶対値の結果を表示するための出力
		System.out.printf(OUTPUT_FLOAT_ABSOLUTE_RESULT_STRING, absoluteFloat);

		//double型実数の絶対値の結果を表示するための出力
		System.out.printf(OUTPUT_DOUBLE_ABSOLUTE_RESULT_STRING, absoluteDouble);

	}

	//int型整数の絶対値を求めるためメソッド
	private static int absolute(int absoluteNumber){
		//メインメソッドに返却する絶対値を求めるための条件演算子
		return (absoluteNumber <= 0) ? 0 - absoluteNumber : absoluteNumber;
	}

	//long型整数の絶対値を求めるためのメソッド
	private static long absolute(long absoluteNumber){
		//メインメソッドに返却する絶対値を求めるための条件演算子
		return (absoluteNumber <= 0) ? 0 - absoluteNumber : absoluteNumber;
	}

	//float型実数の絶対値を求めるためのメソッド
	private static float absolute(float absoluteNumber){
		//メインメソッドに返却する絶対値を求めるための条件演算子
		return (absoluteNumber <= 0.0f) ? 0.0f - absoluteNumber : absoluteNumber;
	}

	//double型実数の絶対値を求めるためのメソッド
	private static double absolute(double absoluteNumber){
		//メインメソッドに返却する絶対値を求めるための条件演算子
		return (absoluteNumber <= 0.0d) ? 0.0d - absoluteNumber : absoluteNumber;
	}

}
