package ensyuu15;

import java.util.Random;

//コンピュータープレイヤー1のためのクラス
public class En15_5_PlayerComOne extends En15_5_Player {

    //コンピュータ1が出す手のためのフィールド変数
    public static int comOneHand;

    //コンピュータの出す手を生成するためのコンストラクタ
    public En15_5_PlayerComOne(){
        //乱数を生成するためのコード
        Random randomComOneHand = new Random();

        //生成した乱数の値をフィールド変数に代入する
        comOneHand = randomComOneHand.nextInt(3);
    }

    //フィールド変数の値を取得するためのゲッター
    public static int getComOneHand(){
        //呼び出し元に取得した値を返却する
        return comOneHand;
    }

    //プレイヤー情報を文字列として返却するためのメソッド
    @Override
    public String toString() {
        //プレイヤーがコンピュータである情報を呼び出し元に返却する
        return "コンピュータ１：";
    }

    //コンピュータが出す手を表示するためのメソッド
    @Override
    public void showHands() {
        //ジャンケンの手のための配列
        String[] jankenHands = {"グー","チョキ","パー"};

        //コンピュータが出す手を表示するための出力
        System.out.println(toString() + jankenHands[comOneHand]);

    }


}
