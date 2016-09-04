********
# Генератор файла README.md
### Добавляет описания и вывод на экран из каждой домашки в этот файл.  
********
# Домашнее задание 01
### Реализована задача по загрузке грузовика (см. код)

********
# Домашнее задание 02
### 2.1 Тест скорости коллекций на разных операциях
Adding 500000 same Test Object to the end of ArrayList...
16 ms
Adding 500000 same Test Object to the beginning of ArrayList...
127746 ms
Adding 500000 same Test Object to the end of LinkedList...
179 ms
Adding 500000 same Test Object to the beginning of LinkedList...
43 ms
Accessing 250000 element 500000 times in ArrayList...
24 ms
Accessing 250000 element 500000 times in LinkedList...
931835 ms
Accessing 250000 element 500000 times in LinkedList using ListIterator...
38 ms


### 2.2 Демо реализации Comparable(), Collections.sort() и Collections.shuffle()
Создана коллекция:
Deck{cards=[A♢, 2♢, 3♢, 4♢, 5♢, 6♢, 7♢, 8♢, 9♢, 10♢, J♢, Q♢, K♢, A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♡, 2♡, 3♡, 4♡, 5♡, 6♡, 7♡, 8♡, 9♡, 10♡, J♡, Q♡, K♡, A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠]}
Сортировка по старшинству (по умолчанию, для использования в игре, сравнение 2 карт происходит по старшинству без учета масти)
Deck{cards=[A♢, A♣, A♡, A♠, 2♢, 2♣, 2♡, 2♠, 3♢, 3♣, 3♡, 3♠, 4♢, 4♣, 4♡, 4♠, 5♢, 5♣, 5♡, 5♠, 6♢, 6♣, 6♡, 6♠, 7♢, 7♣, 7♡, 7♠, 8♢, 8♣, 8♡, 8♠, 9♢, 9♣, 9♡, 9♠, 10♢, 10♣, 10♡, 10♠, J♢, J♣, J♡, J♠, Q♢, Q♣, Q♡, Q♠, K♢, K♣, K♡, K♠]}
Перемешивание с помощью Shuffle():
Deck{cards=[7♣, 8♢, J♣, A♢, 2♠, 7♢, Q♡, 8♡, K♢, 8♠, 10♠, 2♢, K♡, 6♠, 10♣, 4♡, 9♣, 6♢, 7♡, J♠, 10♡, 4♣, Q♠, 3♢, 10♢, K♣, A♡, 3♡, 5♣, 3♠, J♢, 5♡, 2♣, A♠, Q♣, 5♢, Q♢, 2♡, 8♣, 7♠, 6♡, 4♢, J♡, 9♢, 3♣, 5♠, 6♣, 4♠, K♠, 9♠, A♣, 9♡]}


********
# Домашнее задание 04
### Реализована Multimap
********
# Домашнее задание 05
### Реализован метод readContent(), который получает содержимое по URL
********
# Домашнее задание 06
### 6.1 Вывести на консоль все методы класса, включая все родительские методы, (включая приватные). Например, java.io.BufferedReader
read(char[], int, int)
read()
close()
readLine(boolean)
readLine()
fill()
mark(int)
markSupported()
reset()
skip(long)
read1(char[], int, int)
ensureOpen()
lines()
ready()
* read(char[])
* read(char[], int, int)
* read()
* read(java.nio.CharBuffer)
* close()
* mark(int)
* markSupported()
* reset()
* skip(long)
* ready()
* * finalize()
* * wait()
* * wait(long, int)
* * wait(long)
* * equals(java.lang.Object)
* * toString()
* * hashCode()
* * getClass()
* * clone()
* * notify()
* * notifyAll()
* * registerNatives()


### 6.2 Вывести все геттеры класса. Например, com.norg.home02.shuffleusage.cards.Card
getMast()
getNominal()
getClass()
********
# Домашнее задание 07
### Кэширующий прокси + аннотация @Cache
32.0
cachedCalc.longCalculation(5)  
53 ms  
512.0
cachedCalc.longCalculation(9)  
55 ms  
cachedCalc.longCalculation(5) // cached value  
32.0
0 ms  
