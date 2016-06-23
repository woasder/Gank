package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class gankgenerator {
    public static void main(String[] args) throws Exception{
        Schema schema = new Schema(1,"com.yyw.abc.ganhuo");
        addBean(schema);
        addType(schema);
        new DaoGenerator().generateAll(schema,"../Ganhuo/app/src/main/java-gen");
    }
    public static void addBean(Schema schema){
        Entity entity = schema.addEntity("Gank");
        entity.addIdProperty().autoincrement();
        entity.addStringProperty("sid").notNull();
        entity.addStringProperty("url");
        entity.addStringProperty("who");
        entity.addStringProperty("type");
        entity.addStringProperty("publishedAt");
        entity.addStringProperty("desc");

    }

    public static void addType(Schema schema){
        Entity entity = schema.addEntity("Type");
        entity.addIdProperty().autoincrement();
        entity.addIntProperty("sid").notNull();
        entity.addStringProperty("type").notNull();
        entity.addBooleanProperty("isChecked").notNull();
    }
}
