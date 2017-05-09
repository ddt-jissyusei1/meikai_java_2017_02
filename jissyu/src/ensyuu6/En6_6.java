package ensyuu6;
import java.util.Scanner;

/*
 * テストの点数の合計点・平均点・最高点・最低点を表示するプログラムを作成せよ。
 * 人数と点数は、キーボードから読み込むこと。
 */
public class En6_6 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "テストの点数の合計・平均・最高と最低の点数を表示します。";
	//人数の入力を促す文のための定数
	private static final String INPUT_PEOPLE_NUMBER_MESSAGE = "何人の点数ですか？:";
	//点数の入力を促す文のための定数
	private static final String INPUT_TEST_SCORE_MESSAGE = "点数を入力してください。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//入力する点数の、人数の出力を促す文を出力する
		System.out.print(INPUT_PEOPLE_NUMBER_MESSAGE);
		//入力された値を、変数peopleNumbersTestに代入する
		int peopleNumbersTest = inputStream.nextInt();

		int[] testScores = new int[peopleNumbersTest];	//点数を代入するための配列を宣言し、要素数にpeopleNumbersTestの値を代入する
		int sumTestScore = 0;								//点数の合計点を代入するための変数を用意し、0で初期化する
		int averageTestScore = 0;							//点数の平均点を代入するための変数を用意し、0で初期化する

		//点数の入力を促すを文を出力する
		System.out.println(INPUT_TEST_SCORE_MESSAGE);
		//配列に値を代入するために、for文の繰り返し処理にする
		for(int scoreLoop = 0; scoreLoop < testScores.length; scoreLoop++){
			//scoreLoop+1番目の入力を促す文を出力する
			System.out.print((scoreLoop+1) + "番目の点数を入力してください：");
			//入力された値をtestScore配列に読み込む
			testScores[scoreLoop] = inputStream.nextInt();
			//合計点を求めるために、sumTestScoreに入力された値を加算して代入する
			sumTestScore += testScores[scoreLoop];
		}
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//人数と合計点が判明しているので、平均点を計算してavarageTestScoreに代入する
		averageTestScore = (sumTestScore/peopleNumbersTest);

		int arrayLength = testScores.length;				//配列の長さを繰り返し処理で使用するため、別変数に代入する
		int maxTestScore = testScores[0];					//最高点を代入するための変数を用意し、testScores[0]の要素で初期化する
		int minTestScore = testScores[0];					//最低点を代入するための変数を用意し、testScores[0]の要素で初期化する

		//配列要素の最大値を求めるための繰り返し処理
		for(int maxScoreLoop = 0; maxScoreLoop < arrayLength; maxScoreLoop++){
			//最大値を求めるために、配列の要素とmaxTestScoreの値を比較する
			if(testScores[maxScoreLoop] > maxTestScore){
				//testScores[maxScoreLoop]の値のほうが大きければ、maxTestScoreに代入する
				maxTestScore = testScores[maxScoreLoop];
			}
		}

		//配列要素の最小値を求めるための繰り返し処理
		for(int minScoreLoop = 0; minScoreLoop < arrayLength; minScoreLoop++){
			//最小値を求めるために、配列の要素とminTestScoreの値を比較する
			if(testScores[minScoreLoop] < minTestScore){
				//testScores[minScoreLoop]の値のほうが小さければ、minTestScoreに代入する
				minTestScore = testScores[minScoreLoop];
			}
		}

		//合計点・平均点・最高点・最低点の結果を出力する
		System.out.println("\n合計点は" + sumTestScore + "\n平均点は" + averageTestScore +
														"\n最高点は" + maxTestScore + "\n最低点は" + minTestScore + "です。");
	}

}
