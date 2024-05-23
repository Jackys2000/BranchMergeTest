import java.util.Scanner;

/**
 * 快速排序
 * O(NlogN)、不稳定 5 2 7 7 1 1
 */
public class FastSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        fastSort(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void fastSort(int[] nums, int start, int end) {
        // 1. 每组元素数量为1，直接返回
        // 关键点：>=
        if(start >= end)    return;
        // 2. 定义中心轴
        int pivot = nums[start];
        int left = start, right = end;
        while(left < right) {
            // 3. 从右侧开始遍历
            while(left < right && nums[right] >= pivot)   right--;
            // 关键点：此时证明 nums[right] < pivot
            if(left < right) {
                nums[left] = nums[right];
                // 关键点：这里是 left++
                left++;
            }
            // 4. 从左侧开始遍历
            while(left < right && nums[left] <= pivot)   left++;
            // 关键点：此时证明 nums[left] > pivot
            if(left < right) {
                nums[right] = nums[left];
                // 关键点：这里是 right--
                right--;
            }
        }
        // 5. 中心轴归为
        nums[left] = pivot;
        // 6. 递归
        fastSort(nums, start, left - 1);
        fastSort(nums, left + 1, end);
    }
}
