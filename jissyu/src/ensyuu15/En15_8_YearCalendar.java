package ensyuu15;

/**
 * 指定年のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearCalendar extends En15_8_AbsCalendar {
    private int year;                                      //表示するカレンダーの年のためのフィールド変数
    private int month = 1;                                 //表示するカレンダーの月のためのフィールド変数
    private int day = 1;                                   //表示するカレンダーの日のためのフィールド変数

    //年間カレンダーのためのコンストラクタ
    public En15_8_YearCalendar(String year) {
        this.year = Integer.parseInt(year);                //フィールド変数に引数の値をセットするための代入

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

    public int getMonth(){
        return month;
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

    //閏年を判定するためのメソッド
    public boolean isLeap(int year){
        //引数の年から閏年であるか計算し、真偽値を呼び出し元に返却する
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 日付から開始曜日を求めるためのメソッド
     * @return (year + year / 4 - year / 100 + year / 400 + (13*month + 8) / 5 + day) % 7
     *          日付から計算した曜日の値を返却
     */
    @Override
    public int dayOfWeek() {
        int yearOfWeek = getYear();                 //フィールド変数の年の値の取得
        int monthOfWeek = getMonth();               //フィールド変数の月の値の取得

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

    //カレンダーを出力するためのメソッド
    @Override
    public void outputCalendar() {
        //各月の最大日数のための配列の宣言
        int[] monthMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //閏年であった場合、2月の最大日数に1加算するための条件式
        if(isLeap(getYear())){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        //月ごとの出力をするための繰り返し処理
        for(int monthLoop = 0; monthLoop < 12;monthLoop++){
            //出力する月の最大日数を変数に保持する
            int monthDays = monthMaxDays[monthLoop];
            //出力する月の開始曜日を取得し変数に保持する
            int startday = dayOfWeek();
            //月と曜日情報を表示するための出力
            System.out.println("\n" + month + "月\n日　月　火　水　木　金　土");

            //週ごとに出力するための繰り返し処理
            for(int weekLoop = 0; day <= monthMaxDays[monthLoop]; weekLoop++){
                //曜日列の出力のための繰り返し処理
                for(int weekdayLoop = 0; weekdayLoop < 7; weekdayLoop++){
                    if(weekdayLoop >= startday && weekLoop == 0 || day > 1 && day <= monthMaxDays[monthLoop]){
                        System.out.printf("%02d  ",day);
                        day++;
                    } else {
                        System.out.print("    ");
                    }
                }
                System.out.println();
            }
            month++;
            day = 1;
        }

    }

}
