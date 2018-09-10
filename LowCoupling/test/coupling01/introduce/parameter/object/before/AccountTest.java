package coupling01.introduce.parameter.object.before;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class AccountTest
{
	@Test
	public void should_return_sum_of_transactions_in_range() throws Exception
	{
		Account account = new Account();
		account.add(new Transaction(100, new Date(2016, 5, 15)));
		account.add(new Transaction(200, new Date(2016, 6, 15)));
		account.add(new Transaction(300, new Date(2016, 7, 15)));
		
		double value = 
				account.getFlowBetween(new Date(2016, 6, 1), new Date(2016, 7, 30));
	
		assertEquals(500.0, value, 0.1);
	}
}
