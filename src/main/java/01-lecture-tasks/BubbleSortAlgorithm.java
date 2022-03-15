class BubbleSortAlgorithm {
	
	public static void main(String args[]) {
		
		int intsArray[]= new int[20];
		
		int j, temp, i;
		
		for(i=0 ;i<args.length; i++) {
			intsArray[i]=Integer.valueOf(args[i]);
		}
		
		for(i= 0; i<args.length; i++){
			for(j= 0; j<args.length-i - 1; j++) {
				if(intsArray[j]>intsArray[j + 1]) {
					temp=intsArray[j];
					intsArray[j]=intsArray[j + 1];
					intsArray[j + 1]=temp;
				}
			}
		}
		
		System.out.println("Sorted elements: ");
		for(i=0; i<args.length; i++) {
			System.out.print(intsArray[i] + " ");
		}
	}
}