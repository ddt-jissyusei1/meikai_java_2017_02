package ensyuu16;

import java.util.Scanner;

/*
 * 前問と同様に、List16-8(p.526)のメソッドreverseに対して、仮引数aに受け取った参照が空参照であった場合に、
 * 何らかの対処を行うように変更したプログラムを作成せよ。
 *
 */
public class En16_4_ReverseArraySecondTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "メソッドreverseで受け取った仮引数が空参照であった場合に"
                                                               + "別の例外として送出する対処を行うテストプログラムです。";
    //配列の要素数の入力をユーザーに促すための文の定数
    private static final String INPUT_ARRAY_INDEX_MESSAGE = "\n並びを反転する配列の要素数を入力してください。"
                                                               + "\n要素数が奇数で空参照例外が発生します。\n要素数：";
    //要素の値の入力をユーザーに促すための文の定数
    private static final String INPUT_ARRAY_VALUE_MESSAGE = "\n要素の値を入力してください。";
    //要素の値入力時に表示する項目番号のための定数
    private static final String ARRAY_INDEX_STRING = "reverseArrays[%d] = ";
    //要素の並びを反転した結果を通知するための文の定数
    private static final String REVERSE_RESULT_MESSAGE = "\n要素の並びを反転しました。";
    //空参照例外が発生したことを通知する文のための定数
    private static final String NULLPOINTER_EXCEPTION_MESSAGE = "空参照例外が発生しました！";
    //不正添字例外が発生したことを通知する文のための定数
    private static final String OUTOFBOUNDS_EXCEPTION_MESSAGE = "不正添字例外が発生しました！";
    //例外内容を表示する文のための定数
    private static final String EXCEPTION_STRING = "例外　　　：";
    //例外の原因を表示する文のための定数
    private static final String EXCEPTION_CAUSE_STRING = "例外の原因：";
    //捕捉した例外を別の例外として送出する際に表示する文のための定数
    private static final String OTHER_EXCEPTION_MESSAGE = "reverseのバグ？";
    //反転した結果を表示する項目番号のための定数
    private static final String RESULT_ARRAY_INDEX_STRING = "reverseArray[%d] = %d\n";
    //プログラムの繰り返しの可否の入力を促す文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\nもう一度やりますか？\nはい>>>1、いいえ>>>0：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_STRING = "\nプログラムを終了します。お疲れ様でした。";

    //変数初期化用の値の定数
    private static final int INITIALIZE_NUMBER = 0;
    //繰り返し判定可のための値の定数
    private static final int REPEAT_PROGRAM_YES = 1;

    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputValue = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int reverseArrayAmounts = INITIALIZE_NUMBER;       //並びを反転する配列の要素数のための変数

        //ユーザーが希望するだけプログラムを繰り返せるための繰り返し処理
        do{
            //並びを反転する配列の要素数の入力を促すための文の出力
            System.out.print(INPUT_ARRAY_INDEX_MESSAGE);
            //入力された値を配列の宣言のため変数に保持する
            reverseArrayAmounts = inputValue.nextInt();

            //要素の並びを反転するための配列の宣言
            int[] reverseArrays = new int[reverseArrayAmounts];

            //要素数が奇数の場合に実行する処理のための分岐
            if (reverseArrayAmounts%2 == 1){
                //空参照例外を発生させるための配列へのnull代入
                reverseArrays = null;

            //奇数以外の場合に実行する処理のための分岐
            }else{
                //要素の入力を促すための文の表示
                System.out.println(INPUT_ARRAY_VALUE_MESSAGE);
                //反転する要素の値の入力のためのメソッドの呼び出し
                reverseArrays = inputArrayValue(reverseArrayAmounts);
            }

            //再送出された例外を捕捉するためのtryブロック
            try{
                //配列の並びを反転するためのメソッドの呼び出し
                reverse(reverseArrays);

                //要素の並びを反転したことを通知するための文の出力
                System.out.println(REVERSE_RESULT_MESSAGE);
                //反転した結果を表示するためのメソッドの呼び出し
                showReverseArray(reverseArrays);

            //捕捉した再送出例外のための例外ハンドラ
            }catch(RuntimeException e){
                //例外内容を表示するための出力
                System.out.println(EXCEPTION_STRING + e);
                //例外の原因を表示するための出力
                System.out.println(EXCEPTION_CAUSE_STRING + e.getCause());
            }

        //プログラム繰り返し判定メソッドの返り値が真の間処理を繰り返すための条件式
        }while(repeatProgram());

        //プログラムの終了を通知する文の表示のための出力
        System.out.println(QUIT_PROGRAM_STRING);
    }

    /**
     * 配列の要素の値の入力処理のためのメソッド</br>
     * 作成日：2018/11/14</br>
     * 作成者：志田</br>
     *
     * @param arrayLength        要素の値入力のための配列の長さ
     * @return inputResultArrays 要素の値が入力された配列の返却
     */
    public static int[] inputArrayValue(int arrayLength){
        int[] inputResultArrays = new int[arrayLength];     //要素の値を入力するための配列の宣言
        int inputLoopCount;                                  //要素の値入力の繰り返し処理で使用するためのカウンタ変数

        //要素の数だけ値の入力を繰り返すための処理
        for(inputLoopCount = 0; inputLoopCount < arrayLength; inputLoopCount++){
            //入力する要素番号を表示するための出力
            System.out.printf(ARRAY_INDEX_STRING, inputLoopCount);
            //入力された値を要素に保持する
            inputResultArrays[inputLoopCount] = inputValue.nextInt();
        }
        //入力が終わった配列を要素の並び反転のため呼び出しもとに返却する
        return inputResultArrays;
    }

    /**
     * 配列の要素の並びを反転するためのメソッド</br>
     * 作成日：2018/11/14</br>
     * 作成者：志田</br>
     *
     * @param reverseArrays 要素の並びを反転する配列
     */
    static void reverse(int[] reverseArrays){
        //例外を捕捉するためのブロック
        try{
            int reverseLoopCount;                            //並びを反転する繰り返し処理で使用するためのカウンタ変数
            int arrayLength = reverseArrays.length;          //並びを反転する繰り返し処理で使用するための配列の長さの取得

            //並びを反転するため配列の半分の長さの間繰り返すための処理
            for(reverseLoopCount = 0;reverseLoopCount < arrayLength/2; reverseLoopCount++){
                //要素の値を入れ替えるためのメソッドの呼び出し
                swap(reverseArrays, reverseLoopCount, arrayLength - reverseLoopCount - 1);
            }
        //捕捉した不正添字例外に対処するための例外ハンドラ
        }catch(ArrayIndexOutOfBoundsException e){
            //捕捉した例外を別の例外として送出するためのthrow文
            throw new RuntimeException(OUTOFBOUNDS_EXCEPTION_MESSAGE + OTHER_EXCEPTION_MESSAGE,e);
        //捕捉した空参照例外に対処するための例外ハンドラ
        }catch(NullPointerException e){
            //捕捉した例外を別の例外として送出するためのthrow文
            throw new RuntimeException(NULLPOINTER_EXCEPTION_MESSAGE,e);
        }
    }

    /**
     * 並びを反転するため要素の値を入れ替えるためのメソッド</br>
     * 作成日：2018/11/14</br>
     * 作成者：志田</br>
     *
     * @param reverseArrays 要素を入れ替える配列
     * @param indexFirst    入れ替え先の要素の値
     * @param baseIndex     入れ替え元の要素の値
     */
    public static void swap(int[] reverseArrays, int indexFirst, int baseIndex){
        int escapeValue = INITIALIZE_NUMBER;                 //入れ替えのための値退避用変数

        //値の入れ替えのための退避用変数への代入
        escapeValue = reverseArrays[indexFirst];
        //空いた要素へ移動元要素の値を代入
        reverseArrays[indexFirst] = reverseArrays[baseIndex];
        //移動して空いた要素へ退避していた値を代入
        reverseArrays[baseIndex] = escapeValue;
    }

    /**
     * 配列の要素の並びを表示するためのメソッド</br>
     * 作成日：2018/11/14</br>
     * 作成日：志田</br>
     *
     * @param reverseResultArrays 要素の並びを判定した配列
     */
    public static void showReverseArray(int[] reverseResultArrays){
        int indexCounter = INITIALIZE_NUMBER;                //表示する配列の添え字のためのカウント変数

        //仮引数の配列の要素を順に表示するための拡張for文
        for(int arrayValue: reverseResultArrays){
            //配列の要素を表示するための出力
            System.out.printf(RESULT_ARRAY_INDEX_STRING,indexCounter,arrayValue);
            //次の要素の表示のために添え字のカウントを加算する
            indexCounter++;
        }
    }

    /**
     * プログラムの繰り返し判定のためのメソッド</br>
     * 作成日：2018/11/14</br>
     * 作成者：志田</br>
     *
     * @return repeatJudge プログラム繰り返しの真偽値
     */
    public static boolean repeatProgram(){
        int repeatJudge = INITIALIZE_NUMBER;                //入力されたプログラム繰り返し可否判定数値のための変数

        //プログラムの繰り返し可否の入力をユーザーに促すための文の出力
        System.out.print(REPEAT_PROGRAM_QUESTION_MESSAGE);
        //入力された値を式の評価のために変数に保持する
        repeatJudge = inputValue.nextInt();

        //繰り返し可否判定式の評価の真偽値を呼び出しもとに返却する
        return repeatJudge == REPEAT_PROGRAM_YES;
    }

}
