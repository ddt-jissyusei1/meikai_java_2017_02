package ensyuu4;
import java.util.Random;
import java.util.Scanner;

/*
 * List4-3(p.98)の数あてゲームのプレーヤが入力できる回数に制限を設けたプログラムを作成せよ。
 * 制限回数内にあてられなかった場合は、正解を表示してゲームを終了すること。
 */
public class En4_27 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "数あてゲーム開始！\n０～９９の数を当ててください。";
	//数の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "いくつかな？：";
	//正解より大きい場合の文のための定数
	private static final String LARGE_NUMBER_MESSAGE = "もっと小さな数だよ。";
	//正解より小さい場合の文のための定数
	private static final String SMALL_NUMBER_MESSAGE = "もっと大きな数だよ。";
	//正解判定文のための定数
	private static final String CORRECT_MESSAGE = "正解です。";

	public static void main(String[] args) {
		//数値をランダムに生成するためのプログラム
		Random randomNumber = new Random();
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		int answerNumber = randomNumber.nextInt(100);		//0～99の数をランダム生成して、answerNumberに代入する
		int lifeNumber = 5;								//回答の制限回数制御のための変数を用意し、5で初期化する
		int guessNumber = 0;								//入力された値を代入するための変数を用意し、0で初期化する

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//ここから数あてゲームの処理
		//正解する、もしくは回答の制限回数になるまでdo文で繰り返し処理する
		do{
			//値の入力を促す文を出力する
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値をguessNumberに代入する
			guessNumber = inputStream.nextInt();

			//入力された値が正解からの大小判定するための分岐
			//guessNumberが正解より大きい場合
			if(guessNumber > answerNumber){
				//正解はもっと小さな数だというヒントを出力する
				System.out.println(LARGE_NUMBER_MESSAGE);
				//回答の制限を回数を減らすため、lifeNumberを1デクリメントする
				lifeNumber--;
			//guessNumberが正解より小さい場合
			}else if(guessNumber < answerNumber){
				//正解はもっと大きな数だというヒント出力する
				System.out.println(SMALL_NUMBER_MESSAGE);
				//回答の制限を回数を減らすため、lifeNumberを1デクリメントする
				lifeNumber--;
			}else {
				//正解判定文を出力する
				System.out.println(CORRECT_MESSAGE);
				//正解したのでループを抜けるためにプログラムを終了する
				return;
			}
		//lifeNumberが0より大きい間繰り返す
		}while(lifeNumber > 0);
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//正解できないまま、回答の制限回数が0になったら正解の数を出力する
		System.out.println("正解は" + answerNumber + "でした。");

	}

}
