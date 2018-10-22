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
                                + "仮引数に受け取った参照が空参照だった場合に何らかの対処を行うテストプログラムです。";
    //並びを反転する配列の要素数の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_INDEX_NUMBER = "\n要素の並びを反転する配列の要素数を入力してください。";
    //要素数入力時に表示する項目目のための定数
    private static final String ARRAY_INDEX_AMOUNT_COLUMN_STRING = "要素数：";
    //並びを反転する配列の要素の値の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_VALUE_MESSAGE = "\n要素の値を入力してください。";
    //要素の値入力時に表示する要素番号のための定数
    private static final String ARRAY_INDEX_COLUMN_STRING = "reverseArrays[%d]:";
    //要素の並びを反転したことを通知する文のための定数
    private static final String REVERSE_ARRAY_RESULT_MESSAGE = "\n要素の並びを反転しました。";
    //プログラムの繰り返し可否の質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "\nもう一度やりますか？はい>>>1、いいえ>>>0：";

    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputReverseTestNumber = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int arrayIndexAmount = 0;                  //並びを反転する配列の要素数のための変数
        int inputArrayValueLoopCount;             //要素の値入力の繰り返しのためのカウンタ変数
        int reverseArrayOutputLoopCount;          //反転した要素の並びを出力する繰り返しのためのカウンタ変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            //要素の並びを反転する配列の要素数の入力を促す文を表示するための出力
            System.out.println(INPUT_REVERSE_ARRAY_INDEX_NUMBER);
            //入力する要素数の項目名を表示するための出力
            System.out.print(ARRAY_INDEX_AMOUNT_COLUMN_STRING);
            //並びを反転する配列を生成するために入力された値を変数に保持する
            arrayIndexAmount = inputReverseTestNumber.nextInt();

            //並びを反転するための配列の宣言
            int[] reverseArrays = new int[arrayIndexAmount];

            //要素の値の入力を促す文を表示するための出力
            System.out.println(INPUT_REVERSE_ARRAY_VALUE_MESSAGE);

            //要素数の数だけ入力を繰り返すための繰り返し処理
            for(inputArrayValueLoopCount = 0; inputArrayValueLoopCount < arrayIndexAmount; inputArrayValueLoopCount++){
                //値を入力する要素の要素番号を表示するための出力
                System.out.printf(ARRAY_INDEX_COLUMN_STRING,inputArrayValueLoopCount);
                //入力された値を保持するために配列の要素に代入する
                reverseArrays[inputArrayValueLoopCount] = inputReverseTestNumber.nextInt();
            }

            //要素の並びを反転するためのメソッドの呼び出し
            reverse(reverseArrays);

            //要素の並びを反転したことを通知するための文の出力
            System.out.println(REVERSE_ARRAY_RESULT_MESSAGE);
            //反転した要素の並びを表示するための出力
            for(reverseArrayOutputLoopCount = 0;reverseArrayOutputLoopCount < arrayIndexAmount; reverseArrayOutputLoopCount++){
                //並び替えた要素を表示するための出力
                System.out.printf(ARRAY_INDEX_COLUMN_STRING + reverseArrays[reverseArrayOutputLoopCount] +"\n",
                                                                                          reverseArrayOutputLoopCount);
            }

        //プログラムの繰り返しを判定するための条件式
        }while(repeatProgram() == 1);
    }

    /**
     * 配列の要素の並びを反転するための繰り返しメソッド
     *
     *
     *
     */
    public static void reverse(int[] reverseArrays){
        int reverseArrayLength = reverseArrays.length;  //並びを反転する繰り返し処理の制御に使用するための配列の長さの取得

        //発生した例外を送出するためのブロック
        try{
            //要素の値の並びを反転するための繰り返す処理
            for(int reverseLoopCount = 0; reverseLoopCount < reverseArrayLength/2; reverseLoopCount++){
                //要素の値を入れ替えるためのメソッドの呼び出し
                swap(reverseArrays, reverseLoopCount, reverseArrayLength - reverseLoopCount);
            }

        //捕捉した例外に対する処理を行うための例外ハンドラ
        }catch(ArrayIndexOutOfBoundsException e){
            //例外が発生した箇所を遡って表示するための出力
            e.printStackTrace();
            //処理を中断するためのコード
            //return;
            System.exit(1);

        }
    }

    /**
     * 配列の要素の値を入れ替えるためのメソッド
     * @param switchArrays
     * @param indexA
     * @param indexB
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
     * プログラムの繰り返し可否の入力をユーザーに促すためのメソッド
     *
     * @return
     */
    public static int repeatProgram(){
        int repeatJudgeResult = 0;       //入力された値を保持するための変数

        //ユーザーに繰り返しの可否の入力を促す文を表示するための出力
        System.out.println(REPEAT_PROGRAM_QUESTION_STRING);
        //入力された値を呼び出し元に返却するための値の保持
        repeatJudgeResult = inputReverseTestNumber.nextInt();

        //繰り返し判定のための呼び出し元への値の返却
        return repeatJudgeResult;
    }
}
