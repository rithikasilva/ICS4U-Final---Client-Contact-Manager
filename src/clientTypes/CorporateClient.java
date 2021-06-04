package clientTypes;

public class CorporateClient extends AbstractClient{
	
	public String companyName; /*Value the stores the company name of a client*/
	
	
	
	
	@Override
	/******************************
	 * Name: getName
	 * Date: 20/05/2021
	 * Description: A method that returns the company name of a corporate client
	 * Input: -
	 * Output: Company name
	 *****************************/
	public String getName() {
		return companyName;
	}
	
	
	public CorporateClient(String name, String phone, boolean discovered, String location) {
		companyName = name;
		phoneNumber = phone;
		discoveredClient = discovered;
		address	= location;			
	}

}
