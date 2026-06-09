package main.Coding.Algorithms.Normal.DistrbuteMoneyToMax_2591;

public class TEST {
    public static void main(String[] args) {

    }

    public int distMoney(int money, int children) {
        // every child gets 1 dollar
        int moneyLeft = money - children;

        // if money cannot be distributed to all children
        if (moneyLeft < 0)
            return -1;

        // if all children can get 8 dollars
        if (moneyLeft / 7 == children && moneyLeft % 7 == 0)
            return children;

        // if a child can get 4 dollars
        if (moneyLeft / 7 == children - 1 && moneyLeft % 7 == 3)
            return children - 2;

        // if not every child gets 8 dollars and nobody gets 4 dollars
        int count = (children - 1) < (moneyLeft / 7) ? (children - 1) : (moneyLeft / 7);
        return count;
    }
}
