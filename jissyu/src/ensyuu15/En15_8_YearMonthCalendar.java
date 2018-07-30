package ensyuu15;

/**
 * 指定年月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearMonthCalendar extends En15_8_AbsCalendar {
    private int year;                               //年の値のためのフィールド変数
    private int month;                              //月の値のためのフィールド変数

    //指定年月カレンダーのためのコンストラクタ
    public En15_8_YearMonthCalendar(String year, String month) {
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
    }

    //年の値を取得するためのメソッド
    public int getYear() {
        //取得した年の値を呼び出し元に返却する
        return year;
    }

    //月の値を取得するためのメソッド
    public int getMonth() {
        return month;
    }

    /**
     * 出力する年月のカレンダー情報を文字列として返却するためのメソッド
     */
    @Override
    public String toString() {
        //取得した年と月の値を文字列にして呼び出し元に返却する
        return getYear() + "年" + getMonth() + "月";
    }

    /**
     * 日付から月の開始曜日を求めるためのメソッド
     * @return
     *
     *
     */
    @Override
    public int dayOfWeek() {
        return 0;
        //

    }

    /**
     *指定年月のカレンダーを表示するためのメソッド</br>
     *作成日：2018/07/18</br>
     *作成者：志田
     */
    @Override
    public void outputCalendar() {
        //

    }


}
