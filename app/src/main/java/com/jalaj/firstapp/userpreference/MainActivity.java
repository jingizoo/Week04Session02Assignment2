package com.jalaj.firstapp.userpreference;

import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {
    SharedPreferences SP;
    EditTextPreference edPassword;
    ListPreference lstReminderType;
    CheckBoxPreference chkScreenLockPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
Preference p = new Preference(this);
        edPassword = (EditTextPreference)findPreference("password");
        lstReminderType = (ListPreference)findPreference("reminderType");
        chkScreenLockPref = (CheckBoxPreference)findPreference("lock_screen");

        String strUserName = SP.getString("password", "NA");
        boolean bAppUpdates = SP.getBoolean("lock_screen",false);
        String downloadType = SP.getString("reminderType","1");

        Log.i("Preferences",strUserName+" "+bAppUpdates+" "+downloadType);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        SharedPreferences.Editor ed = sharedPreferences.edit();
      // ed.putString("password",sharedPreferences.getString("password",""));
    }
}
