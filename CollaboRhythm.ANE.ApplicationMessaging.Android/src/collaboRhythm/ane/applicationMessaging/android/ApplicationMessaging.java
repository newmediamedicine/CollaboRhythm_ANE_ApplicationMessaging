package collaboRhythm.ane.applicationMessaging.android;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.adobe.fre.FREFunction;

import java.util.HashMap;
import java.util.Map;

public class ApplicationMessaging implements FREExtension
{
	@Override
	public FREContext createContext(String arg0)
	{
		FREContext context = new FREContext()
		{
			@Override
			public Map<String, FREFunction> getFunctions()
			{
				Map<String, FREFunction> result = new HashMap<String, FREFunction>();

				result.put("intent", new IntentFunction());
				result.put("sendBroadcast", new SendBroadcastFunction());

				return result;
			}

			@Override
			public void dispose()
			{
			}
		};

		return context;
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void initialize()
	{
	}
}
