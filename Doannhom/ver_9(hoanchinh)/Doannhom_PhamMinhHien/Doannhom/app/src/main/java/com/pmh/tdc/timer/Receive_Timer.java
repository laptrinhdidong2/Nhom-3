package com.pmh.tdc.timer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Class nhận sự thay đổi thời gian
public class Receive_Timer extends BroadcastReceiver {

	public static final long SECOND = 1000;
	public static final long MINUTE = SECOND * 60;

	@Override
	public void onReceive(Context context, Intent intent) {
		String title = intent.getStringExtra(Util_Timer.TITLE_KEY);
		long millisecondsLeft = intent.getLongExtra(Util_Timer.MILLISECONDS_LEFT_KEY, 0);

		if (intent.getBooleanExtra(Util_Timer.CANCEL_ALARM_KEY, false)) {
			Util_Timer.stopTimer(context.getApplicationContext());
		} else if (millisecondsLeft <= SECOND) {
			Util_Timer.alertTimerHasFinished(context.getApplicationContext(),title);
		} else {
			int hours = Conversation_Time.getHoursFromMilliseconds(millisecondsLeft);
			int minutes = Conversation_Time.getMinutesFromMilliseconds(millisecondsLeft);
			int seconds = Conversation_Time.getSecondsFromMilliseconds(millisecondsLeft);
			if (hours > 0 || minutes > 0) {
				if (hours == 0 && minutes == 1 && seconds == 0) {
					millisecondsLeft -= SECOND;
					Util_Timer.setAlarm(context.getApplicationContext(), SECOND, millisecondsLeft, title);
				}
				else if (seconds > 0)
				{
					millisecondsLeft -= seconds * SECOND;
					Util_Timer.setAlarm(context.getApplicationContext(),
							(seconds * SECOND), millisecondsLeft, title);
				}
				else {
					millisecondsLeft -= MINUTE;
					Util_Timer.setAlarm(context.getApplicationContext(), MINUTE,millisecondsLeft, title);
				}
			}
			else {
				millisecondsLeft -= SECOND;
				Util_Timer.setAlarm(context.getApplicationContext(), SECOND,
						millisecondsLeft, title);
			}
			Util_Timer.updateNotificationContentText(
					context.getApplicationContext(), title, millisecondsLeft);
		}
	}
}
