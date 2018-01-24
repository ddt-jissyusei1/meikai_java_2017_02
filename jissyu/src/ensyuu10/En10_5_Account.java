package ensyuu10;

public class En10_5_Account {
    //口座開設のお礼文のための定数
    private static final String OPEN_ACCOUNT_THANKS_MESSAGE = "\n\n『明解銀行での口座開設ありがとうございます。』";
    //表示する口座情報の、口座識別番号の項目のための定数
    private static final String ACCOUNT_ID_COLUMN_STRING = "\n■識別番号：No.";
    //表示する口座情報の、口座名義の項目のための定数
    private static final String ACCOUNT_NAME_COLUMN_STRING = "\n■口座名義：";
    //表示する口座情報の、口座番号の項目のための定数
    private static final String ACCOUNT_NUMBER_COLUMN_STRING = "\n■口座番号：";
    //表示する口座情報の、預金残高の項目のための定数
    private static final String ACCOUNT_BALANCE_COLUMN_STRING = "\n■預金残高：";

    //与えた識別番号の数を数えるためのカウンター変数
    private static int counter = 0;

    private String accountName;                 //口座名義のための変数
    private String accountNo;                   //口座番号のための変数
    private long accountBalance;                //預金残高のための変数
    private int accountId;                      //口座識別番号のための変数
    private String thanksMessage;               //口座開設お礼文のための変数

    //口座開設のインスタンスが生成されるたびに初期化するためのインスタンス初期化子
    {
        accountId = ++counter;                  //異なる識別番号を与えるためインクリメントした値を代入
    }

  //新規で開設されるたびに表示するためのお礼文のインスタンス初期化子
    {
        //開設のお礼を表示するための出力
        System.out.println(OPEN_ACCOUNT_THANKS_MESSAGE);
    }

    //口座開設のための引数なしのコンストラクタ
    public En10_5_Account(){

    }

    //口座開設のための引数が口座名義のみのコンストラクタ
    public En10_5_Account(String accountName){
        this.accountName = accountName;        //口座名義のフィールドへの引数の値の代入
    }

    //口座開設のための引数が口座名義と口座番号のみのコンストラクタ
    public En10_5_Account(String accountName, String accountNo){
        this.accountName = accountName;         //口座名義のフィールドへの引数の値の代入
        this.accountNo = accountNo;             //口座番号のフィールドへの引数の値の代入
    }

    //口座開設のための引数が口座名義・口座番号・預金額のコンストラクタ
    public En10_5_Account(String accountName, String accountNo, long accountBalance) {
        this.accountName = accountName;         //口座名義のフィールドへの引数の値の代入
        this.accountNo = accountNo;             //口座番号のフィールドへの引数の値の代入
        this.accountBalance = accountBalance;   //預金残高のフィールドへの引数の値の代入
    }

    //口座名義を取得するためのメソッド
    public String getAccountName() {
        //呼び出し元に取得した名義を返却する
        return accountName;
    }

    //口座番号を取得するためのメソッド
    public String getAccountNo() {
        //呼び出し元に取得した口座番号を返却する
        return accountNo;
    }

    //預金残高を取得するためのメソッド
    public long getAccountBalance() {
        //呼び出し元に取得した預金残高を返却する
        return accountBalance;
    }

    //口座識別番号を取得するためのメソッド
    public int getAccountId() {
        //呼び出し元に取得した識別番号を返却する
        return accountId;
    }

    //口座開設文を取得するためのメソッド
    public String getThanksMessage(){
        //呼び出し元に取得した口座開設文を返却する
        return thanksMessage;
    }

    //預金を行う処理ためのメソッド
    public void deposit(long depositAmount){
        //預金残高のフィールドの値に、引数の入金額を加算代入する
        accountBalance += depositAmount;
    }

    //引落しを行う処理のためのメソッド
    public void withdraw(long withdrawAmount){
        //預金残高のフィールドの値に、引数の引落し額を減算代入する。
        accountBalance -= withdrawAmount;
    }

    //口座情報を文字列に整形して表示するためのメソッド
    public String toString(){
        //口座情報を文字列に整形して呼び出し元に返却する
        return  ACCOUNT_ID_COLUMN_STRING + accountId
                                + ACCOUNT_NAME_COLUMN_STRING + accountName
                                + ACCOUNT_NUMBER_COLUMN_STRING+ accountNo
                                + ACCOUNT_BALANCE_COLUMN_STRING + accountBalance;
    }




}
