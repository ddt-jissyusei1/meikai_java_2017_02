

/*
 * 演習10-4で使用する定数が多量になったため、別クラスとしてまとめた定数クラス
 */
public class En10_4_Constant {
    //プログラムの説明文のための定数
    protected static final String PROGRAM_EXPLANATION_STRING = "このプログラムは日付クラスを利用したテストプログラムです。";
    //日付入力の有無を選択させるための質問文の定数
    protected static final String SELECT_INPUT_DATE_OR_NOT = "日付を入力しますか？（しない場合は今日の日付が設定されます）"
                                                                   + "はい　>>　1、いいえ　>>　2 :";
    //二つ目の日付入力の有無を選択させるための質問文の定数
    protected static final String SELECT_INPUT_SECONDDATE_OR_NOT = "二つ目の日付を入力しますか？（しない場合は今日の日付が設定されます）"
                                                                   + "はい　>>　1、いいえ　>>　2 :";
    //ユーザーに年の入力を促す文のための定数
    protected static final String INPUT_YEAR_MESSAGE_STRING = "年を西暦で入力してください：";
    //入力された年が閏年であるかの判定文のための定数
    protected static final String LEAP_YEAR_JUDGE_MESSAGE_STRING = "%d年は閏年%s";
    //日付の入力を促す文のための定数
    protected static final String INPUT_DATE_MESSAGE_STRING = "日付を入力してください。";
    //年の項目表示のための定数
    protected static final String YEAR_INDEX_STRING = "年:";
    //月の項目表示のための定数
    protected static final String MONTH_INDEX_STRING = "月:";
    //日の項目表示のための定数
    protected static final String DAY_INDEX_STRING = "日:";
    //設定した日付に対する処理の選択を促す文のための定数
    protected static final String SELECT_PROCESS_FOR_DATE_MESSAGE = "\n設定した日付に対して行う処理の番号を選択してください。"
            + "\n0.年内での経過日数を求める。\n1.年内の残りの日数を求める。"
            + "\n2.他の日付との前後関係を求める。（インスタンスメソッド使用）"
            + "\n3.他の日付との前後関係を求める。（クラスメソッド使用）\n4.日付を一つ後ろに進める。"
            + "\n5.次の日の日付を求める。\n6.日付を一つ前に進める。\n7.前の日の日付を求める。"
            + "\n8.日付を指定日数後ろに進める。\n9.指定数日後の日付を求める。"
            + "\n10.日付を指定日数前に進める。\n11.指定日数前の日付を求める。\n>>";
    //0番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_ZERO = 0;
    //1番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_ONE = 1;
    //2番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_TWO = 2;
    //3番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_THREE = 3;
    //4番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_FOUR = 4;
    //5番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_FIVE = 5;
    //6番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_SIX = 6;
    //7番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_SEVEN = 7;
    //8番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_EIGHT = 8;
    //9番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_NINE = 9;
    //10番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_TEN = 10;
    //11番目の処理選択肢のための定数
    protected static final int PROCESS_NUMBER_ELEVEN = 11;
    //年内での経過日数の結果を表示するための文の定数
    protected static final String YEARS_DAY_PAST_RESULT_STRING = "年内での経過日数は%d日です。";
    //年内の残り日数の結果を表示するための文の定数
    protected static final String YEARS_DAY_LEFT_RESULT_STRING = "年内の残りの日数は%d日です。";
    //インスタンスメソッドによる他の日付との前後関係を判定した結果を表示する文のための定数
    protected static final String INSTANCE_COMPARE_BEFORE_AFTER_DATE_RESULT_STRING = "最初の日付は二つ目の日付よりも%s";
    //クラスメソッドによる他の日付との前後関係を判定した結果を表示する文のための定数
    protected static final String CLASS_COMPARE_BEFORE_AFTER_DATE_RESULT_STRING =
                                                                            "クラスメソッドによる他の日付との前後関係の判定は：";
    //日付を一つ後ろに進めた結果を表示する文のための定数
    protected static final String MOVE_NEXT_DAY_RESULT_STRING = "一日後ろに進めた日付:%d年%d月%d日";
    //次の日の日付を表示する文のための定数
    protected static final String NEXT_DAY_RESULT_STRING ="次の日の日付:%d年%d月%d日";
    //日付を一つ前に進めた結果を表示する文のための定数
    protected static final String MOVE_BEFORE_DAY_RESULT_STRING ="一日前の日付:%d年%d月%d日";
    //前の日の日付を表示する文のための定数
    protected static final String BEFORE_DAY_RESULT_STRING ="前の日の日付:%d年%d月%d日";
    //指定日数の入力を促す文のための定数
    protected static final String INPUT_DAYS_NUMBER = "\n日数を指定してください:";
    //日付を指定数日後ろに進めた結果を表示する文のための定数
    protected static final String MOVE_DAY_FORWARD_RESULT_STRING ="日付を%d日進めました：%s";
    //指定数日後の日付を表示する文のための定数
    protected static final String DAY_AFTER_RESULT_STRING ="%d日後の日付：%s";
    //日付を指定数日前に戻した結果を表示するための定数
    protected static final String MOVE_DAY_BACK_RESULT_STRING = "日付を%d日戻しました：%s";
    //指定数日前の日付を表示する文のための定数
    protected static final String DAY_BEFORE_RESULT_STRING = "%d日前の日付:%s";
    //プログラムの繰り返し可否の質問文のための定数
    protected static final String REPEAT_PROGRAM_QUESTION = "\n\nもう一度プログラムをやりますか？"
                                                                            + "はい　>>　1、いいえ　>>　0 :";
    //プログラムの終了文のための定数
    protected static final String END_PROGRAM_MESSAGE = "プログラムを終了します。お疲れさまでした。";

}
