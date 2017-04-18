package ensyuu4;
import java.util.Scanner;

/*
 * 正の整数値を読み込み、それが素数であるかどうかを判定するプログラムを作成せよ。
 * 素数とは2以上～未満のいずれの数でも割り切ることのできない整数～のことである。
 */
public class En4_24 {
	//プログラムの説明のための定数
	private static final String PRIME_NUMBER_PROGRAM_MESSAGE = "入力された値が素数であるか判定をします";
	//入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "素数判定をする数字を入力してください：";
	//素数であるという判定文のための定数
	private static final String PRIME_NUMBER_MESSAGE = "それは素数です。";
	//素数ではないという判定文のための定数
	private static final String NOT_PRIME_NUMBER_MESSAGE = "それは素数ではありません。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明を出力する
		System.out.println(PRIME_NUMBER_PROGRAM_MESSAGE);

		int primeNumber = 0;			//入力された値を代入するための変数を用意し、0で初期化する

		//値の入力してもらう
		//1以下の値が入力される場合を考慮して、do文で繰り返す入力文を出力するようにする
		do{
			//入力を促す文を出力する
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値をprimeNumberに代入する
			primeNumber = inputStream.nextInt();
		//1以下の値が入力されたいる間繰り返す
		}while(primeNumber <= 1);
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		//ここから素数判定のコード

		//2から入力された値未満までの数で、入力された値を割っていくループ
		for(int numberToDivide = 2; numberToDivide <= primeNumber; numberToDivide++){
			//素数をprimeNumberをnumberToDivideで割った余りで判定するため、剰余を代入するための変数を用意
			int divideLeftNumber = primeNumber%numberToDivide;

			//numberToDivideとprimeNumberが等しい場合（割り切れず最後のループになった場合）
			if(numberToDivide == primeNumber){
				//素数は入力された値自身でしか割り切れないため、素数であるという判定文を出力する
				System.out.println(PRIME_NUMBER_MESSAGE);
			//divideLeftNumber（剰余の値）が0と等しい場合、素数ではないという判定文を出力する
			}else if(divideLeftNumber == 0){
				//素数ではないという判定文を出力する
				System.out.println(NOT_PRIME_NUMBER_MESSAGE);
				//ひとつでも割り切れた時点で素数ではないと判明するので、判定のループを終了するためbreakで抜ける
				break;
			}
		}
	}

}
