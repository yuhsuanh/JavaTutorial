/**
 * @author Yu-Hsuan Huang
 * 
 */
package pers.sample.tutorial.enums;

// enum: Enumeration
public class EnumsExample {
	
	//an enum is a special class 
	enum BottleSize{ SMALL, MEDIUM, LARGE }
	BottleSize size;
	
	public static void main(String[] args) {
		EnumsExample example = new EnumsExample();
		example.size = EnumsExample.BottleSize.LARGE;
		System.out.println("Size : " + example.size);
	}
	
}
