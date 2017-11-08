package ensyuu10;

public class En10_3_MinMax {

    //二値の最小値を求めるためのメソッド
    public static int searchMinOfTwo(int[] twoNumbers){
        int minimumNumber = 0;       //最小値の値のための変数

        //最小値を求めるための条件式
        //一つ目の値が最小値である場合に実行するための条件式
        if(twoNumbers[0] < twoNumbers[1]){
            //最小値の変数に一つ目の数値を代入する
            minimumNumber = twoNumbers[0];
        //一つ目の値が最小である以外の場合に実行するための条件式
        }else{
            //最小値の変数に二つ目の数値を代入する
            minimumNumber = twoNumbers[1];
        }

        //呼び出し元に求めた最小値の値を返却する
        return minimumNumber;
    }

    //二値の最大値を求めるためのメソッド
    public static int searchMaxOfTwo(int[] twoNumbers){
        int maximumNumber = 0;          //最大値の値のための変数

        //最大値を求めるための条件式
        //一つ目の値が最大値である場合に実行するための条件式
        if(twoNumbers[0] > twoNumbers[1]){
            //最大値のための変数に一つ目の数値を代入する
            maximumNumber = twoNumbers[0];
        //一つ目の値が最大値ではない場合に実行するための条件式
        }else{
            //最大値の変数に二つ目の数値を代入する
            maximumNumber = twoNumbers[1];
        }

        //呼び出し元に求めた最大値の値を返却する
        return maximumNumber;
    }

    //三値の最小値を求めるためのメソッド
    public static int searchMinOfThree(int[] threeNumbers){
        int minimumNumber = threeNumbers[0];         //最小値を求める入れ替えのための一つ目の値を代入した変数

        //最小値変数の値より二つ目の数値が小さい場合に実行するための条件式
        if(threeNumbers[1] < minimumNumber){
            //最小値変数の値を入れ替える
            minimumNumber = threeNumbers[1];
        }

        //最小値変数の値より三つ目の数値が小さい場合に実行するための条件式
        if(threeNumbers[2] < minimumNumber){
            //最小値変数の値を入れ替える
            minimumNumber = threeNumbers[2];
        }

        //呼び出し元に求めた最小値の値を返却する
        return minimumNumber;
    }

    //三値の最大値を求めるためのメソッド
    public static int searchMaxOfThree(int[] threeNumbers){
        int maximumNumber = threeNumbers[0];        //最大値を求める値の入れ替えのために一つ目の値を代入した変数

        //最大値変数の値より二つ目の数値が大きい場合に実行する条件式
        if(maximumNumber < threeNumbers[1]){
            //最大値変数に二つ目の値を代入する
            maximumNumber = threeNumbers[1];
        }

        //最大値変数の値より三つ目の数値が大きい場合に実行する条件式
        if(maximumNumber < threeNumbers[2]){
            //最大値変数に三つ目の値を代入する
            maximumNumber = threeNumbers[2];
        }

        //呼び出し元に求めた最大値の値を返却する
        return maximumNumber;
    }

    //配列の最小値を求めるためのメソッド
    public static int searchMinFromArray(int[] arrayNumbers){
        int minimumNumber = 0;                  //返却する最小値のための変数
        int arrayLength = arrayNumbers.length;  //最小値を求める繰り返し処理で使用する配列の長さの値を取得する

        //最初の要素を後の要素と比較するため最小値用の変数に代入する
        minimumNumber = arrayNumbers[0];

        //配列の最小値を求めるため、繰り返し処理で要素の値を比較する
        for(int minArrayLoop = 0; minArrayLoop < arrayLength; minArrayLoop++){
            //現行の最小値と配列の要素を比較して、要素のほうが小さければ入れ替える処理を実行する条件式
            if(arrayNumbers[minArrayLoop] < minimumNumber){
                //要素のほうが小さければ値を入れ替える
                minimumNumber = arrayNumbers[minArrayLoop];
            }
        }
        //呼び出し元に求めた配列の最小値を返却する
        return minimumNumber;
    }

    //配列の最大値を求めるためのメソッド
    public static int searchMaxFromArray(int[] arrayNumbers){
        int maximumNumber = 0;                  //返却する最大値のための変数
        int arrayLength = arrayNumbers.length;  //最大値を求める繰り返し処理で使用するため配列の長さの値を取得する

        //最初の要素を後の要素と比較するため最大値用の変数に代入する
        maximumNumber = arrayNumbers[0];

        //配列の最大値を求めるため、繰り返し処理で要素の値を比較する
        for(int maxArrayLoop = 0; maxArrayLoop < arrayLength; maxArrayLoop++){
            //現行の最大値と配列の要素を比較して、要素のほうが大きければ入れ替える処理を実行する条件式
            if(arrayNumbers[maxArrayLoop] > maximumNumber){
                //要素のほうが大きければ値を入れ替える
                maximumNumber = arrayNumbers[maxArrayLoop];
            }
        }
        //呼び出し元に求めた配列の最大値を返却する
        return maximumNumber;
    }

}
