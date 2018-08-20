package ensyuu15;

/*
 *コマンドライン引数の値で表示するカレンダーのための抽象クラス
 */
public abstract class En15_8_AbsCalendar {

    //出力するカレンダー情報を返却するためのメソッド
    public abstract String toString();

    //閏年判定をするためのメソッド
    public abstract boolean isLeap(int year);

    //曜日を求めるためのメソッド
    public abstract int dayOfWeek();

    //カレンダーを出力するためのメソッド
    public abstract void outputCalendar();

    //カレンダーを表示するためのメソッド
    public void showCalendar(){
        //カレンダー情報を出力するための文字列メソッドの呼び出し
        System.out.println(toString());
        //カレンダー出力メソッドの呼び出し
        outputCalendar();
    }

}
