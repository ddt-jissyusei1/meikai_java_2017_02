package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ個数だけ*を表示するList4-11(p.114)を書き換えて、5個表示するごとに改行するプログラムを作成せよ
 */

public class En4_16 {
	//*を5個表示するごとに改行するというプログラムの説明文のための定数
	private static final String FIVEEACH_NEWLINE_MESSAGE = "*を5個表示するたびに改行します。";
	//*を表示する数を入力してもらうための質問文の定数
	private static final String ASTERISK_NUMBER_QUESTION = "何個*を表示しますか？：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(FIVEEACH_NEWLINE_MESSAGE);

		int numberOfAsterisk = 0;				//入力された値を代入するための変数numberOfAsteriskを用意し、0で初期化する

		//0未満の値が入力される場合を考慮して、0以上の値が入力されるまで入力を促す文を繰り返し出力するようにする
		do{
			//いくつ*を表示するか質問し、個数を入力してもらう
			System.out.print(ASTERISK_NUMBER_QUESTION);
			//入力された値を変数numberOfAsteriskに代入する
			numberOfAsterisk = inputStream.nextInt();
		 //入力された値が0未満である間繰り返す
	    }while(numberOfAsterisk < 0);
		//*を表示するための個数の入力が終わったのでリソースを開放する
		inputStream.close();

		//入力された値の数だけ*を表示するためにfor文で繰り返すコード
		//制御式で、カウント用の変数countを用意し1で初期化、countがnumberOfAsterisk以下の間for文を繰り返し、
		//ループを繰り返すごとにcountの値を1増やす
		for(int count = 1; count <= numberOfAsterisk; count++){
			//countの値がnumberOfAsterisk未満の間、*を出力する
			System.out.print('*');
			//5個ごとに改行するために、if条件式でcountを5で割った余りが0のときに改行文字を出力する
			if(count%5 == 0){
				//改行文字を出力する
				System.out.print("\n");
			}
		}
	}
}