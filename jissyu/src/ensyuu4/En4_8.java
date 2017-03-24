package ensyuu4;
import java.util.Scanner;

/*
 * 正の整数値を読み込んで、その桁数を出力するプログラムを作成せよ。
 */

public class En4_8 {
	//後々変更しやすいよう、プログラム全体で使用する変数を定数として宣言をしておく。
	private static final String WHAT_TO_DO = "桁数を表示します。",
			INPUT_MESSAGE = "1桁以上の整数値を入力してください。:";


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//桁数を表示するため、好きな整数値を入力してもらう
		System.out.println(WHAT_TO_DO);

		//入力された値を入れる変数numberOfDigitsを用意する
		int numberOfDigits;

		//0以下が入力されプログラムが停止する場合を考慮して、1以上が入力されるまでdo文で繰り返し入力を促すコードを用意
		do{
			//繰り返し出力される入力を促す文
			System.out.print(INPUT_MESSAGE);
			//入力された値を変数numberOfDigitsに代入する
			 numberOfDigits = inputStream.nextInt();

		//numberOfDigitsの値が0以下の間繰り返されるという制御式
		}while(numberOfDigits <= 0);

		//桁数を数えるために変数countを用意し、0で初期化する。
		int count = 0;

		//桁数を数えるための繰り返し処理を必ず1回は実行するためにdo文で実行
		do{
			//10で割ることができた回数で桁数が判明するので、
			//numberOfDigitsを10で割った値をnumberOfDigitsに代入しなおす
			numberOfDigits = numberOfDigits/10;
			//変数カウントの値を1増やす
			count++;

		//numberOfDigitsを10で割ったあまりが0以上の間、桁数を数える処理を繰り返す
		}while(numberOfDigits%10 > 0);

		//while文の処理を繰り返した回数が入力された値の桁数になるので、結果判定文として出力する
		System.out.println("その値は" + count + "桁です。");

	}

}
