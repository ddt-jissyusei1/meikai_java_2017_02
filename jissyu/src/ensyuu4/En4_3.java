package ensyuu4;
import java.util.Scanner;

/*
 *二つの整数値を読み込んで、小さいほうの数以上で大きいほうの数以下の全整数を小さいほうから順に表示するプログラムを作成せよ
 */

public class En4_3 {
	private static final String INPUT_NUMBER_ONE = "一つ目の整数を入力してください：",
									INPUT_NUMBER_TWO = "二つ目の整数を入力してください：";

	public static void main(String[] args) {
		//キーボードからの入力を読み込むためのプログラム
		Scanner inputStream = new Scanner(System.in);

		int min;		//入力される一つ目の値を代入するための変数minを宣言
		int max;		//入力される二つ目の値を代入するための変数maxを宣言

		//一つ目の整数を入力してもらうため、入力を促す文を出力する
		System.out.print(INPUT_NUMBER_ONE);
		//入力された値を変数minに代入する
		min = inputStream.nextInt();


		//二つ目の整数を入力してもらうため、入力を促す文を出力する
		System.out.print(INPUT_NUMBER_TWO);
		//入力された二つ目の値を変数maxに代入しする
		max = inputStream.nextInt();

		//入力された二つの整数の間の全整数を昇順に並べるために、minの値がmaxより大きかった場合、二値を入れ替えるためのコード
		if(min > max){
			//二値を入れ替えるために変数subを用意し、minの値で初期化する
			int sub = min;
			//変数minにmaxの値を代入する
			min = max;
			//変数maxに変数subの値を代入する
			max = min;
		}

		//二値の間の全整数をdo文で繰り返しながら昇順に出力する
		do{
			//minの値を出力するためのコード
			System.out.print(min + " ");
			//minの値から昇順に+1した数値を出力していくので、minの値に1加算するコード
			min += 1;

		//minの値がmaxと等しくない間（minの値がmaxと等しくなるまで）、minに1を加算しながら出力を繰り返す
		}while(min != max);

		//minの値がmaxと等しくなったとき最後にmaxの値を出力する
		System.out.println(max);


	}

}
