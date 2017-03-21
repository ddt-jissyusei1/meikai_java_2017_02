package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ値の個数だけ記号文字を出力するプログラムを作成せよ。表示は*と+を交互に行うこと。
 */

public class En4_7 {
	//後々変更しやすいよう、プログラム全体で使う変数をここで宣言
	private static final char ASTERISK_CHAR = '*',PLUS_CHAR ='+';

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		int outPutNumber;			//入力された値を代入するための変数を宣言する

		//記号文字をいくつ出力するか質問し、出力する数を入力してもらう
		System.out.print("記号をいくつ表示しますか？：");
		//入力された値を変数outPutNumberに代入する
		outPutNumber = inputStream.nextInt();


		int count = 1;				//繰り返し処理の制御のための変数countを用意し、0で初期化する


		//countの値がoutPutNumber以下の間、記号の出力を繰り返す
		while(count <= outPutNumber){

			//記号を交互に出力するために、countの剰余判定でif文の出力分岐処理を行う
			//countの剰余が0だった場合の処理
			if(count%2 == 0){
				//剰余が0は偶数なので、偶数番目は+の記号を出力する
				System.out.print(PLUS_CHAR);

			//countの剰余が1だった場合の処理
			}else if(count%2 == 1){
				//剰余が1は奇数なので、奇数番目は*の記号を出力する
				System.out.print(ASTERISK_CHAR);

			}

			//countの値に1足して、もしoutPutNumberと同じ値であれば、繰り返し処理を抜ける
			count++;

		}

	}

}
