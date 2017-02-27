package ensyuu3;

import java.util.Scanner;

//二つの整数値を読み込んで、それらの値の差を表示するプログラムを作成せよ。

public class En3_10 {

	public static void main(String[] args) {
		//キーボードから読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//数字の差を検証するための一つ目の値を入力してもらう。
		System.out.print("一つ目の整数を入力してください：");
		//入力してもらった一つ目の整数を保持するため用意した変数num1に代入する。
		int num1 =std.nextInt();


		//数字の差を検証するための二つ目の値を入力してもらう。
		System.out.print("二つ目の整数を入力してください：");
		//入力してもらった二つ目の整数を保持するために、用意した変数num2に代入する。
		int num2 =std.nextInt();

		/*ptrintlnで呼び出す（）の文字列の中に、入力された二つの値の差を求める条件式を記述。
		 * 条件式内容は、もしnum1の値がnum2より小さければ、：左のnum2-num1の計算を行い、その結果を返しコンソールに出力する。
		 * もしnum1の値がnum2より大きければ、：右の計算を行い、その結果を返しコンソールに出力する。
		 */
		System.out.println("入力しれた二つの整数の差は、" + (num1 < num2 ? num2 - num1 : num1 - num2) + "です。");


	}

}
