package linkedlist;

public class twoLinkedList {
	public static void main(String[] args) {
		twoLinkedList dl = new twoLinkedList();
		dl.addNode("A");
		dl.addNode("B");
		dl.addNode("C");
		dl.lastNode("D");
		dl.lastNode("E");
		dl.dispalce();
	}

//
	Node head;// 头指针
	Node tail;// 尾指针
	int size;//节点层次

	class Node {
		Node pre;
		Node next;
		String value;
		int size;

		public Node(String value) {
			this.value = value;
		}

	}

	// 添加节点对象
	public void addNode(String value) {
		Node newnode = new Node(value);
		if(head==null) {
			head=newnode;
			tail=newnode;
		}else {
			head.pre=newnode;
			newnode.next=head;
			head=newnode;
		}
		size++;
	}
	
	
	//在尾节点添加对象
	public void lastNode(String value) {
		Node node=new Node(value);
		if(head==null) {
			head=node;
			tail=node;	
		}else {
			node.pre=tail;
			tail.next=node;
			tail=node;
		}
		size++;
	}
	
	
	
	
	
//[c,b,a]
	// 遍历出所有的节点
	 public void dispalce() {
		 Node tempnode=head;
		 int tempsize=size;
		 if(tempsize==1) {
			 System.out.println("==头节点=="+tempnode.value);
		 }
		 
		 while(tempsize>0) {
			 if(tempnode==head) {
				 System.out.print("["+tempnode.value);
			 }else if(tempnode.next==null){
				 System.out.print("--->"+tempnode.value+"]");
			 }else {
				 System.out.print("--->"+tempnode.value);
			 }
			 tempsize--;
			 tempnode=tempnode.next;
		 }
		 
		 
	 }

}
















