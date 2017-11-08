package ensyuu10;
import java.util.Scanner;

/*
 * 二値/三値/配列の最小値を求めるメソッドや
 * 最大値を求めるメソッドを集めたユーティリティクラスMinMaxを作成せよ。
 */
public class En10_3_MinMaxTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING =
            "二値/三値/配列の最小最大値をそれぞれ求めるメソッドクラスのためのテストプログラムです。";
    //最小最大値を求める数値の選択文のための定数
    private static final String SELECT_PROGRAM_MESSAGE =
            "値を求める数値の数を選択してください。\n二値 >>>0を入力、三値　>>>１を入力、配列　>>>2を入力　：";
    //最小最大値どちらを求めるかの選択文のための定数
    private static final String SELECT_MIN_MAX_QUESTION_STRING =
            "最小・最大どちらを求めますか？　最小なら0を、最大なら１を入力してください：";
    //求める値の入力を促すための文の定数
    private static final String INPUT_COMPARE_NUMBER_STRING = "比較するための数値を整数で入力してください。";
    //配列の要素数の入力を促すための文の定数
    private static final String INPUT_ARRAY_NUMBER_STRING = "配列の要素数を入力してください。";
    //配列の値入力時に表示するインデックスの定数
    private static final String INPUT_ARRAY_INDEX = "%dつ目の値：";
    //結果表示用の文のための定数
    private static final String RESULT_STRING = "%sの%sの値は%dです。\n";
    //二値の値を入力するためのマジックナンバー
    private static final int INPUT_TWO_NUMBER_MAGIC = 2;
    //三値の値を入力するためのマジックナンバー
    private static final int INPUT_THREE_NUMBER_MAGIC = 3;
    //プログラムを続けるかの質問文のための定数
    private static final String CONTINUE_PROGRAM_QUESTION_STRING = "プログラムを続けますか？　はい >>>1、いいえ >>>2：";
    //プログラムの終了を知らせるための文の定数
    private static final String END_PROGRAM_MESSAGE_STRING = "プログラムを終了します。お疲れさまでした。";

    //入力ストリームを読み込むためのクラスの呼び出し
    private static Scanner inputNumberStream = new Scanner(System.in);

    public static void main(String[] args) {
        String[] minMaxStrings = {"最小値", "最大値"};          //最小・最大の選択肢の配列
        String[] programNumbers = {"二値", "三値", "配列"};     //二値・三値・配列の選択しの配列
        String selectedProgram;                                 //二値・三値・配列の選択肢のための変数
        String selectedMinMaxMethod;                           //最小・最大の選択肢のための変数
        int[] inputResult;                                      //入力された値の結果を保持するための変数
        int resultNumber = 0;                                   //結果の値のための変数

        //どのようなプログラムであるか説明するために説明文を出力表示する
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //プログラムを望むだけ繰り返しできるようするための繰り返し処理
        do{
            //二値/三値/配列を選択させるため、選択処理用のメソッドを呼び出して引数として選択文を渡す
            selectedProgram = programNumbers[selectProgram(SELECT_PROGRAM_MESSAGE)];

            //選択されたプログラムによって呼び出す値入力のメソッドを分けるための条件式
            if(selectedProgram == "二値"){
                //二値の値をユーザーに入力させるために、引数に2を渡して入力用メソッドを呼び出す
                inputResult = inputTwoThreeNumber(INPUT_TWO_NUMBER_MAGIC);

             //選択された値が三値だった場合に実行する処理
            }else if(selectedProgram == "三値"){
                //三値の値をユーザーに入力させるために、引数に3を渡して入力用メソッドを呼び出す
                inputResult = inputTwoThreeNumber(INPUT_THREE_NUMBER_MAGIC);

            //選択された値が上記以外（配列）だった場合に実行する処理
            }else{
                //配列の値をユーザーに入力させるためのメソッドを呼び出す
                inputResult = inputArrayNumbers();
            }

            //最小値もしくは最大値を選択させるため、選択処理用のメソッドを呼び出して引数として選択文を渡す
            selectedMinMaxMethod = minMaxStrings[selectProgram(SELECT_MIN_MAX_QUESTION_STRING)];

            //最小・最大値を求めるメソッドを選択された値を引数に渡し、返却された結果を変数に代入する
            resultNumber = callMinMaxMethod(inputResult, selectedProgram,selectedMinMaxMethod);

            //求めた結果を通知をするために、結果の値を表示するメソッドを呼び出す
            showMinMaxResult(selectedProgram, selectedMinMaxMethod, resultNumber);

        //繰り返しの選択の値が『１』である間、プログラムを繰り返す条件式
        }while(selectProgram(CONTINUE_PROGRAM_QUESTION_STRING) == 1);

        //値の入力が終了したので、開いていたリソースを開放する
        inputNumberStream.close();

        //プログラムの終了を知らせる文を出力する
        System.out.println(END_PROGRAM_MESSAGE_STRING);

    }

    //プログラムをユーザーに選択してもらい、選択された値を返却するためのメソッド
    private static int selectProgram(String message){
        int selectResultNumber = 0;          //選択された値をメインメソッドに返却するための変数
        //ユーザーに選択させるための選択肢を表示する
        System.out.print(message);
        //入力された選択肢の値を呼び出し元に返却するために変数に代入する
        selectResultNumber = inputNumberStream.nextInt();

        //呼び出し元に選択された値を返却する
        return selectResultNumber;
    }

    //二値・三値の値をユーザーに入力させるためのメソッド
    private static int[] inputTwoThreeNumber(int arrayNumbers){
        int[] inputResult = new int[arrayNumbers];               //入力された値を保持するための配列の宣言
        int arrayLength = inputResult.length;                     //値入力の繰り返し処理で使用する配列の長さの変数

        //値の入力を促すための文を出力する
        System.out.println(INPUT_COMPARE_NUMBER_STRING);

        //入力された値を配列に格納するための繰り返し処理
        for(int arrayLoop = 0; arrayLoop < arrayLength; arrayLoop++){
            //入力する値のインデックスを表示する
            System.out.printf(INPUT_ARRAY_INDEX, arrayLoop+1);
            //入力された値を返却用配列に格納する
            inputResult[arrayLoop] = inputNumberStream.nextInt();
        }

        //呼び出し元に最小または最大を求めるために配列を返却する
        return inputResult;
    }

    //配列の値をユーザーに入力させるためのメソッド
    private static int[] inputArrayNumbers(){
        int arrayNumber = 0;                                    //配列の要素数のための変数

        //値を入力する配列の要素数をユーザーに入力させるための文を出力する
        System.out.println(INPUT_ARRAY_NUMBER_STRING);
        //配列を宣言するために入力された値を変数に代入する
        arrayNumber = inputNumberStream.nextInt();
        //入力された値を保持するための配列を宣言する
        int[] inputArrayResult = new int[arrayNumber];

        int arrayLength = inputArrayResult.length;              //値入力の繰り返し処理で使用するための配列の長さの変数

        //値の入力を促すための文を出力する
        System.out.println(INPUT_COMPARE_NUMBER_STRING);

        //入力された値を配列に格納するための繰り返し処理
        for(int arrayLoop = 0; arrayLoop < arrayLength; arrayLoop++){
            //入力する値のインデックスを表示する
            System.out.printf(INPUT_ARRAY_INDEX, arrayLoop+1);
            //入力された値を返却用配列に格納する
            inputArrayResult[arrayLoop] = inputNumberStream.nextInt();
        }

        //最小・最大を求めるために呼び出し元に配列を返却する
        return inputArrayResult;
    }

    //最小・最大値を求めるメソッド呼び出すためのメソッド
    private static int callMinMaxMethod(int[] compareNumbers, String selectedNumber, String minMaxMethodNumber){
        int resultNumber = 0;                   //求めた結果の値を保持するための変数

        //呼び出すメソッドを条件によって切り替える
        //二値と最小が選択された場合に実行する処理の条件式
        if(selectedNumber == "二値" && minMaxMethodNumber == "最小値"){
            //二値の最小値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMinOfTwo(compareNumbers);
        //二値と最大が選択された場合に実行する処理の条件式
        }else if(selectedNumber == "二値" && minMaxMethodNumber == "最大値"){
            //二値の最大値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMaxOfTwo(compareNumbers);
        //三値と最小が選択された場合に実行する処理の条件式
        }else if(selectedNumber == "三値" && minMaxMethodNumber == "最小値"){
            //三値の最小値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMinOfThree(compareNumbers);
        //三値と最大が選択された場合に実行する処理の条件式
        }else if(selectedNumber == "三値" && minMaxMethodNumber == "最大値"){
            //三値の最大値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMaxOfThree(compareNumbers);
        //配列と最小が選択された場合に実行する処理の条件式
        }else if(selectedNumber == "配列" && minMaxMethodNumber == "最小値"){
            //配列の最小値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMinFromArray(compareNumbers);
        //配列と最大が選択された場合に実行する処理の条件式
        }else {
            //配列の最大値を求めるメソッドを呼び出す
            resultNumber = En10_3_MinMax.searchMaxFromArray(compareNumbers);
        }

        //呼び出し元に求めた値を返却する
        return resultNumber;
    }

    //求めた結果を表示をするためのメソッド
    private static void showMinMaxResult(String index, String minMax, int minMaxResultNumber){
        //求めた結果をprintfメソッドを使用して出力する
        System.out.printf(RESULT_STRING, index, minMax, minMaxResultNumber);
    }




}
