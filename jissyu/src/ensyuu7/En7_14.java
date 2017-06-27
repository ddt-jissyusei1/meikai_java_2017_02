package ensyuu7;
import java.util.Scanner;

/*
 * 整数bitChangeのposBitNumber目を最下位として連続するrepeatBit個のビットを、
 * 1にした値を返すメソッドsetN、
 * 0にした値を返すメソッドresetN、
 * 反転した値を返すメソッドinverseNを作成せよ。
 */
public class En7_14 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "整数の指定されたビットを最下位として、"
													+ "連続したビット数までをそれぞれ1、0、反転、した値を返します。";
	//ビットを変換する整数の入力を促す文のための定数
	private static final String INPUT_BITCHANGE_NUMBER_MESSAGE = "整数を入力してください：";
	//最下位ビットの入力を促す文のための定数
	private static final String INPUT_POSBIT_NUMBER_MESSAGE = "\n最下位に指定するビットを入力してください：";
	//連続して変換するビット数の入力を促す文のための定数
	private static final String INPUT_REPEAT_BIT_NUMBER_MESSAGE = "変換するビット数を入力してください：";
	//1と0に変換の共通の結果文のための定数
	private static final String OUTPUT_SET_RESET_RESULT_MESSAGE = "\n%dビット目を最下位として、"
																		+ "%d個連続したビットを%dに変換した値は：%d\n";
	//反転変換した結果文のための定数
	private static final String OUTPUT_INVERSE_RESULT_MESSAGE = "\n%dビット目を最下位として、"
																		+ "%d個連続したビットを反転した値は：%d\n";
	//変換するビット1のための定数
	private static final int CHANGE_BIT_ONE = 1;
	//変換するビット0のための定数
	private static final int CHANGE_BIT_ZERO = 0;

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int bitChangeNumber = 0;				//ビットを変換する整数のための変数
		int posBitNumber = 0;					//最下位に指定するビットのための変数
		int repeatBitNumber = 0;				//ビットを変換する数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//ビットを変換する整数の入力を促す文を表示するための出力
		System.out.print(INPUT_BITCHANGE_NUMBER_MESSAGE);
		//読み込んだ値を変換するための変数に代入する
		bitChangeNumber = inputNumberStream.nextInt();

		//入力された整数のビットを確認するための、ビット出力メソッドの呼び出し
		printBits(bitChangeNumber);


		//最下位ビットの入力を促す文を表示するための出力
		System.out.print(INPUT_POSBIT_NUMBER_MESSAGE);
		//読み込んだ値を最下位ビットに指定するための変数に代入する
		posBitNumber = inputNumberStream.nextInt();

		//変換するビット数の入力を促す文を表示するための出力
		System.out.print(INPUT_REPEAT_BIT_NUMBER_MESSAGE);
		//読み込んだ値を変換する数に指定するための変数に代入する
		repeatBitNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//入力文と結果文を分けて表示するための改行文の出力
		System.out.println();

		//ビットを指定された数だけ1に変換するためのメソッドの呼び出し
		int setResult = setN(bitChangeNumber, posBitNumber, repeatBitNumber);
		//1に変換した結果を表示するための文の出力
		System.out.printf(OUTPUT_SET_RESET_RESULT_MESSAGE, posBitNumber, repeatBitNumber, CHANGE_BIT_ONE, setResult);
		//ビットを確認するための、ビット出力メソッドの呼び出し
		printBits(setResult);

		//ビットを指定された数だけ0に変換するためのメソッドの呼び出し
		int resetResult = resetN(bitChangeNumber, posBitNumber, repeatBitNumber);
		//0に変換した結果を表示するための文の出力
		System.out.printf(OUTPUT_SET_RESET_RESULT_MESSAGE, posBitNumber, repeatBitNumber, CHANGE_BIT_ZERO, resetResult);
		//ビットを確認するための、ビット出力メソッドの呼び出し
		printBits(resetResult);

		//ビットしてされた数だけ反転するためのメソッドの呼び出し
		int inverseResult = inverseN(bitChangeNumber, posBitNumber, repeatBitNumber);
		//反転した結果を表示するための文の出力
		System.out.printf(OUTPUT_INVERSE_RESULT_MESSAGE, posBitNumber, repeatBitNumber, inverseResult);
		//ビットを確認するための、ビット出力メソッドの呼び出し
		printBits(inverseResult);

	}

	//ビットを表示するためのメソッド
	private static void printBits(int printingNumber){
		//引数のビットを表示するための繰り返し処理
		for(int printBitsLoop = 31; printBitsLoop >= 0; printBitsLoop--){
			//整数のビットを確認するための出力
			System.out.print((( printingNumber >>> printBitsLoop & 1) == 1) ? '1': '0');
		}
	}

	//ビットを指定された数だけ1に変換するためのメソッド
	private static int setN(int bitChangeNumber, int posBitNumber, int repeatBitNumber){
		int rightShiftBit = 0;		//右シフトした値のための変数
		int leftShiftBit = 0;			//左シフトした1の補数のための変数
		int setResult = 0;				//1に変換した結果のための変数

		//指定されたビットを最下位にするための右シフト
		rightShiftBit = bitChangeNumber >>> posBitNumber;
		//最下位ビットから連続して1にするための、1の補数の左シフト
		//最下位ビット含めての連続なので、repeatBitNumberの値を-1する
		leftShiftBit = ~1 << repeatBitNumber-1;
		//最下位ビットから連続したビットを1に変換するための論理和
		setResult = rightShiftBit | ~leftShiftBit;

		//メインメソッドに結果を返却するためのreturn文
		return setResult;
	}

	//ビットを指定された数0に変換するためのメソッド
	private static int resetN(int bitChangeNumber, int posBitNumber, int repeatBitNumber){
		int rightShiftBit = 0;		//右シフトした値のための変数
		int leftShiftBit = 0;			//左シフトした1のための変数
		int resetResult = 0;			//0に変換した結果のための変数

		//指定されたビットを最下位にするための右シフト
		rightShiftBit = bitChangeNumber >>> posBitNumber;
		//最下位ビットから連続して0にするための、1の左シフト
		//最下位ビット含めての連続なので、repeatBitNumberの値を-1する
		leftShiftBit = ~1 << repeatBitNumber-1;
		//最下位ビットから連続したビットを0に変換するための論理積
		resetResult = rightShiftBit & leftShiftBit;

		//メインメソッドに結果を返却するためのreturn文
		return resetResult;
	}

	//ビットを指定された数だけ反転するためのメソッド
	private static int inverseN(int bitChangeNumber, int posBitNumber, int repeatBitNumber){
		int rightShiftBit = 0;		//右シフトした値のための変数
		int leftShiftBit = 0;			//左シフトした1のための変数
		int inverseResult = 0;		//反転した結果のための変数

		//指定されたビットを最下位にするための右シフト
		rightShiftBit = bitChangeNumber >>> posBitNumber;
		//最下位ビットから連続して反転するための、1の左シフト
		//最下位ビット含めての連続なので、repeatBitNumberの値を-1する
		leftShiftBit = ~1 << repeatBitNumber-1;
		//最下位ビットから連続したビットを反転するための排他的論理和
		inverseResult = rightShiftBit ^ ~leftShiftBit;

		//メインメソッドに結果を返却するためのreturn文
		return inverseResult;
	}


}
