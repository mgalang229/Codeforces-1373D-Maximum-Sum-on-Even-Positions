import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class AuthorSol {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			long[] a = fs.readLongArray(n);
			long[] changes = new long[n/2];
			int index = 0;
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0 && i + 1 < n) {
					changes[index++] = a[i+1] - a[i];
				}
			}
			long max = kadane(changes);
			changes = new long[n/2];
			index = 0;
			for (int i = 0; i < n; i++) {
				if (i % 2 == 1 && i + 1 < n) {
					changes[index++] = a[i] - a[i+1];
				}
			}
			max = Math.max(max, kadane(changes));
			if (max < 0) {
				max = 0;
			}
			for (int i = 0; i < n; i += 2) {
				max += a[i];
			}
			System.out.println(max);
		}
		out.close();
	}
	
	static long kadane(long[] changes) {
		long best = 0, sum = 0;
		for (int k = 0; k < changes.length; k++) {
			sum = Math.max(changes[k] + sum, changes[k]);
			best = Math.max(best, sum);
		}
		return best;
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
