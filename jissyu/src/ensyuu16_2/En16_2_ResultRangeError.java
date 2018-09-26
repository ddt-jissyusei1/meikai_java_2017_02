package ensyuu16_2;

/*
 * 範囲外例外クラスを継承した、計算結果が範囲外の場合のための例外クラス
 */
public class En16_2_ResultRangeError extends En16_2_RangeError {

    public En16_2_ResultRangeError(int resultValue) {
        super(resultValue);
        //
    }

}
