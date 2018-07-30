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

    /**
     * 日付から開始曜日を求めるためのメソッド
     * @return (year + year / 4 - year / 100 + year / 400 + (13*month + 8) / 5 + day) % 7
     *          日付から計算した曜日の値を返却
     */
    @Override
    public int dayOfWeek() {
        //フィールドの年月日の値から月の開始曜日を求め、その値を呼び出し元に返却する
        return (year + year / 4 - year / 100 + year / 400 + (13*month + 8) / 5 + day) % 7;


    }

    //カレンダーを出力するためのメソッド
    @Override
    public void outputCalendar() {
        for(int monthLoop = 0; monthLoop < 12;monthLoop++){
            System.out.println("\n" + month + "月\n日　月　火　水　木　金　土");

            day = 1;
            for(int weekLoop = 0; day < 32; weekLoop++){
                //曜日列の出力のための繰り返し処理
                //指定年のカレンダーを出力するための繰り返し処理
                for(int weekdayLoop = 0; weekdayLoop < 7; weekdayLoop++){
                    if(weekdayLoop >= dayOfWeek() || day > 31){
                        System.out.printf("%02d  ",day);
                        day++;
                    }else{
                        System.out.print("    ");
                    }
                }
                System.out.println();

            }
            month++;
        }

    }








}
