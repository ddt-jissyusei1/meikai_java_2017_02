package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * 月を１～１２の数値として表示して、その英語表現を入力させる英単語プログラムを作成せよ。
 * ・出題する月の値は乱数で生成する。
 * ・学習者が望む限り、何度も繰り返せる。
 * ・同一月を連続で出してはいけない。
 * 文字列s1とs2が等しいかどうかの判定は、s1.equals(s2)によって行える。
 */
public class En6_14 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "月を表す英単語の学習プログラムです。";
	//解答の入力を促す文のための定数
	private static final String INPUT_ANSWER_MESSAGE = "\n英語の月名を入力してください。"
																+ "\nなお、先頭は大文字で、2文字目以降は小文字とします。";
	//出題文のための定数
	private static final String OUTPUT_QUESTION_STRING = "%d月：";
	//正解文のための定数
	private static final String CORRECT_ANSWER_MESSAGE = "正解です。";
	//不正解文のための定数
	private static final String WRONG_ANSWER_MESSAGE = "違います。";
	//繰り返しの可否の文のための定数
	private static final String REPEAT_QUESTION_MESSAGE = "もう一度やる場合は１を、終了する場合は０を入力してください：";
	//プログラムの終了文のための定数
	private static final String END_PROGRAM_MESSAGE = "プログラムを終了します、お疲れさまでした。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputAnswerStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();
		//出題する月の英語名のための配列を宣言する
		String[] englishMonthString = {"January", "February", "March", "April", "May", "June", "July", "August",
											"September", "October", "November", "December"};

		//プログラムの説明文を出力するためのコード
		System.out.println(PROGRAM_MESSAGE);

		//解答の入力を促すための文を出力するコード
		System.out.println(INPUT_ANSWER_MESSAGE);

		int month = 0;										//出題する月の値を代入するための変数
		int sameNumberCheck = 0;							//乱数が連続して同じ数値にならないよう比較するための変数
		int repeatProgram;								//出題を繰り返す判定のための定数
		String answerMonth;								//解答を代入するための変数

		//学習者が望む限りプログラムを繰り返せるための繰り返し処理
		do{
			//連続して同じ月が出題されないようにするための繰り返し処理
			do{
				//乱数を生成して変数に代入する
				month = randomNumber.nextInt(11)+1;
			//monthの値がsameNumberCheckと同じ間繰り返すための条件文
			}while(month == sameNumberCheck);

			//次の出題で連続した月かどうかの判定のために、monthの値を変数に代入する
			sameNumberCheck = month;

			//正解するまで問題を出力するためのループ処理
			do{
				//生成した問題を出題するためのコード
				System.out.printf(OUTPUT_QUESTION_STRING,month);
				//入力された文字列を正解変数に代入する
				answerMonth = inputAnswerStream.next();

				//正解判定のための条件式
				//if(answerMonth.equals(englishMonthString[month-1])){
					//正解したと通知するための文を出力する
					//System.out.println(CORRECT_ANSWER_MESSAGE);
					//正解するまで出力を続けるループ処理を抜けるためのbreak文
					//break;
				//}
				//不正解だった場合出力文
				System.out.println(WRONG_ANSWER_MESSAGE);
			}while(!answerMonth.equals(englishMonthString[month-1]));

			//プログラムの繰り返しの可否を聞くための文を出力するためのコード
			System.out.print(REPEAT_QUESTION_MESSAGE);
			//入力された値を繰り返し判定のための変数に代入する
			repeatProgram = inputAnswerStream.nextInt();

		//repeatProgramの値が1である間、出題を繰り返すための条件文
		}while(repeatProgram == 1);

		//値の入力が終了したので、開いていたリソースを開放する
		inputAnswerStream.close();

		//プログラムの終了を知らせるための文を出力する
		System.out.println(END_PROGRAM_MESSAGE);

	}

}
