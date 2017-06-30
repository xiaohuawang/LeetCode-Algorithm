package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class LCContest2 {

	public int scheduleCourse(int[][] courses) {
		
		int temp[]=new int[courses.length];
		int begin=0;
		int count=0;
		
		List<Integer> list=new ArrayList<Integer>();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<courses.length;i++){
			map.put(courses[i][0], courses[i][1]);
			list.add(courses[i][0]);
		}
		//		map.put(arg0, arg1)
		Collections.sort(list);
		
		for(int i=0;i<map.size();i++){
			System.out.println("deadline= "+map.get(list.get(i)));
			System.out.println("chixue= "+list.get(i));
			if(begin+list.get(i)<=map.get(list.get(i))){
				count++;
				begin=begin+list.get(i);
			}
				
//			begin=;
		}
		
		System.out.println(count);
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCContest2 lc=new LCContest2();
		
		int courses[][] = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
		lc.scheduleCourse(courses);
	}

}
