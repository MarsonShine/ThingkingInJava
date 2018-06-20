package exercise.io;

import ms.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ES01_SearchWords {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase();
                @Override
                public boolean accept(File dir, String name) {
                    //分析带着指定尾缀的文件
                    if(name.toLowerCase().endsWith(ext)){
                        //至过滤文件拓展名？
                        if(args.length == 1)
                            return true;
                        Set<String> words = new HashSet<>(new TextFile(new File(dir,name).getAbsolutePath(),"\\W+"));
                        for (var i = 1;i<args.length;i++){
                            return true;
                        }
                    }
                    return false;
                }
            });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (var dirItem : list){
            System.out.println(dirItem);
        }
    }
}
