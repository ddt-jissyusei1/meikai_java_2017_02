package ensyuu4;
import java.util.Scanner;

/*
 * 読み込んだ整数値のすべての約数を表示するList4-13(p.118)を書き換えて、約数の表示が終わった頃に、約数の個数を表示する
 * プログラムを作成せよ
 */
public class En4_17 {
	//プログラムの説明文を出力するための定数
	private static final String DIVISER_PROGRAM_MESSAGE = "入力された値の約数を表示します";
	//表示する約数のための整数値を入力してもらうための出力文の定数
	private static final String INPUT_DIVISER_MESSAGE = "約数を表示する整数値を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(DIVISER_PROGRAM_MESSAGE);

		int numberForDiviser = 0;				//入力された値を代入するための変数を用意し、0で初期化する

		//0以下が入力される場合を考慮して、整数値が入力されるまでdo文で繰り返し、入力文を出力するようにする
		do{
			//入力を促す文を出力する
			System.out.print(INPUT_DIVISER_MESSAGE);
			//入力された値を変数numberForDiviserに代入する
			numberForDiviser = inputStream.nextInt();
		//1以上の値が入力されるまで繰り返す
		}while(numberForDiviser <= 0);
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		int diviserCount = 0;						//約数の数を数えるための変数diviserCountを用意し、0で初期化する

		//ここから入力された値の約数を表示するコード
		//counter変数がnumberForDiviser以下の間for文を繰り返す
		for(int counter = 1; counter <= numberForDiviser; counter++){
			//numberForDiviserをcounterで割った余りが0のとき、counterの値を出力する
			if(numberForDiviser%counter == 0){
				//counterの値を出力する
				System.out.println(counter);
				//diviserCountの値を1インクリメントする
				diviserCount++;
			}
		}

		//入力された値の約数をすべて出力後、約数を数えていたdiviserCountの値を出力する
		System.out.println(numberForDiviser + "の約数は" + diviserCount + "です。");

	}

}
