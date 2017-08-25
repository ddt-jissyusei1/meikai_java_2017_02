package ensyuu9;
import java.util.Scanner;

/*
 * 演習8-1(p293)で作成した<<人間クラス>>の配列を生成するプログラムを作成せよ。生成時に要素を初期化するもの、
 * 生成後の要素に値を代入するものなど、複数のパターンを作ること。
 */
public class En9_1 {
	//配列生成の一つ目のパターンを説明する文のための定数
	private static final String FIRST_MAKE_ARRAY_PATTERN_MESSAGE = "配列の生成時に要素を初期化したプログラムです。";
	//配列生成の二つ目のパターンを説明する文のための定数
	private static final String SECOND_MAKE_ARRAY_PATTERN_MESSAGE = "配列の生成後に要素に値を代入したプログラムです。";
	//配列生成の三つ目のパターンを説明する文のための定数
	private static final String THIRD_MAKE_ARRAY_PATTERN_MESSAGE = "生成する人数分繰り返し処理で要素に値を代入したプログラムです。";
	//人間データの入力を促す文のための定数
	private static final String INPUT_HUMAN_DATA_MESSAGE = "人間データを入力してください。";
	//配列の生成時に要素を初期化するメソッドのインデックスのための定数
	private static final String ARRAY_INDEX_STRING = "humanArray[%d] = %s、%4.1fcm、%4.2fkg、%d歳、%s型\n";
	//配列の生成後に要素に値を代入するメソッドのための配列のインデックスの定数
	private static final String ARRAY_AFTER_INDEX_STRING = "humanArrayAfter[%d] = %s、%4.1fcm、%4.2fkg、%d歳、%s型\n";
	//入力するデータ数分、繰り返し処理で配列を生成するメソッドのインデックスのための定数
	private static final String ARRAY_LOOP_INDEX_STRING = "humanArrayLoop[%d] = %s、%4.1fcm、%4.2fkg、%d歳、%s型\n";

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputDataStream = new Scanner(System.in);

	public static void main(String[] args) {
		//人間クラスの配列生成時に要素を初期化するための配列の宣言
		Human[] humanArray = {
				//一人目のインスタンスの生成
				new Human("Steve", 200, 80, 30, "A"),
				//二人目のインスタンスの生成
				new Human("Alex", 195, 67, 26, "B"),
				//三人目のインスタンスの生成
				new Human("坂東太郎", 322, 16.84, 90, "O"),
		};

		//生成したインスタンスを表示するためのメソッドの呼び出し
		showProfile(FIRST_MAKE_ARRAY_PATTERN_MESSAGE,humanArray, ARRAY_INDEX_STRING);

		//結果の表示を分けるための空白行の出力
		System.out.println();


		//生成後に要素に値を代入するための配列の宣言
		Human[] humanArrayAfter;

		//配列の要素に値を代入する
		humanArrayAfter = new Human[]{
				new Human("東京太郎", 156.4, 52.8, 47, "AB"),
				new Human("南国花子", 163.1, 48.8, 20, "A"),
		};

		//生成したインスタンスを表示するためのメソッドの呼び出し
		showProfile(SECOND_MAKE_ARRAY_PATTERN_MESSAGE,humanArrayAfter, ARRAY_AFTER_INDEX_STRING);

		//結果の表示を分けるための空白行の出力
		System.out.println();

		String humanName;					//入力する名前のための変数
		double humanHeight = 0.0;			//入力する身長のための変数
		double humanWeight = 0.0;			//入力する体重のための変数
		int humanAge = 0;					//入力する年齢のための変数
		String humanBloodType;				//入力する血液型のたの変数

		//データの入力を促すための文の表示
		System.out.println(INPUT_HUMAN_DATA_MESSAGE);

		//作成するインスタンスのための人数の入力
		System.out.print("入力する人数：");
		//配列の要素数で使用するために、変数に代入する
		int numberOfHuman = inputDataStream.nextInt();

		//要素の値を入力するための配列の宣言
		Human[] humanArrayLoop = new Human[numberOfHuman];

		//配列の要素に値を代入するための繰り返し処理
		for(int inputHumanDataLoop = 0; inputHumanDataLoop < numberOfHuman; inputHumanDataLoop++){
			//名前の入力を促す文の表示
			System.out.print("名前：");
			//入力された値を保持するための変数への代入
			humanName = inputDataStream.next();
			//身長の入力を促す文の表示
			System.out.print("身長：");
			//入力された値を保持するための変数への代入
			humanHeight = inputDataStream.nextDouble();
			//体重の入力を促す文の表示
			System.out.print("体重：");
			//入力された値を保持するための変数への代入
			humanWeight = inputDataStream.nextDouble();
			//年齢の入力を促す文の表示
			System.out.print("年齢：");
			//入力された値を保持するための変数への代入
			humanAge = inputDataStream.nextInt();
			//血液型の入力を促す文の表示
			System.out.print("血液型：");
			//入力された値を保持するための変数への代入
			humanBloodType = inputDataStream.next();

			//入力された値のインスタンスを生成
			humanArrayLoop[inputHumanDataLoop] =new Human(humanName, humanHeight, humanWeight, humanAge, humanBloodType);

			//次のループの入力を区切るための空白行の出力
			System.out.println();
		}

		//値の入力が終了したので、開いていたリソースを開放する
		inputDataStream.close();

		//生成したインスタンスを表示するためのメソッドの呼び出し
		showProfile(THIRD_MAKE_ARRAY_PATTERN_MESSAGE, humanArrayLoop, ARRAY_LOOP_INDEX_STRING);

	}

	//生成されたインスタンスを表示するためのメソッド
	static void showProfile(String programMessage, Human[] humanArray, String indexString){
		//配列の生成パターンの説明を表示するための出力
		System.out.println(programMessage);

		//要素を表示する繰り返し制御のために、配列の長さを取得する
		int humanArrayLength = humanArray.length;

		//生成したインスタンスを確認するための繰り返し処理
		for(int showHumanLoop = 0; showHumanLoop < humanArrayLength; showHumanLoop++){
			//配列の要素を表示するための出力
			System.out.printf(indexString, showHumanLoop,
					humanArray[showHumanLoop].getName(),
					humanArray[showHumanLoop].getHeight(),
					humanArray[showHumanLoop].getWeight(),
					humanArray[showHumanLoop].getAge(),
					humanArray[showHumanLoop].getBloodType());
		}
	}

}
