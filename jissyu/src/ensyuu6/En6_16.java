package ensyuu6;
import java.util.Scanner;

/*
 * 4行3列の行列と3行4列の行列の積を求めるプログラムを作成せよ。
 * 各要素の値はキーボードから読み込むこと。
 */
public class En6_16 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "4行3列の行列と3行4列の行列の積を求めます。";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "各要素の値を入力してください。";
	//配列のインデックスのための定数
	private static final int ARRAY_INDEX_NUMBER_FOUR = 4;
	//配列のインデックスのための定数
	private static final int ARRAY_INDEX_NUMBER_THREE = 3;


	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		//積を求めるための4行3列の配列の宣言
		int[][] arrayMultiOne = new int[ARRAY_INDEX_NUMBER_FOUR][ARRAY_INDEX_NUMBER_THREE];
		//積を求めるための3行4列の配列の宣言
		int[][] arrayMultiSecond = new int[ARRAY_INDEX_NUMBER_THREE][ARRAY_INDEX_NUMBER_FOUR];
		//求めた積を代入するための配列の宣言
		int[][] arrayMultiResult = new int[ARRAY_INDEX_NUMBER_FOUR][ARRAY_INDEX_NUMBER_FOUR];
		//要素に値を代入する行の繰り返し制御のための変数
		int inputRowLoop;
		//要素の値を代入する列の繰り返し制御のための変数
		int inputLineLoop;
		//行列の積の合計を入れるための変数
		int sum;

		//プログラムの説明文を出力するためのコード
		System.out.println(PROGRAM_MESSAGE);

		//要素の値の入力を促す文を出力するためのコード
		System.out.println(INPUT_NUMBER_MESSAGE);

		//一つ目の多次元配列に値を代入するためのコード
		//入力された値を配列に代入するための行の繰り返し処理
		for(inputRowLoop = 0; inputRowLoop< ARRAY_INDEX_NUMBER_FOUR; inputRowLoop++){
			//入力された値を配列に代入するための列の繰り返し処理
			for(inputLineLoop = 0; inputLineLoop < ARRAY_INDEX_NUMBER_THREE; inputLineLoop++){
				//どの要素に値が入力されるか表示するための出力
				System.out.print("arrayMultiOne[" + inputRowLoop + "][" + inputLineLoop + "] = ");
				//入力された値を要素に代入する
				arrayMultiOne[inputRowLoop][inputLineLoop] = inputNumberStream.nextInt();
			}
		}

		//出力を見やすくするための区切り改行を出力
		System.out.println();

		//二つ目の多次元配列に値を代入するためのコード
		//入力された値を配列に代入するための行の繰り返し処理
		for(inputRowLoop = 0; inputRowLoop < ARRAY_INDEX_NUMBER_THREE; inputRowLoop++){
			//入力された値を配列に代入するための列の繰り返し処理
			for(inputLineLoop = 0; inputLineLoop < ARRAY_INDEX_NUMBER_FOUR; inputLineLoop++){
				//どの要素に値が入力されるか表示するための出力
				System.out.print("arrayMultiSecond[" + inputRowLoop + "][" + inputLineLoop + "] = ");
				//入力された値を要素に代入するためのコード
				arrayMultiSecond[inputRowLoop][inputLineLoop] = inputNumberStream.nextInt();
			}
		}

		//出力を見やすくするための区切り改行を出力
		System.out.println();

		//値の入力が終わったので開いていたリソースを開放する
		inputNumberStream.close();

		//ここから行列の積を求めるためのコード

		int inputResultRowLoop = 0;						//行列の積の結果を入れる配列のための行のループの変数
		int inputResultLineLoop = 0;						//行列の積の結果を入れる配列のための列のループの変数

		//積の結果を代入する配列の行のための繰り返し処理
		for(inputResultRowLoop = 0; inputResultRowLoop < ARRAY_INDEX_NUMBER_FOUR; inputResultRowLoop++){
			//繰り返し毎に列のインデックスを0にするための変数の初期化
			inputResultLineLoop = 0;
			//積を計算する行のための繰り返し処理
			for(inputRowLoop = 0; inputRowLoop < ARRAY_INDEX_NUMBER_FOUR; inputRowLoop++){
				//行列ごとに合計を計算するために、繰り返し毎に合計値を入れる変数を初期化する
				sum = 0;
				//積を計算する列のための繰り返し処理
				for(inputLineLoop = 0; inputLineLoop < ARRAY_INDEX_NUMBER_THREE; inputLineLoop++){
					//二つの配列の指定した要素を掛け算し、変数に加算する
					sum += arrayMultiOne[inputRowLoop][inputLineLoop]*arrayMultiSecond[inputLineLoop][inputRowLoop];
				}
				//行列の積の結果を出力するための配列に代入する
				arrayMultiResult[inputResultRowLoop][inputResultLineLoop] = sum;
				//要素の値を出力するためのコード
				System.out.println("arrayMultiResult[" + inputResultRowLoop + "][" + inputResultLineLoop + "] = " + sum);
				//行列の積の結果を代入する配列の列のインデックスのためのインクリメント
				inputResultLineLoop++;
			}

		}

	}

}
