package ensyuu15;

import java.util.GregorianCalendar;

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
            + "\nどちらも与えられなかったら現在の月のカレンダーを表示します。";
    //コマンドライン引数の年の値を表示する文のための定数
    private static final String SHOW_ARGUMENTS_VALUE_STRING = "\nargs[%d]：%s";
    //コマンドライン引数の月の値を表示する文のための定数
    //private static final String SHOW_ARGUMENTS_MONTH_VALUE_STRING = "\n月の値(args[%d):%s";
    //表示する『月』の文字リテラルのための定数
    private static final String MONTH_CHAR = "\n%02d月";
    //表示する『年』の文字リテラルのための定数
    private static final String YEAR_CHAR = "%04d年";
    //引数がない場合に表示する『なし』の文字列のための定数
    private static final String NONE_ARGUMENTS_STRING = "なし";
    //カレンダーの曜日の文字列のための定数
    //private static final String WEEKDAY_STRINGS = "\n月　火　水　木　金　土　日";

    public static GregorianCalendar calendar = new GregorianCalendar();

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int showArgsValueCounter = 0;                   //コマンドライン引数の値を表示するループのためのカウンタ変数

        int argsLength = args.length;                    //引数の数によって処理を分けるための引数の配列の長さの取得

        //int[] argsValues = new int[argsLength];

        //コマンドライン引数の値を表示するための拡張for文
        for(String argsValue : args){
            //コマンドライン引数の値を表示するための出力
            System.out.printf(SHOW_ARGUMENTS_VALUE_STRING, showArgsValueCounter, argsValue);
            //次の引数の値を表示するためのカウンタの加算
            showArgsValueCounter++;
        }



        //コマンドライン引数の数によって呼び出して生成するインスタンスを分けるための条件分岐
        switch(argsLength){
            //引数なしの場合に実行する処理のための分岐
            case 0: new En15_8_CurrentMonthCalendar();
                    break;
            //引数
            case 1: En15_8_AbsCalendar calendar = new En15_8_YearCalendar(args[0]);
                    calendar.outputCalendar();
                    break;
            //
            case 2: new En15_8_YearMonthCalendar(args[0],args[1]);
                    break;
            //コマンドライン引数が指定上限数以上の場合に実行するためのデフォルト分岐
            default:
                //上限数以上であることを、
                System.out.println("\nコマンドライン引数の数が許容数以上です。年または年と月を入れなおしてください。");

        }

    }

}
