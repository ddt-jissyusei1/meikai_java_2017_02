package ensyuu6;

/*
 * 要素型がint型で要素数が5の配列の要素に対して、先頭から順に、5,4,3,2,1を代入して表示するプログラムを作成せよ
 */
public class En6_2 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "int型の要素で配列が5の要素の値を、5から降順で表示します。";
	//配列の要素数のための定数
	private static final int ARRAY_NUMBER = 5;
	public static void main(String[] args) {
		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int[] arrayInt = new int[ARRAY_NUMBER];		//int型の要素数が5の配列を宣言する
		int arrayNumber = 5;				//配列の要素に代入するための値の変数を用意し、5で初期化する

		//配列の値を順に出力するために、繰り返し処理でarrayNumberを1づつデクリメントした値を代入し、出力する
		for(int loop = 0; loop < arrayInt.length; loop++){
			//arrayIntにarrayNumberの値を代入する
			arrayInt[loop] = arrayNumber;
			//arrayIntの値を出力する
			System.out.println("arrayInt[" + loop + "] = " + arrayInt[loop]);
			//arrayNumberを1デクリメントする
			arrayNumber--;
		}

	}

}
