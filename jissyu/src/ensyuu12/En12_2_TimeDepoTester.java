
package ensyuu12;

import java.util.Random;
import java.util.Scanner;



/*
 * 定期預金付き銀行口座クラス型変数a、ｂの
 * 普通預金と定期預金残高の合計額を比較した結果を返却するメソッドcompBalanceを作成せよ。
 * 　static int compBalance(Account a, Account b)
 *
 * 合計額を比較して、aのほうが多ければ1、等しければ0、 bのほうが多ければ-1を返却すること。
 * もしaやbの参照先が、定期預金をもたないAccount型のインスタンスであれば、普通預金の金額を比較の対象とすること。
 */

//定期預金付き銀行口座クラスをテストするためのクラス
public class En12_2_TimeDepoTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_EXPLANATION_STRING = "作成した2名の口座の普通預金と定額預金の合計残高を比較します。";
    //口座の作成を促す文のための定数
    private static final String CREATE_BANK_ACCOUNT_MESSAGE = "2名の口座を作成してください。";
    //何人目の口座作成か表示する文のための定数
    private static final String PERSON_NUMBER_STRING = "\n★%d人目の口座★\n";
    //口座名義の入力を促す文のための定数
    private static final String INPUT_ACCOUNT_NAME_MESSAGE = "・名前：";
    //口座開設日の入力を促す文のための定数
    private static final String INPUT_ACCOUNT_OPEN_DATE_MESSAGE = "\n口座開設日を入力してください。";
    //年の入力を促す項目のための定数
    private static final String INPUT_YEAR_COLUMN_STRING = "・年(西暦)：";
    //月の入力を促す項目のための定数
    private static final String INPUT_MONTH_COLUMN_STRING = "・月：";
    //日の入力を促す項目のための定数
    private static final String INPUT_DAY_COLUMN_STRING = "・日：";
    //入金額の入力を促す文のための定数
    private static final String INPUT_DEPOSIT_AMOUNT_MESSAGE = "初回入金額を入力してください。";
    //普通預金への入力を示す項目名のための定数
    private static final String ACCOUNT_BALANCE_COLUMN = "・普通預金入金額：";
    //定額預金への入力を示す項目名のための定数
    private static final String TIME_DEPO_COLUMN = "・定額預金入金額：";
    //表示する口座開設日の項目名のための定数
    private static final String ACCOUNT_OPENDATE_COLUMN_STRING = "　■口座開設日：";
    //プログラムの繰り返しを問う文のための定数
    private static final String REPEAT_PROGRAM_QUESTION_MESSAGE = "\nもう一度やりますか？　はい＞＞＞1、いいえ＞＞＞0";
    //プログラムを終了する通知文のための定数
    private static final String END_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";

    //比較のための作成する口座数のためのマジックナンバー
    private static final int MAKE_ACCOUNT_LOOP_NUMBER = 1;
    //入力する年月日のためのマジックナンバー
    private static final int INPUT_DATE_NUMBER = 3;
    //年月日を入力するループ数のためのマジックナンバー
    private static final int INPUT_DATE_LOOP_NUMBER = 2;


    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputAccountInfoStream = new Scanner(System.in);


    public static void main(String[] args) {
        String accountName = null;              //作成する口座名義のための変数
        int accountBalanceValue = 0;           //普通預金額のための変数
        int timeDepoValue = 0;                  //定額預金額のための変数
        En12_2_TimeDepoAccount[] userNumbers = new En12_2_TimeDepoAccount[2];


        //プログラムの説明文を表示するための出力
        System.out.println(PROGRAM_EXPLANATION_STRING);

        //プログラムをユーザーが続けたいだけ繰り返せるための繰り返し処理
        do {
            //残高合計額を比較するための口座情報の作成を通知する文を表示するための出力
            System.out.println(CREATE_BANK_ACCOUNT_MESSAGE);

                //2名の口座を作成するための繰り返し処理
                for(int makeAccountLoop = 0; makeAccountLoop <= MAKE_ACCOUNT_LOOP_NUMBER; makeAccountLoop++){
                    //何人目の口座作成かを通知するための表示
                    System.out.printf(PERSON_NUMBER_STRING, makeAccountLoop+1);

                    //口座名義を入力してもらうためのメソッドの呼び出し
                    accountName = inputAccountName();

                    //初回預金額の入力を促すための文を出力する
                    System.out.println(INPUT_DEPOSIT_AMOUNT_MESSAGE);

                    //普通預金への初回預金額を入力してもらうためのメソッドの呼び出し
                    accountBalanceValue = inputFirstDepoAmount(ACCOUNT_BALANCE_COLUMN);

                    //定額預金への初回預金額を入力してもらうためのメソッドの呼び出し
                    timeDepoValue = inputFirstDepoAmount(TIME_DEPO_COLUMN);

                    //入力されたデータを元に口座を作成し、表示用の配列に保持する
                    userNumbers[makeAccountLoop] = makeAccount(accountName, makeAccountNumber(), accountBalanceValue,
                                                          makeOpenAccountDate(), timeDepoValue);

                    //作成した口座情報を確認のため表示するメソッドの呼び出し
                    displayAccountInfo(userNumbers[makeAccountLoop]);
                }

            //二つの口座の全残高の比較をするためのメソッドの呼び出し
            int compResult = En12_2_TimeDepoAccount.compBalance(userNumbers[0], userNumbers[1]);

            //比較結果を表示するためのメソッドの呼び出し
            showCompareResult(compResult, userNumbers);

        //真偽値で繰り返しの可否を決定するためのメソッドの呼び出し
        }while(repeatProgramQuestion());

        //プログラムの終了文を通知するための出力
        System.out.println(END_PROGRAM_MESSAGE);

    }

    //口座名義を入力してもらうためのメソッド
    public static String inputAccountName(){
        String accountName;                    //入力された口座名義のための変数

        //口座名義の入力を促すための項目の出力
        System.out.print(INPUT_ACCOUNT_NAME_MESSAGE);
        //呼び出し元に返却するための変数への代入
        accountName = inputAccountInfoStream.next();

        //呼び出し元に口座名義の値を返却する
        return accountName;
    }

    //口座番号を乱数で生成するためのメソッド
    public static int makeAccountNumber(){
        //生成する乱数のためのインスタンス
        Random randomAccountNumber = new Random();

        //口座番号6桁の乱数を呼び出し元に返却するための変数に代入する
        int accountNumberResult = randomAccountNumber.nextInt(799998)+1;

        //呼び出し元に口座番号を返却する
        return accountNumberResult;
    }

    //口座開設日を設定するためのメソッド
    public static int[] makeOpenAccountDate(){
        //入力する年月日の項目名を保持するための配列の宣言
        String[] dateColumn = {INPUT_YEAR_COLUMN_STRING, INPUT_MONTH_COLUMN_STRING, INPUT_DAY_COLUMN_STRING};
        //入力された年月日の値を保持するための配列の宣言
        int[] openDate = new int[INPUT_DATE_NUMBER];

        //口座開設日の日付入力を促す文を出力する
        System.out.println(INPUT_ACCOUNT_OPEN_DATE_MESSAGE);

        //年月日を入力するための繰り返し処理
        for(int dateLoopCount = 0; dateLoopCount <= INPUT_DATE_LOOP_NUMBER; dateLoopCount++){
            //入力する日付の値の項目名を出力する
            System.out.print(dateColumn[dateLoopCount]);
            //入力された値を返却するための配列に代入する
            openDate[dateLoopCount] = inputAccountInfoStream.nextInt();
        }

        //呼び出し元に年月日の値を保持した配列を返却する
        return openDate;
    }

    //初回預金額を入力してもらうためのメソッド
    public static int inputFirstDepoAmount(String inputColumn){
        int firstDepoAmount = 0;                //入力された値を保持するための変数

        //入力先を示すために項目名を出力する
        System.out.print(inputColumn);
        //入力された値を呼び出しもとに返却するための変数に代入する
        firstDepoAmount = inputAccountInfoStream.nextInt();

        //呼び出しもとに入力された値を返却する
        return firstDepoAmount;
    }

    //口座を作成するためのメソッド
    public static En12_2_TimeDepoAccount makeAccount(String userName, int accountNumber, long accountBalance, int[] openAccountDate, long timeBalance){
        //受け取った引数の値で口座インスタンスを作成する
        En12_2_TimeDepoAccount makeAccount = new En12_2_TimeDepoAccount(userName, accountNumber,
                accountBalance, new En12_1_Day(openAccountDate[0], openAccountDate[1], openAccountDate[2]), timeBalance);

        //呼び出し元に作成した口座インスタンスへの参照を返却する
        return makeAccount;
    }

    //口座情報を表示するためのメソッド
    public static void displayAccountInfo(En12_2_TimeDepoAccount userAccount){
        //利用者の口座情報を表示するための出力
        System.out.print(userAccount.toString());
        //利用者の口座開設日を取得し表示する
        System.out.println(ACCOUNT_OPENDATE_COLUMN_STRING + userAccount.getAccountOpenedDate().toString());
    }

    //普通預金と定期預金の合計額の比較結果を表示するためのメソッド
    public static void showCompareResult(int compareResult, En12_2_TimeDepoAccount[] usersInfo){
        //比較結果の値で表示する内容を変えるための条件式
        if(compareResult != 0){
            //残高が多いほうの結果を表示するための演算式
            System.out.println(compareResult == 1 ? "\n" + usersInfo[0].getAccountName() + "さんの残高が多いです。":
                "\n" + usersInfo[1].getAccountName()+ "さんの残高が多いです");
        //どちらの残高も同じだった場合に実行するための処理
        }else {
            //残高が同じであることを伝える文の出力
            System.out.println("\n二人の残高は同額です。");

        }

    }

    //プログラムの繰り返し判定のためのメソッド
    public static boolean repeatProgramQuestion(){
        int questionResult = 0;         //ユーザーが入力した繰り返し可否判定の値のための変数

        //プログラムを繰り返すかの質問文を表示するための出力
        System.out.println(REPEAT_PROGRAM_QUESTION_MESSAGE);
        //繰り返しを判定し返却するためにユーザーが入力した値を変数に代入する
        questionResult = inputAccountInfoStream.nextInt();

        //入力された値を真偽値で返却する
        return questionResult == 1 ;
    }

}
