import java.util.Scanner;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        merge(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void merge(int[] nums, int left, int right) {
        if(left >= right)   return;
        int mid = (left + right) >> 1;
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        mergeSort(nums, left, mid, right);
    }

    /**
     *  left...mid, mid + 1...right 两个子数组分别有序
     */
    private static void mergeSort(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftNums = new int[n1];
        int[] rightNums = new int[n2];
        for(int i = 0; i < n1; i++)  leftNums[i] = nums[left + i];
        for(int i = 0; i < n2; i++)  rightNums[i] = nums[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(leftNums[i] <= rightNums[j]) {
                nums[k++] = leftNums[i++];
            } else {
                nums[k++] = rightNums[j++];
            }
        }
        while(i < n1)   nums[k++] = leftNums[i++];
        while(j < n2)   nums[k++] = rightNums[j++];
    }

}

