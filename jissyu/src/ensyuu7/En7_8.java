package ensyuu7;
import java.util.Random;
import java.util.Scanner;

/*
 * firstNumber以上secondNumber未満の乱数を生成して、その値を返却するメソッドrandomを作成せよ。
 * 内部で乱数を生成する標準ライブラリ（p.45）を呼び出すこと。
 * int random(int firstNumber, int secondNumber)
 * なお、secondNumberの値がfirstNumberより小さい場合には、firstNumberの値をそのまま返却すること。
 */
public class En7_8 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された二値の間の乱数を表示します。";
	//一つ目の値の入力を促す文のための定数
	private static final String INPUT_FIRST_NUMBER_MESSAGE = "\n一つ目の値を入力してください：";
	//二つ目の値の入力を促す文のための定数
	private static final String INPUT_SECOND_NUMBER_MESSAGE = "二つ目の値を入力してください：";
	//生成した乱数を表示する文のための定数
	private static final String OUTPUT_RANDOM_RESULT_STRING = "乱数：%d";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputRandomNumber = new Scanner(System.in);

		int firstNumber = 0;		//入力された一つ目の値のための変数
		int secondNumber = 0;		//入力された二つ目の値のための変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//一つ目の値の入力を促す文を表示するための出力
		System.out.print(INPUT_FIRST_NUMBER_MESSAGE);
		//入力された値を乱数を生成するための変数に代入する
		firstNumber = inputRandomNumber.nextInt();

		//二つ目の値の入力を促す文を表示するための出力
		System.out.print(INPUT_SECOND_NUMBER_MESSAGE);
		//入力された値を乱数を生成するための変数に代入する
		secondNumber = inputRandomNumber.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputRandomNumber.close();

		//乱数を生成するメソッドを呼び出し、表示するための出力
		System.out.printf(OUTPUT_RANDOM_RESULT_STRING, random(firstNumber, secondNumber));
	}

	//入力された二値の間の乱数を生成するためのメソッド
	static int random(int firstNumber, int secondNumber){
		//乱数を生成するためのjavaプログラムの呼び出し
		Random randomNumber = new Random();

		int randomResult;			//生成した乱数を代入するための変数

		//secondNumberの値がfirstNumberの値より小さい場合の条件分岐
		if(secondNumber < firstNumber){
			//firstNumberの値をメインメソッドに返却するための代入
			randomResult = firstNumber;
		//firstNumberの値がsecondNumberの値より小さい場合の条件分岐
		}else {
			//二値の間の乱数を生成するためのコード
			randomResult = randomNumber.nextInt(secondNumber-firstNumber)+firstNumber;
		}

		//生成した乱数をメインメソッドに返却するreturn文
		return randomResult;
	}

}
