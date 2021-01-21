package com.miaolegemitong.basics.java.cache;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mitong
 * @date 2019-03-13
 * @email mitong@meituan.com
 * @desc
 */
public class LRULocalCache {
    private static final int DEFAULT_MAX_CAPACITY = 1 << 30;

    private final LRUMap<String, Object> map;

    private ScheduledExecutorService executor;

    public LRULocalCache() {
        this(DEFAULT_MAX_CAPACITY);
    }

    public LRULocalCache(int maxCapacity) {
        map = new LRUMap<>(maxCapacity);
        executor = new ScheduledThreadPoolExecutor(5, new LRUThreadFactory());
    }

    /**
     * 清除缓存任务类
     */
    static class CleanWorkerTask implements Runnable {
        private LRULocalCache localCache;

        private String key;

        public CleanWorkerTask(LRULocalCache localCache, String key) {
            this.localCache = localCache;
            this.key = key;
        }

        @Override
        public void run() {
            this.localCache.remove(key);
        }
    }

    /**
     * 增加缓存
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        map.put(key, value);
    }

    /**
     * 增加缓存
     *
     * @param key
     * @param value
     * @param timeout 有效时长, 单位毫秒
     */
    public void put(String key, Object value, int timeout) {
        map.put(key, value);
        executor.schedule(new CleanWorkerTask(this, key), timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * 增加缓存
     *
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void put(String key, Object value, Date expireTime) {
        map.put(key, value);
        executor.schedule(new CleanWorkerTask(this, key), expireTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }


    /**
     * 批量增加缓存
     *
     * @param m
     */
    public void putAll(Map<String, Object> m) {
        map.putAll(m);
    }

    /**
     * 批量增加缓存
     *
     * @param m
     */
    public void putAll(Map<String, Object> m, int timeout) {
        map.putAll(m);
        for (String key : m.keySet()) {
            executor.schedule(new CleanWorkerTask(this, key), timeout, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 批量增加缓存
     *
     * @param m
     */
    public void putAll(Map<String, Object> m, Date expireTime) {
        map.putAll(m);
        for (String key : m.keySet()) {
            executor.schedule(new CleanWorkerTask(this, key), expireTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return map.get(key);
    }

    /**
     * 查询缓存是否包含key
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public void remove(String key) {
        map.remove(key);
    }

    /**
     * 返回缓存大小
     *
     * @return
     */
    public int size() {
        return map.size();
    }

    /**
     * 清除所有缓存
     *
     * @return
     */
    public void clear() {
        if (size() > 0) {
            map.clear();
        }
    }

    static class LRUThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        LRUThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "lru-cache-pool-" +
                    POOL_NUMBER.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    static class LRUMap<K, V> extends LinkedHashMap<K, V> {
        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        private final Lock rLock = readWriteLock.readLock();

        private final Lock wLock = readWriteLock.writeLock();

        /**
         * 默认缓存容量
         */
        private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

        /**
         * 加载因子
         */
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private int maxCapacity;

        public LRUMap(int maxCapacity) {
            // must set accessOrder true
            super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
            this.maxCapacity = maxCapacity;
        }

        public LRUMap(int maxCapacity, int initialCapacity) {
            // must set accessOrder true
            super(initialCapacity, DEFAULT_LOAD_FACTOR, true);
            this.maxCapacity = maxCapacity;
        }

        @Override
        public V get(Object k) {
            rLock.lock();
            try {
                return super.get(k);
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public V put(K k, V v) {
            wLock.lock();
            try {
                return super.put(k, v);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            wLock.lock();
            try {
                super.putAll(m);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public V remove(Object k) {
            wLock.lock();
            try {
                return super.remove(k);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public boolean containsKey(Object k) {
            rLock.lock();
            try {
                return super.containsKey(k);
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public int size() {
            rLock.lock();
            try {
                return super.size();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public void clear() {
            wLock.lock();
            try {
                super.clear();
            } finally {
                wLock.unlock();
            }
        }

        /**
         * 重写LinkedHashMap中removeEldestEntry方法;
         * 新增元素的时候,会判断当前map大小是否超过DEFAULT_MAX_CAPACITY,超过则移除map中最老的节点;
         *
         * @param eldest
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > this.maxCapacity;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LRULocalCache localCache = new LRULocalCache(10);
        localCache.put("1", "1");
        localCache.put("2", "2");
        localCache.put("3", "3");
        localCache.put("4", "4");
        localCache.put("5", "5");
        localCache.put("6", "6", 1);
        localCache.put("7", "7");
        localCache.put("8", "8");
        localCache.put("9", "9");
        localCache.put("10", "10");
        localCache.get("1");
        localCache.put("11", "11");
        System.out.println();
    }
}
