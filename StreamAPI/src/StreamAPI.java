import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class StreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<UserVO> list = Arrays.asList(
				new UserVO("������","32"),
				new UserVO("������","34"),
				new UserVO("�ڿϼ�","34"),
				new UserVO("�̿��","29"),
				new UserVO("�̿��","29"));
		System.out.println(list);

		//age�� List ���
		System.out.println(list.parallelStream().map(UserVO::getAge).collect(Collectors.toList()));
		
		//���̰� 3���� �����ϴ� UserVO ����Ʈ ���
		System.out.println(list.parallelStream().filter(n -> n.getAge().startsWith("3")).collect(Collectors.toList()));
		
		//�÷��� ��ü�� Age �� 34 �� ī��Ʈ
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.equals("34")).collect(Collectors.counting()));
		
		//�÷��� ��ü�� ���̰� 29�� ���� ã�� �ߺ������� age�� List ���
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.equals("29")).distinct().collect(Collectors.toList()));
		
		//�÷��� ��ü�� name �� '�ڿϼ�' �� UserVO
		System.out.println(list.parallelStream().filter(n -> n.getName().equals("�ڿϼ�")).collect(Collectors.toList()));
		
		///�÷��� ��ü�� name�� '������' �� UserVO
		System.out.println(list.parallelStream().filter(n -> n.getName().equalsIgnoreCase("������")).collect(Collectors.toList()));
		
		//�÷��� ��ü�� age�� 3���� �����ϴ� �� �����ڷ� ���ν��� ���
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.startsWith("3")).collect(Collectors.joining(",")));
		
		//stream�� �����ؼ� ���ο� stream�� ���� ���� �� �࿡���ؼ� ���
		List<String> strList = Arrays.asList("�츮�� ������","����� ������");
		strList.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(str -> System.out.println(str));
		
		//stream �� ������ ���ο� ��Ʈ���� ���� ���
		List<String> strList2 = Arrays.asList("10,20,30","40,50,60");
		strList2.stream().flatMapToInt(data ->{
			String[] strArr = data.split(",");
			int [] intArr = new int[strArr.length];
			for(int i=0;i<strArr.length;i++)
				intArr[i] = Integer.parseInt(strArr[i]);
			return Arrays.stream(intArr);
		}).forEach(n -> System.out.println(n));
		
		//���ڸ���Ʈ
		List<Integer> iList = Arrays.asList(
				new Integer(5),
				new Integer(2),
				new Integer(3),
				new Integer(9),
				new Integer(8),
				new Integer(1));
		
		//�÷��ǿ��� 2���� ũ�� 7���� ���� ���ڸ� asc �� ������ ����Ʈ ���
		System.out.println(iList.stream().filter(t -> t<7 && t >2).sorted().collect(Collectors.toList()));
		//Ŀ������ desc �� ������ ���
		System.out.println(iList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
		
		//���� ��� 1. Optional �������̽� Ȱ��
		OptionalDouble optional = iList.stream().mapToInt(Integer::intValue).average();
		if(optional.isPresent()) System.out.println(optional.getAsDouble());
		//2.
		double avg = iList.stream().mapToInt(Integer:: intValue).average().orElse(0.0);
		System.out.println(avg);
		///3.
		iList.stream().mapToInt(Integer::intValue).average().ifPresent(t -> System.out.println(t));
		
		//reduce Ȱ�� ����
		int sum = iList.stream().map(Integer::intValue).reduce(0,(a,b) -> a+b);
		System.out.println(sum);
		
		boolean result = iList.stream().allMatch(a -> a % 2 == 0);
		System.out.println("����Ʈ�� ��� 2�� ����ΰ�?"+ result);
		result = iList.stream().anyMatch(a -> a%3 ==0);
		System.out.println("�ϳ��� 3�� ����� �ִ°�?"+ result);
		result = iList.stream().noneMatch(a -> a %3 ==0);
		System.out.println("3�� ����� �ϳ��� ���°�?" + result);
	}
}
