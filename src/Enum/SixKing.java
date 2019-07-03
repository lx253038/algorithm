package Enum;

/**
 * @author LX
 * @date 2019-7-3 18:07
 * 枚举类使用
 */
public enum SixKing {
    ONE("1", "齐"),
    TWO("2", "楚"),
    THREE("3", "燕"),
    FOUR("4", "赵"),
    FIVE("5", "韩"),
    SIX("6", "魏");

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
