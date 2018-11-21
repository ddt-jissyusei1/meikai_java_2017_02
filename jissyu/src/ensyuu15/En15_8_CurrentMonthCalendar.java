package ensyuu15;

import static java.util.Calendar.*;

import java.util.Calendar;

/**
 * 現在の月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_CurrentMonthCalendar extends En15_8_AbsCalendar{
    private int currentYear;                                        //現在年のためのフィールド変数
    private int currentMonth;                                       //現在月のためのフィールド変数
    private int firstDay;                                           //月の初日のためのフィールド変数

    public En15_8_CurrentMonthCalendar(){
        Calendar currentCalendar = Calendar.getInstance();
        this.currentYear = currentCalendar.get(YEAR);       //フィールド変数に現在年をセットするための代入
        this.currentMonth = currentCalendar.get(MONTH)+1;   //フィールド変数に現在月をセットするための代入
        this.firstDay = En15_8_OutputCalendarsCommonProcesses.baseDay;              //フィールド変数に月の初日をセットするための代入
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
                                       +getCurrentYear() + "年" + getCurrentMonth() + "月";
    }

    /**
     * 現在月のカレンダーを表示するためのメソッド</br>
     * 作成日：2018/08/20</br>
     * 作成者：志田
     *
     * @param currentYear  現在年の値のための変数
     * @param currentMonth 現在月の値のための変数
     * @param maxDays      月の最大日数のための変数
     * @param firstDay     月の開始日の値のための変数
     * @paramstartWeekDay 月の開始曜日の値のための変数
     * @param weekLoop     週ごとの繰り返しのためのカウンタ変数
     * @param weekdayLoop  週の日にちごとの繰り返しのためのカウンタ変数
     */
    @Override
    public void outputCalendar() {
        //現在年の値の取得
        int currentYear = getCurrentYear();
        //現在月の値の取得
        int currentMonth = getCurrentMonth();

        //現在月の最大日数を取得しループ制御で使用するため変数に保持する
        int maxDays = En15_8_OutputCalendarsCommonProcesses.getMonthMaxDays(currentYear, currentMonth-1);

        int firstDay = getFirstDay();                                               //日を加算し表示するための変数
        int startWeekDay = En15_8_OutputCalendarsCommonProcesses.getWeekDay(currentYear,currentMonth-1);  //現在月の開始曜日を取得し保持するための変数

        //曜日のヘッダーを表示するための出力
        En15_8_OutputCalendarsCommonProcesses.outputWeekHeader();

        //現在月のカレンダーを出力するための繰り返し処理
        for(int weekLoop = 0; firstDay <= maxDays; weekLoop++){
            //一週間分の日にちを出力するための繰り返し処理
            for(int weekdayLoop = 0; weekdayLoop < En15_8_OutputCalendarsCommonProcesses.weekDays; weekdayLoop++){
                //月の開始曜日から出力開始するための条件式
                if(weekdayLoop >= startWeekDay && weekLoop == 0 || firstDay > 1 && firstDay <= maxDays){
                    //日にちを表示するための出力
                    System.out.printf("%02d  ",firstDay);
                    //次の日の表示のため日にちを1日加算する
                    firstDay++;
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
