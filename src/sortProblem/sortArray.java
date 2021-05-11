package sortProblem;

public class sortArray {
    public static void main(String args[])
    {
        int []arrays={1,4,2,7,3,6,5};
        insertSort(arrays);
        for(int i=0;i<arrays.length;i++)
        {
            System.out.print(arrays[i]+" ");
        }
    }
    /*快速排序*/
    public static  void quickSort(int[] arrays)
    {

    }

    /*冒泡排序*/
    public static void bubbleSort(int[] arrays) {
        for (int i = arrays.length - 1; i >= 0; i--) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if (arrays[index] < arrays[j])
                    index = j;
            }
            int tmp = arrays[i];
            arrays[i] = arrays[index];
            arrays[index] = tmp;
        }
    }
    /*插入排序*/
    public static  void insertSort(int[] arrays)
    {
        if(arrays.length<2)
            return;
        for(int i=1;i<arrays.length-1;i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(arrays[j]<arrays[j-1])
                {
                    int tmp=arrays[j];
                    arrays[j]=arrays[j-1];
                    arrays[j-1]=tmp;
                    continue;
                }
            }
        }
    }
}