package ensyuu7;
import java.util.Scanner;

/*
 * List7-7に示したasteriskNumber個の'*'を連続表示するメソッドputStarsを、
 * 内部でList7-8のメソッドputCharsを呼び出すことによって表示を行うように書きかえよ。
 */
public class En7_7 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された値の数だけ*を表示します。";
	//入力を促す文のための定数
	private static final String INPUT_ASTERISK_NUMBER_MESSAGE = "\n表示する個数を入力してください：";
	//表示する*のための定数
	private static final char OUTPUT_ASTERISK = '*';

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputCharStream = new Scanner(System.in);

		int asteriskNumber = 0;	//表示する*の数のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//表示する*の数の入力を促す文の表示のための出力
		System.out.print(INPUT_ASTERISK_NUMBER_MESSAGE);
		//入力された値をメソッドで使用するために変数に代入する
		asteriskNumber = inputCharStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputCharStream.close();

		//*を表示するためのメソッドの呼び出し式
		putStars(asteriskNumber);
	}

	//*を連続表示するためのメソッド
	static void putStars(int asteriskNumber){
		int outputAsteriskLoop = 0;		//*を連続表示する繰り返し制御のための変数

		//asteriskNumberの値だけ*を表示するための繰り返し処理
		while(outputAsteriskLoop++ < asteriskNumber){
			//*を表示するためのメソッドの呼び出し式
			putChars();
		}
	}

	//*を出力するためのメソッド
	static void putChars(){
		//*を表示するための出力
		System.out.print(OUTPUT_ASTERISK);
	}

}
