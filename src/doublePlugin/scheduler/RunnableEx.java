package doublePlugin.scheduler;

import org.bukkit.Bukkit;

public abstract class RunnableEx implements Runnable {
	private int taskId;
	private int repeat = Integer.MAX_VALUE;
	private int count;
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
	
	public int getCount() {
		return this.count;
	}

	@Override
	public void run() {
		if(this.repeat <= this.count) {
			stop();
		}
		
		function();
		this.count++;
	}
	
	public abstract void function();
	
	public void stop() {
		Bukkit.getScheduler().cancelTask(this.taskId);
	}
}
