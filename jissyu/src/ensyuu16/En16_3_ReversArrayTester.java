package ensyuu16;

import java.util.Scanner;

/*
 * List16-7(p.524)のメソッドreverseは、仮引数aに受け取った参照が空参照でないことを前提としている。
 * 受け取ったのが空参照であった場合に、何らかの対処を行うように変更したプログラムを作成せよ。
 * ※Column16-2(p.527)に示す NullPointerException を捕捉して対処すること。
 */
public class En16_3_ReversArrayTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "配列の要素の並びを反転する際、仮引数に受け取った参照が空参照だった場合に"
                                                                        + "何らかの対処を行うテストプログラムです。";
    //並びを反転する配列の要素数の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_INDEX_NUMBER = "要素の並びを反転する配列の要素数を入力してください。";
    //要素数入力時に表示する項目目のための定数
    private static final String ARRAY_INDEX_COLUMN_STRING = "要素数：";
    //並びを反転する配列の要素の値の入力を促す文のための定数
    private static final String INPUT_REVERSE_ARRAY_VALUE_MESSAGE = "要素の値を入力してください。";
    //要素の値入力時に表示する要素番号のための定数
    private static final String INPUT_ARRAY_INDEX_COLUMN_STRING = "\nreversArrays[%d]:";
    //要素の並びを反転したことを通知する文のための定数
    private static final String REVERSE_ARRAY_RESULT_MESSAGE = "要素の並びを反転しました。";


    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputReverseTestNumber = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int arrayIndexAmount = 0;               //並びを反転する配列の要素数のための変数
        int inputArrayValueLoopCount;             //要素の値入力の繰り返しのためのカウンタ変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            //要素の並びを反転する配列の要素数の入力を促す文を表示するための出力
            System.out.println(INPUT_REVERSE_ARRAY_INDEX_NUMBER);
            //入力する要素数の項目名を表示するための出力
            System.out.print(ARRAY_INDEX_COLUMN_STRING);
            //並びを反転する配列を生成するために入力された値を変数に保持する
            arrayIndexAmount = inputReverseTestNumber.nextInt();

            //並びを反転するための配列の宣言
            int[] reverseArrays = new int[arrayIndexAmount];

            //要素の値の入力を促す文を表示するための出力
            System.out.println(INPUT_REVERSE_ARRAY_VALUE_MESSAGE);

            //要素数の数だけ入力を繰り返すための繰り返し処理
            for(inputArrayValueLoopCount = 0; inputArrayValueLoopCount < arrayIndexAmount; inputArrayValueLoopCount++){
                //値を入力する要素の要素番号を表示するための出力
                System.out.printf(INPUT_ARRAY_INDEX_COLUMN_STRING,inputArrayValueLoopCount);
                //入力された値を保持するために配列の要素に代入する
                reverseArrays[inputArrayValueLoopCount] = inputReverseTestNumber.nextInt();
            }

            //要素の並びを反転するためのメソッドの呼び出し
            reverse(reverseArrays);





        }while(true);

    }

    /**
     * 配列の要素の並びを反転するためのメソッド
     *
     *
     *
     */
    public static void reverse(int[] reverseArrays){
        //発生した例外を送出するためのブロック
        try{


        //捕捉した例外に対する処理を行うための例外ハンドラ
        }catch(ArrayIndexOutOfBoundsException e){

        }

    }
}
