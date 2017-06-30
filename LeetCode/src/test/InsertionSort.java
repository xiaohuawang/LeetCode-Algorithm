package test;

public class InsertionSort {

	//every time, pick one number, insert into the sorted array.
	public static int[] doInsertionSort(int[] input){
		
		for(int i=1;i<input.length;i++){
			for(int j=i-1;j>=0;j--){
				if(input[i]<input[j]){
					int temp=input[i];
					input[i]=input[j];
					input[j]=temp;
					i--;
				}
			}
			
		}
	
//		int j=input.length-1;
//		
//		for(int i=input.length-1;i>=0;i--){
////			int insert=input[j];
//			if(input[j]<input[i]){
//				int temp=input[i];
//				input[i]=input[j];
//				input[j]=temp;
//				j--;
////				input[j]=insert;
//			}
//			System.out.println("input[j]= "+input[j]);
//		}
		return input;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input={2,10,34,42,88,7};
		int[] input = {10,34,2,56,7,67,88,42};
		int res[]=doInsertionSort(input);
		for(int i:res){
			System.out.print(i+" ");
		}
	}

}
