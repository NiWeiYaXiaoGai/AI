package main.java.ChinaHadoop_AI_Offer.UnionFind.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/qq_41593380/article/details/81146850
 * https://www.cnblogs.com/MrSaver/p/9607552.html
 * 并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。有一个联合-查找算法（union-find algorithm）
 * 定义了两个用于此数据结构的操作：
 * (1)Find：确定元素属于哪一个子集。这个确定方法就是不断向上查找找到它的根节点，它可以被用来确定两个元素是否属于同一子集。
 * (2)Union：将两个子集合并成同一个集合。
 * (3)路径压缩
 * 解题思路：遍历数组，将元素添加至散列表，每次添加元素时查找散列表中是否包含相邻元素，
 * 然后利用该数组的并查集，使连续相邻的元素合并成为一个子集，最后通过并查集查找集合最大的size
 */
public class LongestConsecutiveSequence {
    /**
     * https://blog.csdn.net/qq_41593380/article/details/81146850
     * https://www.cnblogs.com/MrSaver/p/9607552.html
     * 并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。有一个联合-查找算法（union-find algorithm）
     * 定义了两个用于此数据结构的操作：
     * (1)Find：确定元素属于哪一个子集。这个确定方法就是不断向上查找找到它的根节点，它可以被用来确定两个元素是否属于同一子集。
     * (2)Union：将两个子集合并成同一个集合。
     * (3)路径压缩
     * 解题思路：遍历数组，将元素添加至散列表，每次添加元素时查找散列表中是否包含相邻元素，
     * 然后利用该数组的并查集，使连续相邻的元素合并成为一个子集，最后通过并查集查找集合最大的size
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    private class UnionSearch{
        private int[] parents;
        public UnionSearch(int n) {
            parents=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }

        public int findRoot(int index){
            int son=index;
            while(parents[son]!=son){
                son=parents[son];
            }
            int parent=son;
            //路径压缩算法，降低并查集树的高度，使其只有两层
            int temp;
            while(parents[index]!=parent){
                temp=parents[index];
                parents[index]=parent;
                index=temp;
            }
            return parent;
        }

        public void union(int son1,int son2){
            int root1=findRoot(son1);
            int root2=findRoot(son2);
            if(root1!=root2){
                parents[root1]=root2;
            }
        }
        public int maxCollectionSize(){
            int[] count=new int[parents.length];
            int max=0;
            int val;
            for(int i=0;i<parents.length;i++){
                val=++count[findRoot(i)];
                if(val>max){
                    max=val;
                }
            }
            return max;
        }
    }
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Map<Integer,Integer> map=new HashMap<>();
        UnionSearch unionSearch=new UnionSearch(nums.length);
        //nums具体的数字是多少不重要，重要的是将哪些位置上的数字合并成一个集合
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]-1)){
                unionSearch.union(i,map.get(nums[i]-1));
            }
            if(map.containsKey(nums[i]+1)){
                unionSearch.union(i,map.get(nums[i]+1));
            }
        }
        return unionSearch.maxCollectionSize();
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence test=new LongestConsecutiveSequence();
        int[] arr={100,4,200,1,3,2};
        test.longestConsecutive(arr);
    }
}
