********
# Домашнее задание 14
### Свой Tread pool  
Реализован класс TreadPool. Принимает в конструкторе число потоков, создает и запускает их. Внутри содержит класс ThreadWorker, представляющий собой поток со следующей логикой: пока очередь пуста, спать. Если очередь не пуста, взять следующий Runnable из очереди, выполнить его метод Run, затем снова спать.  
Для добавления задачи нужно вызвать метод addJob, в который передать Runnable-задачу. 

Научился ограничивать число потоков, работать с синхронизированной очередью, использовать wait(), notify().  
Столкнулся с проблемами остановки зависших задач, выполняемых в потоках тред пула.