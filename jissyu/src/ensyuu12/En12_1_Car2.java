package ensyuu12;

/*
 * 走行距離を表すフィールドと、その値を調べるメソッドを追加した自動車クラスを作成せよ。
 * 自動車クラスCar第２版（p.324）から派生すること
 */

//En12_1_Carクラスを継承したクラス
public class En12_1_Car2 extends En12_1_Car {
        private double mTotalDistanceValue;                  //車の総走行距離のためのフィールド変数


    //親クラスから継承したコンストラクタ
    public En12_1_Car2(String name, int width, int height, int length, double x, double y, double fuel,
                      En12_1_Day purchaseDay, double tankAmount, int carNumber, int fuelEconomy) {
        //継承したスーパークラスのコンストラクタを呼び出す
        super(name, width, height, length, x, y, fuel, purchaseDay, tankAmount, carNumber, fuelEconomy);

        //フィールド変数に初期値として0を代入する
        this.mTotalDistanceValue = 0;
    }


    //走行距離の値を取得するためのメソッド
    public double getTotalDistanceValue() {
        //呼び出し元に取得した値を返却する
        return mTotalDistanceValue;
    }

    //走行距離の値をセットするためのメソッド
    public void setTotalDistanceValue(double distanceValue) {
        //走行距離のフィールド変数に仮引数の値を代入する
        mTotalDistanceValue = distanceValue;
    }





}
