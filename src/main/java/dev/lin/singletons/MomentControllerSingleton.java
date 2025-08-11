package dev.lin.singletons;

import dev.lin.controllers.MomentController;

public class MomentControllerSingleton {
    
    private static final MomentController INSTANCE = new MomentController();

    private MomentControllerSingleton() {}
    
    public static MomentController getInstance() {
        return INSTANCE;
    }
}
