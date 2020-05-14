package ru.itmo.lesson.lesson17;

import java.util.Properties;

public class PropertiesLoader {
    private static PropertiesLoader propertiesLoader;
    private String propFileName;
    public  static PropertiesLoader getPropertiesLoader(String propFileName){
        if (propertiesLoader == null) {//не подходит для многопоточных приложений
            propertiesLoader = new PropertiesLoader(propFileName);
        }
            return propertiesLoader;

    }
    private Properties properties;
    //Возможно создание обьекта только внутри класса
    private PropertiesLoader(String propFileName){
        this.properties = new Properties();
        this.propFileName = propFileName;
        loadProperties();
    }

    public Properties getProperties(){
        return properties;
    }

    private void loadProperties(){
        //загрузка данных из файла
    }
}
