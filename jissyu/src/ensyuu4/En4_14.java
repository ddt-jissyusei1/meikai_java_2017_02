package ensyuu4;
import java.util.Scanner;

/*
 * 1から入力された値までの和を求めるプログラムで、積の式を表示するプログラムを作成せよ
 */

public class En4_14 {
		//和を求めるというプログラム説明文の定数
		private static final String SUM_PROGRAM_MESSAGE = "1から入力された値までの和を求めます。";
		//1からの和を求める整数の入力を促す文の定数
		private static final String INPUT_NUMBER_MESSAGE = "1からの積を求める正の整数値を入力してください:";

		public static void main(String[] args) {
			//キーボードからの読み込みを行うためのプログラム
			Scanner inputStream = new Scanner(System.in);

			//プログラムの内容を説明する文を出力する
			System.out.println(SUM_PROGRAM_MESSAGE);

			int sumEndNumber;						//入力された値を代入するための変数を用意する

			//0以下の値が入力された場合を考慮して、1以上の値が入力されるまで入力を促す文を繰り返し出力する
			do{
				//1からの和を求める整数値の入力を促す文を出力する
				System.out.print(INPUT_NUMBER_MESSAGE);
				//入力された値をsumEndNumberに代入する
				sumEndNumber = inputStream.nextInt();
			//sumEndNumberの値が0以下である間、do文を繰り返す制御式
			}while(sumEndNumber <= 0);
			//値の入力が終了したので開いていたリソースを閉じる
			inputStream.close();

			int sum = 0;					//1からの和の合計値を入れるための変数sumを用意し、0で初期化する
			int count;						//1から入力された値までの和をカウントするための変数を用意する

			//ここから1から入力された値までの和を求める繰り返し処理
			for(count = 1; count <= sumEndNumber; count++){
				//変数sumにcountの値を足して代入する
				sum += count;
				//式を表示するためにカウントの値を表示
				System.out.print(count);

				//もしcountの値がsumEndNumberと等しければ実行する
				if(count == sumEndNumber){
					//式の終わりとして=と合計値を出力する
					System.out.print(" = " + sum);
				//上の条件式以外の場合elseを実行する
				}else{
					//+を出力する
					System.out.print(" + ");
				}
			}
			//1から入力された値までの和が入っているsumの値を出力する
			System.out.println("\n1から入力された値までの和は、" + sum + "です。");
		}
}
