package net.mindview.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy,String ext){
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args){
        try{
            if(args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (var arg : args) {
                    var fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        //允许用户leave off extension
                        if (arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(
                root.getAbsolutePath(),".*\\."+ext
        ))
           strategy.process(file.getCanonicalFile());
    }
    public static void main(String[] args){
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
