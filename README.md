# Projeto POO – Construtor de Calendário

Este repositório contém o código do projeto da disciplina de **Programação Orientada a Objetos**, cursada durante o segundo semestre de 2021.  
O desenvolvimento foi feito em **Java** utilizando o **Gradle** como sistema de build.
O objetivo é implementar um construtor de calendário com funcionalidades de cadastro, remoção e listagem de eventos.

## Compilação

Para compilar o projeto, basta executar no terminal (na raiz do projeto):

```bash
./gradlew build
```

## Execução

Como o programa solicita entradas do usuário (Scanner), é recomendado rodar o Gradle em modo plain console, para evitar que a barra de progresso atrapalhe a visualização:

```bash
./gradlew run --console=plain
```