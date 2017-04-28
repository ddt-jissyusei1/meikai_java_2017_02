package ensyuu6;

/*
 * 要素型がdouble型で要素数が5の配列を生成して、その全要素の値を表示するプログラムを作成せよ。
 */
public class En6_1 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "double型で要素数が5の配列の全要素を表示します。";

	public static void main(String[] args) {
		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		double[] arrayDouble = new double[5];				//問題文に伴い、double型で要素数5の配列を宣言する

		//配列の要素を順に表示するために、繰り返し処理で配列の長さだけ値を代入し出力する
		for(int loop = 0; loop < arrayDouble.length; loop++){
			//配列に,loopに+1した値を代入する
			arrayDouble[loop] = loop + 1;
			//要素の値を出力する
			System.out.println("arrayDouble[" + loop + "] = " + arrayDouble[loop]);
		}

	}

}
