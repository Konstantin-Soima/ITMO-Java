package ru.itmo.lesson.patterns.decorator;

import java.time.LocalDateTime;

public class DecoratorPattern {
    public static void main(String[] args) {

        ILogger logger = new Logger();
        logger.write("info");

        ILogger dateLogger = new DateTimeDecorator(logger);
        dateLogger.write("info");
        ILogger code = new IntegerDecorator(new DateTimeDecorator(logger));
        code.write("info");
    }
}

interface ILogger{//общий интерфейс
    void write(String data);
}
//основной функционал
class Logger implements ILogger{
    @Override
    public void write(String data) {
        System.out.println(data
        );
    }
}
//базовый декоратор
class LoggerDecorator implements ILogger{
    private  ILogger logger;

    public LoggerDecorator(ILogger logger) {

        this.logger = logger;
    }

    @Override
    public void write(String data) {
        logger.write(data);
    }
}

//декораторы наследуются от базового декоратора
class DateTimeDecorator extends LoggerDecorator{

    public DateTimeDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData = data + " date: "+ LocalDateTime.now();
        super.write(newData);
    }
}

class IntegerDecorator extends LoggerDecorator{
    public IntegerDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData = data + " code: " + Math.random();
        super.write(newData);
    }
}