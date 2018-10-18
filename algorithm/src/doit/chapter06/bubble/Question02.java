package doit.chapter06.bubble;


// 비교, 교환 과정 자세히 출력(교환 수행하면 '+', 수행하지 않으면 '-'
public class Question02 {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        bubbleSortPass(arr, arr.length);
    }

    static void bubbleSortPass(int[] arr, int len) {
        int swapCount = 0;
        int compareCount = 0;
        for (int j = 0; j < len - 1; j++) {
            System.out.println("패스"+ (j+1) + ":");
            for (int i = len - 1; i > j; i--) {
                compareCount++;
                if (arr[i - 1] > arr[i]) {
                    swapInfo(arr, i - 1);
                    BubbleSort.swap(arr, i - 1, i);
                    swapCount++;
                } else
                    nonSwapInfo(arr, i - 1);;
            }
        }
        System.out.println("비교를 " + compareCount + "회 했습니다.");
        System.out.println("교환을 " + swapCount + "회 했습니다.");
    }

    static void swapInfo(int[] arr, int flag) {
        for (int n = 0; n < arr.length; n++) {
            if (n == flag)
                System.out.print(arr[n] + "+");
            else
                System.out.print(arr[n] + " ");
        }
        System.out.println();
    }

    static void nonSwapInfo(int[] arr, int flag) {
        for (int n = 0; n < arr.length; n++) {
            if (n == flag)
                System.out.print(arr[n] + "-");
            else
                System.out.print(arr[n] + " ");
        }
        System.out.println();
    }

    static void endPass(int[] arr) {
        for (int n = 0; n < arr.length; n++)
            System.out.print(arr[n] + " ");
        System.out.println();
    }
}

/*
    	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 단순교환정렬
	static void bubbleSort(int[] a, int n) {
		int ccnt = 0; // 비교횟수
		int scnt = 0; // 교환횟수

		for (int i = 0; i < n - 1; i++) {
			System.out.printf("패스%d：\n", i + 1);
			for (int j = n - 1; j > i; j--) {
				for (int m = 0; m < n - 1; m++)
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
				System.out.printf("%3d\n", a[n - 1]);

				ccnt++;
				if (a[j - 1] > a[j]) {
					scnt++;
					swap(a, j - 1, j);
				}
			}
			for (int m = 0; m < n; m++)
				System.out.printf("%3d  ", a[m]);
			System.out.println();
		}
		System.out.println("비교를 " + ccnt + "회 했습니다.");
		System.out.println("교환를 " + scnt + "회 했습니다.");
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순교환정렬  (버블정렬)");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx); // 배열 x를 단순교환정렬
	}
}
*/