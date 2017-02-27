package ensyuu3;
import java.util.Scanner;

/*
 * キーボードから読み込んだ三つの整数値の中央値を求めて表示するプログラムを作成せよ。
 */

public class En3_13 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//中央値を求めるための一つ目の値を入力してもらう。
		System.out.print("一つ目の整数値を入力してください：");
		//入力された値を、保持するために用意した変数num1に代入する。
		int min = std.nextInt();

		//中央値を求めるための二つ目の値を入力してもらう。
		System.out.print("二つ目の整数値を入力してください：");
		//入力された値を、保持するために用意した変数num2に代入する。
		int mid = std.nextInt();

		//中央値を求めるための三つ目の値を入力してもらう。
		System.out.print("三つ目の整数値を入力してください：");
		//入力された値を、保持するために用意した変数num3に代入する。
		int max = std.nextInt();

		//変数の値の入れ替えに必要な、ゼロで初期化した変数num4を用意する。
		int num4= 0;

		/*ここから３値の入れ替えのif文
		 *まずminとmidの値を比べ、midのほうがmin以下だった場合、if文の中を実行する。
		 */
		if(mid <= min){
			//minの値をnum4に移す。
			num4 = min;
			//midの値をminに移す。
			min = mid;
			//num4の値（移す前のminの値）をmidに移す。
			mid = num4;
		}

		/*次にmidとmaxの値を比べる
		 * もし、maxの値がmid以下だった場合、if文の中を実行する。
		 */
		if(max <= mid){
			//maxの値をnum4に移す
			num4 = max;
			//midの値をmaxに移す
			max = mid;
			//num4の値（移す前のmaxの値）をmidに移す。
			mid = num4;

		}

		//三つの値を昇順に並べなおした結果、中央の値を判定分とともに出力する。
		System.out.println("入力された三つの値の中央値は" + mid + "です。");

	}

}
