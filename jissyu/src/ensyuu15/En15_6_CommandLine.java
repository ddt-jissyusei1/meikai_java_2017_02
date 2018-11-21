package ensyuu15;
/*
 * コマンドライン引き数で与えれた半径を持つ円の円周の長さと面積を求めて表示するプログラムを作成せよ。
 */
public class En15_6_CommandLine {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "コマンドライン引数で与えられた半径を持つ円の"
                                                                                       + "円周の長さと面積を求めます。";
    //コマンドライン引数の値を表示する文のための定数
    private static final String SHOW_COMMANDLINE_ARGUMENT_STRING = "args[0] = %s";
    //円の半径の説明文のための定数
    private static final String SHOW_CIRCLE_RADIUS_STRING = "\n\n%sの半径を持つ円です。";
    //求めた円の円周の長さを通知する文のための定数
    private static final String SHOW_CIRCLE_CIRCUMFERENCE_STRING = "\n円周の長さは：%f";
    //求めた円の面積を通知する文のための定数
    private static final String SHOW_CIRCLE_AREA_STRING = "\n円の面積は：%f";

    //円周率のための変数
    private static final double PI = 3.14;

    public static void main(String[] args) {
        //プログラムの説明をするための文の表示
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //受け取ったコマンドライン引数の値を表示するための出力
        System.out.printf(SHOW_COMMANDLINE_ARGUMENT_STRING, args[0]);

        //コマンドライン引数で受け取った円の半径の説明をするための文の表示
        System.out.printf(SHOW_CIRCLE_RADIUS_STRING, args[0]);

        //円周の長さを求めるメソッドを呼び出しその結果を表示するための出力
        System.out.printf(SHOW_CIRCLE_CIRCUMFERENCE_STRING,circleLength(args[0]));

        //円の面積を求めるメソッドを呼び出しその結果を表示するための出力
        System.out.printf(SHOW_CIRCLE_AREA_STRING, circleArea(args[0]));
    }

    /**
     * 円周の長さを求めるためのメソッド</br>
     * 作成者：志田</br>
     * 作成日：20180709
     * @param radius    円の半径の値のための引数
     * @return Double.parseDouble(radius)*2*PI 求めた円周の長さの値
     */
    public static double circleLength(String radius){
        //円周の長さを求める演算式の結果を呼び出し元に返却する
        return Double.parseDouble(radius)*2*PI;
    }

    /**
     * 円の面積を求めるためのメソッド</br>
     * 作成者：志田</br>
     * 作成日：20180709
     * @param radius    円の半径の値のための引数
     * @return circleRadius*circleRadius*PI 求めた円の面積の値
     */
    public static double circleArea(String radius){
        double circleRadius = Double.parseDouble(radius);       //引数の値をdouble型にキャストして変数に保持する

        //円の面積を求める演算式の結果を呼び出しもとに返却する
        return circleRadius*circleRadius*PI;
    }

}
