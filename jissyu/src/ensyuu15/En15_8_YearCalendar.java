package ensyuu15;

/**
 * 指定年のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearCalendar extends En15_8_AbsCalendar {
    private int year;                               //表示するカレンダーの年のためのフィールド変数


    //年間カレンダーのためのコンストラクタ
    public En15_8_YearCalendar(int year) {
        this.year = year;           //フィールド変数に引数の値をセットするための代入

    }

    /**フィールド変数の年の値を取得するためのメソッド</br>
     *作成日：2018/07/18</br>
     *作成者：志田</br>
     *
     * @return year 取得した年の値
     */
    public int getYear() {
        return year;
    }


    /**
     * 出力するカレンダーの年の情報を文字列として返却するためのメソッド
     * @return year年 カレンダーの年情報
     *
     */
    @Override
    public String toString() {
        //年の値を取得して文字列として呼び出し元に返却する
        return   getYear() + "年";
    }

    //カレンダーを出力するためのメソッド
    @Override
    public void outputCalendar() {
        //

    }






}
