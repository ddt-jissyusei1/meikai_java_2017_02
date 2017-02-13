package ensyuu3;
import java.util.Scanner;

/*二つの正の整数値を読み込んで、後者が前者の約数であれば『BはAの約数です。』と表示し、
 * そうでなければ『BはAの約数ではありません。』と表示するプログラムを作成せよ。
 */
public class En3_2 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);				//キーボードからの読み込みを行うプログラム

		System.out.print("整数A：");			//整数Aの入力を促す
		int x = std.nextInt();					//入力された値Aを変数xに代入

		System.out.print("整数B：");			//整数Bの入力を促す
		int y = std.nextInt();					//入力された値Bを変数yに代入

		if(x%y == 0){										//条件文：もしxをyで割ったあまりがゼロならば
			System.out.println("BはAの約数です。");			//ゼロの場合出力する文
		}else {														//そうでない場合
			System.out.println("BはAの約数ではありません。");		//出力する文
		}


	}

}
