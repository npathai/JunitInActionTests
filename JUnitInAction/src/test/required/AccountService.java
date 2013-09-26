package test.required;

public class AccountService {

	private AccountManager accountManager;

	public void setAccountManager(AccountManager accountManger){
		this.accountManager = accountManger;
	}
	
	public void transfer(String senderId, String benefeciaryId, long amount){
		Account sender = accountManager.findAccountForUser(senderId);
		Account receiver = accountManager.findAccountForUser(benefeciaryId);
		
		sender.debit(amount);
		receiver.credit(amount);
		
		accountManager.updateAccount(sender);
		accountManager.updateAccount(receiver);
	}
}
