package ensyuu4;
import java.util.Scanner;

/*
 * 前問（演習4－11)とは逆に、0から正の整数値までカウントアップするプログラムを作成せよ。
 */
public class En4_12 {
	//カウントアップ開始を知らせるための定数
	private static final String COUNT_UP_MESSAGE = "カウントアップを開始します。";
	//カウントアップを終了する値の入力を促す文の定数
	private static final String COUNT_END ="0からカウントする正の整数値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//カウントアップ開始を知らせる文を出力する
		System.out.println(COUNT_UP_MESSAGE);

		int countEndNumber;				//0からカウントアップする値を代入するための変数countEndNumberを用意する

		//正の整数値が入力されるまで、do文で繰り返し入力を促す文を出力する
		do{
			//カウントアップする値の入力を促す文を出力する
			System.out.print(COUNT_END);
			//入力された値をcountEndNumberに代入する
			countEndNumber = inputStream.nextInt();

		//countEndNumberの値が0以下の間、入力を促す文の出力を繰り返す
		}while(countEndNumber <= 0);
		//0からカウントアップするための値の入力が終わったので、開いていたリソースを解放する
		inputStream.close();

		/*
		 * ここからカウントアップの繰り返し処理コード
		 * 0からcountEndNumberまでのカウントアップなので、カウント用の変数countをfor文の初期化部で初期化
		 * countの値がcountEndNumber以下の間、countの出力を繰り返し、繰り返し毎にcountの値をインクリメントする
		 */
		for(int count = 0; count <= countEndNumber; count++ ){
			//インクリメントされたcountの値を出力する
			System.out.println(count);

		}
	}

}
