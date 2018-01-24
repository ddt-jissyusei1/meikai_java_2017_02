package ensyuu10;

import java.util.Scanner;

/*
 * インスタンスが生成されるたびに『明解銀行での口座開設ありがとうございます。』と表示するように、
 * 銀行口座クラスAccountを変更せよ。表示はインスタンス初期化子で行うこと。
 */
public class En10_5_AccountTester {
    //プログラムの説明文のための定数
    private static final String PROGRAM_MESSAGE = "新規で口座を開設するたびにお礼を言うプログラムです。";
    //口座名義の入力を促す文のための定数
    private static final String INPUT_ACCOUNT_NAME_MESSAGE = "\n口座名義を入力してください：";
    //口座番号の入力を促す文のための定数
    private static final String INPUT_ACCOUNT_NUMBER_MESSAGE = "口座番号を入力してください：";
    //預金額の入力を促す文のための定数
    private static final String INPUT_DEPOSIT_AMOUNT_MESSAGE = "預金額を入力してください：";
    //口座情報の表示を伝える項目のための定数
    private static final String BANKACCOUNT_INFO_STRING = "\n★口座情報★";
    //口座開設の繰り返し判定の入力を促す文のための定数
    private static final String INPUT_REPEAT_PROGRAM_JUDGE = "\nプログラムを繰り返しますか？はい >>> 1、いいえ >>> 0 :";
    //プログラムの終了を知らせる文のための定数
    private static final String QUIT_PROGRAM_MESSAGE = "プログラムを終了します。お疲れ様でした。";


    //キーボードからの入力ストリームを読み込むためのプログラム
    private static Scanner inputNumberStream = new Scanner(System.in);

    public static void main(String[] args) {
        //プログラムの説明文を表示する
        System.out.println(PROGRAM_MESSAGE);

        String accountName;                         //口座名義のための変数
        String accountNumber;                       //口座番号のための変数
        long firstDepositAmount = 0;               //初期預金額のための変数
        int repeatMakeAccountProgram = 0;          //口座作成の繰り返し判定のための変数

        //ユーザーが好きなだけ口座の作成を繰り返せるようにするためのループ処理
        do{
            //口座名義を入力してもらうためのメソッドを呼び出す
            accountName = inputAccountName();

            //口座番号を入力してもらうためのメソッドを呼び出す
            accountNumber = inputAccountNumber();

            //預金額を入力してもらうためのメソッドを呼び出す
            firstDepositAmount = inputFirstDepositAmount();

            //入力された情報で口座のインスタンスを作成し、作成情報を表示するための出力
            System.out.println(BANKACCOUNT_INFO_STRING + openBankAccount(accountName, accountNumber, firstDepositAmount));

            //プログラムの繰り返し判定を入力してもらうためのメソッドの呼び出し
            repeatMakeAccountProgram = repeatProgramJudge();

        //繰り返し判定の値が0ではない間、口座作成を繰り返すための条件式
        }while(repeatMakeAccountProgram != 0);

        //プログラム終了を知らせる文を表示するための出力メソッドの呼び出し
        outputConstantMessage(QUIT_PROGRAM_MESSAGE);
    }

    //口座名義を入力してもらうためのメソッド
    private static String inputAccountName(){
        //入力された口座名義のための変数
        String accountName = null;

        //口座名義の入力を促す文を表示する
        System.out.print(INPUT_ACCOUNT_NAME_MESSAGE);
        //入力された値を返却するために、変数に保持する
        accountName = inputNumberStream.next();

        //口座作成のために、メインメソッドに入力された名義を返却する
        return accountName;
    }

    //口座番号を入力してもらうためのメソッド
    private static String inputAccountNumber(){
        //入力された口座番号のための変数
        String accountNumber = null;

        //口座番号の入力を促す文を表示する
        System.out.print(INPUT_ACCOUNT_NUMBER_MESSAGE);
        //入力された値を返却するため、変数に保持する
        accountNumber = inputNumberStream.next();

        //口座開設のために、メインメソッドに入力された番号を返却する
        return accountNumber;
    }

    //初期預金額を入力してもらうためのメソッド
    private static long inputFirstDepositAmount(){
        //入力された預金額のための変数
        long firstDepositAmount = 0;

        //口座開設時の預金額の入力を促す文を表示する
        System.out.print(INPUT_DEPOSIT_AMOUNT_MESSAGE);
        //入力された値を返却するために、変数に保持する
        firstDepositAmount = inputNumberStream.nextInt();

        //口座開設のために、メインメソッドに入力された番号を返却する
        return firstDepositAmount;
    }

    //口座を開設するためのメソッド
    private static En10_5_Account openBankAccount(String accountName, String accountNumber, long depositAmount){
        //新規口座のためのインスタンスの生成
        En10_5_Account bankUser = new En10_5_Account(accountName, accountNumber, depositAmount);

        //作成した口座のインスタンスをメインメソッドに返却する
        return bankUser;
    }

    //口座開設プログラムの繰り返し判定のためのメソッド
    private static int repeatProgramJudge(){
        int repeatResult = 0;               //繰り返し判定結果のための変数

        //プログラムの繰り返しの可否の入力を促す文を表示する
        System.out.print(INPUT_REPEAT_PROGRAM_JUDGE);
        //入力された値を返却するために、変数に保持する
        repeatResult = inputNumberStream.nextInt();

        //プログラムの繰り返しのためにメインメソッドに返却する
        return repeatResult;
    }

    //定形文を表示するための出力メソッド
    private static void outputConstantMessage(String messagesString){
        //引数で受け取った文字列を表示するための出力
        System.out.println(messagesString);
    }

}
