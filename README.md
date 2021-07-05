## Используемые технологии и инструменты

Тесты были написаны на IntelliJ IDEA + Java + JUnit5 + Selenide + Gradle

| IntelliJ IDEA | Java | Gradle | Junit5 | Selenide |
|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

Хранятся на Github, запускаются и прогоняются через Jenkins + Selenoid

| GitHub | Jenkins | Selenoid |
|:--------:|:--------:|:-------------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | 

С отчетами в Allure TestOps + Allure Report + Telegram

| Allure TestOps | Allure Report | Telegram |
|:---------:|:---------:|:--------:|
| <img src="images/Allure_TestOps.svg" width="40" height="40"> | <img src="images/Allure_Report.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |

## Запуск через Jenkins https://jenkins.autotests.cloud/job/tradesanta-tests/

### С какими параметрами можно запустить тесты:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads to run)

### Как запустить тесты из командной строки
Запустить тесты с дефолтными параметрами:
```bash
gradle clean test
```

Запустить тесты с нужными нам параметрами:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ test
```

Сформировать отчет в Allure:
```bash
allure serve build/allure-results
```

### Пример настроек перед запуском сборки в Jenkins:
![alt "Выбор параметров"](./images/jenkins_project.png)

## Прогоняются тесты в Selenoid https://selenoid.autotests.cloud/#/

### Пример прогона теста в Selenoid
![alt "Video from Selenoid"](./images/selenoid_video.gif "Video from Selenoid")

## После прогона формируется отчет в Allure
![alt "Allure Dashboard"](./images/allure_dashboard.png)
![alt "Allure Report"](./images/run_report.png)

### В аттаче каждого теста есть логи, скриншоты и видео прохождения каждого теста
![alt "Allure Attachments"](./images/attachments.png)

### Сейчас один из тестов падает из-за ошибки на сайте
![alt "Failed Test"](./images/fail_test.png)

## Хранение и анализ тестов в Allure TestOps
![alt "Allure TestOps"](./images/allure_testops_cases.png)

## В Telegram отправляется уведомление с результатами
![alt "Выбор параметров"](./images/telegram.png)





