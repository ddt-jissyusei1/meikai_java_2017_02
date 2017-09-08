package ensyuu9;

/*
 *第8章で作成した<<銀行口座クラス（第2版）>>に、口座開設日のフィールドとtoStringメソッドを追加せよ。
 *※コンストラクタを変更したり、口座開設日のゲッタ（口座開設日フィールドが参照する日付インスタンスのコピーを返す）
 *などのメソッドを追加したりすること。
 */
public class En9_3 {

	public static void main(String[] args) {
		//足立君の口座を作成するためのコンストラクタの呼び出し
		En9_3_BankAccount adachi = new En9_3_BankAccount("足立幸一", "123456", 1000, new En9_2_Day(2017, 9, 5));

		//仲田君の口座を作成するためのコンストラクタの呼び出し
		En9_3_BankAccount nakata = new En9_3_BankAccount("仲田信二", "987654", 200, new En9_2_Day(2007, 5, 9));


		//足立君の口座から200円引き下ろすためのメソッドの呼び出し
		adachi.withdraw(200);

		//仲田君の口座に100円入金するためのメソッドの呼び出し
		nakata.deposit(100);

		//足立君の口座情報を表示する
		System.out.print(adachi.toString());
		//足立君の口座開設日を取得し表示する
		System.out.println("　■口座開設日：" + adachi.getAccountOpenedDate().toString());

		//仲田君の口座情報を表示する
		System.out.print(nakata.toString());
		//仲田君の口座開設日を取得し表示する
		System.out.println("　■口座開設日：" + nakata.getAccountOpenedDate().toString());

	}

}
