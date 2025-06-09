import java.util.Scanner;
public class CreditCardValidator{

public static boolean validLength(String cardNumber){
	if(cardNumber.length() != 16){
		return false;
	}
	for(char ch : cardNumber.toCharArray()){
	 if(!Character.isDigit(ch)) {
		return false;
	}
	}
	return true;
}
public static String cardType(String cardNumber){
	if(cardNumber.startsWith("4")){
	return "VISA";
	}
	else if(cardNumber.startsWith("5")){
	return "MasterCard";
	}
	else if(cardNumber.startsWith("37")){
	return "American Express";
	}
	else if(cardNumber.startsWith("6")){
	return "Discover";
	}
	else{
	return "Invalid";
	}
	}
public static boolean check(String cardNumber){
	int sum = 0;
	boolean doubledigit = false;
	for(int i = cardNumber.length()-1; i>=0; i--){
	int digit = cardNumber.charAt(i) - '0';

	if(doubleDigit) {
	   digit *= 2;
	if(digit > 9) digit -= 9;
	}
	sum += digit;
	doubleDigit = !doubleDigit;
	}
	return (sum % 10) == 0;
	}
public static void main(String[] args){
 Scanner input = new Scanner(System.in);
System.out.print("Hello, kindly enter card details to verify: ");
String cardNumber = Scanner.nextLine();

System.out.println("credit card type: " + cardType(cardNumber));
System.out.println("credit card number: " + cardNumber);
System.out.println("credit card Digit Length: " + cardNumber.length());
if(!





