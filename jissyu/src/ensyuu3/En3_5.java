package ensyuu3;
import java.util.Scanner;


/*正の整数値を読み込んで、それが5で割り切れれば『その値は5で割り切れます。』と表示し、
 * そうでなければ『その値は5で割り切れません。』と表示するプログラムを作成せよ。
 *
 * ※正でない値を読み込んだ場合は、『正でない値が入力されました。』と表示すること。
 */
public class En3_5 {

	public static void main(String[] args) {
		//キーボードからの読み込みを行うプログラム
		Scanner std = new Scanner(System.in);

		//5で割り切れるか検証するための数値の入力を促す
		System.out.print("正の整数値を入力してください：");
		//入力された値を変数number1に代入し、保持
		int number1 = std.nextInt();

		//number1の値が1以上であれば次の条件式に移行
		if(number1 > 0){

			//1以上と判定されたnumber1の値を5で割り、その余りが0ならばという条件
			if(number1%5 == 0){
				//number1を5で割った余りがゼロということは、number1は5で割り切れるということなので、
				//number1は5で割り切れるという判定文を出力する。
				System.out.println("その値は5で割り切れます。");

			//number1を5で割った余りがゼロ以外ならばという条件
			}else {
				//number1を5で割った余りがゼロ以外ということは、number1は5で割り切れないということなので、
				//number1は5で割り切れないという判定文を出力する。
				System.out.println("その値は5で割り切れません。");
			}

		//number1の値が1以上ではなかった場合の条件
		}else {
			//number1の値が1以上ではなかった場合（つまり０以下）、number1の値は正の整数ではないので、
			//number1の値は正の整数ではないという判定文を出力する。
			System.out.println("正でない値が入力されました。");
		}


	}

}
