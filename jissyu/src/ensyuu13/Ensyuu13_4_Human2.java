package ensyuu13;

import ensyuu9.En9_4;

/**
 * 演習9-4(p.329)で作成した『人間クラス』に対して、javadocコメントを与えるとともに、
 * javadocツールによってドキュメントを作成せよ。
 *
 * @author y.Shida
 * @see    En9_4
 *
 */
public class Ensyuu13_4_Human2 {
    /**
     * 人間の名前のためのString型のフィールドです。
     */
	private String name;
	/**
	 * 人間の身長のためのdouble型のフィールドです。
	 */
	private  double height;
	/**
	 * 人間の体重のためのdouble型のフィールドです。
	 */
	private  double weight;
	/**
	 * 人間の年齢のためのint型のフィールドです。
	 */
	private  int age;
	/**
	 * 人間の血液型のためのString型のフィールドです。
	 */
	private  String bloodType;
	/**
	 * 人間の誕生年のためのint型のフィールドです。
	 */
	private  int humanBirthdayYear;
	/**
	 * 人間の誕生月のためのint型のフィールドです。
	 */
	private  int humanBirthdayMonth;
	/**
	 * 人間の誕生日のためのint型のフィールドです。
	 */
	private  int humanBirthdayDay;
	/**
	 * 人間の誕生年月日のためのEnsyuu13_4_Human2型のフィールドです。
	 */
	private  Ensyuu13_4_Human2 birthday;

	/**
	 * 人間を生成するためのコンストラクタ
	 * @param name 人間の名前のための引数
	 * @param humanHeight 人間の身長のための引数
	 * @param humanWeight 人間の体重のための引数
	 * @param humanAge 人間の年齢のための引数
	 * @param bloodType 人間の血液型のための引数
	 */
	Ensyuu13_4_Human2(String name, double humanHeight, double humanWeight, int humanAge, String bloodType) {
		this.name = name;									//名前のフィールドに仮引数nameの値を代入するための代入式
		this.height = humanHeight;							//身長のフィールドに仮引数heightの値を代入するための代入式
		this.weight = humanWeight;							//体重のフィールドに仮引数weightの値を代入するための代入式
		this.age = humanAge;								//年齢のフィールドに仮引数ageの値を代入するための代入式
		this.bloodType = bloodType;							//血液型のフィールドに仮引数bloodTypeの値を代入するための代入式
	}

	/**
	 * 人間クラスの誕生年のためのコンストラクタ
	 * @param birthdayYear 人間の誕生年のための引数
	 */
	Ensyuu13_4_Human2(int birthdayYear){
		this.humanBirthdayYear = birthdayYear;				//誕生年のフィールドに仮引数birthdayYearの値を代入するための代入式
	}

	/**
	 * 人間クラスの誕生月のためのコンストラクタ
	 * @param birthdayYear 人間の誕生年のための引数
	 * @param birthdayMonth 人間の誕生月のための引数
	 */
	Ensyuu13_4_Human2(int birthdayYear, int birthdayMonth){
		this(birthdayYear);									//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.humanBirthdayMonth = birthdayMonth;			//誕生月フィールドに仮引数birthdayMonthの値を代入するための代入式
	}

	/**
	 * 人間クラスの誕生日のためのコンストラクタ
	 * @param birthdayYear 人間の誕生年のための引数
	 * @param birthdayMonth 人間の誕生月のための引数
	 * @param birthdayDay 人間の誕生日のための引数
	 */
	Ensyuu13_4_Human2(int birthdayYear, int birthdayMonth, int birthdayDay){
		this(birthdayYear, birthdayMonth);					//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.humanBirthdayDay = birthdayDay;				//誕生日フィールドに仮引数birthdayDayの値を代入するための代入式
	}

	/**
	 * 人間クラスの誕生年月日のためのコンストラクタ
	 * @param human 人間のための引数
	 */
	Ensyuu13_4_Human2(Ensyuu13_4_Human2 human){
		//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this(human.humanBirthdayYear, human.humanBirthdayMonth, human.humanBirthdayDay);
	}

	/**
	 * 名前取得のためのメソッド
	 * @return 取得した人間の名前を呼び出し元に返却する
	 */
	public String getName() {
		//呼び出し元に名前を返却するためのreturn文
		return name;
	}

