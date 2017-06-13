package ensyuu7;

/*
 * 整数を左右にシフトした値が、2のべき乗での乗算や除算と等しくなることを確認するプログラムを作成せよ。
 */
public class En7_11 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "整数を左右にシフトした値が、2のべき乗での乗算や除算と"
																					+ "等しくなることを確認します。";
	//検証する数値とシフトする数を表示する文のための定数
	private static final String OUTPUT_USING_NUMBER = "シフトする整数：%d\nシフトする数：%d";
	//右にシフトする文のための定数
	private static final String RIGHT_SHIFT_MESSAGE = "\n\n右に%dシフトした値は%dで、%d/%d（2のべき乗）と等しい";
	//左にシフトする文のための定数
	private static final String LEFT_SHIFT_MESSAGE = "\n左に%dシフトした値は%dで、%d*%d（2のべき乗）と等しい";
	//検証用の整数の定数
	private static final int SHIFT_NUMBER = 2;
	//整数をシフトする数のための定数
	private static final int SHIFT_BIT_NUMBER = 1;

	public static void main(String[] args) {
		//プログラムの説明文を表示するための出力
		System.out.println(PROGRAM_MESSAGE);

		//使用する数値の表示のための出力
		System.out.printf(OUTPUT_USING_NUMBER, SHIFT_NUMBER, SHIFT_BIT_NUMBER);

		//整数を左右にシフトし、2のべき乗と等しいことを確認するためのメソッドの呼び出し
		shiftBits();
	}


	//整数を左右にシフトするためのメソッド
	private static void shiftBits(){
		int shiftRightResult = 0;		//右シフトした結果の値のための変数
		int shiftLeftResult = 0;		//左シフトした結果の値のための変数

		//整数を右にシフトした値を変数に代入する
		shiftRightResult = SHIFT_NUMBER >> SHIFT_BIT_NUMBER;
		//整数を左にシフトした値を変数に代入する
		shiftLeftResult = SHIFT_NUMBER << SHIFT_BIT_NUMBER;

		//右にシフトした値が2のべき乗での除算と等しい場合に出力するための条件分岐
		if(shiftRightResult == SHIFT_NUMBER/SHIFT_NUMBER){
			//右にシフトした値の確認のための出力
			System.out.printf(RIGHT_SHIFT_MESSAGE, SHIFT_BIT_NUMBER,shiftRightResult, SHIFT_NUMBER,SHIFT_NUMBER);
		}

		//左にシフトした値が2のべき乗での乗算と等しい場合に出力するための条件分岐
		if(shiftLeftResult == SHIFT_NUMBER*SHIFT_NUMBER){
			//左にシフトした値の確認のための出力
			System.out.printf(LEFT_SHIFT_MESSAGE, SHIFT_BIT_NUMBER, shiftLeftResult, SHIFT_NUMBER, SHIFT_NUMBER);
		}

	}

}
