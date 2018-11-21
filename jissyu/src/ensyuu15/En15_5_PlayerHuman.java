package ensyuu15;

//人間プレイヤーのためのクラス
public class En15_5_PlayerHuman extends En15_5_Player {

    //ユーザーが出す手のためのフィールド変数
    public static int playerHumanHand;

    //ユーザーが出す手のためのコンストラクタ
    public En15_5_PlayerHuman(int userHand){
        //引数の値をフィールド変数に設定する
        playerHumanHand = userHand;
    }

    /**
     * フィールド変数の値を取得するためのゲッターメソッド
     * 作成者：志田
     * 作成日：20180704
     * @return playerHumanHand ユーザーの手の値を返却する
     */
    public static int getUserHand(){
        //呼び出し元に取得した値を返却する
        return playerHumanHand;
    }

    /**
     * プレーヤー情報を文字列として返却するためのメソッド
     */
    @Override
    public String toString() {
        //プレイヤーがユーザーである情報を文字列として呼び出しもとに返却する
        return "ユーザー：";
    }

    /**
     *ユーザーが出す手を表示するためのメソッド
     */
    @Override
    public void showHands() {
        //ジャンケンの手のための配列
        String[] jankenHands = {"グー","チョキ","パー"};

        //ユーザーが出す手を表示するためのメソッド
        System.out.println(toString() + jankenHands[playerHumanHand]);

    }

}
