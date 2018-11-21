package ensyuu15;

/*
 * コマンドライン引数で指定された月のカレンダーを表示するプログラムを作成せよ。
 * コマンドラインから年のみが与えられた場合は、その年の1月から12月までのカレンダーを表示して、
 * 年と月が与えられた場合は、その月のカレンダーを表示して、
 * 年も月も与えられたなかったら、現在の月のカレンダーを表示すること。
 *
 *追加仕様：年、月以外にも引数が入力された場合(引数三つ以上ある)、許容数以上であることを通知し、
 *          処理を実行せずプログラムを終了することとする。
 *追加日　：2018/07/18　メンター・卜部決定
 *
 */

public class En15_8_ArgsCalendar {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "コマンドライン引数で指定された月のカレンダーを表示します。"
            + "\n年のみが与えられたら1月～12月まで表示します。\n年と月が与えられたらその月のカレンダーを表示します。"
            + "\nどちらも与えられなかったら現在の月のカレンダーを表示します。\n";
    //コマンドライン引数の年の値を表示する文のための定数
    private static final String SHOW_ARGUMENTS_VALUE_STRING = "args[%d]：%s\n";
    //コマンドライン引数の数が許容数以上であることを告げる通知文のための定数
    private static final String ARGUMENTS_NUMBER_ERROR_MESSAGE = "\nコマンドライン引数の数が許容数以上です。"
                                                                            + "年のみまたは年と月を入れなおしてください。";

    //コマンドライン引数の数が0(現在月カレンダー表示)の条件分岐のための定数
    private static final int CURRENT_CALENDAR_CASE_NUMBER = 0;
    //コマンドライン引数の数が1(指定年カレンダー表示)の条件分岐のための定数
    private static final int SPECIFIED_YEAR_CALENDAR_CASE_NUMBER = 1;
    //コマンドライン引数の数が2(指定年月カレンダー表示)の条件分岐のための定数
    private static final int SPECIFIED_YEARMONTH_CALENDAR_CASE_NUMBER = 2;

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int showArgsValueCounter = 0;                   //コマンドライン引数の値を表示するループのためのカウンタ変数
        int argsLength = args.length;                    //引数の数によって処理を分けるための引数の配列の長さの取得

        //コマンドライン引数の値を表示するための拡張for文
        for(String argsValue : args){
            //コマンドライン引数の値を表示するための出力
            System.out.printf(SHOW_ARGUMENTS_VALUE_STRING, showArgsValueCounter, argsValue);
            //次の引数の値を表示するためのカウンタの加算
            showArgsValueCounter++;
        }

        //カレンダーを表示するためのインスタンスの宣言
        En15_8_AbsCalendar calendars = null;

        //配列の要素数によってい処理を分けるための条件分岐
        switch(argsLength){
            //要素数が0の場合に実行する処理のための条件分岐
            case CURRENT_CALENDAR_CASE_NUMBER://現在月のカレンダーを表示するための参照先インスタンスを生成
                    calendars = new En15_8_CurrentMonthCalendar();
                    //次の分岐に処理が移らないようにするためのブロック抜け文
                    break;
            //要素数が１の場合に実行する処理のための条件分岐
            case SPECIFIED_YEAR_CALENDAR_CASE_NUMBER://指定年の年間カレンダーを表示するための参照先インスタンスの宣言
                    calendars = new En15_8_YearCalendar(args[0]);
                    //次の分岐に処理が移らないようにするためのブロック抜け文
                    break;
            //要素数が２の場合に実行する処理のための条件分岐
            case SPECIFIED_YEARMONTH_CALENDAR_CASE_NUMBER://指定年月のカレンダーを表示するための参照先インスタンスの宣言
                    calendars = new En15_8_YearMonthCalendar(args[0],args[1]);
                    //次の分岐に処理が移らないようにするためのブロック抜け文
                    break;
            //上記条件以外の時に実行する処理のためのデフォルト分岐
            default:
                 //コマンドライン引数が上限数以上であることを通知するための文の表示
                 System.out.println(ARGUMENTS_NUMBER_ERROR_MESSAGE);
                 //例外発生を防ぐためのプログラム終了コード
                 return;
        }

        //コマンドライン引数の数に応じたカレンダーを表示するためのカレンダー表示メソッドの呼び出し
        calendars.showCalendar();
    }

}
