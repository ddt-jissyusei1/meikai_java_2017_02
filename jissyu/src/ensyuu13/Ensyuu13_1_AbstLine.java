package ensyuu13;

//直線のための抽象クラス
public abstract class Ensyuu13_1_AbstLine extends Ensyuu13_1_Shape {

    private int length;         //直線の長さを表すint型のフィールドです。

    //直線を生成するコンストラクタ
    public Ensyuu13_1_AbstLine(int length){
        //引数で受け取った値をセッターメソッドを使用してフィールド変数にセットする
        setLength(length);
    }

    //直線の長さを取得するためのゲッター
    public int getLength(){
        //呼び出し元に取得した長さの値を返却する
        return length;
    }

    //直線の長さを設定するためのセッター
    public void setLength(int length) {
        //引数で受け取った値をフィールド変数にセットする
        this.length = length;

    }

    //直線に関する図形情報を表す文字列を返却する
    public String toString() {
        //呼び出し元に直線の長さの文字列を返却する
        return "AbstLine(length:" + length + ")";
    }


}
