/**
 *
 */
package ensyuu16_2;

/*
 *非検査例外にするためにRuntimeExceptionクラスから派生した範囲外例外のクラス
 */
public class En16_2_RangeError extends RuntimeException {
    En16_2_RangeError(int errorValue){
        super("範囲外の値:" + errorValue);
        }

    }





