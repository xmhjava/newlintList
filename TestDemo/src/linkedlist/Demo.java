package linkedlist;


public class Demo {
	public static void main(String[] args) {
		Demo d=new Demo();
		d.addNode("A");
		d.addNode("B");
		d.addNode("C");
		//d.addNode("D");
		//d.deleteNode("C");
		d.findAll();
	}
	Node head;
	int size=0;
	Node tempNode;
	Node temp1;

	class Node {
		String value;
		Node next;

		public Node(String value) {
			this.value = value;
		}

	}
	

	// 添加节点对象
	public Node addNode(String value) {
		Node newnode=new Node(value);
		if (size == 0) {
			head=newnode;
			tempNode=newnode;
		}else {
//			newnode.next=head;
//			head=newnode; 
			//tempNode=newnode;
			if(size==1) {
				head.next=newnode;
				tempNode=head;
				head=tempNode;
			}else {
				temp1=head;
				while(temp1.next!=null) {
					temp1=temp1.next;
				}
				if(temp1.next==null) {
					temp1.next=head;
					tempNode=temp1;
					head=tempNode;
				}
			}
		}
		size++;
		return head;
	}
	
	
	//遍历节点数据
	public void findAll() {
		
		if(size>0) {
			int tempsize=size;
			Node node=head;
			if(tempsize==1) {
				System.out.print("==头节点=="+node.value);
			}
			while(tempsize>0) {
				if(node.equals(head)) {
					System.out.print("["+node.value);
				}else if(node.next==null) {
					System.out.print("---->"+node.value+"]");
				}else {
					System.out.print("--->"+node.value);
				}
				
				tempsize--;
				node=  node.next;
				
			}
			
		}
	}
	
	
	public void deleteNode(String value) {
		Node priver=head;
		Node current=head;
		
		while(current.value!=value) {
			priver=current;
			current= current.next;
			
		}
		if(current.value!=value) {
		
		}else {
			size--;
			priver.next=current.next;
		}
		
	}

}












