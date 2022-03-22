package com.company;

import java.awt.geom.Rectangle2D;

/** Этот класс является подклассом FractalGenerator. Он используется для вычисления Фрактал Мандельброта */
public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;
    //Метод позволяет генератору фракталов определить наиболее «интересную» область комплексной плоскости для конкретного фрактала.
    public void getInitialRange (Rectangle2D.Double range){
        range.x=-2;
        range.y=-1.5;
        range.width=3;
        range.height=3;
    }
    /** Этот метод реализует итерационную функцию для фрактала Мандельброта.
     Требуется два дабла для действительной и мнимой частей комплекса.
     Вычисляется количество итераций для соответствующей координаты.
     */
    public int numIterations(double x, double y)
    {
        int iteration = 0;
        double zr = 0;
        double zim = 0;

        while (iteration < MAX_ITERATIONS &&
                zr * zr + zim * zim < 4)
        {
            double zrUpdated = zr * zr - zim * zim + x;
            double zimUpdated = 2 * zr * zim + y;
            zr = zrUpdated;
            zim = zimUpdated;
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
    public String toString() {return "Mandelbrot";}
}
