# Клиентская часть приложения "Сетевой чат"

Данный проект представляет собой консольное приложение на Java, разработанное в рамках курсовой работы "Сетевой чат" на платформе Нетология.

## Описание работы

Клиентское приложение подключается к серверу через сокеты. При успешном подключении к серверу, клиент получает уведомления о новых подключениях и отключениях других клиентов. Вся информация о подключениях и отключениях записывается в файл fale.log.

## Логирование

Все логи приложения записываются в файл "fale.log" с указанием временных меток.

## Требования

- Java 8 или выше

## Запуск приложения

1. Склонируйте репозиторий с клиентским приложением.
2. Откройте проект в IDE и добавьте в файл settings.txt хост и порт на котором работает серверная часть.
3. Запустите приложение.
4. Следуйте инструкциям на экране для подключения к серверу и начала общения.
