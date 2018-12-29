public final class MinHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{   public T[] heap;  
public T[]temp;
private int lastIndex; 
// Index of last entry   
private static final int DEFAULT_CAPACITY = 25;  
private static final int MAX_CAPACITY = 10000;


public MinHeap(T[]entry){
	this(entry.length);
	lastIndex=entry.length;
	for(int i=0;i<entry.length;i++){
		heap[i+1]=entry[i];
	}
	
	Comparable[]temp = new Comparable[lastIndex];
	for(int i=0;i<entry.length;i++){
		temp[i]=heap[i];
	}
	for(int rootIndex =lastIndex/2;rootIndex>0;rootIndex--){
		reheap(rootIndex);
	}
	
}
   public MinHeap() { 
	   this(DEFAULT_CAPACITY);
	   } 
   public MinHeap(int initialCapacity)
   {       if (initialCapacity < DEFAULT_CAPACITY)      
	   initialCapacity = DEFAULT_CAPACITY;      
   else      
	   checkCapacity(initialCapacity);    
         
   T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];   
   heap = tempHeap;    
   lastIndex = 0; 
   }
private boolean checkCapacity(int initialCapacity) {
	if (initialCapacity>MAX_CAPACITY){
	return false;
	}
	return true;
	
}
public void extractMin(){

		heap[1]=heap[lastIndex-1];
		heap[lastIndex-1]=null;
		lastIndex--;
		reheap(1);
	
	
}
public int getKthSmallest(Comparable[]x ,int n){
	MinHeap y=new MinHeap(x);
	for(int i=1;i<n;i++){
y.removeMin(); 
		   
	}
	int re=(int)y.heap[1];
	
	
	return re;
}




@Override
public void add(T newEntry) {
	int newIndex = lastIndex + 1; // find the first open index in the heap  
	int parentIndex = newIndex / 2; 
	while( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0)  
	{       heap[newIndex] = heap[parentIndex];    
	newIndex = parentIndex; // update newIndex to be the newly empty index       
	parentIndex = newIndex / 2; // find the parent of newIndex   
	} 
	heap[newIndex] = newEntry;
	lastIndex++;  
	ensureCapacity(); 	
}
private void ensureCapacity() {
	// TODO Auto-generated method stub
	
}
@Override
public T removeMin() {
	 T root = null;
	   if(!isEmpty())
	   {       root = heap[1];     
	   heap[1] = heap[lastIndex];   
	   lastIndex--;      
	   reheap(1); 
	   }  
	   return root; 
}
@Override
public T getMin() {
	
	return heap[1];
}
@Override
public boolean isEmpty() {

	return (heap[1]==null);
}
@Override
public int getSize() {

	return lastIndex;
}
@Override
public void clear() {
	for(int i=0;i<heap.length;i++){
		heap[i]=null;
	}
	
} 
private void reheap(int rootIndex) { 
    boolean done = false;  
    T orphan = heap[rootIndex]; 
    int leftChildIndex = 2 * rootIndex; 
while(!done && (leftChildIndex <= lastIndex))  
{    
	int largerChildIndex = leftChildIndex; // Assume larger  
    int rightChildIndex = 2 * rootIndex + 1;
if ( (rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) <0)  
{          
	largerChildIndex = rightChildIndex; 
}
if(orphan.compareTo(heap[largerChildIndex]) >0)       
{     
	// orphan is less than the largest child of the current node        
	heap[rootIndex] = heap[largerChildIndex];      
	rootIndex = largerChildIndex;  
	leftChildIndex = 2 * rootIndex; 
	}     
else   
	done = true;  
}
heap[rootIndex] = orphan; 
}




}