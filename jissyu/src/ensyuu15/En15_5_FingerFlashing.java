package ensyuu15;

import java.util.Random;
import java.util.Scanner;

/*
 * 3人で行うジャンケンプログラムを作成せよ。プレーヤ3人のうち、コンピュータを2人として、
 * 人間を1人とすること。また、演習13-3(p.443)で作成した、プレーヤクラスを利用すること。
 *
 * 作成者：志田
 * 作成日：20180625
 */
public class En15_5_FingerFlashing {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "プレイヤー1人、コンピュータ2人の3人でジャンケンを行います。";
    //プレーヤに出す手の選択を促す文のための定数
    private static final String SELECT_PLAYER_HANDS_MESSAGE = "出す手を選択して下さい。";
    //ジャンケンの掛け声のための定数
    private static final String START_GAME_STRING = "\nじゃんけんポン！";
    //ジャンケンの手の選択肢を表示するための文字列の定数
    private static final String HANDS_SELECTION_STRING = "(%d)%s ";
    //入力時前に表示する全角コロンのための定数
    private static final String SEPARATION_STRING = "：";
    //それぞれの手を表示するための文字列の定数
    private static final String SHOW_SELECTED_HANDS_STRING = "プレーヤ：%s\nコンピュータ１：%s\nコンピュータ２：%s";
    //引き分け結果の文のための定数
    private static final String EVEN_RESULT_MESSAGE = "\n引き分けです。";
    //ユーザーの勝ちを通知する文のための定数
    private static final String WIN_RESULT_MESSAGE = "\nあなたの勝ちです。";
    //ユーザーの負けを通知する文のための定数
    private static final String LOSE_RESULT_MESSAGE = "\nあなたの負けです。";
    //プログラムの繰り返しの可否の選択文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "\nもう一度やりますか？(%d)いいえ、(%d)はい：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //「はい」の選択番号のための定数
    private static final int SELECTION_NUMBER_YES = 1;
    //「いいえ」の選択番号のための定数
    private static final int SELECTION_NUMBER_NO = 0;
    //最小選択番号のための定数
    private static final int MIN_SELECTION_NUMBER = 0;
    //最大選択番号のための定数
    private static final int MAX_SELECTION_NUMBER = 2;
    //ジャンケンの手の選択肢の数のための定数
    private static final int SELECTION_NUMBERS = 3;
    //判定結果「引き分け」のための値の定数
    private static final int JUDGE_RESULT_EVEN = 0;
    //判定結果「負け」のための値の定数
    private static final int JUDGE_RESULT_LOSE = 1;
    //判定結果「勝ち」のための値の定数
    private static final int JUDGE_RESULT_WIN = 2;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputNumber = new Scanner(System.in);
    //乱数を生成するためのプログラム
    private static Random randomHands = new Random();
    //プログラムで使用するジャンケンの手のための配列の宣言
    public static String[] hands = {"グー", "チョキ","パー"};

    public static void main(String[] args) {
        int comOneHand = 0;                                   //コンピュータ１の手の値のための変数
        int comTwoHand = 0;                                   //コンピュータ２の手の値のための変数
        int playerHand = 0;                                   //プレーヤの手の値のための変数
        int judgeResult = 0;                                  //勝敗判定結果のための変数

        //プログラムの説明をするための文の表示
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //ユーザーが希望するだけプログラムを繰り返すようにするための繰り返し処理
        do{
            //コンピュータ１の手を生成するためのメソッドの呼び出し
            comOneHand = makeComHands();
            //コンピュータ２の手を生成するためのメソッドの呼び出し
            comTwoHand = makeComHands();
            //プレーヤにジャンケンの手を選択させるためのメソッドの呼び出し
            playerHand = selectPlayerHand();

            //ジャンケンんの掛け声を表示するための出力
            System.out.println(START_GAME_STRING);

            //それぞれの手を表示するための出力
            System.out.printf(SHOW_SELECTED_HANDS_STRING,hands[playerHand], hands[comOneHand], hands[comTwoHand]);

            //勝敗判定のためのメソッドの呼び出し
            judgeResult = judgeGameResult(playerHand, comOneHand, comTwoHand);

            //勝敗の結果を通知するためのメソッドの呼び出し
            showGameResult(judgeResult);

        //繰り返し可否メソッドからの返却値がtrueである間プログラムを繰り返すための条件式
        }while(isRepeatProgram());

        //値の入力が終了したので、開いていたリソースを開放する
        inputNumber.close();

        //プログラムの終了を通知するための文の出力
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }

    /**
     * コンピュータのジャンケンの手を生成するためのメソッド</br>
     * </br>
     *作成者：志田
     *作成日：20180625
     * @return madeComHand 生成されたジャンケンの手の値の返却
     */
    public static int makeComHands(){
        int madeComHand = 0;                //生成されたコンピュータの手の値のための変数

        //コンピュータの手を0～2の乱数で生成して返却するための変数に保持する
        madeComHand = randomHands.nextInt(3);

        //ジャンケンするために生成された値を呼び出しもとに編返却する
        return madeComHand;
    }

