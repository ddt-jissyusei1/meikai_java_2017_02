package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * List6-9は探索するキー値と同じ要素が複数個存在する場合、最も先頭に位置する要素を見つけるプログラムである。
 * 最も末尾側に位置する要素を見つけるプログラムを作成せよ。
 */
public class En6_7 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "探索するキー値と同じ要素が複数個ある場合、最も末尾側に位置する要素を見つけます。";
	//探索するキー値のの入力を促す文のための定数
	private static final String INPUT_SEARCH_KEY_NUMBER_MESSAGE = "探索する値を入力してください：";
	//全要素の値表示の説明文のための定数
	private static final String OUTPUT_ALL_ARRAY_MESSAGE = "配列linearArraysの全要素の値は";
	//要素数のための定数
	private static final int ARRAY_NUMBERS = 12;

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber  = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		int[] linearArrays = new int[ARRAY_NUMBERS];		//値を探索するプログラムのために配列を宣言する

		//配列に生成した乱数を代入するための繰り返し処理
		for(int loop = 0; loop < ARRAY_NUMBERS; loop++){
			//一桁の値の探索のため、0～9の乱数を生成して、配列に代入する
			linearArrays[loop] = randomNumber.nextInt(10);
		}

		//配列にどの値が入ってるか表示するため、全要素を出力する
		System.out.print("配列linearArraysの全要素の値\n{");
		//全要素を出力するためのループ
		for(int outPutLoop = 0; outPutLoop < ARRAY_NUMBERS; outPutLoop++){
			//要素をスペース区切りで出力する
			System.out.print(linearArrays[outPutLoop] + " ");
		}
		//全要素出力後文型を整えるための閉じブレスを表示する
		System.out.println("}");

		//探索するキー値を入力してもらうための文を出力する
		System.out.print(INPUT_SEARCH_KEY_NUMBER_MESSAGE);
		//入力された値を探索キー値とするため、変数に代入する
		int searchKeyNumber = inputStream.nextInt();

		//値の入力が終わったので開いていたリソースを開放する
		inputStream.close();

		//ここから線形探索するためのコード

		int searchLoop;										//探索するループと結果を出力する条件文で共通に使用するためのループ用変数
		int loopDecrementNumber = ARRAY_NUMBERS-1;			//配列の最後から探索するため、要素数から1引いた値を代入する

		//入力されたキー値を配列から探すためのループ
		for(searchLoop = 0; searchLoop <= loopDecrementNumber; loopDecrementNumber--){
			//最も末尾側に位置するキー値を見つけるための条件文
			if(linearArrays[loopDecrementNumber] == searchKeyNumber){
				//探索するキー値が見つかった場合ループを抜けるためのブレイク文
				break;
			}
		}

		//探査するキー値の有無の結果を出力するため条件文
		if(searchLoop < loopDecrementNumber){
			//探査するキー値が入ってる要素を出力する
			System.out.println("それはlinearArrays[" + loopDecrementNumber + "]にあります");
		//キー値が配列になかった場合の分岐
		}else {
			//なかった場合に出力するための文
			System.out.println("キー値は見つかりませんでした。");
		}
	}

}
