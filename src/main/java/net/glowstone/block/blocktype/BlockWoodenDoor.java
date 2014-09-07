package net.glowstone.block.blocktype;

import net.glowstone.block.GlowBlock;
import net.glowstone.block.GlowBlockState;
import net.glowstone.entity.GlowPlayer;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/*
 * Issues:
 *   - The top half of the door CANNOT be retrieved, currently. See deobfuscated Minecraft source for Chunk's equivalent
 *     to getBlock. It uses ExtendedBlockStorage. Ours just reads straight out of the array. If someone can look and see
 *     how to implement this, it would be great, because then I could finish doors.
 */

public class BlockWoodenDoor extends BlockType {

    @Override
    public boolean blockInteract(GlowPlayer player, GlowBlock block, BlockFace face, Vector clickedLoc) {
        System.out.println(block.getData());
        if (block.getType() == Material.WOODEN_DOOR) {
            byte data = block.getData();
            System.out.println(data);
            byte var11 = (byte) (data & 7);
            var11 ^= 4;

            if ((data & 8) == 0) { // bottom
                System.out.println("a");
                block.setData(var11);
            } else { // top
                System.out.println("b");
                block.setData(var11);
            }
            return true;
        } else {
            // todo: complain
            return false;
        }
    }

    @Override
    public void placeBlock(GlowPlayer player, GlowBlockState state, BlockFace face, ItemStack holding, Vector clickedLoc) {
        super.placeBlock(player, state, face, holding, clickedLoc);
    }
}
