# Kotlin 1.9 - JRE 17 

## [String](./app/src/main/kotlin/com/alexaleluia12/MyString.kt)
```txt
String principais metodos
name.uppercase(), name.lowercase()
name.trim() : remove espaco em branco no inicio e fim
name.isBlank() // "" or "     "
name.isEmpty() // ""
name.startsWith("n")
name.endsWith("e")
name.contains(substring) : encontra substrig (Boolean)
name.indexOf(substring) : encontra substrig (Int)
name.replace(old, new)
name.split(str)
join : eh um methodo de list e não de string
name.split(" ").joinToString("-")
slice : pega ultima palavra de tamanho 7, usa range operator
name.slice(name.length - 7 .. name.length - 1)
```

## [List](./app/src/main/kotlin/com/alexaleluia12/MyList.kt)
```txt
List pricipais metodos
bc.add(45), add(index, 45)
bc.addAll(otherList) : concatenar listas
bc.indexOf(elemento) : -1 se não achou ou indece caso exista (Int)
bc.removeAt(index) : remove e retona elemento removido, pode lancar IndexOutOfBoundsException
bc.remove(elemento) : apenas remove caso  exista sem execoes e retorna um (Boolean)
bc.sort() : ordena lista (crescente), alterando ela mesma in-place
bc.reverse() : in-place reverte
    non in-place: sorted(), reversed()
bc.sortedBy() : exemplo ondena lista de palavras pela ultima letra
    lst.sortedBy { it.last() }
bc.getOrElse(index) : exemplo retorna valor default caso o indece nao exista, n~ lanca exceção
    bc.getOrElse(0) { 1000 } // pega primeiro item da lista
exemplos map reduce:
    val oe = List(100){ it+1 }
    // quadrados perfeitos
    // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
    println(oe.filter { v ->
        val sv = sqrt(v.toFloat())
        (sv - sv.toInt()) <= 0.0f
    })
    
    val oz = listOf(1, 2, 3, 4)
    println(oz.map { it*it }) // [1, 4, 9, 16]
```

## [Map](./app/src/main/kotlin/com/alexaleluia12/MyMap.kt)
```text
Map principais metodos
    in
    getOrElse
    [key]
    for: iteravel par key/value
    * presenvar ordem de inserção
Atributos
    entries
    keys
    values
    size
```

## [File](./app/src/main/kotlin/com/alexaleluia12/MyFile.kt)

## [Regex](./app/src/main/kotlin/com/alexaleluia12/MyRegex.kt)

# run
./gradlew run


# sub-projetos
Pode ser feito o build separado de cada projeto (babynames, copyspecial, wordcount) entrando na pasta de cada um
e executado `gradle build`. Ou na raiz **kotlin-exercises/** executar `./gradlew build :babynames`

Depois do build o executavel completo foi criado, no sub-projeto, dentro de build/distributions/*.{tar,zip}
Ao desempacotar o .zip temos: bin/ lib/

## bin/
- projeto.bat: executavel para Windows
- projeto: executavel Unix

### rodar depois do build
desempacote .tar

`$./bin/wordcount --count ../mytxtfile`


## Como criar sub-projetos usando gradle
Em settings.gradle.kts, na raiz do projeto, na lista **include**
escreva o nome do projeto "bala-bronze", por exemplo

Ainda na raiz, rode: `$ mkdir -p bala-bronze/src/main/kotlin/`

Copie o **build.gradle.kts** de app para bala-bronze (no mesmo nível de src/)

Sincronize o gradle no projeto todo, Na IDE IntelliJ volte para settings.gradle e sync

TODO:
    logPuzzel (ultima tarefa)