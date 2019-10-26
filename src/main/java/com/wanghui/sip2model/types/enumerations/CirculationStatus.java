package com.wanghui.sip2model.types.enumerations;

/**
 * @auther wanghui
 * @create 2018-11-13 0:36
 * @Description 图书流通状态枚举
 */
public enum CirculationStatus implements AbstractEnumeration {
    OTHER("01"),
    ON_ORDER("02"),
    AVAILABLE("03"),
    CHARGED("04"),
    CHARGED_UNTIL_RECALL_DATE("05"),
    IN_PROCESS("06"),
    RECALLED("07"),
    ON_HOLD_SHELF("08"),
    AWAITING_RESHELVING("09"),
    IN_TRANSIT("10"),
    CLAIMED_RETURN("11"),
    LOST("12"),
    MISSING("13");

    private final String code;

    private CirculationStatus(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getCode();
    }

    @Override
    public final String getCode() {
        return this.code;
    }

    @Override
    public final AbstractEnumeration getKey(String code) {
        for (AbstractEnumeration i : CirculationStatus.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
