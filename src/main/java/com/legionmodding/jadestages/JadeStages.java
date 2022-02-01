package com.legionmodding.jadestages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import mcp.mobius.waila.api.event.WailaRenderEvent;
import mcp.mobius.waila.api.event.WailaTooltipEvent;

import net.darkhax.bookshelf.util.PlayerUtils;
import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("jadestages")
public class JadeStages
{
    public static final Logger LOGGER = LogManager.getLogger();
    
    public static List<String> requiredStages = new ArrayList<>();
    public static Multimap<String, String> prefixes = HashMultimap.create();
    
    public JadeStages()
    {

    }

    @SubscribeEvent
    public void preTooltipRender (WailaRenderEvent.Pre event)
    {
        if (!requiredStages.isEmpty() && !GameStageHelper.hasAnyOf(PlayerUtils.getClientPlayer(), requiredStages))
        {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public void getTooltipText (WailaTooltipEvent event)
    {
        for (final String stage : prefixes.keySet())
        {
            if (!GameStageHelper.hasStage(PlayerUtils.getClientPlayer(), stage))
            {
                for (final Iterator<ITextComponent> iterator = event.getCurrentTip().iterator(); iterator.hasNext();)
                {
                    final ITextComponent line = iterator.next();
                    
                    for (final String regex : prefixes.get(stage))
                    {
                        if (line.getString().startsWith(regex))
                        {
                            iterator.remove();
                            break;
                        }
                    }
                }
            }
        }
    }
}