package ensyuu3;
import java.util.Scanner;

//最後のelseを、else if(n == 0)に変更したらどうなるかを検討せよ。

/*List3-5
 * 読み込んだ整数値の符号（正／負／0）を判定して表示
 */

public class En3_3 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);			//キーボードからの読み込みを行うプログラム

		System.out.print("整数値：");					//整数値の入力を促す
		int n = std.nextInt();							//入力された値を変数nに代入

		if(n > 0){										//もしnの値が1以上ならば
			System.out.println("その値は正です。");		//1以上の場合の文を出力
		}else if (n < 0){								//もしnの値が0未満ならば
			System.out.println("その値は負です。");		//0未満の場合の文を出力
		}else if(n == 0){											//上記2条件以外ならば
			System.out.println("その値は0です。");		//2条件以外の場合の文を出力
		}


	}

}

//検討結果：変更しても同じ結果
