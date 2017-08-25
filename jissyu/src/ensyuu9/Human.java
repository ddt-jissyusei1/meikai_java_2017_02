package ensyuu9;

public class Human {
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
