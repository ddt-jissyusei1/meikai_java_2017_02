package ensyuu15;

/*
 * List15-15(p.499)のfor文を拡張for文で実現したプログラムを作成せよ。
 */
public class En15_7_SumOfArgs {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "コマンドライン引数の値を拡張for文で加算していくプログラムです。";
    //コマンドライン引数の値を表示する前置文のための定数
    private static final String SHOW_ARGUMENT_VALUE_STRING = "\nコマンドライン引数の値は：";
    //コマンドライン引数の表示する配列要素のための定数
    private static final String ARGUMENT_ARRAY_NUMBER_STRING = "\nargs[%d]=";
    //加算結果を通知する文のための定数
    private static final String SUM_RESULT_STRING = "\n\n加算結果は、%fです。";

    public static void main(String[] args) {
        double sumArgs = 0.0;                       //コマンドライン引数加算結果のための変数
        int sumCounter = 0;                         //加算ループのためのカウンタ変数

        //プログラムの説明をするための文の出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //コマンドライン引数の値を表示することを通知する文の表示のための出力
        System.out.print(SHOW_ARGUMENT_VALUE_STRING);

        //コマンドライン引数の値をすべて加算するための拡張for文
        for(String argsValue : args){
            //コマンドライン引数の要素番号を表示するための出力
            System.out.printf(ARGUMENT_ARRAY_NUMBER_STRING,sumCounter);
            //コマンドライン引数の要素の値を表示するための出力
            System.out.print(argsValue);
            //加算結果のための変数に引数の値を加算代入する
            sumArgs += Double.parseDouble(argsValue);
            //次のループをカウントするためのカウンタの加算
            sumCounter++;
        }

        //加算結果を表示するための文の出力
        System.out.printf(SUM_RESULT_STRING,sumArgs);
    }

}
