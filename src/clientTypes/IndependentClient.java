package clientTypes;

public class IndependentClient extends AbstractClient {
	
	public String firstName;	/*Value the stores the first name of a client*/
	public String lastName;		/*Value the stores the last  name of a client*/

	
	
	public IndependentClient(String contactName, String surname, String phone, boolean discovered, String location) {
		firstName = contactName;
		lastName = surname;
		phoneNumber = phone;
		discoveredClient = discovered;
		address	= location;			
	}
	
	/******************************
	 * Name: getName
	 * Date: 20/05/2021
	 * Description: A method that returns either the first name or last name of a independent client.
	 * Input: Boolean to specify the type of name
	 * Output: First name or last name of the client
	 *****************************/
	public String getName(boolean isFirst) {
		if (isFirst == true) {
			return firstName;
		}
		else {
			return lastName;
		}
		
	}


	@Override
	/******************************
	 * Name: getName
	 * Date: 20/05/2021
	 * Description: A method that is inherited from the abstract class. This method is deprecated so returns null.
	 * Input: -
	 * Output: -
	 *****************************/
	protected String getName() {
		return null;
	}




}
