import java.util.*;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i< height.length; i++) {
            for (int j = i+1; j<height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                if (area > max)
                    max = area;
            }
        }

        return max;
    }

    public List<Bar> maxArea2(int[] height) {

        List<Bar> barList = new ArrayList<>();

        for (int i=0; i< height.length; i++) {
            barList.add(new Bar(i,height[i]));
        }
        Collections.sort(barList);
        return List.of(barList.get(0), barList.get(height.length -1));
    }

    public int maxArea3(int[] height) {
        int leftIndex = height.length / 2 -1;
        int rightIndex = leftIndex +1;
        int max = 0;
        int len = height.length;
        if (len < 2)
            return 0;

        while (true) {
            int area = Math.min(height[rightIndex], height[leftIndex]) * (rightIndex - leftIndex);
            if (area > max)
                max = area;
            if (height[rightIndex] <= height[leftIndex] && rightIndex < len-1)
                rightIndex++;
            else if (height[leftIndex] < height[rightIndex] && leftIndex > 0)
                leftIndex--;
            else {
                if (leftIndex > 0)
                    leftIndex--;
                else if (rightIndex < len-1)
                    rightIndex++;
                else break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/container-with-most-water/description/
        ContainerWithMostWater sinif = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5};
        System.out.println(sinif.maxArea3(height));
    }
}
class Bar implements Comparable<Bar>{
    private final int index;
    private final int height;

    Bar(int index, int height) {
        this.index = index;
        this.height = height;
    }
    public int getIndex() {
        return index;
    }
    public int getHeight() {
        return height;
    }
    @Override
    public int compareTo(Bar o) {
        return Math.min(this.height, o.getHeight()) * Math.abs(this.index - o.getIndex());
    }
}