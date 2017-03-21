[chrome]: chrome version above 41.0
[maven]: http://maven.apache.org/
[java]: https://www.java.com/ru/download/help/download_options.xml


### Getting Started

To run tests you need to install [maven][maven] version 3.1.1 or above, [java][java], git and [chrome][chrome].

To generate Allure Report you should perform following steps:

```bash
$ git clone git@github.com:nikitozeg/tinkoff-task.git
$ mvn clean test
$ mvn site
```

To see a report, run `mvn jetty:run` and open `http://localhost:8080` in your browser, or just open index.html in target\site\allure-maven-plugin

**NOTE: required maven version 3.1.1 or above**

### More
 Please, feel free to contact me: tazg@ya.ru
