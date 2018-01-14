public class SimpleHW7Test {
	  public static void main(String[] args) {
		  Polynomial x = new Variable("x");
		  Polynomial y = new Variable("y");
		  Polynomial three = new Number(3);
		  Polynomial xPlusThree = new PlusOp(x,three);
		  Polynomial p = new ProductOp(xPlusThree, y);
		  
		  String s = p.toString();
		  System.out.println(s);
	  }
}
