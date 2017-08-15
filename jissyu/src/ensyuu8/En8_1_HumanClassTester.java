package ensyuu8;

/*
 * 名前・身長・体重などをメンバとしてもつ<<人間クラス>>を作成せよ（フィールドやメソッドのどは自分で自由に設計すること）。
 */
class Human {
	private String name;						//名前のための変数
	private double height;						//身長のための変数
	private double weight;						//体重のための変数
	private int age;							//年齢のための変数
	private String bloodType;					//血液型のための変数

	//人間クラスのためのコンストラクタ
	 Human(String name, double height, double weight, int age, String bloodType) {
		this.name = name;						//名前のフィールドに仮引数nameの値を代入するための代入式
		this.height = height;					//身長のフィールドに仮引数heightの値を代入するための代入式
		this.weight = weight;					//体重のフィールドに仮引数weightの値を代入するための代入式
		this.age = age;							//年齢のフィールドに仮引数ageの値を代入するための代入式
		this.bloodType = bloodType;				//血液型のフィールドに仮引数bloodTypeの値を代入するための代入式
	}

	 //人物のプロフィールを表示するためのメソッド
	 void showProfile(){
		 //名前を表示するための出力
		 System.out.println("名前：" + name);
		 //身長を表示するための出力
		 System.out.println("身長：" + height);
		 //体重を表示するための出力
		 System.out.println("体重：" + weight);
		 //年齢を表示するための出力
		 System.out.println("年齢：" + age);
		 //血液型を表示するための出力
		 System.out.println("血液型:" + bloodType);
	 }
}

//<<人間クラス>>の動作をテストするためのクラス
class En8_1_HumanClassTester {

	public static void main(String[] args) {
		//テストのためのインスタンスの生成式
		Human bouyou = new Human("柴田ボウヨウ", 167.3, 80.0, 54, "B");

		//人物のプロフィールを表示するためのメソッドの呼び出し式
		bouyou.showProfile();

	}
}


