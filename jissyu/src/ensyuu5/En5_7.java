package ensyuu5;

/*
 * 0.0から1.0まで0.001おきに、その値と、その値の2乗を表示するプログラムを作成せよ。
 */
public class En5_7 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "0.0から1.0まで0.001おきに、その値と、その値の2乗を表示します。";
	//ヘッダーを出力するための定数
	private static final String HEADER_OUTPRINT = "  通常値        2乗値   \n-----------------------";

	public static void main(String[] args) {
		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//出力結果を見やすくするため、ヘッダーを出力する
		System.out.println(HEADER_OUTPRINT);

		float doubleFloat = 0.0F;		//2乗した値を代入するための変数を用意し、0.0で初期化する

		//sumFloatの値が1.0になるまで出力を繰り返す
		for(float sumFloat = 0.0F; sumFloat <= 1.0; sumFloat += 0.001){
			//sumFloatの値を2乗した値をdoubleFloatに代入する
			doubleFloat = (sumFloat*sumFloat);
			//sumFloatの値と、その値を2乗した値を出力する
			System.out.printf(" %f     %f\n",sumFloat,doubleFloat);
		}

	}

}
