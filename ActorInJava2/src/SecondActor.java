import akka.actor.UntypedActor;


public class SecondActor extends UntypedActor{

	
	@Override
	/**
	 * 액터에 전달된 메세지를 처리
	 */
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500); // for Test
		System.out.println(message+"Second Actor is On!");
	}

}
