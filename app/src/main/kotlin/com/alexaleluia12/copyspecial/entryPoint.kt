package com.alexaleluia12.copyspecial

import java.io.File
import kotlin.system.exitProcess

/*
Tarefas:

A. Listar arquivos, full path, a partir dos diretorios, relativos dados.
ex: ./bin .
/usr/xpto/files/xyz__hello__.txt
/usr/xpto/files/zz__something__.jpg

B. Copia de dir para --todir, cria o diretorio caso ele não exista. Não printa nada na tela
ex: ./bin --todir /tmp/mywork/ .
$ ls /tmp/mywork
/tmp/mywork/xyz__hello__.txt
/tmp/mywork/zz__something__.jpg

C. Criar arquivo zip considerando o diretorio dado. Vai ser gerado executado um comando externo, zip.
Comando para compresão: zip -j zipFileName <lista de todos os arquivos que vao ser zipados>.
Também dever ser mostrado um printo com o comando e lista dos arquivos que serão zipados.
ex: ./bin --tozip tmp.zip .
Command I'm going to do:zip -j tmp.zip /usr/xpto/files/xyz__hello__.txt /usr/xpto/files/zz__something__.jpg

Em caso de erro encerar o programa com código de erro e mostrar o erro.
 */

fun main(args: Array<String>) {

    val wargs = args.toMutableList()
    if (wargs.isEmpty()) {
        println("usage: [--todir dir][--tozip zipfile] dir [dir ...]")
        exitProcess(1)
    }
    println(wargs.joinToString(" "))
    val todir = if (wargs.first() == "--todir") {
        wargs.removeFirst()
        wargs.removeFirst()
    } else {
         null
    }
    val tozip = if (wargs.first() == "--tozip") {
        wargs.removeFirst()
        wargs.removeFirst()
    } else {
        null
    }

    if (wargs.isEmpty()) {
        println("error: you must specify one or more dirs")
        exitProcess(1)
    }


    when {
        todir != null -> copyFromTo(wargs.first(), todir)
        tozip != null -> zip(wargs)
        else -> listFiles(wargs)
    }
}