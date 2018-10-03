package ensyuu16_2;

import java.util.Scanner;

/*
 *List16-6(p.523)のtry文では、ParameterRangeError例外とResultRangeError例外を別々の例外ハンドラで捕捉している。
 *単一の例外ハンドラで捕捉するように変更したプログラムを作成せよ。
 */
public class En16_2_RangeErrorTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "範囲外例外を単一の例外ハンドラで捕捉した計算テストプログラムです。"
                                                                   + "\n加算する数と計算結果が0～9の範囲外のとき例外となります。";
    //ユーザーに加算する数値の入力を促す文のための定数
    private static final String INPUT_ADDING_NUMBER_MESSAGE = "\n加算する整数0～9の数値を二つ入力してください。";
    //加算する一つ目の数値を表す項目名のための定数
    private static final String FIRST_ADDING_NUMBER_COLUMN_STRING = "一つ目の整数値：";
    //加算する二つ目の数値を表す項目名のための定数
    private static final String SECOND_ADDING_NUMBER_COLUMN_STRING = "二つ目の整数値：";
    //計算結果を通知する文のための定数
    private static final String CALC_RESULT_MESSAGE = "\nそれらの和は%dです。\n";
    //加える数が範囲外だと通知する文のための定数
    private static final String PARAMETER_RANGE_ERROR_MESSAGE = "\n加える数が範囲外です。";
    //計算結果が範囲外だと通知する文のための定数
    private static final String RESULT_RANGE_ERROR_MESSAGE = "\n計算結果が範囲外です。";
    //プログラムの繰り返し可否の質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION = "もう一度やりますか？はい>>>1、いいえ>>>0 :";
    //プログラムの終了を通知する文のための定数
    private static final String EXIT_PROGRAM_MESSAGE = "\nプログラムを終了します。お疲れさまでした。";

    //加算する数値を保持する配列の要素数のための定数
    private static final int ADD_NUMBER_ARRAY_INDEX_NUMBER = 2;
    //加算する数値の配列の一つ目の要素のインデックス番号のための定数
    private static final int ADD_NUMBER_ARRAY_FIRST_INDEX = 0;
    //加算する数値の配列の二つ目の要素のインデックス番号のための定数
    private static final int ADD_NUMBER_ARRAY_SECOND_INDEX = 1;
    //範囲設定数値の最小値のための定数
    private static final int MIN_RANGE_NUMBER = 0;
    //範囲設定数値の最大値のための定数
    private static final int MAX_RANGE_NUMBER = 9;
    //繰り返し判定で『はい』の選択値のための定数
    private static final int SELECT_NUMBER_FOR_YES = 1;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //加算する数値を保持するための配列の宣言
        int[] addNumbers = new int[ADD_NUMBER_ARRAY_INDEX_NUMBER];
        int repeatJudge;                    //プログラム繰り返し判定用数値を保持するための変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするためのループ処理
        do{
            //ユーザーに加算するための数値の入力を促す文を表示するための出力
            System.out.println(INPUT_ADDING_NUMBER_MESSAGE);

            //一つ目の数の入力であることを通知する項目名を表示するための出力
            System.out.print(FIRST_ADDING_NUMBER_COLUMN_STRING);
            //入力された値を計算のために変数に保持する
            addNumbers[ADD_NUMBER_ARRAY_FIRST_INDEX] = inputStream.nextInt();

            //二つ目の数の入力であることを通知する項目名を表示するための出力
            System.out.print(SECOND_ADDING_NUMBER_COLUMN_STRING);
            //入力された値を計算のために変数に保持する
            addNumbers[ADD_NUMBER_ARRAY_SECOND_INDEX] = inputStream.nextInt();

            //範囲外例外を捕捉するための例外処理
            try{
                //計算結果を通知するための出力
                System.out.printf(CALC_RESULT_MESSAGE,calcAdd(addNumbers));

            //捕捉した範囲外例外のための例外ハンドラ
            }catch(En16_2_RangeError e){
                //例外の詳細文字列を取得し表示するための出力
                System.out.println(e.getMessage());
            }

            //プログラムの繰り返し可否の質問文を表示するための出力
            System.out.print(REPEAT_PROGRAM_QUESTION);
            //繰り返し判定用に入力された値を変数に保持する
            repeatJudge = inputStream.nextInt();

        //入力された値が1の間プログラムを繰り返すための条件式
        }while(repeatJudge == SELECT_NUMBER_FOR_YES);

        //プログラムの終了を通知する文を表示するための出力
        System.out.println(EXIT_PROGRAM_MESSAGE);
    }


    /**
     * 1桁の整数二つを加算し結果を返却するためのメソッド</br>
     * 作成日：2018/10/03</br>
     * 作成者：志田</br>
     * @param addNumbers 加算する数値を保持した配列
     * @return addResult 加算結果の値の返却
     */
    public static int calcAdd(int[] addNumbers){
        int addResult;                      //加算結果を保持するための変数

        //範囲外検査をするための加算する数値を保持した配列の拡張for文
        for(int objAddNumber : addNumbers){
            //オブジェクト変数に保持した値が1桁ではない場合に実行する処理のための条件式
            if(!isValid(objAddNumber)){
                //例外ハンドラにパラメータ範囲外例外を渡すための送出。
                throw new En16_2_ParameterRangeError(PARAMETER_RANGE_ERROR_MESSAGE,objAddNumber);
            }
        }

        //二つの引数の値を加算する
        addResult = addNumbers[ADD_NUMBER_ARRAY_FIRST_INDEX] + addNumbers[ADD_NUMBER_ARRAY_SECOND_INDEX];

        //計算結果が一桁ではない場合に範囲外例外を送出するための条件式
        if(!isValid(addResult)){
            //例外ハンドラに計算結果範囲外例外を渡すための送出
            throw new En16_2_ResultRangeError(RESULT_RANGE_ERROR_MESSAGE,addResult);
        }

        //計算結果を呼び出し元に返却する
        return addResult;

    }


    /**
     * 引数の値が1桁であるか判定するためのメソッド</br>
     * 作成日：2018/10/03</br>
     * 作成者：志田</br>
     * @param checkNumber 一桁であるか判定する数値
     * @return boolean    数値が一桁である真偽値の返却
     */
    public static boolean isValid(int checkNumber){
        //引数の値が一桁である判定を真偽値で返却する
        return checkNumber >= MIN_RANGE_NUMBER && checkNumber <= MAX_RANGE_NUMBER;
    }

}
