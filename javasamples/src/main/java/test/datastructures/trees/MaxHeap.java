package test.datastructures.trees;

import java.util.*;
import java.lang.reflect.*;

public class MaxHeap<T extends Comparable<T>> {
private T[] data = null;
private final int DEFAULT_SIZE = 10;
private Class clazz;
private int currPos = -1;
public MaxHeap(Class<T> clazz, int N) {
data = (T[])Array.newInstance(clazz,N+1);
this.clazz = clazz;
}

public MaxHeap(Class<T> clazz) {
data = (T[])Array.newInstance(clazz,DEFAULT_SIZE);
}

public void init(T[] data) {
if (data == null)
throw new IllegalArgumentException("Invalid parameter values");
int len = data.length;
this.data[0] = null;
for (int i=0;i<len;i++) {
this.data[i] = data[i];
pushUp(i);
currPos = i;
}
}

public void put(T data) {
System.out.println("this.data.length:"+this.data.length+":this.currPos:"+this.currPos);
if ((this.data.length-this.currPos)==1) {
T temp[] = (T[])Array.newInstance(this.clazz, this.data.length*2);
System.arraycopy(this.data,0,temp,0,this.data.length);
this.data = temp;
}
this.currPos+=1;
this.data[this.currPos]  = data;
pushUp(this.currPos);
}

public T getMax() {
                if (isEmpty())
                                throw new NoSuchElementException("No data available");
                T temp = this.data[0];
                this.data[0] = this.data[currPos];
                this.data[currPos--]=null;
                pushDown();
                return temp;
/*private void pushDown() {

                int start = 0;
                int targetPos = 0;
                T temp = null;
                if (this.size() ==1)
                                return;


                while (start < this.currPos) {
                                if (this.data[2*start+1]==null || this.data[2*start+2]==null) {
                                                targetPos=this.data[2*start+1]!=null?2*start+1:this.data[2*start+2]!=null?2*start+2:0;
                                } else if (this.data[2*start+1].compareTo(this.data[2*start+2]) > 0 ) {
                                                targetPos = 2*start+1;
                                } else if  (this.data[2*start+1].compareTo(this.data[2*start+2]) < 0 ) {
                                                targetPos = 2*start+2;
                                }

                                if (this.data[start].compareTo(this.data[targetPos]) < 0) {

                                                temp = this.data[targetPos];
                                                this.data[targetPos] = this.data[start];
                                                this.data[start] = temp;
                                                start = targetPos;

                                } else {
                                                break;

                                }
                }

} */

private void pushDown() {

                int start = 0;
                T temp = null;
                while (start < this.currPos/2) {

                                int leftChild = 2*start+1;
                                int rightChild = 2*start+2;
                                int targetPos = 0;
                                if (this.data[leftChild] != null && this.data[rightChild] != null) {
                                                targetPos = this.data[leftChild].compareTo(this.data[rightChild]) >0?leftChild:rightChild;
                                } else {
                                                if (this.data[leftChild] ==null)
                                                                targetPos = rightChild;
                                                else
                                                                targetPos = leftChild;
                                }

                                if (this.data[start].compareTo(this.data[targetPos]) < 0) {
                                                temp = this.data[targetPos];
                                                this.data[targetPos] = this.data[start];
                                                this.data[start] = temp;
                                                start = targetPos;
                                } else
                                                break;
                }

}


public static void main(String[] argv) {
Scanner scanner = new Scanner(System.in);
MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(Integer.class,10);
Integer[] data = new Integer[10];
int[] temp = new int[] {20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
for (int i=0;i<10;i++) {
data[i] = Integer.valueOf(temp[i]);
}
maxHeap.init(data);
System.out.println(maxHeap.toString());
maxHeap.put(100);
maxHeap.put(300);
maxHeap.put(400);
System.out.println(maxHeap.toString());
while (!maxHeap.isEmpty())
                System.out.println("MAX:"+maxHeap.getMax());

System.out.println(maxHeap.toString());
scanner.close();
}
}