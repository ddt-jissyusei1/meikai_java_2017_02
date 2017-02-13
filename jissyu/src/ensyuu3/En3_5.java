package ensyuu3;
import java.util.Scanner;


/*正の整数値を読み込んで、それが5で割り切れれば『その値は5で割り切れます。』と表示し、
 * そうでなければ『その値は5で割り切れません。』と表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */
public class En3_5 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);					//キーボードからの読み込みを行うプログラム

		System.out.print("正の整数値：");							//整数値の入力を促す
		int n = std.nextInt();									//入力された値を変数nに代入

		if(n > 0){												//nの値が0以上であれば中のif文を実行

			if(n%5 == 0){											//nの値を5で割った余りが0ならば
				System.out.println("その値は5で割り切れます。");	//余りがゼロの場合の文を出力

			}else {													//余りがゼロ以外ならば
				System.out.println("その値は5で割り切れません。");	//ゼロ以外の場合の文を出力
			}

		}else {														//入力された値が正ではなかった
			System.out.println("正でない値が入力されました。");		//その場合に出力する文
		}


	}

}
