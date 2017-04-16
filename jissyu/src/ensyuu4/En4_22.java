package ensyuu4;
import java.util.Scanner;
/*
 * 入力された値の段数のピラミッドを表示するプログラムを作成せよ
 * 第～行目には(～ - 1) * 2 + 1個の'*'記号を表示して、最終行である
 * 第(入力された値)行目には(入力された値 - 1) * 2 + 1個の'*'を表示すること。
 */
public class En4_22 {
	//プログラムの説明のための定数
	private static final String PYRAMID_PROGRAM_MESSAGE = "入力された値分の段数のピラミッドを表示します。";
	//段数の値を入力してもらうための文の定数
	private static final String INPUT_ROWNUMBER_MESSAGE = "段数を入力してください：";
	//出力する文字のための定数
	private static final char OUTPUT_ASTERISK = '*';
	//出力する空白のための定数
	private static final char OUTPUT_SPACE = ' ';


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PYRAMID_PROGRAM_MESSAGE);

		int rowNumber = 0;					//入力された値を代入するための変数rowNumberを用意し、0で初期化する

		//正の整数値以外が入力される場合を考慮して、do文で繰り返し入力を促す文を出力するようにする
		do{
			//入力を促す文を出力して値を入力してもらう
			System.out.print(INPUT_ROWNUMBER_MESSAGE);
			//入力された値を変数rowNumberに代入する
			rowNumber = inputStream.nextInt();
		//rowNumberの値が0以下の間、do文を繰り返す
		}while(rowNumber <= 0);
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		int lineNumber = rowNumber;		//行と列の値のデクリメントを分けるため、列用の変数を用意しrowNumberの値を代入する

		//ここからピラミッドを出力するためのコード
		//段数のループ
		for(int row = 1; row <= rowNumber; row++){
			//段数ごとに出力する*の数の計算をして、outputAsteriskNumberに代入する
			int outputAsteriskNumber = (row - 1) * 2 +1;

			//row段目の列の空白を出力するためのループ
			for(int line = 1;line < lineNumber; line++){
				//ピラミッドの形にするため、先に空白を出力する
				System.out.print(OUTPUT_SPACE);
			}

			//row段目の列の*を出力するためのループ
			for(int numberOfAsterisk = 1;numberOfAsterisk <= outputAsteriskNumber; numberOfAsterisk++){
				//(row - 1) * 2 +1個目の*を出力する
				System.out.print(OUTPUT_ASTERISK);
			}

			//空白の出力は左上が直角の三角形になるため、lineNumberの値を1デクリメントする
			lineNumber--;
			//次の段を表示するため改行を出力する
			System.out.println();
		}

	}

}
