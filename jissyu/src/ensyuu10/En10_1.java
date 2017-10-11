package ensyuu10;

/*
 * List10-3(p.340)に示した連番クラスIdに、最後に与えた識別番号を返すクラスメソッドgetMaxIdを追加せよ。
 *
 *  static int getMaxId()
 *
 * なお、このメソッドは、インスタンスをn個生成した時点で呼び出すとnを返すことになる。
 */
public class En10_1 {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "生成したインスタンスに最後に与えた識別番号を表示します。";

    public static void main(String[] args) {
        //プログラムの説明文を表示する
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //一つ目のインスタンスの生成
        En10_1_Id firstId = new En10_1_Id();

        //二つ目のインスタンスの生成
        En10_1_Id secondId = new En10_1_Id();

        //一つ目のIdを確認するためのId取得メソッドと表示出力
        System.out.println("firstIdの識別番号：" + firstId.getId());

        //二つ目のIdを確認するためのId取得メソッドと表示出力
        System.out.println("secondIdの識別番号：" + secondId.getId());

        //最後に与えた識別番号取得のためのメソッドの呼び出し
        System.out.println("最後に与えた識別番号は：" + En10_1_Id.getMaxId());

    }
}
