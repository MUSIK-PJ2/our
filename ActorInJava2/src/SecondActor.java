import akka.actor.UntypedActor;


public class SecondActor extends UntypedActor{

	
	@Override
	/**
	 * ���Ϳ� ���޵� �޼����� ó��
	 */
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500); // for Test
		System.out.println(message+"Second Actor is On!");
	}

}
