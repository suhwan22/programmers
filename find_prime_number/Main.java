import java.util.*;

class Main {
    static Set<Integer> pn = new HashSet<>();
    static char carr[];
    static StringBuilder temp = new StringBuilder();
    static boolean sel[];

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String numbers = sc.next();
		int ret = solution(numbers);
		System.out.println(ret);
	}
    
    public static int solution(String numbers) {
        carr = numbers.toCharArray();
        sel = new boolean[numbers.length()];

        for (int i = 0; i < carr.length; i++) {
            temp.append(carr[i]);
            sel[i] = true;
            isPrime(Integer.parseInt(temp.toString()));
            dfs(i);
            temp.deleteCharAt(temp.length() - 1);
            sel[i] = false;
        }
        return pn.size();
    }
    
    private static boolean isPrime(int n) {
        // System.out.println("isPrime: " + n);
        if (n == 0 || n == 1)
            return false;
        if (n == 2) {
            pn.add(n);
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        pn.add(n);
        return true;
    }
    
    private static void dfs(int idx) {
        for (int i = 0; i < carr.length; i++) {
            if (sel[i])
                continue;
            sel[i] = true;
            temp.append(carr[i]);
            isPrime(Integer.parseInt(temp.toString()));
            dfs(i);
            sel[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
