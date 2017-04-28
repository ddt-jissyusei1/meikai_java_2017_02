package ensyuu5;

/*
 * List5-9(p.168)のように、float型の変数を0.0から1.0まで0.001ずつ増やしていく様子と、
 * List5-10(p.169)のように、int型の変数を0から1000までインクリメントした値を1000で割った値を求める様子を、
 * 横に並べて表示するプログラムを作成せよ。
 */
public class En5_6 {
	//プログラムの説明文を出力するための定数
	private static final String PROGRAM_MESSAGE = "float型の変数を0.0から1.0まで0.001ずつインクリメントと、"
														+ "\nint型の変数を0から1000までインクリメントし1000で割った値を求める様子を表示します。";

	public static void main(String[] args) {
		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//floatとintをカラム名として出力する
		System.out.println("  float        int   \n---------------------");

		float sumFloat = 0.0F;		//float型の値のための変数を用意し0で初期化する
		int sumInt = 0;			//int型の値のための変数を用意し0で初期化する

		//行で出力するために、rowの値が1.0以下の間処理を繰り返す
		for(float row = 0.0F; row <= 1.0F; row += 0.001F){
			//int型変数の値を1000で割った値をfloat型にキャストしてincrementIntに代入する
			float incrementInt = (float)sumInt/1000;
			//float型の変数とint型変数の値を求める様子を出力する
			System.out.printf("%f     %f\n",row,incrementInt);
			//次の行に出力する計算のために、rowの値をsumFloatに加算し代入する
			sumFloat += row;
			//int型変数sumIntも次の行の出力するのために1インクリメントする
			sumInt++;
		}


	}

}
