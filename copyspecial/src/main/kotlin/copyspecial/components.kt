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

fun zip(compressFile: String, lst: List<String>) {
    val workingFiles = mutableListOf<File>()

    for (path in lst) {
        val file = File(path)
        if (file.isDirectory) {
            file.listFiles()?.also {
                workingFiles.addAll(it)
            }
        } else {
            workingFiles.add(file)
        }
    }
    val paths = workingFiles.map { it.absolutePath }
    val cmd = "zip -j ${compressFile}.zip ${paths.joinToString(separator = " ")}"
    println("Command I'm going to do: $cmd")

    val runSubProcess = ProcessBuilder(cmd.split(" "))
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)

    runSubProcess.start()
}