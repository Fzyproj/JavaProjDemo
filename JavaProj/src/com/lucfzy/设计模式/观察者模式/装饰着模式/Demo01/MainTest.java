package com.lucfzy.设计模式.观察者模式.装饰着模式.Demo01;


/**
 * 【例1】用装饰模式实现游戏角色“莫莉卡·安斯兰”的变身。
 *
 * 分析：在《恶魔战士》中，游戏角色“莫莉卡·安斯兰”的原身是一个可爱少女，但当她变身时，
 * 会变成头顶及背部延伸出蝙蝠状飞翼的女妖，当然她还可以变为穿着漂亮外衣的少女。
 * 这些都可用装饰模式来实现，在本实例中的“莫莉卡”原身有 setImage(String t) 方法决定其显示方式，
 * 而其 变身“蝙蝠状女妖”和“着装少女”可以用 setChanger() 方法来改变其外观，原身与变身后的效果用 display() 方法来显示
 */
public class MainTest {
    public static void main(String[] args) {
        Girl molika = new MolikaGirl("茉莉卡");
        molika.setImage("dd");
        Decorator molikaDecorator = new GirlDecorator(molika);
        molikaDecorator.setChanger(true);
        molikaDecorator.setChanger(false);
    }
}

abstract class Girl {
    protected String name;

    // 用来展示角色的外观
    protected abstract void setImage(String t);
}

class MolikaGirl extends Girl{

    public MolikaGirl(String name) {
        super.name = name;
    }

    @Override
    protected void setImage(String t) {
        System.out.println("我是"+t);
    }

}

interface Decorator{
    public void setChanger(boolean flag);
}

// 茉莉卡的实际装饰器
class GirlDecorator implements Decorator {
    private final Girl girl;
    public GirlDecorator(Girl girl) {
        this.girl = girl;
    }
    @Override
    public void setChanger(boolean flag) {
        if (flag) {
            girl.setImage("蝙蝠状女妖");
            return;
        }
        girl.setImage("着装少女");
    }

}