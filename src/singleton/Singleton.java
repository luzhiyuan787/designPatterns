package singleton;

/**
 * 经典单例模式
 */
public class Singleton {
	
	private static Singleton uniqeInstance=null;//
	
	private Singleton(){//杜绝外部构造
		
	};
	
	public static Singleton getInstance()//是类方法，不是对象方法
	{
		if(uniqeInstance==null)
		{
			uniqeInstance=new Singleton();//
		}
		return uniqeInstance;
		
	}

}
