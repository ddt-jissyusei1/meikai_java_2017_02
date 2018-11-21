package ensyuu15;

import java.util.Scanner;

/*
 * 文字列を読み込んで、その文字列を逆順に表示するプログラムを作成せよ。
 */
public class En15_1_ReverseString {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "読み込んだ文字列を逆順に表示します。";
    //文字列の入力を促す文のための定数
    private static final String INPUT_STRING_MESSAGE = "文字列を入力してください：";
    //入力された文字列を確認のため表示するための文の定数
    private static final String SHOW_INPUT_STRING = "\n入力された文字列：%s";
    //逆順に文字列を表示しことを告げるための文の定数
    private static final String SHOW_REVERSE_STRING = "\n逆順に表示：";
    //プログラムの繰り返しの可否を問う文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\n\nもう一度やりますか？はい>>>1、いいえ>>>0:";
    //プログラムの終了を告げる文のための定数
    private static final String QUIT_PROGRAM_STRING = "プログラムを終了します。お疲れ様でした。";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputValue = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明をするための文の表示
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //プログラムを繰り返し実行できるようにするための繰り返し処理
        do{
            String reverseString;                          //逆順に表示する文字列のための変数

            //逆順に表示するための文字列の入力を促す文の表示
            System.out.print(INPUT_STRING_MESSAGE);
            //逆順に表示するため入力された文字列を変数に保持する
            reverseString = inputValue.next();

            //入力された文字列を確認のため表示するための出力
            System.out.printf(SHOW_INPUT_STRING, reverseString);

            //文字列を逆順に表示すること告げる文の出力
            System.out.print(SHOW_REVERSE_STRING);
            //入力された文字列を逆順に表示するためのメソッドの呼び出し
            showReversedString(reverseString);

        //繰り返し可否の真偽値でプログラムの繰り返し判定をするための条件式
        }while(isRepeatProgram());

        //値の入力が終了したので、開いていたリソースを開放する
        inputValue.close();

        //プログラムの終了を通知するための文の出力
        System.out.println(QUIT_PROGRAM_STRING);

    }


    //入力された文字列を逆順に表示するためのメソッド
    /**
     *
     * @param toReverse
     */
    public static void showReversedString(String toReverse){
        //ループ処理で使用するための引数の文字列の長さの取得
        int stringLength = toReverse.length();

        //文字列を逆順に表示するためのループ処理
        for(int outputReverse = 0; outputReverse < stringLength; outputReverse++){
            //文字列を1文字ずつ後ろから表示するための出力
            System.out.print(toReverse.charAt((stringLength-1) - outputReverse));
        }
    }

    //繰り返し可否を判定するためのメソッド
    /**
     *
     * @return boolean
     */
    public static boolean isRepeatProgram(){
        int repeatSelection = 0;                          //選択された繰り返し判定のための変数

        do{
            //繰り返しの可否を問うための文の表示
            System.out.print(REPEAT_PROGRAM_QUESTION_MESSAGE);
            //入力された値を真偽値判定のための変数に保持する
            repeatSelection = inputValue.nextInt();

        //返却値がtrueである間繰り返すための条件式
        }while(isNotSelectionNumberRange(repeatSelection));

        //読み出し元に真偽値を返却するための演算式
        return repeatSelection == 1;
    }


    //選択された値が選択番号範囲外であるかどうかチェックするためのメソッド
    /**
     *
     * @param selectedNumber
     * @return boolean
     */
    public static boolean isNotSelectionNumberRange(int selectedNumber){

        //選択番号数内である条件演算子により真偽値を返却する
        return selectedNumber > 1 || selectedNumber < 0;
    }

}
