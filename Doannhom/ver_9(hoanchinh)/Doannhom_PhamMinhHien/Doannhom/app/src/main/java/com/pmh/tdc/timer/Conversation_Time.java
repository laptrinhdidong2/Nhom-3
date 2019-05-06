package com.pmh.tdc.timer;

import android.util.Log;

// Class chuyển đổi thời gian nhập vào
public class Conversation_Time {

	// Lấy chuỗi thời gian - ở mili giấy
	public static String getTimeStringFromMilliseconds(long milliseconds) {
		String seconds = Integer.toString(getSecondsFromMilliseconds(milliseconds));
		String minutes = Integer.toString(getMinutesFromMilliseconds(milliseconds));
		String hours = Integer.toString(getHoursFromMilliseconds(milliseconds));
		for (int i = 0; i < 2; i++) {
			if (seconds.length() < 2) {
				seconds = "0" + seconds;
			}
			if (minutes.length() < 2) {
				minutes = "0" + minutes;
			}
			if (hours.length() < 2) {
				hours = "0" + hours;
			}
		}
		return hours + ":" + minutes + ":" + seconds;
	}
	// Chuyển giờ - thành giây
	public static int getHoursFromMilliseconds(long milliseconds) {
		long time = milliseconds / 1000;
		return (int) (time / 3600);
	}
	// Chuyển phút thành giây
	public static int getMinutesFromMilliseconds(long milliseconds) {
		long time = milliseconds / 1000;
		return (int) ((time % 3600) / 60);
	}
	// Lấy số giây
	public static int getSecondsFromMilliseconds(long milliseconds) {
		long time = milliseconds / 1000;
		return (int) (time % 60);
	}
	// Chuyển đổi chuối sang giây
	public static long convertStringToMilliseconds(String time) {
		int seconds = getSecondsFromTimeString(time);
		int minutes = getMinutesFromTimeString(time);
		int hours = getHoursFromTimeString(time);
		Log.i("AlarmUtil", "Converted " + time + " into " + hours + " hours, "
				+ minutes + " minutes, " + seconds + " seconds");
		return ((seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000));
	}


	public static Integer getHoursFromTimeString(String time) {
		if (time.length() > 4) {
			return Integer.parseInt(time.substring(0, time.length() - 4));
		} else {
			return 0;
		}
	}

	public static Integer getMinutesFromTimeString(String time) {
		if (time.length() > 2) {
			if (time.length() >= 4) {
				return Integer.parseInt(time.substring(time.length() - 4,
						time.length() - 2));
			} else {
				return Integer.parseInt(time.substring(0, time.length() - 2));
			}
		} else {
			return 0;
		}
	}

	public static Integer getSecondsFromTimeString(String time) {
		if (time.length() >= 2) {
			return Integer.parseInt(time.substring(time.length() - 2));
		} else if (time.length() > 0) {
			return Integer.parseInt(time);
		} else {
			return 0;
		}
	}
}
