package lc_att;

public class Contest1 {

	// public int maxDistance(int[][] arrays) {
	//
	// if (arrays.length == 0) {
	// return 0;
	// }
	// int tempmax = arrays[0][0];
	// int tempmin =arrays[0][arrays[0].length-1];
	// int max = arrays[0][0];
	// int min =arrays[0][arrays[0].length-1];
	// int store = 0;
	// int store1 = 0;
	// int store2 = 0;
	//// store = max - min;
	// for (int i = 0; i < arrays.length; i++) {
	// // System.out.println("qichu= "+arrays[i][0]);
	//
	// tempmin = arrays[i][0];
	// tempmax = arrays[i][arrays[i].length - 1];
	//
	// store1 = max - tempmin;
	// System.out.println("store1="+store1);
	// store2 = tempmax - min;
	// System.out.println("store2="+store1);
	//
	// if (store1 > store && store2 > store) {
	// if (store1 < store2) {
	// max = tempmax;
	// } else if(store1 > store2) {
	// min = tempmin;
	// }else if(store1 == store2) {
	// min = tempmin;
	// }
	// } else if (store1 < store && store < store) {
	//
	// } else if (store1 > store && store2 < store) {
	// min = tempmin;
	// } else if (store1 < store && store2 > store) {
	// max = tempmax;
	// }
	//
	// // if(arrays[i][arrays[i].length-1]>max){
	// // max=
	// // }
	//
	// // }
	// System.out.println("max= " + max);
	// System.out.println("min= " + min);
	// store = max - min;
	//
	// }
	// return max - min;
	// }
//	public int maxDistance(int[][] arrays) {
//		Integer min = null;
//		Integer max = null;
//		int result = 0;
//		for (int i = 0; i < arrays.length; i++) {
//			System.out.println("min= "+min);
//			if (arrays[i].length == 0)
//				continue;
//			int currMin = arrays[i][0];
//			int currMax = arrays[i][arrays[i].length - 1];
//			if (min != null) {
//				result = Math.max(result, Math.abs(min - currMax));
//				result = Math.max(result, Math.abs(max - currMin));
//				min = Math.min(min, currMin);
//				max = Math.max(max, currMax);
//			} else {
//				min = currMin;
//				max = currMax;
//			}
//		}
//		return result;
//	}
	
	
	
//	public int maxDistance(int[][] arrays) {
//		if (arrays.length == 0) {
//			return 0;
//		}
//		int tempmax = arrays[0][arrays[0].length-1];
//		int tempmin =arrays[0][0];
//		int max = arrays[0][arrays[0].length-1];
//		int min =arrays[0][0];
//		int store = 0;
//		int store1 = 0;
//		int store2 = 0;
////		store = max - min;
//		for (int i = 0; i < arrays.length; i++) {
//			// System.out.println("qichu= "+arrays[i][0]);
//
//			tempmin = arrays[i][0];
//			tempmax = arrays[i][arrays[i].length - 1];
//
//			store1 = max - tempmin;
//
//			store2 = tempmax - min;
//
//			if (store1 > store && store2 > store) {
//				if (store1 <= store2) {
//					max = tempmax;
//				} else {
//					min = tempmin;
//				}
//			} else if (store1 < store && store < store) {
//
//			} else if (store1 > store && store2 < store) {
//				min = tempmin;
//			} else if (store1 < store && store2 > store) {
//				max = tempmax;
//			}
//
//			// if(arrays[i][arrays[i].length-1]>max){
//			// max=
//			// }
//
//			// }
//			System.out.println("max= " + max);
//			System.out.println("min= " + min);
//			store = max - min;
//
//		}
//		return max - min;
//	}
	
	
	
	

	public int maxDistance(int[][] arrays) {
		
		Integer max=null;
		Integer min=null;
		int diff=0;
		for(int i=0;i<arrays.length;i++){
			int maxtemp=arrays[i][arrays[i].length-1];
			int mintemp=arrays[i][0];
			
			if(max!=null&&min!=null){
				diff=Math.max(diff, Math.abs(max-mintemp));
				diff=Math.max(diff, Math.abs(maxtemp-min));
				max=Math.max(max, maxtemp);
				min=Math.min(min, mintemp);
			}else{
				max=arrays[i][arrays[i].length-1];
				min=arrays[i][0];
			}
		}
		return diff;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][]={{0,7},{1,5}};
//		int input[][] = { { 1, 4 }, { 0, 5 }, { -1, 1 } };
		// int input[][] = { { 1, 2, 3 }, { 4, 5 }, { 1, 2, 3 } };
		// int input[][]={{1},{1}};
		Contest1 contest = new Contest1();
		int res = contest.maxDistance(input);
		System.out.println("res= " + res);
	}

}
