# 1

* 1.1 
 
        trabs.trab1.grupo1.Student@5caf905d
        false
        false
O output mostra-nos a função padrão do método toString(), que gera uma string com o endereço da memória da variável.
E, tambem, o funcionamento do equals() padrão que compara os endereços da memória em si em vez dos conteudos dos objetos logo obtemos um resultado "inexperado". ola

* 1.2

Codigo adicionado:

      public String toString() {
          return this.number + ": " + this.name + " - " + this.grade;
      }

      public boolean equals(Object obj) {
          Student other = (Student) obj;
          return this.number == other.number &&
          this.name.equals(other.name);
      }
Foi utilizado o mecanismo Overloading para alterar o funcionamento dos métodos toString() e equals() para obter o resultado experado.

* 1.4

Output obtido:

        1: aa - 10
        true
        true
Ao fazer a alteração (remover o toString()), obtemos o mesmo output, pois, a função print da biblioteca padrão java, utiliza o método toString() caso seja utilizado apenas um objeto como único argumento.
