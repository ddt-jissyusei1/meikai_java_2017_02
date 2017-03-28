package ensyuu4;
import java.util.Scanner;

/*
 * 正の整数値を読み込んで、1から読み込んだ値までの積を求めるプログラムを作成せよ。
 */

public class En4_9 {
	//1から階乗するための値を入力してもらうための文の定数
	private static final String INPUT_MESSAGE = "1からどこまでの積を求めますか？:";

	public static void main(String[] args){
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		int maxNumber;			//1から階乗するために入力された値を代入する変数maxNumberを用意

		//0以下の値が入力された場合、プログラムが止まらないよう整数値が入力されるまで繰り返し処理を使用
		do{
			//1から入力された値までの積を求めるために、整数値を入力してもらう
			System.out.print(INPUT_MESSAGE);
			//入力された値を変数multipyに代入する
			maxNumber = inputStream.nextInt();

		//multipyの値が0以下の間、入力を促す文を出力する処理を繰り返す
		}while(maxNumber <= 0);
		//階乗のための値の入力が終わったのでリソースを解放する
		inputStream.close();

		int multipy = 1;			//順に積をした値を入れるための変数multipyを用意し1で初期化する
		int count = 1;				//繰り返し処理を制御するための変数countを用意し、1から繰り返しを始めるため1で初期化


		//ここから1から入力された値までの積を求める
		//countの値がmaxNumberと等しくなるまで、繰り返しを実行する
		while(count <= maxNumber){
			//multipyにcountをかけた値をmultipyに代入する
			multipy *= count;
			//countの値を1増やす
			count++;
		}

		//countの値が入力された値と同じになったとき、繰り返し処理を抜け、1から入力された値までの積の結果を出力する
		System.out.println("1から" + maxNumber + "までの積は" + multipy);
	}

}
