package ensyuu15;

import java.util.Scanner;

/*
 * 浮動小数点数値xを、小数点以下の部分をp桁で、全体で少なくともw桁で表示するメソッドprintDoubleを作成せよ。
 * printDouble(double x, int p, int w)
 *
 * 作成者：志田
 * 作成日：2018/06/20
 */
public class En15_4_StringFormatDouble {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "入力された浮動少数点数値の小数点以下と、"
                                                                            + "全体桁数を任意桁で表示します。";
    //浮動小数点数値の入力を促す文のための定数
    private static final String INPUT_DECIMAL_VALUE_MESSAGE = "\n浮動小数点数値を入力してください：";
    //表示する小数点以下の桁数の入力を促す文のための定数
    private static final String INPUT_DECIMAL_POINT_DIGITS_MESSAGE = "表示する小数点以下の桁数を入力してください：";
    //表示する全体の桁数の入力を促す文のための定数
    private static final String INPUT_GENERAL_DIGITS_MESSAGE = "表示する全体の桁数を入力してください：";
    //表示する結果の文字列のための定数
    private static final String SHOW_RESULT_STRING = "\n表示結果：%%%d.%df";
    //プログラムの繰り返し可否を問う質問文のために定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\nもう一度やりますか？はい>>１、いいえ>>0:";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputValueStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明をするための文の表示
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            double dValue = 0.0;                        //入力された浮動小数点数値のための変数
            int decimalPointDigits = 0;                //小数点以下の桁数のための変数
            int generalDecimalDigits = 0;              //小数点の全体桁数のための変数

            //表示する少数点数値の入力をさせるための入力メソッドの呼び出し
            dValue = inputDecimalValue(INPUT_DECIMAL_VALUE_MESSAGE);

            //小数点以下の桁数の入力をさせるため整数値入力メソッドを呼び出す
            decimalPointDigits = inputIntegerValue(INPUT_DECIMAL_POINT_DIGITS_MESSAGE);

            //小数点の表示する全体桁数の入力をさせるため整数値入力メソッドを呼び出す
            generalDecimalDigits = inputIntegerValue(INPUT_GENERAL_DIGITS_MESSAGE);

            //入力された値を元に小数点数値を表示するためのメソッドの呼び出し
            printDouble(dValue, decimalPointDigits, generalDecimalDigits);

        //プログラム繰り返し可否メソッドから返却された値が真である間繰り返すための条件式
        }while(isRepeatProgram());

        //値の入力が終了したので、開いていたリソースを開放する
        inputValueStream.close();

        //プログラムの終了を通知するための文の表示
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }

    //整数値の入力処理をするためのメソッド
    /**
     * 作成者：志田
     * 作成日：2018/06/20
     * @param inputMessage 入力を促す文のための引数
     * @return inputResult 入力された整数値を返却する
     */
    public static int inputIntegerValue(String inputMessage){
        int inputIntResult = 0;                        //呼び出し元に返却する値のための変数

        //整数値以外が入力された場合入力処理を繰り返すための繰り返し処理
        do{
            //第一引数の値の入力を促すための文の表示
            System.out.print(inputMessage);
            //呼び出し元に返却するために入力された値を変数に保持する
            inputIntResult = inputValueStream.nextInt();

        //整数値以外が入力されている間処理を繰り返すための条件式
        }while(inputIntResult <= 0);

        //プログラムを続けるため入力された値を呼び出し元に返却する
        return inputIntResult;
    }

    //少数値の入力処理をするためのメソッド
    /**
     * 作成者：志田
     * 作成日：2018/06/20
     * @param inputMessage        入力を促す文のための引数
     * @return inputDecimalResult 入力された少数値を返却する
     */
    public static double inputDecimalValue(String inputMessage){
        double inputDecimalResult = 0;                //呼び出し元に返却する値のための変数

        //第一引数の値の入力を促すための文の表示
        System.out.print(inputMessage);
        //呼び出し元に返却するために入力された値を変数に保持する
        inputDecimalResult = inputValueStream.nextDouble();

        //プログラムを続けるため入力された値を呼び出し元に返却する
        return inputDecimalResult;
    }

    //浮動小数点数値を任意の小数点以下桁数と全体桁数で表示するためのメソッド
    /**
     * 作成者：志田
     * 作成日：2018/06/20
     * @param decimalValue      入力された小数点数値のための第一引数
     * @param decimalPointsDigits    表示する小数点以下の値のための第二引数
     * @param generalDigits          表示する全体桁数の値のための第三引数
     */
    public static void printDouble(double decimalValue, int decimalPointDigits, int generalDigits){

        //入力された値を元に小数点数値を表示するためのフォーマット出力
        System.out.printf(String.format(SHOW_RESULT_STRING, generalDigits, decimalPointDigits),decimalValue);
    }

    //プログラムの繰り返し判定のためのメソッド
    /**
     * 作成者：志田
     * 作成日：2018/06/20
     * @return boolean "プログラムを繰り返す"判定条件式の真偽値を返却する
     */
    public static boolean isRepeatProgram(){
        int selectedNumber = 0;                        //選択された2択番号のための変数

        //プログラムの繰り返し可否の入力を促すための質問文の表示
        System.out.print(REPEAT_PROGRAM_QUESTION_MESSAGE);
        //繰り返し可否判定のために入力された値を変数に保持する
        selectedNumber = inputValueStream.nextInt();

        //呼び出し元に真偽値を返却するための条件式
        return selectedNumber == 1;
    }

}
