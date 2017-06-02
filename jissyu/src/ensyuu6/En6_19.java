package ensyuu6;
import java.util.Scanner;

/*
 * クラス数・各クラスの人数・全員の点数を読み込んで、点数の合計点と平均点を求めるプログラムを作成せよ。
 * 合計点と平均点は、クラスごとのものと、全体のものとを表示すること。
 */
public class En6_19 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "各クラス数・各クラスの人数・全員の点数の合計点と平均点を求めます。";
	//クラス数の入力を促す文のための定数
	private static final String INPUT_CLASS_NUMBER_MESSAGE = "\nクラス数：";
	//各クラスの人数の入力を促す文のための定数
	private static final String INPUT_STUDENTS_NUMBER_MESSAGE = "\n%d組の人数：";
	//点数の入力を促すため文のための定数
	private static final String INPUT_STUDENTS_SCORE_MESSAGE = "%d組%d番の点数：";
	//結果の出力の文頭のための定数
	private static final String OUTPUT_RESULT_HEADER = "  組 |   合計   平均 \n-----+---------------";
	//結果の出力を整えるための定数
	private static final String OUTPUT_RESULT = " \n %d組 |    %3d   %3.1f ";
	//結果の出力の文末のための定数
	private static final String OUTPUT_RESULT_FOOTER = "\n-----+---------------\n  計 |    %3d   %3.1f ";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//プログラムの説明をするための文の出力
		System.out.println(PROGRAM_MESSAGE);

		int classNumber = 0;			//入力されるクラス数のための変数
		int studentNumber = 0;		//入力されるクラスの人数のための変数
		int studentsScore = 0;		//入力される点数のための変数
		int classScoreSum = 0;		//クラス全員の点数の合計点のための変数
		int classNumberLoop = 0;		//クラス数の繰り返し制御のための変数
		int studentsScoreLoop = 0;	//生徒数の繰り返し制御のための変数
		int classScoreSumLoop = 0;	//クラスの合計点計算の繰り返し制御のための変数
		float classScoreAverage = 0;	//クラス全員の点数の平均点のための変数

		int[][]  classScoreArray;		//クラスの点数を計算するための配列の宣言

		//点数を計算するクラス数の入力を促すための文の出力
		System.out.print(INPUT_CLASS_NUMBER_MESSAGE);
		//入力された値を生成する配列の行数のための変数に代入する
		classNumber = inputNumberStream.nextInt();
		//入力された値を配列の行数に指定する
		classScoreArray = new int[classNumber][];

		//ここから各クラスの人数と、各人数の点数を入力してもらうための繰り返し処理

		//各クラスの人数の入力の繰り返し処理
		for(classNumberLoop = 0; classNumberLoop < classScoreArray.length; classNumberLoop++){
			//クラスの人数の入力を促す文の出力
			System.out.printf(INPUT_STUDENTS_NUMBER_MESSAGE,classNumberLoop+1);
			//入力された値を配列の列数のための変数に代入する
			studentNumber = inputNumberStream.nextInt();
			//配列の列数を決めるための宣言
			classScoreArray[classNumberLoop] = new int[studentNumber];
			//入力された人数分の点数を入力する繰り返し処理
			for(studentsScoreLoop = 0; studentsScoreLoop < studentNumber; studentsScoreLoop++){
				//学生の点数を入力を促すための文の出力
				//繰り返し制御変数は0スタートで、0組・0番と表示されないよう1加算する
				System.out.printf(INPUT_STUDENTS_SCORE_MESSAGE,classNumberLoop+1,studentsScoreLoop+1);
				//入力された点数を計算するための変数に代入する
				studentsScore = inputNumberStream.nextInt();
				//クラスの合計点数を計算するための配列に値を代入する
				classScoreArray[classNumberLoop][studentsScoreLoop] = studentsScore;
			}
		}
		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//ここから各クラスの合計点と平均点を計算し出力するためのコード

		//結果出力のヘッダーを出力する
		System.out.print(OUTPUT_RESULT_HEADER);

		int allClassSum = 0;          //全クラスの合計点のための変数
		float averageSum = 0;			//各クラスの平均点の合計のための点数
		float allClassAverage = 0;   //全クラスの平均点のための変数

		//各クラスの合計と平均を計算し出力する繰り返し処理
		for(classNumberLoop = 0; classNumberLoop < classNumber; classNumberLoop++){
			//繰り返し毎に、合計点を計算し続けないために初期化する
			classScoreSum = 0;
			//クラスの合計点を計算するためのループ
			for(classScoreSumLoop = 0; classScoreSumLoop < classScoreArray[classNumberLoop].length; classScoreSumLoop++){
				//合計点数のための変数に、各クラスの学生の点数を加算・代入する
				classScoreSum += classScoreArray[classNumberLoop][classScoreSumLoop];
			}
			//クラスの平均点を計算し、平均点のための変数に代入する
			classScoreAverage = (float)classScoreSum/classScoreSumLoop;
			//クラスの合計点と平均点の結果を表示するための出力
			System.out.printf(OUTPUT_RESULT, classNumberLoop+1, classScoreSum, classScoreAverage);

			//全クラスの合計点を計算するために、各クラスの合計点を変数に加算代入する
			allClassSum += classScoreSum;
			//全クラスの平均点を計算するために、各クラスの平均点を変数に加算代入する
			averageSum += classScoreAverage;
			//全クラスの平均点を計算し、変数に代入する
			allClassAverage = (float)averageSum/classNumber;
		}
		//結果表示の文末のための出力
		System.out.printf(OUTPUT_RESULT_FOOTER, allClassSum, allClassAverage);

	}





}
