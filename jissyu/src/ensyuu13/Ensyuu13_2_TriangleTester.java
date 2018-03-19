package ensyuu13;

import java.util.Scanner;

//直角三角形クラス群をテストするためのテスタークラス
public class Ensyuu13_2_TriangleTester {
    //プログラムの説明文のための定数
    private static final String  PROGRAM_EXPLANATION_STRING = "直角三角形を描画するクラスをテストするためのプログラムです。";
    //描画する三角形の数の入力を促す文のための定数
    private static final String INPUT_TRIANGLE_NUMBERS_MESSAGE = "描画する三角形の数を入力してください：";
    //描画する直角三角形の選択を促す文のための定数
    private static final String SELECT_TRIANGLE_SHAPE_MESSAGE = "\n%d個目の直角三角形の形を番号で選択してください。"
                                                                    + "[0]左下直角、[1]右下直角、[2]左上直角、[3]右上直角\n:";
    //描画する三角形の高さの入力を促さす文のための定数
    private static final String INPUT_TRIAGNLE_HEIGHT_MESSAGE = "三角形の高さを入力してください：";
    //プログラムの再実行の有無の入力を促す文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "もう一度やりますか？[1]はい、[0]いいえ：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //右下直角三角形の形の選択番号のための定数
    private static final int downRightTriSelectNum = 1;
    //左上直角三角形の形の選択番号のための定数
    private static final int upLeftTriSelectNum = 2;
    //右上直角三角形の形の選択番号のための定数
    private static final int upRightTriSelectNum = 3;

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputDataStream = new Scanner(System.in);

    public static void main(String[] args) {
        int triangleNumbers = 0;                 //描画する三角の数のための変数
        int triangleShapeNumber = 0;            //描画する三角形の形の選択番号のための変数
        int triangleHeight = 0;                  //描画する三角形の高さの値のための変数

        //プログラムの説明を表示するために文章出力のメソッドの呼び出し
        showMessage(PROGRAM_EXPLANATION_STRING);

        //ユーザーが好きなだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            //描画する三角形の数を入力してもらうための入力メソッドの呼び出し
            triangleNumbers = inputTriangleData(INPUT_TRIANGLE_NUMBERS_MESSAGE);

            //描画する三角形の数のため配列の宣言
            Ensyuu13_2_Triangles[] drawTriangles = new Ensyuu13_2_Triangles[triangleNumbers];

            //描画する三角形のインスタンスを生成するための繰り返し処理
            for(int createTriangleLoop = 0; createTriangleLoop < triangleNumbers; createTriangleLoop++){
                //描画する三角形の形を選択させるために入力メソッドを呼び出す
                triangleShapeNumber = selectTriangleShape(SELECT_TRIANGLE_SHAPE_MESSAGE, createTriangleLoop);

                //描画する三角形の高さを入力させるために入力メソッドを呼び出す
                triangleHeight = inputTriangleData(INPUT_TRIAGNLE_HEIGHT_MESSAGE);

                //描画する三角形のインスタンスを生成するためのメソッドの呼び出し
                drawTriangles[createTriangleLoop] = createInstance(triangleShapeNumber, triangleHeight);
            }

            //直角三角形を描画するための繰り返し処理
            for(Ensyuu13_2_Triangles drawTri : drawTriangles){
                //三角形を描画するためのメソッドの呼び出し
                drawTri.print();
                //次の三角形を描画するための区切りのための改行の出力
                System.out.println();
            }

        //繰り返し判定のメソッドの返却値がtrueの間プログラムを繰り返す条件式
        }while(repeatProgram());

        //プログラムの終了を通知するために文章出力メソッドの呼び出し
        showMessage(QUIT_PROGRAM_MESSAGE);
    }

    //文章のみを表示するためのメソッド
    public static void showMessage(String messageSentence){
        //引数で受け取った文字列を表示するための出力
        System.out.println(messageSentence);
    }

    //ユーザーに三角形の形を選択させるための入力メソッド
    public static int selectTriangleShape(String selectMessage, int inputLoopNumber){
        int selectedResult = 0;         //選択された番号のための変数

        //三角形の形の選択文を表示するための出力
        System.out.printf(selectMessage, inputLoopNumber+1);
        //呼び出し元に返却するために、入力された値を変数に保持する
        selectedResult = inputDataStream.nextInt();

        //入力された値を呼び出し元に返却する
        return selectedResult;
    }

    //ユーザーに描画する三角形に関する数値の入力を促すための入力メソッド
    public static int inputTriangleData(String inputMessage){
        int inputResult = 0;

        //ユーザーに値の入力を促す文を出力する
        System.out.println(inputMessage);
        //入力された値を呼び出しもとに返却するために変数に保持する
        inputResult = inputDataStream.nextInt();

        //呼び出し元に入力された値を次の処理で使用するために返却する
        return inputResult;
    }

    public static Ensyuu13_2_Triangles createInstance(int triangleShapeNumber, int triangleHeight){
        Ensyuu13_2_Triangles trianglesInstance = null;

        //引数の値で生成するインスタンスの処理を分岐するための条件式
        if(triangleShapeNumber == downRightTriSelectNum){
            //右下直角三角形のためのインスタンスの生成
            trianglesInstance = new Ensyuu13_2_DownRightTriangle(triangleHeight);

        //第一引数の値が2の場合の分岐処理
        }else if(triangleShapeNumber == upLeftTriSelectNum){
            //左上直角三角形のためのインスタンスの生成
            trianglesInstance = new Ensyuu13_2_UpLeftTriangle(triangleHeight);

        //第一引数の値が3の場合の分岐処理
        }else if(triangleShapeNumber == upRightTriSelectNum){
            //右上直角三角形のためのインスタンスの生成
            trianglesInstance = new Ensyuu13_2_UpRightTriangle(triangleHeight);

        //第一引数が上記以外の場合の分岐処理
        }else {
            //左下直角三角形のためのインスタンスの生成
            trianglesInstance = new Ensyuu13_2_DownLeftTriangle(triangleHeight);
        }

        //呼び出し元に生成したインスタンスの参照を返却する
        return trianglesInstance;
    }

    //プログラムを繰り返すかユーザーに決定させるためのメソッド
    public static boolean repeatProgram(){
        int repeatJudge = 0;                     //プログラムの繰り返し判定のための変数
        //プログラムの繰り返し可否の入力を促す文を表示するための文章出力メソッドんお呼び出し
        showMessage(REPEAT_PROGRAM_QUESTION_MESSAGE);
        //プログラムの繰り返し処理の判定のために入力された値を変数代入する
        repeatJudge = inputDataStream.nextInt();

        //入力された値を真偽値で返却するための条件式
        return repeatJudge == 1;
    }

}
