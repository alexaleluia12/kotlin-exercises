package com.alexaleluia12.copyspecial

import java.io.File
import java.nio.file.Paths

fun listFiles(relativePaths: List<String>) {
    for (p in relativePaths) {
        val file = File(p)

        file.listFiles()?.forEach { fpath ->  println(fpath.absolutePath) }
    }
}

fun  copyFromTo(originPath: String, targetPath: String) {
    val origin = File(originPath)


    origin.listFiles()?.forEach {
        val target = File(Paths.get(targetPath, it.name).toUri())
        it.copyTo(target, overwrite = true)
    }
}

fun zip(lst: List<String>) {

    /*
    cmd: zip -j zipFileName <lista de todos os arquivos que vao ser zipados>.
    usar process buider para executar comando zip
     ProcessBuilder(*split(" ").toTypedArray())
                .directory(workingDir)
                .redirectOutput(Redirect.INHERIT)
                .redirectError(Redirect.INHERIT)
                .start()
                .waitFor(60, TimeUnit.MINUTES)
     */
}