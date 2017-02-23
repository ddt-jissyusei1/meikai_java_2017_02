package ensyuu3;
import java.util.Scanner;

/*キーボードから読み込んだ点数に応じて、優／良／可／不可を判定して表示するプログラムを作成せよ。
 * 判定は以下のように行うこと。
 * 0～59→不可／60～69→可／70～79→良／80～100→優
 */

public class En3_8 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//成績判定用の点数の入力を促す文を出力する。
		System.out.print("点数を入力してください：");
		//入力された値を変数scoreに代入し、保持
		int score = std.nextInt();

		//条件式：scoreの値が80以上100以下である場合
		if(score <= 100 && score >= 80){
			//scoreの値が80以上100以下の条件に当てはまる場合、『優』とする判定文を出力する。
			System.out.println("優");

		//条件式：scoreの値が70以上79以下である場合
		}else if(score <= 79 && score >= 70){
			//scoreの値が70以上79以下の条件に当てはまる場合、『良』とする判定文を出力する。
			 System.out.println("良");

		//条件式：scoreの値が60以上69以下である場合
		}else if(score <= 69 && score >= 60){
			//scoreの値が60以上69以下の条件に当てはまる場合、『可』とする判定文を出力する。
			System.out.println("可");

		//条件式：scoreの値が0以上59以下である場合
		}else if(score <= 59 && score >= 0){
			//scoreの値が0以上59以下の条件に当てはまる場合、『不可』とする判定文を出力する。
			System.out.println("不可");

		}

	}

}
