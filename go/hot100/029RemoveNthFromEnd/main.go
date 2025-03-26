package _29RemoveNthFromEnd

type ListNode struct {
	Val  int
	Next *ListNode
}

func getLength(head *ListNode) int {
	length := 0
	node := head
	for node != nil {
		length++
		node = node.Next
	}
	return length
}
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	length := getLength(head)
	dummy := &ListNode{Next: head}
	cur := dummy
	for i := 0; i < length-n; i++ {
		cur = cur.Next
	}
	cur.Next = cur.Next.Next
	return dummy.Next
}

func removeNthFromEnd2(head *ListNode, n int) *ListNode {
	var nodes []*ListNode
	dummy := &ListNode{0, head}
	for node := dummy; node != nil; node = node.Next {
		nodes = append(nodes, node)
	}
	prev := nodes[len(nodes)-1-n]
	prev.Next = prev.Next.Next
	return dummy.Next
}
