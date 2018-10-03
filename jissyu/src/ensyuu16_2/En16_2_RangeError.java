/**
 *
 */
package ensyuu16_2;

/*
 *非検査例外にするためにRuntimeExceptionクラスから派生した範囲外例外のクラス
 */
public class En16_2_RangeError extends RuntimeException {
    //範囲外例外のためのコンストラクタ
    En16_2_RangeError(String errorMessage, int errorValue){
        //親クラスのコンストラクタの呼び出し
        super(errorMessage + "範囲外の値:" + errorValue);
        }
    }







