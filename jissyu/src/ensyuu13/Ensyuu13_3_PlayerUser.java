package ensyuu13;

//ユーザープレイヤーのためのクラス
public class Ensyuu13_3_PlayerUser extends Ensyuu13_3_Player {

    //ユーザーが出す手のためのフィールド変数
    public static int userHand;

    //ユーザーが出す手のためのコンストラクタ
    public Ensyuu13_3_PlayerUser(int userHand) {
        //引数の値をフィールド変数に設定する
        Ensyuu13_3_PlayerUser.userHand = userHand;
    }

    //フィールド変数を取得するためのゲッター
    public static int getUserHand() {
        //呼び出し元に取得した値を返却する
        return userHand;
    }

    //プレイヤー情報を文字列として返却するためのメソッド
    @Override
    public String toString() {
        //プレイヤーがユーザーである情報を文字列として呼び出し元に返却する
        return "ユーザー：";
    }

    //ユーザーが出す手を表示するためのメソッド
    @Override
    public void showHands() {
        //ジャンケンの手のための配列
        String[] jankenHands ={"グー","チョキ","パー"};
        //ユーザーが出す手を表示するためのメソッド
        System.out.println(jankenHands[userHand]);

    }





}
