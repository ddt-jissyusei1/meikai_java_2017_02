package ensyuu7;
import java.util.Scanner;
/*
 * 整数numberChangeのposビット目（最下位から0,1,2,・・・と数える）を、1にした値を返すメソッドset、0にした値を返すメソッドreset、
 * 反転した値を返すメソッドinverseを作成せよ。
 */
public class En7_13 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された値の指定されたビット目をそれぞれ1、0、反転、に変換してその値を返します。";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "整数を入力してください：";
	//変換するビットを指定してもらう文のための定数
	private static final String INPUT_POS_BIT_NUMBER_MESSAGE = "変換するビットの番号を入力してください：";
	//ビットを1に変換した結果の文のための定数
	private static final String OUTPUT_SET_ONE_RESULT_MESSAGE = "\n%dビット目を1に変換した値は：%d\n";
	//ビットを0に変換した結果の文のための定数
	private static final String OUTPUT_RESET_RESULT_MESSAGE = "\n%dビット目を0に変換した値は：%d\n";
	//ビットを反転した結果の文のための定数
	private static final String OUTPUT_INVERSE_RESULT_MESSAGE = "\n%dビット目を反転した値は：%d\n";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int numberChange = 0;			//変換する整数のための変数
		int posBitNumber = 0;			//変換するビットのための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//変換する整数の入力を促す文を表示するための出力
		System.out.print(INPUT_NUMBER_MESSAGE);
		//読み込んだ整数を、変換するための変数に代入する
		numberChange = inputNumberStream.nextInt();

		//変換するビットの入力を促す文を表示するための出力
		System.out.print(INPUT_POS_BIT_NUMBER_MESSAGE);
		//読み込んだ値を、変換するビットを指定するための変数に代入する
		posBitNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//入力された整数のビットを出力するための繰り返し処理
		for(int printBits = 31; printBits >= 0; printBits--){
			//ビットを表示するための出力
			System.out.print(((numberChange >>> printBits & 1) == 1) ? '1' : '0');
		}

		//連続した表示ならないようにするための改行出力
		System.out.println();

		//入力された整数のposBitNumber目を1に変換するためのメソッドを呼び出し、戻った値を結果表示のための変数に代入する
		int setResult = set(numberChange, posBitNumber);
		//1に変換した結果を表示するための出力
		System.out.printf(OUTPUT_SET_ONE_RESULT_MESSAGE, posBitNumber, setResult);

		//posBitNumber目が変換していることを確認するためのビット出力メソッドの呼び出し
		printBits(setResult);

		//入力された整数のposBitNumber目を0に変換するためのメソッドを呼び出し、戻った値を結果表示のための変数に代入する
		int resetResult = reset(numberChange, posBitNumber);
		//0に変換した結果を表示するための出力
		System.out.printf(OUTPUT_RESET_RESULT_MESSAGE, posBitNumber, resetResult);

		//posBitNumber目が変換していることを確認するためのビット出力メソッドの呼び出し
		printBits(resetResult);

		//入力された整数のposBitNumber目を反転するためのメソッドを呼び出し、戻った値を結果表示のための変数に代入する
		int inverseResult = inverse(numberChange, posBitNumber);
		//反転した結果を表示するための出力
		System.out.printf(OUTPUT_INVERSE_RESULT_MESSAGE, posBitNumber, inverseResult);

		//posBitNumber目が反転していることを確認するためのビット出力メソッドの呼び出し
		printBits(inverseResult);

	}

	//入力された整数の指定されたビット目を1に変換するためのメソッド
	private static int set(int numberChange, int posBitNumber){
		int shiftedNumber = 0;		//整数をシフトした値のための変数
		int reShiftNumber = 0;		//posBitNumber目を変換後、シフト前の並びに戻した値のための変数
		int setResult = 0;				//1に変換した結果のための変数

		//posBitNumber目のを1に変換するための右シフト
		shiftedNumber = numberChange >>> posBitNumber | 1;
		//posBitNumber目を1に変換したビットを、シフト前の並びに戻すための左シフト
		reShiftNumber = shiftedNumber << posBitNumber;
		//シフト前とビット変換後のビットを論理和した結果をメインメソッド返却用の変数に代入するためのコード
		setResult = numberChange | reShiftNumber;

		//結果の値をメインメソッドに返却するためのreturn文
		return setResult;
	}

	//入力された整数の指定されたビット目を0に変換するためのメソッド
	private static int reset(int numberChange, int posBitNumber){
		int shiftedNumber = 0;		//整数をシフトした値のための変数
		int resetResult = 0;			//0に変換した結果のための変数

		//posBitNumber目を0に変換するために、1をposBitNumber左シフトする
		shiftedNumber = 1 << posBitNumber;
		//シフト前とシフト後のビット補数を論理和した結果をメインメソッド返却用の変数に代入するためのコード
		resetResult = numberChange & ~shiftedNumber;

		//結果の値をメインメソッドに返却するためのreturn文
		return resetResult;
	}

	//入力された整数の指定されたビット目を反転するためのメソッド
	private static int inverse(int numberChange, int posBitNumber){
		int inverseShiftNumber = 0;	//整数をシフトした値のための変数
		int inverseReshiftNumber = 0;//posBitNumber目を反転後、シフト前の並びに戻した値のための変数
		int inverseResult = 0;		//反転した結果のための変数

		//posBitNumber目を反転する判定のための条件分岐
		//右シフトした最下位ビットが1の場合のための実行文
		if((numberChange >>> posBitNumber & 1) == 1){
			//論理和でposBitNumber目を反転するために、1を左シフトする
			inverseShiftNumber = 1 << posBitNumber;
			//posBitNumber目を0にするための論理和
			inverseResult = numberChange & ~inverseShiftNumber;
		//右シフトした最下位ビットが1以外の場合（0の場合）のための実行分
		}else{
			//posBitNumber目を反転するための右シフト
			inverseShiftNumber = numberChange >>> posBitNumber | 1;
			//posBitNumber目を反転したビットを、シフト前の並びに戻すための左シフト
			inverseReshiftNumber = inverseShiftNumber << posBitNumber;
			//シフト前とビット反転後のビットを論理和した結果をメインメソッド返却用の変数に代入するためのコード
			inverseResult = numberChange | inverseReshiftNumber;
		}
		//結果の値をメインメソッドに返却するためのreturn文
		return inverseResult;
	}

	//ビットを表示するための出力メソッド
	private static void printBits(int printNumber){
		//ビットを表示するための繰り返し処理
		for(int printBitsLoop = 31; printBitsLoop >= 0; printBitsLoop--){
			//ビットを表示するための出力
			System.out.print(((printNumber >>> printBitsLoop & 1) == 1) ? '1' : '0');
		}

	}

}
