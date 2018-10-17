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
    //加算するいくつ目の数値であるかを表す項目名のための定数
    private static final String ADDING_NUMBER_COLUMN_STRING = "%dつ目の整数値：";
    //計算結果を通知する文のための定数
    private static final String CALC_RESULT_MESSAGE = "\nそれらの和は%dです。\n";
    //プログラムの繰り返し可否の質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION = "\nもう一度やりますか？はい>>>1、いいえ>>>0 :";
    //プログラムの終了を通知する文のための定数
    private static final String EXIT_PROGRAM_MESSAGE = "\nプログラムを終了します。お疲れさまでした。";

    //加算数値入力ループのカウンタ変数初期化のための定数
    private static final int INPUT_LOOP_COUNTER_INITIALIZE_NUMBER = 0;
    //加算結果を保持する変数の初期化のための定数
    private static final int ADD_RESULT_INITIALIZE_NUMBER = 0;
    //加算する数値を保持する配列の要素数のための定数
    private static final int ADD_NUMBER_ARRAY_INDEX_NUMBER = 2;
    //範囲設定数値の最小値のための定数
    private static final int MIN_RANGE_NUMBER = 0;
    //範囲設定数値の最大値のための定数
    private static final int MAX_RANGE_NUMBER = 9;
    //繰り返し判定で『はい』の選択値のための定数
    private static final int SELECTION_NUMBER_FOR_YES = 1;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //加算する数値を保持するための配列の宣言
        int[] addNumbers = new int[ADD_NUMBER_ARRAY_INDEX_NUMBER];
        int addNumberLoop;                  //加算数値入力用ループのためのカウンタ変数
        int repeatJudge;                    //プログラム繰り返し判定用数値を保持するための変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするためのループ処理
        do{
            //ユーザーに加算するための数値の入力を促す文を表示するための出力
            System.out.println(INPUT_ADDING_NUMBER_MESSAGE);

            //複数の加算数値の入力受付と配列の要素へ保持するためのループ処理
            for(addNumberLoop = INPUT_LOOP_COUNTER_INITIALIZE_NUMBER; addNumberLoop < ADD_NUMBER_ARRAY_INDEX_NUMBER; addNumberLoop++){
                //いくつめの入力であることを通知する項目名を表示するための出力
                System.out.printf(ADDING_NUMBER_COLUMN_STRING,addNumberLoop+1);
                //入力された値を計算のために変数に保持する
                addNumbers[addNumberLoop] = inputStream.nextInt();
            }

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
        }while(repeatJudge == SELECTION_NUMBER_FOR_YES);

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
        int addResult = ADD_RESULT_INITIALIZE_NUMBER;    //加算結果を保持するための変数を0で初期化

        //範囲外検査をするための加算する数値を保持した配列の拡張for文
        for(int objAddNumber : addNumbers){
            //オブジェクト変数に保持した値が1桁ではない場合に実行する処理のための条件式
            if(!isValid(objAddNumber)){
                //例外ハンドラにパラメータ範囲外例外を渡すための送出。
                throw new En16_2_ParameterRangeError(objAddNumber);
            }
            //配列の要素の値を加算するための加算結果への加算代入
            addResult += objAddNumber;
        }

        //計算結果が一桁ではない場合に範囲外例外を送出するための条件式
        if(!isValid(addResult)){
            //例外ハンドラに計算結果範囲外例外を渡すための送出
            throw new En16_2_ResultRangeError(addResult);
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
