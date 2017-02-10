package ensyuu2;
import java.util.Random;

public class En2_7 {

	public static void main(String[] args) {
		/*以下に示すプログラムを作成せよ。
		 * ・1桁の正の整数値（すなわち1以上9以下の値）をランダムに生成して表示。
		 * ・1桁の負の整数値（すなわち‐9以上‐1以下の値）をランダム生成して表示。
		 * ・2桁の正の整数値（すなわち10以上99以下の値）をランダム生成して表示。
		 */

		Random rand = new Random();		//ランダム生成の宣言

		int sei = rand.nextInt(9)+1;			//正の整数のランダム値を生成して変数seiに代入
		int fu = rand.nextInt(9)-9;				//負の整数のランダム値を生成して変数fuに代入
		int futaketa = rand.nextInt(90)+10;	//二桁の整数のランダム値を生成して変数futaketaに代入

		System.out.println("正の整数のランダム値は"+ sei +"です。");		//変数seiの値を表示
		System.out.println("負の整数のランダム値は" + fu + "です。");		//変数fuの値を表示
		System.out.println("二桁の整数のランダム値は" + futaketa + "です。");		//変数futaketaの値を表示

	}

}
