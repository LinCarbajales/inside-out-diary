package dev.lin.models;

import dev.lin.views.MomentPostView;
import dev.lin.views.RecoverListView;
import dev.lin.views.DeleteMomentView;
import dev.lin.views.FilterMomentsView;

public enum HomeOptionEnum {
    ADD(1, MomentPostView::printStoreMenu),
    VIEW(2, RecoverListView::printRecover),
    DELETE(3, DeleteMomentView::printDeleteMoment),
    FILTER(4, FilterMomentsView::printFilterMenu),
    EXIT(5, () -> System.out.println("¡Hasta la próxima!"));

    private final int value;
    private final Runnable action;

    HomeOptionEnum(int value, Runnable action) {
        this.value = value;
        this.action = action;
    }

    public static boolean execute(int option) {
        for (HomeOptionEnum mo : values()) {
            if (mo.value == option) {
                mo.action.run();
                return true;
            }
        }
        return false;
    }
}