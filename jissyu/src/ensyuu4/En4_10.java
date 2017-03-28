package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ値が1未満であれば改行文字を出力しないように、List4-11(p.114)を書き換えたプログラムを作成せよ。
 */

public class En4_10 {
	//後々変更しやすいよう、プログラム全体で使用する変数を定数としてここで宣言する
	private static final String ASTERISK_AMOUNT_QUESTION = "何個*を表示しますか？：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//繰り返し処理でいくつ*を表示するか質問し、個数を入力してもらう
		System.out.print(ASTERISK_AMOUNT_QUESTION);
		//入力された値を変数numberOfAsteriskに代入する
		int numberOfAsterisk = inputStream.nextInt();


		/*入力された値の数だけ*を表示するためにfor文で繰り返しコード
		 *制御式で、カウント用の変数countを用意し0で初期化、countがnumberOfAsterisk未満の間for文を繰り返し、
		 * ループを繰り返すごとにcountの値を1増やす
		 */
		for(int count = 0; count < numberOfAsterisk; count++){
			//countの値がnumberOfAsterisk未満の間、*を出力する
			System.out.print('*');

		}

		/*numberOfAsteriskの値が1以上の場合のみ、改行文字を出力するようif条件式で囲む
		 */
		if(numberOfAsterisk >= 1){
			//numberOfAsteriskの値が1以上の場合ここの改行が出力される
			System.out.println();
		}
	}

}
