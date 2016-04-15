package com.maozy;

public class Remote {

	/**
	 * 处理消息
	 * @param msg
	 * @param callBack
	 */
	public void executeMessage(String msg, CallBack callBack) {
		
		
		//模拟远程类正在处理其他事情，可能需要花费许多时间
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//处理完其他事情，现在来处理消息   
		System.out.println(msg);
		System.out.println("I have executed the message by Local~~~ ");

		//执行回调
		callBack.execute((Object[])new String[] {"Nice to seem you! ~~~"});
	}
}
