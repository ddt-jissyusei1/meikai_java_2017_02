package ensyuu14;

//図形を表すための抽象クラス
public abstract class En14_1_Shape implements En14_1_ShapeSizable {

    //図形を表す文字列を返却するためのメソッド
    public abstract String toString();

    //図形を描画するためのメソッド
    public abstract void draw();

    //図形情報の表示と描画をするためのメソッド
    public void print(){
        //図形情報を文字列として表示するための出力
        System.out.println(toString());
        //図形を描画するためのメソッドの呼び出し
        draw();
    }
}