	/**
	 * 身長取得のためのメソッド
	 * @return 取得した人間の身長の値を呼び出し元に返却する
	 */
	public double getHeight() {
		//呼び出し元に身長を返却するためのreturn文
		return height;
	}

	/**
	 * 体重を取得するためのメソッド
	 * @return 取得した人間の体重の値を呼び出し元に返却する
	 */
	public double getWeight() {
		//呼び出し元に体重を返却するためのreturn文
		return weight;
	}

	/**
	 * 年齢を取得するためのメソッド
	 * @return 取得した人間の年齢を呼び出し元に返却する
	 */
	public int getAge() {
		//呼び出し元に年齢を返却するためのreturn文
		return age;
	}

	/**
	 * 血液型を取得するためのメソッド
	 * @return 取得した人間の血液型の値を呼び出し元に返却する
	 */
	public String getBloodType() {
		//呼び出し元に血液型を返却するためのreturn文
		return bloodType;
	}

	/**
	 * 誕生年を取得するためのメソッド
	 * @return 取得した人間の誕生年の値を呼び出し元に返却する
	 */
	public int getHumanBirthdayYear() {
		//呼び出し元に誕生年を返却するためのreturn文
		return humanBirthdayYear;
	}

	/**
	 * 誕生月を取得するためのメソッド
	 * @return 取得した人間の誕生月の値を呼び出し元に返却する
	 */
	public int getHumanBirthdayMonth() {
		//呼び出し元に誕生月を返却するためのreturn文
		return humanBirthdayMonth;
	}

	/**
	 * 誕生日を取得するためのメソッド
	 * @return 取得した人間の誕生日の値を呼び出し元に返却する
	 */
	public  int getHumanBirthdayDay() {
		//呼び出し元に誕生日を返却するためのreturn文
		return humanBirthdayDay;
	}

	/**
	 * 誕生年月日取得のためのゲッタメソッド
	 * @return 取得した人間の誕生年月日の値を呼び出し元に返却する
	 */
	public Ensyuu13_4_Human2 getBirthday() {
		//呼び出し元に誕生年月日を返却するためのreturn文
		return birthday;
	}

	/**
	 * 誕生年の値を変更するためのセッタメソッド
	 * @param humanBirthdayYear 人間の誕生年をセットするための引数
	 */
	public void setHumanBirthdayYear(int humanBirthdayYear) {
		//受け取った値をフィールド変数へセットするための代入式
		this.humanBirthdayYear = humanBirthdayYear;
	}

	/**
	 * 誕生月の値を変更するためのセッタメソッド
	 * @param humanBirthdayMonth 人間の誕生月をセットするための引数
	 */
	public void setHumanBirthdayMonth(int humanBirthdayMonth) {
		//受け取った値をフィールド変数へとセットするための代入式
		this.humanBirthdayMonth = humanBirthdayMonth;
	}

	/**
	 * 誕生日の値を変更するためのセッタメソッド
	 * @param humanBirthdayDay 人間の誕生日をセットするための引数
	 */
	public void setHumanBirthdayDay(int humanBirthdayDay) {
		//受け取った値をフィールド変数へとセットするための代入式
		this.humanBirthdayDay = humanBirthdayDay;
	}

	/**
	 * 入力された人物のプロフィールデータを表示するためのメソッド
	 * 各項目に応じた値を表示する。
	 */
	public void showProfile(){
		System.out.println("\n入力された人物データは：");
		//名前を表示するための出力
		System.out.printf("名前：%s\n", name);
		//身長を表示するための出力
		System.out.printf("身長：%scm\n", height);
		//体重を表示するための出力
		System.out.printf("体重：%skg\n", weight);
		//年齢を表示するための出力
		System.out.printf("年齢：%s歳\n", age);
		//血液型を表示するための出力
		System.out.printf("血液型:%s型\n", bloodType);
	}

	/**
	 * 人物データを文字列表現にするためのメソッド
	 * @return 入力された人物データの誕生年月日をyyyyMMdd形式の文字列にフォーマットして呼び出し元に返却する。
	 */
	public String toString(){
		//呼び出し元にデータを文字列表現として返却するためのreturn文
		return String.format("誕生日：%d年%d月%d日", getHumanBirthdayYear(), getHumanBirthdayMonth(), getHumanBirthdayDay());
	}

}
