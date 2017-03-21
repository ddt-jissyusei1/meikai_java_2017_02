package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ値が1未満であれば改行文字を出力しないようにList4-7およびList4-8を書き換えたプログラムを作成せよ。
 */

public class En4_6 {
	//後々変更しやすいよう、プログラムの全体で使用する可能性のある変数をここで宣言する
	private static final String ASTERISK = "*",QUESTION = "何個*を表示しますか？：";

	//List4-7のプログラムを書き換える
	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner inputStream = new Scanner(System.in);

		int numberOfAsterisk;			//入力された*表示個数のための変数を用意する

		//'*'をいくつ表示するか質問し、表示する個数の入力をしてもらう
		System.out.print(QUESTION);
		//入力された値を変数numberOfAsteriskに代入する
		numberOfAsterisk = inputStream.nextInt();

		int count = 0;						//繰り返し処理の制御のためのカウント変数を用意する

		//入力された値が1未満の場合改行文字を出力しないための、柴田さんごり押し指示コード
		//numberOfAsteriskの値が1以上の場合、if文ない処理を実行する
		if(numberOfAsterisk >= 1){

			//変数countの値が、numberOfAsteriskの値未満である間、*の出力を繰り返す
			while(count < numberOfAsterisk){
				//*をnumberOfAsteriskの値と同じになるまで出力される
				System.out.print(ASTERISK);
				//変数countの値を1増やし、もしnumberOfAsteriskと等しくなったときは、繰り返しコードを抜ける
				count++;

			}
			//numberOfAsteriskが1以上の場合、改行が出力される
			System.out.println();
		}


	}

}
