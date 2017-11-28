# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # head = tail = ListNode()
        carry = 0
        head = tail = None

        if l1 is None and l2 is None:
            return ListNode(0)

        while l1 is not None or l2 is not None or carry > 0:
            sum = carry
            if l1:
                sum += l1.val
                l1 = l1.next

            if l2:
                sum += l2.val
                l2 = l2.next

            carry, sum = sum / 10, sum % 10

            if head is None:
                head = tail = ListNode(sum)
            else:
                tail.next = ListNode(sum)
                tail = tail.next

        return head