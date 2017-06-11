package meltery;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author glease
 * @since 1.0
 */
public class Ported {
	public static boolean isEmpty(ItemStack stack) {
		return stack == null ||
				       !(stack.getItem() != Item.getItemFromBlock(Blocks.AIR)) ||
				       (stack.stackSize <= 0 || (stack.getItemDamage() < -32768 || stack.getItemDamage() > 65535));
	}
}
