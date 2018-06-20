package ensyuu15;

import java.util.Scanner;

/*
 * 文字列探索のプログラムを書きかえて、右のように(p.489の実行例)表示するプログラムを作成せよ。
 * 一致する部分が上下で揃うように表示すること。
 */
public class En15_3_SearchString {
    //プログラムンの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "入力された文字列から連続した指定文字列を探索し、"
                                                                       + "一致部分を上下で揃えて表示します。";
    //文字列の入力を促す文のための定数
    private static final String INPUT_STRING_REQUEST_MESSAGE = "\n文字列を入力してください。\n文字列s1:";
    //探索する文字列の入力を促す文のための定数
    private static final String INPUT_STRING_TO_SEARCH_MESSAGE = "\n入力された文字列から探索する文字列を入力してください。"
                                                                            + "\n文字列s2:";
    //入力された文字列を表示するヘッダーのための定数
    private static final String SHOW_INPUT_STRING_HEADER = "\ns1：";
    //探索する文字列を表示するヘッダーのための定数
    private static final String SHOW_SEARCH_STRING_HEADER = "\ns2：";
    //探索文字列が含まれていないと通知する文のための定数
    private static final String DOESNOT_INCLUDE_RESULT_MESSAGE = "探索する文字列は含まれていません。";
    //プログラムの繰り返し可否を問う質問文ための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\n\nもう一度やりますか？はい>>１、いいえ>>0：";
    //プログラムの終了を通知する文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明をするための文の表示
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //好きなだけプログラムを繰り返せるようにするための繰り返し処理
        do{
            String inputedString = "";                      //文字列探索する文字列のための変数
            String searchString = "";                       //探索する文字列のための変数
            int searchResult = 0;                           //探索結果の返却値のための変数

            //文字列を入力をさせるためのメソッドの呼び出し
            inputedString = inputString(INPUT_STRING_REQUEST_MESSAGE);

            //探索する文字列を入力させるためのメソッドの呼び出し
            searchString = inputString(INPUT_STRING_TO_SEARCH_MESSAGE);

            //文字列を探索するためのメソッドの呼び出し
            searchResult = searchString(inputedString, searchString);

            //探索する文字列が文字列内に含まれているか否かで処理を分けるための条件分岐
            if(searchResult == -1){
                //文字列が含まれていない結果を通知するための文の表示
                System.out.println(DOESNOT_INCLUDE_RESULT_MESSAGE);

            //文字列が含まれている結果のための分岐処理
            }else {
                //結果を表示するためのメソッドの呼び出し
                showSearchResult(inputedString, searchString, searchResult);
            }

        //真偽値の戻り値で繰り返しを制御するための条件式
        }while(isRepeatProgram());

        //値の入力が終了したので、開いていたリソースを開放する
        inputStream.close();

        //プログラムの終了を通知するための文の表示
        System.out.println(QUIT_PROGRAM_MESSAGE);

    }

    //文字列の入力を促すためのメソッド
    public static String inputString(String inputMessage){
        String inputedString = "";                          //呼び出し元に返却するための変数

        //文字列の入力を促すための文の表示
        System.out.print(inputMessage);
        //呼び出し元に返却するための値を変数に保持する
        inputedString = inputStream.next();

        //次の処理のための値を呼び出し元に返却する
        return inputedString;
    }

    //文字列を探索するためのメソッド
    public static int searchString(String inputedString, String toSearch){
        int searchResult = 0;                               //呼び出し元に探索結果を返却するための変数

        //文字列から文字を探索しその結果を変数に代入する
        searchResult = inputedString.indexOf(toSearch);

        //探索結果を呼び出し元に返却する
        return searchResult;
    }

    //探索結果を表示するためのメソッド
    public static void showSearchResult(String inputedString, String toSearch, int searchResultIndex){
        int stringLength = inputedString.length();          //文字列を出力する繰り返し処理制御のための変数
        int toSearchLength = toSearch.length();             //探索文字列の長さの取得

        //探索元文字列を表示するための出力
        System.out.print(SHOW_INPUT_STRING_HEADER + inputedString);

        //探索文字列を表示するためのヘッダーの出力
        System.out.print(SHOW_SEARCH_STRING_HEADER);
        //探索文字列の一致部分を揃えて表示するための繰り返し処理
        for(int outputStringLoop = 0;outputStringLoop < stringLength; outputStringLoop++){
            //一致した位置から探索文字列を出力するための分岐処理
            if(outputStringLoop >= searchResultIndex && outputStringLoop < searchResultIndex+toSearchLength){
                //一致箇所の文字を表示するための出力
                System.out.print(inputedString.charAt(outputStringLoop));
            //一致箇所以外を表示するための分岐処理
            }else{
                //一致箇所以外は空白を表示するための出力
                System.out.print(" ");
            }
        }
    }

    //プログラム繰り返す判定のためのメソッド
    public static boolean isRepeatProgram(){
        int repeatSelection = 0;                //選択された繰り返し可否番号のための変数

        //選択番号以外選択されている間入力を促し続けるための繰り返し処理
        do{
            //繰り返しの可否を選択させるための文の表示
            System.out.print(REPEAT_PROGRAM_QUESTION_MESSAGE);
            //判定のために変数に入力された値を保持する
            repeatSelection = inputStream.nextInt();
        //入力された値が選択番号以外である間処理を繰り返すための条件式
        }while(repeatSelection < 0 || repeatSelection > 1);

        //呼び出し元に判定を真偽値で返却するための条件式
        return repeatSelection == 1;
    }

}
