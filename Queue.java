
public class Queue 
{
	int rear;
	int front;
	int queuearr[];
	int size;
	int count;
	Queue(int size)
	{
		front=0;
		rear=-1;
		this.size=size;
		queuearr=new int[this.size];
		count=0;
	}

	void add(int element)
	{
		if(rear==size-1)
			rear=-1;
		
			queuearr[++rear]=element;
			count++;
		
	}
	
	int remove()
	{
		int temp=0;
		if(front==size)
			front=0;
		if(count==0)
			System.out.println("Queue empty");
		
		else
		{
			temp=queuearr[front++];
			count--;
		}
		return temp;
	}
	
	void display()
	{
		if(front<rear)
		{
		for(int i=rear;i>=front;i--)
			System.out.print(" "+queuearr[i]);
		}
		else
		{
			for(int k=rear;k>=0;k--)
				System.out.print(" "+queuearr[k]);
			for(int j=size-1;j>=front;j--)
			{
				System.out.print(" "+queuearr[j]);
			}
			
		}
		System.out.println();
		
	}
	public static void main(String[] args) 
	{

		Queue q= new Queue(10);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		q.display();
		q.remove();
		q.remove();
		q.remove();
		q.display();
		q.add(1);
		q.add(2);
		q.add(3);
		q.display();
		q.remove();
		q.display();
		q.remove();
		q.remove();
		q.display();
		q.add(100);
		q.display();
	}

}
