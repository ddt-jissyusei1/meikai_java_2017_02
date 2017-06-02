package ensyuu6;
import java.util.Scanner;

/*
 * 6人の2科目（国語・算数）の点数を読み込んで、科目ごとの平均点、学生ごとの平均点を求めるプログラムを作成せよ。
 */
public class En6_17 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "6人の2科目の、科目ごとの平均点と学生ごとの平均点を求めます。";
	//国語の点数の入力を促す文のための定数
	private static final String INPUT_JAPANESE_SCORE_MESSAGE = "\n国語の点数を入力してください。";
	//数学の点数の入力を促す文のための定数
	private static final String INPUT_MATH_SCORE_MESSAGE = "\n数学の点数を入力してください。";
	//国語の平均点の文のための定数
	private static final String JAPANESE_AVERAGE_MESSAGE = "国語の平均点は%2.1fです。";
	//数学の平均点の文のための定数
	private static final String MATH_AVERAGE_MESSAGE = "\n数学の平均点は%2.1fです。";
	//学生ごとの平均点の文のための定数
	private static final String STUDENTS_AVERAGE_MESSAGE = "\n\n学生ごとの平均点は";
	//配列の行数（科目数）のための定数
	private static final int SUBJECTS_NUMBER = 2;
	//配列の列数（生徒数）のための定数
	private static final int STUDENTS_NUMBER = 6;


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputScoreStream = new Scanner(System.in);
		//出力する生徒名のための配列の宣言
		String[] studentsName = {"佐藤","鈴木","斎藤","山田","田中","渡辺"};

		//プログラムの説明文を出力するためのコード
		System.out.println(PROGRAM_MESSAGE);

		//6人2科目の点数の値を入れるための配列の宣言
		int[][] arrayScores = new int[SUBJECTS_NUMBER][STUDENTS_NUMBER];
		//配列に値を代入する行の繰り返し制御のための変数
		int arrayRowLoop;
		//配列に値を代入する列の繰り返し制御のための変数
		int arrayLineLoop;

		//2科目の点数を配列に代入するための繰り返し処理
		for(arrayRowLoop = 0; arrayRowLoop < 2; arrayRowLoop++){
			//どの科目の入力か知らせる出力のための条件式
			if(arrayRowLoop == 0){
				//国語の点数の入力を促すための文を出力する
				System.out.println(INPUT_JAPANESE_SCORE_MESSAGE);
			}else{
				//数学の点数の入力を促すための文を出力する
				System.out.println(INPUT_MATH_SCORE_MESSAGE);
			}
			//学生ごとの点数を配列に代入するための繰り返し処理
			for(arrayLineLoop = 0; arrayLineLoop < 6; arrayLineLoop++){
				//どの学生の点数入力か知らせるために学生名を出力する
				System.out.print(studentsName[arrayLineLoop] + ":");
				//入力された値を配列の要素に代入するためのコード
				arrayScores[arrayRowLoop][arrayLineLoop] = inputScoreStream.nextInt();
			}
		}
		//値の入力が終わったので、開いていたリソースを開放する
		inputScoreStream.close();

		float subjectsAverage;				//科目ごとの平均点を代入するための変数
		float studentsAverage;				//学生事の平均点を代入するための変数

		//科目ごとの平均点を計算し出力するための繰り返し処理
		for(arrayRowLoop = 0; arrayRowLoop < SUBJECTS_NUMBER; arrayRowLoop++){
			//科目ごとの平均点を代入するために0で初期化する
			subjectsAverage = 0;
			//一科目の平均点を計算するための繰り返し処理
			for(arrayLineLoop = 0; arrayLineLoop < STUDENTS_NUMBER; arrayLineLoop++){
				subjectsAverage += arrayScores[arrayRowLoop][arrayLineLoop];
			}
			//2科目のそれぞれの平均点を出力するための条件式
			if(arrayRowLoop == 0){
				//国語の平均点を出力する
				System.out.printf(JAPANESE_AVERAGE_MESSAGE,subjectsAverage/STUDENTS_NUMBER);
			}else{
				//数学の平均点を出力する
				System.out.printf(MATH_AVERAGE_MESSAGE,subjectsAverage/STUDENTS_NUMBER);
			}
		}

		//学生ごとの平均点であることを知らせるための文の出力
		System.out.println(STUDENTS_AVERAGE_MESSAGE);

		//学生ごとの平均点を計算し出力するための繰り返し処理
		for(arrayLineLoop = 0; arrayLineLoop < STUDENTS_NUMBER; arrayLineLoop++){
			//平均点が加算され続けないために繰り返し毎に平均点を代入する変数を0で初期化する
			studentsAverage = 0;
			//学生ごとの平均点を計算し、出力するために計算結果の値を変数に代入する
			studentsAverage += (arrayScores[0][arrayLineLoop]+arrayScores[1][arrayLineLoop])/SUBJECTS_NUMBER;
			//学生の名前と平均点を表示するための出力
			System.out.println(studentsName[arrayLineLoop] + ":" + studentsAverage + "点");

		}

	}

}
