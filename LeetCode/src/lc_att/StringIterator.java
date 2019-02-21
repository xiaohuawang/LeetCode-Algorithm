package lc_att;

import java.util.LinkedList;
import java.util.Queue;

public class StringIterator {

	Queue<int[]> queue = new LinkedList<>();

	public StringIterator(String compressedString) {

		int j=0;
		for (int i = 0; i < compressedString.length(); i++) {
			//string[i] shi zimu
//			System.out.println("i= "+i);
			if (compressedString.charAt(i) >= 'A' && compressedString.charAt(i) <= 'z') {
				j=i+1;
//				System.out.println("j= "+j);
				//string[j] shi shuzi
				while(j<compressedString.length()&&compressedString.charAt(j)<'A'){
					j++;
				}
//				System.out.println("j= "+j);
//				System.out.println("substring= "+(compressedString.substring(i+1, j)));
				
				int temp[]={compressedString.charAt(i)-'a',Integer.valueOf(compressedString.substring(i+1, j))};
				queue.offer(temp);
				i=j-1;
			}
		}
	}
    
    public char next() {
    	if(queue.size()==0)
    		return ' ';
    	int temp[]=queue.peek();
    	if(temp[1]==1){
    		queue.poll();
    	}
    	else{
    		temp[1]--;
    	}
    	return (char)('a'+temp[0]);
    }
    
    public boolean hasNext() {
        if(queue.size()==0)
        	return false;
        else
        	return true;
    }
	
	public void check(){
		System.out.println("queue.size= "+queue.size());
		System.out.println("queue.peek= "+queue.peek()[0]);
		System.out.println();
	}

	public static void main(String[] args) {
		
		StringIterator si=new StringIterator("l3e2t1C1o1d1e1");
		
//		System.out.println(si.next());
		for (int i = 0; i < 11; i++) {
			System.out.println(si.next());
			System.out.println("queue.size=" + si.queue.size());
		}
		System.out.println(si.hasNext());
	}
}
