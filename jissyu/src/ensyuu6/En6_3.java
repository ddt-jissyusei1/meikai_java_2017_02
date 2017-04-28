package ensyuu6;

/*
 * 要素型がdouble型で要素数が5の配列の要素に対して、先頭から順に1.1, 2.2, 3.3, 4.4, 5.5を代入して表示するプログラムを作成せよ。
 */
public class En6_3 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "double型の要素で、要素数が5の配列の値を表示します。";
	//要素数のための定数
	private static final int ARRAY_NUMBER = 5;

	public static void main(String[] args) {
		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		double[] arrayDoubles = new double[ARRAY_NUMBER];		//要素数が5のdouble型の配列を宣言する
		double arrayNumber = 1.1;									//配列に代入するための値の変数を用意し、1.1で初期化する

		//配列の要素の値を順に表示するために、配列の長さ分だけ繰り返し処理で出力する
		for(int loop = 0; loop < arrayDoubles.length; loop++){
			//配列にarrayNumberの値を代入する
			arrayDoubles[loop] = arrayNumber;
			//arrayDoubles[loop]の値を出力する
			System.out.println("arrayDoubles[" + loop + "] = " + arrayDoubles[loop]);
			//arrayNumberの値を1.1づつ出力するために、arrayNumber値に1.1加算し代入する
			arrayNumber += 1.1;
		}

	}

}
