package singleton;

public class Test {
	
	public class Abc
	{
		private Abc() {//2 内部构造函数是私有的，外部new没法用，就不会产生多个对象，在自己类内部new像3，自己可以控制有几个对象
		};
		//n1=new Abc();// 3
	}
	
	public class Cbd
	{
		public Cbd()
		{
			Abc n1,n2;
			n1=new Abc();//1 java堆的指针n1、n2是不同的
			n2=new Abc();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		Abc n1,n2;
		
	//n1=new Abc();
		
		
		
		
	}

}
