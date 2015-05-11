import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class StreamAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<UserVO> list = Arrays.asList(
				new UserVO("김지민","32"),
				new UserVO("정현근","34"),
				new UserVO("박완석","34"),
				new UserVO("이용규","29"),
				new UserVO("이용규","29"));
		System.out.println(list);

		//age만 List 출력
		System.out.println(list.parallelStream().map(UserVO::getAge).collect(Collectors.toList()));
		
		//나이가 3으로 시작하는 UserVO 리스트 출력
		System.out.println(list.parallelStream().filter(n -> n.getAge().startsWith("3")).collect(Collectors.toList()));
		
		//컬렉션 객체중 Age 가 34 인 카운트
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.equals("34")).collect(Collectors.counting()));
		
		//컬렉션 객체중 나이가 29인 것을 찾아 중복제거후 age의 List 출력
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.equals("29")).distinct().collect(Collectors.toList()));
		
		//컬렉션 객체중 name 이 '박완석' 인 UserVO
		System.out.println(list.parallelStream().filter(n -> n.getName().equals("박완석")).collect(Collectors.toList()));
		
		///컬렉션 객체중 name이 '정현근' 인 UserVO
		System.out.println(list.parallelStream().filter(n -> n.getName().equalsIgnoreCase("정현근")).collect(Collectors.toList()));
		
		//컬렉션 객체중 age가 3으로 시작하는 것 구분자로 조인시켜 출력
		System.out.println(list.parallelStream().map(UserVO::getAge).filter(n -> n.startsWith("3")).collect(Collectors.joining(",")));
		
		//stream을 조작해서 새로운 stream을 생성 한후 각 행에대해서 출력
		List<String> strList = Arrays.asList("우리는 개발자","고급진 개발자");
		strList.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(str -> System.out.println(str));
		
		//stream 을 조작후 새로운 스트림을 생성 출력
		List<String> strList2 = Arrays.asList("10,20,30","40,50,60");
		strList2.stream().flatMapToInt(data ->{
			String[] strArr = data.split(",");
			int [] intArr = new int[strArr.length];
			for(int i=0;i<strArr.length;i++)
				intArr[i] = Integer.parseInt(strArr[i]);
			return Arrays.stream(intArr);
		}).forEach(n -> System.out.println(n));
		
		//숫자리스트
		List<Integer> iList = Arrays.asList(
				new Integer(5),
				new Integer(2),
				new Integer(3),
				new Integer(9),
				new Integer(8),
				new Integer(1));
		
		//컬렉션에서 2보다 크고 7보다 작은 숫자를 asc 로 소팅후 리스트 출력
		System.out.println(iList.stream().filter(t -> t<7 && t >2).sorted().collect(Collectors.toList()));
		//커렉션을 desc 로 소팅후 출력
		System.out.println(iList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
		
		//집계 평균 1. Optional 인터페이스 활용
		OptionalDouble optional = iList.stream().mapToInt(Integer::intValue).average();
		if(optional.isPresent()) System.out.println(optional.getAsDouble());
		//2.
		double avg = iList.stream().mapToInt(Integer:: intValue).average().orElse(0.0);
		System.out.println(avg);
		///3.
		iList.stream().mapToInt(Integer::intValue).average().ifPresent(t -> System.out.println(t));
		
		//reduce 활용 집계
		int sum = iList.stream().map(Integer::intValue).reduce(0,(a,b) -> a+b);
		System.out.println(sum);
		
		boolean result = iList.stream().allMatch(a -> a % 2 == 0);
		System.out.println("리스트는 모두 2의 배수인가?"+ result);
		result = iList.stream().anyMatch(a -> a%3 ==0);
		System.out.println("하나라도 3의 배수가 있는가?"+ result);
		result = iList.stream().noneMatch(a -> a %3 ==0);
		System.out.println("3의 배수는 하나도 없는가?" + result);
	}
}
