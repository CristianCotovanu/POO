package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles;
    private Path file;
    private BasicFileAttributes attr;

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    // TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link:%s", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular link:%s", file);
        } else if (attr.isOther()) {
            System.out.format("Other:%s", file);
        }

        System.out.println("(" + attr.size() + "bytes)");
        return FileVisitResult.CONTINUE;
    }
    // add to javaFiles all the Java related files: the ones with .java and .class extensions

    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                              IOException exc) {
        System.out.format("Directory: %s%n", dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
                                           IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        if (dir.getFileName().toString().equals("SCCS")) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }


//    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
//        if (file.getFileName().equals()) {
//            System.out.println("Located file: " + file);
//            return FileVisitResult.TERMINATE;
//        }
//        return FileVisitResult.CONTINUE;
//    }

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        // TODO
        // use Files.walkFileTree
        // obtain the list of files and print some info about them (e.g. size and path)
        Files.walkFileTree(startingDir, filesVisitor);
    }
}
