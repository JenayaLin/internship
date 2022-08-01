package com.tips.demo.model;

import java.security.SecureRandom;

public class WaitingNum {
	private int waitingNum;

	public int getWaitingNum() {
		SecureRandom sR = new SecureRandom();
		waitingNum = sR.nextInt(99);
		if(waitingNum == 0) {
			waitingNum = sR.nextInt(99);
		}
		return waitingNum;
	}

	public void setWaitingNum(int waitingNum) {
		this.waitingNum = waitingNum;
	}
}
