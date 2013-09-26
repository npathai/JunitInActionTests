package test.required;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager{

	Map<String, Account> accounts = new HashMap<String, Account>();
	
	@Override
	public Account findAccountForUser(String userId) {
		return accounts.get(userId);
	}

	@Override
	public void updateAccount(Account account) {
		//skip this nothing to do in mock
	}

	public void addAccount(Account account){
		accounts.put(account.getAccountId(), account);
	}
}
