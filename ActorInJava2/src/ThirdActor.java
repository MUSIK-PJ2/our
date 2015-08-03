import akka.actor.ActorRef;
import akka.actor.UntypedActor;


public class ThirdActor extends UntypedActor{

	
	@Override
	/**
	 * 액터에 전달된 메세지를 처리
	 */
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500); // for Test
		System.out.println(message+"써드써드");
		if(getSender() != null){
			getSender().tell("this third Next Time!", ActorRef.noSender());
		}
	}

}
