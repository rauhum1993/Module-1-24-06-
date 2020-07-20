package thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_chen;

public class ArrangeInsertion1 {
    static int[] list={4,1,2,6,9,3,12,8};
    public static void main(String[] args) {
        arrangeInsertion(list);
        System.out.println("Array after sort: ");
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void arrangeInsertion (int[] list){

        for (int i=1;i<list.length;i++){
            System.out.println("Run the loop "+ i+ " : ");
            int min = list[i];
            System.out.println( "Temporary minimum value is : "+min);
            int k;


            for(k=i-1; k>=0&& list[k]>min;k--){
                System.out.println(" compare "+ k + " with " +min);
                list[k+1]=list[k];
            }




            list[k+1]=min;
            System.out.println("Array has Index "+(k+1)+" and value is: "+min);
            System.out.println("-------------------"+"\n");

        }
    }

}