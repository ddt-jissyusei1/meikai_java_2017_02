package ensyuu4;
import java.util.Random;
import java.util.Scanner;

/*
 * 2桁の整数値（10～99）を当てさせる《数当てゲーム》を作成せよ。
 */

public class En4_2 {

	public static void main(String[] args) {
		//キーボードからの入力を読み込むためのプログラム
		Scanner inputStream = new Scanner(System.in);
		//乱数を生成するためのプログラム
		Random random = new Random();

		int answer = random.nextInt(90)+10;	//当てるための10～99の生成した乱数を変数answerに代入して保持する

		//ゲーム開始の文を出力して、ゲームスタートする
		System.out.println("数当てゲーム開始！\n10～99の数字を当ててください。");

		int number;							//プレイヤーが入力した回答を代入するための変数numberを宣言する

		//do～while文で正解までの工程を繰り返し実行する
		do {
			//プレイヤーに回答を入力してもらう
			System.out.print("いくつかな？：");
			//入力された数値を変数numberに代入して保持する
			number = inputStream.nextInt();

			//入力された値が、生成された乱数と同じであるか判定する
			//正解より大きいまたは小さい場合、ヒント文を出力する
			if(number > answer){
				//正解の値より入力された値が大きい場合、もっと小さいというヒントを出す
				System.out.println("もっと小さな数です。");

				//他の条件の場合（入力された値が正解より小さいとき）、大きいというヒントを出す
			}else if (number < answer){
				//正解の値より入力された値が小さいというヒントを出す
				System.out.println("もっと大きな数です。");
			}

			//入力された値と生成された乱数の値が等しくない（つまり不正解）の間、上記回答の入力工程を繰り返す
		}while( number != answer);


		//入力された値と正解の値が等しかった場合（つまり正解）、doのループ文を抜け正解したと教える
		System.out.println("正解です！！");
	}

}
