package ensyuu14;

import java.util.Scanner;

/*
 * ロボット型ペットクラスRobotPet(p.407)を拡張した、
 * 着せ替え可能なロボット型ペットクラスを作成せよ。
 * インタフェースSkinnableを実装すること。
 */
public class En14_2_PetTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "着せ替え可能なロボット型ペットクラスをテストするためのプログラムです。";
    //ペットの名前の入力を促す文のための定数
    private static final String INPUT_PET_NAME_MESSAGE = "\nペットの名前を入力してください：";
    //ペットの主人の名前の入力を促す文のための定数
    private static final String INPUT_PETMASTER_NAME_MESSAGE = "飼い主の名前を入力してください：";
    //ペットの色の選択を促す文のための定数
    private static final String SELECT_PET_SKINCOLOR_MESSAGE = "ペットの色を選択してください。\n白=0\n黒=1\n銀=2\n赤=3\n青=4\n緑=5\n:";
    //ペットの色変更の有無の選択を促す文のための定数
    private static final String SELECT_CHANGECOLOR_ORNOT_MESSAGE = "\nペットの色を変更しますか？はい>>>1、いいえ>>>0";
    //プログラムの繰り返しの可否を問う質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\nもう一度始めからやりますか？ はい>>>1、いいえ>>>0：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE ="プログラムを終了します。お疲れ様でした。";
    //入力された選択番号が不正だと通知する文のための定数
    private static final String INPUT_NUMBER_ERROR_MESSAGE = "不正な値です。正しい選択番号を入力してください。";

    //色の選択数のための定数
    private static final int COLOR_SELECTION_NUMBERS = 5;
    //二択の選択番号数のため定数
    private static final int TWO_SELECTION_NUMBERS = 2;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputValueStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムを説明する文を表示するための出力する
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //ユーザーが希望するだけプログラムを繰り返せるためのループ処理
        do{
            String robotPetName;                            //ペットの名前のための変数
            String robotPetMasterName;                     //ペットの飼い主の名前のための変数
            int robotPetColor = 0;                         //ペットの色のための変数

            //ペットの名前の入力を促す文を表示するための出力
            System.out.print(INPUT_PET_NAME_MESSAGE);
            //ロボットペットインスタンスを生成するために、入力されたペットの名前を変数に保持する
            robotPetName = inputValueStream.next();

            //ペットの飼い主の名前の入力を促す文を表示するための出力
            System.out.print(INPUT_PETMASTER_NAME_MESSAGE);
            //ロボットペットインスタンスを生成するために、入力されたペットの飼い主の名前を変数に保持する
            robotPetMasterName = inputValueStream.next();

            //ペットの色の選択をさせるための選択番号入力メソッドの呼び出す
            robotPetColor = inputSelectNumber(SELECT_PET_SKINCOLOR_MESSAGE, COLOR_SELECTION_NUMBERS);

            //ロボットペットのインスタンスを生成する
            En14_2_RobotPet[] rbPet = {new En14_2_RobotPet(robotPetName, robotPetMasterName)};

            //ペットの色設定するためのメソッドの呼び出し
            changePetSkinColor(rbPet, robotPetColor);
            //ロボットペットの自己紹介文を表示するためのメソッドの呼び出し
            petIntroduce(rbPet);

            //ペットの色の変更の有無を入力させるためのメソッドの呼び出し
            while(inputSelectNumber(SELECT_CHANGECOLOR_ORNOT_MESSAGE, TWO_SELECTION_NUMBERS) == 1){
                //変更する色を選択させるため選択番号入力メソッドを呼び出す
                robotPetColor = inputSelectNumber(SELECT_PET_SKINCOLOR_MESSAGE, COLOR_SELECTION_NUMBERS);
                //ペットの色を変更するメソッドの呼び出し
                changePetSkinColor(rbPet, robotPetColor);
                //色を変更後の自己紹介を表示するために自己紹介メソッドを呼び出す
                petIntroduce(rbPet);
            }

        //繰り返し可否判定がtrueのプログラムを繰り返すための条件式
        }while(repeatProgramJudge(inputSelectNumber(REPEAT_PROGRAM_QUESTION_MESSAGE, TWO_SELECTION_NUMBERS)));

        //プログラムの終了を通知する文を表示するための出力
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }

    //ユーザーに選択番号を入力させるためのメソッド
    private static int inputSelectNumber(String selectMessage, int selectionNumber){
        int inputResult = 0;                               //入力結果のための変数

        do{
            //選択文を表示するための出力
            System.out.print(selectMessage);
            //入力された値を返却するために変数に代入する
            inputResult = inputValueStream.nextInt();
        }while(selectedNumberCheck(inputResult, selectionNumber));

        //入力結果を呼び出し元に返却する
        return inputResult;
    }

    //ペットの自己紹介文を表示するためのメソッド
    private static void petIntroduce(En14_2_RobotPet[] rbPet){
        //生成した情報確認のため、ロボットペット自己紹介メソッドを呼び出す
        for(En14_2_RobotPet rbIntroduce : rbPet){
            //ロボットペットの自己紹介のためのインタフェースの呼び出し
            rbIntroduce.introduce();

        }
    }

    //ペットの色を変更するためのメソッド
    private static void changePetSkinColor(En14_2_RobotPet[] rbPet, int robotPetColor){
         //ロボットペットの色を変更するためのメソッドの呼び出し
        for(En14_2_RobotPet rbChangeColor : rbPet){
            //ロボットペットの色を引数の値に変更するメソッドの呼び出し
            rbChangeColor.changePetSkin(robotPetColor);
        }
    }

    //プログラムの繰り返し可否判定のためのメソッド
    private static boolean repeatProgramJudge(int repeatSelect){
        //条件式の判定結果を真偽値で呼び出し元に返却する
        return repeatSelect == 1;
    }

    //入力された数値が選択番号範囲内であるか判定するためのメソッド
    private static boolean selectedNumberCheck(int checkInputNumber, int maxSelectNumber){
        boolean checkResult = false;                //判定結果のための変数

        //入力された値が不正な場合のみ実行するための条件式
        if(checkInputNumber < 0 || checkInputNumber > maxSelectNumber){
            //再入力を促す文を表示する
            System.out.println(INPUT_NUMBER_ERROR_MESSAGE);
            //判定結果変数にfalseを代入する
            checkResult = true;
        }
        //判定結果を呼び出し元に返却する
        return checkResult;
    }

}
