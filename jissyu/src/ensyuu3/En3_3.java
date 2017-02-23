package ensyuu3;
import java.util.Scanner;

//最後のelseを、else if(n == 0)に変更したらどうなるかを検討せよ。

/*List3-5
 * 読み込んだ整数値の符号（正／負／0）を判定して表示
 */

public class En3_3 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);			//キーボードからの読み込みを行うプログラム

		System.out.print("値を入力してください：");					//符号判定用の数値の入力を促す
		int number = std.nextInt();							//入力された値を変数numberに代入し、保持する

		if(number > 0){										//もしnumberの値が1以上ならば
			System.out.println("その値は正です。");		//1以上は正の値なので正であるという判定文を出力

		}else if (number < 0){								//もしnumberの値が0未満ならば
			System.out.println("その値は負です。");		//0未満の値は負なので、負であるという判定を出力

		}else if(number == 0){							//numberの値がゼロと等しいならばという条件
			System.out.println("その値は0です。");		//numberの値はゼロであるという判定文を出力
		}


	}

}

//検討結果：変更しても同じ結果
