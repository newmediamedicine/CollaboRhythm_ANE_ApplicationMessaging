package collaboRhythm.ane.applicationMessaging.android;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SendBroadcastFunction implements FREFunction
{
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		try
		{
			String actionName = arg1[0].getAsString();
			String message = arg1.length > 1 ? arg1[1].getAsString() : null;
			String customData = arg1.length > 2 ? arg1[2].getAsString() : null;

			Intent broadcastIntent = new Intent(actionName);
			if (message != null)
			{
				broadcastIntent.putExtra("message", message);
			}
			if (customData != null)
			{
				broadcastIntent.putExtra("customData", customData);
			}
			Log.d("SendBroadcastFunction", "sending " + actionName + " message " + message);

			arg0.getActivity().getApplicationContext().sendBroadcast(broadcastIntent);

		} catch (Exception e)
		{
			Log.e("SendBroadcastFunction", e.toString());
		}
		return null;
	}
}