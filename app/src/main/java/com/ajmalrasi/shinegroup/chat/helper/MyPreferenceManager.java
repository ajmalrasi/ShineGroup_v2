package com.ajmalrasi.shinegroup.chat.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ajmalrasi.shinegroup.chat.model.Member;

/**
 * Created by Rasi on 06-02-2018.
 */

public class MyPreferenceManager {

    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "shinegroup_gcm";

    // All Shared Preferences Keys
    private static final String KEY_MEMBER_ID = "member_id";
    private static final String KEY_MEMBER_NAME = "user_name";
    private static final String KEY_MEMBER_EMAIL = "user_email";
    private static final String KEY_NOTIFICATIONS = "notifications";

    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void storeMember(Member member) {
        editor.putString(KEY_MEMBER_ID, member.getId());
        editor.putString(KEY_MEMBER_NAME, member.getName());
        editor.putString(KEY_MEMBER_EMAIL, member.getEmail());
        editor.commit();

        Log.e(TAG, "User is stored in shared preferences. " + member.getName() + ", " + member.getEmail());
    }

    public Member getMember() {
        if (pref.getString(KEY_MEMBER_ID, null) != null) {
            String id, name, email;
            id = pref.getString(KEY_MEMBER_ID, null);
            name = pref.getString(KEY_MEMBER_NAME, null);
            email = pref.getString(KEY_MEMBER_EMAIL, null);

            Member member = new Member(id, name, email);
            return member;
        }
        return null;
    }


    public void addNotification(String notification) {

        // get old notifications
        String oldNotifications = getNotifications();

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }

        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS, null);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}