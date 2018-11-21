package ensyuu14;

//ペットの模様のためのインタフェース
public interface Skinnable {
    int BLACK = 0;                //黒色のための定数
    int RED = 1;                  //銀色のための定数
    int BLUE = 2;                 //赤色のための定数
    int GREEN = 3;                //青色のための定数
    int LEOPARD = 4;              //緑色のための定数

    //着せ替えするためのメソッドの呼び出し
    public void changeSkin(int skin);
}
