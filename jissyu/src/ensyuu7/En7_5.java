package ensyuu7;

/*
 * 『こんにちは。』と表示するメソッドhelloを作成せよ。
 */
public class En7_5 {
	//『こんにちは。』と表示する文ための定数
	private static final String HELLO_MESSAGE = "『こんにちは。』";

	public static void main(String[] args) {
		//メソッドhelloを呼び出すための呼び出し式
		 hello();

	}

	//『こんにちは。』と表示するためのメソッド
	static void hello(){
		//『こんにちは』と表示するための出力
		System.out.println(HELLO_MESSAGE);
	}

}
