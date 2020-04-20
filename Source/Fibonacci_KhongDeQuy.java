class Fibonacci_KhongDeQuy extends Fibonacci
{
    @Override
    public int FindFibonacci(int n) {
        Count_Compare++; // so sánh n <= 1
        if (n <= 1)
        {
            Count_Assign++;
            return 1;
        }
        int last = 1; Count_Assign++;
        int nextToLast = 1; Count_Assign++;
        int answer = 1; Count_Assign++;
        for (int i = 2; i <= n; i++)
        {
            Count_Compare++;
            answer = last + nextToLast; Count_Assign++;
            nextToLast = last; Count_Assign++;
            last = answer; Count_Assign++;
        }
        Count_Compare++; //So sánh với n tại i = n + 1
        return answer;
    }
}
