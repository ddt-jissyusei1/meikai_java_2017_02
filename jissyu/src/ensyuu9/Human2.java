package ensyuu9;

/*
 * Humanクラスに誕生日のフィールドとtoStringメソッドを追加したクラス
 */
public class Human2 {
	private String name;									//名前のための変数
	private  double height;								//身長のための変数
	private  double weight;								//体重のための変数
	private  int age;										//年齢のための変数
	private  String bloodType;								//血液型のための変数
	private  int humanBirthdayYear;						//誕生年のための変数
	private  int humanBirthdayMonth;						//誕生月のための変数
	private  int humanBirthdayDay;							//誕生日のための変数
	private  Human2 birthday;								//誕生年月日のための変数

	//人間クラスのためのコンストラクタ
	Human2(String name, double humanHeight, double humanWeight, int humanAge, String bloodType) {
		this.name = name;									//名前のフィールドに仮引数nameの値を代入するための代入式
		this.height = humanHeight;							//身長のフィールドに仮引数heightの値を代入するための代入式
		this.weight = humanWeight;							//体重のフィールドに仮引数weightの値を代入するための代入式
		this.age = humanAge;								//年齢のフィールドに仮引数ageの値を代入するための代入式
		this.bloodType = bloodType;							//血液型のフィールドに仮引数bloodTypeの値を代入するための代入式
	}

	//人間クラスの誕生年のためのコンストラクタ
	Human2(int birthdayYear){
		this.humanBirthdayYear = birthdayYear;				//誕生年のフィールドに仮引数birthdayYearの値を代入するための代入式
	}

	//人間クラスの誕生月のためのコンストラクタ
	Human2(int birthdayYear, int birthdayMonth){
		this(birthdayYear);									//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.humanBirthdayMonth = birthdayMonth;			//誕生月フィールドに仮引数birthdayMonthの値を代入するための代入式
	}

	//人間クラスの誕生日のためのコンストラクタ
	Human2(int birthdayYear, int birthdayMonth, int birthdayDay){
		this(birthdayYear, birthdayMonth);					//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this.humanBirthdayDay = birthdayDay;				//誕生日フィールドに仮引数birthdayDayの値を代入するための代入式
	}

	//人間クラスの誕生年月日のためのコンストラクタ
	Human2(Human2 human){
		//同一処理を委ねるための同一クラス内のコンストラクタの呼び出し
		this(human.humanBirthdayYear, human.humanBirthdayMonth, human.humanBirthdayDay);
	}

	//名前取得のためのメソッド
	public String getName() {
		//呼び出し元に名前を返却するためのreturn文
		return name;
	}

	//身長取得のためのメソッド
	public double getHeight() {
		//呼び出し元に身長を返却するためのreturn文
		return height;
	}

	//体重を取得するためのメソッド
	public double getWeight() {
		//呼び出し元に体重を返却するためのreturn文
		return weight;
	}

	//年齢を取得するためのメソッド
	public int getAge() {
		//呼び出し元に年齢を返却するためのreturn文
		return age;
	}

	//血液型を取得するためのメソッド
	public String getBloodType() {
		//呼び出し元に血液型を返却するためのreturn文
		return bloodType;
	}

	//誕生年を取得するためのメソッド
	public int getHumanBirthdayYear() {
		//呼び出し元に誕生年を返却するためのreturn文
		return humanBirthdayYear;
	}

	//誕生月を取得するためのメソッド
	public int getHumanBirthdayMonth() {
		//呼び出し元に誕生月を返却するためのreturn文
		return humanBirthdayMonth;
	}

	//誕生日を取得するためのメソッド
	public  int getHumanBirthdayDay() {
		//呼び出し元に誕生日を返却するためのreturn文
		return humanBirthdayDay;
	}

	//誕生年月日取得のためのゲッタメソッド
	public Human2 getBirthday() {
		//呼び出し元に誕生年月日を返却するためのreturn文
		return birthday;
	}

	//誕生年の値を変更するためのセッタメソッド
	public void setHumanBirthdayYear(int humanBirthdayYear) {
		//受け取った値をフィールド変数へセットするための代入式
		this.humanBirthdayYear = humanBirthdayYear;
	}

	//誕生月の値を変更するためのセッタメソッド
	public void setHumanBirthdayMonth(int humanBirthdayMonth) {
		//受け取った値をフィールド変数へとセットするための代入式
		this.humanBirthdayMonth = humanBirthdayMonth;
	}

	//誕生日の値を変更するためのセッタメソッド
	public void setHumanBirthdayDay(int humanBirthdayDay) {
		//受け取った値をフィールド変数へとセットするための代入式
		this.humanBirthdayDay = humanBirthdayDay;
	}

	//人物のプロフィールを表示するためのメソッド
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

	//人物データを文字列表現にするためのメソッド
	public String toString(){
		//呼び出し元にデータを文字列表現として返却するためのreturn文
		return String.format("誕生日：%d年%d月%d日", getHumanBirthdayYear(), getHumanBirthdayMonth(), getHumanBirthdayDay());
	}

}
