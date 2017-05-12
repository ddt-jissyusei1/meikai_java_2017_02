package ensyuu6;
import java.util.Random;
import java.util.Scanner;

/*
 * 異なる要素が同じ値を持つことのないように演習6－9のプログラムを改良したプログラムを作成せよ。
 * たとえば{1, 3, 5, 6, 1, 2}とならないようにすること（配列の要素数は10以下であるとする）。
 */
public class En6_11 {
	//プログラムの説明文のための定数
	private static final String PROGRAM_MESSAGE = "異なる要素が同じ値を持つことがない配列を表示します。";
	//要素の入力を促す文のための定数
	private static final String INPUT_ARRAY_NUMBER_MESSAGE = "10以下の要素数を入力してください：";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputNumberStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random randomNumber = new Random();

		//プログラムの説明文を出力する
		System.out.println(PROGRAM_MESSAGE);

		//要素数を入力してもらうための文を出力する
		System.out.print(INPUT_ARRAY_NUMBER_MESSAGE);
		//入力された要素数の配列を作成するため、変数に代入する
		int arrayNumber = inputNumberStream.nextInt();

		//値の入力が終わったので、開いていたリソースを開放する
		inputNumberStream.close();

		int[] arrayRandomNumbers = new int[arrayNumber];		//入力された値の要素数の配列を宣言する
		int arrayLength = arrayRandomNumbers.length;			//ループ処理で使用するための、配列の長さのための変数
		int sameNumberCheckLoop;								//同じ値を探索するループのためのカウント変数
		int sameNumberCheck = 0;								//同じ値か探策するキー値のための変数

		//配列に乱数を代入するためのループ処理
		for(int inputRandomNumberLoop = 0; inputRandomNumberLoop < arrayLength; inputRandomNumberLoop++){
			//要素に生成した乱数を代入するためのコード
			//異なる値か探索するための変数に、生成した乱数を代入する
			sameNumberCheck = randomNumber.nextInt(10)+1;

			//配列の一つ目の要素の場合
			if(inputRandomNumberLoop == 0){
				//探索する必要がないため、sameNumberCheckの値をそのまま代入する
				arrayRandomNumbers[0] = sameNumberCheck;
			}
			//要素に値を代入する前に、異なる配列に同じ値がなくなるまでループを繰り返すための繰り返し処理
			do{
				//生成した乱数をキー値として、異なる配列に同じ値がないか探索するためのループ
				for(sameNumberCheckLoop = 0; sameNumberCheckLoop < inputRandomNumberLoop; sameNumberCheckLoop++){
					//同じ値があった場合の条件処理
					if(arrayRandomNumbers[sameNumberCheckLoop] == sameNumberCheck){
						//変数に違う乱数を生成して代入する
						sameNumberCheck = randomNumber.nextInt(10)+1;
						//再度同じ値がないか最初の要素から探索しなおすため、この繰り返し処理を抜けるためのbreak文
						break;
					}
				}
			//探索が参照している要素にくるまでループを繰り返すための条件
			}while(sameNumberCheckLoop < inputRandomNumberLoop);

			//探索が失敗（同じ値がなかった）ため、要素に値を代入する
			arrayRandomNumbers[inputRandomNumberLoop] = sameNumberCheck;
		}

		//要素を表示するための繰り返し処理
		for(int outPutElementsLoop = 0; outPutElementsLoop < arrayLength ; outPutElementsLoop++){
			//配列の各要素を表示するための出力文
			System.out.println("arrayRandomNumbers[" + outPutElementsLoop + "] = "
																		+ arrayRandomNumbers[outPutElementsLoop]);
		}

	}

}
