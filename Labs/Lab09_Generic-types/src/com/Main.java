package com;

import com.task1.MyHashMap;

public class Main {

    public static void main(String[] args) {
	    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

	    myHashMap.put(1, "Test1");
        myHashMap.put(2, "Test2");

        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
    }
}
