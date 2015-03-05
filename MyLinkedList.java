public class MyLinkedList
{
	Node head = null;
	int nodecount;

	public void add(Object data)
	{
		Node temp = new Node(data);
		Node current = head;
		if (head == null) 
		{
			head = temp;
			nodecount++;
		} 
		else
		{
			while (current.getNext() != null)
			{
				current = current.getNext();
			}
			current.setNext(temp);
			nodecount++;
		}
	}

	public void display() 
	{
		Node current = head;
		if (current == null)
		{
			System.out.println("List empty");
		} 
		else 
		{
			int i = 0;
			while (current != null) 
			{
				System.out.print("Node" + (++i) + " " + "("+current.getData()+")"+ "--> ");
				current = current.getNext();
			}
		}
		System.out.print("null");System.out.println("");

	}

	void insertat(int pos,Object data)
	{
		Node current=head;int i=0;
		if(current==null)
		{
			System.out.println("List empty. No such position available");
		}
		if(nodecount<pos)
		{
			System.out.println("Cannot insert in this position as very few nodes exist!");
		}

		else
		{
			System.out.println("pos s "+pos);
			while(current.getNext()!=null)
			{
				i++;
				if(i==pos-1)
					break;
				current=current.getNext();
			}
			Node temp = new Node(data);
			nodecount++;
			if(i==1)
			{
				head=temp;
				head.setNext(current);
			}
			else
			{
				Node nextnode=current.getNext();
				current.setNext(temp);
				current=temp;
				current.setNext(nextnode);
			}
		}
	}

	void remove(int index)
	{
		Node current=head;
		if(nodecount==0 || nodecount<index)
		{
			System.out.println("cannot remove. Index not present");
		}
		else
		{
			if(index==1)
			{
				head=current.getNext();
				current=head;
				nodecount--;
			}
			else
			{
				int i=0;
				while(current.getNext()!=null)
				{
					i++;
					if(i==index-1)
						break;
					current=current.getNext();
				}
				Node nextNode= current.getNext().getNext();
				current.setNext(nextNode);
				nodecount--;
			}
		}
	}

	void remove_element(Object data)
	{
		Node current=head;
		Object temp=head.getData();
		if(data.equals(temp))
		{
			current=current.getNext();
			head=current;
			nodecount--;
		}
		else
		{
			while(current!=null)
			{
				temp=current.getNext().getData();
				if(temp.equals(data))
					break;
				current=current.getNext();
			}
			Node nextNode=current.getNext().getNext();
			current.setNext(nextNode);
		}
	}
	
	void removedup()
	{
		Node temp=head;
		Node prev=head;
		Node curr=head;
		
		while(temp!=null)
		{
			while(curr!=null)
			{
				if(temp==curr)
				{
					curr=curr.next;
					continue;
				}
				System.out.println("Comparing "+temp.data+"and"+curr.data);
				if(temp.data==curr.data)
				{
					System.out.println("prev is "+prev.data);
					System.out.println("curr is "+curr.data);
					prev.next=curr.next;
					
				}
				
				prev=curr;
				curr=curr.next;
			}
			temp=temp.next;
			curr=head;
		}
	}
	public static void main(String[] args)
	{

		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add("asv");
		list.add(10);
		list.add(15);
		list.insertat(1, 34);
		//	list.display();
	//	list.remove(4);
		list.display();
		list.insertat(3,15);
		list.display();
		list.removedup();
		list.display();
	}

}
