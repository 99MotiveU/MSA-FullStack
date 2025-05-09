package com.am;

import java.util.*;

class MyLink {
	private class Node {
		int val;
		Node nxt;
	}

	Node first;
	int cnt;

	int size() {
		return cnt;
	}

	int get(int idx) {
//		0 first.val;
//		1 first.val.val;
//		2 first.val.val;

		Node temp = first;
		for (int i = 0; i < idx; i++) {
			temp = temp.nxt;
		}
		return temp.val;
	}// get end

	void add(int su) {
		cnt++;
//		1.
		if (cnt == 1) {
			first = new Node();
			first.val = su;
		} else {
			Node temp2 = new Node();
			temp2.val = su;
//			first.nxt=temp2;
			Node temp = first;
			while (true) {
				if (temp.nxt == null)
					break;
				temp = temp.nxt;
			}
			temp.nxt = temp2;
		}
	}
}

public class Ex05 {

	public static void main(String[] args) {
//		MyLink arr = new MyLink();
		LinkedList arr = new LinkedList();
		arr.add(1111);
		arr.add(2222);
		arr.add(3333);
		arr.add(4444);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}

}
