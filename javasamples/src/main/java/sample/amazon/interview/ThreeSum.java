package sample.amazon.interview;

import java.util.*;
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


public class ThreeSum {
	

	public Set<Triplet> modsum(int[] data) {
		Set<Triplet> results = new HashSet<>();
		int len = data.length;
		 Arrays.sort(data);
// S = [-1, 0, 1, 2, -1, -4],
		for (int i=0;i<len-2;i++) {
			if(i > 0 && data[i] == data[i - 1]) {
                
                continue;
                
            }
			int required = 0 - data[i];
			int k = len-1;
			int j = i+1;
			while (j < k) {

				if (data[j]+data[k]==required) {
					Triplet t = new Triplet(data[i],data[j],data[k]);
					results.add(t);
					j+=1;
					k-=1;
					 while(j < k && data[j] == data[j - 1]) j++;
                     while(j < k && data[k] == data[k + 1]) k--;
				} else if (data[j]+data[k] > required) {
					k-=1;
				} else {
					j+=1;
				}
				
			}
		}
		return results;
	}
	public Set<Triplet> sum(int[] data) {
		Set<Triplet> results = new HashSet<>();
		for (int i=0;i<data.length;i++) {
			for(int j=0;j<data.length;j++) {
				if (j == i) continue;
				for (int k=0;k<data.length;k++) {
					if (k==j || k==i)
						continue;

					if (data[i]+data[j]+data[k]==0) {
						
						Triplet t = new Triplet(data[i],data[j],data[k]);
						results.add(t);
					}
				}
			}
		}
		return results;
	}


	public static void main(String[] argv) {
		int[] data = new int[]{-1,0,1,2,-1,-4};
		ThreeSum ts = new ThreeSum();
		Set<Triplet> results = ts.modsum(data);
		for (Triplet t:results) {
			System.out.print(t.i+"::"+t.j+"::"+t.k);
			System.out.println();
		}
	}

}

class Triplet {
	Integer i;
	Integer j;
	Integer k;

	public Triplet(Integer i, Integer j, Integer k) {
		this.i=i;
		this.j=j;
		this.k=k;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Triplet))
			return Boolean.FALSE;
		Triplet t = (Triplet)o;
		if (this.i==t.i && this.j==t.j && this.k==t.k) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public int hashCode() {

		return this.i.hashCode()+this.j.hashCode()+this.k.hashCode();
	}
}