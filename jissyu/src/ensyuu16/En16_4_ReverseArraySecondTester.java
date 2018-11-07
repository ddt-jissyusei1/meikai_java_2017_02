package ensyuu16;

import java.util.Scanner;

/*
 * 前問と同様に、List16-8(p.526)のメソッドreverseに対して、仮引数aに受け取った参照が空参照であった場合に、
 * 何らかの対処を行うように変更したプログラムを作成せよ。
 *
 */
public class En16_4_ReverseArraySecondTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "メソッドreverseで受け取った仮引数が空参照であった場合に"
                                                               + "別の例外として送出する対処を行うテストプログラムです。";
    //配列の要素数の入力をユーザーに促すための文の定数
    private static final String INPUT_ARRAY_INDEX_MESSAGE = "\n並びを反転する配列の要素数を入力してください。"
                                                               + "\n要素数が奇数で空参照例外が発生します。\n要素数：";
    //要素の値の入力をユーザーに促すための文の定数
    private static final String INPUT_ARRAY_VALUE_MESSAGE = "\n要素の値を入力してください。";
    //要素の値入力時に表示する項目番号のための定数
    private static final String ARRAY_INDEX_STRING = "reverseArrays[%d] = ";
    //

    //キーボードからの入力ストリームを読み込むためのプログラム
    public static Scanner inputValue = new Scanner(System.in);

    public static void main(String[] args) {
        //

    }



}
