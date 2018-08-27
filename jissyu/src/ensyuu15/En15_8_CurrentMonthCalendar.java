package ensyuu15;

import static java.util.Calendar.*;

import java.util.GregorianCalendar;

/**
 * 現在の月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_CurrentMonthCalendar extends En15_8_AbsCalendar {
    private int currentYear;                                        //現在年のためのフィールド変数
    private int currentMonth;                                       //現在月のためのフィールド変数
    private int firstDay = 1;                                       //月の初日のためのフィールド変数
    GregorianCalendar calendarToday = new GregorianCalendar();       //現在日時取得のためのカレンダークラスのインスタンスの宣言

    public En15_8_CurrentMonthCalendar(){
        this.currentYear = calendarToday.get(YEAR);                 //フィールド変数に現在年をセットするための代入
        this.currentMonth = calendarToday.get(MONTH)+1;             //フィールド変数に現在月をセットするための代入
    }

    /**
     * 現在年のフィールド値を取得するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return cuurentYear 取得した現在年の値
     */
    public int getCurrentYear() {
        //取得した値を呼び出しもとに返却する
        return currentYear;
    }

    /**
     * 現在月のフィールド値を取得するためのメソッド
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return currentMonth 取得した現在月の値
     */
    public int getCurrentMonth() {
        //取得した値を呼び出しもとに返却する
        return currentMonth;
    }

    /**
     * 月の初日のフィールド値を取得するためのメソッド
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return firstDay 取得した開始日の値
     */
    public int getFirstDay() {
        //取得した値を呼び出しもとに返却する
        return firstDay;
    }

    /**
     * カレンダー情報を表示するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成日：志田</br>
     *
     *@return String 表示するカレンダー情報の文字列
     */
    @Override
    public String toString() {
        //取得した年と月の値を文字列にして呼び出し元に返却する
        return "コマンドライン引数がないので、\n現在月のカレンダーを表示します。\n\n"
                                       +calendarToday.get(YEAR) + "年" + calendarToday.get(MONTH) + "月";
    }

    /**
     * 現在月のカレンダーを表示するためのメソッド</br>
     * 作成日：2018/08/20</br>
     * 作成者：志田
     */
    @Override
    public void outputCalendar() {
        //各月の最大日数のための配列の宣言
        int[] monthMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //閏年であった場合、2月の最大日数に1加算するための条件式
        if(calendarToday.isLeapYear(currentYear)){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        int maxDays = monthMaxDays[getCurrentMonth() -1];         //現在月の最大日数を取得しループ制御で使用するため変数に保持する

        int day = getFirstDay();                                  //日を加算し表示するための変数
        int startDay = calendarToday.get(GregorianCalendar.DAY_OF_WEEK);  //現在月の開始曜日を取得し保持するための変数

        //曜日のヘッダーを表示するための出力
        System.out.println("日　月　火　水　木　金　土");

        //現在月のカレンダーを出力するための繰り返し処理
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
