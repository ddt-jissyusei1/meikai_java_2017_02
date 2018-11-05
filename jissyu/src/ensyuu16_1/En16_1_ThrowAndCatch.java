package ensyuu16_1;

/*
 * メインクラスからの引数の値に応じて例外を送出するためのクラス
 *
 */
public class En16_1_ThrowAndCatch {
    //検査例外発生分岐のための値の定数
    public static final int EXCEPTION_SWITCH_VALUE = 1;
    //非検査例外発生分岐のための値の定数
    public static final int RUNTIMEEXCEPTION_SWITCH_VALUE = 2;

    //検査例外発生を通知する文のための定数
    private static final String EXCEPTION_MESSAGE = "\n検査例外発生！！";
    //非検査例外発生を通知する文のための定数
    private static final String RUNTIMEEXCEPTION_MESSAGE = "\n非検査例外発生！！";

    //引数の値の応じて例外を送出するためのメソッド
    static void check(int exceptionTestValue) throws Exception{
        //引数の値に応じて例外を送出するための分岐式
        switch(exceptionTestValue){
        //引数の値が１の場合に送出する検査例外のための分岐
        case EXCEPTION_SWITCH_VALUE: throw new Exception(EXCEPTION_MESSAGE);

        //引数の値が２の場合に送出する非検査例外のための分岐
        case RUNTIMEEXCEPTION_SWITCH_VALUE: throw new RuntimeException(RUNTIMEEXCEPTION_MESSAGE);
        }
    }

    //例外を発生させるためのメソッド
    static void exceptionTest(int exceptionTestValue) throws Exception{
        //例外を発生させるための呼び出し
        check(exceptionTestValue);
    }


}
