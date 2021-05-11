import treeProblem.TreeNode;

import java.util.*;


public class Main {
    public static void main(String args[])
    {
       int [][] list={{1,3},{2,6},{8,10},{15,18}};
       int [][] res=merge(list);
     //   int mid=(int)Math.ceil(((double) 0+(double)3)/2.0);
     //   System.out.println(mid);
      // System.out.println(judgeSquareSum(10));
        int[] nums={30000,500,100,30000,100,30000,100};
        String str="3+2*2";
        System.out.println(calculate(str));

    }

    public static int calculate(String s) {
        Deque<Integer> stack=new LinkedList<>();
       // char preSign=' ';
        int num=0;
        int n=s.length();
        for(int i=0;i<n;i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                System.out.print(num +" ");
            }
            if (!Character.isDigit(s.charAt(i)) ) {
                System.out.println(s.charAt(i)+"abc");
                switch (s.charAt(i)) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;

                }
            }

            num = 0;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }


       return ans;

    }

    /*
     137. 只出现一次的数字 II
     给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     https://leetcode-cn.com/problems/single-number-ii/
     */
    public static int singleNumber(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int res=-1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> e:map.entrySet()
             ) {
            if(e.getValue()!=3)
            {
               res= e.getKey();
               System.out.println(e.getKey()+"--"+e.getValue()+" ");
            }

        }
        return res;
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
