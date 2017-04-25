package ensyuu5;
import java.util.Scanner;

/*
 * float型の変数とdouble型の変数に値を読み込んで表示するプログラムを作成せよ。
 * ※float型の読み込みには、nextFloat()を利用する。
 */
public class En5_2 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "浮動小数点のfloat型とdouble型を表示します";
	//数値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "10桁以上の数値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		float numberFloat = 0;			//入力された値をfloat型で表示するための変数を用意し0で初期化する
		double numberDouble = 0;			//入力された値をdouble型で表示するための変数を用意し0で初期化する

		//数値の入力を促す文を出力する
		System.out.print(INPUT_NUMBER_MESSAGE);
		//入力された値をfloat型変数に代入する
		numberFloat = inputStream.nextFloat();
		//入力された同じ値を使用するため、numberFloatの値ををnumberDoubleに代入する
		numberDouble = numberFloat;

		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//それぞれの浮動小数点型を表示する
		System.out.println("float型は" + numberFloat + ",\ndouble型は" + numberDouble + "です。");
	}

}
