package test.datastructures.lists;

import java.util.*;
import java.lang.reflect.*;

public class ArrayLinearList<T extends Comparable<T>> {
	
	private T[] data;
	private int size;	
	private Class<T> clazz;

	public ArrayLinearList(Class<T> clazz,int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("Initial capacity must be greater than 1");
		this.clazz = clazz;
		data = (T[])Array.newInstance(clazz,initialCapacity);	
	}

	public ArrayLinearList(Class<T> clazz) {
		this(clazz, 10);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (size==0);
	}

	public T get(int position) {
		if (position < 0 || position >= size)
			throw new IllegalArgumentException("Invalid element position");
		if (!isEmpty())
			return this.data[position];
		else
			return null;
	}

	public int indexOf(T t) {
		if (t==null)
			throw new IllegalArgumentException("Null parameter value not allowed");
		for (int i =0;i < size; i++) {
			if (t.compareTo(data[i]) ==0)  {
				return i;
			}
		}
		return -1;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Invalid element position");
		T t = get(index);
		this.data[index] = null;
		shiftLeft(index);
		this.size-=1;
		return t;
	}

	public void add(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException("Null value cannot be inserted");
		if (index < 0)
			throw new IllegalArgumentException("Invalid element position for insertion");

		if (index >= data.length) {
			increaseCapacity(index);
		}
		if (index < this.size()) {
			int start = this.size();
			for (int i = start + 1;i > index;i-- ) {
				data[i]=data[i-1];
			}
		}
		System.out.println("Index:"+index+":Element:"+element);
		data[index] = element;
		this.size+=1;
		
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		if (isEmpty())
			return "NULL";
		for (int i=0;i<this.data.length;i++) {
			if (strBuilder.length()==0)
				strBuilder.append(data[i]!=null?data[i].toString():"NULL");
			else
				strBuilder.append(",").append(data[i]!=null?data[i].toString():"NULL");
		}
		return strBuilder.toString();
	}

	private void increaseCapacity(int index) {
		int currCap = data.length;
		int targetLen = 2*currCap;
		if (index >	targetLen)
			targetLen	=	index;
		T[] temp = (T[])Array.newInstance(this.clazz, targetLen);
		System.arraycopy(this.data, 0, temp, 0, this.data.length);
		data = temp;

	}

	private void shiftLeft(int index) {

		for (int i=index;i<size-1;i++) {
			data[i]=data[i+1];
		}
		size-=1;
	}

	public Iterator<T> iterator() {

		T[] data = this.data;
		int size = this.size();
		return new Iterator() {
			int count = -1;
			public boolean hasNext() {
				return (++count < size);
			}

			public T next() {
				if (count == -1)
					throw new NoSuchElementException();
				return data[count];
			}

			public void remove() {
				if (count == -1)
					throw new IllegalStateException();
				data[count]=null;
			}
		};
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);

		ArrayLinearList<Integer> list1 = new ArrayLinearList<Integer>(Integer.class);
		System.out.println("Size:"+list1.size());
		System.out.println("List 1:"+list1.toString());
		try {
			System.out.println("Element at 2:"+list1.get(2));
		} catch (Exception ex) {
			System.err.println("Exception :"+ex.getMessage());
		}

		ArrayLinearList<Integer> list2 = new ArrayLinearList<Integer>(Integer.class);
		for (int i=0;i<5;i++) {
			list2.add(i,i*5);
		}
		System.out.println("Size:"+list2.size());
		System.out.println("List 2:"+list2.toString());

		ArrayLinearList<Integer> list3 = new ArrayLinearList<Integer>(Integer.class);
		for (int i=0;i<15;i++) {
			list3.add(i*2,i*5);
		}
		System.out.println("Size:"+list3.size());
		System.out.println("List 3:"+list3.toString());
		list3.remove(5);
		list3.remove(10);
		try {
			list3.remove(11);
		} catch (Exception ex) {
			System.err.println("Exception :"+ex.getMessage());
		}
		System.out.println("List 3 After removal:"+list3.toString());

		ArrayLinearList<Integer> list4 = new ArrayLinearList<Integer>(Integer.class);
		for (int i=0;i<5;i++) {
			list4.add(i,i*5);
		}
		Iterator<Integer> iterator = list4.iterator();
		try {
			System.out.println(iterator.next());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			iterator.remove();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(list4.toString());
		iterator = list4.iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}
		System.out.println(list4.toString());
		scanner.close();
	}
}
