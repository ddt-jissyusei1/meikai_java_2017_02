package ensyuu14;

import java.util.Scanner;

/*
 * ここに示した図形クラス群を利用するプログラム例を作成せよ。
 */
public class En14_1_ShapeTester2 {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "図形を拡大するためのテストプログラムです。";
    //描画する図形を選択させる文のための定数
    private static final String SELECT_SHAPE_MESSAGE = "\n描画する図形を選択してください。平行四辺形>>>1、長方形>>>0：";
    //高さの値の入力を促す文のための定数
    private static final String INPUT_HEIGHT_VALUE_MESSAGE = "\n図形の高さを入力してください：";
    //幅の値の入力を促す文のための定数
    private static final String INPUT_WIDTH_VALUE_MESSAGE = "図形の幅を入力してください：";
    //拡大または縮小の選択を促す文のための定数
    private static final String SELECT_CHANGE_SIZE_MESSAGE = "\n拡大もしくは縮小を選択してください。拡大>>>1、縮小>>>0：";
    //拡大するサイズ値の入力を促す文のための定数
    private static final String INPUT_EXPAND_VALUE_MESSAGE = "拡大する値を入力してください：";
    //縮小するサイズ値の入力を促す文のための定数
    private static final String INPUT_SHRINK_VALUE_MESSAGE = "縮小する値を入力してください：";
    //図形のサイズを変更したことを通知する文のための定数
    private static final String CHANGE_SIZE_SUCCESS_MESSAGE = "\n図形を%sしました。\n";
    //プログラムの繰り返し可否の入力を促す文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_STRING = "もう一度やりますか？はい>>>1、いいえ>>>0：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "\nプログラムを終了します。お疲れ様でした。";
    //もう一度番号の入力を促す文のための定数
    private static final String INPUT_CORRECT_NUMBER_MESSAGE = "正しい選択番号を入力してください。";

    //"拡大"の項目名のための定数
    private static final String EXPAND_COLUMN_STRING = "拡大";
    //"縮小の項目名のための定数
    private static final String SHRINK_COLUMN_STRING = "縮小";

    //縮小の選択番号のための定数
    private static final int SHRINK_INDEX_NO = 0;
    //拡大の選択番号のための定数
    private static final int EXPAND_INDEX_NO = 1;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //ユーザーが希望するだけプログラムを繰り返せるための繰り返し処理
        do{
            int selectedShape = 0;              //選択された図形番号のための変数
            int heightValue = 0;                //図形の高さのための変数
            int widthValue = 0;                 //図形の幅のための変数
            int selectedChange = 0;             //選択された拡大縮小番号のための変数

            //正しい選択番号を入力させるための繰り返し処理
            do{
                //描画する図形の選択を促すためのメソッドの呼び出し
                inputErrorCheck(selectedShape = inputValue(SELECT_SHAPE_MESSAGE));
            //選択番号が入力されるまで処理を繰り返す
            }while(selectedShape < 0 || selectedShape > 1);

            //図形の高さの値の入力を促すためのメソッドの呼び出し
            heightValue = inputValue(INPUT_HEIGHT_VALUE_MESSAGE);

            //図形の幅の値の入力を促すためのメソッドの呼び出し
            widthValue = inputValue(INPUT_WIDTH_VALUE_MESSAGE);

            //図形インスタンスのための宣言
            En14_1_Shape drawShape;

            //選択された図形番号事にインスタンス生成処理を分けるための条件分岐
            if(selectedShape == 0){
                //長方形のためのインスタンスの生成
                drawShape = new En14_1_Rectangle(heightValue, widthValue);

            }else{
                //平行四辺形のためのインスタンスの生成
                drawShape = new En14_1_Parallelogram(heightValue, widthValue);
            }

            //生成した図形情報を確認するための表示
            drawShape.print();

            //正しい選択番号を入力させるための繰り返し処理
            do{
                //図形の拡大縮小の選択を入力をさせるためのメソッドの呼び出し
                inputErrorCheck(selectedChange = inputValue(SELECT_CHANGE_SIZE_MESSAGE));
            //選択番号が入力されるまで処理を繰り返す
            }while(selectedChange < 0 || selectedChange > 1);


            //選択された図形番号事にサイズ変更インスタンス生成処理を分けるための条件分岐
            if(selectedShape == 0){
                //長方形のためのインスタンスの生成
                drawShape = new En14_1_Rectangle(heightValue, widthValue,
                                                   changeSizeValueInput(selectedChange, heightValue, widthValue));

            }else{
                //平行四辺形のためのインスタンスの生成
                drawShape = new En14_1_Parallelogram(heightValue, widthValue,
                                                   changeSizeValueInput(selectedChange, heightValue, widthValue));
            }

            //選択されたサイズ変更事に処理を分けるための条件分岐
            if(selectedChange == EXPAND_INDEX_NO){
                //図形を拡大するためのメソッドの呼び出し
                drawShape.expandShape();
                //図形を拡大したことを通知するための文の出力
                System.out.printf(CHANGE_SIZE_SUCCESS_MESSAGE, EXPAND_COLUMN_STRING);

            }else{
                //図形を縮小するためのメソッドの呼び出し
                drawShape.shrinkShape();
                //図形を縮小をしたことを通知するための文の出力
                System.out.printf(CHANGE_SIZE_SUCCESS_MESSAGE, SHRINK_COLUMN_STRING);

            }

            //サイズ変更した図形情報を確認するための表示
            drawShape.print();


        //返却された真偽値で繰り返し判定するための条件式
        }while(repeatProgramJudge());

