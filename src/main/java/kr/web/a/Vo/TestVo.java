package kr.web.a.Vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TestVo implements Serializable{
	private int val1;
	private String val2;
	private String val3;


	public void getCatsInfo() {
		System.out.println("val1 : " + getVal1());
		System.out.println("val2 : " + getVal2());
		System.out.println("val3 : " + getVal3());
	}
}
