package ensyuu3;
import java.util.Scanner;

/*二つの変数a,bに値を読み込んで、その大小関係を以下のいずれかで表示するプログラムを作成せよ。
 * 『aのほうが大きいです。』『bのほうが大きいです。』『aとbは同じ値です。』
 */

public class En3_4 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);					//キーボードからの読み込みを行うプログラム

		System.out.print("整数a：");						//整数aの値の入力を促す
		int a = std.nextInt();								//入力された値を変数aに代入

		System.out.print("整数b：");						//整数bの値の入力を促す
		int b = std.nextInt();								//入力された値を変数bに代入

		if(a > b){											//aの値がbより大きい
			System.out.println("aのほうが大きいです。");	//その場合に出力する文

		}else if(b > a){									//bの値がaより大きい
			System.out.println("bのほうが大きいです。");	//その場合に出力する文

		}else if(a == b){									//aとbの値が同じ
			System.out.println("aとbは同じ値です。");		//その場合に出力する文
		}

	}

}
