
public class SimpleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		
		Integer i = 0;
		
		if(str instanceof String){
			System.out.println("str is String");
		} else {
			System.out.println("str is not String");
		}
		
		if(i instanceof Integer){
			System.out.println("i is Integer");
		}
	}

}
