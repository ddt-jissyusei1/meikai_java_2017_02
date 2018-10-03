package ensyuu16_2;

/*
 * 範囲外例外クラスを継承した、仮引数の値が範囲外の場合のための例外クラス
 */
public class En16_2_ParameterRangeError extends En16_2_RangeError {
    //加算する数が範囲外例外のためのコンストラクタ
    public En16_2_ParameterRangeError(String errorMessage,int addNumberValue) {
        //仮引数の値をセットするための親クラスのコンストラクタの呼び出し
        super(errorMessage,addNumberValue);
    }

}
