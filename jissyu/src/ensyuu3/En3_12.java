package ensyuu3;
import java.util.Scanner;

/*
 * キーボードから読み込んだ三つの整数値の最小値を求めて表示するプログラムを作成せよ。
 */
public class En3_12 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//検証用の一つ目の整数値を入力してもらうための文を出力。
		System.out.print("一つ目の整数を入力してください：");
		//入力された値を保持するために用意した変数num1に代入する。
		int num1 = std.nextInt();

		//検証用の二つ目の整数値を入力してもらうための文を出力。
		System.out.print("二つ目の整数を入力してください：");
		//入力された値を保持するために用意した変数num2に代入する。
		int num2 = std.nextInt();

		//検証用の三つ目の整数値を入力してもらうための文を出力。
		System.out.print("三つ目の整数を入力してください：");
		//入力された値を保持するために用意した変数num3に代入する。
		int num3 = std.nextInt();

		//入力された三つの値の最小値を求めるために、
		//まず一つ目の整数num1を最小値を入れるために用意した変数minに代入する。
		int min = num1;


		/*num1の値が入っている変数minと二つめの値が入っている変数num2をくらべ、もしnum2のほうが小さければ、
		 * if文内が実行される。もしminの値（入力された一つ目の値）のほうが小さければ、このif文はスルーされ実行されず、
		 * 次へ移る
		 */
		if(num2 < min){
			//num2の値がminより小さければ、num2の値をminに代入する。
			min = num2;
		}


		/*num3の値とminの値を比べ、num3の値がminの値より小さければ中のコードが実行される。
		 * この時のminの値は、ひとつ前のif文が実行されていればnum2の値が、されていなければnum1の値が入っている。
		 * もし、minの値のほうが小さければ、このif文はスルーされ実行されず、次へ移る。
		 */
		if(num3 < min){
			//num3の値がminより小さければ、num3の値をminに代入する。
			min = num3;
		}

		//三つの値を比べた結果、最終的に一番小さい値が入っている変数minを、判定文と共にコンソールに出力する。
		System.out.println("三つの入力された値のうち、一番小さい値は、" + min + "です。");


	}

}
