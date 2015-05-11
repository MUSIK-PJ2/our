import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;


public class ConsumerTest {

	static List<UserVO> list = (List<UserVO>)Arrays.asList(
			new UserVO("������","34"),
			new UserVO("�ڿϼ�","34"),
			new UserVO("������","32"),
			new UserVO("�̿��","29")
			);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Consumer<T> : �Լ��� �������̽� �Һ��� 
		// ���� ���� ����.
		Consumer<String> strcon = t -> System.out.println(t + t);
		Consumer<Integer> intcon = t -> System.out.println(t + t);
		strcon.accept("str");
		intcon.accept(4);
		
		
		//Supplier �������̽� 
		//�Ű������� ���� ���ϰ��� �ִ�.
		IntSupplier intsup = () ->{
			int num = (int) (Math.random() * 10)+ 1;
			return num;
		};
		Supplier<String> strsup = () -> {
			String str = "�츮�ǲ��� ����� �ڹ� ������";
			return str;
		};
		
		int value = intsup.getAsInt();
		String string = strsup.get();
		
		System.out.println(value);
		System.out.println(string);
		
		
		//Function �������̽�
		System.out.println("[�̸�]");
	    printString( t -> t.getName());
	   
		
		
	}
	public static void printString(Function<UserVO,String> function){
		for(UserVO user:list){
			System.out.print(function.apply(user)+ " ");
		}
		System.out.println();
	}
}
