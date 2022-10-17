package study03;

public class Customer {
	
	private String firstName;
	private String lastName;
	private BankAccount account;

	
	
	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "고객 이름 : " + firstName + lastName 
				+ " 고객 계좌 : " + account.getBalance() ;
	}
	
}
