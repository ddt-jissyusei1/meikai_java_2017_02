package ensyuu11_id;
import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class En10_4_Day {
    private int year = 1;                   //年の値のための変数
    private int month = 1;                  //月の値のための変数
    private int date = 1;                   //日の値のための変数
    private En10_4_Day days;                //年月日のための変数

    //y年が閏年か調べるためのメソッド
    public static boolean isLeap(int yearLeap){
        //閏年を求めるための定型の計算式
        return yearLeap % 4 == 0 && yearLeap % 100 != 0 || yearLeap % 400 == 0;
    }

    //現在時刻を取得するためのプログラムの呼び出し
    GregorianCalendar today = new GregorianCalendar();

    //日付クラスのコンストラクタ
    //引数を受け取らないコンストラクタで、プログラム実行時の日付で変数を初期化する
    public En10_4_Day(){
        //年のフィールド変数に取得した現在年を代入する
        this.year = today.get(YEAR);
        //月のフィールド変数に取得した現在月を代入する
        this.month = today.get(MONTH)+1;
        //日のフィールド変数に取得した現在日を代入する
        this.date = today.get(DATE);
    }

    //引数に年の値を渡したコンストラクタ
    public En10_4_Day(int year){
        //このクラスの年のフィールド変数に仮引数の値を代入する
        this.year = year;
    }

    //引数に年と月の値を渡したコンストラクタ
    public En10_4_Day(int year, int month){
        //すでにある年の同様の処理を実行する
        this(year);

        //月の引数に不正な値を受け取った場合正常な値に修正する
        if(month <= 0){
            //月の値が0以下であれば引数の月の値に1を代入する
            month = 1;
        //月の値が13以上であれば月の値を12にする
        }else if(month >= 13){
            //引数の月の変数に12を代入する
            month = 12;
        }
        //このクラスの月のフィールド変数に仮引数の値を代入する
        this.month = month;
    }

    //引数に年と月と日の値を渡したコンストラクタ
    public En10_4_Day(int year, int month, int date){
        //すでにある年と月の同様の処理を実行する
        this(year, month);

        //日の引数に不正な値を受け取った場合は正常な値に修正する
        if(date <= 0){
            //日の値が0以下であれば、引数の日の値に1を代入する
            date = 1;
        //日の値が32以上でかつ奇数月の場合日の値を31に修正する
        }else if(date >= 32 && month%2 == 1 || date >= 32 && month <= 7 && month%2 == 0){
            //引数の日の変数に31を代入する
            date = 31;
        //日の値が31以上でかつ2月以外の偶数月場合日の値を30に修正する
        }else if(date >= 31 && month <=6 && month != 2 && month%2 == 0 || date >= 31 && month >= 8 && month%2 == 1){
            //引数の日の変数に30を代入する
            date = 30;
        //日の値が29以上でかつ2月の場合
        }else if(date >= 29 && month == 2){
            //引数の日の変数に閏年であれば29を、違うなら28を代入する
            date = isLeap(year) ? 29 : 28;
        }

        //このクラスの日のフィールド変数に仮引数の値を代入する
        this.date = date;
    }

    //引数にクラス型変数の値を渡したコンストラクタ
    public En10_4_Day(En10_4_Day cDate){
        //すでにある年・月・日の同様の処理を実行する
        this(cDate.year, cDate.month, cDate.date);
    }

    //年の値を取得するゲッターメソッド
    public int getYear() {
        //取得した年の値を呼び出しもとに返却する
        return year;
    }

    //月の値を取得するゲッターメソッド
    public int getMonth() {
        //取得した月の値を呼び出し元に返却する
        return month;
    }

    //日の値を取得するゲッターメソッド
    public int getDate() {
        //取得した日の値を呼び出し元に返却する
        return date;
    }

    //年月日の値を取得するゲッターメソッド
    public En10_4_Day getDays(){
        //取得した日付への参照を呼び出し元に返却する
        return new En10_4_Day(days);
    }

    //年の値を変更するためのセッターメソッド
    public void setYear(int year) {
        //このクラスの年のフィールド変数に値をセットする
        this.year = year;
    }

    //月の値を変更するためのセッターメソッド
    public void setMonth(int month) {
        //このクラスの月のフィールド変数に値をセットする
        this.month = month;
    }

    //日の値を変更するためのセッターメソッド
    public void setDate(int date) {
        //このクラスの日のフィールド変数に値をセットする
        this.date = date;
    }

    //年月日の値を変更するためのセッターメソッド
    public void setDays(int days){
        //このクラスの日付のフィールド変数に値をセットする
        this.days = new En10_4_Day(days);
    }

    //閏年か判定するためのインスタンスメソッドの呼び出し
    public boolean isLeap(){
        //閏年か判定した結果を呼び出し元に返却する
        return isLeap(year);
    }

    //曜日を求めるためのメソッド
    public int dayOfWeek(){
        int yearForWeek = year;             //曜日を求める計算式で使用する年の変数
        int monthForWeek = month;           //曜日を求める計算式で使用する月の変数

        //月の変数の値が1または2であれば実行する処理
        if(monthForWeek == 1 || monthForWeek == 2){
            //曜日を求める計算のために年の値を1デクリメントする
            yearForWeek--;
            //曜日を求める計算のために月の値に12を加算する
            monthForWeek += 12;
        }

        //曜日を求めるための定型の計算式で求られた結果を呼び出し元に返却する
        return (yearForWeek + yearForWeek / 4  - yearForWeek / 100 + yearForWeek / 400 + (13 * monthForWeek + 8) / 5 + date) % 7;
   }

    //インスタンスの日付と入力された値が同じであるか判定するためのメソッド
   public boolean equalTo(En10_4_Day cDate){
       //インスタンスの年月日をそろぞれ入力された値と比較してすべて等しいかの真偽値を呼び出しもとに返却する
       return year == cDate.year && month == cDate.month && date == cDate.date;
   }

   //年内での経過日数を求めるためのメソッド
   public int dayPast(En10_4_Day testDate){
       long dayPastResult = 0;                                //求めた経過日数のための変数
       Calendar calendarFirst = Calendar.getInstance();      //経過日数を求めるための元日の日付インスタンス
       Calendar calendarSecond = Calendar.getInstance();     //ユーザーが入力した日付のためのインスタンス

       //設定された年の元旦に日付インスタンスを設定する
       calendarFirst.set(getYear(), 1,1);
       //ユーざーが入力した日付をインスタンスに設定する
       calendarSecond.set(getYear(), getMonth(), getDate());

       //経過日数の数え始めの日付（1月1日）を取得する
       long calendarDays = calendarFirst.getTimeInMillis();
       //ユーザーが入力した日付インスタンスからミリ秒を取得する
       long userDate = calendarSecond.getTimeInMillis();

       //元日からの経過日数を計算し、経過日数を算出する
       dayPastResult = (userDate - calendarDays)/(1000 * 60 * 60 * 24);

       //結果をintにキャストして呼び出し元に返却する
       return (int)dayPastResult;
   }

   //年内の残りの日数を求めるメソッド
   public int dayLeft(){
       long dayLeftResult = 0;                                 //求めた残り日数のための変数
       Calendar calendarFirst = Calendar.getInstance();      //残り日数を求めるための最終日の日付インスタンス
       Calendar calendarSecond = Calendar.getInstance();     //ユーザーが入力した日付のためのインスタンス

       //設定された年の最終日を日付インスタンスを設定する
       calendarFirst.set(getYear(), 12,31);
       //ユーざーが入力した日付をインスタンスに設定する
       calendarSecond.set(getYear(), getMonth(), getDate());

       //残り日数の数え終わりの日付（12月31日）を取得する
       long calendarDays = calendarFirst.getTimeInMillis();
       //ユーザーが入力した日付インスタンスからミリ秒を取得する
       long userDate = calendarSecond.getTimeInMillis();

       //元日からの経過日数を計算し、経過日数を算出する
       dayLeftResult = (calendarDays - userDate)/(1000 * 60 * 60 * 24);

       //結果を呼び出し元に返却する
       return (int)dayLeftResult;

   }

   //他の日付との前後関係を判定するインスタンスメソッド
   public boolean dayContextCheck(En10_4_Day testDate, En10_4_Day testDate2){
       Calendar compareDate = Calendar.getInstance();           //前後判定するためのカレンダーインスタンスの取得
       Calendar compareDateSecond = Calendar.getInstance();    //前後比較用のカレンダーインスタンスの取得

       //前後判定するためのインスタンスにユーザーが入力した最初の日付を設定する
       compareDate.set(testDate.getYear(), testDate.getMonth(), testDate.getDate());
       //前後比較するためのインスタンスにユーザーが入力した二つ目の日付を設定する
       compareDateSecond.set(testDate2.getYear(), testDate2.getMonth(),testDate2.getDate());

       //比較するために、最初の日付のミリ秒で取得する
       long testDateTime = compareDate.getTimeInMillis();
       //比較するために、二つ目の日付のミリ秒を取得する
       long testDate2Time = compareDateSecond.getTimeInMillis();

       //設定された日付が現在日付よりも前である真偽値を呼び出し元に返却する
       return testDateTime < testDate2Time;

   }

   //二つの日付の前後関係を判定するクラスメソッド
   public static boolean cDayContextCheck(En10_4_Day testDate, En10_4_Day testDate2){
       Calendar compareDate = Calendar.getInstance();           //前後判定するためのカレンダーインスタンスの取得
       Calendar compareDateSecond = Calendar.getInstance();    //前後比較用のカレンダーインスタンスの取得

       //前後判定するためのインスタンスにユーザーが入力した最初の日付を設定する
       compareDate.set(testDate.getYear(), testDate.getMonth(), testDate.getDate());
       //前後比較するためのインスタンスにユーザーが入力した二つ目の日付を設定する
       compareDateSecond.set(testDate2.getYear(), testDate2.getMonth(),testDate2.getDate());

       //比較するために、最初の日付のミリ秒で取得する
       long testDateTime = compareDate.getTimeInMillis();
       //比較するために、二つ目の日付のミリ秒を取得する
       long testDate2Time = compareDateSecond.getTimeInMillis();

       //設定された日付が現在日付よりも前である真偽値を呼び出し元に返却する
      return testDateTime < testDate2Time;
     }


    //日付を一つ後ろに進めるメソッド
    public void moveOneDayForward(En10_4_Day testDate){
        Calendar addBaseDate = Calendar.getInstance();   //1日加算するための元の日付のためのインスタンス

       //インスタンスに加算するための日付をセットする
       addBaseDate.set(testDate.getYear(), testDate.getMonth(), testDate.getDate());
       //セットした日付に1日加算するためのメソッド
        addBaseDate.add(Calendar.DAY_OF_MONTH, 1);

        //一日加算した日付の値から年を取得しフィールドの年の値にセットする
        testDate.setYear(addBaseDate.get(Calendar.YEAR));
        //一日加算した日付の値から月を取得しフィールドの月の値にセットする
        testDate.setMonth(addBaseDate.get(Calendar.MONTH));
        //一日加算した日付の値から日を取得しフィールドの日の値にセットする
        testDate.setDate(addBaseDate.get(Calendar.DATE));

    }

   //次の日の日付を返却するメソッド
    public Calendar giveBackNextDay(){
       Calendar addBaseDate = Calendar.getInstance();   //1日加算するための元の日付のためのインスタンス

       //インスタンスに加算するための日付をセットする
       addBaseDate.set(this.getYear(), this.getMonth(), this.getDate());
       //セットした日付に1日加算するためのメソッド
       addBaseDate.add(Calendar.DAY_OF_MONTH, 1);

        //加算した値を結果表示のために呼び出し元に返却する
        return addBaseDate;
    }

   //日付を一つ前に戻すメソッド
    public void moveOneDayBack(En10_4_Day testDate){
        Calendar minusDay = Calendar.getInstance();                       //減算した日付のための変数

       //日付を減算するために、カレンダークラスのインスタンスに現在設定の日付を取得しセットする
        minusDay.set(testDate.getYear(), testDate.getMonth(), testDate.getDate());

        //インスタンスに設定した日付から一日減算する
        minusDay.add(DAY_OF_MONTH, -1);

        //減算した日付の年の値をフィールド変数にセットする
        testDate.setYear(minusDay.get(Calendar.YEAR));
        //減算した日付の月の値をフィールド変数にセットするための変数に代入する
        testDate.setMonth(minusDay.get(Calendar.MONTH));
        //減算した日付の日の値をフィールド変数にセットするための変数に代入する
        testDate.setDate(minusDay.get(Calendar.DATE));

    }

   //前の日の日付を返却するメソッド
    public Calendar giveBackDayBefore(){
        Calendar beforeDayResult = Calendar.getInstance();           //前日の日付のためのカレンダークラスのインスタンス

        //日付をインスタンスに設定するために現在の設定日付を取得する
        beforeDayResult.set(this.getYear(), this.getMonth(), this.getDate());

        //インスタンスにセットした日付から一日減算する
        beforeDayResult.add(DAY_OF_MONTH, -1);

        //減算した値を結果表示のために呼び出し元に返却する
        return beforeDayResult;

    }

   //日付をn日後ろに進めるメソッド
    public long moveSomeDateForward(long moveDayNumber){
           Calendar baseMoveDate = Calendar.getInstance();    //計算元の日付のためのカレンダークラスのインスタンス
           long baseDateToMillis = 0;                         //ミリ秒に換算した計算元日付のための変数
           long dayToMillis = 0;                                //ミリ秒に換算した指定日数のための変数
           long moveDayAfterResult = 0;                       //指定日後ろに移動した日付のミリ秒ための変数

           //インスタンスにフィールドから取得した日付を設定する
           baseMoveDate.set(this.getYear(), this.getMonth()-1, this.getDate());

           //日付をミリ秒に換算する
           baseDateToMillis = baseMoveDate.getTimeInMillis();

           //指定日数をミリ秒に換算する
           dayToMillis =(long) moveDayNumber*(24*60*60*1000);

           //日付を指定日進めるために、日付のミリ秒に指定日のミリ秒を加算する
           moveDayAfterResult = baseDateToMillis + dayToMillis;

           return moveDayAfterResult;
    }

   //n日後の日付を返却するメソッド
    public long sendBackDayAfter(long dayNumber){
        Calendar baseDate = Calendar.getInstance();     //計算元の日付のためのカレンダークラスのインスタンス
        long baseDateToMillis = 0;                      //計算元日付のミリ秒のための変数
        long dayToMillis = 0;                            //ミリ秒に変換した日数のための変数
        long dayAfterResult = 0;                        //指定日数後の日付のための変数

        //インスタンスに設定されている日付をセットする
        baseDate.set(this.getYear(), this.getMonth()-1, this.getDate());

        //日付をミリ秒に変換する
        baseDateToMillis = baseDate.getTimeInMillis();

        //指定日数をミリ秒に変換する
        dayToMillis =(long) dayNumber*(24*60*60*1000);

        //指定日後を求めるために、元の日付のミリ秒に指定日数のミリ秒を加算する
        dayAfterResult = baseDateToMillis + dayToMillis;

        //指定日後の日付をミリ秒で呼び出しもとに返却する
        return dayAfterResult;
    }

   //日付をn日前に戻すメソッド
    public long moveSomeDayBack(long dayBackNumber){
        Calendar baseMoveDate = Calendar.getInstance();    //計算元の日付のためのカレンダークラスのインスタンス
        long baseDateToMillis = 0;                         //ミリ秒に換算した計算元日付のための変数
        long dayToMillis = 0;                                //ミリ秒に換算した指定日数のための変数
        long moveDayBeforeResult = 0;                       //指定日前に移動した日付のミリ秒ための変数

        //インスタンスにフィールドから取得した日付を設定する
        baseMoveDate.set(this.getYear(), this.getMonth()-1, this.getDate());

        //日付をミリ秒に換算する
        baseDateToMillis = baseMoveDate.getTimeInMillis();

        //指定日数をミリ秒に換算する
        dayToMillis =(long) dayBackNumber*(24*60*60*1000);

        //日付を指定日戻すために、日付のミリ秒に指定日のミリ秒を減算する
        moveDayBeforeResult = baseDateToMillis - dayToMillis;

        return moveDayBeforeResult;
    }

   //n日前の日付を返却するメソッド
    public long sendBackDayBefore(int dayNumber){
        Calendar baseDate = Calendar.getInstance();     //計算元の日付のためのカレンダークラスのインスタンス
        long baseDateToMillis = 0;                      //計算元日付のミリ秒のための変数
        long dayToMillis = 0;                            //ミリ秒に変換した日数のための変数
        long dayBeforeResult = 0;

        //インスタンスに設定されている日付をセットする
        baseDate.set(this.getYear(), this.getMonth()-1, this.getDate());

        //日付をミリ秒に変換する
        baseDateToMillis = baseDate.getTimeInMillis();

        //指定日数をミリ秒に変換する
        dayToMillis =(long)dayNumber*(24*60*60*1000);

        //指定日前を求めるために、元の日付のミリ秒に指定日数のミリ秒を減算する
        dayBeforeResult = baseDateToMillis-dayToMillis;

        //指定日前の日付をミリ秒で呼び出しもとに返却する
        return dayBeforeResult;
    }

   //日付を文字列に成形するメソッド
   public String toString(){
       //曜日文字リテラルを保持するための配列
       String[] wd = {"日", "月", "火", "水", "木", "金", "土"};


       return String.format("%04d年%02月%02日（%s）", year, month, date, wd[dayOfWeek()]);
   }

}
