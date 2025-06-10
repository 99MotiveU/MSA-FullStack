package com.my.sts;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sts23Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sts23Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Stream<String> stream = Stream.of("item1", "item2", "ITEM3","item2", "ITEM4");
//		List list=List.of("item1", "item2", "item3", "item4");
//		Stream stream=list.stream();
//		Set list=Set.of("item1", "item2", "item3", "item4");
//		Stream stream=list.stream();
//		List list=Arrays.asList("item1", "item2", "item3", "item4");
//		Stream stream=list.stream();
//		String[] array = {"a1", "a2", "b1", "b2", "c2", "c1"};
//		Stream<String> stream = Arrays.stream(array);
//		Stream<Integer> stream = Stream.generate(() -> 1+2).limit(5);
//		Stream<Integer> stream = Stream.iterate(0, n -> n+2).limit(5);
//		Stream<String> stream = 
//				Stream.<String>builder()
//				    .add("item1")
//				    .add("item2")
//				    .add("item3")
//				    .add("item4")
//				    .add("item5")
//				    .build();

//		IntStream intstream = IntStream.range(1, 5); // [1, 2, 3, 4]
////		LongStream stream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
//
//		Stream<Integer> stream = intstream.boxed();

//		IntStream stream = new Random().ints(3);
//		DoubleStream stream = new Random().doubles(3); // 난수 3개 생성

//		IntStream stream = 
//				  "Stream".chars(); // [83, 116, 114, 101, 97, 109]

//		Stream<String> stream = 
////		  Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
//		Arrays.stream("Eric, Elena, Java".split(", "));

//		File f=new File("./file.txt");
//		Stream<String> stream = 
////				  Files.lines(Paths.get("file.txt"), 
////				              Charset.forName("UTF-8"));
//		Files.lines(Paths.get(f.getAbsolutePath()), 
//				Charset.forName("UTF-8"));

//		stream=stream.distinct();
//		stream=stream.filter(a->a.startsWith("item"));
//		stream=stream.sorted((a,b)->b.compareTo(a));
//		stream=stream.map(a->{
//			System.out.println("중간 출력:"+a);
//			return a;});
//		stream=stream.peek(a->{System.out.println("중간 출력:"+a);});

//		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
//		List<String> chars = Arrays.asList("a", "b", "c", "d", "e");
//		Stream<String> stream1 = numbers.stream();
//		Stream<String> stream2 = chars.stream();
//		stream = Stream.concat(stream1, stream2);
//		stream.forEach(s -> System.out.println(s));
//		List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
//		Consumer result=System.out::println;
//		list.stream().forEach(result);

//		int[] intArr = { 2, 4 ,6,3};
//		boolean result = Arrays.stream(intArr)
//		            .allMatch(a -> a%2==0); // and
//					.anyMatch(a -> a%2!=0); // or
//					.noneMatch(a -> a%2!=0); // not
//		System.out.println("모두 2의 배수인가? " + result);
//		IntStream stream = IntStream.range(1, 101);
//        stream.forEach(a -> sum += a);
//        System.out.println("총합: " + sum);
//		IntStream.range(10, 21)
//        .min().ifPresent(System.out::println);
//		IntStream.range(10, 21)
//        .max().ifPresent(System.out::println);
//		IntStream.range(10, 21)
//		.average().ifPresent(System.out::println);
//		sum=IntStream.range(10, 21)
//		.sum();
//		IntStream.range(10, 21)
//		.average().ifPresent(System.out::println);
//		long su = IntStream.range(10, 21)
//		.count();
//        System.out.println("총합: " + sum);
//        System.out.println("개수: " + su);
//        
//        sum=IntStream.range(10, 21).reduce((a,b)->a+b).getAsInt();
//        System.out.println(sum);
//		List<String> langs = Arrays.asList("1", "2", "3", "4", "5");
//
//		Stream<String> stream = langs.stream();
//		Optional<String> op = stream
//		        .reduce((a,b)->String.valueOf(
//		                        Integer.parseInt(a)+Integer.parseInt(b)));
//		System.out.println(op.get());
//
//		IntStream stream2= langs.stream()
////		        .mapToInt(Integer::parseInt)
//		        .mapToInt(a->Integer.parseInt(a));
//		System.out.println(stream2.reduce((a,b)->a+b).getAsInt());
////
//		Stream<Integer> stream3 = langs.stream().map(Integer::parseInt);
//		Optional<Integer> op3 = stream3.reduce((a,b)->a+b);
//		System.out.println(op3.get());
//		
//		
//		System.out.println(
//				langs.stream().map(Integer::parseInt).reduce((a,b)->a+b).get()
//				);

		Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
//		List<String> list = stream.collect(Collectors.toList());
//		Set<String> list = stream.collect(Collectors.toSet());
//		Map<String, String> list = stream.collect(Collectors.toMap(a -> a, a -> a.toUpperCase()));
//		String list = stream.collect(Collectors.joining(","));
//		Map<Integer, List<String>> list = null;
//		list = stream.collect(Collectors.groupingBy(String::length));
//		List<String> list = stream.toList();
		Object[] list =stream.toArray();
		System.out.println(list);

		
		// Optional
		String string = "문자열";
//		Optional <String> opString = Optional.of(string);
		Optional <String> opString = Optional.empty();
		System.out.println(opString.isPresent());
		opString.ifPresent(System.out::println);
		opString.ifPresentOrElse(System.out::println, ()->System.out.println("없음"));
		
		
	}

	int sum = 0;

}
