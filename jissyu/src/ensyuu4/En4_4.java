package ensyuu4;
import java.util.Scanner;

/*
 * while文終了時に変数countDownの値が-1になることを確認するプログラムを作成せよ
 */

public class En4_4 {
	//後々変更しやすいよう、全体で使用する変数をここで宣言する
	private static final String COUNT_DOWN_MESSAGE = "カウントダウンを開始します。\n好きな正数を入力してください:";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner inputStream = new Scanner(System.in);

		int countDown;			//カウントダウンを開始する数値を入れるための変数を宣言


		//入力された値が正数ではなかった場合、正しい値が入力されるまで繰り返すようにする
		do{
			//カウントダウン開始の合図を出力して、カウントダウンを始める任意の数値の入力をしてもらう
			System.out.print(COUNT_DOWN_MESSAGE);
			//入力された値を用意した変数countDownに代入する
			countDown = inputStream.nextInt();

		//countDownの値（入力された値）が0以下の間このdo文を繰り返す
		}while(countDown <= 0);

		//正数値が入力されたら、カウントダウンの処理を開始する
		//カウントを開始するcountDownの値が0より大きい間、ここのコードを繰り返す
		while(countDown >= 0){

			//countDownの値を出力する
			System.out.println(countDown);
			//countDownの値を出力したあとで、そこから1引いた値をcountDownに代入しなおす
			//代入しなおした値が0未満であれば、countDown>= 0の制御式がfalseとなるため、繰り返しの処理を抜ける
			countDown--;
		}

		//最終的にcountDownに入ってる値がいくつであるかを確認するためコンソールに出力する
		System.out.println("変数countDownの最後の値は" + countDown + "です。");

	}


}
