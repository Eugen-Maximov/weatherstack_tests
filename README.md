# WeatherStack API Tests
1. Реализация тестов только через Junit4 - проект weatherstack_tests
2. Реализация тестов через Cucumber - проект cucumber_weatherstack_tests
***

#### Авторизация:
Авторизационный токен weatherstack передается в тесты через переменную окружения **TOKEN**
Токены для авторизации:
1. *ed0cec3065036a4f388505daf48222d8* - еще не истек
2. *1ad6d6000b35dffa30ed6e17ec33b366* - превышен лимит реквестов в месяц
***

#### Тестовые примеры
Готовые тела под каждый кейс лежат в:
1. *src/test/java/test_data*
2. *src/test/resources*

Под каждый пример выставляются актуальными лишь поля с датой и временем: "location.localtime" и "location.localtime_epoch"
***