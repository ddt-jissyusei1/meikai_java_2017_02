package ensyuu8;

/*
 * 自動車クラスCar（p.290）に対して、フィールドやメソッドを自由に追加せよ。
 *例：タンク容量を表すフィールド、ナンバーを表すフィールド、燃費を表すフィールド、
 *移動による燃料残量の計算に燃費を反映させる、給油のためのメソッドを追加するetc...
 */
public class En8_2_Car {
	private String name;					//車の名前のための変数
	private int width;						//車幅のための変数
	private int height;					//車高のための変数
	private int length;					//車長のための変数
	private double x = 0.0;				//現在位置X座標のための変数
	private double y = 0.0;				//現在位置Y座標のための変数
	private double fuel;					//残り燃料のための変数
	private double tankAmount;				//タンク容量のための変数
	private int carNumber;					//車番号のための変数
	private int fuelEconomy;				//燃費のための変数

	//Carクラスのためのコンストラクタ
	public En8_2_Car(String name, int width, int height, int length, double x, double y, double fuel, double tankAmount,
			int carNumber, int fuelEconomy) {
		this.name = name;					//車名のフィールドに仮引数の値を代入するための代入式
		this.width = width;					//車幅のフィールドに仮引数の値を代入するための代入式
		this.height = height;				//車高のフィールドに仮引数の値を代入するための代入式
		this.length = length;				//車幅のフィールドに仮引数の値を代入するための代入式
		this.x = x;							//現在位置X座標のフィールドに仮引数の値を代入するための代入式
		this.y = y;							//現在位置Y座標のフィールドに仮引数の値を代入するための代入式
		this.fuel = fuel;					//残り燃料のフィールドに仮引数の値を代入するための代入式
		this.tankAmount = tankAmount;		//タンク容量のフィールドに仮引き数の値を代入するための代入式
		this.carNumber = carNumber;			//車番号のフィールドに仮引数の値を代入するための代入式
		this.fuelEconomy = fuelEconomy;		//燃費のフィールドに仮引数の値を代入するための代入式
	}

	//現在位置X座標取得のためのgetメソッド
	public double getX() {
		//呼び出し元に取得したX座標を返却するためのreturn文
		return x;
	}

	//現在位置Y座標取得のためのgetメソッド
	public double getY() {
		//呼び出し元に取得したY座標を返却するためのreturn文
		return y;
	}

	//残り燃料の値取得のためのgetメソッド
	public double getFuel() {
		//呼び出し元に取得した値を返却するためのreturn文
		return fuel;
	}

	//車の性能を表示するためのメソッド
	void showCarSpec(){
		//車の名前を表示するための出力
		System.out.printf("\n車名：%s\n", name );
		//車番号を表示するための出力
		System.out.printf("車番号：%d\n", carNumber);
		//車幅を表示するための出力
		System.out.printf("車幅：%dmm\n", width);
		//車高を表示するための出力
		System.out.printf("車高：%dmm\n", height);
		//車長を表示するための出力
		System.out.printf("車長：%dmm\n", length);
		//タンク容量を表示するためのメソッド
		System.out.printf("タンク容量：%4.1fL\n", tankAmount);
		//残り燃料を表示するため出力
		System.out.printf("残り燃料：%3.1fL\n", fuel);
		//燃費を表示するための出力
		System.out.printf("燃費：%dkm/L\n", fuelEconomy);
	}

	//車を移動させるためのメソッド
	boolean moveCar(double xDistance, double yDistance){
		//移動距離をを算出するための計算式
		double moveDistance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		//移動距離を表示するための出力
		System.out.printf("%4.1f移動します。",moveDistance);

		//残り燃料をもとに移動結果を返却するための条件分岐
		if(moveDistance > fuel){
			//移動距離が残り燃料を超えていた場合、呼び出し元に移動不可の結果を返却するためのreturn文
			return false;
		//移動可能であった場合に実行する処理のための条件分岐
		}else {
			//移動距離分燃料を減少させるための演算式
			fuel -= moveDistance/fuelEconomy;
			//現在位置X座標を変更するための演算式
			x += xDistance;
			//現在位置Y座標を変更するための演算式
			y += yDistance;

			//移動完了の結果を呼び出し元に返却するためのreturn文
			return true;
		}
	}

	//燃料を給油するためのメソッド
	void refuel(double refuelAmount){
		//タンク容量と残り燃料をもとに、給油量を決定するための条件分岐
		if(refuelAmount + fuel > tankAmount){
			//残り燃料と給油量の合計がタンク容量を超えていた場合、給油可能量を算出するための計算式
			refuelAmount = refuelAmount - (tankAmount - fuel);
		}

		//タンクに給油するための演算式
		fuel += refuelAmount;

		//給油結果を表示するための出力
		System.out.printf("%3.1fリットル給油しました。", refuelAmount);
		//残り燃料を表示するための出力
		System.out.printf("\n残り燃料：%3.1fL\n", fuel);
	}


}
