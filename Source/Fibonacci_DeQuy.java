
class Fibonacci_DeQuy extends Fibonacci
{
    @Override
    public int FindFibonacci(int n) {
            Count_Compare++; // So sánh n <= 1
            if (n <= 1)
            {
                Count_Assign++;
                return 1;
            }
            Count_Assign++; // Phép tính n = FindFibonacci(n - 1) + FindFibonacci(n - 2)
            return FindFibonacci(n - 1) + FindFibonacci(n - 2);
    }
}