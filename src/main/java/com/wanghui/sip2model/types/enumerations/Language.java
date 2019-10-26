package com.wanghui.sip2model.types.enumerations;

/**
 * @auther wanghui
 * @create 2018-11-13 0:36
 * @Description
 */
public enum Language implements AbstractEnumeration {
    UNKNOWN("000"),
    ENGLISH("001"),
    FRENCH("002"),
    GERMAN("003"),
    ITALIAN("004"),
    DUTCH("005"),
    SWEDISH("006"),
    FINNISH("007"),
    SPANISH("008"),
    DANISH("009"),
    PORTUGUESE("010"),
    CANADIAN_FRENCH("011"),
    NORWEGIAN("012"),
    HEBREW("013"),
    JAPANESE("014"),
    RUSSIAN("015"),
    ARABIC("016"),
    POLISH("017"),
    GREEK("018"),
    CHINESE("019"),
    KOREAN("020"),
    NORTH_AMERICAN_SPANISH("021"),
    TAMIL("022"),
    MALAY("023"),
    UNITED_KINGDOM("024"),
    ICELANDIC("025"),
    BELGIAN("026"),
    TAIWANESE("027");

    private final String code;

    private Language(String code) {
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
        for (AbstractEnumeration i : Language.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
