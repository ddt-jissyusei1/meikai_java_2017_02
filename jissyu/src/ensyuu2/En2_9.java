package ensyuu2;
import java.util.Random;

/*以下に示すプログラムを作成せよ。
 * ・0.0以上1.0未満の実数値をランダムに生成して表示。
 * ・0.0以上10.0未満の実数値をランダムに生成して表示。
 * ・-1.0以上1.0未満の実数値をランダムに生成して表示。
 */
public class En2_9 {

	public static void main(String[] args) {
		Random dubll = new Random();		//乱数生成用の変数

		double x = dubll.nextDouble();			//0.0以上1.0未満の実数値の乱数を生成して変数xに代入
		double y = dubll.nextDouble()+10;			//0.0以上10.0未満の実数値の乱数を生成して変数yに代入
		double z = dubll.nextDouble()-10;			//-1.0以上1.0未満の実数値の乱数を生成して変数yに代入



		System.out.println("0.0以上1.0未満の乱数は"+ x + "です。");		//変数xの値を表示

	}

}
