/*
 * 1) Kelly Hall
 * 2) October 4, 2016
 * 3) compare 3 different objects using getMeasure() and Element T
 * 4) Input: N/A
 * 5) Output: the Largest measure and a sorted array by measure 
 */

package Generics;

public class BankAccount<T> extends Measurable {
	String type = null;
	double balance = 0.0;
	//bankaccount constructor
	BankAccount(String type,double balance){
		this. type = type;
		this.balance = balance;
	}
	//get bank account type
	public String getName(){
		return type;
	}
	@Override
	//get bankaccount balance
	public double getMeasure(){
		return balance;
	}
	public String toString(){
		return "$" + balance;
	}


}//end of bankaccount
