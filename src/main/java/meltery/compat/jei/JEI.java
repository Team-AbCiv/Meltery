package meltery.compat.jei;

import meltery.Meltery;
import meltery.common.MelteryHandler;
import meltery.common.MelteryRecipe;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

/**
 * Created by tyler on 6/1/17.
 */
@JEIPlugin
public class JEI extends BlankModPlugin {
	public static final String MELTING_UID = "melting";
	private static IGuiHelper helper;

	@Override
	public void register(IModRegistry registry) {
		if (helper == null)
			helper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(new SmeltingRecipeCategory(helper));
		registry.addRecipeHandlers(new IRecipeHandler() {
			@Override
			public Class getRecipeClass() {
				return MelteryRecipe.class;
			}

			@Override
			public String getRecipeCategoryUid() {
				return MELTING_UID;
			}

			@Override
			public String getRecipeCategoryUid(Object recipe) {
				return MELTING_UID ;
			}

			@Override
			public IRecipeWrapper getRecipeWrapper(Object recipe) {
				return new SmeltingRecipeWrapper((MeltingRecipe) recipe);
			}

			@Override
			public boolean isRecipeValid(Object recipe) {
				return recipe instanceof  MelteryRecipe;
			}
		});
		registry.addRecipes(MelteryHandler.meltingRecipes);
		registry.addRecipeCategoryCraftingItem(new ItemStack(Meltery.MELTERY), MELTING_UID);
	}
}
