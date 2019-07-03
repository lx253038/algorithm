package Enum;

/**
 * @author LX
 * @date 2019-7-3 18:07
 * ö����ʹ��
 */
public enum SixKing {
    ONE("1", "��"),
    TWO("2", "��"),
    THREE("3", "��"),
    FOUR("4", "��"),
    FIVE("5", "��"),
    SIX("6", "κ");

    private String id;
    private String name;

    SixKing(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SixKing findById(String id) {
        for (SixKing king : SixKing.values()) {
            if (king.getId().equals(id)) {
                return king;
            }
        }

        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
