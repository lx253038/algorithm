import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LX
 * @Date 2019/12/24 19:32
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(strLength("aabaab!bb"));
        System.out.println(threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

    private static int strLength(String str) {
        String s1 = "";
        int length = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (s1.contains(String.valueOf(c))) {

                s1 = s1.substring(s1.indexOf(String.valueOf(c)) + 1);
            }
            s1 += c;
            if (s1.length() > length) {
                length = s1.length();
            }
        }
        return length;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    list.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > sum) {
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                }
            }


        }
        return list;
    }


}
