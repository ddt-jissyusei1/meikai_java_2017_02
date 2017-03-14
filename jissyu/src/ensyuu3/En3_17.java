package ensyuu3;
import java.util.Random;

/*
 * 0,1,2のいずれかの値の乱数を生成し、0であれば"グー"を、1であれば"チョキ"を、2であれば"パー"を
 * 表示するプログラムを作成せよ
 */
public class En3_17 {

	public static void main(String[] args) {
		//乱数を生成するためのプログラム
		Random number = new Random();

		//0～2の乱数を生成し、変数handに代入
		int hand = number.nextInt(3);

		//handの値でプログラムを分岐させる
		switch(hand){
			//handの値が0だった場合、"グー"と出力する
			case 0 : System.out.println(hand+":グー");
			//分岐処理の実行を終了しプログラムの流れを抜ける
			break;
			//handの値が1だった場合、"チョキ"と出力する
			case 1 : System.out.println(hand+":チョキ");
			//分岐処理の実行を終了しプログラムの流れを抜ける
			break;
			//handの値が2だった場合、"パー"と出力する
			case 2 : System.out.println(hand+":パー");
			//分岐処理の実行を終了しプログラムの流れを抜ける

		}

	}

}
