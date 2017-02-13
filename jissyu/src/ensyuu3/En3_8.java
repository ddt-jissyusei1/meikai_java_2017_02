package ensyuu3;
import java.util.Scanner;

/*キーボードから読み込んだ点数に応じて、優／良／可／不可を判定して表示するプログラムを作成せよ。
 * 判定は以下のように行うこと。
 * 0～59→不可／60～69→可／70～79→良／80～100→優
 */

public class En3_8 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);							//キーボードからの読み込みを行うプログラム

		System.out.print("点数を入力：");								//点数の入力を促す
		int score = std.nextInt();										//入力された値を変数scoreに代入

		if(score <= 100 && score >= 80){									//条件式：scoreの値が80以上100以下
			System.out.println("優");									//『優』と出力

		}else if(score <= 79 && score >= 70){							//条件式：scoreの値が70以上79以下
			 System.out.println("良");									//『良』と出力

		}else if(score <= 69 && score >= 60){							//条件式：scoreの値が60以上69以下
			System.out.println("可");									//『可』と出力

		}else if(score <= 59 && score >= 0){							//条件式：scoreの値が0以上59以下
			System.out.println("不可");									//『不可』と出力

		}

	}

}
