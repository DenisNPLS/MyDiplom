# Отчет по итогам тестирования

В данном проекте произведено тестирование симулятора банковских сервисов покупки тура, взаимодействующее с СУБД банка(**MySQL** или **PostgreSQL**), работающего на **Node.js**.

Общее количество тест-кейсов: **70**.

Количество успешных(в %): **32**.

Количество не успешных(в %): **38**.

API тестирование прошло на **100%** успешно.

Из рекомендаций можно выделить следующее:

  1. Оформить кнопки "Купить" и "Купить в кредит" одинаковым цветом чтобы при нажатии они меняли цвет;
  2. Исправить ошибки с не верными сообщениями о вводе данных в поля формы;
  3. В названии вкладки исправить надпись "Заявка на карту" на "Путешествие дня";
  4. Изменить поведение кнопки "Продолжить": не давать пользователю нажимать на нее при незаполненных полях;
  5. В поле "Владелец" ввести возможность автоматического ввода данных с верхним регистром и на латинице;

По ссылке можно ознакомиться со списком багов [Issues](https://github.com/DenisNPLS/DiplomQA/issues).