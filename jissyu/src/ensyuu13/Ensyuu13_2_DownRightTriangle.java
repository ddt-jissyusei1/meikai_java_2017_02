package ensyuu13;

//右下が直角三角形を表すためのクラス
public class Ensyuu13_2_DownRightTriangle extends Ensyuu13_2_Triangles {

    //右下直角三角形のためのコンストラクター
    public Ensyuu13_2_DownRightTriangle(int heightLength) {
        //親クラスから継承した高さの値のためのコンストラクタ
        super(heightLength);
    }

    //右下が直角三角形の図形情報を表す文字列を呼び出し元に返却するためのメソッド
    public String toString(){
        //図形情報を表す文字列を呼び出し元に返却する
        return "DownRightTriangle(Height:" + getHeightLength() + ")";
    }

    //右下直角三角形を表示するための文字を出力するメソッド
    @Override
    public void draw() {
        //直角三角形の高さを出力するための繰り返し処理
        for(int triangleHeightLoop = 0; triangleHeightLoop <= getHeightLength(); triangleHeightLoop++){
            //直角三角形の幅を出力するための繰り返し処理
            for(int triangleWidthLoop = 0; triangleWidthLoop < getHeightLength(); triangleWidthLoop++){
                //右下を直角にするための出力する文字の条件式
                if(triangleWidthLoop < getHeightLength() - triangleHeightLoop){
                    //スペースを先出力する
                    System.out.print('　');
                //上記条件式以外のための出力処理
                }else{
                    //三角形を表す文字を出力する
                    System.out.print('▽');
                }
            }
            //次の行に出力するための改行文字の出力
            System.out.println();

        }


    }

}
