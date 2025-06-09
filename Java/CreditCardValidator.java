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