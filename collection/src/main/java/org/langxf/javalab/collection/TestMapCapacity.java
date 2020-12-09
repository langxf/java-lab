package org.langxf.javalab.collection;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Langxf
 * 测试完成时间
 * 预热 2 轮，每次 1s
 * 测试 5 轮，每次 3s
 * fork 1 个线程
 * 每个测试线程一个实例
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class TestMapCapacity {

    static final int SIZE = 1024;
    public static void main(String[] args) throws RunnerException {
        // 启动基准测试 & 要导入的测试类
        Options opt = new OptionsBuilder()
                .include(TestMapCapacity.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void noSizeTest(Blackhole blackhole) {
        Map map = new HashMap(SIZE);
        for (int i = 0; i < SIZE; i++) {
            map.put(i, i);
        }
        // 为了避免 JIT 忽略未被使用的结果
        blackhole.consume(map);
    }

    @Benchmark
    public void setSizeTest(Blackhole blackhole) {
        Map map = new HashMap(1367);
        for (int i = 0; i < SIZE; i++) {
            map.put(i, i);
        }
        // 为了避免 JIT 忽略未被使用的结果
        blackhole.consume(map);
    }
}
