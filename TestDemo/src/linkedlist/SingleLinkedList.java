package linkedlist;

import linkedlist.SingleLinkedList.Note;

public class SingleLinkedList {
	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		sl.addNote("A");
		sl.addNote("B");
		sl.addNote("C");
		sl.addNote("D");
//		sl.deletehead();
//        sl.display();
//        sl.isEmp();
		//Note findNode = sl.findNode("B");
       // System.out.println("==findNode=="+findNode.value);
		sl.delete("B");
		 sl.display();
	}

	int size = 0;
	Note head;

	public SingleLinkedList() {
		head = null;
	}

	class Note {
		Object value;
		Note next;

		public Note(Object value) {
			this.value = value;
		}
	}
	
	//查找节点位置。找不到返回为空null
	  public Note findNode(Object obj) {
		  Note current=head;
		  int currentSzie=size;
		  while(currentSzie>0) {
			  if(obj.equals(current.value)) {
				  return current;
			  }
			  current=current.next;
			  currentSzie--;
		  }
		  
		  return null;

	  }
	
 //删除指定节点数据
	  public boolean delete(Object value){
		           if(size == 0){
		               return false;
		           }
		           Note current = head;
		           Note previous = head;
		           while(current.value != value){
		               if(current.next == null){
		                   return false;
		               }else{
		                   previous = current;
		                   current = current.next;
		               }
		           }
		           //如果删除的节点是第一个节点
		           if(current == head){
		               head = current.next;
		               size--;
		           }else{//删除的节点不是第一个节点
		               previous.next = current.next;
		               size--;
		           }
		           return true;
		       }
	
	
	
	
	
	//删除头节点
	public Object deletehead() {
		Object headvalue = head.value;
		head=head.next;
		size--;
		return headvalue;
		
	}
	
	
	
	
	//判断链表是否为空
	public boolean isEmp() {
		return size==0;
	}

	Object addNote(Object value) {
		Note newHead = new Note(value);
		if (size == 0) {
			head = newHead;
		} else {
			newHead.next = head;
			head = newHead;

		}
		size++;
		return head;
	}
	
	public void display(){
		if(size>0) {
		Note node=head;
		int temSize=size;
		if(temSize==1) {
			System.out.println("===="+node.value);
		}
		while(temSize>0) {
			if(node.equals(head)) {
				System.out.print("["+node.value+"->");
			}else if(node.next==null) {
				System.out.print(node.value+"]");
			}else {
				System.out.print(node.value+"->");
			}
			temSize--;
			node=node.next;
			
		}
			
		}else {
			System.out.println("没有数据");
		}
		
		
	}

}