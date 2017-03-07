package ensyuu3;
import java.util.Scanner;

	/*
	 * 二つの整数値を読み込んで、小さいほうの値と大きいほうの値の両方を表示するプログラムを作成せよ。
	 * ただし、二つの整数値が等しい場合は、右に示すように『二つの値は同じです。』と表示すること。
	 */
public class En3_14 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//昇順にソートするための一つ目の整数の入力を促す
		System.out.print("一つ目の整数を入力してください：");
		//入力された一つ目の値を変数minに代入して保持する
		int min = std.nextInt();

		//昇順にソートするための二つ目の整数の入力を促す。
		System.out.print("二つ目の整数を入力してください：");
		//入力された二つ目の値を変数maxに代入して保持する。
		int max = std.nextInt();

		//二値の交換を行うために必要な予備の変数subを用意し、初期化
		int sub = 0;


		//ここから入力された二値を昇順にソートする
		//もしmaxの値がminより小さかった場合、二値の入れ替えを行う
		 if(max < min) {
			 //予備変数subにminを代入する。
			 sub = min;
			 //次にmaxの値をminに代入する。
			 min = max;
			 //最後にsubの値をmaxに代入する。
			 max = sub;

		//もし二値の値が等しかった場合の条件
		 } if (min == max){
			 //二つの値は等しいという結果を出力する。
			 System.out.println("二つの値は同じです");

		 }

		 //二値を入れ替える必要がない場合、入力された順のまま結果を出力する
		 System.out.println("二つの値を昇順に並べました。\n小さい値は" + min + "です。\n大きい値は" + max + "です。");



	}

}
