package ensyuu13;

import java.util.Random;

//コンピュータプレーヤーのためのクラス
public class Ensyuu13_3_PlayerCom extends Ensyuu13_3_Player {

    //コンピュータが出す手のためのフィールド変数
    public static int comHand;

    //コンピュータの出す手を生成するためのコンストラクタ
    public Ensyuu13_3_PlayerCom() {
        //乱数を生成するためのコード
        Random randomComHand = new Random();
        //生成した乱数の値をフィールド変数に代入する
        Ensyuu13_3_PlayerCom.comHand = randomComHand.nextInt(3);
    }

    //フィールド変数の値を取得するためのゲッター
    public static int getComHand() {
        //呼び出し元の取得した値を返却する
        return comHand;
    }

    //プレイヤー情報を文字列として返却するためのメソッド
    @Override
    public String toString() {
        //プレイヤーがコンピュータである情報を呼び出し元に返却する
        return "コンピュータ：";
    }

    //コンピュータが出す手を表示するためのメソッド
    @Override
    public void showHands() {
        //ジャンケンの手のための配列
        String[] jankenHands ={"グー","チョキ","パー"};
        //コンピュータが出す手を表示するための出力
        System.out.println(jankenHands[comHand]);

    }




}
