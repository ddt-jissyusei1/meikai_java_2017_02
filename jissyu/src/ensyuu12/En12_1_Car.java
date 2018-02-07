package ensyuu12;

//車のためのクラス
public class En12_1_Car {
    private String name;                    //車の名前のための変数
    private int width;                      //車幅のための変数
    private int height;                     //車高のための変数
    private int length;                     //車長のための変数
    private double tankAmount;              //タンク容量のための変数
    private int carNumber;                  //車番号のための変数
    private int fuelEconomy;                //燃費のための変数
    protected double x = 0.0;              //現在位置X座標のための変数
    protected double y = 0.0;              //現在位置Y座標のための変数
    protected double fuel;                 //残り燃料のための変数
    private En12_1_Day purchaseDay;         //車の購入日のための変数

    //Carクラスのためのコンストラクタ
    public En12_1_Car(String name, int width, int height, int length, double x, double y, double fuel,
                                         En12_1_Day purchaseDay, double tankAmount, int carNumber, int fuelEconomy) {
        this.name = name;                   //車名のフィールドに仮引数の値を代入するための代入式
        this.width = width;                 //車幅のフィールドに仮引数の値を代入するための代入式
        this.height = height;               //車高のフィールドに仮引数の値を代入するための代入式
        this.length = length;               //車幅のフィールドに仮引数の値を代入するための代入式
        this.tankAmount = tankAmount;       //タンク容量のフィールドに仮引数の値を代入するための代入式
        this.carNumber = carNumber;         //車番号のためのコンストラクタ
        this.fuelEconomy = fuelEconomy;     //燃費のためのコンストラクタ
        this.x = x;                         //現在位置X座標のフィールドに仮引数の値を代入するための代入式
        this.y = y;                         //現在位置Y座標のフィールドに仮引数の値を代入するための代入式
        this.fuel = fuel;                   //残り燃料のフィールドに仮引数の値を代入するための代入式
        this.purchaseDay = new En12_1_Day(purchaseDay);

    }

    //タンク容量を取得するためのメソッド
    public double getTankAmount() {
        //呼び出し元に取得した値を返却する
        return tankAmount;
    }

    //タンク容量をフィールド変数にセットするためのメソッド
    public void setTankAmount(double tankAmount) {
        //引数の値をフィールド変数にセットする
        this.tankAmount = tankAmount;
    }

    //車番号を取得するためのメソッド
    public int getCarNumber() {
        //呼び出し元に取得した値を返却する
        return carNumber;
    }

    //車番号をフィールド変数にセットするためのメソッド
    public void setCarNumber(int carNumber) {
        //引数の値をフィールド変数にセットする
        this.carNumber = carNumber;
    }

    //燃費を取得するためのメソッド
    public int getFuelEconomy() {
        //呼び出し元に取得した値を返却する
        return fuelEconomy;
    }

    //燃費の値をフィールド変数にセットするためのメソッド
    public void setFuelEconomy(int fuelEconomy) {
        //引数の値をフィールド変数にセットする
        this.fuelEconomy = fuelEconomy;
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

    //車の購入日を取得するためのメソッド
    public En12_1_Day getPurchaseDay(){
        //呼び出し元に取得した値を返却するためのreturn文
        return new En12_1_Day(purchaseDay);
    }

    //車のスペックを表示するためのメソッド
    public void showCarSpec(){
        //車のスペック表示だと明示するための文の出力
        System.out.println("\n■車の性能■");
        //車名を表示するための出力
        System.out.println("名前：" + name);
        //車幅を表示するための出力
        System.out.println("車幅：" + width + "mm");
        //車高を表示するための出力
        System.out.println("車高：" + height + "mm");
        //車長を表示するための出力
        System.out.println("車長：" + length + "mm");
        //車番号を表示するための出力
        System.out.println("車番号：" + carNumber);
        //タンク容量を表示するための出力
        System.out.println("タンク容量：" + tankAmount + "L");
        //燃費を表示するための出力
        System.out.println("燃費：" + fuelEconomy);
        //購入日を表示するための出力
        System.out.println("購入日:" + purchaseDay);
    }

    //燃料を給油するためのメソッド
    void refuel(double refuelAmount){
        //タンク容量と残り燃料をもとに、給油量を決定するための条件分岐
        if(refuelAmount + fuel > tankAmount){
            //残り燃料と給油量の合計がタンク容量を超えていた場合、給油可能量を算出するための計算式
            refuelAmount = refuelAmount - (tankAmount - fuel);
        }

       //既にタンク満タンで給油できない場合の処理
        if (tankAmount == fuel){
            //満タンであることを告げるための文を出力する
            System.out.println("\n既に満タンで給油できません！！");

        //給油可能な場合に給油するための条件分岐
        }else {
        //タンクに給油するための演算式
        fuel += refuelAmount;

        //給油結果を表示するための出力
        System.out.printf("%3.1fリットル給油しました。", refuelAmount);
        }
        //残り燃料を表示するための出力
        System.out.printf("\n残り燃料：%3.1fL\n", fuel);
    }

    //走行距離を算出するためのメソッド
    public double calculateMoveDistance(double calcX, double calcY){
        double moveDistanceResult = 0;      //算出された値を返却するための変数
        //座標から移動距離を算出するための計算式
        moveDistanceResult = Math.sqrt(calcX * calcX + calcY * calcY);

        //呼び出し元に移動距離の値を返却する
        return moveDistanceResult;
    }

    //車の現在位置を移動させるためのメソッド
    public boolean moveCar(double moveX, double moveY){
        double moveDistance = 0;            //算出された移動距離のための変数
        double totalDistance = 0;           //取得した総走行距離のための変数
        //引数の座標から移動距離を算出するためのメソッドの呼び出し
        moveDistance = calculateMoveDistance(moveX, moveY);

        //移動距離分の燃料を消費させ、車の現在位置の値を変更するための条件式
        //移動距離が残り燃料より多い場合に実行するための処理
        if(moveDistance > fuel){
            //燃料不足のため移動できないという結果を返却する
            return false;
        //上記条件以外の場合に実行するための処理
        } else {
            //移動距離分燃料を減らすための演算式
            fuel -= moveDistance;
            //現在位置のx座標を変更するための演算式
            x += moveX;
            //現在位置のy座標を変更するための演算式
            y += moveY;


            //走行距離を加算するため、総走行距離を取得する
            totalDistance = En12_1_Car2.getTotalDistanceValue();
            //取得した総走行距離に走行距離を加算する
            totalDistance += moveDistance;
            //総走行距離のフィールド変数に加算した値をセットする
            En12_1_Car2.setTotalDistanceValue(totalDistance);

            //移動完了したという結果を返却する
            return true;
        }

    }


}
