package ensyuu3;
import java.util.Scanner;

/*正の整数値を読み込んで、それを3で割った値に応じて『その値は3で割り切れます。』『その値を3で割った余りは1です。』
 * 『その値を3で割った余りは2です。』のいずれかを表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */

public class En3_7 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);				//キーボードからの入力を読み込むプログラム

		System.out.print("正の整数値：");							//正の整数値の値の入力を促す
		int n = std.nextInt();										//入力された値を変数nに代入

		if(n > 0){															//条件式：nの値が0以上の場合、中のif文を実行
			if(n%3 == 0){													//nを3で割った余りが0ならば
				System.out.println("その値は3で割り切れます。");			//3で割り切れた場合に出力する文

			}else if(n%3 == 1){											//nを3で割った余りが1ならば
				System.out.println("その値を3で割った余りは1です。");		//余りが1の場合に出力する文

			}else if(n%3 == 2){											//nを3で割った余りが2ならば
				System.out.println("その値を3で割った余りは2です。");		//余りが2の場合に出力する文

			}

		}else {																//正ではない値が入力された場合
			System.out.println("正でない値が入力されました。");				//その場合に出力する文
		}

	}

}
