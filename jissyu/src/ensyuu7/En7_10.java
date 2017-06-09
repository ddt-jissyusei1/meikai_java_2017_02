package ensyuu7;
import java.util.Random;
import java.util.Scanner;

/*
 * List7-11(p.238)を拡張して、以下の四つの問題をランダムに出題するプログラムを作成せよ。
 * firstMathNumber + secondMathNumber + thirdMathNumber
 * firstMathNumber + secondMathNumber - thirdMathNumber
 * firstMathNumber - secondMathNumber + thirdMathNumber
 * firstMathNumber - secondMathNumber - thirdMathNumber
 */
public class En7_10 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "暗算力トレーニング！！";
	//一つ目の問題の表示のための定数
	private static final String OUTPUT_FIRST_QUESTION_STRING = "%d + %d + %d = ";
	//二つ目の問題の表示のための定数
	private static final String OUTPUT_SECOND_QUESTION_STRING = "%d + %d - %d = ";
	//三つ目の問題の表示のための定数
	private static final String OUTPUT_THIRD_QUESTION_STRING = "%d - %d + %d = ";
	//四つ目の問題の表示のための定数
	private static final String OUTPUT_FOURTH_QUESTION_STRING = "%d - %d - %d = ";
	//正解文のための定数
	private static final String CORRECT_ANSWER_MESSAGE = "正解です。";
	//不正解文のための定数
	private static final String WRONG_ANSWER_MESSAGE = "不正解です。";
	//プログラムの繰り返しの可否の入力を促す文のための定数
	private static final String OUTPUT_REPEAT_PROGRAM = "もう一度やりますか？<Yes・・・1/No・・・0>：";

	//キーボードからの入力ストリームを読み込むためのプログラムをスコープの関係でここに記述する
	static Scanner inputNumberStream = new Scanner(System.in);

	public static void main(String[] args) {
		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//問題を出題するためのメソッドの呼び出し式
		mentalArithmeticQuestion();
	}

	//問題を出題するためのメソッド
	private static void mentalArithmeticQuestion(){
		//乱数を生成するためのjavaプログラムの呼び出し
		Random randomNumber = new Random();

		//出題を続けるための繰り返し処理
		do{
			//乱数を生成して出題する式に表示するための一つ目の変数に代入する
			int firstMathNumber = randomNumber.nextInt(900) + 100;
			//乱数を生成して出題する式に表示するための二つ目の変数に代入する
			int secondMathNumber = randomNumber.nextInt(900) + 100;
			//乱数を生成して出題する式に表示するための三つ目の変数に代入する
			int thirdMathNumber = randomNumber.nextInt(900) + 100;

			//出題する問題を決定するための乱数の生成
			int questionNumber = randomNumber.nextInt(4);

			int questionAnswer = 0;	//解答者が入力した値のための変数
			int correctAnswer = 0;		//正解の値のための変数

			//正解するまで出題を続けるための繰り返し処理
			do{
				//出題する式を生成するためのメソッドを呼び出し、返却された正解値を変数に代入するためのコード
				correctAnswer = questionGenerator(firstMathNumber, secondMathNumber, thirdMathNumber, questionNumber);
				//解答者が入力した値が正解か判定するために変数に代入する
				questionAnswer = inputNumberStream.nextInt();
				//入力した値が不正解だった場合に表示するための条件
				if(questionAnswer != correctAnswer){
					//不正解文を表示するための出力
					System.out.println(WRONG_ANSWER_MESSAGE);
				}
			//入力された値が正解値と等しくない間繰り返すための条件式
			}while(questionAnswer != correctAnswer);
			//正解文を表示するための出力
			System.out.println(CORRECT_ANSWER_MESSAGE);

		//続けて出題する可否を決定するためのメソッドを呼び出し、返却値がtrueの間繰り返す条件文
		}while(confirmRetry());
	}

	//出題する式を生成するためのメソッド
	private static int questionGenerator(int firstMathNumber, int secondMathNumber, int thirdMathNumber, int questionNumber){

		int answer = 0;		//正解の値のための変数

		//生成する式を決定するための条件分岐式
		//questionNumberの値が0の場合の条件分岐
		if(questionNumber == 0){
			//一つ目の式を生成して表示するための出力
			System.out.printf(OUTPUT_FIRST_QUESTION_STRING,firstMathNumber, secondMathNumber, thirdMathNumber);
			//生成した式の正解を計算してメインメソッドに返却するための変数に代入する
			answer = firstMathNumber + secondMathNumber + thirdMathNumber;
		//questionNumberの値が1の場合の条件分岐
		}else if(questionNumber == 1){
			//二つ目の式を生成して表示するための出力
			System.out.printf(OUTPUT_SECOND_QUESTION_STRING,firstMathNumber, secondMathNumber, thirdMathNumber);
			//生成した式の正解を計算してメインメソッドに返却するための変数に代入する
			answer = firstMathNumber + secondMathNumber - thirdMathNumber;
		//questionNumberの値が2の場合の条件分岐
		}else if(questionNumber == 2){
			//三つ目の式を生成して表示するための出力
			System.out.printf(OUTPUT_THIRD_QUESTION_STRING,firstMathNumber, secondMathNumber, thirdMathNumber);
			//生成した式の正解を計算してメインメソッドに返却するための変数に代入する
			answer = firstMathNumber - secondMathNumber + thirdMathNumber;
			//questionNumberの値が3の場合の条件分岐
		}else if(questionNumber == 3){
			//四つ目の式を生成して表示するための出力
			System.out.printf(OUTPUT_FOURTH_QUESTION_STRING,firstMathNumber, secondMathNumber, thirdMathNumber);
			//生成した式の正解を計算してメインメソッドに返却するための変数に代入する
			answer = firstMathNumber - secondMathNumber - thirdMathNumber;
		}
		//メインメソッドに正解の値を返却するためのreturn文
		return answer;
	}

	//続けて出題する可否のためのメソッド
	private static boolean confirmRetry(){
		int continueProgram;		//出題を続ける判定のための変数
		//プログラム繰り返し判定の値が1か0が入力されるまで繰り返すための処理
		do{
			//プログラムの繰り返しの可否の入力を促す文の表示のための出力
			System.out.print(OUTPUT_REPEAT_PROGRAM);
			//入力された値を繰り返し可否判定のための変数に代入する
			continueProgram = inputNumberStream.nextInt();
			//メインメソッドにboolean型の値を返却するためのreturn文
			return continueProgram == 1;
		//入力された値が0か1以外の間繰り返すための条件文
		}while(continueProgram != 0 && continueProgram != 1);
	}
}
