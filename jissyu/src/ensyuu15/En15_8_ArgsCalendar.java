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
                                                                            + "年または年と月を入れなおしてください。";

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

        //コマンドライン引数の数によって呼び出して生成するインスタンスを分けるための条件分岐
        switch(argsLength){
            //引数なしの場合に実行する処理のための分岐
            case 0:
                    //現在月のカレンダーを表示するためのクラスを参照するインスタンスの生成
                    En15_8_AbsCalendar currentCalendar = new En15_8_CurrentMonthCalendar();
                    //現在月のカレンダーを表示するためのメソッドの呼び出し
                    currentCalendar.showCalendar();
                    //次の処理に流れないようにするためのブロック抜け処理
                    break;
            //引数が年のみの場合に実行する処理のための分岐
            case 1:
                    //指定年間カレンダーを表示するためのクラスを参照するインスタンスを生成
                    En15_8_AbsCalendar yearCalendar = new En15_8_YearCalendar(args[0]);
                    //引数の年の年間カレンダーを表示するためのメソッドの呼び出し
                    yearCalendar.showCalendar();
                  //次の処理に流れないようにするためのブロック抜け処理
                    break;
            //引数が年と月の場合に実行する処理のための分岐
            case 2:
                    //指定年月のカレンダーを表示するためのクラスを参照するインスタンスを生成
                    En15_8_AbsCalendar yearMonthCalendar = new En15_8_YearMonthCalendar(args[0],args[1]);
                    //引数の年月のカレンダーを表示するためのメソッドの呼び出し
                    yearMonthCalendar.showCalendar();
                  //次の処理に流れないようにするためのブロック抜け処理
                    break;
            //コマンドライン引数が指定上限数以上の場合に実行するためのデフォルト分岐
            default:
                //コマンドライン引数が上限数以上であることを通知するための文の、
                System.out.println(ARGUMENTS_NUMBER_ERROR_MESSAGE);
        }

    }

}
