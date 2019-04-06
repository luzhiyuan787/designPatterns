package singleton;

public class ChocolateFactory {

	private boolean empty;
	private boolean boiled;
	public volatile static ChocolateFactory uniqueInstance = null;//1 -2急切解决方案，直接new，弥补同步锁资源的消耗，但可能程序用不到这个资源
	//1 -3双重检查加锁，volatile，下边也得加synchronized

	//只有一个锅炉，new出两个实例，可能第一个加满料了，还得继续加
	//如果不是单例容易出现内容混杂
	//如果是单例模式，在第二次getInstance的时候，会得到第一次的实例，这个时候就不会继续加料了
	private ChocolateFactory() {
		empty = true;
		boiled = false;
	}

	public static ChocolateFactory getInstance() {

		if (uniqueInstance == null) {//1 -1多线程，可能线程切片过程中两个线程都进入了此段代码，不加synchronized（同步锁），可能会有意外
			synchronized (ChocolateFactory.class) {//1 -4不会频繁消耗资源
				if (uniqueInstance == null) {
					uniqueInstance = new ChocolateFactory();
				}
			}
		}

		return uniqueInstance;

	}

	public void fill() {
		if (empty) {
			// 添加原料巧克力动作
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if ((!empty) && boiled) {
			// 排出巧克力动作
			empty = true;
		}
	}

	public void boil() {
		if ((!empty) && (!boiled)) {
			// 煮沸
			boiled = true;
		}
	}
}
