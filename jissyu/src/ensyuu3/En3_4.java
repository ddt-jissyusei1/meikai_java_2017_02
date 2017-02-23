package ensyuu3;
import java.util.Scanner;

/*二つの変数number1,number2に値を読み込んで、その大小関係を以下のいずれかで表示するプログラムを作成せよ。
 * 『number1のほうが大きいです。』『number2のほうが大きいです。』『number1とnumber2は同じ値です。』
 */

public class En3_4 {

	public static void main(String[] args) {

		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//数値の大小を比べるための一つ目の数字の入力を促す
		System.out.print("整数１：");
		//入力された値を変数number1に代入し、保持
		int number1 = std.nextInt();

		//二つ目の数字の入力を促す
		System.out.print("整数２：");
		//入力された値を変数number2に代入し、保持
		int number2 = std.nextInt();



		//number1の値がnumber2より大きいという条件
		if(number1 > number2){
			//number1のほうが大きいという判定文を出力する
			System.out.println("整数１のほうが大きいです。");

		//number2の値がnumber1より大きいという条件
		}else if(number2 > number1){
			//number2のほうが大きいという判定文を出力する。
			System.out.println("整数２のほうが大きいです。");

		//number1とnumber2の値が等しいという条件
		}else if(number1 == number2){
			//二つの値は等しいという判定文を出力する
			System.out.println("整数１と整数２は同じ値です。");
		}

	}

}
