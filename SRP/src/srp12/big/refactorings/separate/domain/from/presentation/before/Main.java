package srp12.big.refactorings.separate.domain.from.presentation.before;

public class Main
{
	private static CmdUI ui;

	public static void main(String[] args)
	{
		ui = new CmdUI();
		ui.start();
	}
}


