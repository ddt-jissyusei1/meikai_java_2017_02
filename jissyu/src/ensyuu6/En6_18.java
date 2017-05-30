package ensyuu6;
import java.util.Scanner;

/*
 * 行数・各行の列数・各要素の値をキーボードから読み込むようにList6-18(p.214)を書きかえたプログラムを作成せよ。
 */
public class En6_18 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "凹凸な二次元配列の要素の値を出力します。";
	//行数の値の入力を促す文のための定数
	private static final String INPUT_ROW_NUMBER_MESSAGE = "\n行数を入力してください：";
	//各行の列数の入力を促す文のための定数
	private static final String INPUT_LINE_NUMBER_MESSAGE ="\n各行の列数を入力してください。";
	//各要素の値の入力を促す文のための定数
	private static final String INPUT_ELEMENTS_NUMBER_MESSAGE = "\n各要素の値を入力してください。";


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//プログラムの説明文を出力するためのコード
		System.out.println(PROGRAM_MESSAGE);

		int[][] unevennessArray;			//凹凸な2次元配列を作成するための配列の宣言
		int arrayRowNumber = 0;			//入力された行数を代入するための変数
		int lineNumber = 0;				//各行数の入力された列数を代入するための変数
		int rowNumberLoop = 0;			//配列の行の繰り返し制御のための変数
		int lineNumberLoop = 0;			//配列の列の繰り返し制御のための変数

		//行数の入力を促すための文を出力するコード
		System.out.print(INPUT_ROW_NUMBER_MESSAGE);
		//入力された値を配列の生成にしようするための変数に代入する
		arrayRowNumber = inputNumberStream.nextInt();

		//入力された行数で配列を生成するための配列宣言
		unevennessArray = new int[arrayRowNumber][];

		//各行数の列数の入力を促すための文を出力するコード
		System.out.println(INPUT_LINE_NUMBER_MESSAGE);

		//入力された値で各行数の列数の配列を生成するための繰り返し処理
		for(rowNumberLoop = 0; rowNumberLoop < arrayRowNumber; rowNumberLoop++){
			//どの行の列数の入力か知らせるための文の出力
			System.out.print("unevennessArray[" + rowNumberLoop + "][] = ");
			//入力された値を配列の列数のための変数に代入する
			lineNumber = inputNumberStream.nextInt();
			//各行の列数を入力された値で宣言するためのコード
			unevennessArray[rowNumberLoop] = new int[lineNumber];
		}

		//宣言された配列の各要素の値の入力促すための文を出力するコード
		System.out.println(INPUT_ELEMENTS_NUMBER_MESSAGE);

		//ここから配列の各要素に値を代入するための繰り返し処理

		//配列の行数のための繰り返し処理
		for(rowNumberLoop = 0; rowNumberLoop < unevennessArray.length; rowNumberLoop++){
			//配列の各行の列数のための繰り返し処理
			for(lineNumberLoop = 0; lineNumberLoop < unevennessArray[rowNumberLoop].length; lineNumberLoop++){
				//値を入力する配列の要素数の出力
				System.out.print("unevennessArray[" + rowNumberLoop + "][" + lineNumberLoop + "] = ");
				//入力された値を配列に代入するためのコード
				unevennessArray[rowNumberLoop][lineNumberLoop] = inputNumberStream.nextInt();
			}
		}
		//値の入力が終わったので開いていたリソースを開放する
		inputNumberStream.close();

		//配列の要素を出力するための繰り返し処理
		for(rowNumberLoop = 0; rowNumberLoop < unevennessArray.length; rowNumberLoop++){
			//どの行数の要素の出力か知らせるための文の出力
			System.out.print("\nunevennessArray[" + rowNumberLoop + "][] =");
			//要素を出力するための列の繰り返し処理
			for(lineNumberLoop = 0; lineNumberLoop < unevennessArray[rowNumberLoop].length; lineNumberLoop++){
				//配列の要素を出力するためのコード
				System.out.printf("%3d", unevennessArray[rowNumberLoop][lineNumberLoop]);
			}
			//配列の各行の出力を区切るための改行出力
			System.out.println();
		}


	}

}
