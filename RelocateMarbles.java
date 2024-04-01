import java.util.*;

public class RelocateMarbles {
    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int p = 0;
        List<Integer> temp = new ArrayList<>();

        while(p<moveFrom.length){
            for(int i=0; i<nums.length; i++){
                if(nums[i] > moveFrom[p]){
                    break;
                }
                if(nums[i] == moveFrom[p]){
                    nums[i] = moveTo[p];
                }
            }
            p++;
            Arrays.sort(nums);
        }
        for(int t=0; t<nums.length; t++){
            if (!temp.contains(nums[t])){
                temp.add(nums[t]);
            }
        }
        return temp;
    }

    public static List<Integer> relocateMarbles1(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> temp = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            temp.add(nums[i]);
        }

        for(int i=0; i<moveTo.length; i++){
            temp.remove(moveFrom[i]);
            temp.add(moveTo[i]);
        }
        List<Integer> out = new ArrayList<>(temp);

        Collections.sort(out);
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,8,15};
        int[] moveFrom = {5,7,8,9};
        int[] moveTo = {9,15,2,7};
        System.out.println(relocateMarbles1(nums,moveFrom, moveTo));
    }
}
