package ensyuu14;

//ペットの模様のためのインタフェース
public interface En14_2_IFPetSkinColor {
    int WHITE = 0;              //白色のための定数
    int BLACK = 1;              //黒色のための定数
    int SILVER = 2;             //銀色のための定数
    int RED = 3;                //赤色のための定数
    int BLUE = 4;               //青色のための定数
    int GREEN = 5;              //緑色のための定数

    //着せ替えするためのメソッドの呼び出し
    public void changePetSkin(int skin);
}
