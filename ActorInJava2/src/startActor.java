import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


public class startActor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubs
		
		if(args != null){
			System.out.println(args);
		}
		ActorSystem system = ActorSystem.create("printer");
		ActorSystem second = ActorSystem.create("second");
		ActorSystem third = ActorSystem.create("third");
		ActorRef print = system.actorOf(Props.create(PrintActor.class),"printerActor");
		ActorRef secondActor = second.actorOf(Props.create(PrintActor.class),"secondActor");
		ActorRef thirdActor = third.actorOf(Props.create(ThirdActor.class),"thirdActor");
		
		
		print.tell("ssss",ActorRef.noSender());
		Thread.sleep(1000);
		print.tell("2222", secondActor);
		//print.tell("ssss",thirdActor);
		//thirdActor.tell("third First!", print);
		
		
	}

}
