## Rational
Класс для работы с рациональными числами, т.е. числами, которые можно представить в виде обыкновенной дроби, в которой числитель и знаменатель — целые числа. Примеры чисел: `1/2`, `3/4`, `-5/2`.

&nbsp;

Класс позволяет создавать объекты обыкновенных дробей с заданными числителем и знаменателем или же со значением по умолчанию (`0`/`1`).

При попытке создания дроби с нулевым знаменателем генерируется исключение `ArithmeticException("division by zero !")`.

Если дробь отрицательна, минус стоит перед числителем.

При создании дроби она сокращается, если такая возможность есть. Например, дробь `5/10` сократится до `1/2`.

&nbsp;

Также класс предоставляет возможность проводить с обыкновенными дробями

- элементарные операции: сложение, вычитание, умножение, деление.

- сравнения: на равно, на меньше, на меньше или равно.

При попытке деления на ноль генерируется исключение `ArithmeticException("division by zero !")`.

## RationalTests
Класс с примером теста на класс `Rational`. 

Пример теста (`void testStandardConstructor()`), проверяет значения числителя и знаменателя стандартного экземпляра класса.

## Пояснения к коду
Найдена ошибка логики в публичном методе `less`, при равных значениях числителя сравнивая отрицательные дроби, тест падает.

В этом же методе синтаксическая ошибка, вместо `rational.getNumerator()` указано `getNumerator()`. 

По этим причинам 3 теста имеют статус fail.

Для запуска проекта необходимо скопировать файлы из src в любой проект, с подключенным junit4 (возможен запуск в IDE Intellij Idea).
