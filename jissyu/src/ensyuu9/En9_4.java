package ensyuu9;
import java.util.Scanner;

/*
 * 演習8－1（p.293）で作成した《人間クラス》に、誕生日フィールドとtoStringメソッドを追加せよ。
 * ※コンストラクタを変更したり、誕生日のゲッタなどのメソッドを追加したりすること。
 */
public class En9_4 {
	//データの入力を促す文のための定数
	private static final String INPUT_HUMAN_DATA_MESSAGE = "人物データを入力してください。";
	//名前項目のための定数
	private static final String HUMAN_NAME_COLUMN_STRING = "名前：";
	//身長項目のための定数
	private static final String HUMAN_HEIGHT_COLUMN_STRING = "身長：";
	//体重項目のための定数
	private static final String HUMAN_WEIGHT_COLUMN_STRING = "体重：";
	//年齢項目のための定数
	private static final String HUMAN_AGE_COLUMN_STRING = "年齢：";
	//血液型項目のための定数
	private static final String HUMAN_BLOODTYPE_COLUMN_STRING = "血液型：";
	//誕生日の入力を促す文のための定数
	private static final String INPUT_HUMAN_BIRTHDAY_MESSAGE = "誕生日を西暦で入力してください。";
	//誕生日の年の項目のための定数
	private static final String YEAR_COLUMN_STRING = "年：";
	//誕生日の月の項目のための定数
	private static final String MONTH_COLUMN_STRING = "月：";
	//誕生日の日の項目のための定数
	private static final String DAY_COLUMN_STRING = "日：";

	//キーボードからの入力ストリームを読み込むためのプログラム
	static Scanner inputDataStream = new Scanner(System.in);

	public static void main(String[] args) {
		//人物データ入力のためのメソッドの呼び出し
		Human2 humanData = inputHumanData();

		//誕生年月日入力のためのメソッドの呼び出し
		Human2 humanBirthday = inputBirthdayData();

		//値の入力が終了したので、開いていたリソースを開放する
		inputDataStream.close();

		//生成した人物データを確認するための表示メソッドの呼び出し
		humanData.showProfile();

		//誕生日を表示するためのメソッドの呼び出し
		System.out.println(humanBirthday.toString());

	}

	//人間データのインスタンスを生成するためのメソッドメソッド
	private static Human2 inputHumanData(){
		String humanName;									//名前のための変数
		double humanHeight = 0.0;							//身長のための変数
		double humanWeight = 0.0;							//体重のための変数
		int humanAge = 0;									//年齢のための変数
		String humanBloodType;								//血液型のための変数

		//人物のデータの入力を促す文を表示するための出力
		System.out.println(INPUT_HUMAN_DATA_MESSAGE);

		//名前入力のための項目を表示する出力
		System.out.print(HUMAN_NAME_COLUMN_STRING);
		//インスタンスを生成するための変数に入力された値を代入する
		humanName = inputDataStream.next();

		//身長の入力のための項目を表示する出力
		System.out.print(HUMAN_HEIGHT_COLUMN_STRING);
		//インスタンスを生成するための変数に入力された値を代入する
		humanHeight = inputDataStream.nextDouble();

		//体重の入力のための項目を表示する出力
		System.out.print(HUMAN_WEIGHT_COLUMN_STRING);
		//インスタンスを生成するための変数に入力された値を代入する
		humanWeight = inputDataStream.nextDouble();

		//年齢の入力のための項目を表示する出力
		System.out.print(HUMAN_AGE_COLUMN_STRING);
		//インスタンスを生成するための変数に入力された値を代入する
		humanAge = inputDataStream.nextInt();

		//血液型の入力のための項目を表示する出力
		System.out.print(HUMAN_BLOODTYPE_COLUMN_STRING);
		//インスタンスを生成するための変数に入力された
		humanBloodType = inputDataStream.next();

		//入力された値で人間インスタンスを生成する
		Human2 humanData = new Human2(humanName, humanHeight, humanWeight, humanAge, humanBloodType);

		//呼び出し元に生成した人間インスタンスへの参照を返却する
		return humanData;
	}

	//誕生年月日の入力のためのメソッド
	private static Human2 inputBirthdayData(){
		int birthdayYear = 0;								//誕生年のための変数
		int birthdayMonth = 0;							//誕生月のための変数
		int birthdayDay = 0;								//誕生日のための変数

		//誕生年月日の入力を促す文を表示する出力
		System.out.println(INPUT_HUMAN_BIRTHDAY_MESSAGE);

		//誕生年の入力を促す項目を表示する出力
		System.out.print(YEAR_COLUMN_STRING);
		//誕生日インスタンスを生成するための変数に入力された値を代入する
		birthdayYear = inputDataStream.nextInt();

		//誕生月の入力を促す項目を表示する出力
		System.out.print(MONTH_COLUMN_STRING);
		//誕生日のインスタンスを生成するための変数に入力された値を代入する
		birthdayMonth = inputDataStream.nextInt();

		//誕生日の入力を促す項目を表示する出力
		System.out.print(DAY_COLUMN_STRING);
		//誕生月のインスタンスを生成するための変数に入力された値を代入する
		birthdayDay = inputDataStream.nextInt();

		//入力された値の誕生年インスタンスを生成する
		Human2 humanBirthday = new Human2(birthdayYear, birthdayMonth, birthdayDay);

		//呼び出し元に生成した誕生日インスタンスへの参照を返却する
		return humanBirthday;
	}



}
