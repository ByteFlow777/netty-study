package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class TestGatheringWrites {
    @Test
    public void testGatheringWrites() {
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello"); // 5个字节
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("world"); // 5个字节
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好");   // 6个字节

        try (FileChannel channel = new RandomAccessFile("GatheringWrites.txt", "rw").getChannel();) {
            channel.write(new ByteBuffer[]{b1, b2, b3});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
