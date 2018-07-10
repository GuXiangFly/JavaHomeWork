package cn.guxiangfly.netty.common.module.fuben.response;

import cn.guxiangfly.netty.common.serial.Serializer;

/**
 * FightResponse
 *
 * @author guxiang
 * @date 2018/1/24
 */
public class FightResponse extends Serializer {

    /**
     * 获取金币
     */
    private int gold;



    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    protected void read() {
        this.gold = readInt();
    }

    @Override
    protected void write() {
        writeInt(gold);
    }
}
