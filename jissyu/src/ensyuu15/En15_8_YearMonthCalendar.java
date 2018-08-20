package ensyuu15;

/**
 * 指定年月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearMonthCalendar extends En15_8_AbsCalendar {
    private int year;                               //年の値のためのフィールド変数
    private int month;                              //月の値のためのフィールド変数
    private int day = 1;

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
        //取得した月の値を呼び出し元に返却する
        return month;
    }

    //日の値を取得するためのメソッド
    public int getDay(){
        //取得した日の値を呼び出し元に返却する
        return day;
    }

    /**
     * 出力する年月のカレンダー情報を文字列として返却するためのメソッド
     */
    @Override
    public String toString() {
        //取得した年と月の値を文字列にして呼び出し元に返却する
        return "\n"+getYear() + "年" + getMonth() + "月";
    }

    //閏年を判定するためのメソッド
    @Override
    public boolean isLeap(int year){
        //引数の年から閏年であるか計算し、真偽値を呼び出し元に返却する
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 日付から月の開始曜日を求めるためのメソッド</br>
     * 作成日：2018/08/20</br
     * 作成者：志田</br>
     *
     * @return 月の開始曜日の値
     */
    @Override
    public int dayOfWeek() {
        //フィールドの年月日の値から月の開始曜日を求め、その値を呼び出し元に返却する
        return (year + year / 4 - year / 100 + year / 400 + (13*month + 8) / 5 + day) % 7;
    }

    /**
     *指定年月のカレンダーを表示するためのメソッド</br>
     *作成日：2018/08/20</br>
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

        /*
         * デバッグ用取得曜日確認変数
         */
        int checkWeek = dayOfWeek();

        int maxDays = monthMaxDays[getMonth() -1];         //指定月の最大日数を取得しループ制御で使用するため変数に保持する
        int day = getDay();                                //日を加算し表示するための変数

        //曜日のヘッダーを表示するための出力
        System.out.println("日　月　火　水　木　金　土");

        //指定月のカレンダーを出力するための繰り返し処理
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
