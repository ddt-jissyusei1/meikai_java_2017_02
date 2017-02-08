package ensyuu2;
import java.util.Scanner;


public class En2_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//キーボードから読み込んだ整数値に10を加えた値を10を減じた値を出力するプログラムを作成せよ。

		Scanner std = new Scanner(System.in);

		System.out.print("整数値：");
		int x = std.nextInt();

		System.out.println("10を加えた値は" + (x + 10) + "です。");
		System.out.println("10を減じた値は" + (x - 10) + "です。");

	}

}
