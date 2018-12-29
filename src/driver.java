
public class driver {
	public static void main(String[]args){
		Comparable[]array=new Comparable[50];
		for(int i=0;i<array.length;i++){
			array[i]=(int)(Math.random()*100+0);
		}
		System.out.println("This is array with random number:");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.print("\n");
		MinHeap mp=new MinHeap(array);
		System.out.println("put this array in Minheap: ");
		for(int i=0;i<array.length;i++){
			System.out.print(mp.heap[i]+",");
		}
		
		System.out.println(" \n the 5th smallest is: "+		mp.getKthSmallest(array,5));
		System.out.println(" \n the 9th smallest is: "+		mp.getKthSmallest(array,9));


		
		
	}
}