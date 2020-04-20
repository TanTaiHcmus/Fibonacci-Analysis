# Báo cáo độ phứt tạp của bài toán Fibonacci

Chúng ta giải quyết bài toán tìm số **Fibonacci** thứ *n* bằng **2** thuật toán khác nhau: **Đệ quy** và **không đệ quy**.
> **Dãy Fibonacci** là dãy vô hạn các số tự nhiên bắt đầu bằng hai phần tử 1 và 1. Các phần tử tiếp theo được tính theo công thức truy hồi sau:
>
> ![{\displaystyle F(n):=\left\{{\begin{matrix}1\,,\qquad \qquad \qquad \quad \,\ \ \,&&{\mbox{khi }}n=1\,;\ \ \\1,\qquad \qquad \qquad \qquad \,&&{\mbox{khi }}n=2;\ \ \,\\F(n-1)+F(n-2)&&{\mbox{khi }}n>2.\end{matrix}}\right.}](https://wikimedia.org/api/rest_v1/media/math/render/svg/6693d2c78bc8132bb9b65be861148ca574a738ef)

## Thuật toán đệ quy

Trên lý thuyết, thuật toán này áp dụng việc tính toán số **Fibonacci** thứ *n* dựa trên số **Fibonacci** thứ *n - 1* và *n - 2*. Như vậy ta có thể hình dung được cách tính toán này có dạng **Cây nhị phân** có độ cao là *n - 2* với mỗi  *node cha* có 2 *node con* và bằng tổng của chúng. Vậy nên ta có thể tính *số phép tính thực hiện* của thuật toán này là *2^(n - 1) - 1*.  Thuật toán được mô tả như sau:
```java
int FindFibonacci(int n) 
{
	Count_Compare++;  // So sánh n <= 1
	if (n <= 1)
	{
		Count_Assign++;
		return  1;
	}
	Count_Assign++;  // Phép tính n = FindFibonacci(n - 1) + FindFibonacci(n - 2)
	return FindFibonacci(n - 1) + FindFibonacci(n - 2);
}
```
Tính theo lý thuyết thì số phép gán là *2^(n - 1) - 1* và số phép so sánh là *2^(n - 1) - 1*.

### Bảng kết quả khi chạy code


| Input| Output| Count-Assign | Count-Compare |
| :-------------: |:-------------:| :-----:| :----: |
| 3 | 2 | 3 | 3 |
| 6 | 8 | 15 | 15 |
| 9 | 34 | 67 | 67 |
| 12| 144 | 287| 287|
| 15| 610| 1219| 1219|
| 18| 2584| 5167| 5167 |
| 21| 10946| 21891| 21891|
| 24| 46368| 92735| 92735|
| 27| 196418| 392835| 392835|
| 30| 832040| 1664079| 1664079|

*Kết quả được lưu lại trong file Report_Fibonacci_DeQuy.csv*
## Thuật toán không đệ quy (vòng lặp)
Trên lý thuyết, thuật toán này có độ phứt tạp tuyến tính *O(n)* với vòng lặp *1 -> n*. Thuật toán được mô tả như sau:
```java
public  int  FindFibonacci(int n) {
	Count_Compare++;  // so sánh n <= 1
	if (n <= 1)
	{
		Count_Assign++;
		return  1;
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
	Count_Compare++;  //So sánh với n tại i = n + 1
	return answer;
}
```
Tính theo lý thuyết thì số phép gán là *3(n - 1)* và số phép so sánh là *n*.

### Bảng kết quả khi chạy code


| Input| Output| Count-Assign | Count-Compare |
| :-------------: |:-------------:| :-----:| :----: |
| 3 | 2 | 6| 3 |
| 6 | 8 | 15 | 6 |
| 9 | 34 | 24| 9 |
| 12| 144 | 33| 12|
| 15| 610| 42| 15|
| 18| 2584| 51| 18|
| 21| 10946| 60| 21|
| 24| 46368| 69| 24|
| 27| 196418| 78| 27|
| 30| 832040| 87| 30|

*Kết quả được lưu lại trong file Report_Fibonacci_KhongDeQuy.csv*

## Kết luận

Từ những phân tích về độ phứt tạp và bảng số liệu trên, ta có thể thấy thuật toán *không đệ quy* sử dụng ít phép tính toán hơn thuật toán *đệ quy* rất nhiều lần nên nó sẽ chạy nhanh hơn nhiều lần.
