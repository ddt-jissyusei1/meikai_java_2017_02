package ensyuu8;
import java.util.Scanner;

//Carクラスのテストのためのクラス
public class En8_2_Tester {
	//車のデータの入力を促す文のための定数
	private static final String INPUT_CAR_DATA_MESSAGE = "車のデータを入力してください。";
	//車名入力時に表示する文のための定数
	private static final String OUTPUT_CAR_NAME_STRING = "車名：";
	//車番号入力時に表示する文のための定数
	private static final String OUTPUT_CAR_NUMBER_STRING ="車番号：";
	//車幅入力時に表示する文のための定数
	private static final String OUTPUT_CAR_WIDTH_STRING ="車幅：";
	//車高入力時に表示する文のための定数
	private static final String OUTPUT_CAR_HEIGHT_STRING ="車高：";
	//車長入力時に表示する文のための定数
	private static final String OUTPUT_CAR_LENGTH_STRING ="車長：";
	//タンク容量入力時に表示する文のための定数
	private static final String OUTPUT_TANK_AMOUNT_STRING = "タンク容量：";
	//燃費入力時に表示する文のための定数
	private static final String OUTPUT_FUEL_ECONOMY_STRING ="燃費：";
	//車の現状を表示する文のための定数
	private static final String SHOW_CAR_STATUS_STRING = "\n現在地（%2.1f）,（%2.1f）・残り燃料（%4.1fL）\n";
	//給油の可否の入力を促す文のための定数
	private static final String INPUT_REFUEL_MESSAGE = "給油しますか？[0]→いいえ、[1]→はい：";
	//給油量の入力を促す文のための定数
	private static final String INPUT_REFUEL_AMOUNT_MESSAGE = "何リットル給油しますか？：";
	//移動の可否の入力を促す文のための定数
	private static final String REPEAT_PROGRAM_MESSAGE = "\n移動しますか？[0]→いいえ、[1]→はい：";
	//プログラム終了を通知する文のための定数
	private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。";
	//X座標への移動距離の入力を促す文のための定数
	private static final String MOVE_XDIRECTION_DISTANCE_MESSAGE = "\nX方向への移動距離を入力してください：";
	//Y座標への移動距離の入力を促す文のための定数
	private static final String MOVE_YDIRECTION_DISTANCE_MESSAGE = "Y方向への移動距離を入力してください：";
	//燃料不足を通知する文のための定数
	private static final String FUEL_ERROR_MESSAGE = "燃料が足りません！";

	public static void main(String[] args) {
		//キーボードからの入力ストリームを読み込むためのプログラム
		Scanner inputDataStream = new Scanner(System.in);

		String name;							//車名のための変数
		int carNumber;							//車番号のための変数
		int width;								//車幅のための変数
		int height;							//車高のための変数
		int length;							//車長のための変数
		double tankAmount;					    //タンク容量のための変数
		double fuel = 0;						//残り燃料のための変数
		int fuelEconomy;						//燃費のための変数
		double x = 0.0;							//現在位置x座標のための変数
		double y = 0.0;							//現在位置y座標のための変数
		double refuelAmount = 0.0;			//給油量のための変数

		//試運転する車のデータの入力を促す文を表示するための出力
		System.out.println(INPUT_CAR_DATA_MESSAGE);

		//車名の入力を促す文を表示するための出力
		System.out.print(OUTPUT_CAR_NAME_STRING);
		//入力された値を変数に保持するための代入
		name = inputDataStream.next();

		//車番号の入力を促す文を表示するための出力
		System.out.print(OUTPUT_CAR_NUMBER_STRING);
		//入力された値を変数に保持するための代入
		carNumber = inputDataStream.nextInt();

		//車幅の入力を促す文を表示するための出力
		System.out.print(OUTPUT_CAR_WIDTH_STRING);
		//入力された値を変数に保持するための代入
		width = inputDataStream.nextInt();

		//車高の入力を促す文を表示するための出力
		System.out.print(OUTPUT_CAR_HEIGHT_STRING);
		//入力された値を変数に保持するための代入
		height = inputDataStream.nextInt();

		//車長の入力を促す文を表示するための出力
		System.out.print(OUTPUT_CAR_LENGTH_STRING);
		//入力された値を変数に保持するための代入
		length = inputDataStream.nextInt();

		//タンク容量の入力を促す文を表示するめの出力
		System.out.print(OUTPUT_TANK_AMOUNT_STRING);
		//入力された値を変数に保持するための代入
		tankAmount = inputDataStream.nextDouble();

		//燃費の入力を促す文を表示するための出力
		System.out.print(OUTPUT_FUEL_ECONOMY_STRING);
		//入力された値を変数に保持するための代入
		fuelEconomy = inputDataStream.nextInt();

		En8_2_Car newCar = new En8_2_Car(name, width, height, length, x, y, fuel, tankAmount, carNumber, fuelEconomy);

		//車の性能を表示するためのメソッドの呼び出し
		newCar.showCarSpec();

		//車を好きなだけ移動させるための繰り返し処理
		while (true){
			//現在地と残り燃料を取得し表示するための出力
			System.out.printf(SHOW_CAR_STATUS_STRING, newCar.getX(), newCar.getY(), newCar.getFuel());

			//給油するか否かを選択するための文の出力
			System.out.print(INPUT_REFUEL_MESSAGE);
			//給油する場合に実行する処理のための条件式
			if(inputDataStream.nextInt() == 1){
				//給油量の入力を促す文を表示するための出力
				System.out.print(INPUT_REFUEL_AMOUNT_MESSAGE);
				//給油するメソッドで使用するために、入力された値を変数に代入する
				refuelAmount = inputDataStream.nextDouble();
				//給油するためのメソッドの呼び出し
				newCar.refuel(refuelAmount);
				//残り燃料を表示するための出力
			}

			//車を移動するか否かを選択するための文の出力
			System.out.print(REPEAT_PROGRAM_MESSAGE);
			//移動しない選択の場合、プログラムを終了するために繰り返し処理を抜ける条件式
			if(inputDataStream.nextInt() == 0){
				//プログラムの終了を通知するための文の出力
				System.out.println(QUIT_PROGRAM_MESSAGE);
				//繰り返し処理を抜けるためのbreak文
				break;
			}

			//X座標方向へ移動するための距離の入力を促す文を表示する出力
			System.out.print(MOVE_XDIRECTION_DISTANCE_MESSAGE);
			//クラスで使用するために変数に入力された値を代入する
			double distanceX = inputDataStream.nextDouble();
			//Y座標方向への移動するための距離の入力を促す文を表示する出力
			System.out.print(MOVE_YDIRECTION_DISTANCE_MESSAGE);
			//クラスで使用するために変数に入力された値を代入する
			double distanceY = inputDataStream.nextDouble();

			//燃料不足だった場合に実行する処理のための条件式
			if(!newCar.moveCar(distanceX, distanceY)){
				//燃料不足を通知するための文の出力
				System.out.println(FUEL_ERROR_MESSAGE);
			}
		}
		//値の入力が終了したので、開いていたリソースを開放する
		inputDataStream.close();

	}

}
