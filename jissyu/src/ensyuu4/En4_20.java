package ensyuu4;
import java.util.Scanner;

/*
 * 入力された値の段数の正方形を表示するプログラムを作成せよ
 */
public class En4_20 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された値の段数の正方形を表示します。";
	//値の入力を促す文のための定数
	private static final String INPUT_SQUARESIZE_MESSAGE = "何段の正方形を表示しますか？：";
	//出力する文字のための定数
	private static final char OUTPUT_SQUARE = '□';

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int rowNumber = 0;		//入力された段数の値を代入するための変数stepsNumberを用意し、0で初期化する

		//入力された値が0以下の場合考慮して、入力を促す文を出力するよう繰り返し処理にする
		do{
			//表示する段数の入力を促す文を出力する
			System.out.print(INPUT_SQUARESIZE_MESSAGE);
			//入力された値を変数stepsNumberに代入する
			rowNumber = inputStream.nextInt();
		//stepsNumberが0以下の間、do文を繰り返す
		}while(rowNumber <= 0);
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		//ここから入力された値の段数の正方形を表示するコード
		//段数のループをカウントする変数ラインを用意し、ループ毎に段数を増やす
		for(int row = 1; row <= rowNumber; row++){
			//正方形は段数＝列数なので、変数lineの値がstepsNumberと同じになるまで列ループを繰り返す
			for(int line = 1; line <= rowNumber; line++){
				//□を出力する
				System.out.print(OUTPUT_SQUARE);
			}
			//列ループの繰り返しが終わったら、次の段数を表示するため改行を出力する
			System.out.println();
		}

	}

}
