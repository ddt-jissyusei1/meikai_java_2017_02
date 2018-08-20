package ensyuu15;

import static java.util.Calendar.*;

import java.util.GregorianCalendar;

/**
 * 現在の月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_CurrentMonthCalendar extends En15_8_AbsCalendar {
    private int currentYear;                //現在年のためのフィールド変数
    private int currentMonth;               //現在月のためのフィールド変数
    private int firstDay = 1;               //月の初日のためのフィールド変数

    public En15_8_CurrentMonthCalendar(){
        GregorianCalendar calendar = new GregorianCalendar();     //現在日時のためのカレンダークラスのインスタンスの宣言
        this.currentYear = calendar.get(YEAR);                    //フィールド変数に現在年をセットするための代入
        this.currentMonth = calendar.get(MONTH)+1;                //フィールド変数に現在月をセットするための代入
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getFirstDay() {
        return firstDay;
    }

    @Override
    public String toString() {
        //取得した年と月の値を文字列にして呼び出し元に返却する
        return getCurrentYear() + "年" + getCurrentMonth() + "月";
    }

    //閏年を判定するためのメソッド
    @Override
    public boolean isLeap(int year){
        //引数の年から閏年であるか計算し、真偽値を呼び出し元に返却する
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    @Override
    public int dayOfWeek() {
        //フィールドの年月日の値から月の開始曜日を求め、その値を呼び出し元に返却する
        return (currentYear + currentYear / 4 - currentYear / 100 + currentYear / 400 + (13*currentMonth + 8) / 5 + firstDay) % 7;
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
        if(isLeap(getCurrentYear())){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        int maxDays = monthMaxDays[getCurrentMonth() -1];       //現在月の最大日数を取得しループ制御で使用するため変数に保持する
        int day = getFirstDay();                                //日を加算し表示するための変数

        //曜日のヘッダーを表示するための出力
        System.out.println("日　月　火　水　木　金　土");

        //現在月のカレンダーを出力するための繰り返し処理
        for(int dayCountLoop = 1; dayCountLoop <= maxDays; dayCountLoop++){
            //カレンダーの空白位置を表示する処理のための条件式
            if(dayCountLoop <= dayOfWeek() || dayCountLoop > maxDays){
                //空白を表示するための出力
                System.out.print("    ");
            //日にちを表示するためのデフォルト分岐処理
            }else{
                //日を表示するための出力
                System.out.printf("%02d  ",day);
                //次の日の出力のため一日加算する
                day++;
            }

            //７曜日目で改行するための条件式
            if(dayCountLoop >= 7 && dayCountLoop%7 == 0){
                //次の行に出力するための改行出力
                System.out.println();
            }
        }

    }



}
