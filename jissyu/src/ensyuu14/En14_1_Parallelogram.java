package ensyuu14;

//平行四辺形のためのクラス
public class En14_1_Parallelogram extends En14_1_Shape implements En14_1_ShapeSizable {
    private int width;                      //底辺の幅のためのフィールド変数
    private int height;                     //高さのためのフィールド変数
    private int changeSize = 0;                 //サイズ変更の値のためのフィールド変数


    //平行四辺形のためのコンストラクタ
    public En14_1_Parallelogram(int width, int height){
        this.width = width;                 //引数の幅の値をフィールド変数にセットする
        this.height = height;               //引数の高さの値をフィールド変数にセットする
    }

    //平行四辺形のサイズ変更のためのコンストラクタ
    public En14_1_Parallelogram(int width, int height, int changeSize){
        this.width = width;                 //引数の幅の値をフィールド変数にセットする
        this.height = height;               //引数の高さの値をフィールド変数にセットする
        this.changeSize = changeSize;           //引数のサイズ変更の値をフィールド変数にセットする
    }

    //平行四辺形を表す情報を文字列として返却するためのメソッド
    @Override
    public String toString() {
        //平行四辺形の高さと幅の値を文字列として呼び出し元に返却する
        return "Parallelogram(width:" + width + ",height:" + height + ")";
    }

    //平行四辺形を描画するためのメソッド
    @Override
    public void draw() {
        //平行四辺形の高さを描画するための繰り返し処理
        for(int drawHeightLoop = 0; drawHeightLoop < height; drawHeightLoop++){
            //平行四辺形の幅を描画するために出力する空白のための繰り返し処理
            for(int drawWidthLoop = 0; drawWidthLoop < height - drawHeightLoop ; drawWidthLoop++){
                //平行四辺形を形づくるための半角スペースの出力
                System.out.print(' ');
            }
            //平行四辺形の幅を描画するために出力する文字のための繰り返し処理
            for(int drawWidthLoop = 0; drawWidthLoop < width; drawWidthLoop++){
                //平行四辺形を形づくるための文字の出力
                System.out.print('#');
            }
            //次の行に出力するための改行の出力
            System.out.println();
        }

    }

    //平行四辺形の大きさを拡大するためのメソッド
    public void expandShape(){

        //高さを拡大するためにフィールド変数に値を加算する
        this.height += changeSize;
        //幅を拡大するためにフィールド変数に値を加算する
        this.width += changeSize;

    }

    //平行四辺形の大きさを縮小するためのメソッド
    public void shrinkShape() {

        //高さを縮小するためにフィールド変数に値を減算する
        this.height -= changeSize;
        //幅を縮小するためにフィールド変数に値を減算する
        this.width -= changeSize;

    }

}
