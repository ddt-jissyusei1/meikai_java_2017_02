package ensyuu15;

import java.util.Scanner;

/*
 * 文字列を読み込んで、その全文字の文字コードを表示するプログラムを作成せよ。
 */
public class En15_2_StringUnicode {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "入力された文字列の全文字の文字コードを表示します。";
    //文字列の入力を促す文のための定数
    private static final String INPUT_STRING_MESSAGE = "\n文字列を入力してください：";
    //入力された文字列の確認文のための定数
    private static final String DISPLAY_STRING_TO_CHECK_MESSAGE = "\n入力された文字列：%s";
    //文字列コードの表示確認文のための定数
    private static final String SHOW_CHAR_UNICODE_STRING = "\n入力された文字の文字コード：\n";
    //プログラムの繰り返し可否を問う文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "\nもう一度やりますか？はい>>1、いいえ>>0：";
    //プログラムの終了を告げる文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れさまでした。";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputValue = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //ユーザーが希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            String stringToCharCode;                   //文字コードを表示する文字列のための変数

            //文字コードを表示する文字列の入力を促すための文の表示
            System.out.print(INPUT_STRING_MESSAGE);
            //文字コードをするため入力された文字列を変数に保持する
            stringToCharCode = inputValue.next();

            //入力された文字列の確認のための表示
            System.out.printf(DISPLAY_STRING_TO_CHECK_MESSAGE, stringToCharCode);

            //文字コードの表示を告げるための文の出力
            System.out.print(SHOW_CHAR_UNICODE_STRING);

            //文字コードを表示するための出力メソッドの呼び出し
            showCharCode(stringToCharCode);

        //返却値がtrueである間プログラムを繰り返すための制御式
        }while(isRepeatProgram());

        //値の入力が終了したので、開いていたリソースを開放する
        inputValue.close();

        //プログラムの終了を通知するための文の出力
        System.out.println(QUIT_PROGRAM_MESSAGE);

    }


    //文字列の全文字の文字コードを表示するためのメソッド
    /**
     * 作成者：志田
     * @param stringToShow
     */
    public static void showCharCode(String stringToShow){
        //文字コードを表示する繰り返し処理で使用するための文字列の長さの取得
        int stringLength = stringToShow.length();

        //文字列の全文字の文字コードを表示するための繰り返し処理
        for(int outputCharLoop = 0; outputCharLoop < stringLength; outputCharLoop++){
            //文字列の文字の文字コードを表示するための出力
            System.out.println(stringToShow.charAt(outputCharLoop) + "=" + stringToShow.codePointAt(outputCharLoop));
        }
    }


    //プログラムの繰り返し判定をするためのメソッド
    /**
     * 作成者：志田
     * @return boolean
     */
    public static boolean isRepeatProgram(){
        int selectedNumber = 0;                            //選択された繰り返し可否の番号のための変数

        //選択番号以外が入力されている間繰り返すための繰り返し処理
        do{
            //プログラムの繰り返しの可否の選択を促す文を表示するための出力
            System.out.print(REPEAT_PROGRAM_QUESTION_STRING);
            //入力された値を真偽値判定するために変数に保持する
            selectedNumber = inputValue.nextInt();

        //返却値がtrueである間処理を繰り返すための制御式
        }while(isNotSelectionNumber(selectedNumber));

        //呼び出し元に条件演算子の真偽値を返却する
        return selectedNumber == 1;
    }


    //入力された選択番号が選択数範囲外であるか判定するためのメソッド
    /**
     * 作成者：志田
     * @param selectedNumber
     * @return boolean
     */
    public static boolean isNotSelectionNumber(int selectedNumber){

        //呼び出し元に真偽値を返すための条件式
        return selectedNumber > 1 || selectedNumber < 0;
    }

}