    /**
     * ユーザーに手の選択をさせるためのメソッド</br>
     * </br>
     * 作成者：志田
     * 作成日：20180625
     * @return selectedHand ジャンケンするためのプレーヤの手の値の返却
     */
    public static int selectPlayerHand(){
        int selectedHand = 0;               //選択された手の番号のための変数

        //正しい選択番号が入力されるまで選択処理を続けるための繰り返し処理
        do{
            //出す手の選択を促すための文の表示
            System.out.print(SELECT_PLAYER_HANDS_MESSAGE);
            //出す手の選択肢を表示するための繰り返し処理
            for(int handsSelectionLoop = 0; handsSelectionLoop < SELECTION_NUMBERS; handsSelectionLoop++){
                //選択番号と手を表示するための文字列の出力
                System.out.printf(HANDS_SELECTION_STRING, handsSelectionLoop, hands[handsSelectionLoop]);
            }
            //入力の受付を意味するための区切りコロンの表示
            System.out.print(SEPARATION_STRING);
            //選択された値を返却するために変数に保持する
            selectedHand = inputNumber.nextInt();

        //選択番号以外が入力されている間処理を繰り返すための条件式
        }while(selectedHand < MIN_SELECTION_NUMBER || selectedHand > MAX_SELECTION_NUMBER);

        //ジャンケンをするために呼び出し元に選択された値を返却する
        return selectedHand;
    }

    /**
     * 勝敗判定をするためのメソッド</br>
     * </br>
     * 作成者：志田
     * 作成日：20180625
     * @param playerHand    選択されたプレーヤの手の値
     * @param comOneHand    コンピュータ１の手の値
     * @param comTwoHand    コンピュータ２の手の値
     * @return finalJudgeResult  勝敗判定結果を返却する
     */
    public static int judgeGameResult(int playerHand, int comOneHand, int comTwoHand){
        int firstJudgeResult = 0;                            //プレイヤーとコンピュータ１との勝敗判定結果のための変数
        int secondJudgeResult = 0;                           //プレイヤーとコンピュータ２との勝敗判定結果のための変数
        int finalJudgeResult = 0;                            //最終判定の結果のための変数

            //プレイヤーとコンピュータ１の勝敗判定結果の算出
            firstJudgeResult = (playerHand - comOneHand + 3)%3;
            //プレイヤーとコンピュータ２の勝敗判定結果の算出
            secondJudgeResult = (playerHand - comTwoHand + 3)%3;

          //引き分け判定の場合に実行する処理のための条件分岐
            if(firstJudgeResult == JUDGE_RESULT_EVEN && secondJudgeResult == JUDGE_RESULT_EVEN){
                //引き分け判定の値を返却するための変数に保持する
                finalJudgeResult = JUDGE_RESULT_EVEN;
            //プレーヤーが勝ちである判定の場合に実行する処理のための条件分岐
            }else if(firstJudgeResult != JUDGE_RESULT_LOSE && secondJudgeResult != JUDGE_RESULT_LOSE){
                //勝ち判定の値を返却するための変数に保持する
                finalJudgeResult = JUDGE_RESULT_WIN;
            //プレーヤーが負けである判定の場合に実行する処理のための条件分岐
            }else if(firstJudgeResult != JUDGE_RESULT_WIN && secondJudgeResult !=JUDGE_RESULT_WIN){
                //負け判定の値を返却するための変数に保持する
                finalJudgeResult = JUDGE_RESULT_LOSE;
            }

        //勝敗通知のため判定結果を呼び出し元に返却する
        return  finalJudgeResult;
    }

    /**
     * 勝敗の結果を通知するためのメソッド
     * @param gameResult    勝敗判定の結果の値
     */
    public static void showGameResult(int gameResult){
        //判定結果を通知するための条件分岐処理
        switch(gameResult){
            //結果が引き分けの場合のための分岐処理
            case JUDGE_RESULT_EVEN:
                //引き分けの結果を通知するための文の表示
                System.out.println(EVEN_RESULT_MESSAGE);
                //次の処理に流れないようにするためのbreak処理
                break;

            //結果が負けの場合のための分岐処理
            case JUDGE_RESULT_LOSE:
                //プレイヤーの負けを通知するための文の表示
                System.out.println(LOSE_RESULT_MESSAGE);
                //次の処理に流れないようにするためのbreak処理
                break;

            //結果が勝ちの場合のための分岐処理
            case JUDGE_RESULT_WIN:
                //プレーヤの勝ちを通知するための文の表示
                System.out.println(WIN_RESULT_MESSAGE);
                //次の処理に流れないようにするためのbreak処理
                break;
        }
    }

    /**
     * プログラムの繰り返しを選択させるためのメソッド</br>
     * </br>
     * 作成者：志田
     * 作成日：20180625
     * @return boolean 繰り返し可の真偽値を返却する
     */
    public static boolean isRepeatProgram(){
        int repeatProgram = SELECTION_NUMBER_NO;            //プログラムの繰り返し選択番号のための変数

        //正しい選択番号が入力されるまで繰り返すための繰り返し処理
        do{
            //プログラムの繰り返し可否を選択させるための文の表示
            System.out.printf(REPEAT_PROGRAM_QUESTION_STRING, SELECTION_NUMBER_NO, SELECTION_NUMBER_YES);
            //繰り返し判定するために入力された値を変数に保持する
            repeatProgram = inputNumber.nextInt();
        //正しい値でない場合選択処理を繰り返すための条件式
        }while(repeatProgram != SELECTION_NUMBER_NO && repeatProgram != SELECTION_NUMBER_YES);

        //選択された値が1であるという等価演算子の真偽値を呼び出しもとに返却する
        return repeatProgram == SELECTION_NUMBER_YES;
    }
}
