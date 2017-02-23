package ensyuu3;
import java.util.Scanner;

//二つの実数値を読み込んで、大きいほうの値を表示するプログラムを作成せよ。

public class En3_9 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//実数値の大小比較用の一つ目の値の入力を促す文を出力する。
		System.out.print("一つ目の実数値を入力してください：");
		//入力されたひとつめの実数値を変数number1に代入し、保持する。
		double number1 = std.nextDouble();

		//二つ目の実数値の入力を促す文を出力する。
		System.out.print("二つ目の実数値を入力してください：");
		//入力された二つ目の実数値を変数number2に代入し、保持する。
		double number2 = std.nextDouble();

		//大きい方の値であるという判定文の中の条件演算子で、入力された二つの値のどちらが大きいかを判定する
		//number1の値がnumber2の値より大きいということが真であるならば、number1を、偽であるならばnumber2の値を
		//出力する判定文に返し、表示する。
		System.out.println("大きいほうの値は" + (number1 > number2 ? number1 : number2 ) + "です。");

	}

}
