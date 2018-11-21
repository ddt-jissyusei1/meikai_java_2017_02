package ensyuu16;

import java.util.Scanner;

/*
 * List16-7(p.524)のメソッドreverseは、仮引数aに受け取った参照が空参照でないことを前提としている。
 * 受け取ったのが空参照であった場合に、何らかの対処を行うように変更したプログラムを作成せよ。
 * ※Column16-2(p.527)に示す NullPointerException を捕捉して対処すること。
 */
public class En16_3_ReversArrayTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "配列の要素の並びを反転する際、"
                                                                + "\n仮引数に受け取った参照が空参照だった場合に例外発生を通知して、"
                                                                + "\nプログラムを中断するテストプログラムです。";
    //並びを反転する配列の要素数の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_INDEX_NUMBER = "\n要素の並びを反転する配列の要素数を入力してください。"
                                                                      + "\n要素数が偶数で空参照例外が発生します。";
    //要素数入力時に表示する項目目のための定数
    private static final String ARRAY_INDEX_AMOUNT_COLUMN_STRING = "要素数：";
    //並びを反転する配列の要素の値の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_VALUE_MESSAGE = "\n要素の値を入力してください。";
    //要素の値入力時に表示する要素番号のための定数
    private static final String ARRAY_INDEX_COLUMN_STRING = "reverseArrays[%d]:";
    //要素の値の結果を表示時に出力する要素番号のための定数
    private static final String RESULT_ARRAY_INDEX_COLUMN_STRING = "reverseArrays[%d]:%d\n";
    //要素の並びを反転したことを通知する文のための定数
    private static final String REVERSE_ARRAY_RESULT_MESSAGE = "\n要素の並びを反転しました。";
    //プログラムの繰り返し可否の質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "\nもう一度やりますか？はい>>>1、いいえ>>>0：";
    //空参照例外を通知する文のための定数
    private static final String NULL_POINTER_EXCEPTION_MESSAGE = "\n空参照例外が発生しました。"
                                                                    + "\n例外発生箇所を出力し、処理を中断します。";

    //プログラム繰り返しの「可」の判定番号のための定数
    private static final int REPEAT_PROGRAM_YES_NUMBER = 1;

    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputReverseTestNumber = new Scanner(System.in);

    public static void main(String[] args){
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int arrayIndexAmount = 0;                           //並びを反転する配列の要素数のための変数
        boolean reverseProcessResult;                      //並び反転処理結果真偽値のための変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            //並びを反転する配列の要素数の入力をするためのメソッドの呼び出し
            arrayIndexAmount = inputArrayLength();

            //並びを反転するための配列の宣言(要素数が偶数であれば空参照例外を発生させるため空リテラルを代入する)
            int[] reverseArrays = arrayIndexAmount%2 == 0 ? null : inputArrayValue(arrayIndexAmount);

            //要素の並びを反転するためのメソッドの呼び出し
            reverseProcessResult = reverse(reverseArrays);

            //反転処理結果が偽の場合に実行するための条件式
            if (!reverseProcessResult) {
                //処理を中断するためのコード
                break;
            }

            //反転した要素の並びの結果を表示するための配列の要素表示メソッドの呼び出し
            showArrayValues(REVERSE_ARRAY_RESULT_MESSAGE, reverseArrays);

         //プログラムの繰り返しを判定するための条件式
         }while(repeatProgram() == REPEAT_PROGRAM_YES_NUMBER);
    }

    /**
     *配列の要素数の入力処理を行うためのメソッド</br>
     *作成日：2018/10/31</br>
     *作成者：志田</br>
     *
     * @return arrayIndexAmount 配列の要素数の値を返却する
     */
    public static int inputArrayLength(){
        int arrayIndexAmount = 0;                          //配列の要素数のための変数

        //要素の並びを反転する配列の要素数の入力を促す文を表示するための出力
        System.out.println(INPUT_REVERSE_ARRAY_INDEX_NUMBER);

        //入力された要素数の値が0以下の間入力処理を繰り返すための繰り返し処理
        do{
            //入力する要素数の項目名を表示するための出力
            System.out.print(ARRAY_INDEX_AMOUNT_COLUMN_STRING);
            //並びを反転する配列を生成するために入力された値を変数に保持する
            arrayIndexAmount = inputReverseTestNumber.nextInt();

        //入力された値が自然数ではない判定が真の間繰り返すための条件式
        }while(isNotNaturalNumber(arrayIndexAmount));

        //要素数の値を呼び出し元に返却する
        return arrayIndexAmount;
    }

    /**
     * 入力された要素数の値が自然数ではないという判定をするためのメソッド</br>
     * 作成日：2018/10/31</br>
     * 作成者：志田</br>
     *
     * @param checkNumber 自然数であるか判定する値
     * @return boolean 自然数ではないという判定結果を真偽値で返却
     */
    public static boolean isNotNaturalNumber(int checkNumber){
        //仮引数が0以下の場合に真を呼び出し元に返却する
        return checkNumber <= 0;
    }

    /**
     * 配列の要素の値をユーザーに入力してもらうための入力処理メソッド</br>
     * 作成日：2018/10/31</br>
     * 作成者：志田</br>
     *
     * @param arrayLength 入力する配列の長さの値
     * @return inputResultArrays 要素の値の入力が完了した配列の返却
     */
    public static int[] inputArrayValue(int arrayLength){

        int[] inputResultArrays = new int[arrayLength];     //要素の値を保持するための配列宣言
        int inputArrayValueLoopCount;                       //要素の値入力の繰り返しのためのカウンタ変数

        //要素の値の入力を促す文を表示するための出力
        System.out.println(INPUT_REVERSE_ARRAY_VALUE_MESSAGE);

        //要素数の数だけ入力を繰り返すための繰り返し処理
        for(inputArrayValueLoopCount = 0; inputArrayValueLoopCount < arrayLength; inputArrayValueLoopCount++){
            //値を入力する要素の要素番号を表示するための出力
            System.out.printf(ARRAY_INDEX_COLUMN_STRING,inputArrayValueLoopCount);
            //入力された値を保持するために配列の要素に代入する
            inputResultArrays[inputArrayValueLoopCount] = inputReverseTestNumber.nextInt();
        }
        //要素の値の入力が完了した配列を呼び出し元に返却する
        return inputResultArrays;
    }

    /**
     *  配列の要素の並びを反転するための繰り返しメソッド</br>
     *  作成日：2018/10/24</br>
     *  作成者：志田</br>
     *
     * @param reverseArrays 要素の値の並びを反転させる配列
     */
    public static boolean reverse(int[] reverseArrays){
        //発生した例外を送出するためのブロック
        try{
            int reverseArrayLength = reverseArrays.length;  //並びを反転する繰り返し処理の制御に使用するための配列の長さの取得

            //要素の値の並びを反転するための繰り返す処理
            for(int reverseLoopCount = 0; reverseLoopCount < reverseArrayLength/2; reverseLoopCount++){
                //要素の値を入れ替えるためのメソッドの呼び出し
                swap(reverseArrays, reverseLoopCount, reverseArrayLength - reverseLoopCount-1);
            }

         //捕捉した空参照例外のための例外ハンドラ
         }catch(NullPointerException e){

            //空参照例外が発生したことを通知するための文の表示
            System.out.println(NULL_POINTER_EXCEPTION_MESSAGE);
            //例外が発生した箇所を遡って表示するための出力
            e.printStackTrace();
            //処理を中断するため反転失敗の判定値を呼び出しもとに返却する
            return false;

        //捕捉した範囲外の配列添字例外に対する処理を行うための例外ハンドラ
        }catch(ArrayIndexOutOfBoundsException e){
            //例外が発生した箇所を遡って表示するための出力
            e.printStackTrace();
            //処理を中断するためのコード
            return false;
        }
        //処理を継続するため反転成功の判定値を返却する
        return true;
    }

    /**
     * 配列の要素の値を入れ替えるためのメソッド</br>
     * 作成日：2018/10/24</br>
     * 作成者：志田</br>
     *
     * @param switchArrays 要素の値の並びを反転させる配列
     * @param indexA       値の入れ替え先の要素番号
     * @param indexB       値の入れ替え元の要素番号
     */
    public static void swap(int[] switchArrays, int indexA, int indexB){
        //配列の要素の値を入れ替えるための変数への退避
        int switchArrayBackup = switchArrays[indexA];
        //空になった要素へ入れ替え元の値の代入
        switchArrays[indexA] = switchArrays[indexB];
        //空になった入れ替え元の要素への退避した値の代入
        switchArrays[indexB] = switchArrayBackup;
    }

    /**
     * 配列の全要素の値を表示するための出力メソッド</br>
     * 作成日：2018/11/5</br>
     * 作成者：志田</br>
     *
     * @param resultArrays 出力する配列のための変数
     *
     */
    public static void showArrayValues(String outputMessage, int[] resultArrays){
        int indexNumber = 0;                                 //配列の要素番号のための変数

        //出力する配列の内容を説明するための文の表示
        System.out.println(outputMessage);

        //仮引数の配列の要素の値を順に表示するための繰り返す処理
        for(int showValue : resultArrays){
            //配列の要素番号とその値を表示するための出力
            System.out.printf(RESULT_ARRAY_INDEX_COLUMN_STRING, indexNumber, showValue);
            //次の要素番号表示のために要素番号の値を１加算する
            indexNumber++;
        }
    }

    /**
     * プログラムの繰り返し可否の入力をユーザーに促すためのメソッド</br>
     *作成日：2018/10/24</br>
     *作成者：志田</br>
     *
     * @return repeatJudgeResult 入力された繰り返し可否の値の返却
     */
    public static int repeatProgram(){
        int repeatJudgeResult = 0;                          //入力された値を保持するための変数

        //ユーザーに繰り返しの可否の入力を促す文を表示するための出力
        System.out.print(REPEAT_PROGRAM_QUESTION_STRING);
        //入力された値を呼び出し元に返却するための値の保持
        repeatJudgeResult = inputReverseTestNumber.nextInt();

        //繰り返し判定のための呼び出し元への値の返却
        return repeatJudgeResult;
    }
}
