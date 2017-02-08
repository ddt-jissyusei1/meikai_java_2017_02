package ensyuu2;
import java.util.Random;
import java.util.Scanner;

//キーボードから読み込んだ整数値プラスマイナス5の範囲の整数値をランダムに生成して表示するプログラムを作成せよ。
public class En2_8 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("整数値：");		//整数値の入力を促す
		int x = std.nextInt();				//入力された値を変数xに代入

		int y = rand.nextInt(11)-5;			//±5の乱数を生成して変数yに代入

		System.out.println("その値の±5の乱数を生成しました。それは" + (x+y) + "です。");	//変数xに変数yの値を足した値を表示



	}

}
