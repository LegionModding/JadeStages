package com.legionmodding.jadestages.compat.crt;

import com.blamejared.crafttweaker.api.actions.IAction;
import com.legionmodding.jadestages.WailaStages;



public class ActionAddRequiredStage implements IAction {
    
    private final String stage;
    
    public ActionAddRequiredStage(String stage) {
        
        this.stage = stage;
    }
    
    @Override
    public void apply () {
        
        WailaStages.requiredStages.add(this.stage);
    }
    
    @Override
    public String describe () {
        
        return String.format("Added possible waila stage requirement %s", this.stage);
    }
}