package ensyuu10;
import java.util.Scanner;

/*
 *前問で作成したクラスIdを、以下のように変更したクラスExIdを作成せよ。
 *インスタンスを生成するたびに識別番号をnずつ増やして与える（nは正の整数）。
 *nの値は、指定されない限り1とするが、メソッドを通じて取得・変更できるようにする。
 *たとえばインスタンスを3個生成した後にnを4に変更した場合、インスタンスに与える識別番号は生成順に1,2,3,7,11,15・・・となる。
 */
public class En10_2 {
    //プログラム説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "識別番号を指定数ずつ増やしてインスタンスに与えます。"
            + "指定がない場合は1ずつインクリメントします。";
    //識別番号の増加数の入力を促す文のための定数
    private static final String INPUT_CHANGE_INCREMENT_NUMBER_MESSAGE = "識別番号の増加数を指定しますか？　はい＞＞1、いいえ＞＞0\n：";
    //変更する識別番号の増加数の入力を促す文のための定数
    private static final String INPUT_INCREMENT_NUMBER_MESSAGE = "指定する増加数を入力してください：";
    //インスタンスの生成を続ける可否の質問文のための定数
    private static final String REPEAT_GENERATE_INSTANCE_QUESTION_MESSAGE = "\nインスタンスの生成を続けますか？　はい＞＞1、いいえ＞＞0\n：";
    //プログラム終了を告げる文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputNumberStream = new Scanner(System.in);

    public static void main(String[] args) {
        int repeatGenerateInstanceJudge = 0;             //インスタンス生成の繰り返しの可否判定のための変数
        int incrementNumber = 1;                          //指定増加数のための変数

        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //インスタンス生成を繰り返し行うための繰り返し処理
        do{

            //増加数を変更する場合に変更メソッドを呼び出すための条件式
            if(changeIncrementNumberJudge() == 1){
                //増加数変更有りの場合に増加数変更のメソッドを呼び出す
                incrementNumber = changeIncrementNumber();
            }

            //Idの増加数の値を渡してインスタンスを生成するためのメソッドを呼び出す
            generateSpecifiedIncrementNumber(incrementNumber);

            //識別番号を確認するために表示するメソッドの
            showId();

            //インスタンス生成を繰り返す可否の判断のためのメソッドの呼び出し
            repeatGenerateInstanceJudge = generateExtraIdInstance();

        //インスタンス生成繰り返しの可否判定の値が1である間、生成処理を繰り返すための条件
        }while(repeatGenerateInstanceJudge == 1);

        //プログラムの終了を知らせる文を表示するための出力
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }

    //インスタンスの生成の繰り返し判定のためのメソッド
    private static int generateExtraIdInstance(){
        int quitInstanceGenerate = 0;                     //インスタンス可否判定のための変数

        //インスタンスの生成を続ける可否の入力を促すための文を表示する
        System.out.println(REPEAT_GENERATE_INSTANCE_QUESTION_MESSAGE);
        //入力された値をメインメソッドに返却するための変数に代入する
        quitInstanceGenerate = inputNumberStream.nextInt();

        //呼び出し元に繰り返し判定の値を返却するためのreturn文
        return quitInstanceGenerate;
    }

    //識別番号の増加数の指定ためのメソッド
    private static int changeIncrementNumberJudge(){
        int changeQuestionAnswer = 0;	                  //識別番号の増加数の指定の有無の判断のための変数

        //識別番号の増加数の指定の有無を入力してもらうための質問文の表示
        System.out.println(INPUT_CHANGE_INCREMENT_NUMBER_MESSAGE);
        //識別番号の増加数指定の有無で処理を変更するため、入力された値を変数に代入する
        changeQuestionAnswer = inputNumberStream.nextInt();

        //メインメソッドに増加数有無判断の値を返却する
        return changeQuestionAnswer;
    }

    //識別番号の増加数を変更するためのメソッド
    private static int changeIncrementNumber(){
        int changeResultNumber = 0;                     //識別番号の増加数のための変数

        //指定する増加数を入力を促す文を表示する
        System.out.println(INPUT_INCREMENT_NUMBER_MESSAGE);
        //メインメソッドに返却するため、入力された値を変数に代入する
        changeResultNumber = inputNumberStream.nextInt();

        //メインメソッドに増加数の値を返却する
        return changeResultNumber;
    }

    //識別番号の増加数を渡してインスタンスを生成するためのメソッド
    private static void generateSpecifiedIncrementNumber(int incrementNumber){

        //Idを指定数増加させたインスタンスを生成する
        new En10_2_ExId(incrementNumber);
    }

    //インスタンスの識別番号を表示するためのメソッド
    private static void showId(){
        //Id確認のために取得メソッドを呼び出して出力する
        System.out.println("識別番号：" + En10_2_ExId.getMaxId());
    }

}
