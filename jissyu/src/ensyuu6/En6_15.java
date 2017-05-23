package ensyuu6;
import java.util.Random;
import java.util.Scanner;


/*
 * 曜日を表示して、その英語表現を入力させる英単語プログラムを作成せよ。
 * ・出題する曜日は乱数で生成する。
 * ・学習者が望む限り、何度の繰り返せる
 * ・同一曜日を連続して出題しない。
 */
public class En6_15 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "曜日を表す英単語の学習プログラムです。";
	//解答の入力を促す文のための定数
	private static final String INPUT_ANSWER_MESSAGE = "\n英語の曜日名を小文字で入力してください。";
	//出題文形成のための定数
	private static final String OUTPUT_QUESTION_STRING = "%s曜日：";
	//正解文のための定数
	private static final String CORRECT_ANSWER_MESSAGE = "正解です。";
	//不正解文のための定数
	private static final String WRONG_ANSWER_MESSAGE = "不正解です。";
	//繰り返しの可否を問う文のための定数
	private static final String REPEAT_PROGRAM_MESSAGE = "\nもう一度やる場合は１を、終了する場合は０を入力してください：";
	//プログラム終了文のための定数
	private static final String END_PROGRAM_MESSAGE = "プログラムを終了します、お疲れさまでした。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputWeekStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();
		//出題する曜日のための配列
		String[] weekStringArray = {"月", "火", "水", "木", "金", "土", "日" };
		//曜日を英語表記で比較するための配列
		String[] weekEnglishStringArray = {"monday", "tuesday", "wendsday", "thursday", "friday", "saturday", "sunday"};

		//プログラムの説明文を出力するためのコード
		System.out.println(PROGRAM_MESSAGE);

		String answerWeek;							//入力された解答を代入するための変数
		String weekQuestion;						//出題文に曜日を出力するための変数
		int sameWeekCheck = 0;					//連続した曜日判定のための変数
		int weekQuestionArrayNumber = 0;			//生成した乱数を代入するための変数
		int repeatProgram = 0;					//出題を繰り返す判定のための変数

		//学習者が望む限りプログラムを繰り返せるためのループ処理
		do{

			//解答の入力を促す文を出力するためのコード
			System.out.println(INPUT_ANSWER_MESSAGE);

			//連続して同じ曜日が出題されないよう判定するためのループ処理
			do{
				//生成した乱数を変数に代入する
				weekQuestionArrayNumber = randomNumber.nextInt(6);
			//前問と同じ値である間繰り返す条件文
			}while(weekQuestionArrayNumber == sameWeekCheck);

			//次の出題で連続して同じ値にならないよう、判定のための変数に代入する
			sameWeekCheck = weekQuestionArrayNumber;
			//曜日を出題するために、要素の値を変数に代入する
			weekQuestion = weekStringArray[weekQuestionArrayNumber];

			//正解するまで出題を繰り返すためのループ処理
			do{
				//生成した問題を出力するためのコード
				System.out.printf(OUTPUT_QUESTION_STRING,weekQuestion);
				//入力された値を正解と比較するため変数に代入する
				answerWeek = inputWeekStream.next();

				//不正解だった場合に出力する文のための条件式
				if(!answerWeek.equals(weekEnglishStringArray[weekQuestionArrayNumber])){
					System.out.println(WRONG_ANSWER_MESSAGE);
				}
			//入力された値が、正解の値と等しくない間出題を繰り返すための条件文
			}while(!answerWeek.equals(weekEnglishStringArray[weekQuestionArrayNumber]));

			//正解したと通知するための文を出力するコード
			System.out.println(CORRECT_ANSWER_MESSAGE);

			//プログラムの繰り返しの可否を問うための文を出力するコード
			System.out.print(REPEAT_PROGRAM_MESSAGE);
			//入力された値を繰り返し判定のための変数に代入する
			repeatProgram = inputWeekStream.nextInt();

		//repeatProgramの値が1の間、出題を繰り返すための条件文
		}while(repeatProgram == 1);

		//値の入力が終了したので、開いていたリソースを開放する
		inputWeekStream.close();

		//プログラムの終了を通知する文を出力するためのコード
		System.out.println(END_PROGRAM_MESSAGE);

	}

}
