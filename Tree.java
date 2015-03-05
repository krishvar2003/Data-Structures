
public class Tree 
{
	Node root;
	
	/*void add(int element)
	{
		
		Node nodetoadd = new Node(element);
		if(root==null)
			root=nodetoadd;
		else
		{
			Node current=root;
			Node parent;
			while(true)
			{
				parent=current;
				if(nodetoadd.data<current.data)
				{
					current=current.leftchild;
					if(current==null)
					{
						parent.leftchild=nodetoadd;
						break;
					}
				}
				else
				{
					if(nodetoadd.data>current.data)
					{
						current=current.rightchild;
						if(current==null)
						{
							parent.rightchild=nodetoadd;
							break;
						}
					}
				}
			}
		}
			
	}*/
	
	void add(int element)
	{
		Node nodetoadd= new Node(element);
		if(root==null)
			root=nodetoadd;
		else
			traverseandadd(nodetoadd,root);
	}
	
	void traverseandadd(Node nodetoadd,Node current)
	{
		if(current.data>nodetoadd.data)
		{
			if(current.leftchild==null)
				current.leftchild=nodetoadd;
			else
				traverseandadd(nodetoadd,current.leftchild);
		}
		else if(current.data<nodetoadd.data)
		{
			if(current.rightchild==null)
				current.rightchild=nodetoadd;
			else
				traverseandadd(nodetoadd,current.rightchild);
		}
	}
	
	void inorder(Node localroot)
	{
		if(localroot!=null)
		{
			inorder(localroot.leftchild);
			System.out.print(localroot.data+" ");
			inorder(localroot.rightchild);
		}
	}

	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.add(10);
		t.add(8);
		t.add(4);
		t.add(3);
		t.add(6);
		t.add(5);
		t.add(9);
		t.add(12);
		t.add(11);
		t.inorder(t.root);
	}

}
