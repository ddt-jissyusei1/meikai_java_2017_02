package ensyuu13;

//左上が直角三角形を表すためのクラス
public class Ensyuu13_2_UpLeftTriangle extends Ensyuu13_2_Triangles {

    //左上直角三角形のためのコンストラクタ
    public Ensyuu13_2_UpLeftTriangle(int heightLength) {
        //親クラスから継承した高さの値のためのコンストラクタ
        super(heightLength);
    }

    //直角三角形の図形情報を表す文字列を呼び出し元に返却するためのメソッド
    public String toString(){
        //図形情報を文字列として呼び出し元に返却する
        return "upLeftTriangle(height:" + getHeightLength() + ")";
    }

    //左上直角三角形を描画するためのメソッド
    @Override
    public void draw() {
        //三角形の高さを出力するための繰り返し処理
        for(int triangleHeightLoop = 0; triangleHeightLoop < getHeightLength(); triangleHeightLoop++){
            //三角形の幅を出力するための繰り返し処理
            for(int triangleWidthLoop = getHeightLength(); triangleWidthLoop > triangleHeightLoop; triangleWidthLoop--){
                //三角形を表すための文字を出力する
                System.out.print('▼');
            }
            //次の行に文字を出力するための改行の出力
            System.out.println();
        }
    }

}
