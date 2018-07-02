package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Павлуша on 24.04.2018.
 */
public class CachingProxyRetriever implements Retriever {
    OriginalRetriever retriever;
    LRUCache cache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = cache.find(id);
        if(obj != null) return obj;
        obj = retriever.retrieve(id);
        cache.set(id, obj);
        return obj;
    }
}
