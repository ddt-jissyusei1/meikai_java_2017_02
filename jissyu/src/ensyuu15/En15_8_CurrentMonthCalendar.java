package ensyuu15;

/**
 * 現在の月のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_CurrentMonthCalendar extends En15_8_AbsCalendar {
    private int currentYear;                //現在年のためのフィールド変数
    private int currentMonth;               //現在月のためのフィールド変数
    private int currentDay;                 //現在日のためのフィールド変数

    public En15_8_CurrentMonthCalendar(){
        this.currentYear = 2000;
    }

    @Override
    public String toString() {
        //
        return null;
    }


    @Override
    public int dayOfWeek() {
        return 0;
        //

    }

    @Override
    public void outputCalendar() {
        //

    }



}
