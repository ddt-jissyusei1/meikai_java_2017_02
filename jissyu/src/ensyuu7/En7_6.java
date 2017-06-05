package ensyuu7;
import java.util.Scanner;

/*
 * 引数monthで指定された月の季節を表示するメソッドprintSeasonを作成せよ。
 * monthが３，４，５であれば『春』、６，７，８であれば『夏』、
 * ９、１０，１１であれば『秋』、１２、１、２であれば『冬』と表示し、それ以外の値であれば何も表示しないこと。
 */
public class En7_6 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された月の季節を表示します。"
														+ "\n１～１２以外の値の場合何も表示しません。";
	//値の入力を促す文のための定数
	private static final String INPUT_MONTH_MESSAGE = "\n何月ですか？：";
	//『春』と表示するための定数
	private static final String OUTPUT_SPRING_MESSAGE = "『春』です。";
	//『夏』と表示するための定数
	private static final String OUTPUT_SUMMER_MESSAGE = "『夏』です。";
	//『秋』と表示するための定数
	private static final String OUTPUT_AUTUMN_MESSAGE = "『秋』です。";
	//『冬』と表示するための定数
	private static final String OUTPUT_WINTER_MESSAGE = "『冬』です。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputMonthNumberStream = new Scanner(System.in);

		int month;		//季節を求めるための月の変数

		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//月の入力を促す文を表示するための出力
		System.out.print(INPUT_MONTH_MESSAGE);
		//季節を求めるために入力された値を変数に代入する
		month = inputMonthNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputMonthNumberStream.close();

		//入力された値の季節を求めるためのメソッドの呼び出し式
		printSeason(month);
	}

	//季節を求め出力するためのメソッド
	static void printSeason(int month){
		//季節の判定のための条件式
		if(month >= 3 && month <= 5){
			//『春』と表示するための出力文
			System.out.println(OUTPUT_SPRING_MESSAGE);
		//monthの値が6以上8以下のための条件分岐
		}else if(month >= 6 && month <= 8){
			//『夏』と表示するための出力文
			System.out.println(OUTPUT_SUMMER_MESSAGE);
		//monthの値が9以上11以下のための条件分岐
		}else if(month >= 9 && month <= 11){
			//『秋』と表示するための出力文
			System.out.println(OUTPUT_AUTUMN_MESSAGE);
		//monthの値が12、1、2のための条件分岐
		}else if(month == 12 || month == 1 || month == 2){
			//『冬』と表示するための出力文
			System.out.println(OUTPUT_WINTER_MESSAGE);
		//monthの値が上記条件以外のための条件分岐
		}else{
			//何も表示しないために改行を出力する
			System.out.println();
		}

	}

}
