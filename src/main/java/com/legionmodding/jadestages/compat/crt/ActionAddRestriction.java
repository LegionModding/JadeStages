package com.legionmodding.jadestages.compat.crt;

import com.legionmodding.jadestages.WailaStages;

import com.blamejared.crafttweaker.api.actions.IAction;

public class ActionAddRestriction implements IAction {
    
    private final String stage;
    private final String prefix;
    
    public ActionAddRestriction(String stage, String prefix) {
        
        this.stage = stage;
        this.prefix = prefix;
    }
    
    @Override
    public void apply () {
        
        WailaStages.prefixes.put(this.stage, this.prefix);
    }
    
    @Override
    public String describe () {
        
        return String.format("Added restriction %s to stage %s", this.prefix, this.stage);
    }
}