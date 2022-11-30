package l.dsong.commond;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Selector;

public class IOTest {

    @Test
    public void t1(){
        try(
                RandomAccessFile raf  = new RandomAccessFile("E:\\Temp\\init_data.7z", "r")
                ){

        }
        catch (Exception ex){

        }

        new File("E:\\Temp\\init_data.7z").delete();

    }


    @Test
    public void t2(){

// 报错缺少org.tukaani.xz.FilterOptions这个类
        File outFile = new File("E:\\Temp\\logs\\p-info.7z");
        File inFile = new File("E:\\Temp\\logs\\p-info");
        try (SevenZOutputFile sevenZOutput = new SevenZOutputFile(outFile);) {
            SevenZArchiveEntry entry = sevenZOutput.createArchiveEntry(inFile, "p-info");
            sevenZOutput.putArchiveEntry(entry);
            byte[] buffer = new byte[1024];
            int len = 0;
            try (FileInputStream fis = new FileInputStream(inFile)) {
                while ((len = fis.read(buffer)) != -1) {
                    sevenZOutput.write(buffer, 0, len);
                }
            }

            sevenZOutput.closeArchiveEntry();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("成功写入一个7z的文件.....");

    }

    @Test
    public void t3(){
    }



}
