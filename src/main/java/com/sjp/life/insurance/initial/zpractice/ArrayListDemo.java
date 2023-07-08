package com.sjp.life.insurance.initial.zpractice;

import antlr.Utils;

public class ArrayListDemo<E> {
	
	private int DEFAULT_CAPACITY = 10;
	
	private Object[] elementData;
	
	private int size;
	
	private Object[] empty_elementData = {};
	
	public ArrayListDemo() {
		
		elementData = empty_elementData;
		
	}
	
	public static void main(String[] args) {
		ArrayListDemo arr = new ArrayListDemo();
		
		arr.add(1);
		arr.displayValues();
	}
	
	
	public  void add(E e) {
		
		if(size==elementData.length)
			elementData = growTheLength(size);
		elementData[size] = e;
		size++;
		
		
	}
	
	public void displayValues() {
		
		for(int i=0;i<elementData.length;i++) {
			if(i+1 <=size)
			System.out.println(elementData[i]);
			
		}
		
	}
	
	public Object[] growTheLength(int size_plus_one) {
		int oldCapacityArr = elementData.length;
		
		if(oldCapacityArr >0 && elementData != empty_elementData) {
			
			int newCapacityArr = (elementData.length*3/2) +1;
			
			Object elementData1[] = new Object[newCapacityArr];
			
			int i=0;
			
			 for(;i<elementData.length;i++) {
				 elementData1[i] = elementData[i];
			 }
			 elementData = elementData1; 
			 
		}
		else {
			elementData = new Object[Math.max(DEFAULT_CAPACITY, size_plus_one)];
		}
		
		return elementData;
		
	}
	
	public void remove(Object obj) {
		
		boolean isRemoved=false;
		int nullremoval = 0;
		
		Object finalResult[] = new Object[elementData.length];
		
		if(obj == null) {
			for (int index=0;index<elementData.length&&index<size; index++) {
				if(elementData[index] == obj && nullremoval ==0) {
					isRemoved = true;
					nullremoval++;
					continue;
				}
				if(isRemoved) {
					finalResult[index-1] = elementData[index];
				}
				else {
					finalResult[index]=elementData[index];	
				}
			}
		}
		else {
			for (int index=0;index<elementData.length&&index<size; index++) {
				if(elementData[index]!=null &&   elementData[index].equals(obj) && nullremoval == 0) {
					isRemoved = true;
					nullremoval++;
					continue;
				}
				if(isRemoved) {
					finalResult[index-1] = elementData[index];
				}
				else {
					finalResult[index]=elementData[index];	
				}
			}
		}
		
		elementData = finalResult;
		if(isRemoved) 
			size--;	
	}
	public int size() {
		return size;
	}

}
