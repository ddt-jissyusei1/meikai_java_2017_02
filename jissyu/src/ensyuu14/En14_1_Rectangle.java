package ensyuu14;

public class En14_1_Rectangle extends En14_1_Shape implements En14_1_ShapeSizable {
    private int width = 0;                      //幅のためのフィールド変数
    private int height = 0;                     //高さのためのフィールド変数
    private int changeSize = 0;                 //サイズ変更の値のためのフィールド変数

    //長方形を生成するためのコンストラクタ
    public En14_1_Rectangle(int width, int height) {
        this.width = width;                     //引数の幅の値をフィールド変数にセットする
        this.height = height;                   //引数の高さの値をフィールド変数にセットする
    }

    //長方形のサイズ変更のためのコンストラクタ
    public En14_1_Rectangle(int width, int height, int changeSize) {
        this.width = width;                     //引数の幅の値をフィールド変数にセットする
        this.height = height;                   //引数の高さの値をフィールド変数にセットする
        this.changeSize = changeSize;           //引数のサイズ変更の値をフィールド変数にセットする
    }


    //長方形に関する図形情報を表す文字列を返却するためのメソッド
    @Override
    public String toString() {
        //長方形の幅と高さの情報を文字列として返却する
        return "Rectangle(width:" + width + ",height:" + height + ")";
    }

    //長方形を描画するためのメソッド
    @Override
    public void draw() {
        //長方形の高さを描画するための繰り返し処理
        for(int drawHeightLoop = 0; drawHeightLoop < height; drawHeightLoop++){
            //長方形の幅を描画するための繰り返し処理
            for(int drawWidthLoop = 0; drawWidthLoop < width; drawWidthLoop++){
                //長方形を表すための文字を出力する
                System.out.print('■');
            }
            //次の行に出力するための改行の出力
            System.out.println();
        }

    }

    //長方形を拡大するためのメソッド
    public void expandShape(){

        //高さを拡大するためにフィールド変数に値を加算する
        this.height += changeSize;
        //幅を拡大するためにフィールド変数に値を加算する
        this.width += changeSize;
    }

    //長方形を縮小するためのメソッド
    public void shrinkShape() {

        //高さを縮小するためにフィールド変数に値を減算する
        this.height -= changeSize;
        //幅を縮小するためにフィールド変数に値を減算する
        this.width -= changeSize;
    }

}
