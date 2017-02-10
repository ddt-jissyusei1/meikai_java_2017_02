package ensyuu3;
import java.util.Scanner;

//整数値を読み込んで、その絶対値を求めて表示するプログラムを作成せよ。
public class En3_1 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);		//キーボードの標準入力ストリーム

		System.out.print("整数値：");		//整数値の入力を促す
		int x = std.nextInt();   			//入力された値を変数xに代入する

		if(x < 0){									//もしxの値が0未満であれば
			int y = -x;								//xの値の符号を反転して、変数yに代入
			System.out.println("その絶対値は" + y + "です。");				//yの値を表示
		}else{															//もしそれ以外であれば
			System.out.println("その絶対値は" + x + "です。");			//xをそのまま表示
		}


	}

}
