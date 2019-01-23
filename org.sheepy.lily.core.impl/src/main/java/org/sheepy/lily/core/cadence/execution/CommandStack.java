package org.sheepy.lily.core.cadence.execution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.sheepy.lily.core.api.cadence.EditingCommand;
import org.sheepy.lily.core.api.cadence.ICommandStack;

public class CommandStack implements ICommandStack
{

	private LilyTransaction currentTransaction = null;
	public Deque<EditingCommand> commands = new ConcurrentLinkedDeque<>();

	private final HashMap<String, Long> times = new HashMap<>();
	private final List<EditingCommand> keptCommands = new ArrayList<>();

	public CommandStack()
	{
	}

	@Override
	public void add(EditingCommand command)
	{
		commands.add(command);
	}

	public void execute()
	{
		if (commands.isEmpty() == false)
		{
			LilyTransaction previousTransaction = currentTransaction;
			currentTransaction = new LilyTransaction();
			keptCommands.clear();

			try
			{
				for (EditingCommand lilyEditingCommand; (lilyEditingCommand = commands
						.poll()) != null;)
				{
					long duration = System.nanoTime();
					if (lilyEditingCommand.doPrepare())
					{
						lilyEditingCommand.execute();
					}

					if (lilyEditingCommand.keepInStack())
					{
						keptCommands.add(lilyEditingCommand);
					}

					duration = System.nanoTime() - duration;
					Long totalDuration = times.get(lilyEditingCommand.getLabel());
					if (totalDuration == null)
					{
						times.put(lilyEditingCommand.getLabel(), duration);
					}
					else
					{
						times.put(lilyEditingCommand.getLabel(), totalDuration + duration);
					}
				}

			} catch (Exception e)
			{
				e.printStackTrace();
			}

			commands.addAll(keptCommands);

			currentTransaction = previousTransaction;
		}
	}

	public ILilyTransaction getCurrentTransaction()
	{
		return currentTransaction;
	}

	@Override
	public void printStats()
	{
		System.out.println("========================================");
		System.out.println("Model commands times :");
		int total = 0;
		for (Entry<String, Long> entry : times.entrySet())
		{
			int val = (int) (entry.getValue() / 1_000_000);
			System.out.format("%s : %d ms\n", entry.getKey(), val);
			total += val;
		}

		System.out.format("Total : %d ms\n", total);

		System.out.println("========================================");
	}

}
