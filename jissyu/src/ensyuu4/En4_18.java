package ensyuu4;
import java.util.Scanner;

/*
 * 1から読み込んだ値までの整数値の２乗値を表示するプログラムを作成せよ
 */
public class En4_18 {
	//プログラムの説明出力文のための定数
	private static final String SQUARE_PROGRAM_MESSAGE = "1から入力された値までの整数値の２乗値を表示します。";
	//1から二乗していく整数値入力を促す文のための定数
	private static final String INPUT_SQUAREEND_MESSAGE = "1からどこまで２乗しますか？:";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//何をするプログラムなのかを説明した文を出力する
		System.out.println(SQUARE_PROGRAM_MESSAGE);

		int numberSquareEnd = 0;						//入力された値を代入するための変数numberSquareEndを用意し、0で初期化する

		//0以下の値が入力された場合を考慮して、do文で繰り返し入力文を出力するようにする
		do{
			//入力を促す文を出力する
			System.out.print(INPUT_SQUAREEND_MESSAGE);
			//入力された値を変数numberSquareEndに代入する
			numberSquareEnd = inputStream.nextInt();
		//入力された値が0以下である間、入力文の出力を繰り返す
		}while(numberSquareEnd <= 0);
		//値が入力されたので、開いていたリソースを開放する
		inputStream.close();

		//ここから1から入力された値まで２乗していくコード
		//順に２乗して出力するために、変数countの値を1から入力された値まで２乗していきながら、繰り返し毎に1インクリメントする
		for(int count = 1; count <= numberSquareEnd; count++){
			//countの値を２乗し、結果を出力する
			System.out.println(count + "の２乗は" + count*count);
		}

	}

}
