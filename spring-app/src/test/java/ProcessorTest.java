import com.thoughtworks.training.Add;
import com.thoughtworks.training.Processor;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProcessorTest {
   private final List<Integer> input = IntStream.range(1,6).boxed().collect(Collectors.toList());

   @Test
    public void shouldPlusInputValues(){
       Processor processor = new Add();
       List<Integer> output = IntStream.of(3,4,5,6,7).boxed().collect(Collectors.toList());
       assertThat(processor.process(input),is(output));
   }
}
