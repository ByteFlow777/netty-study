package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestByteBufferRead {
    @Test
    public void testByteBufferRead() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();

        byte[] bytes = new byte[4];
        // 读取前四个字节到 bytes 中
        buffer.get(bytes);
        System.out.println(Arrays.toString(bytes));

        // 从头开始读
        buffer.rewind();
        System.out.println((char) buffer.get());

        buffer.rewind();

        // mark 做一个标记，记录 position 位置
        // reset 将 position 重置到 mark 位置
        System.out.println((char) buffer.get()); // a
        System.out.println((char) buffer.get()); // b
        buffer.mark();

        System.out.println((char) buffer.get()); // c
        System.out.println((char) buffer.get()); // d
        buffer.reset();

        System.out.println((char) buffer.get()); // c
        System.out.println((char) buffer.get()); // d
    }
}
