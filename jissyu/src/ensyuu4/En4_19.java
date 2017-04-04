package ensyuu4;
import java.util.Scanner;

/*
 * 季節を求めるList4-1(p.95)の月の読み込みにおいて、1～12以外の値が入力された場合は、
 * 再入力させるように修正したプログラムを作成せよ（do文の中にdo文が入る二重ループとなる）
 */
public class En4_19 {
	//プログラムの説明文のための定数
	private static final String SEASONS_PROGRAM_MESSAGE = "季節を求めます。";
	//求める季節の月の入力を促す文のための定数
	private static final String INPUT_MONTH_MESSAGE = "求める季節の月を入力してください：";
	//繰り返すをするかどうかの質問文のための定数
	private static final String REPEAT_PROGRAM_MESSAGE ="もう一度実行する場合は1を、終了する場合は1以外を入力してください：";
	//春という判定文を出力するための定数
	private static final String IS_SPRING_MESSAGE = "その月は春です。";
	//夏という判定文を出力するための定数
	private static final String IS_SUMMER_MESSAGE = "その月は夏です。";
	//秋という判定文を出力するための定数
	private static final String IS_AUTUMN_MESSAGE = "その月は秋です。";
	//冬という判定文を出力するための定数
	private static final String IS_WINTER_MESSAGE = "その月は冬です。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		int month = 0;						//入力された月の値を代入するための変数を用意し、0で初期化する
		int retry = 0;						//プログラムをもう一度実行するかの制御のための変数を用意し、0で初期化する

		//プログラム終了後、もう一度プログラム実行できるようdo文で繰り返し処理にする
		do{
			//プログラムの説明文を出力する
			System.out.println(SEASONS_PROGRAM_MESSAGE);
			//1～12以外の数値が入力された場合を考慮して、再入力させるよう繰り返し処理にする
			do{
				//求める季節の月の入力を促す文を出力する
				System.out.print(INPUT_MONTH_MESSAGE);
				//入力された値を変数monthに代入する
				month = inputStream.nextInt();
			//入力された値が0以下、または13以上の間、入力を促す文の出力を繰り返す
			}while(month <= 0 || month >= 13);

			//monthの値が3より大きく、かつ5より小さいときの分岐
			if(month >= 3 && month <= 5){
				//3～5は春であるという判定文を出力する
				System.out.println(IS_SPRING_MESSAGE);
				//monthの値が6より大きく、かつ8より小さいときの分岐
			}else if(month >= 6 && month <= 8){
				//6～8は夏であるという判定文を出力する
				System.out.println(IS_SUMMER_MESSAGE);
				//monthの値が9より大きく、かつ11より小さいときの分岐
			}else if(month >= 9 && month <= 11){
				//9～11は秋であるという判定文を出力する
				System.out.println(IS_AUTUMN_MESSAGE);
				//monthの値が12、または1、または2の場合の分岐
			}else if(month == 12 || month == 1 || month == 2){
				//12・1・2は冬であるという判定文を出力する
				System.out.println(IS_WINTER_MESSAGE);
			}
			//もう一度プログラムを実行するかの質問文を出力し、『はい』なら1を、『いいえ』なら2の入力を促す
			System.out.print(REPEAT_PROGRAM_MESSAGE);
			//入力された値を変数retryに代入する
			retry = inputStream.nextInt();
		//retryの値が1である間、プログラムを実行するdo文を繰り返す
		}while(retry == 1);
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

	}

}
