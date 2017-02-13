package ensyuu3;
import java.util.Scanner;

//二つの実数値を読み込んで、大きいほうの値を表示するプログラムを作成せよ。

public class En3_9 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);						//キーボードからの読み込みを行うプログラム

		System.out.print("実数値a：");								//実数値aの入力を促す
		double n = std.nextDouble();								//入力された実数値を変数nに代入

		System.out.print("実数値b：");								//実数値bの入力を促す
		double d = std.nextDouble();								//入力された実数値を変数dに代入

		System.out.println("大きいほうの値は" + (n > d ? n : d ) + "です。");
		//条件演算子：ｎの値がｄより大きければnを、そうでなければdを表示する。
	}

}
