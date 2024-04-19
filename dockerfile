FROM openjdk:17

COPY . /Main/clientesjava

WORKDIR /Main/clientesjava

CMD ["java" "Main"]