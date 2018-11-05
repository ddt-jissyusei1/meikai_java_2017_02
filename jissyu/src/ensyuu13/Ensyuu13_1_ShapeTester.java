package ensyuu13;

import java.util.Scanner;

/*
 * 図形クラス群をテストするプログラムを作成せよ。List13-9(p.443)と同じく、
 * Shape型の配列を利用して、インスタンスの生成と表示を行うこと。
 * ただし、個々の要素が参照するインスタンスは、プログラム内で与えるのではなく、気ボードから読み込むようにすること。
 */
public class Ensyuu13_1_ShapeTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_MESSAGE = "図形を描画するクラス群をテストするプログラムです。";
    //描画する図形の個数の入力を促す文のための定数
    private static final String INPUT_NUMBER_OF_SHAPES_MESSAGE = "\n描画する図形の数を入力してください：";
    //長さの値の入力を促す文のための定数
    private static final String INPUT_LENGTH_VALUE_MESSAGE = "長さを入力してください：";
    //幅の値の入力を促す文のための定数
    private static final String INPUT_WIDTH_VALUE_MESSAGE = "幅を入力してください：";
    //高さの値の入力を促す文のための定数
    private static final String INPUT_HIEGHT_VALUE_MESSAGE = "高さを入力してください：";
    //描画する図形の番号と選択文のための定数
    private static final String SELECT_DRAW_SHAPE_STRING = "\n%d番目の図形の種類（0・・・点 / 1・・・水平直線 "
                                                                                + "/ 2・・・垂直直線 / 3・・・長方形）"
                                                                                + " \n:";
    //プログラムを繰り返しの有無を問う質問文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "プログラムをもう一度やりますか？ はい>>>1、いいえ>>>0:";
    //不正な値が入力された場合に再入力を促す文のための定数
    private static final String WRONG_VALUE_MESSAGE = "不正な値です！！もう一度入力してください：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "\nプログラムを終了します。お疲れ様でした。";

    //水平直線の図形選択番号のための定数
    private static final int HORIZONTAL_LINE_SHAPE_INDEX_NUMBER = 1;
    //垂直曲線の図形選択番号のための定数
    private static final int VERTICAL_LINE_SHAPE_INDEX_NUMBER = 2;
    //長方形の図形選択番号のための定数
    private static final int RECTANGLE_SHAPE_INDEX_NUMBER = 3;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputValueStream = new Scanner(System.in);

    public static void main(String[] args) {
        int shapesNumber = 0;                       //描画する図形の数のための変数
        int createShapeLoop = 0;                    //図形のインスタンス生成の繰り返し処理のためのカウンター変数
        int shapeIndexNumber = 0;                   //選択された図形のインデックス番号のための変数

        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_MESSAGE);

        //プログラムをユーザーが望むだけ繰り返せるようにするためのループ文
        do{
            //描画する図形の個数の入力を促すための文の出力
            System.out.print(INPUT_NUMBER_OF_SHAPES_MESSAGE);
            //描画する図形の数を制御するため、入力された値を変数に代入する
            shapesNumber = inputValueStream.nextInt();

            //描画する図形のインスタンスのための配列
            Ensyuu13_1_Shape[] shapesToDraw = new Ensyuu13_1_Shape[shapesNumber];

            //描画する図形数分のインスタンスを生成するための繰り返し処理
            for(createShapeLoop = 0;createShapeLoop < shapesNumber; createShapeLoop++){
                //描画する図形をユーザーに選択させるためのメソッドの呼び出し
                shapeIndexNumber = selectShape(SELECT_DRAW_SHAPE_STRING, createShapeLoop);

                //参照している配列の値で処理を分岐させるための条件式
                switch(shapeIndexNumber){

                //選択番号が1の水平直線の図形のための処理
                case HORIZONTAL_LINE_SHAPE_INDEX_NUMBER :
                    //水平直線のインスタンス生成のためのメソッドの呼び出し
                    shapesToDraw[createShapeLoop] = createHorzLine();
                    //次の分岐処理に流れないように条件式から抜ける
                    break;

                //選択番号が2の垂直直線のための処理
                case VERTICAL_LINE_SHAPE_INDEX_NUMBER :
                    //垂直線のインスタンス生成のためのメソッドの呼び出し
                    shapesToDraw[createShapeLoop] = createVertLine();
                    //次の分岐処理に流れないように条件式から抜ける
                    break;

                //選択番号が3の長方形のための処理
                case RECTANGLE_SHAPE_INDEX_NUMBER :
                    //長方形のインスタンス生成のためのメソッドの呼び出し
                    shapesToDraw[createShapeLoop] = createRectangle();

                    //次の処理に流れないよう条件式から抜ける
                    break;

                //上記以外の、選択番号が0の点のための処理
                default :
                    //図形描画のための配列に点のインスタンスへの参照を代入する
                    shapesToDraw[createShapeLoop] = new Ensyuu13_1_Point();
                }
            }

            //図形を描画するための繰り返し処理
            for(Ensyuu13_1_Shape drawShape : shapesToDraw){
                //図形を描画するメソッドの呼び出し
                drawShape.print();
                //次に描画する図形との区切りのための改行出力
                System.out.println();
            }

            //プログラムを繰り返すか判定するためのメソッドの呼び出し
            //repeatJudge = repeatProgramQuestion();

        //繰り返し有無の判定のメソッドの返却値が真である間処理を繰り返す
        }while(repeatProgramQuestion());

        //値の入力が終了したので、開いていたリソースを開放する
        inputValueStream.close();

        //プログラムの終了を通知するための文の出力
        System.out.println(QUIT_PROGRAM_MESSAGE);
    }


    //描画する図形の選択をユーザーにさせるためのメソッド
    public static int selectShape(String selectShapeMessage, int drawingNumber){
        int selectedResult = 0;                //選択された図形番号のための変数

        //描画する図形の選択文を表示させるための出力
        System.out.printf(selectShapeMessage, drawingNumber+1);
        //呼び出しもとに入力された値を返却するために、変数に代入する
        selectedResult = inputValueStream.nextInt();

        //図形データの処理の分岐を決めるために呼び出し元に値を返却する
        return selectedResult;
    }

    //図形の描画に必要な値をユーザーに入力させるためのメソッド
    public static int inputValue(String inputMessage){
        int inputValueResult = 0;            //入力された値のための変数

        //値の入力を促す文の出力
        System.out.print(inputMessage);
        //呼び出し元に返却するための変数に入力された値を代入する
        inputValueResult = inputValueStream.nextInt();

        //図形の描画で使用するために、呼び出し元に値を返却する
        return inputValueResult;
    }

    //直線のインスタンスを生成するためのメソッド
    public static Ensyuu13_1_Shape createHorzLine(){
        int shapeHorzLength = 0;            //水平直線の長さの値のための変数

        //長さの値を入力してもらうためのメソッドの呼び出し
        shapeHorzLength = inputValue(INPUT_LENGTH_VALUE_MESSAGE);

        //入力された値を引数に呼び出し元に水平直線のインスタンスへの参照を返却する
        return new Ensyuu13_1_HorzLine(shapeHorzLength);
    }

    //垂直直線のインスタンスを生成するためのメソッド
    public static Ensyuu13_1_Shape createVertLine(){
        int shapeVertLength = 0;            //垂直直線の長さの値のための変数

        //長さの値を入力してもらうためのメソッドの呼び出し
        shapeVertLength = inputValue(INPUT_LENGTH_VALUE_MESSAGE);

        //入力された値を引数に、呼び出し元に垂直直線のインスタンスへの参照を返却する
        return new Ensyuu13_1_VertLine(shapeVertLength);
    }

    //長方形のインスタンスを生成するためのメソッド
    public static Ensyuu13_1_Shape createRectangle(){
        int shapeHeight = 0;                //高さの値のための変数
        int shapeWidth = 0;                 //幅の値のための変数

        //高さの値を入力してもらうためのメソッドの呼び出し
        shapeHeight = inputValue(INPUT_HIEGHT_VALUE_MESSAGE);
        //幅の値を入力してもらうためのメソッドの呼び出し
        shapeWidth = inputValue(INPUT_WIDTH_VALUE_MESSAGE);

        //入力された値を引数に、呼び出し元に長方形のインスタンスへの参照を返却する
        return new Ensyuu13_1_Rectangle(shapeHeight, shapeWidth);
    }

    //プログラムを繰り返す有無の処理のためのメソッド
    public static boolean repeatProgramQuestion(){
        int repeatJudgeValue = 0;           //繰り返し判定の値のための変数


        //不正な値が入力された場合に繰り返し入力を促すためのループ文
        do{
            //プログラムの繰り返しの有無の入力を促す文の出力
            System.out.print(REPEAT_PROGRAM_QUESTION_MESSAGE);
            //入力された値を繰り返し処理の判定のために変数に代入する
            repeatJudgeValue = inputValueStream.nextInt();

            //不正な値が入力された場合に表示する文の出力ための条件式
            if(repeatJudgeValue < 0 || repeatJudgeValue > 1){
            //不正な値が入力された場合に再入力を促すための文の出力
            System.out.print(WRONG_VALUE_MESSAGE);
            }
        }while(repeatJudgeValue < 0 || repeatJudgeValue > 1);

        //真偽値を返却するための演算式
        return repeatJudgeValue == 1;
    }

}
