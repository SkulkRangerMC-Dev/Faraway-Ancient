package net.skulkrange.faraway.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.item.AncientFoods;
import net.skulkrange.faraway.item.FarawayAncientArtifacts;
import net.skulkrange.faraway.item.FarawayAncientItems;

public class ArtifactModelProvider extends ItemModelProvider {
    public ArtifactModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FarawayMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(FarawayAncientArtifacts.SHOVEL_HEAD);
        simpleItem(FarawayAncientArtifacts.TEMPLE_SUNRISE_DISC);
        simpleItem(FarawayAncientArtifacts.HELIOS_DISC);
        simpleItem(FarawayAncientArtifacts.KNOWLEDGE_STONE);

        simpleItem(FarawayAncientItems.ANCIENT_SHOVEL);
        simpleItem(FarawayAncientItems.RESIN);
        simpleItem(FarawayAncientItems.ANCIENT_BERRIES);
        simpleItem(FarawayAncientItems.GYRO_PITA);




    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarawayMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
