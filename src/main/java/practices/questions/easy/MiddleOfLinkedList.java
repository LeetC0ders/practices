package practices.questions.easy;

import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import practices.datastructure.SinglyLinkedList.ListNode;
import practices.questions.Solution;

/*
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1 and 100.
 *
 *
 * */
public class MiddleOfLinkedList implements Solution<ListNode, ListNode> {

    @Inject
    public MiddleOfLinkedList() {}

    @NotNull
    @Override
    public String getName() {
        return "MiddleOfLinkedList";
    }

    @Override
    public ListNode solve(@Nullable ListNode solutionIn) {
        if (solutionIn != null) {
            return firstAttempt(solutionIn);
        }
        return null;
    }

    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
     * Memory Usage: 33.7 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
     * */
    public ListNode firstAttempt(ListNode solutionIn) {
        ListNode passedIn = solutionIn;
        ListNode loopNode = solutionIn;
        int counter = 0;

        while (passedIn != null) {
            counter++;
            passedIn = passedIn.getNext();
        }

        for (int i = 0; i < counter / 2; i++) {
            loopNode = loopNode.getNext();
        }
        return loopNode;
    }
}
