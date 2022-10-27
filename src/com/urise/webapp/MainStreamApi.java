package com.urise.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;


public class MainStreamApi {
    public static void main(String[] args) {
        System.out.println("minValue: " + minValue(new int[]{1, 2, 3, 3, 2, 3}));
        System.out.println("minValue: " + minValue(new int[]{9, 8}));
        System.out.println("---");
        System.out.println("oddOrEven: " + oddOrEven(List.of(1, 2, 3, 4, 5))); //15 // 2,4
        System.out.println("oddOrEven: " + oddOrEven(List.of(4, 2, 8, 7, 7))); //28 // 7,7
        System.out.println("oddOrEven: " + oddOrEven(List.of(2, 3, 6, 9))); //20 // 3,9
        System.out.println("oddOrEven: " + oddOrEven(List.of(3, 3, 6, 9))); //21 // 6
    }

    /*
     * Реализовать метод через стрим int minValue(int[] values).
     * Метод принимает массив цифр от 1 до 9, надо выбрать уникальные и вернуть минимально возможное число,
     * составленное из этих уникальных цифр. Не использовать преобразование в строку и обратно.
     * Например {1,2,3,3,2,3} вернет 123, а {9,8} вернет 89
     */
    private static int minValue(int[] values) {

        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    /*
     * Реализовать метод List<Integer> oddOrEven(List<Integer> integers)
     * если сумма всех чисел нечетная - удалить все нечетные, если четная - удалить все четные.
     * Сложность алгоритма должна быть O(N). Optional - решение в один стрим.
     */
    private static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> map = integers.stream().collect(partitioningBy(a -> a % 2 == 0));

        return map.get(true).size() >= map.get(false).size() ? map.get(false) : map.get(true);
    }
}
