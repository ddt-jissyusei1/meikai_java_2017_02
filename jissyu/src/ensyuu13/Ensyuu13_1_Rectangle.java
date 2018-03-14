package ensyuu13;

//長方形を表すためのクラス
public class Ensyuu13_1_Rectangle extends Ensyuu13_1_Shape {

    private int width;      //長方形の幅を表すためのフィールド
    private int height;     //長方形の高さを表すためのフィールド

    //長方形を生成するためのコンストラクタ
    public Ensyuu13_1_Rectangle(int width, int height){
        this.width = width;             //引数の幅の値をフィールド変数にセットする
        this.height = height;           //引数の高さの値をフィールド変数にセットする
    }

    //長方形の図形情報を表す文字列を返却するためのメソッド
    public String toString(){
        //長方形を表す情報を文字列として返却する
        return "Rectangle(width:" + width + ", height:" + height + ")";
    }

    //長方形を描画するためのメソッド
    public void draw(){
        //長方形を描画するための行の繰り返し処理
        for(int drawRecRowLoop = 1; drawRecRowLoop <= height; drawRecRowLoop++){
            //長方形を描画するための列の繰り返し処理
            for(int drawRecLineLoop = 1; drawRecLineLoop <= width; drawRecLineLoop++){
                //長方形を描画するための記号の出力
                System.out.print('*');
            }
            //次の行に出力するための改行の出力
            System.out.println();
        }
    }

}

