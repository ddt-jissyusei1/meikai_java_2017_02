package ensyuu15;

/**
 * 指定年月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearMonthCalendar extends En15_8_AbsCalendar {
    private int year;                                       //年の値のためのフィールド変数
    private int month;                                      //月の値のためのフィールド変数
    private int day = 1;                                    //月の開始日のためのフィールド変数

    //指定年月カレンダーのためのコンストラクタ
    public En15_8_YearMonthCalendar(String year, String month) {
        this.year = Integer.parseInt(year);                 //年のフィールド変数に第一引数の値をセットするための代入
        this.month = Integer.parseInt(month);               //月のフィールド変数に第二引数の値をセットするための代入
    }

    /**
     * 年の値を取得するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return year 取得した年の値
     */
    public int getYear() {
        //取得した年の値を呼び出し元に返却する
        return year;
    }

    /**
     * 月の値を取得するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return month 取得した月の値
     */
    public int getMonth() {
        //取得した月の値を呼び出し元に返却する
        return month;
    }

    /**
     * 日の値を取得するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return day 取得した日の
     */
    public int getDay(){
        //取得した日の値を呼び出し元に返却する
        return day;
    }

    /**
     * 出力する年月のカレンダー情報を文字列として返却するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return String 表示する内容の説明と年月の文字列
     */
    @Override
    public String toString() {
        //取得した年と月の値を文字列にして呼び出し元に返却する
        return "コマンドライン引数が年と月のため、その年月のカレンダーを表示します。\n\n"
                                                                        +getYear() + "年" + getMonth() + "月";
    }

    /**
     * 閏年を判定するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return boolean 閏年判定の式の真偽値
     */
    @Override
    public boolean isLeap(int year){
        //引数の年から閏年であるか計算し、真偽値を呼び出し元に返却する
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 日付から月の開始曜日を求めるためのメソッド</br>
     * 作成日：2018/08/22</br
     * 作成者：志田</br>
     *
     * @return int 月の開始曜日の値
     */
    @Override
    public int dayOfWeek() {
        int yearOfWeek = getYear();                         //フィールド変数の年の値の取得
        int monthOfWeek = getMonth();                       //フィールド変数の月の値の取得

        //月の値が１または２の場合に年月の値を調整するための条件式
        if(monthOfWeek == 1 || monthOfWeek ==2){
            //年の値を1減算する
            yearOfWeek--;
            //月の値に12加算代入する
            monthOfWeek += 12;
        }
        //フィールドの年月日の値から月の開始曜日を求め、その値を呼び出し元に返却する
        return (yearOfWeek + yearOfWeek / 4 - yearOfWeek / 100 + yearOfWeek / 400 + (13*monthOfWeek + 8) / 5 + day) % 7;
    }

    /**
     *指定年月のカレンダーを表示するためのメソッド</br>
     *作成日：2018/08/22</br>
     *作成者：志田
     */
    @Override
    public void outputCalendar() {
      //各月の最大日数のための配列の宣言
        int[] monthMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //閏年であった場合、2月の最大日数に1加算するための条件式
        if(isLeap(getYear())){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        int maxDays = monthMaxDays[getMonth() -1];         //指定月の最大日数を取得しループ制御で使用するため変数に保持する
        int day = getDay();                                //日を加算し表示するための変数
        int startDay = dayOfWeek();
        //曜日のヘッダーを表示するための出力
        System.out.println("日　月　火　水　木　金　土");

        //指定月のカレンダーを出力するための繰り返し処理
        for(int weekLoop = 0; day <= maxDays; weekLoop++){
            //一週間分の日にちを出力するための繰り返し処理
            for(int weekdayLoop = 0; weekdayLoop < 7; weekdayLoop++){
                //月の開始曜日から出力開始するための条件式
                if(weekdayLoop >= startDay && weekLoop == 0 || day > 1 && day <= maxDays){
                    //日にちを表示するための出力
                    System.out.printf("%02d  ",day);
                    //次の日の表示のため日にちを1日加算する
                    day++;
                //日曜始まり土曜終わり以外の場合に実行する処理のための条件分岐
                } else {
                    //空白を表示するための出力
                    System.out.print("    ");
                }
            }
            //次の行に表示するための改行の出力
            System.out.println();
        }

    }




}
