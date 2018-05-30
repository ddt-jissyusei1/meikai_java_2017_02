package ensyuu14;

//ペットクラスを継承したロボットペットクラス
public class En14_2_RobotPet extends En14_2_Pet implements En14_2_IFPetIntroduce, En14_2_IFPetSkinColor {
    private int petSkin;                       //ペットの色のためのフィールド変数


    //ロボットペットのコンストラクタ
    public En14_2_RobotPet(String name, String masterName) {
        super(name,masterName);                //親クラスから継承いたコンストラクタ
    }

    //ロボットペットの自己紹介のためのメソッド
    public void introduce(){
        //自己紹介する文を表示するための出力
        System.out.println("◇私はロボット。名前は" + getName() + "。");
        //飼い主の名前を紹介する文を表示するための出力
        System.out.println("◇ご主人様は" + getMasterName() + "。");
        //色の情報を文字列として表示するための出力
        System.out.println("◇私の色は" + toString() + "です。");
    }

    //ペットの色を設定するためのメソッド
    @Override
    public void changePetSkin(int skinColor) {
        //引数の値を色のフィールド変数にセットする
        this.petSkin = skinColor;
        //変更した色を告げる文を表示するための出力
        System.out.println("ロボットペットの色を" + toString() + "に変更しました。");
    }

    //ロボットペットを着せ替えする色を文字列情報にするためのメソッド
    public String toString(){
        //色のフィールド変数の値で呼び出す色を変更するための分岐処理
        switch(petSkin){
            //引数の値が白色の定数1の場合の分岐
            case WHITE:
                //白色を返却する
                return "白色";

            //引数の値が黒色の定数1の場合の分岐
            case BLACK:
                //黒色を返却する
                return "黒色";

            //引数の値が銀色の定数2の場合の分岐
            case SILVER:
                //銀色を返却する
                return "銀色";

            //引数の値が赤色の定数3の場合の分岐処理
            case RED:
                //赤色を返却する
                return "赤色";

            //引数の値が青色の定数4の場合の分岐処理
            case BLUE:
                //青色を返却する
                return "青色";

            //引数の値が緑色の定数5の場合の分岐処理
            case GREEN:
                //色を緑色にセットする
                return "緑色";
        }
        //引数の値が上記以外の場合無地を返却する
        return "無地";
    }




}
