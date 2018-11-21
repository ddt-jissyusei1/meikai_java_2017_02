package ensyuu16_2;

/*
 * 範囲外例外クラスを継承した、計算結果が範囲外の場合のための例外クラス
 */
public class En16_2_ResultRangeError extends En16_2_RangeError {
    //計算結果が範囲外例外のためのコンストラクタ
    public En16_2_ResultRangeError(int resultValue) {
        //仮引数の値セットするための親クラスのコンストラクタの呼び出し
        super("\n計算結果が範囲外です。",resultValue);
    }
}