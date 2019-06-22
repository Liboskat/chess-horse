# chess-horse
Тестовое задание по рассчету кратчайшего пути от клетки до клетки на шахматной доске произвольного размера.

## Инструкция по сборке
1. Загрузить и установить [OpenJDK 8](https://openjdk.java.net/install/).
2. [Загрузить](https://maven.apache.org/download.cgi) и [установить](https://maven.apache.org/install.html) Maven.
3. Загрузить исходный код из репозитория в виде [архива](https://github.com/Liboskat/chess-horse/archive/master.zip) и распаковать; либо склонировать репозиторий командой `git clone https://github.com/Liboskat/chess-horse.git`, для этого необходимо загрузить и установить [Git](https://git-scm.com/downloads).
4. Перейти в корневую директорию загруженного проекта и выполнить команду `mvn clean package`, таким образом удаляются существующие артефакты сборки (.class, .jar и других файлы), компилируется исходный код, производится тестирование с помощью JUnit тестов и создание jar файла.
Собранный проект хранится в директории target.
