package ensyuu7;
import java.util.Scanner;

/*
 * 整数xを右にnビット回転した値を返すメソッドrRotateと、左にnビット回転した値を返すメソッドlRotateを作成せよ。
 *  int rRotate(int x, int n)
 *  int lRotate(int x, int n)
 * ※回転とは、最下位ビットと最上位ビットがつながっているとみなしてシフトすることである。
 * たとえば右に5ビット回転した場合は、シフトによって弾き出されることになる下位5ビットを上位に持ってこなければならない。
 */
public class En7_12 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された整数を、左右に入力された数だけビット回転した値を返します。";
	//整数の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "整数を入力してください：";
	//回転する数の入力を促す文のための定数
	private static final String INPUT_ROTATE_NUMBER_MESSAGE = "回転する数を入力してください：";
	//右回転の結果を表示する文のための定数
	private static final String RIGHT_ROTATE_RESULT_MESSAGE = "\n右に%d回転した値は%dです。";
	//左回転の結果を表示する文のための定数
	private static final String LEFT_ROTATE_RESULT_MESSAGE = "\n左に%d回転した値は%dです。";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int rotateNumber = 0;					//ビットを回転する値のための変数
		int bitsRotateNumber = 0;				//回転するビット数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//ビットを回転する整数の入力を促す文を表示するための出力
		System.out.print(INPUT_NUMBER_MESSAGE);
		//入力された値を回転するための変数に代入する
		rotateNumber = inputNumberStream.nextInt();

		//回転するビット数の入力を促す文を表示するための出力
		System.out.print(INPUT_ROTATE_NUMBER_MESSAGE);
		//入力された値を回転する数のための変数に代入する
		bitsRotateNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//右に回転した値を求めるためのメソッドの呼び出し
		rightRotate(rotateNumber, bitsRotateNumber);

		//左に回転した値を求めるためのメソッドの呼び出し
		leftRotate(rotateNumber, bitsRotateNumber);

	}

	//右に回転した値を求めるためのメソッド
	private static void rightRotate(int rotateNumber, int bitsRotateNumber){
		int rightRotateResult = 0;			//右回転した結果のための変数
		int rotateRightCompareNumber = 0; 	//右回転を論理演算するための変数

		//右回転の値を出すために、右にシフトした値を変数に代入する
		rightRotateResult = rotateNumber >>> bitsRotateNumber;

		//シフトによって弾き出された値を上位に持ってくるために、左に32-bitsRotateNumberシフトする
		rotateRightCompareNumber = rotateNumber << 32-bitsRotateNumber;

		//入力された値のビット数の確認のための文の出力
		System.out.print(rotateNumber + "のビット数は：");

		//入力された値のビットを確認表示するための繰り返し処理
		for(int printBits = 31; printBits >= 0; printBits--){
			//値のビットを確認表示するための出力
			System.out.print(((rotateNumber >>> printBits & 1) == 1) ? '1' : '0');
		}

		//連続した表示にならないようにするための改行の出力
		System.out.println("\n");

		//左右にシフトしたビットの論理和のための変数
		int resultRightBits = rightRotateResult|rotateRightCompareNumber;

		//ビットの回転を確認する文のための出力
		System.out.print("右に" + bitsRotateNumber + "回転したビット数は：");

		//回転したビットになっていることを確認表示するための繰り返し処理
		for(int printBits = 31; printBits >= 0; printBits--){
			//値のビットを確認表示するための出力
			System.out.print((( resultRightBits >>> printBits & 1) == 1) ? '1' : '0');
		}

		//結果を表示するための出力
		System.out.printf(RIGHT_ROTATE_RESULT_MESSAGE, bitsRotateNumber, resultRightBits);
	}

	//左に回転した値を求めるためのメソッド
	private static void leftRotate(int rotateNumber, int bitsRotateNumber){
		int leftRotateResult = 0;				//左回転した結果のための変数
		int rotateLeftCompareNumber = 0;		//左回転を論理演算するための変数

		//左回転の値を出すために、左にシフトした値を変数に代入する
		leftRotateResult = rotateNumber << bitsRotateNumber;

		//シフトによって弾き出された値を下位に持ってくるために、右に32-bitsRotateNumberシフトする
		rotateLeftCompareNumber = rotateNumber >> 32-bitsRotateNumber;

		//連続して表示されないようにするための改行の出力
		System.out.println();

		//左右にシフトしたビットの論理和のための変数
		int resultRightBits = leftRotateResult|rotateLeftCompareNumber;

		//値を左に回転したビット数の確認のための文の出力
		System.out.print("\n左に" + bitsRotateNumber + "回転したビット数は：");

		//回転したビット数を確認表示するための繰り返し処理
		for(int printBits = 31; printBits >= 0; printBits--){
			//回転したビット数を表示するための出力
			System.out.print(((resultRightBits >>> printBits & 1) == 1) ? '1' : '0');
		}

		//結果を表示するための出力
		System.out.printf(LEFT_ROTATE_RESULT_MESSAGE, bitsRotateNumber, resultRightBits);
	}

}
