package task3;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
        // System.out.println("input data:");
        // for(int i :a)
        //     System.out.println(i);
    }

    private int partition(int low,int high)
    {
        int pivot = a[high];
        int i = low - 1;
        for(int j = low;j < high;j++){
            if(a[j] < pivot){
                i++;
                swap(i,j);
            }
        }
        i++;
        swap(i,high);
        return i;
    }

    @Override
    public void sort() {
        quickSort(0, a.length - 1);
        // System.out.println("sorted result:");
        // for(int i :a)
        //     System.out.println(i);
    }

    void quickSort(int left,int right)
    {
        if (left < right)
        {
            int pivotpos = partition(left, right);
            quickSort(left, pivotpos - 1);
            quickSort(pivotpos + 1, right);
        }
    }

    private void swap(int i, int j) {
        int temp;
        temp = this.a[i];
        this.a[i] = this.a[j];
        this.a[j] = temp;
        plan += "" + i + "<->" + j + "\n";
        // System.out.println("swap"+a[i]+" and "+a[j]);
    }

    private String plan = "";

    @Override
    public String getPlan() {
        return this.plan;
    }

}