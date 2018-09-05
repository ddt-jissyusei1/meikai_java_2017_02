package ensyuu15;
import static java.util.Calendar.*;

import java.util.GregorianCalendar;

/**
 * 指定年月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearMonthCalendar extends En15_8_AbsCalendar {
    public GregorianCalendar specifiedMonthCalendar;               //指定年月のためのフィールド変数

    //指定年月カレンダーのためのコンストラクタ
    public En15_8_YearMonthCalendar(String year, String month) {
        //引数の値をフィールド変数にセット
        this.specifiedMonthCalendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1,1);
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
                                            +specifiedMonthCalendar.get(YEAR) + "年" + (specifiedMonthCalendar.get(MONTH)+1) + "月";
    }

    @Override
    public void outputWeekHeader() {
        System.out.println(En15_8_Common.WEEKHEADER);

    }

    /**
     *指定年月のカレンダーを表示するためのメソッド</br>
     *作成日：2018/08/22</br>
     *作成者：志田
     */
    @Override
    public void outputCalendar() {
        int specifiedYear = specifiedMonthCalendar.get(YEAR);     //指定年の値の取得
        int specifiedMonth = specifiedMonthCalendar.get(MONTH);   //指定月の値の取得
        int firstDay = specifiedMonthCalendar.get(DATE);           //月の初日の値を取得

        //指定月の最大日数を取得しループ制御で使用するため変数に保持する
        int maxDays = En15_8_Common.getMonthMaxDays(specifiedMonth-1, specifiedYear);

        //月の開始曜日の取得
        int startDay = specifiedMonthCalendar.get(GregorianCalendar.DAY_OF_WEEK)-1;
        //曜日のヘッダーを表示するための出力
        outputWeekHeader();

        //指定月のカレンダーを出力するための繰り返し処理
        for(int weekLoop = 0; firstDay <= maxDays; weekLoop++){
            //一週間分の日にちを出力するための繰り返し処理
            for(int weekdayLoop = 0; weekdayLoop < 7; weekdayLoop++){
                //月の開始曜日から出力開始するための条件式
                if(weekdayLoop >= startDay && weekLoop == 0 || firstDay > 1 && firstDay <= maxDays){
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
