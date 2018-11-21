package ensyuu7;
import java.util.Scanner;

/*
 *List7-12(p.241)のメソッドprintBitsは、int型整数値の内部のビットを表示するものであった。
 *他の整数型に対しても同様の働きを行う、多重定義されたメソッド群を作成せよ。
 *void printBits(byte overloadNumber)
 *void printBits(short overloadNumber)
 *void printBits(int overloadNumber)
 *void printBits(long overloadNumber)
 */
public class En7_32 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "４つの整数型のビットを表示します。";
	//ビットを表示する整数の入力を促す文のための定数
	private static final String INPUT_BIT_NUMBER_MESSAGE ="ビットを表示する整数を入力してください：";
	//byte型整数の内部ビットを表示する文のための定数
	private static final String PRINT_BYTE_BITS_STRING = "\nbyte型整数のビットは:";
	//short型整数の内部ビットを表示する文のための定数
	private static final String PRINT_SHORT_BITS_STRING = "\nshort型整数のビットは：";
	//int型整数の内部ビットを表示する文のための定数
	private static final String PRINT_INT_BITS_STRING = "\nint型整数のビットは:";
	//long型整数の内部ビットを表示する文のための定数
	private static final String PRINT_LONG_BITS_STRING = "\nlong型整数のビットは:";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		int overloadNumber = 0;						//整数型のビットを表示する整数のための変数

		//内部ビットを表示する整数の入力を促す文を表示するための出力
		System.out.print(INPUT_BIT_NUMBER_MESSAGE);
		//整数型のビットの表示に使用するために、入力された値を変数に代入する
		overloadNumber = inputNumberStream.nextInt();

		//値入力が終了したので、開いていたリソースを開放する
		inputNumberStream.close();

		//byte型整数の内部ビットを表示するための結果文の出力
		System.out.print(PRINT_BYTE_BITS_STRING);
		//byta型整数の内部ビットを表示するためのメソッドの呼び出し
		printBits((byte)overloadNumber);

		//short型整数の内部ビットを表示するための結果文の出力
		System.out.print(PRINT_SHORT_BITS_STRING);
		//short型整数の内部ビットを表示するためのメソッドの呼び出し
		printBits((short)overloadNumber);

		//int型整数の内部ビットを表示するための結果文の出力
		System.out.print(PRINT_INT_BITS_STRING);
		//int型整数の内部ビットを表示するためのメソッドの呼び出し
		printBits(overloadNumber);

		//lomg型整数の内部ビットを表示するための結果文の出力
		System.out.print(PRINT_LONG_BITS_STRING);
		//long型整数の内部ビットを表示するためのメソッドの呼び出し
		printBits((long)overloadNumber);

	}

	//byte型整数の内部ビットを表示するためのメソッド
	private static void printBits(byte overloadNumber){
		//byte型のビットを表示するための繰り返し処理
		for(int printByteBitsLoop = 7; printByteBitsLoop >= 0; printByteBitsLoop--){
			//引数の整数のビットを表示するための出力
			System.out.print(((overloadNumber >>> printByteBitsLoop & 1) == 1) ? '1' : '0');
		}
	}

	//short型整数の内部ビットを表示するためのメソッド
	private static void printBits(short overloadNumber){
		//short型のビットを表示するための繰り返し処理
		for(int printShortBitsLoop = 15; printShortBitsLoop >= 0; printShortBitsLoop--){
			//引数の整数のビットを表示するための繰り返し処理
			System.out.print(((overloadNumber >>> printShortBitsLoop & 1) == 1) ? '1' : '0');
		}
	}

	//int型整数の内部ビットを表示するためのメソッド
	private static void printBits(int overloadNumber){
		//int型のビットを表示するための繰り返し処理
		for(int printIntBitsLoop = 31; printIntBitsLoop >= 0; printIntBitsLoop--){
			//引数のビットを表示するための出力
			System.out.print(((overloadNumber >>> printIntBitsLoop & 1) == 1) ? '1' : '0');
		}
	}

	//long型整数の内部ビットを表示するためのメソッド
	private static void printBits(long overloadNumber){
		//long型のビットを表示するための繰り返し処理
		for(int printLongBitsLoop = 63; printLongBitsLoop >= 0; printLongBitsLoop--){
			//引数のビットを表示するための出力
			System.out.print(((overloadNumber >>> printLongBitsLoop & 1) == 1) ? '1' : '0');
		}
	}

}
