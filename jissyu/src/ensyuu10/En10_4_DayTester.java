package ensyuu10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * 日付クラス第4版（p.346)を以下のように改良せよ。
 *
 * ・引数を受け取らないコンストラクタによるインスタンスの生成時は、西暦1年1月1日で初期化するのではなく、
 * プログラム実行時の日付で初期化する。
 * ・引数を受けとるコンストラクタに不正な値が指定された場合は、適当な値に調整する
 * （例えば13月が指定された場合は12月とする/9月31日と指定された場合は9月30日とする）。
 *
 * さらに、以下に示すメソッドを追加すること：
 * ・年内での経過日数（その年の元旦から数えて何日目であるか）を求めるメソッド
 * ・年内の残り日数を求めるメソッド
 * ・他の日付との前後関係（より前の日付か/同じ日付か/より後ろの日付か）を判定するインスタンスメソッド
 * ・二つの日付の前後関係を判定するクラスメソッド
 * ・日付を一つ後ろに進めるメソッド（日付が2012年12月31日であれば、2013年1月1日に更新する）
 * ・次の日の日付を返却するメソッド
 * ・日付を一つ前に戻すメソッド
 * ・前の日の日付を返却するメソッド
 * ・日付をn日後ろに進めるメソッド
 * ・n日後の日付を返却するメソッド
 * ・日付をn日前に戻すメソッド
 * ・n日前の日付を返却するメソッド
 * etc...
 */
public class En10_4_DayTester {

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputNumberStream = new Scanner(System.in);

    public static void main(String[] args) {
        int repeatProgram = 0;      //プログラムの繰り返し判定のための変数
        En10_4_Day testDate;
        //int dateProcessResult = 0; //日付に対する処理の結果を保持するための変数

        //プログラムの説明するための文を表示する
        System.out.println(En10_4_Constant.PROGRAM_EXPLANATION_STRING);

        //メインメソッドから非static参照するために自身でnewする
        En10_4_DayTester en10 = new En10_4_DayTester();

        //ユーザーが希望する限りプログラムを繰り返せるための処理
        do{
            //日付設定処理のメソッドを呼び出す
            testDate = en10.inputDateSelection(En10_4_Constant.SELECT_INPUT_DATE_OR_NOT);

            //日付に対する処理の選択をさせるメソッドを呼び出し、
            //その返却された値と日付インスタンスを引数に対応する処理を呼び出しその結果を受け取る
            en10.callDateProcess(testDate,
                en10.selectProcess(En10_4_Constant.SELECT_PROCESS_FOR_DATE_MESSAGE));

            //プログラムの繰り返し可否を選択させるため、選択メソッドを呼び出す
            repeatProgram = en10.selectProcess(En10_4_Constant.REPEAT_PROGRAM_QUESTION);

        //プログラムの繰り返す判定のための条件式
        }while(repeatProgram != 0);

        //値の入力が終わったので、開いていたリソースを開放する
        inputNumberStream.close();

        //プログラムの終了を知らせる文を表示する
        System.out.println(En10_4_Constant.END_PROGRAM_MESSAGE);

    }

    private En10_4_Day inputDateSelection(String inputDateQuestion){
        int selectedDateProcessNumber = 0;  //選択された日付処理の番号のための変数
        int[] inputDates = new int[3];       //ユーザーが入力した年月日を保持するための配列
        En10_4_Day testDate;                  //インスタンスへの参照のための変数

        //日付入力の有無の選択をしてもらうための選択処理のメソッドを呼び出す
        selectedDateProcessNumber = selectProcess(inputDateQuestion);

        //日付入力の選択をユーザーがした場合に、入力処理用のメソッドを呼び出す
        if (selectedDateProcessNumber == 1) {
            //返却された年月日の配列をインスタンス生成のために配列に保持する
            inputDates = userEntryDateProcess();

            //年月日の値を格納した配列の各要素を引数に、年月日のインスタンスを生成し返却された参照を変数に保持する
            testDate = dayInstance(inputDates[0], inputDates[1], inputDates[2]);
        } else {
            //日付の入力がない場合、プログラム実行の日付でインスタンスを生成する
            testDate = new En10_4_Day();
        }

        //設定された日付を表示する
        System.out.printf("\n設定された日付は%04d年%02d月%02d日です。\n", testDate.getYear(), testDate.getMonth(),
                testDate.getDate());

        //日付インスタンスへの参照を呼び出し元に返却する
        return testDate;
    }

