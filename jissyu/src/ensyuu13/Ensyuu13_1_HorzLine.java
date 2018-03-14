package ensyuu13;

//水平直線を表すためのクラス
public class Ensyuu13_1_HorzLine extends Ensyuu13_1_AbstLine {

    //水平直線を生成するためのコンストラクタ
    public Ensyuu13_1_HorzLine(int length) {
        //継承した親クラスのコンストラクタを利用して引数の値をセットする
        super(length);
    }

    //水平直線に関する図形情報を表す文字列を返却するためのメソッド
    public String toString(){
        //水平直線を表す図形情報を表す文字列を呼び出しもとに返却する
        return "HorzLine(length:" + getLength() + ")";
    }

    //水平直線を描画するためのメソッド
    public void draw(){
        //文字列の長さだけ記号を出力するための繰り返し処理
        for(int drawHorzLineLoop = 1; drawHorzLineLoop <= getLength(); drawHorzLineLoop++){
            //水平線を表す記号を表示するための出力
            System.out.print('-');
        }
        //次の行に処理を出力するための改行出力
        System.out.println();
    }

}
