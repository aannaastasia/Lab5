package com.company;

import java.awt.geom.Rectangle2D;

//Этот класс является подклассом FractalGenerator. Он используется для вычисления Фрактал Мандельброта
public class Tricorn extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;
    /** Этот метод реализует итерационную функцию для фрактала Мандельброта.
     Требуется два дабла для действительной и мнимой частей комплекса.
     Вычисляется количество итераций для соответствующей координаты.
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }
    /**
    Этот метод реализует итерационную функцию для фрактала Мандельброта.
    Требуется два дабла для действительной и мнимой частей комплекса.
    Вычисляется количество итераций для соответствующей координаты.
    */
    public int numIterations(double x, double y)
    {
        int iteration = 0;
        double zr = 0;
        double zim = 0;
        /*
        Вычислить Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа, представленные
        по zr и zim, Z0 = 0, а c - особая точка в
        фрактале, который мы отображаем (заданный x и y). Это повторяется
        до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
        достигнуто количество итераций.
        */
        while (iteration < MAX_ITERATIONS &&
                zr * zr + zim * zim < 4)
        {
            double zrealUpdated = zr * zr - zim * zim + x;
            double zimaginaryUpdated = -2 * zr * zim + y;
            zr = zrealUpdated;
            zim = zimaginaryUpdated;
            iteration += 1;
        }
        //В случае, если алгоритм дошел до значения MAX_ITERATIONS нужно вернуть -1, чтобы показать, что точка не выходит за границы.
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        return iteration;
    }
    //Возврат названия фрактала
    public String toString() {
        return "Tricorn";
    }
}
