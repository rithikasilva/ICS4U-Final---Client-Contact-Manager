package clientTypes;

public abstract class AbstractClient {
	
	public String phoneNumber;			/*Value the stores the phone number of a client*/
	public boolean discoveredClient;	/*Value the stores if the client was discovered by the company*/
	public String address;				/*Value the stores the address of a client*/
	
	
	
	/******************************
	 * Name: getName
	 * Date: 20/05/2021
	 * Description: Abstract method to return string name of instantiated house
	 * Input: -
	 * Output: -
	 *****************************/
	protected abstract String getName();
	
}
