package dip02.replace.conditional.logic.with.strategy.before;

import java.util.ArrayList;
import java.util.List;

public class Sale
{
	public static final int No_Discount = 1;
	public static final int Percent_Discount = 2;
	public static final int Threshold_Discount = 3;

	private int discountCode;
	private double percentage;
	private ThresholdData thresholdData;
	private double total;
	
	private List<Item> items = new ArrayList<>();

	public Sale()
	{
		discountCode = No_Discount;
		total = 0;
	}

	public void addItem(Item item)
	{
		items.add(item);
		total += item.getSubTotal();
	}

	public double getTotalWithDiscount()
	{
		if (discountCode == Percent_Discount)
		{
			total -= total * percentage;
		} else if (discountCode == Threshold_Discount)
		{
			if (total > thresholdData.getThresholdAmount())
				total -= thresholdData.getDiscountAmount();
		}
		return total;
	}

	public void setDiscountCode(int code)
	{
		this.discountCode = code;
	}

	public void setPercentage(double percentage)
	{
		this.percentage = percentage;
	}

	public double getPercentage()
	{
		return percentage;
	}

	public ThresholdData getThresholdData()
	{
		return thresholdData;
	}

	public void setThresholdData(ThresholdData thresholdData)
	{
		this.thresholdData = thresholdData;
	}
}