    //日付をユーザーが入力の際に必要な処理のメソッド
    private int[] userEntryDateProcess() {
        String isLeapJudge;                  //閏年判定文のための変数
        int[] entryDates = new int[3];      //入力された年月日の値を保持するための配列

        //年の値を入力させるために、引数に年入力の文を渡して入力用メソッドを呼び出す
        entryDates[0] = entryDate(En10_4_Constant.INPUT_YEAR_MESSAGE_STRING);

        //入力された年が閏年であるか調べるためのメソッドを呼び出す。
        isLeapJudge = En10_4_Day.isLeap(entryDates[0]) ? "です。" : "ではありません。";

        //閏年判定の結果を表示して使用者に知らせる
        System.out.printf(En10_4_Constant.LEAP_YEAR_JUDGE_MESSAGE_STRING, entryDates[0], isLeapJudge);

        //日付の入力を促す文を表示する
        System.out.println(En10_4_Constant.INPUT_DATE_MESSAGE_STRING);

        //月の値を入力させるために、引数に月の項目文を渡して入力用メソッドを呼び出す
        entryDates[1] = entryDate(En10_4_Constant.MONTH_INDEX_STRING);

        //日の値を入力させるために、引数に日の項目文を渡して入力用メソッドを呼び出す
        entryDates[2] = entryDate(En10_4_Constant.DAY_INDEX_STRING);

        //日付インスタンスを生成するために、メインメソッドに年月日の値を保持した配列を返却する
        return entryDates;
    }

    //年月日の入力を受け付けるためのメソッド
    private int entryDate(String inputMessage) {
        int inputNumber = 0;                //入力された値を保持するための変数

        //引数で受け取った入力を促す文を表示する
        System.out.print(inputMessage);
        //入力された値をメインメソッドに返却するため、値を保持するための変数に代入する
        inputNumber = inputNumberStream.nextInt();

        //入力された値をメインメソッドに返却する
        return inputNumber;
    }

    //日付インスタンスを生成するためのメソッド
    private En10_4_Day dayInstance(int yearInstance, int monthInstance, int dayInstance) {
        //受け取った引数のインスタンスを生成する
        En10_4_Day testDate = new En10_4_Day(yearInstance, monthInstance, dayInstance);

        //メインメソッドにインスタンスへの参照を返却する
        return testDate;
    }

    //選択肢の処理を実行するためのメソッド
    private int selectProcess(String selectMessage) {
        int selectedProcessNumber = 0;   //入力された選択肢の番号の値のための変数

        //選択内容の表示と選択の入力を促すための文を表示する
        System.out.print(selectMessage);
        //入力された値を返却するために変数に代入して保持する
        selectedProcessNumber = inputNumberStream.nextInt();

        //呼び出し元に選択された値を返却する
        return selectedProcessNumber;
    }

