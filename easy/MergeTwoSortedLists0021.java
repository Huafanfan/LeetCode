package com.huafanfan.easy;

/**
 * @author alex
 */
public class MergeTwoSortedLists0021 {

	/*
	 * 时间复杂度：O(n+m)。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数
	 * mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
	 * 空间复杂度：O(n+m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以
	 * n+m 个栈帧会消耗 O(n+m) 的空间。
	 */

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}
		else if(l2==null) {
			return l1;
		}
		else if(l1.val<=l2.val) {
			l1.next = mergeTwoLists(l1.next,l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	/*
	 * 时间复杂度：O(n+m) 。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， while 循环
	 * 的次数等于两个链表的总长度。所有其他工作都是常数级别的，所以总的时间复杂度是线性的。
	 * 空间复杂度：O(1) 。迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的。
	 */

	public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(-1);
		ListNode pre = listNode;
		while (l1!=null&&l2!=null) {
			if(l1.val<=l2.val) {
				pre.next = l1;
				l1 = l1.next;
				pre = pre.next;
			}
			else {
				pre.next = l2;
				l2 = l2.next;
				pre = pre.next;
			}
		}
		pre.next = l1 == null ? l2 : l1;
//		if(l1==null) {
//			pre.next = l2;
//		}
//		if(l2==null) {
//			pre.next = l1;
//		}
		return listNode.next;
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}