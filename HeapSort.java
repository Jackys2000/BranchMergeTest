import java.util.Scanner;

/**
 * 堆排序
 * O(NlogN)、不稳定
 */
public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 创建堆
        // 关键点：一定要注意从最后一个叶子节点的父节点开始维护堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        // 堆排序
        for (int i = 1; i < n; i++) {
            // 将堆顶大元素与最后一个叶子节点的元素交换
            swap(nums, n - i, 0);
            // 维护堆
            heapify(nums, n - i, 0);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 维护堆
     * @param nums：待排序的数组
     * @param n：数组的长度
     * @param i：待维护结点的位置
     */
    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        // 关键点：一定要注意 left < n 判断条件在前
        if(left < n && nums[largest] < nums[left] )  largest = left;
        if(right < n && nums[largest] < nums[right])  largest = right;
        if(largest != i){
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }
    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
