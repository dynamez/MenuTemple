package com.example.dynam.menutemple;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MyService extends Service {
	int numMessages = 0;
	HashMap<String, String> queryValues;
	MenuReaderDbHelper controller = new MenuReaderDbHelper(this);
	//ProgressDialog prgDialog;

	public MyService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "Service was Created", Toast.LENGTH_LONG).show();

	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		Intent resultIntent = new Intent(this, MainActivity.class);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
				resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//		prgDialog = new ProgressDialog(this);
//		prgDialog.setMessage("Transferring Data from Remote MySQL DB and Syncing SQLite. Please wait...");
//		prgDialog.setCancelable(false);
		// System.out.println("antes de ");
		syncSQLiteMySQLDB();
		// System.out.println("despues de");
//		NotificationCompat.Builder mNotifyBuilder;
//		NotificationManager mNotificationManager;
//		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//		// Sets an ID for the notification, so it can be updated
//		int notifyID = 9001;
//		mNotifyBuilder = new NotificationCompat.Builder(this)
//				.setContentTitle("Alert")
//				.setContentText("You've received new messages.")
//				.setSmallIcon(R.drawable.ic_launcher);
//		// Set pending intent
//		mNotifyBuilder.setContentIntent(resultPendingIntent);
//		// Set Vibrate, Sound and Light
//		int defaults = 0;
//		defaults = defaults | Notification.DEFAULT_LIGHTS;
//		defaults = defaults | Notification.DEFAULT_VIBRATE;
//		defaults = defaults | Notification.DEFAULT_SOUND;
//		mNotifyBuilder.setDefaults(defaults);
//		// Set the content for Notification
//		mNotifyBuilder.setContentText(intent.getStringExtra("intntdata"));
//		// Set autocancel
//		mNotifyBuilder.setAutoCancel(true);
//		// Post a notification
//		mNotificationManager.notify(notifyID, mNotifyBuilder.build());
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

	}

	public void syncSQLiteMySQLDB() {
		// Create AsycHttpClient object
		AsyncHttpClient client = new AsyncHttpClient();
		// Http Request Params Object
		RequestParams params = new RequestParams();
		// Show ProgressBar
		//prgDialog.show();
		// Make Http call to getusers.php
		client.post("http://192.168.1.38:8080/mysqlsqlitesync/getusers.php", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// Hide ProgressBar
				//prgDialog.hide();
				// Update SQLite DB with response sent by getusers.php
				System.out.println("esto es" + response);
				updateSQLite(response);
			}

			// When error occured
			@Override
			public void onFailure(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				// Hide ProgressBar
				//prgDialog.hide();
				if (statusCode == 404) {
					Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
				} else if (statusCode == 500) {
					Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public void updateSQLite(String response) {
		ArrayList<HashMap<String, String>> usersynclist;
		usersynclist = new ArrayList<HashMap<String, String>>();
		// Create GSON object
		Gson gson = new GsonBuilder().create();
		try {
			// Extract JSON array from the response
			JSONArray arr = new JSONArray(response);
			//System.out.println(arr.length());
			// If no of array elements is not zero
			if (arr.length() != 0) {
				// Loop through each array element, get JSON object which has userid and username
				for (int i = 0; i < arr.length(); i++) {
					// Get JSON object
					JSONObject obj = (JSONObject) arr.get(i);

					// DB QueryValues Object to insert into SQLite
					queryValues = new HashMap<String, String>();
					// Add userID extracted from Object
					queryValues.put("id", obj.get("id").toString());
					// Add userName extracted from Object
					queryValues.put("name", obj.get("name").toString());
					//System.out.println(obj.get("name").toString());
					// Add description extracted from Object
					queryValues.put("description", obj.get("description").toString());
					// Add description2 extracted from Object
					queryValues.put("description2", obj.get("description2").toString());
					// Add price extracted from Object
					queryValues.put("price", obj.get("price").toString());
					// Add category extracted from Object
					queryValues.put("category", obj.get("category").toString());
					// Add foto2 extracted from Object
					queryValues.put("foto2", obj.get("foto2").toString());
					// Insert User into SQLite DB
					controller.insertUser(queryValues);
					HashMap<String, String> map = new HashMap<String, String>();
					// Add status for each User in Hashmap
					map.put("id", obj.get("id").toString());
					map.put("status", "1");
					usersynclist.add(map);
				}
				// Inform Remote MySQL DB about the completion of Sync activity by passing Sync status of Users
				updateMySQLSyncSts(gson.toJson(usersynclist));
				// Reload the Main Activity
				//reloadActivity();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to inform remote MySQL DB about completion of Sync activity
	public void updateMySQLSyncSts(String json) {
		System.out.println(json);
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		params.put("syncsts", json);
		// Make Http call to updatesyncsts.php with JSON parameter which has Sync statuses of Users
		client.post("http://192.168.1.38:8080/mysqlsqlitesync/updatesyncsts.php", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				Toast.makeText(getApplicationContext(), "MySQL DB has been informed about Sync activity", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onFailure(int statusCode, Throwable error, String content) {
				Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_LONG).show();
			}
		});
	}

	// Reload MainActivity
	public void reloadActivity() {
		Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(objIntent);
	}
}