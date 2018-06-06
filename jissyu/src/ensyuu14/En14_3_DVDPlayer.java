package ensyuu14;

//DVDプレーヤのためのクラス
public class En14_3_DVDPlayer implements En14_3_IFExPlayer {

    //再生を実行するためのメソッド
    @Override
    public void play() {
        //再生を開始したことを通知するための文の出力
        System.out.println("■DVD再生開始！\n\n再生中・・・");

    }

    //再生を停止するためのメソッド
    @Override
    public void stop() {
        //再生を停止したことを通知するための文の出力
        System.out.println("□DVD停止！");

    }

    //スロー再生するためのメソッド
    @Override
    public void slow() {
        //スロー再生を開始したことを通知するための文の出力
        System.out.println("◆DVDスロー再生開始！\n\nスロー再生中～・・・");

    }

}
