$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/AddAgenda.feature");
formatter.feature({
  "name": "Test Add agenda",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "browser is open1",
  "keyword": "Given "
});
formatter.step({
  "name": "user is on login page1",
  "keyword": "And "
});
formatter.step({
  "name": "user enters \u003cusername\u003e y \u003cpassword\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "user clicks on login1",
  "keyword": "And "
});
formatter.step({
  "name": "user is navigated to the home page1",
  "keyword": "Then "
});
formatter.step({
  "name": "user clicks on agenda",
  "keyword": "And "
});
formatter.step({
  "name": "user es redirigido a la lista de agendas",
  "keyword": "Then "
});
formatter.step({
  "name": "user pulsa en Registrar nuevo",
  "keyword": "And "
});
formatter.step({
  "name": "user es redirigido al formulario de registro de agenda",
  "keyword": "Then "
});
formatter.step({
  "name": "user ingresa \u003cidMascota\u003e y \u003cfecha\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user pulsa en Registrar",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "idMascota",
        "fecha"
      ]
    },
    {
      "cells": [
        "admin",
        "admin",
        "1",
        "2023-01-16 07:00"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "browser is open1",
  "keyword": "Given "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.browser_is_open1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on login page1",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_is_on_login_page1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters admin y admin",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_enters_username_y_password1(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login1",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_clicks_on_login1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to the home page1",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_is_navigated_to_the_home_page1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on agenda",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_clisk_on_agenda()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user es redirigido a la lista de agendas",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_es_redirigido_a_la_lista_de_agendas()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user pulsa en Registrar nuevo",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_pulsa_en_Registrar_nuevo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user es redirigido al formulario de registro de agenda",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_es_redirigido_al_formulario_de_registro_de_agenda()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user ingresa 1 y 2023-01-16 07:00",
  "keyword": "When "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_ingresa_idMascota_y_fecha(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user pulsa en Registrar",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.AddAgendaSteps.user_pulsa_en_Registrar()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/Features/Login.feature");
formatter.feature({
  "name": "Test login functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "browser is open",
  "keyword": "Given "
});
formatter.step({
  "name": "user is on login page",
  "keyword": "And "
});
formatter.step({
  "name": "user enters \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user clicks on login",
  "keyword": "And "
});
formatter.step({
  "name": "user is navigated to the home page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "admin",
        "admin"
      ]
    },
    {
      "cells": [
        "admin",
        "123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "selenium.LoginSteps.browser_is_open()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on login page",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.LoginSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters admin and admin",
  "keyword": "When "
});
formatter.match({
  "location": "selenium.LoginSteps.user_enters_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.LoginSteps.user_clicks_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.LoginSteps.user_is_navigated_to_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "selenium.LoginSteps.browser_is_open()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on login page",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.LoginSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters admin and 123",
  "keyword": "When "
});
formatter.match({
  "location": "selenium.LoginSteps.user_enters_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login",
  "keyword": "And "
});
formatter.match({
  "location": "selenium.LoginSteps.user_clicks_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "selenium.LoginSteps.user_is_navigated_to_the_home_page()"
});
formatter.result({
  "status": "passed"
});
});