package ensyuu13;

//左下が直角三角形を表すためのクラス
public class Ensyuu13_2_DownLeftTriangle extends Ensyuu13_2_Triangles {

    //左下直角三角形のためのコンストラクタ
    public Ensyuu13_2_DownLeftTriangle(int heightLength) {
        //親クラスから継承した高さの値のコンストラクタ
        super(heightLength);
    }

    //左下が直角三角形の図形情報を表す文字列を呼び出し元に返却するためのメソッド
    public String toString(){
        //図形情報を表す文字列を呼び出し元に返却する
        return "DownLeftTriangle(heightLength:" + getHeightLength() + ")";
    }

    //左下直角三角形を描画するためのメソッド
    @Override
    public void draw() {
        //直角三角形の高さを出力するための繰り返し処理
        for(int triangleHeightLoop = 0; triangleHeightLoop <= getHeightLength(); triangleHeightLoop++){
            //左下直角三角形の列（幅）を出力するための繰り返し処理
            for(int triangleLengthLoop = 0; triangleLengthLoop < triangleHeightLoop; triangleLengthLoop++){
                //三角形を表すための文字の出力
                System.out.print('▲');
            }
            //次の行に出力するための改行を出力
            System.out.println();
        }
    }

}
