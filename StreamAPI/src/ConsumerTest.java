import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;


public class ConsumerTest {

	static List<UserVO> list = (List<UserVO>)Arrays.asList(
			new UserVO("정현근","34"),
			new UserVO("박완석","34"),
			new UserVO("김지민","32"),
			new UserVO("이용규","29")
			);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Consumer<T> : 함수형 인터페이스 소비자 
		// 리턴 값이 없다.
		Consumer<String> strcon = t -> System.out.println(t + t);
		Consumer<Integer> intcon = t -> System.out.println(t + t);
		strcon.accept("str");
		intcon.accept(4);
		
		
		//Supplier 인터페이스 
		//매개변수가 없고 리턴값이 있다.
		IntSupplier intsup = () ->{
			int num = (int) (Math.random() * 10)+ 1;
			return num;
		};
		Supplier<String> strsup = () -> {
			String str = "우리의꿈은 고급진 자바 개발자";
			return str;
		};
		
		int value = intsup.getAsInt();
		String string = strsup.get();
		
		System.out.println(value);
		System.out.println(string);
		
		
		//Function 인터페이스
		System.out.println("[이름]");
	    printString( t -> t.getName());
	   
		
		
	}
	public static void printString(Function<UserVO,String> function){
		for(UserVO user:list){
			System.out.print(function.apply(user)+ " ");
		}
		System.out.println();
	}
}
