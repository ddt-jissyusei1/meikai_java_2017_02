package ensyuu3;
import java.util.Scanner;


/*二つの整数値を読み込んで、それらの値の差が10以下であれば、『それらの差は10以下です。』と表示し、
 * そうでなければ『それらの差は11以上です。』と表示するプログラムを作成せよ。
 */

public class En3_11 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner std = new Scanner(System.in);

		//検証用の一つ目の整数を入力してもらう。
		System.out.print("一つ目の整数を入力してください：");
		//入力された一つ目の整数を保持するために用意した、変数num1に代入する
		int num1 = std.nextInt();

		//続いて検証用の二つ目の整数を入力してもらう。
		System.out.print("二つ目の整数を入力してください：");
		//入力された二つ目の整数を保持するために用意した、変数num2に代入する
		int num2 = std.nextInt();

		//入力された二つの整数のどちらが大きいかを比べ、条件式で二つの整数の差を求める計算を行い、
		//結果出た差を、用意した変数answerに代入する
		int answer = num1 < num2 ? num2 - num1 : num1 - num2;


		//answerの値が10以下だった場合の条件
		if(answer <= 10){

			//10以下だった場合、二つの整数num1とnum2の差は10以下ですという判定分をコンソールに出力する。
			System.out.println("二つの整数の差は10以下です。");

		//answerの値が10以下以外だった場合の条件
		}else {

			//10以下以外だった場合、二つの整数num1とnum2の差は11以上ですという判定分をコンソールに出力する。
			System.out.println("二つの整数の差は11以上です。");

		}

	}

}
