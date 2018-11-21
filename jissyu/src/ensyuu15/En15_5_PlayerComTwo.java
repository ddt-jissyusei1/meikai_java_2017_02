package ensyuu15;

import java.util.Random;

//コンピュータプレーヤ２のためのクラス
public class En15_5_PlayerComTwo extends En15_5_Player {

    //コンピュータ２が出す手のためのフィールド変数
    public static int comTwoHand;

    //コンピュータの出す手を生成するためのコンストラクタ
    public En15_5_PlayerComTwo(){
        //乱数を生成するためのコード
        Random randomComTwoHand = new Random();

        //生成した乱数の値をフィールド変数に代入する
        comTwoHand = randomComTwoHand.nextInt(3);
    }

    /**
     * フィールド変数の値を取得するためのゲッター
     * 作成者：志田
     * 作成日：20180704
     * @return comTwoHand　生成された手の値を返却
     */
    public static int getComTwoHand(){
        //呼び出し元に取得した値を返却する
        return comTwoHand;
    }

    /**
     * プレイヤー情報を文字列として返却するためのメソッド
     * 作成者：志田
     * 作成日：20180704
     */
    @Override
    public String toString() {
        //プレイヤーがコンピュータ２である情報を呼び出し元に返却する
        return "コンピュータ２：";
    }

    /**
     * コンピュータが出す手を表示するためのメソッド
     * 作成者：志田
     * 作成日：20180704
     */
    @Override
    public void showHands() {
        //ジャンケンの手のための配列
        String[] jankenHands = {"グー","チョキ","パー"};

        //コンピュータが出す手を表示するための出力
        System.out.println(toString() + jankenHands[comTwoHand]);
    }

}
