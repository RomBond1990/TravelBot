#Travel Bot
Telegram Bot for travel

####Бота можно найти в Telegram по имени @for_test_travel_bot


Для удобного запуска приложения используется H2 база данных. 
Скрипт создания бд располагается по адресу [./web/src/main/resources/data.sql](./web/src/main/resources/data.sql).
При запуске приложения Spring Boot автоматически создает базу данных из скрипта. 
###Для запуска:
1. Скачать проект с GitHub
2. Открыть в Intelij Idea (или другой IDE)
3. Запустить проект  из вкладки Run - Run 'TravelBotApplication'(или просто нажать Shift+F10) 

К сожалению Front-end пока отсутствует и добавлять/изменять данные можно только напрямую через базу данных. 
Для этого в браузере пройти по адресу
 
1. [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. В строке JDBC URL написать jdbc:h2:mem:travel_bot 
3. В открывшемся окне используйте поле для команд

<i>имя бота: @for_test_travel_bot <br/></i>
<i>токен бота: 1508517017:AAF0LZKzyjLh8FPi9P44qd9cawJoxMMaR6c</i>