
abstract class Fibonacci {
    protected int Count_Assign;
    protected int Count_Compare;
    public int FindFibonacci(int n)
    {
        return 0;
    }
    public int[] Execute(int n) {
        Count_Assign = 0; // khởi tạo Count_Assign
        Count_Compare = 0; // khởi tạo Count_Compare
        int []result = {n, FindFibonacci(n - 1), Count_Assign, Count_Compare};
        return result; 
    }
}