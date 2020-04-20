import java.io.FileWriter;
import java.io.IOException;

class Test {
    private static String fileName_DeQuy = "Report_Fibonacci_DeQuy.csv";
    private static String fileName_KhongDeQuy = "Report_Fibonacci_KhongDeQuy.csv";
    private static final String strChuyenCot = ",";
    private static final String strXuongDong = "\n";
    private static final String strFibonacci_DeQuy = "Fibonacci-DeQuy\n\n";
    private static final String strFibonacci_KhongDeQuy = "Fibonacci-KhongDeQuy\n\n";
    private static final String strTenCot = "Input,Output,Count_Assign,Count_Compare\n";
    private static final int[] input = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
    private static final int SL = 10;
    private static FileWriter fileWriter_DeQuy = null;
    private static FileWriter fileWriter_KhongDeQuy = null;

    public static String toString(int[] arr) {
        String result = "";
        try {
            for (int i = 0; i < arr.length; i++)
                result += String.valueOf(arr[i]) + strChuyenCot;
        } 
        catch (Exception e) {
        }

        result += strXuongDong;
        return result;
    }

    public static void InitFile() {
        try {
            fileWriter_DeQuy = new FileWriter(fileName_DeQuy);
            fileWriter_DeQuy.append(strFibonacci_DeQuy);
            fileWriter_DeQuy.append(strTenCot);
            fileWriter_KhongDeQuy = new FileWriter(fileName_KhongDeQuy);
            fileWriter_KhongDeQuy.append(strFibonacci_KhongDeQuy);
            fileWriter_KhongDeQuy.append(strTenCot);
        } catch (Exception e) {
            System.out.println("Không thể mở tệp");
            return;
        }
    }

    public static void main(String[] args) {
        InitFile();
        if (fileWriter_DeQuy != null && fileName_KhongDeQuy != null)
        {
            for (int i = 0; i < SL; i++)
                WriteResultToFile(input[i]);
            CloseFile();
        }
    }

    private static void CloseFile() {
        try{
            fileWriter_DeQuy.flush();
            fileWriter_DeQuy.close();
            fileWriter_KhongDeQuy.flush();
            fileWriter_KhongDeQuy.close();
        }
        catch (Exception e){
        }
    }

    private static void WriteResultToFile(int n) {
        Fibonacci fibonacci_DeQuy = new Fibonacci_DeQuy();
        Fibonacci fibonacci_KhongDeQuy = new Fibonacci_KhongDeQuy();
        int []result_DeQuy = fibonacci_DeQuy.Execute(n);
        int []result_KhongDeQuy = fibonacci_KhongDeQuy.Execute(n);
        try
        {
            fileWriter_DeQuy.append(toString(result_DeQuy));
            fileWriter_KhongDeQuy.append(toString(result_KhongDeQuy));
        }
        catch (Exception e){
        }
    }
}