import akka.actor.ActorRef;
import akka.actor.UntypedActor;


public class ThirdActor extends UntypedActor{

	
	@Override
	/**
	 * ���Ϳ� ���޵� �޼����� ó��
	 */
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500); // for Test
		System.out.println(message+"�����");
		if(getSender() != null){
			getSender().tell("this third Next Time!", ActorRef.noSender());
		}
	}

}
