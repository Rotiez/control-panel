# Control-panel (Панель управления)

## Обзор
Этот проект направлен на упрощение доступа к различным инструментам, таким как Redis, Grafana и другие, 
предоставляя единый веб-интерфейс. Он создает веб-страницу со ссылками на эти ресурсы, 
позволяя пользователям настраивать их через файл `control-panel.yml`.

![Screenshot](/src/main/resources/screenshots/Screenshot.png)

---

## Возможности

- **Централизованный доступ:** Доступ ко всем сконфигурированным инструментам из одной веб-страницы.
- **Настройка по желанию:** Настройка инструментов и их ссылок с помощью файла `control-panel.yml` (`/src/main/resources/properties/control-panel.yml`).
- **Простота развертывания:** Простой процесс настройки для развертывания точки входа в инструменты.

---

## Настройка

Пример конфигурационного файла `control-panel.yml`:
```yml
properties:
    services:
    - name: Redis
      address: http://localhost:8001
      icon: /icons/redis_logo.png       #optional
      version: 7.2.0                    #optional
```
Вы также можете объединять ссылки на ресурсы в группы следущим образом:
```yml
properties:     
    groups:
    - name: group_example
      icon: /icons/prometheus_logo.png          #optional
      services:
        - name: Prometheus
          address: http://localhost:8002
          icon: /icons/prometheus_logo.png      #optional
          version: 1.0.0                        #optional
```
Для включения/отключения логирования используйте переменную среды `LOGGING_ENABLED`. 
Установите ее значение `true` или `false`.(_Значение по умолчанию - false_).

---

## Docker-compose

>Docker образ доступен на [Docker Hub](https://hub.docker.com/repository/docker/rxtiez/control-panel) (rxtiez/control-panel).

Пример docker-compose.yml файла:
```yml
version: '3.8'

services:
  control-panel:
    image: rxtiez/control-panel:1.0.0
    container_name: control-panel
    ports:
      - "3030:3030"
    volumes:
      - ./config/control-panel/control-panel.yml:/control-panel/properties/control-panel.yml
    environment:
      - LOGGING_ENABLED=true
```
>!!! Обратите внимание на указание `volumes`. Таким образом нужно сопоставить ваш
конфигурационный файл на хостовой машине с конфигурационным файлом внутри Docker контейнера, который
расположен в директории `/control-panel/properties/control-panel.yml`.