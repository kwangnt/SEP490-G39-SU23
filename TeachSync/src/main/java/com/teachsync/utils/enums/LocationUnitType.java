package com.teachsync.utils.enums;

public enum LocationUnitType {
    /** Level 0 */
    COUNTRY("COUNTRY", "country", "Quốc gia"),


    /** Level 1 */
    PROVINCE("PROVINCE", "Province", "Tỉnh"),
    /** Level 1 */
    MUNICIPALITY("MUNICIPALITY", "Municipality", "Thành phố trực thuộc trung ương"),


    /** Level 2 */
    PROVINCIAL_CITY("PROVINCIAL_CITY", "Provincial city", "Thành phố thuộc tỉnh"),
    /** Level 2 */
    TOWN("TOWN", "Town", "Thị xã"),
    /** Level 2 */
    RURAL_DISTRICT("RURAL_DISTRICT", "Rural district", "Huyện"),
    /** Level 2 */
    DISTRICT("DISTRICT", "District", "Quận"),


    /** Level 3 */
    TOWNSHIP("TOWNSHIP", "Township", "thị trấn"),
    /** Level 3 */
    COMMUNE("COMMUNE", "Commune", "Xã"),
    /** Level 3 */
    WARD("WARD", "Ward", "Phường");

    private final String stringValue;
    private final String stringValueEng;
    private final String stringValueVie;

    LocationUnitType(String stringValue, String stringValueEng, String stringValueVie) {
        this.stringValue = stringValue;
        this.stringValueEng = stringValueEng;
        this.stringValueVie = stringValueVie;
    }

    public String getStringValue() {
        return stringValue;
    }
    public String getStringValueEng() {
        return stringValueEng;
    }
    public String getStringValueVie() {
        return stringValueVie;
    }
}
