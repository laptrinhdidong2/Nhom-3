package com.pmh.tdc.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import com.pmh.tdc.R;
import com.pmh.tdc.TimerModel;

// Class Sử dụng thời gian
public class Util_Timer {
	public static final String MILLISECONDS_LEFT_KEY = "ms_left"; // Chuỗi thời gian
	public static final String TITLE_KEY = "timer_title"; //tiêu đề
	public static final String CANCEL_ALARM_KEY = "cancel_alarm"; // chuỗi cancel
	private static final int NOTIFICATION_ID = 4439; // ID cảnh báo
	private static final int PENDING_INTENT_ID = 94549; // ID Pending Intent


	// Hàm dừng thời gian lại
	public static void stopTimer(Context applicationContext) {
		getAlarmManager(applicationContext).cancel(PendingIntent.getBroadcast(
				applicationContext,
				PENDING_INTENT_ID,
				new Intent(applicationContext, Receive_Timer.class),
				PendingIntent.FLAG_CANCEL_CURRENT));
		getNotificationManager(applicationContext).cancel(NOTIFICATION_ID);
		getApplication(applicationContext).stopNotifyingUser();
	}

	// Hàm cài đặt chuông báo
	public static void setAlarm(Context applicationContext,
			long millisecondsUntilAlarm, long totalMillisecondsLeft, String title) {
		// Set when alarm will go off
		Calendar alarmTime = Calendar.getInstance();
		alarmTime.add(Calendar.SECOND, (int) (millisecondsUntilAlarm / 1000));
		// Set alarm
		getAlarmManager(applicationContext).set(
				AlarmManager.RTC_WAKEUP,
				alarmTime.getTimeInMillis(),
				getTimerPendingIntent(applicationContext,
						totalMillisecondsLeft, title, false));
	}
	// Lấy tiêu đề cảnh báo
	public static String getNotificationTitleText(Context applicationContext,
			String timerName, long milliseconds) {
		Calendar time = Calendar.getInstance();
		time.add(Calendar.SECOND, (int) (milliseconds / 1000));
		SimpleDateFormat sdf;
		if (PreferenceManager.getDefaultSharedPreferences(applicationContext)
				.getBoolean(
						applicationContext.getResources().getString(
								R.string.key_twenty_four_hour), false)) {
			sdf = new SimpleDateFormat("kk:mm:ss", Locale.getDefault());
		} else {
			sdf = new SimpleDateFormat("h:mm:ss aa", Locale.getDefault());
		}
		return timerName + " - " + sdf.format(time.getTime());
	}
	// Lấy thời gian chạy chính
	public static String getTimeRemainingText(Context applicationContext,
			long millisecondsLeft) {
		int hours = Conversation_Time
				.getHoursFromMilliseconds(millisecondsLeft);
		int minutes = Conversation_Time
				.getMinutesFromMilliseconds(millisecondsLeft);
		int seconds = Conversation_Time
				.getSecondsFromMilliseconds(millisecondsLeft);
		if (hours > 0 || minutes > 0) {
			return getHoursMinutesText(applicationContext, hours, minutes);
		}
		return getSecondsText(applicationContext, seconds);
	}

	private static String getHoursMinutesText(Context applicationContext,
			int hours, int minutes) {
		Resources res = applicationContext.getResources();
		String result = "";
		if (hours > 1) {
			result = result.concat(hours + " " + res.getString(R.string.hours)
					+ " ");
		} else if (hours == 1) {
			result = result.concat(hours + " " + res.getString(R.string.hour)
					+ " ");
		}
		if (minutes > 1) {
			result = result.concat(minutes + " "
					+ res.getString(R.string.minutes) + " ");
		} else if (minutes == 1) {
			result = result.concat(minutes + " "
					+ res.getString(R.string.minute) + " ");
		}
		result = result.concat(res.getString(R.string.remaining));
		return result;
	}

	private static String getSecondsText(Context applicationContext, int seconds) {
		Resources res = applicationContext.getResources();
		String result = "";
		if (seconds > 1) {
			result = result.concat(seconds + " " + res.getString(R.string.seconds) + " ");
		} else if (seconds == 1) {
			result = result.concat(seconds + " " + res.getString(R.string.second) + " ");
		}
		result = result.concat(res.getString(R.string.remaining));
		return result;
	}

	 // Cập nhật Notification
	public static void updateNotificationContentText(
			Context applicationContext, String title, long milliseconds) {
		getNotificationManager(applicationContext).notify(
				NOTIFICATION_ID,
				getNotificationBuilder(applicationContext, title,
						getTimeRemainingText(applicationContext, milliseconds))
						.build());
	}
	// CKết thúc cảnh báo
	public static void alertTimerHasFinished(Context applicationContext,
			String title) {
		NotificationCompat.Builder builder = getNotificationBuilder(
				applicationContext, title, applicationContext.getResources()
						.getString(R.string.notification_done_text));

		builder.setOngoing(false).setDeleteIntent(
				getTimerPendingIntent(applicationContext, 0, title, true));
		getNotificationManager(applicationContext).notify(NOTIFICATION_ID,
				builder.build());
		getApplication(applicationContext).notifyUser();
	}
	//
	private static NotificationCompat.Builder getNotificationBuilder(
			Context applicationContext, String title, String content) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				applicationContext);
		Intent notificationIntent = new Intent(applicationContext,
				DemNguocActivity.class);
		notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent contentIntent = PendingIntent.getActivity(
				applicationContext, 0, notificationIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		int icon = R.drawable.ic_alarm_24dp;
		long when = System.currentTimeMillis();

		builder.setSmallIcon(icon)
				.setContentTitle(title)
				.setContentText(content)
				.setWhen(when)
				.setOngoing(true)
				.setTicker(
						applicationContext.getResources().getString(
								R.string.notification_popup_msg))
				.setContentIntent(contentIntent);

		return builder;
	}

	private static PendingIntent getTimerPendingIntent(
			Context applicationContext, long millisecondsLeft, String title,
			boolean cancelAlarm) {
		Intent intent = new Intent(applicationContext, Receive_Timer.class);
		intent.putExtra(MILLISECONDS_LEFT_KEY, millisecondsLeft);
		intent.putExtra(TITLE_KEY, title);
		intent.putExtra(CANCEL_ALARM_KEY, cancelAlarm);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(
				applicationContext, PENDING_INTENT_ID, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		return pendingIntent;
	}

	private static TimerModel getApplication(
			Context applicationContext) {
		return (TimerModel) applicationContext;
	}

	private static AlarmManager getAlarmManager(Context applicationContext) {
		return (AlarmManager) applicationContext
				.getSystemService(Context.ALARM_SERVICE);
	}

	private static NotificationManager getNotificationManager(
			Context applicationContext) {
		return (NotificationManager) applicationContext
				.getSystemService(Context.NOTIFICATION_SERVICE);
	}
}
