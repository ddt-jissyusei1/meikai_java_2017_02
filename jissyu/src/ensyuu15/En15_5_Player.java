package ensyuu15;

//ジャンケンのプレーヤのためのプレーヤ抽象クラス
public abstract class En15_5_Player {

    //プレーヤ情報を文字列として表示するための抽象メソッド
    public abstract String toString();

    //ジャンケンの手の情報を表示するための抽象メソッド
    public abstract void showHands();

    //プレーヤの出す手を表示するためのメソッド
    public void showPlayerHand(){
        //プレイヤー情報を表示するための出力
        System.out.println(toString());

        //プレイヤーが出した手を表示するためのメソッド
        showHands();
    }



}
