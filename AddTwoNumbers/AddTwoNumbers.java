/**
 * Definition for singly-linked list.
 * public class ListNode
 * {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
    	ListNode returnNode;				//Node to return
    	ListNode currentNode;				//Node currently on
    	ListNode addNode;					//Node to add to current node
    	
    	int sum = addNums(l1, l2);
    	int carry;
    	
    	if(sum > 9)							//Checks whether addition is 10 or more, meaning we need carry over to next place
    	{
    		sum = sum % 10;
    		carry = 1;
    	}
    	else
    		carry = 0;
    	
		returnNode = new ListNode(sum);		//Initialize Node to return
		currentNode = returnNode;			//Currently on first Node
		
		while(l1.next != null && l2.next != null)	//Repeats while both lists continue
		{
			l1 = l1.next;							//Iterates lists
			l2 = l2.next;
			
	    	sum = addNums(l1, l2) + carry;			//Adds values and carry if there was any in previous addition
	    	
	    	if(sum > 9)
	    	{
	    		sum = sum % 10;
	    		carry = 1;
	    	}
	    	else
	    		carry = 0;
	    	
	    	addNode = new ListNode(sum);
	    	
	    	currentNode.next = addNode;				//Currently on Node appends new Node
	    	currentNode = currentNode.next;			//Currently on Node switches appended Node
		}
		
		while(l1.next != null)					//Continues when l2 runs out
		{
			l1 = l1.next;

			sum = l1.val + carry;
			
			if(sum > 9)
			{
				sum = sum % 10;
				carry = 1;
			}
			else
				carry = 0;
			
	    	addNode = new ListNode(sum);
	    	
	    	currentNode.next = addNode;
	    	currentNode = currentNode.next;
		}
		
		while(l2.next != null)					//Continues when l1 runs out
		{
			l2 = l2.next;

			sum = l2.val + carry;
			
			if(sum > 9)
			{
				sum = sum % 10;
				carry = 1;
			}
			else
				carry = 0;
			
	    	addNode = new ListNode(sum);
	    	
	    	currentNode.next = addNode;
	    	currentNode = currentNode.next;
		}
		
		if(carry == 1)							//In case both lists end but carry exists, create one last node and append
		{
			addNode = new ListNode(carry);
			
			currentNode.next = addNode;
		}
		
		return returnNode;
    }
    
    public static int addNums(ListNode l1, ListNode l2)
    {
    	return l1.val + l2.val;
    }
}
