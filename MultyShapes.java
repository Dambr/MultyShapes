import java.util.ArrayList;

public class MultyShapes {

    static final int N = 4;

    static int getSum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++)
            result += array[i] * Math.pow(-1, i);
        return result;
    }

    static int decToK(int dec) {
        int[] result = new int[N];
        int idx = 0;
        while (dec > 0) {
            int a = dec % N;
            dec /= N;
            result[idx] = a;
            idx++;
        }
        return getSum(result);
    }

    static ArrayList modifyList(ArrayList arrayList, int number, String value){
        ArrayList result = arrayList;
        String bar = "";
        for (int i = 0; i < number; i++)
            bar += "\t";
        result.add("\n" + bar + value);
        return result;
    }

    public static void main(String[] args) {
        ArrayList numbers = new ArrayList();
        for (int i = 0; i < Math.pow(N, N); i++)
            numbers.add(String.valueOf(decToK(i)).length() == 1
                            ? " " + String.valueOf(decToK(i))
                            : String.valueOf(decToK(i))
                    );
        for (int k = 0; k < N - 1; k++) {
            ArrayList result = new ArrayList();
            int idx = 0;
            for (int i = 0; i < Math.pow(N, N - 1 - k); i++) {
                ArrayList res = new ArrayList();
                for (int j = 0; j < N; j++) {
                    res.add(numbers.get(idx));
                    if (j == N - 1 && k != 0)
                        res = modifyList(res, N - k - 1, "");
                    idx++;
                }
                result = (k == 0)
                        ? modifyList(result, N - 1, String.valueOf(res))
                        : modifyList(result, N - k - 1, String.valueOf(res));
            }
            numbers = result;
        }
        String answer = String.valueOf(numbers);
        System.out.println(answer.substring(0, answer.length() - 1) + "\n]");
    }
}