package com.example.spark.viewpagerdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;


public class ReminderNotification {

    private static final String NOTIFICATION_TAG = "Reminder";

    private static final int NOTIFICATION_PENDING_INTENT_ID = 247;

    public static void notify(final Context context) {
        final Resources res = context.getResources();

        // This image is used as the notification's large icon (thumbnail).
        // TODO: Remove this if your notification has no relevant thumbnail.
        final Bitmap picture = BitmapFactory.decodeResource(res, R.drawable.clipboard);


        final String ticker = "";
        final String title = res.getString(
                R.string.reminder_notification_title_template);
        final String text = res.getString(
                R.string.reminder_notification_placeholder_text_template);

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context)

                // Set appropriate defaults for the notification light, sound,
                // and vibration.
                .setDefaults(Notification.DEFAULT_VIBRATE)

                // Set required fields, including the small icon, the
                // notification title, and text.
                .setSmallIcon(R.drawable.ic_stat_reminder)
                .setContentTitle(title)
                .setContentText(text)

                // All fields below this line are optional.

                // Use a default priority (recognized on devices running Android
                // 4.1 or later)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

//                .setLargeIcon(picture)

                // Set ticker text (preview) information for this notification.
                .setTicker(ticker)

                .setContentIntent(
                        PendingIntent.getActivity(
                                context,
                                NOTIFICATION_PENDING_INTENT_ID,
                                new Intent(context, MainActivity.class),
                                PendingIntent.FLAG_UPDATE_CURRENT))
                // Example additional actions for this notification. These will
                // only show on devices running Android 4.1 or later, so you
                // should ensure that the activity in this notification's
                // content intent provides access to the same actions in
                // another way.
//                .addAction(
//                        R.drawable.ic_action_stat_share,
//                        res.getString(R.string.action_share),
//                        PendingIntent.getActivity(
//                                context,
//                                0,
//                                Intent.createChooser(new Intent(Intent.ACTION_SEND)
//                                        .setType("text/plain")
//                                        .putExtra(Intent.EXTRA_TEXT, "Dummy text"), "Dummy title"),
//                                PendingIntent.FLAG_UPDATE_CURRENT))
//                .addAction(
//                        R.drawable.ic_action_stat_reply,
//                        res.getString(R.string.action_reply),
//                        null)

                // Automatically dismiss the notification when it is touched.
                .setAutoCancel(true);

        notify(context, builder.build());
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private static void notify(final Context context, final Notification notification) {
        final NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_TAG, 0, notification);
    }

    /**
     * Cancels any notifications of this type previously shown using
     * {@link #notify(Context)}.
     */
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static void cancel(final Context context) {
        final NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(NOTIFICATION_TAG, 0);
    }
}
