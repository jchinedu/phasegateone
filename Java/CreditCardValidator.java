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