package ensyuu15;

/*
 * List15-15(p.499)のfor文を拡張for文で実現したプログラムを作成せよ。
 */
public class En15_7_SumOfArgs {

    public static void main(String[] args) {
        double sumArgs = 0.0;                       //コマンドライン引数加算のための変数

        //コマンドライン引数の値をすべて加算するための拡張for文
        for(String argsValue : args){
            sumArgs += Double.parseDouble(argsValue);
        }

        System.out.println(sumArgs);
    }

}
