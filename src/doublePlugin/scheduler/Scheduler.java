package doublePlugin.scheduler;

import org.bukkit.Bukkit;

import doublePlugin.DoublePlugin;

public class Scheduler {
	//일정시간뒤에 작동
	public static void delayScheduler(final RunnableEx task, int startDelayTick) {
		task.setTaskId(Bukkit.getScheduler().scheduleSyncDelayedTask(DoublePlugin.plugin, task, startDelayTick));
	}
	
	//일정시간마다 반복
	public static void repeatDelayScheduler(final RunnableEx task, int delayTick, int repeat) {
		repeatDelayScheduler(task, 0, delayTick, repeat);
	}
	
	//일정시간뒤에 일정시간마다 반복
	public static void repeatDelayScheduler(final RunnableEx task, int startDelayTick, int delayTick, int repeat) {
		task.setRepeat(repeat);
		task.setTaskId(Bukkit.getScheduler().scheduleSyncRepeatingTask(DoublePlugin.plugin, task, startDelayTick, delayTick));
	}

	//영구적인 무한반복 가급적 사용을하지 말것
	public static void infiniteRepeatScheduler(final RunnableEx task, int startDelayTick, int delayTick) {
		task.setTaskId(Bukkit.getScheduler().scheduleSyncRepeatingTask(DoublePlugin.plugin, task, startDelayTick, delayTick));
	}
}
