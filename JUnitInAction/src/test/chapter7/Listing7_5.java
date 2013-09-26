package test.chapter7;

import junit.framework.TestCase;

import org.junit.Test;

import test.required.Account;
import test.required.AccountManager;
import test.required.AccountService;
import test.required.MockAccountManager;

public class Listing7_5 extends TestCase{

	@Test
	public void testTransferOK(){
		MockAccountManager mockAccountManager = new MockAccountManager();
		
		Account sender = new Account("1", 200);
		Account receiver = new Account("2", 100);
		
		mockAccountManager.addAccount(sender);
		mockAccountManager.addAccount(receiver);
		
		AccountService accountService = new AccountService();
		accountService.setAccountManager(mockAccountManager);
		
		accountService.transfer(sender.getAccountId(), receiver.getAccountId(), 50);
		
		assertEquals(150, sender.getBalance());
		assertEquals(150, receiver.getBalance());
	}
}
