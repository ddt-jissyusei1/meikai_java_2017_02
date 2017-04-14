package ensyuu4;
import java.util.Scanner;

/*
 * 直角がそれぞれ左上・右上・右下となる直角三角形をそれぞれ表示するプログラムを作成せよ
 */
public class En4_21 {
	//プログラムを説明するための定数
	private static final String PROGRAM_MESSAGE = "直角が左上・右上・右下の三角形をそれぞれ表示します。";
	//段数の値を入力してもらうための文の定数
	private static final String INPUT_ROWNUMBER_MESSAGE = "段数を入力してください：";
	//表示する文字のための定数
	private static final char OUTPUT_TRIANGLE = '▽';
	//左上が直角三角形のための説明文の定数
	private static final String UPPERLEFT_TRIANGLE_MESSAGE = "\n左上が直角の直角三角形";
	//右上が直角三角形のための説明文の定数
	private static final String UPPERRIGHT_TRIANGLE_MESSAGE = "\n右上が直角の直角三角形";
	//右下が直角三角形のための説明文の定数
	private static final String DOWNRIGHT_TRIANGLE_MESSAGE = "\n右下が直角の三角形";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int rowNumber = 0;			//入力された段数の値を代入するための変数を用意し、0で初期化する

		//段数の入力の際、正の整数値以外入力された場合を考慮して、do文で入力文を繰り返し出力するようにする
		do{
			//入力を促す文を出力する
			System.out.print(INPUT_ROWNUMBER_MESSAGE);
			//入力された値を変数rowNumberに代入する
			rowNumber = inputStream.nextInt();
			//rowNumberの値が0以下の間do文を繰り返す
		}while(rowNumber <= 0);
		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();


		int lineCount = rowNumber;				//三角形を出力するための列の出力を制御する変数を用意し、rowNumberで初期化する

		//ここから3種類の直角三角形の生成を順に処理し、出力していく

		//左上が直角の三角形の説明文を出力する
		System.out.println(UPPERLEFT_TRIANGLE_MESSAGE);

		//行の出力は入力された段数になるようrowNumberの値だけ処理を繰り返す
		for(int row = 1; row <= rowNumber; row++){
			//列の繰り返しは、出力が三角形になるよう変数lineCountで制御する
			for(int line = 1; line <= lineCount; line++){
				//文字を出力する
				System.out.print(OUTPUT_TRIANGLE);
			}
			//繰り返しの段数毎に列の繰り返しを1デクリメントして出力が三角形になるよう制御する
			lineCount--;
			//次の段を表示するために改行を出力する
			System.out.println();
		}

		//次の三角形出力のために、lineCountの値を再びrowNumberで初期化する
		lineCount = rowNumber;

		//右上が直角の三角形の説明文を出力する
		System.out.println(UPPERRIGHT_TRIANGLE_MESSAGE);

		int outPrintSpace = 1;					//空白を出力するための制御をする変数を用意し、1で初期化する

		//右上が直角の三角形を出力するためのループ文
		//行の出力は入力された段数になるようrowNumberの値だけ処理を繰り返す
		for(int row = 1; row <= rowNumber; row++){
			//列の繰り返しは、出力が三角形になるよう変数lineCountで制御する
			for(int line = 1; line <= lineCount; line++){
				//右上が直角の三角形に出力するためにif文で分岐させる
				if(line < outPrintSpace){
					//もしlineの値がoutPrintSpace未満の場合空白を出力する
					System.out.print("  ");
				//上記条件以外の場合
				}else {
					//▽を出力する
					System.out.print(OUTPUT_TRIANGLE);
				}
			}
			//繰り返し毎に出力する空白を増やすために、outPrintSpaceの値を1インクリメントする
			outPrintSpace++;
			//次の段に出力が移るよう改行を出力する
			System.out.println();
		}

		//次の三角形を出力するために、lineCountの値を再びrowNumberで初期化する
		lineCount = rowNumber;
		//空白を出力する制御のための変数outPrintSpaceを次のプログラムで段数分デクリメントするためrowNumberで初期化する
		outPrintSpace = rowNumber;

		//右下が直角の三角形の説明文を出力する
		System.out.println(DOWNRIGHT_TRIANGLE_MESSAGE);

		//右下が直角の三角形を出力するためのループ文
		//行の出力は入力された段数になるようrowNumberの値だけ処理を繰り返す
		for(int row = 1; row <= rowNumber; row++){
			//列の繰り返しは、出力が三角形になるよう変数lineCountで制御する
			for(int line = 1; line <= lineCount; line++){
				//lineの値がoutPrintSpace以上の場合
				if(line >= outPrintSpace){
					//▽を出力する
					System.out.print(OUTPUT_TRIANGLE);
				//上記条件以外の場合
				}else{
					//空白を出力する
					System.out.print("  ");
				}
			}
			//次の段の▽の出力を増やすためoutPrintSpaceを1デクリメントする
			outPrintSpace--;
			//次の段に出力されるよう改行を出力する
			System.out.println();

		}











	}

}
