package ensyuu7;
import java.util.Scanner;

/*
 * 受け取ったint型引数の値がnであれば-1を返却し、0であれば0を返却し、正であれば1を返却するメソッドsignOfを作成せよ。
 */
public class En7_1 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された値が負なら-1を、0なら0を、正なら1を返します。";
	//値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "数値を入力してください：";
	//負の判定時に返却する値のための定数
	private static final int MINUS_JUDGE_NUMBER = -1;
	//正の判定時に返却する値のための定数
	private static final int PLUS_JUDGE_NUMBER = 1;
	//0の判定時に返却する値のための定数
	private static final int ZERO_JUDGE_NUMBER = 0;
	//判定結果出力文のための定数
	private static final String JUDGE_RESULT_MESSAGE = "判定は%d";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);

		int numberToJudge = 0;		//正負判定する値のための変数

		//プログラムの説明のための出力
		System.out.println(PROGRAM_MESSAGE);

		//正・負・0の判定をするための値の入力を促すための文の出力
		System.out.print(INPUT_NUMBER_MESSAGE);
		//入力された値を正負の判定するために変数に代入する
		numberToJudge = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		//メソッド呼び出し式を組み込んで、判定結果を出力するためのコード
		System.out.printf(JUDGE_RESULT_MESSAGE,signOf(numberToJudge));
	}

	//入力された値を判定して、対応する数値を返すためのメソッド
	static int signOf(int numberToJudge){

		int resultNumber = 0;		//判定結果のための変数

		//返す値を判定するための条件分岐
		//引数の値が-1以下の場合の条件
		if(numberToJudge <= MINUS_JUDGE_NUMBER ){
			//メインメソッドに-1を返す
			resultNumber = MINUS_JUDGE_NUMBER;
		//引数の値が1以上の場合の条件
		}else if(numberToJudge >= PLUS_JUDGE_NUMBER){
			//メインメソッドに1を返す
			resultNumber = PLUS_JUDGE_NUMBER;
		//引数が0の場合の条件
		}else{
			//メインメソッドに0を返す
			resultNumber = ZERO_JUDGE_NUMBER;
		}
		//判定結果の値をメインメソッドに返すためのreturn文
		return resultNumber;
	}

}
