package ensyuu16_1;

import java.util.Scanner;

/*
 * List16-4(p.518)のtry文では、Exception例外とRunTimeException例外を、単一の例外ハンドラで捕捉している。
 * 二つの例外を別々に捕捉するように変更したプログラムを作成せよ。
 */
public class En16_1_TestThrowAndCatch {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "二つの例外を別々に捕捉するテストプログラムです。";
    //ユーザーに検査用の値の入力を促す文のための定数
    private static final String INPUT_EXAMINE_VALUE_MESSAGE = "1または２を入力してください。\n検査用数値:";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明をするための文の出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int exceptionTestValue;         //例外検査用の値のための変数

        //規定の数値が入力されるまで入力処理を繰り返す
        do{
            //ユーザーに値の入力を促すための文の出力
            System.out.print(INPUT_EXAMINE_VALUE_MESSAGE);
            //入力された値を例外捕捉に使用するため変数に保持する
            exceptionTestValue = inputStream.nextInt();
        //規定数値以外が入力されている間処理を繰り返す
        }while(exceptionTestValue < 1 || exceptionTestValue > 2);

        //入力された値に対する処理を行うためのtryブロック
        try{
            //例外を発生させるための検査用メソッドの呼び出し
            En16_1_ThrowAndCatch.exceptionTest(exceptionTestValue);

        //送出された非検査例外を受け取るためのブロック
        }catch(RuntimeException runtimeException){
            //送出された非検査例外のメッセージ取得し表示するための出力
            System.out.println(runtimeException.getMessage());

        //送出された検査例外を受け取るためのブロック
        }catch(Exception exception){
            //送出された検査例外のメッセージを取得し表示するための出力
            System.out.println(exception.getMessage());

        }

    }

}
