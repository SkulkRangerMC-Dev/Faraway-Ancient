package net.skulkrange.faraway.datagen;

import com.ibm.icu.impl.ICUService;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skulkrange.faraway.FarawayMod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = FarawayMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new AncientRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), AncientLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new AncientBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ArtifactModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new FarawayWorldGenProvider(packOutput, lookupProvider));

        AncientBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new AncientBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ArtifactTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}