package com.xuhq.arithmetic.io;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :
 * create at:  9/29/22  11:04 AM
 * @description:
 */
public class ExportFiles {

    public static void main(String[] args) throws Exception {
        List<String> strings = queryFileNames("/Users/apple/Desktop/文件");

    }

    private static List<String> queryFileNames(String filePath) throws Exception {

        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String writePath = filePath.concat("/").concat(files[i].getName().replace(".",""));
            new File(writePath).mkdir();
            FileInputStream inputStream = new FileInputStream(files[i]);
            FileOutputStream outputStream = new FileOutputStream(new File(writePath,files[i].getName()));
            FileCopyUtils.copy(inputStream,outputStream);
            inputStream.close();
            outputStream.close();

        }
        return list;
    }

    private static void writeOutFile(List<String> list){


    }
}
