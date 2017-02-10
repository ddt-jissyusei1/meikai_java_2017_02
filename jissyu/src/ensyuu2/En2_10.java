package ensyuu2;
import java.util.Scanner;

//名前の姓と名とを個別にキーボードから読み込んで、挨拶を行うプログラムを作成せよ。

public class En2_10 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);		//キーボードからの読み込みを行うプログラム

		String firstName = "ABC";		//変数firstName初期化
		String lastName = "DEF";		//変数lastName初期化

		System.out.print("姓：");		//姓の入力を求める
		firstName = std.next();			//入力された文字列を変数firstNameに代入
		System.out.print("名：");		//名の入力を求める
		lastName = std.next();			//入力された文字列を変数lastNameに代入

		System.out.println("こんにちは"+ firstName + lastName + "さん。");		//変数firstNameとlastNameを表示

	}

}
