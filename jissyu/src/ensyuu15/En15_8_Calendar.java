package ensyuu15;

import java.util.GregorianCalendar;

public interface En15_8_Calendar {

    //カレンダークラスインスタンスの生成
    GregorianCalendar calendar = new GregorianCalendar();

    //カレンダーを初日から表示するための月の初日の値
    int baseDay = 1;
    //カレンダー表示ループで使用するための一週間の日数の値
    int weekDays = 7;

    void outputWeekHeader();
}
