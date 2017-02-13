package ensyuu3;
import java.util.Scanner;


/*正の整数値を読み込んで、それが10の倍数であれば『その値は10の倍数です。』と表示し、
 * そうでなければ『その値は10の倍数ではありません。』と表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */
public class En3_6 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);					//キーボードからの読み込みを行うプログラム

		System.out.print("正の整数値：");					//正の整数値の入力を促す
		int n = std.nextInt();								//入力された値を変数nに代入

		if(n > 0){														//条件式：nが0以上の場合中のif文を実行
			if(n%10 == 0){												//nを10で割った余りが0ならば
				System.out.println("その値は10の倍数です。");			//その場合に出力する文

			}else {														//nを10で割った余りが0以外ならば
				System.out.println("その値は10の倍数ではありません。");	//その場合に出力する文
			}

		}else {															//条件式以外の場合
			System.out.println("正ではない値が入力されました。");		//その場合に出力する文
		}

	}

}
