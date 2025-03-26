package _27AddTwoNumbers

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	return add(l1, l2, 0)
}

func add(l1 *ListNode, l2 *ListNode, carry int) *ListNode {
	if l1 == nil && l2 == nil {
		if carry == 0 {
			return nil
		}
		return &ListNode{Val: carry}
	}
	if l1 == nil {
		l1 = &ListNode{}
	}
	if l2 == nil {
		l2 = &ListNode{}
	}
	sum := l1.Val + l2.Val + carry
	carry = sum / 10
	sum = sum % 10
	return &ListNode{Val: sum, Next: add(l1.Next, l2.Next, carry)}
}
