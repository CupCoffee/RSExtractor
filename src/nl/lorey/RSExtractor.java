package nl.lorey;

import net.openrs.cache.Cache;
import net.openrs.cache.FileStore;
import java.io.IOException;

public class RSExtractor {
    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.exit(0);
        }

        String cachePath = args[0];

        new RSExtractor(cachePath);
    }

    public RSExtractor(String cachePath)
    {
        try {
            Cache cache = this.readCache(cachePath);
            System.out.println(cache.getTypeCount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cache readCache(String path) throws IOException {
        return new Cache(FileStore.open(path));
    }
}
