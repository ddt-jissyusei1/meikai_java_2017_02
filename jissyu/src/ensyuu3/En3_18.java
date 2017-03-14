package ensyuu3;
import java.util.Scanner;

/*
 * 月を１～１２の整数値として読み込んで、それに対応する季節を表示するプログラムを作成せよ。
 */
public class En3_18 {

	public static void main(String[] args) {
		//キーボードからの入力を読み込むためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//任意の月の入力を促す文を出力する
		System.out.print("好きな月の整数を入力してください：");
		//入力された整数を変数monthに代入して、保持する
		int month = inputStream.nextInt();

		//変数monthの値を分岐のための制御式とし、それを評価して分岐の処理を実行する。
		switch(month){
			//monthの値が1,2,12のどれかの場合、対応季節は冬と出力する。
			case 1 :
			case 2 :
			case 12 :	System.out.println(month + "月の季節は冬です。");
						//分岐処理の流れをbreakで抜ける
						break;
			//monthの値が3,4,5のどれかの場合、対応季節は春と出力する。
			case 3 :
			case 4 :
			case 5 :	System.out.println(month + "月の季節は春です。");
						//分岐処理の流れをbreakで抜ける
						break;
			//monthの値が6,7,8のどれかの場合、対応季節は夏と出力する。
			case 6 :
			case 7 :
			case 8 :	System.out.println(month + "月の季節は夏です。");
						//分岐処理の流れをbreakで抜ける
						break;
			//monthの値が9,10,11のどれかの場合、対応季節は秋と出力する。
			case 9 :
			case 10 :
			case 11 :	System.out.println(month + "月の季節は秋です。");
						//分岐処理の流れをbreakで抜ける
						break;
			//1～12以外の数値が入力された場合、月ではありませんと出力する
			default : System.out.println(month + "は月ではありません");
						//分岐処理の流れをbreakで抜ける
						break;
		}
	}

}

