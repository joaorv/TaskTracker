# TaskTracker 📝

Projeto simples de **gerenciamento de tarefas** desenvolvido em **Java**, com persistência de dados em **JSON** utilizando a biblioteca **Jackson**.

O objetivo do projeto é praticar conceitos de:
- Programação Orientada a Objetos
- Organização em camadas
- Persistência de dados
- Uso do Maven

---

## 🚀 Funcionalidades

- Criar tarefas
- Listar tarefas
- Atualizar status da tarefa
- Remover tarefas
- Persistência automática em arquivo JSON
- Datas de criação e atualização das tarefas

---

## 🛠️ Tecnologias Utilizadas

- Java
- Maven
- Jackson (JSON)
- Console (CLI)

---

## 📂 Estrutura do Projeto
```
src/
├── main/
│   ├── java/
│   │   └── com/jv/tasktracker/
│   │       ├── main
│   │       ├── model
│   │       └── service
│   └── resources

```
---

## ▶️ Como Executar

1. Clone o repositório
2. Abra o projeto em uma IDE Java (IntelliJ, Eclipse, etc.)
3. Certifique-se de ter o **Java 17+** instalado
4. Execute a classe `Main`

---

## 💾 Persistência

As tarefas são salvas automaticamente em um arquivo JSON localizado em:

data/tasks.json

Os dados são carregados automaticamente ao iniciar o programa.

---

## 📌 Observações

Projeto desenvolvido para fins de estudo e prática em Engenharia de Software.

---

## 👨‍💻 Autor

João Victor
