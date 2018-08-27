package ensyuu13;

//垂直直線を表すためのクラス
public class Ensyuu13_1_VertLine extends Ensyuu13_1_AbstLine {

    //垂直直線を生成するためのコンストラクタ
    public Ensyuu13_1_VertLine(int length) {
        //継承した親クラスのコンストラクタを使用して引数の値をフィールドにセットする
        super(length);
    }

    //垂直直線に関する図形情報を表す文字列を返却するためのメソッド
    public String toString(){
        //呼び出し元に垂直直線を表す文字列を返却する
        return "VertLine(length:" + getLength() + ")";
    }

    //垂直直線を描画するためのメソッド
    public void draw(){
        //垂直直線の長さだけ縦線記号を出力するための繰り返し処理
        for(int drawVertLineLoop = 1; drawVertLineLoop <= getLength(); drawVertLineLoop++){
            //垂直直線を描画するための記号を表示するための出力
            System.out.print('|');
            //次の行に出力するための改行の出力
            System.out.println();
        }

    }

}
