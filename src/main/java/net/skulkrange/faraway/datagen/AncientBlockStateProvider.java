package net.skulkrange.faraway.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skulkrange.faraway.FarawayMod;
import net.skulkrange.faraway.block.FarawayAncientBlocks;
import net.skulkrange.faraway.block.custom.AncientBerryBushBlock;

public class AncientBlockStateProvider extends BlockStateProvider {
    public AncientBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FarawayMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        grassBlockWithItem(FarawayAncientBlocks.ANCIENT_GRASS);
        blockWithItem(FarawayAncientBlocks.ANCIENT_DIRT);
        blockWithItem(FarawayAncientBlocks.ANCIENT_RESIN_ORE);
        blockWithItem(FarawayAncientBlocks.MARBLE);

        logBlock((RotatedPillarBlock) FarawayAncientBlocks.ATHENWOOD_LOG.get());
        axisBlock(((RotatedPillarBlock) FarawayAncientBlocks.ATHENWOOD.get()), blockTexture(FarawayAncientBlocks.ATHENWOOD_LOG.get()), blockTexture(FarawayAncientBlocks.ATHENWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) FarawayAncientBlocks.STRIPPED_ATHENWOOD_LOG.get()), blockTexture(FarawayAncientBlocks.STRIPPED_ATHENWOOD_LOG.get()), new ResourceLocation(FarawayMod.MOD_ID, "block/stripped_athenwood_log_top"));
        axisBlock(((RotatedPillarBlock) FarawayAncientBlocks.STRIPPED_ATHENWOOD.get()), blockTexture(FarawayAncientBlocks.STRIPPED_ATHENWOOD_LOG.get()), blockTexture(FarawayAncientBlocks.ATHENWOOD_LOG.get()));

        blockItem(FarawayAncientBlocks.ATHENWOOD_LOG);
        blockItem(FarawayAncientBlocks.ATHENWOOD);
        blockItem(FarawayAncientBlocks.STRIPPED_ATHENWOOD_LOG);
        blockItem(FarawayAncientBlocks.STRIPPED_ATHENWOOD);

        blockWithItem(FarawayAncientBlocks.ATHENWOOD_PLANKS);

        leavesBlock(FarawayAncientBlocks.ATHENWOOD_LEAVES);

        getVariantBuilder(FarawayAncientBlocks.ANCIENT_BERRY_BUSH.get())
                .forAllStates(state -> {
                    int age = state.getValue(AncientBerryBushBlock.AGE);
                    String modelName =  modLoc("block/ancient_berry_bush_stage" + age).toString();
                    if(age == 0) {
                        modelName =  modLoc("block/ancient_berry_bush_stage0").toString();
                    }
                    //System.out.println("age variant: " + age + " " + modelName);
                    return ConfiguredModel.builder().modelFile(models().getBuilder(modelName)).build();
                });

    }

    private void blockItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(FarawayMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void grassBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        Block block = blockRegistryObject.get();
        ResourceLocation sideTexture = modLoc("block/ancient_grass_block_side");
        ResourceLocation topTexture = modLoc("block/ancient_grass_block_top");
        ResourceLocation bottomTexture = modLoc("block/ancient_dirt"); // Assuming you have an ancient_dirt texture

        ModelFile blockModel = models().cube("ancient_grass_block",
                bottomTexture, // down
                topTexture,    // up
                sideTexture,   // north
                sideTexture,   // south
                sideTexture,   // west
                sideTexture    // east
        );
        simpleBlockWithItem(block, blockModel);


    }


}
