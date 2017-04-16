package ensyuu4;
import java.util.Scanner;

/*入力された段数のピラミッドを表示するプログラムを作成せよ
 * 第～行目には～%10を表示すること
 */
public class En4_23 {
	//プログラムの説明ための文の定数
	private static final String PYRAMID_PROGRAM_MESSAGE = "入力された段数の、段ごとの数字のピラミッドを表示します。";
	//段数を入力してもらうための文の定数
	private static final String INPUT_ROWNUMBER_MESSAGE = "表示する段数を入力してください：";
	//空白を出力するための定数
	private static final char OUTPUT_SPACE = ' ';

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明を出力する
		System.out.println(PYRAMID_PROGRAM_MESSAGE);

		int rowNumber = 0;			//入力された値を代入するための変数rowNumberを用意し0で初期化する

		//段数を入力してもらう
		//入力された値が0以下の場合を考慮して、1以上の値が入力されるまでdo文で繰り返し入力を促すようにする
		do{
			//段数を入力を促す文を出力する
			System.out.print(INPUT_ROWNUMBER_MESSAGE);
			//入力された値をrowNumberに代入する
			rowNumber = inputStream.nextInt();
		//入力された値が0以下の間繰り返す
		}while(rowNumber <= 0);
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		int lineNumber = rowNumber;		//行と列の値のデクリメントを分けるため、列用の変数を用意しrowNumberの値を代入する

		//ここからピラミッドを出力するためのコード
		//段数のループ
		for(int row = 1; row <= rowNumber; row++){
			//row段目に出力する文字の数の計算をし、outPutNumberOfRowに代入する
			int outputNumberOfRow = (row - 1) * 2 +1;

			//row段目の空白を出力するためのループ
			for(int line = 1; line < lineNumber; line++){
				//ピラミッドの形にするため、空白を出力する
				System.out.print(OUTPUT_SPACE);
			}

			//row段目の段数をrow個表示するためのループ
			for(int numberOfRow = 1; numberOfRow <= outputNumberOfRow; numberOfRow++){
				//段数の数字を出力する
				System.out.print(row%10);
			}

			//空白の出力は左上が直角の三角形になるため、lineNumberの値を1デクリメントする
			lineNumber--;
			//次の段を表示するため、改行を出力する
			System.out.println();
		}

	}

}
