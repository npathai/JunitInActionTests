package test.required;

public interface AccountManager {
	
	public Account findAccountForUser(String accountId);
	
	public void updateAccount(Account account);
}
