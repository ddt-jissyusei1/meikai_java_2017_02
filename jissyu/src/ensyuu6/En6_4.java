package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * List6-5(p.187)を書きかえて、縦向きの棒グラフで表示するプログラムを作成せよ。
 * 最下段には、インデックスを10で割った剰余を表示すること。
 */
public class En6_4 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された要素数の数だけ縦向きの棒グラフを表示します。";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "要素数を入力してください：";
	//生成する乱数の上限値のための定数
	private static final int MAX_RANDOM_NUMBER = 10;
	//グラフに出力する文字のための定数
	private static final char OUTPUT_GRAPHIC_CHART_ASTERISK = '*';
	//グラフに出力する空白のための定数
	private static final char OUTPUT_GRAPHIC_CHART_SPACE = ' ';
	//グラフに出力する罫線のための定数
	private static final String OUTPUT_GRAPHIC_CHART_LINE = "--";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random arrayRandomNumber = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//表示する要素数の入力を促す文を出力する
		System.out.print(INPUT_NUMBER_MESSAGE);
		//入力された値を配列の要素数に代入するための変数に代入する
		int arrayNumber = inputStream.nextInt();
		//棒グラフ表示のための配列を宣言し、要素数にarrayNumberの値を代入する
		int[] randomArrays = new int[arrayNumber];

		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		//乱数を配列randomArraysに代入するためのコード
		for(int loop = 0; loop < arrayNumber; loop++){
			//1～10の乱数を代入するために、生成された乱数に1を足した値を代入する
			randomArrays[loop] = 1 + arrayRandomNumber.nextInt(MAX_RANDOM_NUMBER);
		}

		//ここから棒グラフを表示するためのコード

		int outputGraphicControlNumber = MAX_RANDOM_NUMBER;	  //グラフに出力する文字の制御のための変数を用意し、MAX_RANDOM_NUMBERの値を代入する

		//行を、生成する乱数の最大値の数だけ表示するための繰り返し処理
		for(int row = 0; row < MAX_RANDOM_NUMBER; row++){
			//列を、要素数の数だけ表示するための繰り返し処理
			for(int line = 0; line < arrayNumber; line++){
				//縦向きの棒グラフを出力するための分岐処理
				if(randomArrays[line] >= outputGraphicControlNumber){
					//要素の値がmaxRandomNumber以上の場合、棒グラフの表示にするためにアスタリスクを出力する
					System.out.print(OUTPUT_GRAPHIC_CHART_ASTERISK + " ");
				//要素の値がmaxRandomNumber未満の場合
				}else {
					//棒グラフの表示にするために空白を出力する
					System.out.print(OUTPUT_GRAPHIC_CHART_SPACE + " ");
				}
			}
			//次の行を表示するために改行を出力する
			System.out.println();
			//次の行に表示する文字数の制御のためoutputGraphicControlNumberを1デクリメントする
			outputGraphicControlNumber--;
		}

		//グラフの罫線を要素数の長さだけ出力するためのコード
		for(int lineLoop = 0; lineLoop < randomArrays.length; lineLoop++){
			//罫線を表示するための文字を出力する
			System.out.print(OUTPUT_GRAPHIC_CHART_LINE);
		}

		//次の行を表示するために改行を出力する
		System.out.println();

		//グラフの最下段を表示するためのコード
		for(int indexLoop = 0; indexLoop < randomArrays.length; indexLoop++){
			//インデックスを表示するための出力
			System.out.print(indexLoop%10 + " ");
		}

	}

}
