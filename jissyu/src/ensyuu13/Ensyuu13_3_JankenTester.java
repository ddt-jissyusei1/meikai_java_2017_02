package ensyuu13;

import java.util.Scanner;

/*
 * ジャンケンの<<プレーヤ>>を表す抽象クラスを定義せよ。そのクラスから、以下のクラスを派生すること。
 * ・人間プレーヤクラス（出す手をキーボードから読み込む）
 * ・コンピュータプレーヤのクラス（出す手を乱数で生成する）
 */
public class Ensyuu13_3_JankenTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "コンピュータとジャンケンをするプログラムです。";
    //ユーザーに出す手の選択を促す文のための定数
    private static final String SELECT_USER_HAND_MESSAGE = "出す手を選択してください。[0]グー、[1]チョキ、[2]パー：";
    //手を出す合図文のための定数
    private static final String SHOW_HAND_SIGINAL_STRING = "ジャ-ン、ケン・・・ポン！";
    //勝者を知らせる文のための定数
    private static final String WINNER_MESSAGE = "\n%sの勝ちです！";
    //引き分けを知らせる文のための定数
    private static final String EVEN_MESSAGE = "引き分けです。";
    //再試合の可否の質問文のための定数
    private static final String ANOTHER_GAME_QUESTION_MESSAGE = "\nもう一度やりますか？[0]NO、[1]YES";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れさまでした。";
    //勝敗通知で表示するためのプレイヤー名詞のための定数
    private static final String USER_STRING = "ユーザー";
    //勝敗通知で表示するコンピュータ名詞のための定数
    private static final String COMPUTER_STRING = "コンピュータ";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力メソッドの呼び出し
        showMessage(PROGRAM_EXPLANATION_STRING);

        //ユーザーが好きなだけ試合できるようにするための繰り返し処理
        do{
            //プレイヤーの出す手のインスタンスを保持するための配列の宣言
            Ensyuu13_3_Player[] playerHands = new Ensyuu13_3_Player[2];

            //ユーザーに出す手を選択させるためのメソッドでユーザーのインスタンスを生成する。
            playerHands[0] = new Ensyuu13_3_PlayerUser(selectUserHand());

            //コンピューターの出す手のインスタンスを生成して配列に格納する
            playerHands[1] = new Ensyuu13_3_PlayerCom();

            //手を出す合図文を表示するための出力メソッドの呼び出し
            showMessage(SHOW_HAND_SIGINAL_STRING);

            //プレイヤーの手を表示するための繰り返し処理
            for(Ensyuu13_3_Player gamePlay : playerHands){
                //プレイヤーの出す手の参照先のメソッドの呼び出し
                gamePlay.showPlayersHand();
            }

            //勝者を決定して通知するためのメソッドの呼び出し
            winnerJudge();

        //プログラムの繰り返し可否を選択させるためのメソッドを呼び出し、返却された真偽値で判定するための条件式
        }while(repeatProgramJudge());

        //値の入力が終了したので、開いていたリソースを開放する
        inputStream.close();

        //プログラムの終了を通知する文の表示
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }

    //文章を表示するためのメソッド
    public static void showMessage(String programMessage){
        //引数の値を表示するための出力
        System.out.println(programMessage);
    }

    //ユーザーに出す手を選択させるためのメソッド
    public static int selectUserHand(){
        int selectedHand = 0;               //選択された手の値のための変数

        //不正な値が入力されても処理が止まらないようにするための繰り返し処理
        do{
            //ユーザーに出す手の選択を促す文を表示するためのメソッドの呼び出し
            showMessage(SELECT_USER_HAND_MESSAGE);
            //入力された値を返却するために変数に代入する
            selectedHand = inputStream.nextInt();

        //不正な値が入力され続けている間処理を繰り返すための条件式
        }while(selectedHand < 0 || selectedHand > 2);

        //呼び出し元に入力された値を返却する
        return selectedHand;
    }

    //勝敗を判定するためのメソッド
    public static void winnerJudge(){
        int computerHand = 0;               //コンピュータの手の値のための変数
        int userHand = 0;                   //ユーザーの手の値のための変数

        //コンピュータの手の値を取得して変数に代入する
        computerHand = Ensyuu13_3_PlayerCom.getComHand();
        //ユーザーの手の値を取得して変数に代入する
        userHand = Ensyuu13_3_PlayerUser.getUserHand();

        //コンピュータが勝利する場合の条件式
        if(computerHand == 0 && userHand == 1 || computerHand == 1 && userHand == 2 || computerHand == 2 && userHand == 0){
            //コンピュータの勝利を通知する文を表示するための出力
            System.out.printf(WINNER_MESSAGE,COMPUTER_STRING);

        //プレイヤーが勝利する場合の条件式
        }else if (computerHand == 0 && userHand == 2 || computerHand == 1 && userHand == 0 || computerHand == 2 && userHand == 1){
            //プレイヤーの勝利を通知する文を表示するための出力
            System.out.printf(WINNER_MESSAGE,USER_STRING);

        //引き分けだった場合の条件式
        }else {
            //引き分けを通知する文を表示する
            System.out.println(EVEN_MESSAGE);
        }
    }

    //プログラムの繰り返し可否を判定するためのメソッド
    public static boolean repeatProgramJudge(){
        int repeatProgram = 0;          //繰り返し判定の値のための変数

        //繰り返しの可否を問う質問文を表示するための出力メソッドの呼び出し
        showMessage(ANOTHER_GAME_QUESTION_MESSAGE);
        //入力された値を判定のための変数に代入する
        repeatProgram = inputStream.nextInt();

        //呼び出し元に真偽値を返却するための演算式
        return repeatProgram == 1;
    }

}
