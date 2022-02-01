package com.legionmodding.jadestages.compat.crt;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.WailaStages")
public class WailaStagesCrT
{
    @ZenCodeType.Method
    public static void addWailaStage (String stage) {
        
        CraftTweakerAPI.apply(new ActionAddRequiredStage(stage));
    }

    @ZenCodeType.Method
    public static void addRequirement (String stage, String prefix) {
        
        CraftTweakerAPI.apply(new ActionAddRestriction(stage, prefix));
    }
}
