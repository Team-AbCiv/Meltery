package meltery.compat.jei;

import mcjty.lib.jei.CompatRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

public class SmeltingRecipeHandler extends CompatRecipeHandler<MeltingRecipe> {

    public SmeltingRecipeHandler() {
        super(JEI.MELTING_UID);
    }

    @Override
    public Class<MeltingRecipe> getRecipeClass() {
        return MeltingRecipe.class;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(MeltingRecipe recipe) {
        return new SmeltingRecipeWrapper(recipe);
    }
}
