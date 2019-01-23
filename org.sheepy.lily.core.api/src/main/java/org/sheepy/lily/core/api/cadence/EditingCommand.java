package org.sheepy.lily.core.api.cadence;

public abstract class EditingCommand
{

	private String label = "";

	public EditingCommand()
	{
		this.label = getClass().getName();
	}

	public EditingCommand(String label)
	{
		this.label = label;
	}

	/**
	 * Prepare some stuff before the command is truely executed.
	 * 
	 * The command will not be executed if doPrepare() returns false.
	 * 
	 * @return
	 */
	@SuppressWarnings("static-method")
	public boolean doPrepare()
	{
		return true;
	}

	public abstract void execute();

	public String getLabel()
	{
		return label;
	}

	/**
	 * While this method return true, the command will stay on the command
	 * stack.
	 * 
	 * @return
	 */
	@SuppressWarnings("static-method")
	public boolean keepInStack()
	{
		return false;
	}
}
