package solvdlaba.hometask;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void Test1() {
        Integer[] numbers = {5, 4, 3, 2, 1, 0};
        Main.quickSort(numbers);
        Assert.assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5}, numbers);
    }

    @Test
    public void Test2() {
        Integer[] numbers = {-1, -2, -3, -4, -5};
        Main.quickSort(numbers);
        Assert.assertArrayEquals(new Integer[] {-5, -4, -3, -2, -1}, numbers);
    }

    @Test
    public void Test3() {
        Integer[] numbers = {-10, 0, -1, 0, 199};
        Main.quickSort(numbers);
        Assert.assertArrayEquals(new Integer[] {-10, -1, 0, 0, 199}, numbers);
    }

    @Test
    public void Test4() {
        Integer[] numbers = {0, 1, 2, 3};
        Main.quickSort(numbers);
        Assert.assertArrayEquals(new Integer[] {0, 1, 2, 3}, numbers);
    }

    @Test
    public void Test5() {
        Character[] chars = {'e', 'd', 'c', 'b', 'a'};
        Main.quickSort(chars);
        Assert.assertArrayEquals(new Character[] {'a', 'b', 'c', 'd', 'e'}, chars);
    }
}
