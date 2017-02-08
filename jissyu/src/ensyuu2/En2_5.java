package ensyuu2;
import java.util.Scanner;

public class En2_5 {

	public static void main(String[] args) {
		// 二つの実数値を読み込み、その和と平均を求めて表示するプログラムを作成せよ。
		Scanner std = new Scanner(System.in);

		System.out.print("xの値：");
		double x = std.nextDouble();

		System.out.print("yの値：");
		double y = std.nextDouble();

		System.out.println("合計は" + (x + y) + "です。");
		System.out.println("平均は" + (x + y)/2 + "です。");


	}

}
