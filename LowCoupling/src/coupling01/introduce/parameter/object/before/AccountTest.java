package coupling01.introduce.parameter.object.before;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AccountTest
{
	@Test
	public void should_return_sum_of_transactions_in_range() throws Exception
	{
		Account account = new Account();
		account.add(new Transaction(100, LocalDate.of(2016, 5, 15)));
		account.add(new Transaction(200, LocalDate.of(2016, 6, 15)));
		account.add(new Transaction(300, LocalDate.of(2016, 7, 15)));
		
		double value = 
				account.getFlowBetween(LocalDate.of(2016, 6, 1), LocalDate.of(2016, 7, 30));
	
		assertEquals(500.0, value, 0.1);
	}
}
