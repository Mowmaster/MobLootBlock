package com.mowmaster.moblootblock.Items;

import com.mowmaster.moblootblock.moblootblock;
import com.mowmaster.mowlib.MowLibUtils.MowLibCompoundTagUtils;
import com.mowmaster.mowlib.MowLibUtils.MowLibTooltipUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MobLootItem extends Item
{
    public MobLootItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        MutableComponent component = Component.translatable(moblootblock.MODID + ".moblootitem.tooltip");
        MutableComponent mob = EntityType.byString(MowLibCompoundTagUtils.readStringFromNBT(moblootblock.MODID,p_41421_.getOrCreateTag(),"_moblootitem")).get().getDescription().copy();
        component.append(mob);
        MowLibTooltipUtils.addTooltipMessage(p_41423_,p_41421_,component);
    }
}
