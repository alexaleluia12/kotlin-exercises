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
```

# run
./gradlew run

# parei
exercicios list2
https://developers.google.com/edu/python/lists?hl=en
