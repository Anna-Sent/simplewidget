package com.anna.sent.soft.simplewidget;

import java.text.DateFormat;
import java.util.Calendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

/**
 * Define a simple widget that shows a text.
 */
public class SimpleWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Calendar today = Calendar.getInstance();

		// Update each of the widgets with the remote adapter
		for (int i = 0; i < appWidgetIds.length; ++i) {
			RemoteViews views = buildViews(context, today);
			appWidgetManager.updateAppWidget(appWidgetIds[i], views);
		}

		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	public static RemoteViews buildViews(Context context, Calendar today) {
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.simple_widget);
		views.setTextViewText(
				R.id.widgetTextView,
				context.getResources().getString(R.string.last_update_time,
						DateFormat.getInstance().format(today.getTime())));
		return views;
	}
}
