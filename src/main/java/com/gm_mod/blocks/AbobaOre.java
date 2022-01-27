package com.gm_mod.blocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.NoteBlockEvent;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.minecraft.block.AbstractFireBlock.getState;

public class AbobaOre extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
    public static final BooleanProperty EAST = SixWayBlock.EAST;
    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
    public static final BooleanProperty WEST = SixWayBlock.WEST;
    public static final BooleanProperty UP = SixWayBlock.UP;

    private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape DOWN_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private final Map<BlockState, VoxelShape> shapesCache;

    public AbobaOre(AbstractBlock.Properties p1_) {
        super(p1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)).setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)).setValue(UP, Boolean.valueOf(false)));
        this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().filter((p0) -> {
            return p0.getValue(AGE) == 0;
        }).collect(Collectors.toMap(Function.identity(), AbobaOre::calculateShape)));
    }

    private static VoxelShape calculateShape(BlockState p0) {
        VoxelShape voxelshape = VoxelShapes.empty();
        if (p0.getValue(UP)) {
            voxelshape = UP_AABB;
        }

        if (p0.getValue(NORTH)) {
            voxelshape = VoxelShapes.or(voxelshape, NORTH_AABB);
        }

        if (p0.getValue(SOUTH)) {
            voxelshape = VoxelShapes.or(voxelshape, SOUTH_AABB);
        }

        if (p0.getValue(EAST)) {
            voxelshape = VoxelShapes.or(voxelshape, EAST_AABB);
        }

        if (p0.getValue(WEST)) {
            voxelshape = VoxelShapes.or(voxelshape, WEST_AABB);
        }

        return voxelshape.isEmpty() ? DOWN_AABB : voxelshape;
    }
    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public BlockState updateShape(BlockState p1_1, Direction p1_2, BlockState p1_3, IWorld p1_4, BlockPos p1_5, BlockPos p1_6) {
        return this.getStateWithAge(p1_4, p1_5, p1_1.getValue(AGE));
    }
    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public VoxelShape getShape(BlockState p2_1, IBlockReader p2_2, BlockPos p3_3, ISelectionContext p4_4) {
        return this.shapesCache.get(p2_1.setValue(AGE, Integer.valueOf(0)));
    }

    private BlockState getStateWithAge(IWorld p3_1, BlockPos p3_2, int p3_3) {
        BlockState blockstate = getState(p3_1, p3_2);
        return blockstate.setValue(AGE, Integer.valueOf(p3_3));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AGE, NORTH, EAST, SOUTH, WEST, UP);
    }
    /*
    static final Property[] IntegerProperty() {
        return new Property[] {
                IntegerProperty.create("aboba_ore_0", 0, 0),
                IntegerProperty.create("aboba_ore_1", 1, 1)
        };
    }

    private BlockState getStateWithAge(IWorld p_235494_1_, BlockPos p_235494_2_, int p_235494_3_) {
        BlockState blockstate = getState(p_235494_1_, p_235494_2_);
        return blockstate.is(Blocks.DIAMOND_ORE) ? blockstate.setValue(AGE, Integer.valueOf(p_235494_3_)) : blockstate;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        //super.createBlockStateDefinition(builder);
    }
    */
}
