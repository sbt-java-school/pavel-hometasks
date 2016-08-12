# pavel-hometasks
##Задание №2
> 1. Добавление элементов в конец ArrayList
> 1. Вставка элементов в начало ArrayList
> 1. Добавление элементов в конец LinkedList
> 1. Вставка элементов в начало LinkedList
> 1. Доступ к элементу в середине ArrayList
> 1. Доступ к элементу в середине LinkedList
> 1. Доступ к элементу в середине LinkedList через ListIterator  

```Output:
Adding 1000000 same Test Object to the end of ArrayList...
53 ms
Adding 1000000 same Test Object to the beginning of ArrayList...
508554 ms
Adding 1000000 same Test Object to the end of LinkedList...
68 ms
Adding 1000000 same Test Object to the beginning of LinkedList...
42 ms
Accessing 500000 element 1000000 times in ArrayList...
19 ms
Accessing 500000 element 1000000 times in LinkedList...
2136887 ms
Accessing 500000 element 1000000 times in LinkedList using ListIterator...
71 ms
```
###Вывод: Случайное чтение LinkedList почти не проигрывает по скорости ArrayList'у, если использовать ListIterator

> 1. Реализовать интерфейс Comparable
> 1. Использовать Collections.sort();  
> 1. Использовать Collections.shuffle();  

```
Создана коллекция:
Deck{cards=[A♢, 2♢, 3♢, 4♢, 5♢, 6♢, 7♢, 8♢, 9♢, 10♢, J♢, Q♢, K♢, A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♡, 2♡, 3♡, 4♡, 5♡, 6♡, 7♡, 8♡, 9♡, 10♡, J♡, Q♡, K♡, A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠]}
Сортировка по старшинству (по умолчанию, для использования в игре, сравнение 2 карт происходит по старшинству без учета масти)
Deck{cards=[A♢, A♣, A♡, A♠, 2♢, 2♣, 2♡, 2♠, 3♢, 3♣, 3♡, 3♠, 4♢, 4♣, 4♡, 4♠, 5♢, 5♣, 5♡, 5♠, 6♢, 6♣, 6♡, 6♠, 7♢, 7♣, 7♡, 7♠, 8♢, 8♣, 8♡, 8♠, 9♢, 9♣, 9♡, 9♠, 10♢, 10♣, 10♡, 10♠, J♢, J♣, J♡, J♠, Q♢, Q♣, Q♡, Q♠, K♢, K♣, K♡, K♠]}
Перемешивание с помощью Shuffle():
Deck{cards=[3♣, A♣, 8♣, 8♢, 2♠, J♡, 9♡, 10♢, 7♠, 7♣, 8♡, J♢, 5♢, A♠, 4♠, 3♠, 2♢, K♡, 6♠, 10♠, 10♣, 2♣, J♠, 9♠, 4♡, 5♠, Q♡, Q♢, 6♢, 4♣, K♠, J♣, 6♡, 9♣, 5♡, 4♢, 8♠, K♢, 9♢, Q♠, K♣, 7♡, Q♣, A♡, 10♡, 3♡, A♢, 3♢, 6♣, 5♣, 2♡, 7♢]}
```
*****
