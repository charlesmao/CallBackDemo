package com.maozy;

public class Local implements CallBack, Runnable {
	
	private Remote remote;
	
	/**
	 * 发送出去的消息
	 */
	private String message;
	
	
	
	public Local(Remote remote, String message) {
		super();
		this.remote = remote;
		this.message = message;
	}


	/**
	 * 发送消息
	 */
	public void sendMessage() {
		//当前线程名称
		System.out.println(Thread.currentThread().getName());
		//创建一个新的线程改善消息
		Thread thread = new Thread(this);
		thread.start();
		//当前线程继续执行
		System.out.println("Message has been send by Local~!");
	}
	
	

	/**
	 * 发送消息后的回调函数
	 */
	@Override
	public void execute(Object... objects) {
		System.out.println(objects[0]);
		System.out.println(Thread.currentThread().getName());
		Thread.interrupted();
	}


	@Override
	public void run() {
		remote.executeMessage(message, this);
	}
	
	public static void main(String[] args) {
		Local local = new Local(new Remote(), "Hello");
		local.sendMessage();
	}

}
