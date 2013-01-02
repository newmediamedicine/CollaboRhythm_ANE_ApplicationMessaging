package collaboRhythm.ane.applicationMessaging.actionScript
{

	import flash.external.ExtensionContext;

	public class ApplicationMessaging
	{
		private var context:ExtensionContext;

		public function ApplicationMessaging()
		{
			context = ExtensionContext.createExtensionContext(
					"CollaboRhythm.ANE.ApplicationMessaging", "type");
		}

		public function intent(packageName:String = ""):void
		{
			if (packageName != "")
			{
				context.call("intent", packageName);
			}
		}

		public function sendBroadcast(actionName:String = null, message:String = null, customData:String = null):void
		{
			if (actionName != null)
			{
				context.call("sendBroadcast", actionName, message, customData);
			}
		}

		public function dispose():void
		{
			return context.dispose();
		}
	}
}
