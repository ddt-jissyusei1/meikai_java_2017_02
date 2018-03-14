package ensyuu13;

//図形の概念を表すための抽象クラス
public abstract class Ensyuu13_1_Shape {

    //図形情報を表す文字列を返却するためのメソッド
    public abstract String toString();

    //図形を描画するための抽象メソッド
    public abstract void draw();

    //図形情報の表示と図形の描画を行うためのメソッド
    public void print(){
        //図形情報を表示するためのメソッドを呼び出して結果を出力する
        System.out.println(toString());
        //図形を描画するための描画するメソッドの呼び出し
        draw();
    }

}