        //値の入力が終了したので、開いていたリソースを開放する
        inputStream.close();

        //プログラムの終了を通知する文を表示するための出力
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }


    //値の入力をさせるためのメソッド
    public static int inputValue(String inputMessage){
        int value = 0;                          //入力された値のための変数

        System.out.print(inputMessage);
        //入力された値を呼び出しもとに返却するために変数に代入する
        value = inputStream.nextInt();

        //呼び出し元に入力された値を返却する
        return value;
    }


    //変更するサイズの値の入力処理のためのメソッド
    public static int changeSizeValueInput(int selectedChange, int shapeHeight, int shapeWidth){
        int changeSizeValue = 0;               //図形のサイズ変更の値のための変数

        do{
            //引数の値で処理を分岐させる
            switch(selectedChange){

            //拡大が選択された場合のための処理
            case EXPAND_INDEX_NO :
                //図形を拡大する値の入力を促すメソッドの呼び出し
                changeSizeValue = inputValue(INPUT_EXPAND_VALUE_MESSAGE);
                //次の処理を実行しないよう現在のブロックを抜ける
                break;

            //縮小が選択された場合の処理
            case SHRINK_INDEX_NO :
            //図形を縮小する値の入力を促すメソッドの呼び出し
                changeSizeValue = inputValue(INPUT_SHRINK_VALUE_MESSAGE);
                //次の処理を実行しないよう現在のブロックを抜ける
                break;

            //指定番号以外が選択された場合のための処理
            default :
                //正しい番号を選択するよう促す文を表示するための出力
                System.out.println(INPUT_CORRECT_NUMBER_MESSAGE);
            }
        //サイズ変更の値が図形の高さと幅の値より大きい間入力処理を繰り返すための条件式
        }while(selectedChange == SHRINK_INDEX_NO && changeSizeValue >= shapeHeight && changeSizeValue >= shapeWidth);

        //呼び出し元に入力された値を返却する
        return changeSizeValue;
    }


    //プログラムの繰り返し判定をするためのメソッド
    public static boolean repeatProgramJudge(){
        int repeatProgram = 0;                  //繰り返し判定の値のための変数

        //繰り返しの可否の質問を表示するための出力
        repeatProgram = inputValue(REPEAT_PROGRAM_QUESTION_STRING);

        //入力された値の真偽値を返却する
        return repeatProgram == 1;
    }

    //入力された値のエラーチェックのためのメソッド
    public static void inputErrorCheck(int checkValue){

        //引数の値が選択番号以外の場合にエラーを通知するための処理
        if(checkValue < 0 || checkValue > 1){
            //正しい番号の入力を促す文を表示するための出力
            System.out.println(INPUT_CORRECT_NUMBER_MESSAGE);
        }
    }











}
