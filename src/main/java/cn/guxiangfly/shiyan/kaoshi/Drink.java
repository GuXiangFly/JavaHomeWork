package cn.guxiangfly.shiyan.kaoshi;

/**
 * Drink
 *
 * @author guxiang
 * @date 2018/1/9
 */
public abstract class Drink {
    private int category;

    public abstract void drinkit();

    public static Drink getDrink(int category){
        if (category==1)
        return new Milk();

        if (category==2)
            return new Sprite();
        if (category==3)
            return new Water();

        throw new MyRuntimeException();
    }
}
