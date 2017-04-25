package ensyuu5;
import java.util.Scanner;

/*
 * 10進整数を読み込んで、その値を8進数と16進数で表示するプログラムを作成せよ。
 */
public class En5_1 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された数を8進数と16進数で表示します。";
	//値の入力を促す説明文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "整数を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int inputNumber = 0;			//入力された値を代入するための変数を用意し0で初期化する

		//0以下の値が入力された場合を考慮して、do文で繰り返し入力文を出力する
		do{
			//10進数と8進数で表示するための数値の入力を促す文を出力する
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値を変数inoutNumberに代入する
			inputNumber = inputStream.nextInt();
		//inputNumberの値が0以下の間繰り返す
		}while(inputNumber <= 0);

		//入力された値の10進数と8進数を表示する
		System.out.printf("8進数では%oです。\n16進数では%xです。", inputNumber,inputNumber);

	}

}
