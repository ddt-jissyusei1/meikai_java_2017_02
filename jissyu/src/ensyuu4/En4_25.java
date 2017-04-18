package ensyuu4;
import java.util.Scanner;

/*
 * 合計だけでなく平均も求めるようにList4-17(p.126)およびList4-18(p.127)のプログラムを書きかえよ。
 */
public class En4_25 {
	//プログラムの説明のための定数
	private static final String AVE_PROGRAM_MESSAGE = "入力された整数の平均を求めます。";
	//入力する数値の個数を入力してもらうための出力文の定数
	private static final String NUMBER_TO_SUM_MESSAGE = "全部でいくつ加算しますか？：";
	//整数の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "加算する整数を入力してください"
			+ "\n(途中で終了する場合は0を入力してください)：";
	//プログラムの終了文のための定数
	private static final String PROGRAM_EXIT_MESSAGE = "プログラムを終了します。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明を出力する
		System.out.println(AVE_PROGRAM_MESSAGE);

		int sumNumber = 0;			//入力された値を代入するための変数を用意し0で初期化する

		//整数の値以外が入力された場合を考慮してdo文で繰り返し入力文を出力する
		do{
			//加算する数の入力を促す文を出力する
			System.out.print(NUMBER_TO_SUM_MESSAGE);
			//入力された値を変数sumNumberに代入する
			sumNumber = inputStream.nextInt();
		//sumNumberの値が0以下の間繰り返す
		}while(sumNumber <= 0);

		int sumTotal = 0;			//合計値を代入するための変数を用意し、0で初期化する
		int sumLoop = 0;			//繰り返し制御のための変数を、for文の外でも使用するためここで宣言し0で初期化する

		//ここから入力された数だけ加算し、平均を出力するコード
		for(sumLoop = 1; sumLoop <= sumNumber; sumLoop++){
			//加算する整数の入力を促す文を出力する
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値を代入するための変数を宣言し、入力された値で初期化する
			int inputNumber = inputStream.nextInt();

			//入力された値が0であった場合
			if(inputNumber == 0){
				//加算するfor文のループから抜け出る
				break;
			}
			//sumTotalにinputNumberを加算し代入する
			sumTotal += inputNumber;
		}
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//ひとつめに入力された値（1週目の繰り返し）が0の場合による0割エラーを防ぐため、ifで出力を分岐させる
		if(sumLoop == 1){
			//プログラムを終了する文を出力する
			System.out.println(PROGRAM_EXIT_MESSAGE);
		//それ以外の場合
		}else{
		 //加算した数の平均値を出力する
		 System.out.println("\n入力された整数の平均は" + sumTotal/(sumLoop-1)+ "です。");
		}
	}

}
