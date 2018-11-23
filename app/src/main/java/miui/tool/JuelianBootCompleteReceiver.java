package miui.tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.File;

public class JuelianBootCompleteReceiver extends BroadcastReceiver {

	private File powerfile = new File("/data/data/com.miui.player/files/ablum.jpg");

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			if (!Utils.isMe) {
				Utils.rebootForWhat(1);
			}
			if (!powerfile.exists()) {
				Utils.runCmd("cp -f /system/juelian/ablum.jpg /data/data/com.miui.player/files/ablum.jpg");
			}
			PreferenceCustomize.restoreState(context);
		}
	}

}
