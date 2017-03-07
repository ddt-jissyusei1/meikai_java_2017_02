package ensyuu3;
import java.util.Scanner;

/*
 * 三つの整数値を読み込んで昇順（小さい順）にソートするプログラムを作成せよ。
 */

public class En3_16 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//昇順にソートする用の一つ目の整数の入力を促す
		System.out.print("一つ目の整数を入力してください：");
		//入力された値を変数num1に代入し保持
		int num1 = std.nextInt();

		//昇順にソートする用の二つ目の整数の入力を促す
		System.out.print("二つ目の整数を入力してください：");
		//入力された二つ目の値を、変数num2に代入し保持
		int num2 = std.nextInt();

		//昇順にソートする用の三つ目の整数の入力を促す
		System.out.print("三つ目の整数を入力してください：");
		//入力された三つ目の値を、変数num3に代入し保持
		int num3 = std.nextInt();

		//三値の入れ替えを行うために必要な予備の変数subを用意し初期化
		int sub = 0;

		//三値が等しくなかった場合、入れ替えるため次のif文を実行
		//(num1とnum2が等しくないもしくはnum2とnum3が等しくない場合)
		if(num1 != num2 || num2 != num3){
			//num1がnum2より大きい場合、次のif文で二値を入れ替える
			if(num1 > num2){
				//予備の変数subにnum1の値を代入
				sub = num1;
				//num1にnum2の値を代入
				num1 = num2;
				//num2にsubの値を代入
				num2 = sub;
			}
			//num2がnum3より大きかった場合、次のif文で二値を入れ替える
			if(num2 > num3){
				//予備の変数subにnum2の値を代入
				sub = num2;
				//num2にnum3の値を代入
				num2 = num3;
				//num3にsubの値を代入
				num3 = sub;
			}
			//num1の値がnum3より大きかった場合、次のif文で二値を入れ替える
			if(num1 > num3){
				//予備の変数subにnum1の値を代入
				sub = num1;
				//num1にnum3の値を代入
				num1 = num3;
				//num3にsubの値を代入
				num3 = sub;
			}

			//昇順にソートした結果を出力する
			System.out.println("三つの値を昇順にソートしました\n" + num1 + "\n" + num2 + "\n" + num3);

		//三値の値が等しくなかった以外（すべて等しい）の場合の条件
		}else{
			//三値が等しいという判定文を出力する
			System.out.println("三つの値はすべて等しいです。");
		}

	}

}
