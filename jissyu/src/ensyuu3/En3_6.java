package ensyuu3;
import java.util.Scanner;


/*正の整数値を読み込んで、それが10の倍数であれば『その値は10の倍数です。』と表示し、
 * そうでなければ『その値は10の倍数ではありません。』と表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */
public class En3_6 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//10の倍数か検証するための正の数値の入力を促す
		System.out.print("正の整数値を入力してください：");
		//入力された値を変数number1に代入し、保持
		int number1 = std.nextInt();

		//条件式：number1の値がが0以上の場合、次のif文を実行
		if(number1 > 0){

			//number1の値が1以上であり、number1の値を10で割った余りがゼロと等しい場合の条件式
			if(number1%10 == 0){
				//number1の値を10で割った余りがゼロと等しい場合、number1の値は10の倍数であると言えるので、
				//number1の値は10の倍数であるという判定文を出力する。
				System.out.println("その値は10の倍数です。");

				//number1を10で割った余りが0以外の条件式
			}else {
				//number1の値を10で割った余りがゼロではない場合、number1の値は10の倍数ではないので、
				//number1の値は10の倍数ではないという判定文を出力する。
				System.out.println("その値は10の倍数ではありません。");
			}

			//number1の値がゼロ以下だった場合の条件式
		}else {
			//number1の値がゼロ以下の場合、それは正の値ではないという判定文を出力する。
			System.out.println("正ではない値が入力されました。");
		}

	}

}
