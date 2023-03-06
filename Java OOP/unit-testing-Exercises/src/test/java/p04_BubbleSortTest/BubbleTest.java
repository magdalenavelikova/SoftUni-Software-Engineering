package p04_BubbleSortTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BubbleTest  {
    @Test
    public void testBubbleSort(){
        int[] array={1,10,9,5,2,4};
        int[] sortedArray={1,2,4,5,9,10};
        Bubble.sort(array);
        Assert.assertArrayEquals(sortedArray,array);
    }

}