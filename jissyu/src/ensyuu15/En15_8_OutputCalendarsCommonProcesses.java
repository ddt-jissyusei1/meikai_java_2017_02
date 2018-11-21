package ensyuu15;

import java.util.GregorianCalendar;

/*
 * 演習15-8のカレンダー表示クラスで使用する共通の関数をまとめたクラス
 */
public class En15_8_OutputCalendarsCommonProcesses {
    //表示するカレンダーの曜日のヘッダのための定数
    public static final String WEEKHEADER = "日　月　火　水　木　金　土";

    //月の初日から表示するための開始日の保持
    public static final int baseDay = 1;
    //カレンダーを表示する繰り返し処理で使用するための1週間の日数の値の保持
    public static final int weekDays = 7;

    //カレンダークラスインスタンスの生成
    public static GregorianCalendar calendar = new GregorianCalendar();

    //月の開始曜日を取得するためのメソッド
    public static int getWeekDay(int year, int month){
        //開始曜日を取得するためカレンダーインスタンスに引数の値をセットする
        calendar.set(year, month, baseDay);
        //カレンダークラスより取得した開始曜日の値を返却用変数に代入する
        int weekday = calendar.get(GregorianCalendar.DAY_OF_WEEK)-1;
        //呼び出し元に取得した値を返却する
        return weekday;
    }

    //引数の月の最大日数を取得するための関数
    public static int getMonthMaxDays(int year, int month){
        //各月の最大日数のための配列の宣言
        int[] monthMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //閏年であった場合、2月の最大日数に1加算するための条件式
        if(calendar.isLeapYear(year)){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        //呼び出し元に引数月の最大日数を返却する
        return monthMaxDays[month];
    }

    //曜日のヘッダを出力するためのメソッド
    public static void outputWeekHeader(){
        //曜日のヘッダを表示するための出力
        System.out.println(En15_8_OutputCalendarsCommonProcesses.WEEKHEADER);
    };



}
