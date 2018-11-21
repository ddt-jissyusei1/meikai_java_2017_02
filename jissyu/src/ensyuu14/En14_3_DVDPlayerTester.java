package ensyuu14;

import java.util.Scanner;

/*
 * クラスDVDPlayerを利用するプログラムを作成せよ。
 */
public class En14_3_DVDPlayerTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "DVDプレーヤクラスをテストするためのプログラムです。";
    //操作の選択を促す文のための定数
    private static final String SELECT_CONTROL_STRING = "\n操作を選択してください："
                                                                        + "\n□停止>>>0\n■再生>>>1\n◆スロー再生>>>2\n";
    //プログラムの繰り返しの可否を問う文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "\nもう一度やりますか？はい>>>1、いいえ>>>0：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";
    //入力された選択番号が不正であることを通知する文のための定数
    private static final String SELECTED_NUMBER_ERROR_MESSAGE = "選択番号が不正な値です！";

    //操作の選択数のための定数
    private static final int CONTROL_SELECTION_NUMBER = 3;
    //はいいいえの二択の選択数のための定数
    private static final int YES_NO_SELECTION_NUMBER = 2;

    //停止の操作の選択番号のための定数
    private static final int STOP_CONTROL_NUMBER = 0;
    //再生の操作の選択番号のための定数
    private static final int PLAY_CONTROL_NUMBER = 1;
    //スロー再生の操作の選択番号のための定数
    private static final int SLOW_PLAY_CONTROL_NUMBER = 2;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputValueStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明をするための文の出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        int playerControlNumber;                                 //DVDの操作番号のための変数

        //ユーザーが希望するだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            playerControlNumber = 0;                                //変数を初期化するための0の代入
            En14_3_IFExPlayer playDvd = new En14_3_DVDPlayer();     //操作するDVDプレーヤのためのインスタンスの生成

            //プレーヤの操作を入力させるための選択処理メソッドの呼び出し
            playerControlNumber = inputSelectNumber(SELECT_CONTROL_STRING, CONTROL_SELECTION_NUMBER);

            //選択されたDVDプレーヤの操作を実行するためのメソッドの呼び出し
            executeDVDPlayerControl(playerControlNumber, playDvd);


        //繰り返し判定メソッドからの返却値で繰り返しの可否を決定するための条件式
        }while(repeatProgramJudge(playerControlNumber));


        //プログラムの終了を通知するための文の出力
        System.out.println(QUIT_PROGRAM_MESSAGE);

    }

    //番号選択式入力を処理するためのメソッド
    /**
     *
     * @param inputRequestMessage
     * @param selectionNumbers
     * @return selectedNumber
     */
    public static int inputSelectNumber(String inputRequestMessage, int selectionNumbers){
        //選択された番号を保持するための変数
        int selectedNumber = 0;

        //不正な値が入力された場合繰り返し入力を促せるようにするための繰り返し処理
        do{
            //ユーザーに選択させるための第一引数の選択文の出力
            System.out.print(inputRequestMessage);
            //入力された値を呼び出し元に返却するため変数に代入する
            selectedNumber = inputValueStream.nextInt();
        //不正な値が入力されている間入力処理を繰り返すための条件式
        }while(selectNumberCheck(selectedNumber, selectionNumbers));

        //呼び出し元に選択された値を返却する
        return selectedNumber;
    }

    //選択されたプレーヤの操作を実行するためのメソッド
    /**
     *
     * @param controlNumber
     * @param controlDvd
     */
    public static void executeDVDPlayerControl(int controlNumber, En14_3_IFExPlayer controlDvd){
        //第一引数の値で実行する操作の処理を分けるための分岐処理
        switch(controlNumber){

        //引数の値が再生の１の場合の分岐処理
        case PLAY_CONTROL_NUMBER:
            //再生するためのメソッドの呼び出し
            controlDvd.play();
            //次の処理に流れないようブロックを抜けるためのbreak文
            break;

        //引数の値がスロー再生の２の場合の分岐処理
        case SLOW_PLAY_CONTROL_NUMBER:
            //スロー再生するためのメソッドの呼び出し
            controlDvd.slow();
            //次の処理に流れないようブロックを抜けるためのbreak文
            break;

        //引数の値が停止の０の場合の分岐処理
        case STOP_CONTROL_NUMBER:
            //停止のためのメソッドの呼び出し
            controlDvd.stop();
            //次の処理に流れないようブロックを抜けるためのbreak文
            break;
        }
    }

    //プログラムの繰り返し判定のためのメソッド
    /**
     *
     * @param selectedControlNumber
     * @return boolean
     */
    public static boolean repeatProgramJudge(int selectedControlNumber){
        //入力された繰り返し可否のための変数
        int repeatJudge = 1;

        //引数の値が停止の選択番号0である場合にのみ実行するための条件式
        if(selectedControlNumber == STOP_CONTROL_NUMBER){

            //入力された値が不正な間入力処理を繰り返すための繰り返し処理
            do{
                //繰り返しの可否を問うための質問文の出力
                System.out.print(REPEAT_PROGRAM_QUESTION_STRING);
                //繰り返し可否判定のため入力された値を変数に代入する
                repeatJudge = inputValueStream.nextInt();
            //不正な値チェックメソッドからの返却値がfalseである間繰り返し処理を続けるための条件式
            }while(selectNumberCheck(repeatJudge, YES_NO_SELECTION_NUMBER));
        }

        //入力された値の真偽値を呼び出しもとに返却する
        return repeatJudge == 1;
    }

    //選択された番号が正常値であるか判定するためのメソッド
    /**
     *
     * @param selectedNumber
     * @param selectionNumbers
     * @return errorCheckResult
     */
    public static boolean selectNumberCheck(int selectedNumber, int selectionNumbers){
        //判定結果のための変数
        boolean errorCheckResult = false;

        //値が正常値ではない場合に実行するための条件分岐
        if(selectedNumber < 0 || selectedNumber > selectionNumbers){
            //入力された選択番号が不正であることを通知するための文の出力
            System.out.println(SELECTED_NUMBER_ERROR_MESSAGE);
            //判定結果にtrueを代入する
            errorCheckResult = true;
        }

        //呼び出し元に判定結果を返却する
        return errorCheckResult;

    }

}
