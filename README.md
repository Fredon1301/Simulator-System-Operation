# 🖥️ Simulator System Operation

Um simulador de Sistema Operacional desenvolvido em **Java puro**, focado em demonstrar o funcionamento interno de componentes essenciais como o escalonador de processos e o gerenciador de memória.

Este projeto foi criado com fins educacionais para visualizar como um S.O. decide qual processo executar e como aloca recursos.

## 🚀 Funcionalidades

O simulador implementa as seguintes características principais:

### 1. Gerenciamento de Processos (CPU)
Simulação de algoritmos de escalonamento de CPU para decidir a ordem de execução dos processos:
* **FIFO (First-In, First-Out) / FCFS:** O primeiro processo a chegar é o primeiro a ser servido.
* **Round Robin (RR):** Distribuição de tempo de CPU (quantum) igualitária entre os processos.
* *(Adicione outros se houver, ex: SJF, Prioridade)*

### 2. Gerenciamento de Memória
Simulação da alocação de memória para os processos:
* **Alocação Contígua:** Verifica se há espaço suficiente na RAM simulada.
* **Paginação/Swap:** (Se implementado) Simulação de troca de páginas entre memória principal e disco.

### 3. Sistema de Entrada/Saída (I/O)
* Simulação de filas de espera para dispositivos de E/S (Disco, Impressora).
* Transição de estados de processos (Pronto → Executando → Bloqueado).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 8 ou superior)
* **Interface:** Console/Terminal (CLI)
* **Dependências:** Nenhuma (Java Puro - Standard Library)

## 📂 Estrutura do Projeto

A estrutura de pastas segue o padrão Java:

Simulator-System-Operation/ ├── src/ │ ├── main/ │ │ └── Main.java # Ponto de entrada da aplicação │ ├── model/ │ │ ├── Processo.java # Representação de um processo (PCB) │ │ └── Memoria.java # Representação da RAM │ ├── scheduler/ │ │ ├── Escalonador.java # Lógica de escalonamento (Round Robin/FIFO) │ └── util/ │ └── LeitorArquivo.java # (Opcional) Leitura de processos de um arquivo ├── README.md └── https://www.google.com/search?q=LICENSE


## ⚙️ Como Executar

Como o projeto não utiliza gerenciadores de dependência (como Maven ou Gradle), você pode compilá-lo e rodá-lo diretamente pelo terminal.

### Pré-requisitos
* Ter o **Java JDK** instalado.
* Terminal (CMD, PowerShell, Bash).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Fredon1301/Simulator-System-Operation.git](https://github.com/Fredon1301/Simulator-System-Operation.git)
    cd Simulator-System-Operation
    ```

2.  **Compile o código:**
    Navegue até a pasta `src` e compile todos os arquivos `.java`:
    ```bash
    cd src
    javac -d ../binMain application/Program.java
    # (Ajuste o caminho conforme seu pacote principal, ex: javac br/com/fredon/*.java)
    ```
    *Dica: Se estiver usando uma IDE como IntelliJ ou Eclipse, basta importar o projeto e clicar em "Run".*

3.  **Execute a aplicação:**
    ```bash
    java -cp ../binMain application.Program
    ```
