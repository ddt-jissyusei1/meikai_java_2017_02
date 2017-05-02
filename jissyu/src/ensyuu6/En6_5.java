package ensyuu6;
import java.util.Scanner;

/*
 * 配列の要素数と、個々の要素の値を読み込んで、各要素の値を表示するプログラムを作成せよ。
 * 表示の形式は、初期化子と同じ形式、すなわち、各要素の値をコンマで区切って｛｝で囲んだ形式とすること。
 */
public class En6_5 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "入力された配列の要素数と各要素の値を表示します。";
	//配列の要素数の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "要素数を入力してください：";
	//要素の値の入力を促す文のための定数
	private static final String INPUT_NUMBER_MESSAGE = "要素の値をそれぞれ入力してください。";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数を入力してもらうための文を出力する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された値を変数arrayNumberに代入する
		int arrayNumber = inputStream.nextInt();

		int[] arrayNumbers = new int[arrayNumber];		//要素を出力するための配列を宣言し、要素数にarrayNumberを代入する

		//配列の要素の値を入力してもらうための文を出力する
		System.out.println(INPUT_NUMBER_MESSAGE);

		//配列の要素に順に入力された値を代入するための繰り返し処理
		for(int loop = 0; loop < arrayNumber; loop++){
			//値を入力する要素を出力する
			System.out.print("arrayNumbers[" + loop + "] = ");
			//入力された値を要素に代入する
			arrayNumbers[loop] = inputStream.nextInt();
		}
		//値の入力が終わったので、開いていたリソースを開放する
		inputStream.close();

		//ここから各要素の値を表示するためのコード
		//文の先頭を出力する
		System.out.print("arrayNumbers = {");
		//各要素の値を繰り返し処理で先頭文の後ろに出力する
		for(int outputLoop = 0; outputLoop < arrayNumbers.length; outputLoop++){
			//要素を出力する
			System.out.print(arrayNumbers[outputLoop]);
			//全要素出力後、｝を出力するための分岐処理
			if(outputLoop < arrayNumber-1){
				//要素を出力している間、各要素を区切るため','を出力する
				System.out.print(',');
			}else{
				//最後の要素出力後'}を出力する'
				System.out.println('}');
			}
		}

	}

}
