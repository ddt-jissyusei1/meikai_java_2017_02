package ensyuu13;

//点を表すためのクラス
public class Ensyuu13_1_Point extends Ensyuu13_1_Shape {

    //点を生成するためのコンストラクタ
    public Ensyuu13_1_Point(){

    }

    //点に関する図形情報を表す文字列を返却するためのメソッド
    public String toString(){

        //点という意味の文字列を返却する
        return "\nPoint";
    }

    //点を描画するためのメソッド
    public void draw() {
        //点を描画するための文字の出力
        System.out.println('+');

    }

}
