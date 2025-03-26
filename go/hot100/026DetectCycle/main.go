package _26DetectCycle

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	seen := make(map[*ListNode]bool)
	for head != nil {
		if seen[head] {
			return head
		}
		seen[head] = true
		head = head.Next
	}
	return nil
}
