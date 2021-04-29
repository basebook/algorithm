import java.util.Arrays;

public class binSearch {
    public static void main(String args[])
    {
      int weights[] = {1,2,3,4,5,6,7,8,9,10},D=5;
      System.out.println(shipWithinDays(weights,D));
    }
    public static int shipWithinDays(int[] weights, int D) {
        if(weights.length<1)
              return 0;
        int l=weights[weights.length-1];
        int r= Arrays.stream(weights).sum();
        while (l<r)
        {
            int mid=(l+r)>>1;
            if(vertify(weights,D,mid))
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;

    }
    public static boolean vertify(int weights[],int D,int H)
    {
        int sum=0;
        int count=1;
        for(int i=0;i<weights.length;i++)
        {

                sum=sum+weights[i];

           if(H<sum)
            {
                sum=weights[i];
                count++;
            }
        }
        if(count>D)
            return false;
        return true;
    }
}
