package ensyuu3;
import java.util.Scanner;

/*正の整数値を読み込んで、それを3で割った値に応じて『その値は3で割り切れます。』『その値を3で割った余りは1です。』
 * 『その値を3で割った余りは2です。』のいずれかを表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */

public class En3_7 {

	public static void main(String[] args) {
		//キーボードからの入力を読み込むプログラム
		Scanner std = new Scanner(System.in);

		//検証用に3で割るための正の値の入力を促す
		System.out.print("正の整数値を入力してください：");
		//入力された値を変数number1に代入し、保持
		int number1 = std.nextInt();

		//条件式：number1の値が0以上の場合、中のif文を実行
		if(number1 > 0){
			//number1を3で割った余りが0である場合の条件式
			if(number1%3 == 0){
				//number1の値を3で割った余りが0である場合、number1の値は3で割り切れるという判定文を出力する
				System.out.println("その値は3で割り切れます。");

			//number1を3で割った余りが1である場合の条件式
			}else if(number1%3 == 1){
				//number1を3で割った余りが1である場合、number1を3で割った余りは1であるという判定文を出力する。
				System.out.println("その値を3で割った余りは1です。");

			//number1を3で割った余りが2である場合の条件式
			}else if(number1%3 == 2){
				//number1を3で割った余りが2である場合、number1を3で割った余りは2であるという判定文を出力する。
				System.out.println("その値を3で割った余りは2です。");

			}

		//もし正ではない値が入力された場合の条件式
		}else {
			//入力された値が正ではないという判定文を出力する。
			System.out.println("正でない値が入力されました。");
		}

	}

}
