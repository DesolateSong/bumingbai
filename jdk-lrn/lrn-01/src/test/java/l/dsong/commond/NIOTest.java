package l.dsong.commond;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOTest {

    @Test
    public void fileReadTest() {
        try (
                RandomAccessFile raf = new RandomAccessFile("E:\\SUXS\\MyWorkSpace\\bumingbai\\jdk-lrn\\lrn-01\\src\\test\\resources\\file.txt", "r");
        ) {

            FileChannel fc = raf.getChannel();

            ByteBuffer buff = ByteBuffer.allocate(10 * 1024);

            int bytesRead = 0;
            while ((bytesRead = fc.read(buff)) != -1) {
                buff.flip();
                byte[] bytes = new byte[bytesRead];
                buff.get(bytes);
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
