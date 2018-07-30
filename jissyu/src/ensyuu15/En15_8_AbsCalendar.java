package ensyuu15;

/*
 *コマンドライン引数の値で表示するカレンダーのための抽象クラス
 */
public abstract class En15_8_AbsCalendar {

    //出力するカレンダー情報を返却するためのメソッド
    public abstract String toString();

    //曜日を求めるためのメソッド
    public abstract int dayOfWeek();

    //カレンダーを出力するためのメソッド
    public abstract void outputCalendar();

}
