## JSON analyser

### Описание

Данная программа написана в рамках выполнения тестового задания для [Idea Platform](https://ideaplatform.ru). Программа парсит JSON файл, расположенный в папке по-умолчанию, осуществляет маппинг данных на Java объекты класса `Ticket`, высчитывает и затем выводит в консоль:

1) Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика;
2) Разницу между средней и медианной ценами для полета между городами Владивосток и Тель-Авив.

Помимо непосредственно предусмотренного заданием функционала, в приложение заложены возможности дальнейшего развития и масштабирования. Так фильтрация билетов согласно заданию осуществляется лишь по городам назначения, однако сервис `TicketServiceImpl` реализован таким образом, что он взаимодействует с интерфейсом `TicketFiltrationCriterion` и его реализациями (к примеру, `CarrierFilter`), что в свою очередь позволяет при необходимости вводить новые критерии фильтрации и комбинировать их. Каждое такое новое правило фильтрации будет представлено классом, имплементирующим `TicketFiltrationCriterion` и, следовательно, переопределяющим метод `.getPredicate()`, то есть генерирующим необходимый предикат, исходя из своих потребностей и переданных данных.

При этом формирование списка, содержащего классы-критерии, для последующего направления в сервис можно будет осуществлять в отдельном классе, конкретная реализация которого будет зависеть от формата входных данных.

Кроме того, уже сейчас заложена возможность в будущем работать не только с файлами формата `.json`, но и, к примеру, с файлами форматов `.yml` или `.yml`. 

Ввиду инструкций, содержащихся в задании, возможность указать путь до файла в настоящий момент не предусмотрена, однако может быть реализована, к примеру, с помощью [Picocli](https://picocli.info), а в случае, если предполагается, что JSON будет приходить через веб, то не трудно будет реализовать соответствующих контроллер.

Код протестирован юнит-тестами и проверен на соответствие checkstyle.

### Использованные технологии и инструменты

+ Java 17
+ Gradle 8.4
+ JUnit

### Запуск программы

1) Скачайте программу используя команду git clone (или вручную):
```zsh
git clone git@github.com:DmitriiGoltsov/Idea-Platform-test-task.git
```
2) В терминале перейдите в скачанную директорию (внутрь директории json_analyser) и выполните следующую команду:
```zsh
./gradlew run
```
3) Дождитесь выполнения программы.

### Ответы на вопросы, поставленные в задании:

Для компании TK минимальное время перелёта между городами Владивосток и Тель-Авив составляет 350 минут.

Для компании BA минимальное время перелёта между городами Владивосток и Тель-Авив составляет 485 минут.

Для компании SU минимальное время перелёта между городами Владивосток и Тель-Авив составляет 360 минут.

Для компании S7 минимальное время перелёта между городами Владивосток и Тель-Авив составляет 390 минут.

Разница между средней арифметической и медианной ценой авиабилетов составляет: 460 рублей.