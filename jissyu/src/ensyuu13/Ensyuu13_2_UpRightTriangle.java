package ensyuu13;

//右上が直角三角形を表すためのクラス
public class Ensyuu13_2_UpRightTriangle extends Ensyuu13_2_Triangles {

    //右上直角三角形を表すためのコンストラクタ
    public Ensyuu13_2_UpRightTriangle(int heightLength) {
        //親クラスから継承した高さの値のためのコンストラクタ
        super(heightLength);
    }

    //右上直角三角形の図形情報を表す文字列を呼び出し元に返却するためのメソッド
    public String toString(){
        //右上直角三角形の図形情報を表す文字列を呼び出し元に返却する
        return "upRightTriangle(Height:" + getHeightLength() + ")";
    }

    //右上直角三角形を描画するためのメソッド
    @Override
    public void draw() {
        //三角形の高さを出力するための繰り返し処理
        for(int triangleHeightLoop = 0; triangleHeightLoop < getHeightLength(); triangleHeightLoop++){
            //三角形の幅を出力するための繰り返し処理
            for(int triangleWidthLoop = 0; triangleWidthLoop < getHeightLength(); triangleWidthLoop++){
                //三角形を表す文字を出力するための条件式
                if(triangleWidthLoop < triangleHeightLoop){
                    //三角形を描画する文字を出力する
                    System.out.print('　');
                //上記以外の場合の条件式
                }else{
                    //三角形を表すためのスペースを出力する
                    System.out.print('▽');
                }
            }
            //次の行に出力するための改行の出力
            System.out.println();
        }

    }

}
