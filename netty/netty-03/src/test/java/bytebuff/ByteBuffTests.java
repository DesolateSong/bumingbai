package bytebuff;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ByteBuffTests {

    @Test
    public void test1() {

        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() - 2000;
        int mon = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int mi = now.getMinute();
        int sec = now.getSecond();

        ByteBuf buf = Unpooled.buffer();

        buf.writeBytes(new byte[]{
                (byte) year
                , (byte) mon
                , (byte) day
                , (byte) hour
                , (byte) mi
                , (byte) sec
        });

//        byte[] bytes = new byte[6];
//        buf.readBytes(bytes);

        System.out.println(LocalDateTime.of(
                ((int) buf.readByte()) + 2000
                , (int) buf.readByte()
                , (int) buf.readByte()
                , (int) buf.readByte()
                , (int) buf.readByte()
                , (int) buf.readByte()
        ));
    }

    @Test
    public void test2() {
        String in = "23230901322D313233343536373801004F0100408FD2FB6B4FDD6795090BF4BA70DA92A8029997797BB9FEA3CDFE1F72EE2DE17A828C23C4D1B86051A6A1361213320ADE1CBB1E7C5A94D7B57FD92399403DF652160B0C0E0B3717020C0E0B374E";

        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(HexUtil.hexString2Bytes(in));

        String a = new String(new byte[]{buf.readByte(), buf.readByte()});
        System.out.println(a);
        System.out.println((int) buf.readByte());
        ;

    }

    @Test
    public void test3() {
        String hexString = HexUtil.bytes2HexString(new byte[]{0x01, 0x02});
        System.out.println(hexString);

        byte[] bytes = HexUtil.hexString2Bytes(hexString);
        System.out.println(bytes[0] + "" + bytes[1]);

    }

    public interface DataType<T extends Serializable> {
        void setValue(T value);

        T getValue(ByteBuf byteBuf);
    }

    static abstract class AbstractDataType<T extends  Serializable> implements DataType<T>{
        protected T value;
    }

    static class BytE extends AbstractDataType<Byte>{

        @Override
        public void setValue(Byte value) {

        }

        @Override
        public Byte getValue(ByteBuf byteBuf) {
            return null;
        }
    }

    static class VersionType extends AbstractDataType<Version>{

        @Override
        public void setValue(Version value) {

        }

        @Override
        public Version getValue(ByteBuf byteBuf) {
            return null;
        }
    }

    enum Version {
        V_2011,
        V_2016,
        V_2019;
    }
}
