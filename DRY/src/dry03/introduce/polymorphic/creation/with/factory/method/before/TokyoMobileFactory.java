package dry03.introduce.polymorphic.creation.with.factory.method.before;

/*
 * Produces "Thunder" and "Plus"
 */
public class TokyoMobileFactory
{
	public SSMobileProduct of(String model)
	{
		SSMobileProduct mobile = null;

		if (model.equalsIgnoreCase("Thunder"))
		{
			mobile = new SSMobileThunder();
			mobile.setPrice(500);
		} else if (model.equalsIgnoreCase("Plus"))
		{
			mobile = new SSMobilePlus();
			mobile.setPrice(250);
		}

		return mobile;
	}
}
