package ru.skillbench.tasks.basics.control;

/**
 * ЦЕЛЬ ЗАДАЧИ - научиться использовать управляющие конструкции <code>if, case, for, while</code> в Java.<br/>
 * Дополнительно: разобраться с простыми типами, массивами и передачей параметров в методы.<br/>
 * <p/>
 * ЗАДАНИЕ<br/>
 * <dl>
 * <dt>Оператор if</dt>
 * <dd>Применить ту или иную формулу в зависимости от условия.</dd>
 * <dt>Оператор case</dt>
 * <dd>Вывести строковое значение в зависимости от целочисленного значения.</dd>
 * <dt>Оператор for</dt>
 * <dd>Заполнить и обработать двумерный массив.</dd>
 * <dt>Оператор while</dt>
 * <dd>Рассчитать параметры банковского вклада.</dd>
 * </dl>
 * <p/>
 * ПРИМЕЧАНИЯ<br/>
 * Задачу можно решать без явной обработки и генерации исключительных ситуаций (Exceptions).<br/>
 * Вот как должна выглядеть реализация данного интерфейса:<br/>
 * <code>
 * public class ControlFlowStatements1Impl implements ControlFlowStatements1 {  }
 * </code>
 * <p/>
 * Метод main не тестируется, но для себя в main вы можете проверить, что возвращают ваши методы, например:
 * <code>
 * ControlFlowStatements1 object = new ControlFlowStatements1Impl();
 * System.out.println(object.decodeWeekday(4));
 * </code>
 *
 *  @author Elena Protsenko
 *  @author Alexey Evdokimov
 */
public interface ControlFlowStatements1{
    /**
     * Для данного вещественного x найти значение следующей функции f, принимающей вещественные значения:<br/>
     * <pre>
     *        | 2*sin(x), если x>0,
     *  f(x)= |
     *        | 6-x, если x<=0.
     * </pre>
     * @return значение f.
     */
    float getFunctionValue(float x);
    /**
     * Дано целое число в диапазоне 1–7.
     * Вернуть строку — название дня недели, соответствующее этому числу:<br/>
     * 1 — Monday, 2 — Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday.
     * @param weekday
     * @return строковое представление weekday
     */
    String decodeWeekday(int weekday);

    /**
     * Создать двумерный массив, содержащий 8x5 целочисленных элементов,
     * и присвоить каждому элементу произведение его индексов: array[i][j] = i*j.
     * @return массив.
     */
    int[][] initArray();
    /**
     * Найти минимальный элемент заданного двумерного массива.
     * @param array массив, содержащий как минимум один элемент
     * @return минимальный элемент массива array.
     */
    int getMinValue(int[][] array);

    /**
     * Начальный размер вклада в банке равен $1000.<br/>
     * По окончанию каждого года размер вклада увеличивается на P процентов (вклад с капитализацией процентов).<br/>
     * По заданному P определить, через сколько лет размер вклада превысит $5000, а также итоговый размер вклада.
     * @param P процент по вкладу
     * @return информация о вкладе (в виде экземпляра класса {@link BankDeposit})
     * после наступления вышеуказанного условия
     */
    BankDeposit calculateBankDeposit(double P);
    /**
     * Вспомогательный тип для метода {@link ControlFlowStatements1#calculateBankDeposit(double)}.<br/>
     * Примечание: Специальный тип здесь необходим, поскольку метод должен вернуть ДВА значения,
     *  в то время как через аргументы метода значения просто так вернуть нельзя
     *  (передача параметров в методы в Java - только по значению, а не по ссылке).<br/>
     * ВОПРОС: как можно было бы обойтись без специального типа, но вернуть два значения в calculateBankDeposit?
     * (есть несколько способов, возможных с точки зрения синтаксиса, хотя и все они нехороши с точки зрения ООП)
     */
    public static class BankDeposit{
        /**
         * Число полных лет, которые вклад пролежал в банке.
         */
        public int years = 0;
        /**
         * Размер вклада после {@link #years} лет.
         */
        public double amount;

        @Override
        public String toString() {
            return years + " years: $" + amount;
        }
    }
}