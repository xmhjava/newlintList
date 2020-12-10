
public class Aa {
	
	public static void main(String[] args) {
		String[] str=new String[5];
		str[0]="aa";
		str[1]="bb";
		str[2]="cc";
		str[3]="dd";
		str[4]="ee";
		System.out.println(str.length);
		for (int i = 0; i < str.length; i++) {
			System.out.println("===="+str[i]);
		}
		
	}
	
	public static void aa() {
		System.out.println(111);
	}

	public void bb() {
		System.out.println(222);
	}
	
	public void cc() {
		
	}
	
}

