### 2.2 Демо реализации Comparable(), Collections.sort() и Collections.shuffle()
Создана коллекция:
Deck{cards=[A♢, 2♢, 3♢, 4♢, 5♢, 6♢, 7♢, 8♢, 9♢, 10♢, J♢, Q♢, K♢, A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, A♡, 2♡, 3♡, 4♡, 5♡, 6♡, 7♡, 8♡, 9♡, 10♡, J♡, Q♡, K♡, A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠]}
Сортировка по старшинству (по умолчанию, для использования в игре, сравнение 2 карт происходит по старшинству без учета масти)
Deck{cards=[A♢, A♣, A♡, A♠, 2♢, 2♣, 2♡, 2♠, 3♢, 3♣, 3♡, 3♠, 4♢, 4♣, 4♡, 4♠, 5♢, 5♣, 5♡, 5♠, 6♢, 6♣, 6♡, 6♠, 7♢, 7♣, 7♡, 7♠, 8♢, 8♣, 8♡, 8♠, 9♢, 9♣, 9♡, 9♠, 10♢, 10♣, 10♡, 10♠, J♢, J♣, J♡, J♠, Q♢, Q♣, Q♡, Q♠, K♢, K♣, K♡, K♠]}
Перемешивание с помощью Shuffle():
Deck{cards=[3♡, 7♡, A♠, K♣, 3♣, K♡, 4♢, J♢, 9♠, 3♠, 2♡, 5♣, 2♠, A♢, 7♢, 8♢, 9♢, K♠, 7♠, 4♠, 9♡, 2♣, 9♣, 7♣, J♣, J♠, 6♠, Q♠, 10♢, Q♣, 4♣, 10♡, 6♣, 5♢, 6♡, J♡, 8♠, 8♣, 10♠, 5♡, 4♡, K♢, 5♠, 3♢, 6♢, Q♡, A♣, Q♢, 2♢, A♡, 10♣, 8♡]}

