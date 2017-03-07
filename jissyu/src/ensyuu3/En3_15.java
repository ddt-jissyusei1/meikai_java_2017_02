package ensyuu3;
import java.util.Scanner;

/*
 * 二つの整数値を読み込んで降順（大きい順）にソートするプログラムを作成せよ。
 */

public class En3_15 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//降順にソートするための一つ目の値の入力を促す
		System.out.print("一つ目の整数を入力してください：");
		//入力された一つ目の値を変数maxに代入し保持
		int max = std.nextInt();

		//降順にソートするための二つ目の値の入力を促す。
		System.out.print("二つ目の整数を入力してください：");
		//入力された二つ目の値を変数minに代入し保持
		int min = std.nextInt();

		//二値の入れ替えを行うために必要な変数subを用意し、初期化
		int sub = 0;

		//二値の値が等しくなかった場合
		if(max != min){
			//もし、maxの値がminより小さかった場合降順にソートするため、二値の入れ替えを行う
			if(max < min){
				//予備変数subにmaxの値を代入する
				sub = max;
				//maxにminの値を代入する
				max = min;
				//subの値をminに代入する
				min = sub;
			}

			//降順にソートした結果を出力する。
			System.out.println("二つの値を降順にソートしました。\n大きい値は" + max + "です。\n小さい値は" + min + "です。");

		//もし二値の値が等くなかった以外（二値が等しい）の場合の条件
		}else {
			//二つの値は等しいという判定分を出力
			System.out.println("二つの値は等しいです");
		}

	}

}
