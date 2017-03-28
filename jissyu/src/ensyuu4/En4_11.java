package ensyuu4;
import java.util.Scanner;

/*
 * 正の整数値を0までカウントダウンするList4-4(p.100)をfor文で実現せよ
 */

public class En4_11 {
	//カウントダウン開始を知らせるための定数
	private static final String COUNT_DOWN = "カウントダウンします。";
	//カウント開始する整数値を入力してもらうための定数
	private static final String STARTING_NUMBER = "カウントを開始する正の整数値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//カウント開始を知らせる文を出力する
		System.out.println(COUNT_DOWN);

		int countStart;			//入力された値を代入するための変数countStartを用意する

		//正の整数値が入力されるまでdo文で入力を促す文の出力を繰り返す
		do{
			//カウントを開始する整数値を入力してもらう文を出力する
			System.out.print(STARTING_NUMBER);
			//入力された値を変数countStartに代入する
			countStart = inputStream.nextInt();
		//countStartの値が0以下の間繰り返す制御式
		}while(countStart <= 0);
		//カウントダウンの開始数値の入力が終わったのでリソースを解放する
		inputStream.close();

		/*変更前のwhile文を使用した繰り返し処理を比較のためコメントアウト
		 * while(countStart >= 0){
		 * 		System.out.println(countStart);
		 *		countStart--;
		 *}
		 */

		//while文変更後のコード
		/*
		 * for文初期化部のcountStartはプログラムの21行目で初期化されているので省略
		 * countStartの値が0以上の間、countStartの値の出力を繰り返し、繰り返し毎にcountStartの値を1引いていく制御式
		 */
		for(;countStart >= 0; countStart--){
			//countStartの値を表示する
			System.out.println(countStart);
		}
	}

}
