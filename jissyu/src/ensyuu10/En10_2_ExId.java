package ensyuu10;

public class En10_2_ExId {
    static int sCounter = 0;                    //与えた識別番号をカウントするためのカウンター変数
    private int id;                              //識別番号のための変数

    //識別番号が指定数づつ増えるためのコンストラクタ
    public En10_2_ExId(int incrementNumber){
        sCounter += incrementNumber;              //仮引数の値をフィールド変数に加算代入する
        id = sCounter;                            //フィールド変数の値をインスタンス変数に代入する
    }

    //識別番号を取得するためのゲッタメソッド
    public int getId(){
      //呼び出し元に取得した識別番号を返却する
      return id;
    }

    //最後に与えた識別番号を取得するためのゲッタメソッド
    public static int getMaxId(){
      //最後に与えた識別番号としてカウンター変数の値を取得する
      int maxId = sCounter;
      //呼び出し元に取得した識別番号を返却する
      return maxId;

    }


}
