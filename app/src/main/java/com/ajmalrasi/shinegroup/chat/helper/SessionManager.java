package com.ajmalrasi.shinegroup.chat.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ajmalrasi.shinegroup.chat.model.Member;

/**
 * Created by Rasi on 06-02-2018.
 */

public class SessionManager {

    private String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "shine_group";

    // All Shared Preferences Keys
    private static final String KEY_MEMBER_ID = "member_id";
    private static final String KEY_MEMBER_NAME = "member_name";
    private static final String KEY_MEMBER_EMAIL = "member_email";
    private static final String KEY_MEMBER_DP = "member_dp";
    private static final String KEY_MEMBER_CREATED = "member_created";
    private static final String KEY_MEMBER_LOGGED_IN = "member_logged_in";
    private static final String KEY_NOTIFICATIONS = "notifications";

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    /**
     * Store Member data in Shared Preference
     * @param member
     */
    public void storeMember(Member member) {
        editor.putString(KEY_MEMBER_ID, member.getId());
        editor.putString(KEY_MEMBER_NAME, member.getName());
        editor.putString(KEY_MEMBER_EMAIL, member.getEmail());
        editor.putString(KEY_MEMBER_CREATED, member.getCreated());
        editor.putString(KEY_MEMBER_DP, member.getDp());
        editor.putBoolean(KEY_MEMBER_LOGGED_IN,true);
        editor.commit();

        Log.e(TAG, "Member is stored in shared preferences. " + member.getName() + ", " + member.getEmail());
    }

    /**
     * Retrieve Member information from Shared Preference
     * @return Member
     */
    public Member getMember() {
        if (pref.getString(KEY_MEMBER_ID, null) != null) {
            String id, name, email, created, dp;
            id = pref.getString(KEY_MEMBER_ID, null);
            name = pref.getString(KEY_MEMBER_NAME, null);
            email = pref.getString(KEY_MEMBER_EMAIL, null);
            created = pref.getString(KEY_MEMBER_CREATED, null);
            dp = pref.getString(KEY_MEMBER_DP, null);

            return new Member(id, name, email, created, dp);
        }
        return null;
    }

    /**
     *
     * @return bool
     */
    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_MEMBER_LOGGED_IN,false);
    }

    /**
     *
     * @param notification
     */
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

    /**
     *
     * @return
     */
    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS, null);
    }

    /**
     * Delete data stored in Shared Preference
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }
}