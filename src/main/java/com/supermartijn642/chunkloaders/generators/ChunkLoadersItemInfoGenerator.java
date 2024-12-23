package com.supermartijn642.chunkloaders.generators;

import com.supermartijn642.chunkloaders.ChunkLoaderType;
import com.supermartijn642.core.generator.ItemInfoGenerator;
import com.supermartijn642.core.generator.ResourceCache;

/**
 * Created 23/12/2024 by SuperMartijn642
 */
public class ChunkLoadersItemInfoGenerator extends ItemInfoGenerator {

    public ChunkLoadersItemInfoGenerator(ResourceCache cache){
        super("chunkloaders", cache);
    }

    @Override
    public void generate(){
        for(ChunkLoaderType type : ChunkLoaderType.values())
            this.simpleInfo(type.getItem(), "item/" + type.getRegistryName());
    }
}