    //受け取った引数で日付に対する処理を呼び出し、返却された結果をメインメソッドに返却するためのメソッド
    private void callDateProcess(En10_4_Day testDate, int processNumber) {
        int dateProcessResult = 0;      //呼び出した日付に対する処理メソッドの結果を保持するための変数

        //引数の値で呼び出す処理を分ける条件式
        switch (processNumber) {
        //経過日数を求めるための処理
        case En10_4_Constant.PROCESS_NUMBER_ZERO:
            //経過日数を求めるためのメソッドの呼び出し
            dateProcessResult = testDate.dayPast(testDate);

            //算出された結果を表示する
            System.out.printf(En10_4_Constant.YEARS_DAY_PAST_RESULT_STRING, dateProcessResult);

            //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //年内残り日数を求めるための処理
        case En10_4_Constant.PROCESS_NUMBER_ONE:
            //その年の残り日数を求めるためのメソッドの呼び出し
            dateProcessResult = testDate.dayLeft();

            //算出された結果を表示する
            System.out.printf(En10_4_Constant.YEARS_DAY_LEFT_RESULT_STRING, dateProcessResult);

            //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //ふたつの日付をインスタンスメソッドで前後判定をするための処理
        case En10_4_Constant.PROCESS_NUMBER_TWO:
            //前後比較のための日付をユーザーに入力してもらう
            En10_4_Day testDate2 = inputDateSelection(En10_4_Constant.SELECT_INPUT_SECONDDATE_OR_NOT);

            //インスタンスメソッドを使用した二つの日付の前後判定結果を出力する
            System.out.printf(En10_4_Constant.INSTANCE_COMPARE_BEFORE_AFTER_DATE_RESULT_STRING,
                    testDate.dayContextCheck(testDate, testDate2) ? "前です。":"後です。");

            //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //二つの日付をクラスメソッドで前後判定するための処理
        case En10_4_Constant.PROCESS_NUMBER_THREE:
            //前後比較のための日付をユーザーに入力してもらう
            En10_4_Day cTestDate = inputDateSelection(En10_4_Constant.SELECT_INPUT_SECONDDATE_OR_NOT);

            //クラスメソッドを使用した二つの日付の前後判定結果を出力する
            System.out.printf(En10_4_Constant.INSTANCE_COMPARE_BEFORE_AFTER_DATE_RESULT_STRING,
                    En10_4_Day.cDayContextCheck(testDate, cTestDate) ? "前です。":"後です。");

            //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //日付を一つ後ろに進めるための処理
        case En10_4_Constant.PROCESS_NUMBER_FOUR:
            //日付を一つ後ろに進めるためのメソッドを呼び出す
            testDate.moveOneDayForward(testDate);

            //進めた結果を表示するためのprintfメソッド
            System.out.printf(En10_4_Constant.MOVE_NEXT_DAY_RESULT_STRING, testDate.getYear(), testDate.getMonth(), testDate.getDate());

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //次の日の日付を返却するための処理
        case En10_4_Constant.PROCESS_NUMBER_FIVE:
            //翌日の日付の結果のための変数
            Calendar oneDayAfterResult = Calendar.getInstance();
            int year = 0;                   //翌日の日付結果の年のための変数
            int month = 0;                  //翌日の日付結果の月のための変数
            int date = 0;                   //翌日の日付結果の日のための変数

            //翌日の日付を求めるメソッドを呼び出し、返却された値を変数に代入する
            oneDayAfterResult = testDate.giveBackNextDay();

            //返却された値から年を取得し、結果表示のための変数に代入する
            year = oneDayAfterResult.get(Calendar.YEAR);
            //返却された値から月を取得し、結果表示のための変数に代入する
            month = oneDayAfterResult.get(Calendar.MONTH);
            //返却された値から日を取得し、結果表示のための変数に代入する
            date = oneDayAfterResult.get(Calendar.DATE);

            //求めた翌日の日付を表示するためのprintfメソッド
            System.out.printf(En10_4_Constant.NEXT_DAY_RESULT_STRING, year, month, date);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;
        //日付を一つ前に戻すための処理
        case En10_4_Constant.PROCESS_NUMBER_SIX:
            //日付を一日戻すためのメソッドを呼び出す
            testDate.moveOneDayBack(testDate);

            //日付を戻した結果を表示するための出力
            System.out.printf(En10_4_Constant.MOVE_BEFORE_DAY_RESULT_STRING, testDate.getYear(), testDate.getMonth(), testDate.getDate());

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;
        //前日の日付を返却するための処理
        case En10_4_Constant.PROCESS_NUMBER_SEVEN:
            Calendar oneDayBeforeResult = Calendar.getInstance();            //求めた前日の日付の値のための変数
            int dayBeforeYear = 0;                   //前日の日付結果の年のための変数
            int dayBeforeMonth = 0;                  //前日の日付結果の月のための変数
            int dayBeforeDate = 0;                   //前日の日付結果の日のための変数

            //前日の日付を求めるためのメソッドの呼び出し
            oneDayBeforeResult = testDate.giveBackDayBefore();

            //返却された値から年の値を取得し、結果表示のための変数に代入する
            dayBeforeYear = oneDayBeforeResult.get(Calendar.YEAR);
            //返却された値から月の値を取得し、結果表示のための変数に代入する
            dayBeforeMonth = oneDayBeforeResult.get(Calendar.MONTH);
            //返却された値から日の値を取得し、結果表示のための変数に代入する
            dayBeforeDate = oneDayBeforeResult.get(Calendar.DATE);

            //求めた前日の日付の結果を表示するための出力
            System.out.printf(En10_4_Constant.BEFORE_DAY_RESULT_STRING, dayBeforeYear, dayBeforeMonth, dayBeforeDate);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //指定日数日付を進めるための処理
        case En10_4_Constant.PROCESS_NUMBER_EIGHT:
            int moveDays = 0;                                    //指定日数のための変数
            long moveDaysResult = 0;                            //日付の計算結果のための変数

            //指定日数を入力してもらうためのメソッドの呼び出し
            moveDays = entryDate(En10_4_Constant.INPUT_DAYS_NUMBER);

            //日付を指定日進めるためのメソッドの呼び出し
            moveDaysResult = testDate.moveSomeDateForward(moveDays);

            //日付を指定日進めた結果を表示するためのメソッドの呼び出し
            showResult(En10_4_Constant.MOVE_DAY_FORWARD_RESULT_STRING, moveDays, moveDaysResult);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //指定日後の日付を返却するための処理
        case En10_4_Constant.PROCESS_NUMBER_NINE:
            int sendDaysNumber = 0;                             //指定日数のための変数
            long dateResult = 0;                                //日付の計算結果のミリ秒のための変数

            //指定日数を入力してもらうためのメソッドの呼び出し
            sendDaysNumber = entryDate(En10_4_Constant.INPUT_DAYS_NUMBER);

            //指定日後の日付を計算するためのメソッドの呼び出し
            dateResult = testDate.sendBackDayAfter(sendDaysNumber);

            //指定日数後の日付の結果を表示するためのメソッドの呼び出し
            showResult(En10_4_Constant.DAY_AFTER_RESULT_STRING, sendDaysNumber, dateResult);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //指定日数日付を戻すための処理
        case En10_4_Constant.PROCESS_NUMBER_TEN:
            int specifiedDaysForward = 0;                      //指定日数のための変数
            long setDayBeforeResult = 0;                       //日付を戻した結果のための変数

            //指定日数を入力してもらうためのメソッドの呼び出し
            specifiedDaysForward = entryDate(En10_4_Constant.INPUT_DAYS_NUMBER);
            //日付を指定日戻すためのメソッドの呼び出し
            setDayBeforeResult = testDate.moveSomeDayBack(specifiedDaysForward);

            //日付を戻した結果を表示するためのメソッドの呼び出し
            showResult(En10_4_Constant.MOVE_DAY_BACK_RESULT_STRING, specifiedDaysForward, setDayBeforeResult);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        //指定日数前の日付を返却するための処理
        case En10_4_Constant.PROCESS_NUMBER_ELEVEN:
            int specifiedDaysBack = 0;                          //指定日数のための変数
            long dayBeforeResult = 0;                           //指定日前の結果の日付のための変数

            //指定日数を入力してもらうためのメソッドの呼び出し
            specifiedDaysBack = entryDate(En10_4_Constant.INPUT_DAYS_NUMBER);

            //指定日前の日付を計算するためのメソッドの呼び出し
            dayBeforeResult = testDate.sendBackDayBefore(specifiedDaysBack);

            //指定日前の結果を表示するためのメソッドの呼び出し
            showResult(En10_4_Constant.DAY_BEFORE_RESULT_STRING, specifiedDaysBack, dayBeforeResult);

          //処理が次の分岐に流れないよう条件分岐から抜ける
            break;

        default :
            //選択肢以外の不正な値が入力された場合に通知するための出力
            System.out.println("無効な値です。0～11を入力してください。");

            break;
        }

    }

    //結果を表示するためのメソッド
    private void showResult(String resultMessage, int specifiedDates, long resultDateValue){
        //引数で受け取ったミリ秒の値を指定した文字列に変換するためのフォーマット
        SimpleDateFormat resultDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        //引数のミリ秒の値をフォーマットし、表示のための変数に代入する
        String dateFormat = resultDateFormat.format(resultDateValue);

        //結果文とともに求めた年月日の結果を表示するためのprintfメソッド
        System.out.printf(resultMessage, specifiedDates, dateFormat);
    }

}
