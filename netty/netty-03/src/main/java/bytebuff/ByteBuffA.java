package bytebuff;

import io.netty.buffer.*;

import java.nio.charset.StandardCharsets;

public class ByteBuffA {

    public static void main(String[] args) {

        ByteBuf byteBuf = Unpooled.buffer();

        byteBuf.writeBytes("abcdefg".getBytes(StandardCharsets.UTF_8));

        byteBuf.writeShort(1);

        int readableLeng = byteBuf.readableBytes();

        String a = (String) byteBuf.getCharSequence(0, readableLeng, StandardCharsets.UTF_8);

        System.out.println(readableLeng);
        System.out.println(a);


        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes("##".getBytes(StandardCharsets.UTF_8));
        int readLen = buf.readableBytes();
        System.out.println(readLen);




    }

}
