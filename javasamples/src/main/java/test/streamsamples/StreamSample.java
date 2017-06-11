package test.streamsamples;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {

	public static void main(String[] argv) {
		Stream<Integer> sampleStream = Stream.of(1,2,3,4,5);
		sampleStream.forEach(s -> System.out.println(s));
		
		Stream<Integer> sampleStream1 = Stream.of(new Integer[]{1,2,3,4,5,6,7});
		sampleStream1.forEach(s -> System.out.println(s));
		
	//	Stream<Date> dateStream = Stream.generate(() -> new Date());
		//dateStream.forEach(d->System.out.println(d));
		
		
		Stream<Integer> sampleStream2 = Stream.of(new Integer[]{1,2,3,4,5,6,7,8});
		List<Integer> testStream = sampleStream2.filter(i -> i%2 == 0).collect(Collectors.toList());
		testStream.forEach(i -> {System.out.println(i);});
		
	} 
}
