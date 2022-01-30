package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatteringReads {
    @Test
    public void testScatteringReads() {
        try (FileChannel channel = new RandomAccessFile("ScatteringReads.txt", "r").getChannel();) {
            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(5);

            // 分开读取到对应长度 ByteBuffer 中
            channel.read(new ByteBuffer[]{b1, b2, b3});

            b1.flip();
            b2.flip();
            b3.flip();

            System.out.println(b1); // one
            System.out.println(b2); // two
            System.out.println(b3); // three
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
