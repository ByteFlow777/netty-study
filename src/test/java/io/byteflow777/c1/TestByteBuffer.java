package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    @Test
    public void testByteBuffer() {
        // FileChannel
        // 1. 输入输入流 2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(16);
            while (true) {
                // 从 Channel 读数据，向 buffer 写入
                int read = channel.read(buffer);
                // 没有内容了
                if (read == -1) break;
                // 从 buffer 取数据，并打印
                buffer.flip(); // 切换至读模式
                while (buffer.hasRemaining()) { // 是否仍有剩余未读数据
                    byte b = buffer.get(); // 获取内容
                    System.out.println((char) b);
                }
                // 切换至写模式
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}