package ensyuu4;
import java.util.Scanner;

/*
 * 合計だけでなく平均も求めるようにList4-19(p.129)のプログラムを書きかえよ。
 * なお、読み込んだ負の数の個数は平均を求める際の分母から除外すること。
 */
public class En4_26 {
	//プログラムの説明のための定数
	private static final String PROGRAM_MESSAGE = "入力された値を加算して平均を求めます。";
	//入力する個数の入力を促す文のための定数
	private static final String INPUT_SUMNUMBER_MESSAGE = "加算する個数を入力してください：";
	//加算する整数の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "整数を入力してください：";
	//負の値が入力された場合に出力する文のための定数
	private static final String MINUS_NUMBER_MESSAGE = "負の値は加算しません";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int sumNumber = 0;		//入力された加算数を代入するための変数を用意し、0で初期化する

		//加算する数が0以下の場合を考慮して、do文で繰り返し入力文を出力する
		do{
			//加算数の入力を促す文を出力する
			System.out.print(INPUT_SUMNUMBER_MESSAGE);
			//入力された値を変数sumNumberに代入する
			sumNumber = inputStream.nextInt();
		//sumNumberの値が0以下の間繰り返す
		}while(sumNumber <= 0);

		//ここから入力された個数分だけ加算していくコード

		int sumTotal = 0;		//加算した合計値を代入するための変数を用意し0で初期化する
		int loop;			//繰り返し制御用の変数を用意する
		int minusCount=0;		//負の値が入力された回数をカウントするための変数を用意し0で初期化する

		//loopの値がsumNumber以下の間繰り返す
		for(loop = 1; loop <= sumNumber; loop++){
			//加算する整数の値の入力を促す
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値を代入するための変数を宣言し、入力された値で初期化する
			int inputNumber = inputStream.nextInt();
			//負の値は加算しないのでinputNumberが0未満のとき
			if(inputNumber < 0){
				//負の値が入力された場合に出力する文
				System.out.println(MINUS_NUMBER_MESSAGE);
				//入力された負の回数カウントを1インクリメントする
				minusCount++;
				//負の値を加算する処理を実行しないために、continueで加算処理を飛ばしてループの末尾に移動する
				continue;
			}
			//sumTotalにinputNumberを加算して代入する
			sumTotal += inputNumber;
		}
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//加算数の平均を計算して出力する
		System.out.println("\n入力された整数の平均は" + sumTotal/(sumNumber - minusCount) + "です。");


	}

}
