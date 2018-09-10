/*
 * SMELL: Data Clump
 *   -- Your methods contain a repeating group of parameters.
 * 
 * TREATMENT: Introduce Parameter Object
 *   -- Replace these parameters with an object.
 */
package coupling01.introduce.parameter.object.before;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Account {
	// ...
	private List<Transaction> transactions = new ArrayList<>();

	public double getFlowBetween(LocalDate start, LocalDate end) {
		double result = 0;

		for (Transaction each : transactions) {
			if (each.getChargeDate().isAfter(start) && each.getChargeDate().isBefore(end)) {
				result += each.getValue();
			}
		}

		return result;
	}

	public void add(Transaction transaction) {
		transactions.add(transaction);
	}
}

class Transaction {
	private LocalDate chargeDate;
	private double value;

	public Transaction(double value, LocalDate chargeDate) {
		this.value = value;
		this.chargeDate = chargeDate;
	}

	public LocalDate getChargeDate() {
		return chargeDate;
	}

	public double getValue() {
		return value;
	}
}
