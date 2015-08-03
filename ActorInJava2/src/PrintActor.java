import akka.actor.ActorRef;
import akka.actor.UntypedActor;


public class PrintActor extends UntypedActor{

	
	@Override
	/**
	 * ���Ϳ� ���޵� �޼����� ó��
	 */
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(message + "Printer Actor is On!");
		Thread.sleep(500); // for Test
		System.out.println(message + "Printer Actor is Off!");
		System.out.println(getSender().toString());
		if(getSender() != null){
			System.out.println(getSender().toString() + "to send() !!");
			getSender().tell("next", ActorRef.noSender());
		}
		
	}

}
