
public class DoublyLinkedList
{
	Node head=null;
	Node tail=null;
	int nodecount;
	
	void insertAtFirst(Object element)
	{
		//Node current=head;
		Node temp=new Node(element);
		if(head==null)
		{
			temp.nextLink=null;
			temp.prevLink=null;
			head=temp;
			tail=temp;
			nodecount++;
		}
		else
		{
			temp.nextLink=head;
			head.prevLink=temp;
			
			head=temp;
			nodecount++;
		}

	}
	
	void insertAtRear(Object element)
	{
		Node current=tail;
		Node temp=new Node(element);
		if(nodecount==0)
		{
			temp.nextLink=null;
			temp.prevLink=null;
			tail=temp;
			head=temp;
			nodecount++;
		}
		else
		{
			tail.nextLink=temp;
			temp.prevLink=tail;
			tail=temp;
			nodecount++;
		}
	}
	
	void display()
	{
		
		if(nodecount==0)
		{
			System.out.println("Empty List");
		}
		else
		{
			System.out.print("null<-->");
			Node current=head;
			int i=0;
			while(current!=null)
			{
				i++;
				System.out.print("Node "+i+"{"+current.getData()+"}"+"<-->");
				current=current.getNextLink();
			}
			System.out.print("null");
		}
		System.out.println("");
	}
	
	void insertAt(Object element,int pos)
	{
		Node temp= new Node(element);
		if(pos==1)
		{
			head.prevLink=temp;
			temp.nextLink=head;
			head=temp;
			nodecount++;
		}
		if(pos==nodecount)
		{
			Node prevNode=tail.getPrevLink();
			prevNode.setNextLink(temp);;
			temp.setNextLink(tail);
			nodecount++;
		}
		if(pos>1)
		{
			Node current=tail;
			int tempcount=nodecount;
			while(--tempcount==pos)
			{
				current=current.getPrevLink();
			}
			Node prevNode=current.getPrevLink();
			prevNode.setNextLink(temp);
			temp.setNextLink(current);
			nodecount++;
		}
	}
	
	void removefirst()
	{
		Node current=head;
		Node nextNode=current.getNextLink();
		head=nextNode;
		head.prevLink=null;
		nodecount--;
	}
	
	void removelast()
	{
		Node current=tail;
		Node prevNode=current.getPrevLink();
		tail=prevNode;
		prevNode.nextLink=null;
		nodecount--;
	}
	void removeindex(int pos,DoublyLinkedList list)
	{
		if(pos==1)
		{
			list.removefirst();
			
		}
		else if(pos==nodecount)
		{
			list.removelast();
		}
		else 
		{
			int i=0;
			Node current=head;
			while(++i!=pos)
			{
				current=current.getNextLink();
			}
			Node prevNode=current.getPrevLink();
			Node nextNode=current.getNextLink();
			prevNode.setNextLink(nextNode);
			nextNode.setPrevLink(prevNode);
			nodecount--;
		}
	}
	public static void main(String[] args)
	{
		DoublyLinkedList list= new DoublyLinkedList();
		list.insertAtFirst(10);
		list.insertAtFirst(30);
		list.insertAtFirst(50);
		list.insertAtFirst(60);
		list.insertAtRear(1);
		list.insertAtRear(3);
		list.insertAt(240, 3);
		list.display();
		list.removeindex(4,list);
		list.display();		
	}

}
