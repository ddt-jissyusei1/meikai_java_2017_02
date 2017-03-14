package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ整数値の符号を判定するプログラムを、好きなだけ何度でも繰り返して入力・表示できるようにした
 * プログラムを作成せよ。
 */

public class En4_1 {

	public static void main(String[] args) {
		//キーボードからの入力を読み込むためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//入力された整数の値を保持するための変数signを用意する
		int sign;

		//繰り返し実行判定のための変数retryを用意する；
		int retry;

		//doを利用したプログラムのループ文
		do{
			//符号判定するための整数値の入力を促す文を出力する。
			System.out.print("整数値の符号を判定します。\n好きな数値を入力してください：");
			//入力された値を変数signに代入
			sign = inputStream.nextInt();

			//符号の判定をするための処理をif文で実行
			//signの値が0より小さい場合if文内の処理を実行する
			if(sign < 0){
				//0より小さい値は負なので、入力された値は負であるという判定分を出力する
				System.out.println(sign + "の符号は負です。");

			//signの値が0より大きい場合else if文内の処理を実行する
			}else if (sign > 0){
				//0より大きい値は正なので、入力された値は正であるという判定分を出力する
				System.out.println(sign + "の符号は正です。");

			//signの値が0だった場合、else if文内の処理を実行する
			}else if (sign == 0){
				//0は正でも負でもないので、入力された値は0であるという判定分を出力する
				System.out.println("入力された値が0です。正でも負でもありません");
			}

			//判定結果後、もう一度判定するかどうかをyes/noで聞く文を出力する。
			System.out.print("もう一度やりますか？ \nYesなら1を、Noなら0を入力してください：");
			//入力された1または0を繰り返し判定用の変数retryに代入する
			retry = inputStream.nextInt();

		//retryの値が1という制御式がtrueの間、do文ブロック内のプログラムを実行する
		}while(retry == 1);

		//retryの値が1という制御式がfalseとなった場合、do文ブロックを抜け、プログラム終了の文を出力する
		System.out.println("プログラムを終了します、お疲れさまでした。");


	}

}
