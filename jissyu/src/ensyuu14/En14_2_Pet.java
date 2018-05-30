package ensyuu14;

//ペットクラス
public abstract class En14_2_Pet implements En14_2_IFPetIntroduce, En14_2_IFPetSkinColor{
    private String name;                    //ペットの名前のフィールド変数
    private String masterName;              //飼い主の名前のフィールド変数
    //private int petSkin;                  //ペットの色のためのフィールド変数


    //ペットのコンストラクタ
    public En14_2_Pet(String name, String masterName) {
        this.name = name;                   //第一引数の値をペットの名前フィールド変数に代入する
        this.masterName = masterName;       //第二引数の値を飼い主の名前フィールド変数に代入する
    }


    //ペットの名前を取得するためのゲッターメソッド
    public String getName() {
        //呼び出し元に取得した値を返却する
        return name;
    }

    //飼い主の名前を取得するためのゲッターメソッド
    public String getMasterName() {
        //呼び出し元に取得した値を返却する
        return masterName;
    }

    //自己紹介のためのメソッド
    public void introduce(){
        System.out.println("■僕の名前は" + name + "です！");
        System.out.println("■ご主人様は" + masterName + "です！");
    }













}
