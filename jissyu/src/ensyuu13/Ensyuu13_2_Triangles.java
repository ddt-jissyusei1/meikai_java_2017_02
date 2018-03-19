package ensyuu13;

//直角二等辺三角形のための抽象クラス
public abstract class Ensyuu13_2_Triangles extends Ensyuu13_1_Shape {

    //高さの長さを表すフィールド
    private int heightLength;

    //三角形を生成するためのコンストラクタ
    public Ensyuu13_2_Triangles(int heightLength){
        setHeightLength(heightLength);

    }

    //高さの値を取得するためのメソッド
    public int getHeightLength() {
        //取得した値を呼び出し元に返却する
        return heightLength;
    }

    //高さの値をフィールド変数に設定する
    public void setHeightLength(int heightLength) {
        //引数の値を高さのためのフィールド変数に代入する
        this.heightLength = heightLength;
    }

    //二等辺三角形に関する図形情報を表す文字列を返却するためのメソッド
    public String toString(){
        //図形情報を表す文字列を呼び出し元に返却する
        return "Triangle(height:" + heightLength + ")";
    }





}
