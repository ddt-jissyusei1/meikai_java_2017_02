package ensyuu15;

import java.util.GregorianCalendar;

/*
 * 演習15-8のカレンダー表示クラスで使用する共通の関数をまとめたクラス
 */
public class En15_8_Common {
    public static final String WEEKHEADER = "日　月　火　水　木　金　土";

    public static int baseDay = 1;
    public int weekDays = 7;

    //カレンダークラスインスタンスの生成
    public static GregorianCalendar calendar = new GregorianCalendar();

    //引数の月の最大日数を取得するための関数
    public static int getMonthMaxDays(int month, int year){
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



}
