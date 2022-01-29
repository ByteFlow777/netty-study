package io.byteflow777.c1;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    @Test
    public void testTestByteBufferAllocate() {
        // class java.nio.HeapByteBuffer
        // Java 堆内存，读写效率较低，受到 GC 影响
        ByteBuffer heapBuffer = ByteBuffer.allocate(16);
        System.out.println(heapBuffer.getClass());

        // class java.nio.DirectByteBuffer
        // 直接内存，读写效率高（少一次拷贝），不会受到 GC 影响。分配效率较低
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(16);
        System.out.println(directBuffer.getClass());
    }
}
