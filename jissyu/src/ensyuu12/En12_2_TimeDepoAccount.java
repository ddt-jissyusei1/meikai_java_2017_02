package ensyuu12;

//定期預金付き銀行口座のためのクラス
public class En12_2_TimeDepoAccount extends En12_2_BankAccount {
    private long mTimeBalance;                  //預金残高（定期預金）のための変数

    //定期預金付き口座クラスのためのコンストラクタ
    public En12_2_TimeDepoAccount(String accountName, int accountNumber, long accountBalance,
            En12_1_Day accountOpenedDate, long timeBalance) {
        //継承した親クラスのコンストラクタの呼び出し
        super(accountName, accountNumber, accountBalance, accountOpenedDate);
        //預金残高（定期預金）のためのコンストラクタ
        this.mTimeBalance = timeBalance;

    }

    //定期預金残高を調べるためのゲッターメソッド
    public long getmTimeBalance() {
        //呼び出し元に取得した残高の値を返却する
        return mTimeBalance;
    }

    //定期預金時の計算をするためのオーバーライドメソッド
    void timeDeposit(long amountOfDeposit){
        //定期預金用メンバ変数に預金額を加算する
        mTimeBalance += amountOfDeposit;
    }


    //定期預金を解約して全額を普通預金に移すためのメソッド
    void cancelTimeDeposit(){
        //定期預金の残高を普通に全額移すために、普通預金のメソッドを呼び出す
        deposit(mTimeBalance);
        //普通預金に移行後、定期預金のメンバ変数を0にするための処理
        mTimeBalance = 0;
    }

    //定額預金残高を文字列表現するためのメソッド
    @Override public String toString(){

        return String.format(super.toString()+"　■定額預金残高：%d円\n", getmTimeBalance());
    }








}
