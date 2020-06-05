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
 * Created by Langxf on 2020/6/5.
 */
@BenchmarkMode(Mode.AverageTime) // 测试完成时间
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS) // 预热 2 轮，每次 1s
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS) // 测试 5 轮，每次 3s
@Fork(1) // fork 1 个线程
@State(Scope.Thread) // 每个测试线程一个实例
public class TestMapCapacity {

    static final int size = 1024;
    public static void main(String[] args) throws RunnerException {
        // 启动基准测试
        Options opt = new OptionsBuilder()
                .include(TestMapCapacity.class.getSimpleName()) // 要导入的测试类
                .build();
        new Runner(opt).run(); // 执行测试
    }

    @Benchmark
    public void noSizeTest(Blackhole blackhole) {
        Map map = new HashMap();
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        // 为了避免 JIT 忽略未被使用的结果
        blackhole.consume(map);
    }

    @Benchmark
    public void setSizeTest(Blackhole blackhole) {
        Map map = new HashMap(1367);
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        // 为了避免 JIT 忽略未被使用的结果
        blackhole.consume(map);
    }
}
