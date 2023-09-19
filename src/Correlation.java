package Correlation;

import java.util.stream.IntStream;

public class Correlation {


    /**
     * Написать скрипт для расчета корреляции Пирсона между
     * двумя случайными величинами (двумя массивами).
     */


    public static void main(String[] args) {
        int[] array1 = {3, 5, 5, 9, 1};
        int[] array2 = {3, 9, 8, 5, 4};
        try {
            int arraysLength = array1.length;
            double sum1 = java.util.Arrays.stream(array1, 0, arraysLength).sum();

            double sum2 = java.util.Arrays.stream(array2, 0, arraysLength).sum();

            double sum1Squared = IntStream.range(0, arraysLength).mapToDouble(i -> array1[i] * array1[i]).sum();

            double sum2Squared = IntStream.range(0, arraysLength).mapToDouble(i -> array2[i] * array2[i]).sum();

            double productSum = IntStream.range(0, arraysLength).mapToDouble(i -> array1[i] * array2[i]).sum();

            double numerator = arraysLength * productSum - sum1 * sum2;

            double denominator = Math.sqrt((arraysLength * sum1Squared - sum1 * sum1) * (arraysLength * sum2Squared - sum2 * sum2));

            System.out.printf("%.2f%n", numerator / denominator);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Разная длинна массивов");
        }

    }


}