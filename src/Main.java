import java.util.*;


public class Main {
    public static void main(String args[])
    {
       int [][] list={{1,3},{2,6},{8,10},{15,18}};
       int [][] res=merge(list);
     //   int mid=(int)Math.ceil(((double) 0+(double)3)/2.0);
     //   System.out.println(mid);
       System.out.println(judgeSquareSum(10));

    }
    /* a^2+b^2=c* leetcode 633 */
    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;


    }
    /*合并区间 [1,3],[2,6],[2,4]*/
    public  static  int[][] merge(int nums[][])
    {
        if(nums.length<2)
            return nums;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1][0]<=nums[i][1]) {
                nums[i+1][0] = nums[i][0];

            }
            else
            {
                list.add(new int[]{nums[i][0],nums[i][1]});
                if(i==nums.length-2) {
                    list.add(new int[]{nums[i + 1][0], nums[i + 1][1]});
                    continue;
                }
            }
        }
        int[][] res= list.toArray(new int[list.size()][2]);
        return  res;

    }

    /*回溯法全排序*/
    public static  ArrayList<ArrayList<Integer>> findParh(int[] nums)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean[] isVisited=new boolean[nums.length];
        dfs(nums,isVisited,new ArrayList<>(),ans);
        return ans;

    }

    /*回溯法全排序*/
    public static  void  dfs(int []nums,boolean[] isVisited,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans)
    {
        if(path.size()==nums.length)
        {
            ans.add(new ArrayList<>(path));
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!isVisited[i])
            {
                isVisited[i]=true;
                path.add(nums[i]);
                dfs(nums,isVisited,path,ans);
                path.remove(path.size()-1);
                isVisited[i]=false;
            }
        }
    }
   public static  void dfs1(int[] nums,boolean[] isVisited,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans)
   {
       if(path.size()==nums.length)
       {
           ans.add(new ArrayList<>(path));
       }
       for(int i=0;i<nums.length;i++)
       {
           if(!isVisited[i])
           {
               path.add(nums[i]);
               isVisited[i]=true;
               dfs1(nums,isVisited,path,ans);
               path.remove(path.size()-1);
               isVisited[i]=false;
           }
       }

   }
    public static TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return root;
        ArrayList<Integer> list=new ArrayList<>();
        inOrder(root,list);
        TreeNode t=new TreeNode(-1);
        TreeNode next=t;
        for(int i=0;i<list.size();i++)
        {
            next.right=new TreeNode(list.get(i));
            next=next.right;
            System.out.println(next.val+" ");
        }
        return t;

    }
    public static  void inOrder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null) {
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public static int clumsy(int N) {
        Deque<Integer> stack=new LinkedList<Integer>();
        stack.push(N);
        int temp=0;
        while(N>0)
        {
            if(temp%4==0)
                stack.push(stack.pop()*N);
            else if(temp%4==1)
                stack.push(stack.pop()/N);
            else if(temp%4==2)
                stack.push(N);
            else
                stack.push(--N);
            temp++;
            N--;
        }
        int sum=0;
        while (!stack.isEmpty())
        {
            sum+=stack.pop();
        }
        return sum;
    }
}
